package com.example.karo.domain.jwt;

public enum DomainJwtKeySelection
{
    ACCESS_TOKEN(0),
    REFRESH_TOKEN(1);


    private int secretName;
    private DomainJwtKeySelection(int secretName)
    {
        this.secretName = secretName;
    }

    public int getSecretName() {
        return secretName;
    }
}
