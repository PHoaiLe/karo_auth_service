package com.example.karo.infrastructure.services;

import com.example.karo.domain.jwt.DomainJwtKeySelection;
import com.example.karo.domain.jwt.DomainJwtService;
import com.example.karo.domain.jwt.JwtService;
import com.example.karo.domain.jwt.dto.JwtExtraClaims;
import com.example.karo.domain.jwt.dto.JwtGeneratedToken;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.UnsupportedJwtException;
import io.jsonwebtoken.security.SignatureException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class AppJwtService implements JwtService
{
    @Value(value = "${jwt.secret.token_id_prefix}")
    private String tokenIdPrefix;
    @Value(value = "${jwt.secret.access_token}")
    private String accessTokenSecret;
    @Value(value = "${jwt.secret.refresh_token}")
    private String refreshTokenSecret;
    @Value(value = "${jwt.secret.refresh_token_expired_interval}")
    private String expiredInterval;
    private DomainJwtService domainJwtService;

    public AppJwtService()
    {
        this.domainJwtService = new DomainJwtService();
    }

    private String selectKey(DomainJwtKeySelection selection)
    {
        if(selection == DomainJwtKeySelection.ACCESS_TOKEN)
        {
            return this.accessTokenSecret;
        }
        else if(selection == DomainJwtKeySelection.REFRESH_TOKEN)
        {
            return this.refreshTokenSecret;
        }

        return null;
    }

    @Override
    public JwtGeneratedToken generateToken(DomainJwtKeySelection selection, JwtExtraClaims extraClaims, long expiredInterval, String tokenIdPrefix)
    {
        String secret = selectKey(selection);
        return this.domainJwtService.generateToken(secret, extraClaims, expiredInterval, tokenIdPrefix);
    }

    @Override
    public JwtGeneratedToken generateToken(DomainJwtKeySelection selection, JwtExtraClaims extraClaims)
    {
        long castedExpiratedInterval = Long.valueOf(this.expiredInterval).longValue();
        String secret = selectKey(selection);
        return this.domainJwtService.generateToken(secret, extraClaims, castedExpiratedInterval, this.tokenIdPrefix);
    }

    @Override
    public <T extends JwtExtraClaims> T getClaims(DomainJwtKeySelection selection, String token, Function<Claims, T> claimsResolver) throws ExpiredJwtException, UnsupportedJwtException,
            MalformedJwtException, SignatureException, IllegalArgumentException
    {
        String secret = selectKey(selection);
        return this.domainJwtService.getClaims(secret, token, claimsResolver);
    }
}
