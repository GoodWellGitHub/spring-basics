package com.org.main;

import com.org.util.JedisUtil;
import redis.clients.jedis.Jedis;

public class RedisJava {

  public static void main(String[] args) {
    Jedis jedis = JedisUtil.createLocalJedis();
    System.out.println("连接成功");
    System.out.println("服务正在运行：" + jedis.ping());
  }

}
