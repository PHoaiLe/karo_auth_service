package com.example.karo.infrastructure.repositories.account;

import com.example.karo.domain.repositories.AccountRepository;
import com.example.karo.infrastructure.repositories.account.cores.MySqlJpaAccount;
import com.example.karo.infrastructure.repositories.account.entities.AccountEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class AppAccountRepository implements AccountRepository<AccountEntity>
{
    private final MySqlJpaAccount repository;

    @Autowired
    public AppAccountRepository(MySqlJpaAccount repository)
    {
        this.repository = repository;
    }

    @Override
    public AccountEntity create(AccountEntity accountEntity) {

        AccountEntity entity = this.repository.save(accountEntity);

        return entity;
    }

    @Override
    public Optional<AccountEntity> findByAuthInfo(String authInfo) {
        return this.repository.findByAuthInfo(authInfo);
    }
}
