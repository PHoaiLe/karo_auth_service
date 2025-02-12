package com.example.karo.infrastructure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

@Configuration
public class PasswordProviderConfig
{
    private static final int BCRYPT_PASSWORD_ENCODER_STRENGTH = 10;
    @Bean
    PasswordEncoder passwordEncoder() throws NoSuchAlgorithmException {
        SecureRandom random = SecureRandom.getInstanceStrong();

        return new BCryptPasswordEncoder(BCRYPT_PASSWORD_ENCODER_STRENGTH, random);
    }


}
