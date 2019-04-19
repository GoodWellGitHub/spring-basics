package com.org.service;

import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;

public class RedisMessageListener implements MessageListener {
    private RedisTemplate<String, String> redisTemplate;

    public RedisTemplate<String, String> getRedisTemplate() {
        return redisTemplate;
    }

    public void setRedisTemplate(RedisTemplate<String, String> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @Override
    public void onMessage(Message message, byte[] bytes) {
        RedisSerializer<?> redisSerializer=redisTemplate.getValueSerializer();
        Object channel=redisSerializer.deserialize(message.getChannel());
        Object body=redisSerializer.deserialize(message.getBody());
        System.out.println("主题："+channel);
        System.out.println("内容："+body);

    }
}
