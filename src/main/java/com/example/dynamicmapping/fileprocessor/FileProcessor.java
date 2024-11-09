package com.example.dynamicmapping.fileprocessor;

public interface FileProcessor {

    /**
     * Processes the file based on the system's field mapping.
     *
     * @param systemName  The system's name for which to apply mappings.
     * @param fileHeaders The headers from the file (List of column names).
     * @param rowData     The row data from the file (List of values).
     * @return The resulting JSON string after applying the field mappings.
     */
    String processFile(String systemName, String[] fileHeaders, String[] rowData);
}
