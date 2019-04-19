package com.org.util;

import redis.clients.jedis.JedisPoolConfig;

public class PoolConfig {
    private JedisPoolConfig config;

    private JedisPoolConfig getConfig() {
        if (config == null) {
            config = new JedisPoolConfig();
        }

        return config;
    }
}
