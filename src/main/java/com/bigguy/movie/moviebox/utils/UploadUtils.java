package com.bigguy.movie.moviebox.utils;/**
 * @Auther: hechen
 * @Date: 2019/4/10 18:00
 * @Description: ...
 */

import java.io.File;

/**
 * @author hechen
 * @data 2019/4/10
 */
public class UploadUtils {

    public final static String IMG_PATH_PREFIX = "/upload/imgs/";

    public static File getImgDirFile(){

        // 构建上传文件的存放路径
//        String fileDirPath = new String("src/main/resources/static/upload/imgs/");
        String fileDirPath = new String("D:/upload/");              // 将项目存放到 D 盘里面

        File fileDir = new File(fileDirPath);
        if(!fileDir.exists()){
            // 递归生成文件夹
            fileDir.mkdirs();
        }


        return fileDir;
    }

}
