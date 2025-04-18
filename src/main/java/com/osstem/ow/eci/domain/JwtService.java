package com.osstem.ow.eci.domain;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.security.Signature;
import java.time.Instant;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class JwtService {
    private static final String key = "my-very-secret-secret-key-1234567890";
    private final JwtProperties jwtProperties;
    private SecretKey secretKey;

    public JwtService(JwtProperties jwtProperties) {
        this.jwtProperties = jwtProperties;
        this.secretKey = new SecretKeySpec(key.getBytes(), SignatureAlgorithm.HS256.getJcaName() );
    }

    public String issueAccessToken(String id, String password) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("id", id);
        claims.put("password", password);
        Instant now = Instant.now();
        Instant expired = now.plusSeconds(jwtProperties.accessExpirationTime());
        return generateToken("id", now, expired, claims);
    }

    public SessionRequest parseToken(String token) {
        Claims claims = Jwts.parser()
                .verifyWith(secretKey)
                .build()
                .parseSignedClaims(token)
                .getPayload();
        String id = claims.get("id", String.class);
        String pw = claims.get("password", String.class);
        return new SessionRequest(id, pw);
    }

    private String generateToken(String id, Instant issuedAt, Instant expiresAt, Map<String, Object> claims) {
        JwtBuilder jwtBuilder = Jwts.builder()
                .subject(id)
                .issuedAt(Date.from(issuedAt))
                .expiration(Date.from(expiresAt));

        if(claims != null) {
            jwtBuilder.claims(claims);
        }
        return jwtBuilder
                .signWith(secretKey)
                .compact();

    }
}
