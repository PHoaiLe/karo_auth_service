package com.example.karo.infrastructure.repositories.account.cores;

import com.example.karo.infrastructure.repositories.account.entities.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MySqlJpaAccount extends JpaRepository<AccountEntity, String>
{
    Optional<AccountEntity> findByAuthInfo(String auth_info);
}
