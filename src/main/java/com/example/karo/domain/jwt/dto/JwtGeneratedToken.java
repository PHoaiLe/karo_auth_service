package com.example.karo.domain.jwt.dto;

import lombok.Builder;
import lombok.Getter;

import java.util.Date;

@Getter
@Builder
public class JwtGeneratedToken
{
    private String id;
    private String token;
    private Date issuedAt;
    private Date expiration;
}
