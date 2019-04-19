package com.org.lock;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

@Component
public class RedisTemplateLock {

    @Test
    public void setRedis() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/xml/spring-context-jedis.xml");
        RedisTemplate redisTemplate = (RedisTemplate) context.getBean("redisTemplate");
        System.out.println(redisTemplate);
        RedisCallbackImpl redisCallback = (RedisCallbackImpl) context.getBean("redisCallbackImpl");
        System.out.println(redisCallback);
        redisTemplate.execute(new RedisCallback() {
            @Override
            public Object doInRedis(RedisConnection redisConnection) throws DataAccessException {
                System.out.println(redisConnection);
                return "hello";
            }
        });
/*        String result = (String) redisTemplate.execute(redisCallback);
        System.out.println("redis结果：" + result);*/
    }
}
