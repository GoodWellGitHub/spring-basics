package com.org.main;

import com.org.util.JedisUtil;
import java.util.Set;
import redis.clients.jedis.Jedis;

public class RedisZSet {

  public static void main(String[] args) {
    Jedis jedis = JedisUtil.createLocalJedis();
    System.out.println("连接成功");
    jedis.zadd("a", 4.45, "sed");
    jedis.zadd("a", 4.345, "abd");
    Set<String> sets = jedis.zrange("a", 0, 1);
    sets.forEach(System.out::println);
  }
}
