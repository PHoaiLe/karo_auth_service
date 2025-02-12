package com.example.karo.domain.models;

public abstract class AuthenticationModel<ENTITY extends AuthenticationModel>
{
    public abstract ENTITY getModel();
    public abstract String getAuthInfoId();
    public abstract String getAuthInfo();
}
