package com.example.karo.infrastructure.config;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationContextConfig
{
    @Bean
    ApplicationContext applicationContext(ApplicationContext applicationContext)
    {
        return applicationContext;
    }

}
