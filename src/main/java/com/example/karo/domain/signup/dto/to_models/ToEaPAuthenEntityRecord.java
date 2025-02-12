package com.example.karo.domain.signup.dto.to_models;

import com.example.karo.domain.signup.dto.ToAuthenEntityRecord;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class ToEaPAuthenEntityRecord extends ToAuthenEntityRecord
{
    private String email;
    private String hashedPassword;
}