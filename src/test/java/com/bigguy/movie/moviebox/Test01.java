package com.bigguy.movie.moviebox;

import com.bigguy.movie.moviebox.utils.CommonUtils;
import org.junit.Test;

import java.io.File;
import java.io.UnsupportedEncodingException;

/**
 * @author bigguy_hc
 * @create 2019-02-12 16:34
 */
public class Test01 {

    @Test
    public void testStringEncode() throws UnsupportedEncodingException {

        String s = "jfdk！@";

        System.out.println(new String(s.getBytes()));

    }


    @Test
    public void testFileUpload(){


        // D:\IDEAPro\movie-box-master\src\main\resources

        File file = new File("src/main/resources/upload/imgs/");

        if(!file.exists()){
            file.mkdirs();
        }

        System.out.println(file.getAbsolutePath());


    }




    @Test
    public void testEmail(){

        String[] str1 = {"aaa@","aa.b@qq.com","1123@163.com","113fe$@11.com","han. @sohu.com.cn","han.c@sohu.com.cn.cm.cm",
                           "155709904@163.com" };


        Object o = new Object();

        System.out.println("o = " + o);

        System.out.println("fdsa");

        for (String s:str1){
            System.out.println(s+"  "+CommonUtils.isEmail(s));
        }

    }

}
