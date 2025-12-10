package com.census.exception;

public class CensusAnalyserException extends Exception {
    public enum ExceptionType {
        FILE_NOT_FOUND,
        INVALID_FILE_TYPE,
        INVALID_DELIMITER,
        INVALID_HEADER,
        CSV_PARSE_ERROR,
        NO_CENSUS_DATA
    }

    private final ExceptionType type;

    public CensusAnalyserException(String message, ExceptionType type) {
        super(message);
        this.type = type;
    }

    public ExceptionType getType() {
        return type;
    }
}
