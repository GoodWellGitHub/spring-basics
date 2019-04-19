package com.org.main;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.org.domain.Student;
import com.org.util.JedisUtil;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class SpringJedisMain {

    /**
     * java中redis字符串常用API
     */
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/xml/spring-context-jedis.xml");
        final RedisTemplate<String, Object> redisTemplate = context.getBean("redisTemplate", RedisTemplate.class);
        System.out.println("first:" + redisTemplate.opsForValue().get("tom"));
        redisTemplate.opsForValue().set("tom", "boy", 10, TimeUnit.SECONDS);
        System.out.println("1:" + redisTemplate.opsForValue().get("tom"));
        try {
            Thread.sleep(9995);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("2:" + redisTemplate.opsForValue().get("tom"));
    }

    @Test
    public void testoverWrite() {
        RedisTemplate<String, Object> redisTemplate = JedisUtil.getRedisTemplate();
        redisTemplate.opsForValue().set("a", "123456789");
        redisTemplate.opsForValue().set("a", "3333", 5);
        String str = (String) redisTemplate.opsForValue().get("a");
        System.out.println(redisTemplate.opsForValue().get("a"));
    }

    @Test
    public void multiset() {
        Map<String, String> stringMap = new HashMap<>();
        stringMap.put("aa", "林黛玉");
        stringMap.put("bb", "薛宝钗");
        stringMap.put("cc", "gg");
        RedisTemplate template = JedisUtil.getRedisTemplate();
        template.opsForValue().multiSet(stringMap);
        List<String> keyList = new ArrayList<>();
        keyList.add("aa");
        keyList.add("cc");
        System.out.println(template.opsForValue().multiGet(keyList));
    }

    @Test
    public void getAndSet() {
        RedisTemplate template = JedisUtil.getRedisTemplate();
        template.opsForValue().set("key1", "你好");
        String str = (String) template.opsForValue().getAndSet("key1", "hello");
        System.out.println(str);
    }

    @Test
    public void increment() {
        RedisTemplate template = JedisUtil.getRedisTemplate();
        template.opsForValue().increment("num", 1);
        System.out.println(template.opsForValue().get("num"));
    }

    @Test
    public void append() {
        RedisTemplate template = JedisUtil.getRedisTemplate();
        template.opsForValue().append("good", "hello");
        System.out.println(template.opsForValue().get("good"));
        template.opsForValue().append("good", "world");
        System.out.println(template.opsForValue().get("good"));
    }

    @Test
    public void getSubString() {
        RedisTemplate template = JedisUtil.getRedisTemplate();
        System.out.println(template.opsForValue().get("good"));
        System.out.println(template.opsForValue().get("good", 2, 4));
        System.out.println(template.opsForValue().get("good", 0, -1));
        System.out.println(template.opsForValue().get("good", -4, -2));
    }

    @Test
    public void getSize() {
        RedisTemplate template = JedisUtil.getRedisTemplate();
        long size = template.opsForValue().size("good");
        System.out.println(size);
    }

    @Test
    public void setBit() {
        RedisTemplate template = JedisUtil.getRedisTemplate();
        template.opsForValue().set("bit", "a");
        System.out.println(template.opsForValue().get("bit"));
        template.opsForValue().setBit("bit", 6, true);
        template.opsForValue().setBit("bit", 7, false);
        System.out.println(template.opsForValue().get("bit"));
    }

    @Test
    public void getBit() {
        RedisTemplate template = JedisUtil.getRedisTemplate();
        System.out.println(template.opsForValue().getBit("bit", 6));
    }

    /**
     * javalist集合常用API
     */
    @Test
    public void listRange() {
        RedisTemplate redisTemplate = JedisUtil.getRedisTemplate();
        redisTemplate.opsForList().leftPush("keylist1", "aa");
        redisTemplate.opsForList().leftPush("keylist1", "cc");
        redisTemplate.opsForList().leftPush("keylist1", "dd");
        System.out.println(redisTemplate.opsForList().range("keylist1", 0, 10));
    }

    @Test
    public void trim() {
        RedisTemplate template = JedisUtil.getRedisTemplate();
        System.out.println(template.opsForList().range("keylist1", 0, -1));
        template.opsForList().trim("keylist1", 2, 3);
        System.out.println(template.opsForList().range("keylist1", 0, -1));
    }

    @Test
    public void listSize() {
        RedisTemplate template = JedisUtil.getRedisTemplate();
        System.out.println(template.opsForList().size("keylist1"));
    }

    @Test
    public void pushAll() {
        RedisTemplate template = JedisUtil.getRedisTemplate();
        String[] args = {"林黛玉", "薛宝钗", "戴宗"};
        template.opsForList().leftPushAll("keylist1", args);
        System.out.println(template.opsForList().range("keylist1", 0, -1));
    }

    @Test
    public void pushifPresent() {
        RedisTemplate template = JedisUtil.getRedisTemplate();
        System.out.println(template.opsForList().leftPushIfPresent("keylist2", "aa"));
        System.out.println(template.opsForList().leftPushIfPresent("keylist2", "bb"));
        System.out.println(template.opsForList().leftPush("keylist2", "aa"));
        System.out.println(template.opsForList().leftPushIfPresent("keylist2", "bb"));
    }

    @Test
    public void pushleftValuePush() {
        RedisTemplate template = JedisUtil.getRedisTemplate();
        System.out.println(template.opsForList().leftPush("keylist2", "aa", "cc"));
    }

    /**
     * java中redis的hash操作api
     */
    @Test
    public void hashput() {
        RedisTemplate template = JedisUtil.getRedisTemplate();
        template.opsForHash().put("hash1", "key1", "value1");
        template.opsForHash().put("hash1", "name", "林黛玉");
        template.opsForHash().put("hash1", "age", "18");
        template.opsForHash().put("hash1", "sex", "woman");
        System.out.println(template.opsForHash().get("hash1", "name"));
    }

    @Test
    public void template() {
        Student student = new Student();
        List<Student> students = student.getStudentList();
        RedisTemplate<String,String> redisTemplate=JedisUtil.getRedisTemplate();
        boolean yy=redisTemplate.opsForValue().setIfAbsent("contentI","kk");
        RedisTemplate<String,String> redisTemplate1=JedisUtil.getRedisTemplate1();
        boolean mm=redisTemplate1.opsForValue().setIfAbsent("contentI","kk");
        System.out.println(yy);
        System.out.println(mm);
        //redisTemplate.opsForList().leftPush("student",student);
        //redisTemplate.opsForList().pop
       // redisTemplate.opsForList().leftPush("student",JSON.toJSONString(students.get(1)));
      //  System.out.println(redisTemplate.opsForList().leftPop(student).getClass());
    }
}
