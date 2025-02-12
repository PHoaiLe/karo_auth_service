package com.example.karo.domain.signin;

import com.example.karo.domain.signin.dto.SignInStandardInput;

public abstract class SignInStrategy<INPUT extends SignInStandardInput>
{
    protected Integer signInType;

    protected SignInStrategy() {}

    protected SignInStrategy(Integer signInType)
    {
        this.signInType = signInType;
    }

    public abstract boolean signIn(INPUT input);
}
