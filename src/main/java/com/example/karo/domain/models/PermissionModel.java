package com.example.karo.domain.models;

import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@MappedSuperclass
public abstract class PermissionModel
{
    protected String name;
    protected String value;
    protected String method;
    protected String endpoint;

    protected PermissionModel() {}

    protected PermissionModel(String name, String value, String method, String endpoint)
    {
        this.name = name;
        this.value = value;
        this.method = method;
        this.endpoint = endpoint;
    }

    public abstract Integer getId();
}
