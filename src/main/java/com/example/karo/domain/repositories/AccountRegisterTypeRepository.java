package com.example.karo.domain.repositories;

import com.example.karo.domain.models.AccountRegisterTypeModel;

import java.util.List;

public interface AccountRegisterTypeRepository<ENTITY extends AccountRegisterTypeModel>
{
    public List<ENTITY> findAll();
}
