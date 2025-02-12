package com.example.karo.domain.signup;

import com.example.karo.domain.dto.ServiceResult;
import com.example.karo.domain.models.AuthenticationModel;
import com.example.karo.domain.signup.dto.SignUpInput;

public interface SignUpService
{
    <RESULT extends AuthenticationModel, INPUT extends SignUpInput> ServiceResult<RESULT> signUp(INPUT input);
}
