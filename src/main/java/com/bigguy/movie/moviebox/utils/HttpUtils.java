package com.bigguy.movie.moviebox.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * @author bigguy_hc
 * @create 2019-05-10 22:04
 */
public class HttpUtils {

    // 访问http的一些工具类

    public static String parseUrlWithParams(String url, Map<String,String> map){

        if(map.size()<=0){
            return url;
        }
        for(Map.Entry<String,String> entry : map.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();

            url +="&" + key + "=" +value;

        }
        return url;
    }

    public static void main(String[] args) {

        Map<String,String> map = new HashMap<>();
        map.put("name","jeck");
        map.put("hello","23");

        String url = "www.baidu.com";

        String s = HttpUtils.parseUrlWithParams(url, map);
        System.out.println(s);

    }

}
