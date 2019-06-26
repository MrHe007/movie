package com.bigguy.movie.moviebox.controller;/**
 * @author shkstart
 * @create 2019-03-20 10:55
 */

import com.bigguy.movie.moviebox.bean.User;
import com.bigguy.movie.moviebox.message.MsgTo;
import com.bigguy.movie.moviebox.resource.MovieUrlProperties;
import com.bigguy.movie.moviebox.service.RedisService;
import com.bigguy.movie.moviebox.service.UserService;
import com.bigguy.movie.moviebox.utils.RedisUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author hechen
 * @data 2019/3/20
 *
 */

@RestController
@RequestMapping("/api")
public class CommonRestController {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    MovieUrlProperties movieUrlProperties;

    @Autowired
    RedisService redisService;

    @Autowired
    UserService userService;



    // 通过ID删除用户 , 发送 DELETE 请求
    @ResponseBody
    @RequestMapping(value = "/user/del/{id}")
    public MsgTo delUser(@PathVariable("id") Integer id) {
        logger.info("del : "+id);
        boolean flag = userService.delUser(id);

        return new MsgTo("delete user : "+id);
    }

    // 通过ID禁用用户
    @ResponseBody
    @RequestMapping(value = "/user/put/{id}")
    public MsgTo updateUserState(@PathVariable("id") Integer id, Integer state) {
        logger.info("updateState : "+id);
        boolean flag = userService.updateUserState(id, state);
        return new MsgTo("forbid user ,id: "+id);
    }


    // 通过ID拿到 usr
    @ResponseBody
    @RequestMapping("/user/{id}.json")
    public User getUser(@PathVariable("id") Integer id) {

        User user = userService.getUser(id);
        return user;
    }

    @ResponseBody
    @RequestMapping("/celebrity/{id}.json")
    public String toCelebrityPage(@PathVariable("id") Integer id){

        String celebrityUrl = movieUrlProperties.getCelebrityUrl();

        String okUrl = celebrityUrl + id + movieUrlProperties.getSuffix();

        logger.info("celebrity id : "+okUrl);


        return RedisUtils.getHtml(redisService, okUrl);
    }

}
