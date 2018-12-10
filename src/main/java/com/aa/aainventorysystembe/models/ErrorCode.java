package com.aa.aainventorysystembe.models;

public enum ErrorCode {
    NOT_FOUND("404", "Data not found"),
    BAD_REQUEST("400", "Data not valid"),
    INTERNAL_SERVER_ERROR("500", "System fault"),
    OK("200", "Data Saved");
    private String code;
    private String message;

    ErrorCode(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
