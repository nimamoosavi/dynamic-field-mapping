package com.example.dynamicmapping.mapping.util;

import com.example.dynamicmapping.mapping.JsonUtil;
import com.fasterxml.jackson.databind.JsonNode;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class JsonUtilTest {

    @Test
    void testReadJsonFromClasspath_GivenFile_WhenReadTheFile_ThenMustNotnull() throws IOException {
        //Arrange
        String path = "mappings.json";
        // Action
        JsonNode jsonNode = JsonUtil.readJsonFromClasspath(path);

        // Assertion
        assertNotNull(jsonNode);
    }

    @Test
    void testReadJsonFromClasspath_GivenFileExists_WhenReadTheFile_ThenCheckFieldNameKey() throws IOException {
        //Arrange

        String path = "mappings.json";
        // Action
        JsonNode jsonNode = JsonUtil.readJsonFromClasspath(path);

        // Assertion
        assertTrue(jsonNode.has("SystemA"));
    }


    @Test
    void testReadJsonFromClasspath_FileNotFound() {
        assertThrows(IOException.class, () -> JsonUtil.readJsonFromClasspath("non_existent_file.json"));
    }

    @Test
     void testReadJsonFromClasspath_InvalidJson() {
        assertThrows(IOException.class, () -> JsonUtil.readJsonFromClasspath("invalid.json"));
    }
}
