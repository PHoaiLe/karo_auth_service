package com.example.karo.infrastructure.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppLoggerConfig
{
    @Bean
    public Logger appLogger()
    {
        return LoggerFactory.getLogger(AppLoggerConfig.class);
    }

}
