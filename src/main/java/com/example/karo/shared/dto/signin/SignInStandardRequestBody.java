package com.example.karo.shared.dto.signin;

import com.example.karo.domain.signin.dto.SignInStandardInput;
import lombok.Getter;

@Getter
public class SignInStandardRequestBody
{
    private String authInfo;
    private String password;
    private String type;
    private Object extraData;


    public SignInStandardRequestBody() {}

    public SignInStandardRequestBody(String authInfo, String password, String type)
    {
        this.authInfo = authInfo;
        this.password = password;
        this.type = type;
    }

    public SignInStandardRequestBody(String authInfo, String password, String type, Object extraData)
    {
        this.authInfo = authInfo;
        this.password = password;
        this.type = type;
        this.extraData = extraData;
    }
}
