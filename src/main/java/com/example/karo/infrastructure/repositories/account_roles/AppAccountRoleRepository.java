package com.example.karo.infrastructure.repositories.account_roles;

import com.example.karo.domain.repositories.AccountRoleRepository;
import com.example.karo.infrastructure.repositories.account_roles.entities.AccountRoleEntity;
import com.example.karo.infrastructure.repositories.account_roles.cores.MySqlJpaAccountRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AppAccountRoleRepository implements AccountRoleRepository<AccountRoleEntity>
{
    private final MySqlJpaAccountRole jpaAccountRole;

    @Autowired
    public AppAccountRoleRepository(MySqlJpaAccountRole jpaAccountRole)
    {
        this.jpaAccountRole = jpaAccountRole;
    }

    @Override
    public List<AccountRoleEntity> findAll() {
        return this.jpaAccountRole.findAll();
    }
}
