package com.example.karo.shared.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ApiResponseBody<DATA>
{
    private int statusCode;
    private String message;
    private DATA data;
}
