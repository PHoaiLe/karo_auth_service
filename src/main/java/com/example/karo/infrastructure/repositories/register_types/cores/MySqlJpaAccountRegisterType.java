package com.example.karo.infrastructure.repositories.register_types.cores;

import com.example.karo.infrastructure.repositories.register_types.entities.AccountRegisterTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MySqlJpaAccountRegisterType extends JpaRepository<AccountRegisterTypeEntity, Integer>
{

}
