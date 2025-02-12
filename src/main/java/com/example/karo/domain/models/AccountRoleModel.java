package com.example.karo.domain.models;

import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@MappedSuperclass
public abstract class AccountRoleModel
{
    protected String name;
    protected String value;
    protected String refer_table;

    protected AccountRoleModel() {}
    protected AccountRoleModel(String name, String value, String refer_table)
    {
        this.name = name;
        this.value = value;
        this.refer_table = refer_table;
    }

    public abstract Integer getId();
}
