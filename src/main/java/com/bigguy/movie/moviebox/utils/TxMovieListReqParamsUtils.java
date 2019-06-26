package com.bigguy.movie.moviebox.utils;

import com.bigguy.movie.moviebox.dto.TxMovieListReqParamsDto;

/**
 * @author bigguy_hc
 * @create 2019-05-11 9:12
 */
public class TxMovieListReqParamsUtils {

    // 拼接请求参数
    public static String parseParam(TxMovieListReqParamsDto paramsDto){

//        String url = "https://v.qq.com/x/bu/pagesheet/list?append=5&channel=movie&itype=100062&offset=90&pagesize=30&itype=100022";

        //  假设请求rootUrl = https://v.qq.com/x/bu/pagesheet/list?append=1&channel=movie
        // 拼接字符串类型如：&offset=30&pagesize=30

        StringBuilder sb = new StringBuilder();

        // 排序
        if(paramsDto.getSort()!=null){
            sb.append("&sort=");
            sb.append(paramsDto.getSort());
        }

        // 地区
        if(paramsDto.getIarea()!=null){
            sb.append("&iarea=");
            sb.append(paramsDto.getIarea());
        }

        // 特色
        if(paramsDto.getCharacteristic()!=null){
            sb.append("&characteristic=");
            sb.append(paramsDto.getCharacteristic());
        }

        // 年份
        if(paramsDto.getYear()!=null){
            sb.append("&year=");
            sb.append(paramsDto.getYear());
        }

        // 资费
        if(paramsDto.getCharge()!=null){
            sb.append("&charge=");
            sb.append(paramsDto.getCharge());
        }

        // 类型
        if(paramsDto.getItype()!=null){
            sb.append("&itype");
            sb.append(paramsDto.getItype());
        }

        // 分页
        if(paramsDto.getOffset()!=null){
            sb.append("&offset=");
           sb.append(paramsDto.getOffset());
        }
        if(paramsDto.getPagesize()!=null){
            sb.append("&pagesize=");
            sb.append(paramsDto.getPagesize());
        }

        return sb.toString();
    }
}
