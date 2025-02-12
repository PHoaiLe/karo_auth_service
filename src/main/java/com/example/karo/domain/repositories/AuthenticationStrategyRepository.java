package com.example.karo.domain.repositories;

import com.example.karo.domain.models.AuthenticationModel;

import java.util.Optional;

public interface AuthenticationStrategyRepository<APP_MODEL extends AuthenticationModel, RECORD>
{
    Optional<APP_MODEL> findByAuthInfo(String auth_info);

    APP_MODEL create(APP_MODEL inputModel);

    APP_MODEL createEntity(RECORD e);
}
