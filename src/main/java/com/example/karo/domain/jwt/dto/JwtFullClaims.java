package com.example.karo.domain.jwt.dto;

import lombok.Getter;

import java.util.Date;

@Getter
public class JwtFullClaims extends JwtExtraClaims
{
    private String tokenId;
    private Date issuedAt;
    private Date expiration;

    private JwtFullClaims(String tokenId, String authId, Double nonce, Date issuedAt, Date expiration)
    {
        super(authId, nonce);
        this.tokenId = tokenId;
        this.issuedAt = issuedAt;
        this.expiration = expiration;
    }

    public static JwtFullClaims getInstance(String tokenId, String authId, Date issuedAt, Date expiration)
    {
        Double nonce = Math.random();
        return new JwtFullClaims(tokenId, authId, nonce, issuedAt, expiration);
    }

    public static JwtFullClaims toInstance(String tokenId, String authId, Double nonce, Date issuedAt, Date expiration)
    {
        return new JwtFullClaims(tokenId, authId, nonce, issuedAt, expiration);
    }
}
