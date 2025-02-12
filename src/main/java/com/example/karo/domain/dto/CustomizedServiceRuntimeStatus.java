package com.example.karo.domain.dto;

import org.springframework.http.HttpStatusCode;

public interface CustomizedServiceRuntimeStatus
{
    HttpStatusCode getStatusCode();
    int getIntStatusCode();
    String getMessage();
}
