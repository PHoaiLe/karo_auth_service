package com.example.karo.domain.signup.dto;

import lombok.Getter;

import java.util.Date;

@Getter
public abstract class SignUpInput
{
    protected SignUpInput(String role, String registerType, Date createdAt) {
        this.registerType = registerType;
        this.role = role;
        this.createdAt = createdAt;
    }

    protected String registerType;
    protected String role;
    protected Date createdAt;
}
