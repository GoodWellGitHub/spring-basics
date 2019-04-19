package com.org.util;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.redis.core.RedisTemplate;
import redis.clients.jedis.Jedis;

public class JedisUtil {

    public static Jedis createLocalJedis() {
        Jedis jedis = new Jedis(PropertiesUtil.propertiesValue("jedisurl"));
        return jedis;
    }

    public static <K,V> RedisTemplate<K,V> getRedisTemplate() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/xml/spring-context-jedis.xml");
        RedisTemplate<K,V> template = context.getBean("redisTemplate", RedisTemplate.class);
        return template;
    }

    public static <K,V> RedisTemplate<K,V> getRedisTemplate1() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/xml/spring-context-jedis.xml");
        RedisTemplate<K,V> template = context.getBean("redisTemplate1", RedisTemplate.class);
        return template;
    }

}
