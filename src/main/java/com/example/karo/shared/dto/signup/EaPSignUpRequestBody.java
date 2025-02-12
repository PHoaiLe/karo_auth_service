package com.example.karo.shared.dto.signup;

import com.example.karo.domain.signup.dto.SignUpInput;
import com.example.karo.domain.signup.dto.strategies.EaPSignUpInput;
import lombok.Getter;
import lombok.NonNull;

import java.util.Date;

@Getter
public class EaPSignUpRequestBody extends SignUpRequestBody
{
    @NonNull
    private String email;
    @NonNull
    private String password;

    public EaPSignUpRequestBody(String email, String password, String role, String registerType)
    {
        super(role, registerType);
        this.email = email;
        this.password = password;
    }

    @Override
    public SignUpInput createSignUpInput() {
        return new EaPSignUpInput(this.email, this.password, super.role, super.type);
    }

    @Override
    public SignUpInput createSignUpInput(Date createdAt) {
        return new EaPSignUpInput(this.email, this.password, super.role, super.type, createdAt);
    }

    @Override
    public String toString() {
        return "EaPRequestBody{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
                ", registerType='" + registerType + '\'' +
                '}';
    }
}
