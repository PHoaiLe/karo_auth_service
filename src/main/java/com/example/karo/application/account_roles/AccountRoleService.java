package com.example.karo.application.account_roles;

import com.example.karo.domain.repositories.AccountRoleRepository;
import com.example.karo.infrastructure.repositories.account_roles.entities.AccountRoleEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccountRoleService
{
    private final AccountRoleRepository<AccountRoleEntity> accountRoleRepository;
    private LinkedHashMap<String, AccountRoleEntity> mapOfRoles;

    @Autowired
    public AccountRoleService(AccountRoleRepository<AccountRoleEntity> accountRoleRepository)
    {
        this.accountRoleRepository = accountRoleRepository;
        this.mapOfRoles = new LinkedHashMap<>();
        this.init();
    }

    private void init()
    {
        List<AccountRoleEntity> listOfRoles = this.accountRoleRepository.findAll();

        for(int i = 0; i < listOfRoles.size(); i++)
        {
            String value = listOfRoles.get(i).getValue();
            mapOfRoles.put(value, listOfRoles.get(i));
        }
    }

    public AccountRoleEntity getEntityByValue(String value)
    {
        return this.mapOfRoles.get(value);
    }

    public AccountRoleEntity getEntityById(Integer id)
    {
        return this.mapOfRoles.values().stream().collect(Collectors.toList()).get(id);
    }
}
