package com.org.main;

import com.org.util.JedisUtil;
import redis.clients.jedis.Jedis;

public class RedisStringJava {

  public static void main(String[] args) {
    Jedis jedis = JedisUtil.createLocalJedis();
    System.out.println("jedis连接成功");
    jedis.set("hello", "world");
    System.out.println("存储的数据：" + jedis.get("hello"));
  }
}
