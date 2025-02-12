package com.example.karo.domain.models;

import jakarta.persistence.MappedSuperclass;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@MappedSuperclass
public abstract class AccountModel
{
    @NonNull
    private String auth_info_id;

    @NonNull
    private String auth_info;

    @NonNull
    private Integer role;

    @NonNull
    private Integer register_type;

    @NonNull
    private Integer status;

    @NonNull
    private Date created_at;

    protected AccountModel() {}

    protected AccountModel(String auth_info_id, String auth_info, @NonNull Integer role, @NonNull Integer register_type, @NonNull Integer status, @NonNull Date created_at)
    {
        this.auth_info_id = auth_info_id;
        this.auth_info = auth_info;
        this.role = role;
        this.register_type = register_type;
        this.status = status;
        this.created_at = created_at;
    }

    @Override
    public String toString() {
        return "auth_info_id='" + auth_info_id + '\'' +
                ", auth_info='" + auth_info + '\'' +
                ", role=" + role +
                ", register_type=" + register_type +
                ", status=" + status +
                ", created_at=" + created_at;
    }

    public abstract String getId();
}
