package com.bigguy.movie.moviebox.message;/**
 * @Auther: hechen
 * @Date: 2019/4/20 10:15
 * @Description: ...
 */

import java.io.Serializable;

/**
 * @author hechen
 * @data 2019/4/20
 */
public class BaseMsg implements Serializable {

    public static final long serialVersionUID = -8293670734331124616L;

    // 登入相关信息

    public static final String LOGIN_UNKNOW_ERR = "未知异常";

    public static final String LOGIN_PASSWORD_ERR = "密码错误";

    public static final String LOGIN_SUCCESS = "登入成功";

    public static final String UPDATE_UPASSWORD = "修改密码成功";





}
