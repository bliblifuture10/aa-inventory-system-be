package com.aa.aainventorysystembe.models;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
public class Response<T> {
    private String code;
    private String message;
    private T data;
}
