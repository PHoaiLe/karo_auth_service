package com.example.karo.infrastructure.repositories.account_status.cores;

import com.example.karo.infrastructure.repositories.account_status.entities.AccountStatusEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MySqlJpaAccountStatus extends JpaRepository<AccountStatusEntity, Integer>
{

}
