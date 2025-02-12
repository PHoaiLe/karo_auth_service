package com.example.karo.infrastructure.repositories.account_status;

import com.example.karo.domain.repositories.AccountStatusRepository;
import com.example.karo.infrastructure.repositories.account_status.cores.MySqlJpaAccountStatus;
import com.example.karo.infrastructure.repositories.account_status.entities.AccountStatusEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AppAccountStatusRepository implements AccountStatusRepository<AccountStatusEntity>
{
    private final MySqlJpaAccountStatus jpaAccountStatus;

    @Autowired
    public AppAccountStatusRepository(MySqlJpaAccountStatus jpaAccountStatus)
    {
        this.jpaAccountStatus = jpaAccountStatus;
    }

    @Override
    public List<AccountStatusEntity> findAll() {
        return this.jpaAccountStatus.findAll();
    }
}
