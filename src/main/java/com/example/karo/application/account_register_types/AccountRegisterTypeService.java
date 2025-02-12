package com.example.karo.application.account_register_types;

import com.example.karo.domain.repositories.AccountRegisterTypeRepository;
import com.example.karo.infrastructure.repositories.register_types.entities.AccountRegisterTypeEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccountRegisterTypeService
{
    private final AccountRegisterTypeRepository<AccountRegisterTypeEntity> accountRegisterTypeRepository;
    private LinkedHashMap<String, AccountRegisterTypeEntity> mapOfRegisterTypes;

    @Autowired
    public AccountRegisterTypeService(AccountRegisterTypeRepository<AccountRegisterTypeEntity> accountRegisterTypeRepository)
    {
        this.accountRegisterTypeRepository = accountRegisterTypeRepository;
        this.mapOfRegisterTypes = new LinkedHashMap<>();

        this.init();
    }

    private void init()
    {
        List<AccountRegisterTypeEntity> listOfEntity = this.accountRegisterTypeRepository.findAll();

        for(int i = 0; i < listOfEntity.size(); i++)
        {
            String value = listOfEntity.get(i).getValue();
            this.mapOfRegisterTypes.put(value, listOfEntity.get(i));
        }
    }

    public AccountRegisterTypeEntity getEntityByValue(String value)
    {
        return this.mapOfRegisterTypes.get(value);
    }

    public AccountRegisterTypeEntity getEntityById(Integer id)
    {
        return this.mapOfRegisterTypes.values().stream().collect(Collectors.toList()).get(id);
    }
}
