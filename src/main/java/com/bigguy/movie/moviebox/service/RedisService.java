package com.bigguy.movie.moviebox.service;/**
 * @author shkstart
 * @create 2019-03-21 13:42
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @author hechen
 * @data 2019/3/21
 *
 */
@Service
public class RedisService {

    @Autowired
    RedisTemplate<String,String> redisTemplate;

    // 默认的有效时间
    public static final int DEFAULT_EXPIRE = 60*60*24;

    private static final int  NOT_EXPIRE = -1;


    public boolean existsKey(String key){
        return redisTemplate.hasKey(key);
    }

    public String getKey(String key){
        return redisTemplate.opsForValue().get(key);
    }

    public void setKey(String key,String value){
        redisTemplate.opsForValue().set(key,value);
    }

    // 以秒为单位
    public void setKeyWithTime(String key,String value,long time){
        redisTemplate.opsForValue().set(key,value,60*60*24, TimeUnit.SECONDS);
    }

    public void setHashMap(String key,String field,String value){
        redisTemplate.opsForHash().put(key,field,value);
    }

    public void setHashMapWithTime(String key,String field,String value,Integer duration){
        redisTemplate.opsForHash().put(key,field,value);
        redisTemplate.expire(key,duration,TimeUnit.SECONDS);
    }


    public String getHashMap(String key,String field){
        return (String) redisTemplate.opsForHash().get(key,field);
    }

    // 判断 hashmap中是否有 key
    public boolean containsKeyHashMap(String key,String field){
        return redisTemplate.opsForHash().hasKey(key,field);
    }

}
