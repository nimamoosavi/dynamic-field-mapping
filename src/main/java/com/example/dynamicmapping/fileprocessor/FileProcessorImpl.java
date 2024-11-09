package com.example.dynamicmapping.fileprocessor;

import com.example.dynamicmapping.mapping.MappingService;
import lombok.RequiredArgsConstructor;

import java.util.Map;
import java.util.Objects;

@RequiredArgsConstructor
public class FileProcessorImpl implements FileProcessor {

    private final MappingService mappingService;

    public String processFile(String systemName, String[] fileHeaders, String[] rowData) {
        Map<String, String> fieldMapping = mappingService.getFieldMapping(systemName);

        StringBuilder jsonBuilder = new StringBuilder("{ \"payload\": { \"Profile\": {");

        for (int i = 0; i < fileHeaders.length; i++) {
            String header = fileHeaders[i];
            String mappedField = fieldMapping.get(header);
            if (Objects.nonNull(mappedField)) {
                jsonBuilder.append("\"")
                        .append(mappedField)
                        .append("\": \"")
                        .append(rowData[i])
                        .append("\", ");
            }
        }

        jsonBuilder.setLength(jsonBuilder.length() - 2);
        jsonBuilder.append("}}}");

        return jsonBuilder.toString();
    }
}
