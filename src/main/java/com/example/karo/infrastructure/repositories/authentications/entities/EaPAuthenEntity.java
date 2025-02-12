package com.example.karo.infrastructure.repositories.authentications.entities;

import com.example.karo.domain.models.signup_strategies.EaPAuthenModel;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NonNull;

@Entity
@Table(name = "email_password_auth")
@Getter
public class EaPAuthenEntity extends EaPAuthenModel<EaPAuthenEntity>
{
    @Id
    @NonNull
    @Column(name = "id", length = 36, nullable = false)
    private String id;

    private EaPAuthenEntity() {super();}

    public EaPAuthenEntity(@NonNull String email, @NonNull String password) {
        super(email, password);
    }

    public static EaPAuthenEntity getInstance(@NonNull String email, @NonNull String password)
    {
        EaPAuthenEntity entity = new EaPAuthenEntity(email, password);

        return entity;
    }

    @Override
    public EaPAuthenEntity getModel() {
        return this;
    }

    @Override
    public String getAuthInfoId() {
        return this.id;
    }

    @Override
    public String getAuthInfo() {
        return super.email;
    }
}
