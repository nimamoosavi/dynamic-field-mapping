package com.example.dynamicmapping.fileprocessor;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import com.example.dynamicmapping.mapping.MappingService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import java.util.Map;

class FileProcessorImplTest {

    @Mock
    private MappingService mappingService;

    private FileProcessorImpl fileProcessor;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        fileProcessor = new FileProcessorImpl(mappingService);
    }

    @Test
    @DisplayName("check process file and must be equals expected")
    void testProcessFile_GetValue_WhenMappingCalled_ThenEqualsExpected() {
        // Arrange
        String systemName = "SystemA";
        String[] fileHeaders = {"FirstName", "LastName", "CustomerId", "status"};
        String[] rowData = {"John", "Doe", "12345", "Active"};

        // Mock the field mappings returned by the MappingService
        Map<String, String> fieldMapping = Map.of(
                "FirstName", "firstname",
                "LastName", "lastname",
                "CustomerId", "customerId",
                "status", "status"
        );
        when(mappingService.getFieldMapping(systemName)).thenReturn(fieldMapping);

        // Action
        String result = fileProcessor.processFile(systemName, fileHeaders, rowData);

        String expectedJson = "{ \"payload\": { \"Profile\": {"
                + "\"firstname\": \"John\", "
                + "\"lastname\": \"Doe\", "
                + "\"customerId\": \"12345\", "
                + "\"status\": \"Active\""
                + "}}}";

        // Assert that the result matches the expected output
        assertEquals(expectedJson, result);
    }

    @Test
    @DisplayName("check process file and must be equals expected")
    void testProcessFileWithMissingMapping() {
        // Arrange
        String systemName = "SystemA";
        String[] fileHeaders = {"FirstName", "LastName", "CustomerId", "status", "UnknownField"};
        String[] rowData = {"John", "Doe", "12345", "Active", "N/A"};

        // Mock the field mappings returned by the MappingService
        Map<String, String> fieldMapping = Map.of(
                "FirstName", "firstname",
                "LastName", "lastname",
                "CustomerId", "customerId",
                "status", "status"
        );
        when(mappingService.getFieldMapping(systemName)).thenReturn(fieldMapping);

        //Action
        String result = fileProcessor.processFile(systemName, fileHeaders, rowData);

        String expectedJson = "{ \"payload\": { \"Profile\": {"
                + "\"firstname\": \"John\", "
                + "\"lastname\": \"Doe\", "
                + "\"customerId\": \"12345\", "
                + "\"status\": \"Active\""
                + "}}}";

        // Assert
        assertEquals(expectedJson, result);
    }
}
