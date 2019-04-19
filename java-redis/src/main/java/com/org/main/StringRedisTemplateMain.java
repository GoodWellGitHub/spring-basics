package com.org.main;

import org.springframework.data.redis.core.StringRedisTemplate;

import java.util.concurrent.TimeUnit;

public class StringRedisTemplateMain {
    public static void main(String[] args){
        StringRedisTemplate redisTemplate=new StringRedisTemplate();
        redisTemplate.opsForValue().set("template","spring提供的Redis工具类",1, TimeUnit.MINUTES);
        System.out.println(redisTemplate.opsForValue().get("template"));
    }
}
