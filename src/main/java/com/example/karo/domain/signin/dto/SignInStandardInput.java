package com.example.karo.domain.signin.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
public class SignInStandardInput
{
    protected String authInfo;
    protected String password;
    protected String type;
    protected Object extraData;

    protected SignInStandardInput() {}

    protected SignInStandardInput(String authInfo, String password, String type)
    {
        this.authInfo = authInfo;
        this.password = password;
        this.type = type;
    }

    protected SignInStandardInput(String authInfo, String password, String type, Object extraData)
    {
        this.authInfo = authInfo;
        this.password = password;
        this.type = type;
        this.extraData = extraData;
    }
}
