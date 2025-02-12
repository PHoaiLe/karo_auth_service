package com.example.karo.application.signup;

import com.example.karo.application.account_register_types.AccountRegisterTypeService;
import com.example.karo.application.account_roles.AccountRoleService;
import com.example.karo.application.account_status.AccountStatusService;
import com.example.karo.domain.dto.ServiceResult;
import com.example.karo.domain.models.AuthenticationModel;
import com.example.karo.domain.repositories.AccountRepository;
import com.example.karo.domain.signup.SignUpStrategy;
import com.example.karo.domain.signup.dto.SignUpInput;
import com.example.karo.domain.signup.dto.ToAuthenEntityRecord;
import com.example.karo.domain.signup.exceptions.SignUpException;
import com.example.karo.infrastructure.repositories.account.entities.AccountEntity;
import com.example.karo.infrastructure.repositories.account_roles.entities.AccountRoleEntity;
import com.example.karo.infrastructure.repositories.register_types.entities.AccountRegisterTypeEntity;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppSignUpService
{
    private final SignUpStrategyFactory signUpStrategyFactory;
    private final AccountRepository accountRepository;
    private final AccountRoleService accountRoleService;
    private final AccountRegisterTypeService accountRegisterTypeService;
    private final AccountStatusService accountStatusService;
    private final Logger appLogger;

    @Autowired
    public AppSignUpService(SignUpStrategyFactory signUpStrategyFactory, AccountRepository accountRepository, AccountRoleService accountRoleService,
                            AccountRegisterTypeService accountRegisterTypeService, AccountStatusService accountStatusService, Logger appLogger)
    {
        this.signUpStrategyFactory = signUpStrategyFactory;
        this.accountRepository = accountRepository;
        this.accountRoleService = accountRoleService;
        this.accountRegisterTypeService = accountRegisterTypeService;
        this.accountStatusService = accountStatusService;
        this.appLogger = appLogger;
    }

    @Transactional(rollbackOn = {SignUpException.class})
    public <RETURN extends AuthenticationModel,INPUT extends SignUpInput, RECORD extends ToAuthenEntityRecord> ServiceResult<AccountEntity> signUp(INPUT input) throws SignUpException
    {
        AccountRoleEntity accountRoleEntity = this.accountRoleService.getEntityByValue(input.getRole());
        if(accountRoleEntity == null)
        {
            throw SignUpException.INVALID_SIGNUP_ROLE;
        }

        AccountRegisterTypeEntity accountRegisterTypeEntity = this.accountRegisterTypeService.getEntityByValue(input.getRegisterType());
        if(accountRegisterTypeEntity == null)
        {
            throw SignUpException.INVALID_SIGNUP_TYPE;
        }

        Integer statusId = this.accountStatusService.getEntityById(0).getId();

        SignUpStrategy<RETURN, INPUT, RECORD> strategy = signUpStrategyFactory.getStrategy(input.getClass());
        if(strategy == null)
        {
            throw SignUpException.NOT_SUPPORTED_METHOD;
        }

        AuthenticationModel model = strategy.signUp(input);

        try
        {
            AccountEntity accountEntity = (AccountEntity) this.accountRepository.create(AccountEntity.getInstance(model.getAuthInfoId(),
                    model.getAuthInfo(), accountRoleEntity.getId(), accountRegisterTypeEntity.getId(), statusId));

            ServiceResult serviceResult = ServiceResult.builder().result(accountEntity)
                    .runtimeStatus(SignUpException.SignUpRuntimeStatus.SUCCESS)
                    .build();

            return serviceResult;
        }
        catch (Exception exception)
        {
            appLogger.error(exception.getMessage());
            appLogger.debug(exception.getMessage());
            throw SignUpException.SQL_CREATED_ERROR;
        }
    }
}
