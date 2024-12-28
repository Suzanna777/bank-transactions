package com.bank.web.security.service;

import com.bank.web.security.config.TokenParameters;

import java.util.Date;
import java.util.Map;

public interface PersistentTokenService {

    /**
     * Removes JWT token from storage. Method removes all entries
     * of the same token.
     *
     * @param token JWT token to be removed
     * @return true - if JWT token was removed, false - otherwise
     */
    boolean invalidate(String token);

    /**
     * Removes JWT token from storage.
     *
     * @param params params of JWT token
     * @return true - if JWT token was removed, false - otherwise
     */
    boolean invalidate(TokenParameters params);
    boolean isExpired(String token);
    boolean isExpired(String token, Date date);
    boolean has(String token, String key,Object value);

    public String create(TokenParameters params);
    public String getSubject( String token);
    public String getType( String token);
    public Map<String, Object> claims(String token);
    public Object claim( String token,  String key);
}
