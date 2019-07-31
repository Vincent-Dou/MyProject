package com.dgy.utils;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Date: 2019/7/31
 * Time: 10:42
 * Author: vincent-Dou
 * Description：使用jedis数据库
 */
public class JedisUtil {
    private static JedisPool jedisPool;

    static {
        InputStream inputStream = JedisPool.class.getClassLoader().getResourceAsStream("jedis.properties");
        Properties properties = new Properties();
        try {
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }

        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxTotal(Integer.parseInt(properties.getProperty("maxTotal")));
        jedisPoolConfig.setMaxIdle(Integer.parseInt(properties.getProperty("maxIdle")));

        jedisPool = new JedisPool(jedisPoolConfig, properties.getProperty("host"), Integer.parseInt(properties.getProperty("port")));
    }

    /**
     * 获取连接
     */
    public static Jedis getJedis(){
        return jedisPool.getResource();
    }

    /**
     * 关闭连接
     */
    public void close(Jedis jedis){
        if (jedis != null){
            jedis.close();
        }
    }

    public static void main(String[] args) {
        System.out.println(getJedis().get("dgy"));
    }
}

