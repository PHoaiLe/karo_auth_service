package com.example.karo.domain.models;

import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass
public abstract class AccountRegisterTypeModel
{
    protected String name;
    protected String value;

    protected AccountRegisterTypeModel() {}
    protected AccountRegisterTypeModel(String name, String value)
    {
        this.name = name;
        this.value = value;
    }

    public abstract Integer getId();
}
