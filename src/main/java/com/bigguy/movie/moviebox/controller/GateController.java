package com.bigguy.movie.moviebox.controller;/**
 * @Auther: hechen
 * @Date: 2019/3/28 21:07
 * @Description: ...
 */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * intro: 进行请求到页面的 controller
 * @author hechen
 * @data 2019/3/28
 */
@Controller
@RequestMapping("/page")
public class GateController {

    Logger logger = LoggerFactory.getLogger(this.getClass());
    
    @RequestMapping(value = "/{prePath}/{subPath}",method = RequestMethod.GET)
    public String toPage(@PathVariable("prePath") String prePath, @PathVariable("subPath") String subPath){

        String path = prePath +"/"+ subPath;

        logger.info(path);

        return path;

    }

    @RequestMapping(value = "/{prePath}/{subPath}.html",method = RequestMethod.GET)
    public String toPageHtml(@PathVariable("prePath") String prePath, @PathVariable("subPath") String subPath){

        String path = prePath +"/"+ subPath;

        logger.info(path);

        return path;

    }
    
}
