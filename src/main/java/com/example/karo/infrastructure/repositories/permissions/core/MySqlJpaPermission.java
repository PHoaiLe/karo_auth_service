package com.example.karo.infrastructure.repositories.permissions.core;

import com.example.karo.infrastructure.repositories.permissions.entities.PermissionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MySqlJpaPermission extends JpaRepository<PermissionEntity, Integer>
{

}
