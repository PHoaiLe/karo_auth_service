package com.example.karo.domain.signup;

import com.example.karo.domain.signup.dto.SignUpInput;
import com.example.karo.domain.models.AuthenticationModel;
import com.example.karo.domain.signup.dto.ToAuthenEntityRecord;
import com.example.karo.domain.signup.exceptions.SignUpException;
import lombok.Getter;

@Getter
public abstract class SignUpStrategy<RETURN_MODEL extends AuthenticationModel, INPUT extends SignUpInput, RECORD_TO_GEN_MODEL extends ToAuthenEntityRecord>
{
    protected Class classOfInput;

    protected SignUpStrategy()
    {}

    protected SignUpStrategy(Class classOfInput)
    {
        this.classOfInput = classOfInput;
    }

    protected abstract RETURN_MODEL genModelFrom(RECORD_TO_GEN_MODEL record);

    public abstract RETURN_MODEL signUp(INPUT input) throws SignUpException;
}
