package com.example.karo.domain.models;

import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
@MappedSuperclass
public abstract class AccountStatusModel
{
    protected String name;
    protected String value;

    protected AccountStatusModel() {}

    protected AccountStatusModel(String name, String value)
    {
        this.name = name;
        this.value = value;
    }

    public abstract Integer getId();
}
