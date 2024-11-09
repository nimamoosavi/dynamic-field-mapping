package com.example.dynamicmapping.mapping;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.TextNode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class MappingServiceImplTest {

    @Mock
    private JsonUtil jsonUtil;

    private MappingServiceImpl mappingService;

    @BeforeEach
    public void setUp() throws IOException {
        MockitoAnnotations.openMocks(this);
        mappingService = new MappingServiceImpl();
    }

    @Test
    @DisplayName("Check Field Mapping Not Null")
    void testLoadMappings_GetArrange_WhenCheck_FiledMappingMustNotNull(){
        // Arrange
        JsonNode mockMappings = mock(JsonNode.class);
        JsonNode mockSystemNode = mock(JsonNode.class);

        // Mock the behavior of the mock mappings node
        when(mockMappings.fieldNames()).thenReturn(List.of("SystemA", "SystemB").iterator());
        when(mockMappings.get("SystemA")).thenReturn(mockSystemNode);
        when(mockSystemNode.fieldNames()).thenReturn(List.of("FirstName", "LastName").iterator());
        when(mockSystemNode.get("FirstName")).thenReturn(new TextNode("firstname"));
        when(mockSystemNode.get("LastName")).thenReturn(new TextNode("lastname"));

        //Action
        Map<String, String> fieldMapping = mappingService.getFieldMapping("SystemA");

        //Assertion
        assertNotNull(fieldMapping);
    }


    @Test
    @DisplayName("Check First name equals to expected")
    void testLoadMappings_GetArrange_WhenCheck_ThenFirstNameMustBeEquals(){
        // Arrange
        JsonNode mockMappings = mock(JsonNode.class);
        JsonNode mockSystemNode = mock(JsonNode.class);

        // Mock the behavior of the mock mappings node
        when(mockMappings.fieldNames()).thenReturn(List.of("SystemA", "SystemB").iterator());
        when(mockMappings.get("SystemA")).thenReturn(mockSystemNode);
        when(mockSystemNode.fieldNames()).thenReturn(List.of("FirstName", "LastName").iterator());
        when(mockSystemNode.get("FirstName")).thenReturn(new TextNode("firstname"));
        when(mockSystemNode.get("LastName")).thenReturn(new TextNode("lastname"));

        //Action
        Map<String, String> fieldMapping = mappingService.getFieldMapping("SystemA");

        //Assertion
        assertEquals("firstname", fieldMapping.get("FirstName"));
    }

    @Test
    @DisplayName("Check Last name equals to expected")
    void testLoadMappings_GetArrange_WhenCheck_ThenLastNameMustBeEquals(){
        // Arrange
        JsonNode mockMappings = mock(JsonNode.class);
        JsonNode mockSystemNode = mock(JsonNode.class);

        // Mock the behavior of the mock mappings node
        when(mockMappings.fieldNames()).thenReturn(List.of("SystemA", "SystemB").iterator());
        when(mockMappings.get("SystemA")).thenReturn(mockSystemNode);
        when(mockSystemNode.fieldNames()).thenReturn(List.of("FirstName", "LastName").iterator());
        when(mockSystemNode.get("FirstName")).thenReturn(new TextNode("firstname"));
        when(mockSystemNode.get("LastName")).thenReturn(new TextNode("lastname"));

        //Action
        Map<String, String> fieldMapping = mappingService.getFieldMapping("SystemA");

        //Assertion
        assertEquals("lastname", fieldMapping.get("LastName"));
    }
}
