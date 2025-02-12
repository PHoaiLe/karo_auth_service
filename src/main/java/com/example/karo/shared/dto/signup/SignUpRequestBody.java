package com.example.karo.shared.dto.signup;

import com.example.karo.domain.signup.dto.SignUpInput;
import lombok.Getter;
import lombok.NonNull;

import java.util.Date;

@Getter
public abstract class SignUpRequestBody
{
    @NonNull
    protected String role;
    @NonNull
    protected String type;

    protected SignUpRequestBody(String role, String type)
    {
        this.role = role;
        this.type = type;
    }

    public abstract SignUpInput createSignUpInput();
    public abstract SignUpInput createSignUpInput(Date createdAt);
}
