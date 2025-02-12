package com.example.karo.domain.repositories;

import com.example.karo.domain.models.AccountStatusModel;

import java.util.List;

public interface AccountStatusRepository<ENTITY extends AccountStatusModel>
{
    List<ENTITY> findAll();
}
