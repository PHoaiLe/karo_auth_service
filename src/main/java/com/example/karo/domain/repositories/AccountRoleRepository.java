package com.example.karo.domain.repositories;

import com.example.karo.domain.models.AccountRoleModel;

import java.util.List;

public interface AccountRoleRepository<ENTITY extends AccountRoleModel>
{
    List<ENTITY> findAll();
}
