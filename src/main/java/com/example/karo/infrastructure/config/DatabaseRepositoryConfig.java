package com.example.karo.infrastructure.config;

import com.example.karo.domain.repositories.AccountRegisterTypeRepository;
import com.example.karo.domain.repositories.AccountRepository;
import com.example.karo.domain.repositories.AccountRoleRepository;
import com.example.karo.domain.repositories.AccountStatusRepository;
import com.example.karo.infrastructure.repositories.account.AppAccountRepository;
import com.example.karo.infrastructure.repositories.account_roles.AppAccountRoleRepository;
import com.example.karo.infrastructure.repositories.account_status.AppAccountStatusRepository;
import com.example.karo.infrastructure.repositories.register_types.AppAccountRegisterTypeRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
public class DatabaseRepositoryConfig
{
    @Bean
    public AccountRepository accountRepository(AppAccountRepository mySqlAccountRepository)
    {
        return mySqlAccountRepository;
    }

    @Bean
    public AccountRoleRepository accountRoleRepository(AppAccountRoleRepository appAccountRoleRepository)
    {
        return appAccountRoleRepository;
    }

    @Bean
    public AccountRegisterTypeRepository accountRegisterTypeRepository(AppAccountRegisterTypeRepository appAccountRegisterTypeRepository)
    {
        return appAccountRegisterTypeRepository;
    }

    @Bean
    public AccountStatusRepository accountStatusRepository(AppAccountStatusRepository appAccountStatusRepository)
    {
        return appAccountStatusRepository;
    }
}
