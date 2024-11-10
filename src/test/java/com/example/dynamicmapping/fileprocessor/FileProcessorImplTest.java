package com.example.dynamicmapping.fileprocessor;

import com.example.dynamicmapping.mapping.MappingService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class FileProcessorImplTest {

    private MappingService mappingService;
    private FileProcessorImpl fileProcessor;

    @BeforeEach
    void setUp() {
        mappingService = Mockito.mock(MappingService.class);
        fileProcessor = new FileProcessorImpl(mappingService);
    }

    /**
     * Test {@link FileProcessorImpl#processFile(String, String[], String[])}.
     * <ul>
     *   <li>When array of {@link String} with {@code File Headers}.</li>
     *   <li>Then return {@code {"payload":{"Profile":{}}}}.</li>
     * </ul>
     * <p>
     * Method under test:
     * {@link FileProcessorImpl#processFile(String, String[], String[])}
     */
    @Test
    @DisplayName("Test processFile(String, String[], String[]); then equals expected")
    void testProcessFileSystemA_whenArrayOfStringWithFileHeaders_thenReturnProfile() {
        // Arrange
        String[] fileHeadersA = {"FirstName", "LastName", "CustomerId", "status", "addressLine", "City", "Province", "PostalCode"};
        String[] rowDataA = {"Nima", "Moosavi", "12345", "active", "123 Main St", "Toronto", "ON", "M5A 1A1"};

        when(mappingService.getFieldMapping("SystemA")).thenReturn(Map.of(
                "FirstName", "firstname",
                "LastName", "lastname",
                "CustomerId", "customerId",
                "status", "status",
                "addressLine", "address.addressLine",
                "City", "address.city",
                "Province", "address.province",
                "PostalCode", "address.postalCode"
        ));

        //Action
        String expectedJson = "{\"payload\":{\"Profile\":{\"firstname\":\"Nima\",\"address\":{\"province\":\"ON\",\"city\":\"Toronto\",\"postalCode\":\"M5A 1A1\",\"addressLine\":\"123 Main St\"},\"customerId\":\"12345\",\"lastname\":\"Moosavi\",\"status\":\"active\"}}}";

        String result = fileProcessor.processFile("SystemA", fileHeadersA, rowDataA);

        // Assertion
        assertEquals(expectedJson, result);
    }


    /**
     * Test {@link FileProcessorImpl#processFile(String, String[], String[])}.
     * <ul>
     *   <li>When array of {@link String} with {@code File Headers}.</li>
     *   <li>Then return {@code {"payload":{"Profile":{}}}}.</li>
     * </ul>
     * <p>
     * Method under test:
     * {@link FileProcessorImpl#processFile(String, String[], String[])}
     */
    @Test
    @DisplayName("Test processFile(String, String[], String[]); when array of String with 'File Headers'; then return '{\"payload\":{\"Profile\":{}}}'")
    void testProcessFile_whenArrayOfStringWithFileHeaders_thenReturnPayloadProfile() {
        // Arrange
        when(mappingService.getFieldMapping(Mockito.any())).thenReturn(new HashMap<>());

        // Act
        String actualProcessFileResult = (new FileProcessorImpl(mappingService)).processFile("System Name",
                new String[]{"File Headers"}, new String[]{"Row Data"});

        // Assert
        assertEquals("{\"payload\":{\"Profile\":{}}}", actualProcessFileResult);
    }
}
