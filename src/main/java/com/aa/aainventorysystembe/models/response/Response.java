package com.aa.aainventorysystembe.models.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Response<T> {
    private String code;
    private String message;
    private T Data;
}
