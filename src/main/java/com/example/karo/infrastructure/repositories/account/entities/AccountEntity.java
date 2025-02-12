package com.example.karo.infrastructure.repositories.account.entities;

import com.example.karo.domain.models.AccountModel;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "account")
@Getter
public class AccountEntity extends AccountModel
{
    @Id
    @Column(name = "id", length = 36, nullable = false)
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private AccountEntity() {super();}

    private AccountEntity(String auth_info_id, String auth_info, @NonNull Integer role, @NonNull Integer register_type, @NonNull Integer status, @NonNull Date created_at)
    {
        super(auth_info_id, auth_info, role, register_type, status, created_at);
    }

    public static AccountEntity getInstance(String auth_info_id, String auth_info, Integer role, Integer register_type, Integer status)
    {
        return new AccountEntity(auth_info_id, auth_info, role, register_type, status, new Date());
    }

    public static AccountEntity getInstance(String auth_info_id, String auth_info, Integer role, Integer register_type, Integer status, Date created_at)
    {
        AccountEntity entity = new AccountEntity(auth_info_id, auth_info, role, register_type, status, created_at);

        return entity;
    }

    @Override
    public String toString() {
        return "MySqlAccountEntity{" +
                "id='" + id + '\'' +
                super.toString() + '\'' +
                '}';
    }
}
