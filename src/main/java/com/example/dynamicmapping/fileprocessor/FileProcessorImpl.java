package com.example.dynamicmapping.fileprocessor;

import com.example.dynamicmapping.mapping.JsonUtil;
import com.example.dynamicmapping.mapping.MappingService;
import lombok.RequiredArgsConstructor;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@RequiredArgsConstructor
public class FileProcessorImpl implements FileProcessor {

    private static final String ADDRESS_PREFIX = "address.";
    private static final String PAYLOAD_KEY = "payload";
    private static final String PROFILE_KEY = "Profile";
    private static final String ADDRESS_KEY = "address";

    private final MappingService mappingService;



    public String processFile(String systemName, String[] fileHeaders, String[] rowData) {
        Map<String, String> fieldMapping = mappingService.getFieldMapping(systemName);

        Map<String, Object> profileMap = new HashMap<>();
        Map<String, String> addressMap = new HashMap<>();

        for (int i = 0; i < fileHeaders.length; i++) {
            String header = fileHeaders[i];
            String mappedField = fieldMapping.get(header);

            if (Objects.nonNull(mappedField)) {
                addFieldToProfileOrAddress(profileMap, addressMap, mappedField, rowData[i]);
            }
        }

        if (!addressMap.isEmpty()) {
            profileMap.put(ADDRESS_KEY, addressMap);
        }

        return buildJsonOutput(profileMap);
    }


    private void addFieldToProfileOrAddress(Map<String, Object> profileMap, Map<String, String> addressMap, String mappedField, String value) {
        if (mappedField.startsWith(ADDRESS_PREFIX)) {
            String addressField = mappedField.substring(ADDRESS_PREFIX.length());
            addressMap.put(addressField, value);
        } else {
            profileMap.put(mappedField, value);
        }
    }

    private String buildJsonOutput(Map<String, Object> profileMap) {
        Map<String, Object> payloadMap = new HashMap<>();
        payloadMap.put(PROFILE_KEY, profileMap);
        Map<String, Object> result = Map.of(PAYLOAD_KEY, payloadMap);
        return JsonUtil.writeValueAsString(result);
    }
}
