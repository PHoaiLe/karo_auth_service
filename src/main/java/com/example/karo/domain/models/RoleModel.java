package com.example.karo.domain.models;

import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass
public abstract class RoleModel
{
    protected String permission_id;
    protected String banned_status_id;
    protected Boolean is_available;

    protected RoleModel() {}
    protected RoleModel(String permission_id, String banned_status_id, Boolean is_available)
    {
        this.permission_id = permission_id;
        this.banned_status_id = banned_status_id;
        this.is_available = is_available;
    }

}
