package com.example.karo.application.account_status;

import com.example.karo.domain.repositories.AccountStatusRepository;
import com.example.karo.infrastructure.repositories.account_status.entities.AccountStatusEntity;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccountStatusService
{
    private final AccountStatusRepository<AccountStatusEntity> repository;

    private LinkedHashMap<String, AccountStatusEntity> mapOfStatus;

    public AccountStatusService(AccountStatusRepository<AccountStatusEntity> repository)
    {
        this.repository = repository;
        this.mapOfStatus = new LinkedHashMap<>();

        init();
    }

    private void init()
    {
        List<AccountStatusEntity> listOfEntities = this.repository.findAll();

        for(int i=0; i < listOfEntities.size(); i++)
        {
            String value = listOfEntities.get(i).getValue();
            this.mapOfStatus.put(value, listOfEntities.get(i));
        }
    }

    public AccountStatusEntity getEntityByValue(String value)
    {
        return this.mapOfStatus.get(value);
    }

    public AccountStatusEntity getEntityById(Integer id)
    {
        return this.mapOfStatus.values().stream().collect(Collectors.toList()).get(id);
    }
}
