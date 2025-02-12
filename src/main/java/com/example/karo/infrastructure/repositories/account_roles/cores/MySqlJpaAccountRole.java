package com.example.karo.infrastructure.repositories.account_roles.cores;

import com.example.karo.infrastructure.repositories.account_roles.entities.AccountRoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MySqlJpaAccountRole extends JpaRepository<AccountRoleEntity, Integer>
{

}
