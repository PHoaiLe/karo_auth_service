package com.example.karo.infrastructure.repositories.register_types.entities;

import com.example.karo.domain.models.AccountRegisterTypeModel;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "account_register_type")
@Getter
public class AccountRegisterTypeEntity extends AccountRegisterTypeModel
{
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private AccountRegisterTypeEntity() {super();}

    private AccountRegisterTypeEntity(String name, String value)
    {
        super(name, value);
    }

    public AccountRegisterTypeEntity getInstance(String name, String value)
    {
        AccountRegisterTypeEntity entity = new AccountRegisterTypeEntity(name, value);

        return entity;
    }
}
