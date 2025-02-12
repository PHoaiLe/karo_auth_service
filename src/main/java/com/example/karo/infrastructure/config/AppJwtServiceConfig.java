package com.example.karo.infrastructure.config;

import com.example.karo.domain.jwt.JwtService;
import com.example.karo.infrastructure.services.AppJwtService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppJwtServiceConfig
{
    @Bean
    public JwtService jwtService(AppJwtService appJwtService)
    {
        return appJwtService;
    }
}
