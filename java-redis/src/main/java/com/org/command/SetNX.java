package com.org.command;

import com.org.util.JedisUtil;
import redis.clients.jedis.Jedis;

public class SetNX {
    public static void main(String[] args) {
        Jedis jedis = JedisUtil.createLocalJedis();
        System.out.println("jedis -- "+jedis.toString());
        long status = jedis.setnx("nx", "nxvalue");
        System.out.println("插入数据返回结果 " + status);
        if (status > 0) {
            long expire = jedis.expire("nx", 200);
            System.out.println("设置nx过期时间结果 " + expire);
        }
    }
}
