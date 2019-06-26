package com.bigguy.movie.moviebox.utils;/**
 * @author shkstart
 * @create 2019-03-21 14:33
 */

import com.bigguy.movie.moviebox.service.RedisService;

/**
 * @author hechen
 * @data 2019/3/21
 *
 */
public class RedisUtils {


    // 用于解决在将 *RestController 方法中的代码冗余问题

    // 传递 RedisService 实例，和准备请求网络资源的连接
    public static String getHtml(RedisService redisService , String okUrl){

        //  接收返回的数据
        String html = null;

        // 判断在redis中是否存在该链接，如果存在
        if(redisService.containsKeyHashMap(CommonConstant.MOV,okUrl)){
            html = redisService.getHashMap(CommonConstant.MOV, okUrl);
        }else {
            // redis中不存在该链接，通过网络获取数据
            html = UrlUtils.getHtml(okUrl);

            // 将获取的数据存到 Redis中
            redisService.setHashMapWithTime(CommonConstant.MOV,okUrl,html,60*60*24);
        }
        // 返回数据
        return html;
    }
}
