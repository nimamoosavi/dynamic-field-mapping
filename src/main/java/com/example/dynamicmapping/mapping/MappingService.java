package com.example.dynamicmapping.mapping;

import java.util.Map;

public interface MappingService {

    /**
     * Retrieves a map of field names for a given system.
     * The map contains the field names from the specified system and their corresponding
     * standard names.
     *
     * @param systemName The name of the system for which the field mappings are to be retrieved.
     *                   This name should correspond to a specific system in your environment.
     * @return A map where the key is the field name from the system and the value is the corresponding
     *         standard field name. If no mapping is found for the given system, the map can be empty
     *         or {@code null}.
     * @throws IllegalArgumentException if the provided system name is invalid or not recognized.
     */
    Map<String, String> getFieldMapping(String systemName);
}
