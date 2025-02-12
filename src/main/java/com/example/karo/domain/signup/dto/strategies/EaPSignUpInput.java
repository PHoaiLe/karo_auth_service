package com.example.karo.domain.signup.dto.strategies;

import com.example.karo.domain.signup.dto.SignUpInput;
import lombok.Builder;
import lombok.Getter;

import java.util.Date;

@Getter
public class EaPSignUpInput extends SignUpInput
{
    private String email;
    private String password;


    public EaPSignUpInput(String email, String password, String role, String registerType) {
        super(role, registerType, new Date());
        this.email = email;
        this.password = password;
    }

    public EaPSignUpInput(String email, String password, String role, String registerType, Date createdAt) {
        super(role, registerType, createdAt);
        this.email = email;
        this.password = password;
    }
}
