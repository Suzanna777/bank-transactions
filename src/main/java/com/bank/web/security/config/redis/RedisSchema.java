package com.bank.web.security.config.redis;

public interface RedisSchema {

    /**
     * Redis key for JWT token to be stored with.
     *
     * @param subject "sub" of JWT token
     * @param type    token type
     * @return Redis key
     */
    String subjectTokenKey(
            String subject,
            String type
    );


}
