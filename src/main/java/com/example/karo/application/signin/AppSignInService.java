package com.example.karo.application.signin;

import com.example.karo.domain.dto.ServiceResult;
import com.example.karo.domain.repositories.AccountRepository;
import com.example.karo.domain.signin.dto.SignInStandardInput;
import com.example.karo.domain.signin.exceptions.SignInException;
import com.example.karo.infrastructure.repositories.account.entities.AccountEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AppSignInService
{
    private final AccountRepository<AccountEntity> accountRepository;

    @Autowired
    public AppSignInService(AccountRepository<AccountEntity> accountRepository)
    {
        this.accountRepository = accountRepository;
    }

    public ServiceResult signIn(SignInStandardInput input) throws SignInException
    {
        Optional<AccountEntity> accountEntityOptional = this.accountRepository.findByAuthInfo(input.getAuthInfo());

        if(accountEntityOptional.isEmpty())
        {
            throw SignInException.NOT_FOUND_AUTH_INFO;
        }

        AccountEntity accountEntity = accountEntityOptional.get();

        Integer registerType = accountEntity.getRegister_type();


    }
}
