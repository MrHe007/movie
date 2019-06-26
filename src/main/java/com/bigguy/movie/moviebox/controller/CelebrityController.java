package com.bigguy.movie.moviebox.controller;

import com.bigguy.movie.moviebox.service.CelebrityWService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author shkstart
 * @create 2019-03-18 14:50
 */
@RequestMapping("/celebrity")
@Controller
public class CelebrityController {

    @Autowired
    CelebrityWService wService;

    @RequestMapping("/{id}")
    public String goToCelebrityPage(@PathVariable("id") int id, Model model){

        Logger logger = LoggerFactory.getLogger(this.getClass());
        logger.info("celebrity: "+id);


//        Celebrity celebrity = wService.getCelebrityById(id);

//        model.addAttribute("man",celebrity);

//        logger.info(celebrity.toString());

        return "/celebrity/celebrity";
    }


}
