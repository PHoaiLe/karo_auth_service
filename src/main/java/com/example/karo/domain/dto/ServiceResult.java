package com.example.karo.domain.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ServiceResult<T>
{
    private CustomizedServiceRuntimeStatus runtimeStatus;
    private T result;
}
