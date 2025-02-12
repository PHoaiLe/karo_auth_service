package com.example.karo.infrastructure.repositories.account_status.entities;


import com.example.karo.domain.models.AccountStatusModel;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "account_status")
@Getter
public class AccountStatusEntity extends AccountStatusModel
{
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private AccountStatusEntity() {super();}

    private AccountStatusEntity(String name, String value)
    {
        super(name, value);
    }

    public static AccountStatusEntity getInstance(String name, String value)
    {
        AccountStatusEntity entity = new AccountStatusEntity(name, value);

        return entity;
    }

}
