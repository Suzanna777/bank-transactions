package com.bank.web.security.storage;

import com.bank.web.security.config.TokenParameters;
import com.bank.web.security.config.redis.DefaultRedisSchema;
import com.bank.web.security.config.redis.RedisSchema;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class RedisTokenStorageImpl implements TokenStorage {


    /**
     * Pool of Redis connections.
     */
    private final JedisPool jedisPool;

    /**
     * Schema of keys for storing JWT tokens.
     */
    private final RedisSchema redisSchema;

    /**
     * Creates an object.
     *
     * @param jedisPool JedisPool object
     */
    public RedisTokenStorageImpl(final JedisPool jedisPool) {
        this.jedisPool = jedisPool;
        this.redisSchema = new DefaultRedisSchema();
    }

    /**
     * Creates an object.
     *
     * @param jedisPool   JedisPool object
     * @param redisSchema RedisSchema object
     */
    public RedisTokenStorageImpl(final JedisPool jedisPool, final RedisSchema redisSchema) {
        this.jedisPool = jedisPool;
        this.redisSchema = redisSchema;
    }

    /**
     * Creates an object.
     *
     * @param host Redis host
     * @param port Redis port
     */
    public RedisTokenStorageImpl(final String host, final int port) {
        JedisPoolConfig config = new JedisPoolConfig();
        config.setJmxEnabled(false);
        this.jedisPool = new JedisPool(
                config,
                host,
                port
        );
        this.redisSchema = new DefaultRedisSchema();
    }

    /**
     * Creates an object.
     *
     * @param host     Redis host
     * @param port     Redis port
     * @param user     Redis username
     * @param password Redis password
     */
    public RedisTokenStorageImpl(final String host, final int port, final String user, final String password) {
        JedisPoolConfig config = new JedisPoolConfig();
        config.setJmxEnabled(false);
        this.jedisPool = new JedisPool(
                config,
                host,
                port,
                user,
                password
        );
        this.redisSchema = new DefaultRedisSchema();
    }

    @Override
    public void save(final String token, final TokenParameters params) {
        try (Jedis jedis = jedisPool.getResource()) {
            String tokenKey = redisSchema.subjectTokenKey(
                    params.getSubject(),
                    params.getType()
            );
            jedis.set(
                    tokenKey,
                    token
            );
            jedis.pexpireAt(tokenKey, params.getExpiredAt().getTime());
        }
    }

    @Override
    public boolean exists(final String token, final TokenParameters params) {
        try (Jedis jedis = jedisPool.getResource()) {
            String tokenKey = redisSchema.subjectTokenKey(
                    params.getSubject(),
                    params.getType()
            );
            return token.equals(jedis.get(tokenKey));
        }
    }

    @Override
    public String get(final TokenParameters params) {
        try (Jedis jedis = jedisPool.getResource()) {
            String tokenKey = redisSchema.subjectTokenKey(
                    params.getSubject(),
                    params.getType()
            );
            return jedis.get(tokenKey);
        }
    }

    @Override
    public boolean remove(final String token) {
        try (Jedis jedis = jedisPool.getResource()) {
            String script = """
                    local keys = redis.call('keys', ARGV[1])
                    for _, key in ipairs(keys) do
                      redis.call('del', key)
                    end
                    return #keys > 0
                    """;
            Long result = (Long) jedis.eval(
                    script,
                    0,
                    "*",
                    token
            );
            return result != null && result > 0;
        }
    }

    @Override
    public boolean remove(final TokenParameters params) {
        try (Jedis jedis = jedisPool.getResource()) {
            String tokenKey = redisSchema.subjectTokenKey(
                    params.getSubject(),
                    params.getType()
            );
            return jedis.del(tokenKey) > 0;
        }
    }

}
