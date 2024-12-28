package com.bank.web.security.service;

import com.bank.web.security.config.TokenParameters;
import com.bank.web.security.storage.TokenStorage;
import com.bank.web.security.storage.TokenStorageImpl;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class PersistentTokenServiceImpl implements PersistentTokenService {
    /**
     * Secret key for verifying JWT token.
     */
    private final SecretKey key;

    /**
     * TokenStorage for accessing persistence layer.
     */
    private final TokenStorage tokenStorage;

    /**
     * Name of field in JWT token for token type.
     */
    public static final String TOKEN_TYPE_KEY = "tokenType";

    /**
     * Creates an object.
     *
     * @param secret secret of key for JWT token generation
     */
    public PersistentTokenServiceImpl(final String secret) {
        this.key = Keys.hmacShaKeyFor(secret.getBytes());
        this.tokenStorage = new TokenStorageImpl();
    }

    /**
     * Creates an object.
     *
     * @param secret       secret of key for JWT token generation
     * @param tokenStorage implementation of JWT token storage interface
     */
    public PersistentTokenServiceImpl(final String secret, final TokenStorage tokenStorage) {
        this.key = Keys.hmacShaKeyFor(secret.getBytes());
        this.tokenStorage = tokenStorage;
    }

    @Override
    public String create(final TokenParameters params) {
        String token = tokenStorage.get(params);
        if (token != null) {
            return token;
        }

        // Prepare claims
        Claims claims = Jwts.claims();
        claims.setSubject(params.getSubject());
        claims.putAll(params.getClaims());
        claims.put(TOKEN_TYPE_KEY, params.getType());

        // Generate token
        token = Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(params.getIssuedAt())
                .setExpiration(params.getExpiredAt())
                .signWith(key)
                .compact();

        tokenStorage.save(token, params);
        return token;
    }

    @Override
    public boolean isExpired(final String token) {
        return isExpired(token, new Date());
    }

    @Override
    public boolean isExpired(final String token, final Date date) {
        try {
            Jws<Claims> claims = Jwts.parserBuilder()
                    .setSigningKey(key)
                    .build()
                    .parseClaimsJws(token);
            return claims.getBody().getExpiration().before(date);
        } catch (ExpiredJwtException e) {
            return true;
        }
    }

    @Override
    public boolean has(final String token, final String key, final Object value) {
        Jws<Claims> claims = Jwts.parserBuilder()
                .setSigningKey(this.key)
                .build()
                .parseClaimsJws(token);
        return claims.getBody().get(key).equals(value);
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
        Jws<Claims> claims = Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token);
        return new HashMap<>(claims.getBody());
    }

    @Override
    public Object claim(final String token, final String key) {
        Jws<Claims> claims = Jwts.parserBuilder()
                .setSigningKey(this.key)
                .build()
                .parseClaimsJws(token);
        return claims.getBody().get(key);
    }

    @Override
    public boolean invalidate(final String token) {
        return tokenStorage.remove(token);
    }

    @Override
    public boolean invalidate(final TokenParameters params) {
        return tokenStorage.remove(params);
    }
}
