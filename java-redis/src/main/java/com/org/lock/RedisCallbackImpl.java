package com.org.lock;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import redis.clients.jedis.JedisCommands;

public class RedisCallbackImpl implements RedisCallback {
    private static final Logger logger = LoggerFactory.getLogger(RedisCallbackImpl.class);

    @Autowired
    @Override
    public Object doInRedis(RedisConnection redisConnection) throws DataAccessException {
        JedisCommands jedisCommands = (JedisCommands) redisConnection.getNativeConnection();
        String lock = jedisCommands.set("order_lock_001", "uu9id", "NX", "EX", 10);
        logger.info("redis加锁返回：" + lock);
        return lock;
    }
}
