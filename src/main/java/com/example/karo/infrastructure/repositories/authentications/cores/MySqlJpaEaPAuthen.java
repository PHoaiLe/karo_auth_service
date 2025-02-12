package com.example.karo.infrastructure.repositories.authentications.cores;

import com.example.karo.infrastructure.repositories.authentications.entities.EaPAuthenEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MySqlJpaEaPAuthen extends JpaRepository<EaPAuthenEntity, String>
{
    Optional<EaPAuthenEntity> findByEmail(String email);
}
