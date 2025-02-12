package com.example.karo.infrastructure.repositories.account_roles.entities;

import com.example.karo.domain.models.AccountRoleModel;
import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Table(name = "account_role")
@Getter
public class AccountRoleEntity extends AccountRoleModel
{
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private AccountRoleEntity() {super();}

    private AccountRoleEntity(String name, String value, String refer_table)
    {
        super(name, value, refer_table);
    }

    public static AccountRoleEntity getInstance(String name, String value, String refer_table)
    {
        AccountRoleEntity entity = new AccountRoleEntity(name, value, refer_table);

        return entity;
    }

    @Override
    public String toString() {
        return "AccountRoleEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", value='" + value + '\'' +
                ", refer_table='" + refer_table + '\'' +
                '}';
    }
}
