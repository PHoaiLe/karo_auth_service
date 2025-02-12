package com.example.karo.infrastructure.repositories.permissions.entities;

import com.example.karo.domain.models.PermissionModel;
import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Table(name = "permission")
@Getter
public class PermissionEntity extends PermissionModel
{
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    public PermissionEntity()
    {
        super();
    }

    public PermissionEntity(String name, String value, String method, String endpoint)
    {
        super(name, value, method, endpoint);
    }
}
