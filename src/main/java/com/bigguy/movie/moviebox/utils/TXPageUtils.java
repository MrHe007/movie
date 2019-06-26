package com.bigguy.movie.moviebox.utils;

import java.util.HashMap;

/**
 * @author bigguy_hc
 * @create 2019-05-10 22:01
 */
public class TXPageUtils {
    // 专门处理腾讯视频

    private static final String rootUrl = "https://v.qq.com/x/bu/pagesheet/list";

    // 传递偏移量和每页返回的数量
    public static String getMovieListUrl(Integer offset, Integer pageSize) {

//        String url = "https://v.qq.com/channel/movie?listpage=1&channel=movie";

        String url = "https://v.qq.com/x/bu/pagesheet/list?append=1&channel=movie&itype=100062";

        HashMap<String, String> map = new HashMap<>();
        map.put("offset",offset.toString());
        map.put("pagesize",pageSize.toString());

        return HttpUtils.parseUrlWithParams(url,map);
    }
}
