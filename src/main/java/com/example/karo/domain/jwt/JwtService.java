package com.example.karo.domain.jwt;

import com.example.karo.domain.jwt.dto.JwtExtraClaims;
import com.example.karo.domain.jwt.dto.JwtGeneratedToken;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.UnsupportedJwtException;
import io.jsonwebtoken.security.SignatureException;

import java.util.function.Function;

public interface JwtService
{
    JwtGeneratedToken generateToken(DomainJwtKeySelection selection, JwtExtraClaims extraClaims, long expiredInterval, String tokenIdPrefix);
    JwtGeneratedToken generateToken(DomainJwtKeySelection selection, JwtExtraClaims extraClaims);
    <T extends  JwtExtraClaims> T getClaims(DomainJwtKeySelection selection, String token, Function<Claims, T> claimsResolver) throws ExpiredJwtException, UnsupportedJwtException,
            MalformedJwtException, SignatureException, IllegalArgumentException;
}
