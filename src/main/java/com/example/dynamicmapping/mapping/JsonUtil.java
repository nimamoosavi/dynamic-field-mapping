package com.example.dynamicmapping.mapping;

import com.example.dynamicmapping.persistence.exception.JsonNotParsedException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

import java.io.IOException;
import java.io.InputStream;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class JsonUtil {
    private static final ObjectMapper objectMapper = new ObjectMapper();

    /**
     * Reads a JSON file from the classpath and converts it to a JsonNode.
     *
     * @param fileName the name of the file to read (e.g., "mappings.json")
     * @return the parsed JsonNode
     * @throws IOException if there is an error reading or parsing the file
     */
    public static JsonNode readJsonFromClasspath(String fileName) throws IOException {
        try (InputStream inputStream = JsonUtil.class.getResourceAsStream("/" + fileName)) {
            if (inputStream == null) {
                throw new IOException("File not found in classpath: " + fileName);
            }
            return objectMapper.readTree(inputStream);
        }
    }


    public static String writeValueAsString(Object object){
        try {
            return objectMapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            throw new JsonNotParsedException("Failed to convert map to JSON", e);
        }
    }
}
