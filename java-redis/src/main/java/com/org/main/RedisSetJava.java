package com.org.main;

import com.org.util.JedisUtil;
import java.util.Set;
import redis.clients.jedis.Jedis;

public class RedisSetJava {

  public static void main(String[] args) {
    Jedis jedis = JedisUtil.createLocalJedis();
    System.out.println("连接成功");
    jedis.sadd("a*", "bb");
    jedis.sadd("a*", "cc");
    jedis.sadd("a*", "bb");
    Set<String> keya = jedis.smembers("a*");
    keya.forEach(System.out::println);
  }
}
