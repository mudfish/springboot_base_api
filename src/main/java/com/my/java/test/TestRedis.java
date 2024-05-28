package com.my.java.test;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.Connection;

public class TestRedis {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("redis://default:VVzk82edayzAYL2072qUBydmInceQXfZ@redis-11402.c265.us-east-1-2.ec2.redns.redis-cloud.com:11402");
        Connection connection = jedis.getConnection();
        jedis.set("test", "test");
    }
}