package com.example.karo.domain.jwt.dto;

import lombok.Getter;

@Getter
public class JwtExtraClaims
{
    private String authId;
    private Double nonce;

    protected JwtExtraClaims(String authId, Double nonce)
    {
        this.authId = authId;
        this.nonce = nonce;
    }

    public static JwtExtraClaims toInstance(String authId, Double nonce)
    {
        return new JwtExtraClaims(authId, nonce);
    }

    public static JwtExtraClaims getInstance(String authId)
    {
        Double nonce = Math.random();
        return new JwtExtraClaims(authId, nonce);
    }
}
