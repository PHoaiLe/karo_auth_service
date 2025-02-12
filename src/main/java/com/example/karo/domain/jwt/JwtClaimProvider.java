package com.example.karo.domain.jwt;

import com.example.karo.domain.jwt.dto.JwtExtraClaims;
import com.example.karo.domain.jwt.dto.JwtFullClaims;
import io.jsonwebtoken.Claims;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public abstract class JwtClaimProvider
{
    public static final String AUTH_ID = "AID";
    public static final String NONCE = "NOC";

    public static Map<String, Object> getMapOfClaims(JwtExtraClaims extraClaims)
    {
        Map<String, Object> mapOfClaims = new HashMap<>();
        mapOfClaims.put(AUTH_ID, extraClaims.getAuthId());
        mapOfClaims.put(NONCE, extraClaims.getNonce());

        return mapOfClaims;
    }

    public static JwtExtraClaims getExtraClaims(Claims claims)
    {
        String authId = claims.get(AUTH_ID, String.class);
        Double nonce = claims.get(NONCE, Double.class);

        return JwtExtraClaims.toInstance(authId, nonce);
    }

    public static JwtFullClaims getFullClaims(Claims claims)
    {
        String tokenId = claims.getId();
        String authId = claims.get(AUTH_ID, String.class);
        Double nonce = claims.get(NONCE, Double.class);
        Date issueAt = claims.getIssuedAt();
        Date expiration = claims.getExpiration();

        return JwtFullClaims.toInstance(tokenId, authId, nonce, issueAt, expiration);
    }
}
