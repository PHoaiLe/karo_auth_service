package com.example.karo.domain.signin;

import com.example.karo.domain.dto.ServiceResult;
import com.example.karo.domain.signin.dto.SignInStandardInput;

public interface SignInService
{
    ServiceResult signIn(SignInStandardInput input);
}
