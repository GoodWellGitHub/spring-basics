package com.org.main;

import com.org.util.JedisUtil;
import java.util.List;
import redis.clients.jedis.Jedis;

public class RedisListJava {

  public static void main(String[] args) {
    Jedis jedis = JedisUtil.createLocalJedis();
    System.out.println("连接成功");
    jedis.lpush("site-list", "www.baidu.com");
    jedis.lpush("site-list", "www.google.com");
    jedis.lpush("site-list", "www.alibaba.com");
    List<String> sites = jedis.lrange("site-list", 0, 2);
    sites.forEach(System.out::println);
  }

}
