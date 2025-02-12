package com.example.karo.infrastructure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SpringSecurityFilterChainConfig
{
    @Bean
    SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception
    {
        SecurityFilterChain filterChain = httpSecurity.authorizeHttpRequests(authorRequestRegistry ->
                authorRequestRegistry
                        .requestMatchers("/apis/auth/v1/signup/**").permitAll()
                        .requestMatchers("/apis/auth/welcome").permitAll()
        )
                .formLogin(formLoginConfig -> formLoginConfig.disable())
                .logout(logoutConfig -> logoutConfig.disable())
//                .cors(httpSecurityCorsConfigurer -> ...)
                .csrf(httpSecurityCsrfConfigurer -> httpSecurityCsrfConfigurer.disable())
                .build();

        return filterChain;
    }
}
