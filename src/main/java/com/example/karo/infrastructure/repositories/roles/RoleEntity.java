package com.example.karo.infrastructure.repositories.roles;

import com.example.karo.domain.models.RoleModel;

public class RoleEntity extends RoleModel
{
    public RoleEntity() {}

    public RoleEntity(String permission_id, String banned_status_id, Boolean is_available)
    {
        super(permission_id, banned_status_id, is_available);
    }

    @Override
    public boolean equals(Object obj) {
        RoleEntity entity = (RoleEntity) obj;

        if(this.permission_id.equals(entity.permission_id) && this.banned_status_id.equals(entity.banned_status_id)
        && this.is_available.equals(entity.is_available))
        {
            return true;
        }

        return false;
    }
}
