package com.example.karo.domain.utils.password;

public interface DomainPasswordEncoder
{
    String encode(String rawPassword);
    boolean isCorrectPassword(String rawPassword, String hashPassword);
}
