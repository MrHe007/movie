package com.bigguy.movie.moviebox.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author bigguy_hc
 * @create 2019-02-16 21:06
 */
@Controller
public class RootController {

    Logger logger = LoggerFactory.getLogger(this.getClass());


//     登入成功 , 跳转到主页
    @RequestMapping(value = "/home",method = RequestMethod.POST)
    public String loginSuccess(){

        return "home";
    }

}
