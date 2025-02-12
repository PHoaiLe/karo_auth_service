package com.example.karo.infrastructure.repositories.register_types;

import com.example.karo.domain.repositories.AccountRegisterTypeRepository;
import com.example.karo.infrastructure.repositories.register_types.cores.MySqlJpaAccountRegisterType;
import com.example.karo.infrastructure.repositories.register_types.entities.AccountRegisterTypeEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AppAccountRegisterTypeRepository implements AccountRegisterTypeRepository<AccountRegisterTypeEntity>
{
    private final MySqlJpaAccountRegisterType repository;

    @Autowired
    public AppAccountRegisterTypeRepository(MySqlJpaAccountRegisterType repository)
    {
        this.repository = repository;
    }

    @Override
    public List<AccountRegisterTypeEntity> findAll() {
        return this.repository.findAll();
    }
}
