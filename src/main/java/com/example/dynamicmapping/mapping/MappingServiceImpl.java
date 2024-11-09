package com.example.dynamicmapping.mapping;

import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Service
public class MappingServiceImpl implements MappingService {

    private static final String MAPPING_ADDRESS = "mappings.json";

    private final Map<String, Map<String, String>> fieldMappings = new HashMap<>();


    public MappingServiceImpl() throws IOException {
        loadMappings();
    }

    private void loadMappings() throws IOException {
        JsonNode mappingsNode = JsonUtil.readJsonFromClasspath(MAPPING_ADDRESS);
        mappingsNode.fieldNames().forEachRemaining(systemName -> {
            JsonNode systemNode = mappingsNode.get(systemName);
            Map<String, String> systemFields = new HashMap<>();
            systemNode.fieldNames().forEachRemaining(field ->
                systemFields.put(field, systemNode.get(field).asText())
            );
            fieldMappings.put(systemName, systemFields);
        });
    }

    @Cacheable(value = "fieldMappingsCache", key = "#systemName")
    public Map<String, String> getFieldMapping(String systemName) {
        return fieldMappings.get(systemName);
    }
}
