package com.example.karo.domain.repositories;

import com.example.karo.domain.models.AccountModel;

import java.util.Optional;

public interface AccountRepository<ENTITY extends AccountModel>
{
    ENTITY create(ENTITY entity);

    Optional<ENTITY> findByAuthInfo(String authInfo);
}
