package com.bank.web.security.service;

import com.bank.web.security.config.TokenParameters;
import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class TokenServiceImpl implements TokenService {

    /**
     * Secret key for verifying JWT token.
     */
    private final SecretKey key;

    /**
     * Name of field in JWT token for its type.
     */
    public static final String TOKEN_TYPE_KEY = "tokenType";

    /**
     * Creates an object.
     *
     * @param secret secret of key for JWT token generation
     */
    public TokenServiceImpl(final String secret) {
        this.key = Keys.hmacShaKeyFor(secret.getBytes());
    }

    @Override
    public String create(final TokenParameters params) {
        Map<String, Object> claims = new HashMap<>(params.getClaims());
        claims.put(TOKEN_TYPE_KEY, params.getType());

        return Jwts.builder()
                .setSubject(params.getSubject())
                .setClaims(claims)
                .setIssuedAt(params.getIssuedAt())
                .setExpiration(params.getExpiredAt())
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();
    }

    @Override
    public boolean isExpired(final String token) {
        try {
            Jwts.parserBuilder()
                    .setSigningKey(key)
                    .build()
                    .parseClaimsJws(token);
            return false;
        } catch (ExpiredJwtException e) {
            return true;
        }
    }

    @Override
    public boolean isExpired(final String token, final Date date) {
        try {
            Claims claims = Jwts.parserBuilder()
                    .setSigningKey(key)
                    .build()
                    .parseClaimsJws(token)
                    .getBody();
            return claims.getExpiration().before(date);
        } catch (ExpiredJwtException e) {
            return true;
        }
    }

    @Override
    public boolean has(final String token, final String key, final Object value) {
        Claims claims = Jwts.parserBuilder()
                .setSigningKey(this.key)
                .build()
                .parseClaimsJws(token)
                .getBody();
        return value.equals(claims.get(key));
    }

    @Override
    public String getSubject(final String token) {
        return Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }

    @Override
    public String getType(final String token) {
        return Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody()
                .get(TOKEN_TYPE_KEY, String.class);
    }

    @Override
    public Map<String, Object> claims(final String token) {
        Claims claims = Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody();
        return new HashMap<>(claims);
    }

    @Override
    public Object claim(final String token, final String key) {
        Claims claims = Jwts.parserBuilder()
                .setSigningKey(this.key)
                .build()
                .parseClaimsJws(token)
                .getBody();
        return claims.get(key);
    }
}
