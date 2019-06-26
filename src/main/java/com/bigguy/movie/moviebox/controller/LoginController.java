package com.bigguy.movie.moviebox.controller;

import com.bigguy.movie.moviebox.message.MsgTo;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author bigguy_hc
 * @create 2019-02-17 9:48
 */
@Controller
public class LoginController {

    Logger logger = LoggerFactory.getLogger(this.getClass());



    @RequestMapping(value = "/login2",method = RequestMethod.GET)
    public String toLoginPage(){

        logger.info("login2");

        return "user/login2";
    }

    @RequestMapping(value = "/login2",method = RequestMethod.POST)
    public String doLogin(String username, String password, HttpServletRequest request){

        logger.info(username+" "+password);
        logger.info("doLogin");

        request.setAttribute("msg",new MsgTo("ok"));

        return "user/login2";
    }




}

