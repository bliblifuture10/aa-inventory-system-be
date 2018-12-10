package com.aa.aainventorysystembe.controllers;

import com.aa.aainventorysystembe.models.Response;

public abstract class GlobalController {
    public <T> Response toResponse(T value){
        return Response.builder()
                .code("200")
                .message("Success")
                .data(value)
                .build();
    }
}
