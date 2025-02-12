package com.example.karo.domain.jwt;


import com.example.karo.domain.jwt.dto.JwtExtraClaims;
import com.example.karo.domain.jwt.dto.JwtGeneratedToken;
import io.jsonwebtoken.*;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.security.SignatureException;

import java.security.Key;
import java.util.Date;
import java.util.UUID;
import java.util.function.Function;

public class DomainJwtService
{
    public DomainJwtService() {}

    private Key getSignKey(String secret)
    {
        byte[] decodedSecret = Decoders.BASE64.decode(secret);
        return Keys.hmacShaKeyFor(decodedSecret);
    }

    public JwtGeneratedToken generateToken(String secret, JwtExtraClaims extraClaims, long expiredInterval, String tokenIdPrefix)
    {
        long currentTimesMillis = System.currentTimeMillis();
        Date issuedMoment = new Date(currentTimesMillis);
        Date expirationMoment = new Date(currentTimesMillis + expiredInterval);
        UUID uuid = UUID.randomUUID();

        String tokenId = tokenIdPrefix + uuid;

        String token = Jwts.builder()
                .signWith(getSignKey(secret), SignatureAlgorithm.HS256)
                .addClaims(JwtClaimProvider.getMapOfClaims(extraClaims))
                .setIssuedAt(issuedMoment)
                .setExpiration(expirationMoment)
                .setId(tokenId)
                .compact();

        return JwtGeneratedToken.builder()
                .id(tokenId)
                .token(token)
                .issuedAt(issuedMoment)
                .expiration(expirationMoment)
                .build();
    }

    protected Claims extractClaims(String secret, String token) throws ExpiredJwtException, UnsupportedJwtException,
            MalformedJwtException, SignatureException, IllegalArgumentException
    {
        JwtParser jwtParser = Jwts.parserBuilder()
                .setSigningKey(getSignKey(secret))
                .build();

        Claims claims = jwtParser.parseClaimsJwt(token).getBody();

        return claims;
    }

    public <T extends JwtExtraClaims> T getClaims(String secret, String token, Function<Claims, T> claimsConverter) throws ExpiredJwtException, UnsupportedJwtException,
            MalformedJwtException, SignatureException, IllegalArgumentException
    {
        Claims claims = this.extractClaims(secret, token);

        return claimsConverter.apply(claims);
    }
}
