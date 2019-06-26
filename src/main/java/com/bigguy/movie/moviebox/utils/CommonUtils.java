package com.bigguy.movie.moviebox.utils;

import com.bigguy.movie.moviebox.bean.MovieListWebTO;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author bigguy_hc
 * @create 2019-02-12 16:30
 */
public class CommonUtils {

    public static final String REGEX_EMAIL = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";

    public static String parseObjToStr(MovieListWebTO obj){

        String queryStr = "?";

        queryStr += "sort="+obj.getSort();
        // 作为分页的依据
        queryStr += "&start="+obj.getStart();
        queryStr +="&range=0,10";
        queryStr +="&tags="+obj.getTags();



        // 如果有特色标签
        if(obj.getFeatures() !=null){
            queryStr +=","+obj.getFeatures();
        }

        // 如果有年代
        if (obj.getEndYear()>0){
            // 年代
            queryStr+="&year_range="+obj.getStartYear() +","+obj.getEndYear();
        }

        if(obj.getCountries()!=null){
            queryStr +="&countries="+obj.getCountries();
        }

        if(obj.getGenres()!=null){
            queryStr +="&genres="+obj.getGenres();
        }



        return queryStr;
    }

//    检查 是否是邮箱字符串
    public static boolean isEmail(String string){

        Pattern p = Pattern.compile(REGEX_EMAIL);

        Matcher matcher = p.matcher(string);
        return matcher.matches();

    }

}
