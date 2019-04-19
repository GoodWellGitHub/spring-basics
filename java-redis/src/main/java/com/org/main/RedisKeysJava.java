package com.org.main;

import com.org.util.JedisUtil;
import java.util.Set;
import redis.clients.jedis.Jedis;

public class RedisKeysJava {

  public static void main(String[] args) {
    Jedis jedis= JedisUtil.createLocalJedis();
    System.out.println("连接成功");
    Set<String> keys=jedis.keys("*");
    keys.forEach(System.out::println);
  }
}
