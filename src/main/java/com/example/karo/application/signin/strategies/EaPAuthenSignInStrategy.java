package com.example.karo.application.signin.strategies;

import com.example.karo.domain.signin.SignInStrategy;
import com.example.karo.domain.signin.dto.SignInStandardInput;

public class EaPAuthenSignInStrategy extends SignInStrategy<SignInStandardInput>
{
    private static final Integer SIGN_TYPE_ID = 0;

    public EaPAuthenSignInStrategy() {super(SIGN_TYPE_ID);}

    public EaPAuthenSignInStrategy()
    {
        super(SIGN_TYPE_ID);
    }

    @Override
    public boolean signIn(SignInStandardInput input) {
        return false;
    }
}
