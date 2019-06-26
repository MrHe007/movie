package com.bigguy.movie.moviebox.controller;/**
 * @Auther: hechen
 * @Date: 2019/3/28 21:02
 * @Description: ...
 */

import com.bigguy.movie.moviebox.bean.NewsItem;
import com.bigguy.movie.moviebox.service.NewsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

/**
 * @author hechen
 * @data 2019/3/28
 */
@Controller
@RequestMapping("/news")
    public class NewsController {

    @Autowired
    NewsService newsService;



    Logger logger = LoggerFactory.getLogger(this.getClass());




    /*
         * @Author hechen
         * @Description //跳转到新闻的详细页面
         * @Date 16:29 2019/3/31
         * @Param [id]
         * @return java.lang.String
         **/

    @RequestMapping(value ="news-details/{id}",method = RequestMethod.GET)
    public String toNewsItemPage(@PathVariable("id") Integer id, HttpServletRequest request){
        logger.info("user -> 跳转到 news-details.html ");

        request.setAttribute("isAdminRole",false);

        NewsItem newsItem = newsService.getNewsItem(id);

        request.setAttribute("newsItem", newsItem);


        return "news/news-details";
    }



    /*
         * @Author hechen
         * @Description 新闻页面的分页查询
         * @Date 14:15 2019/3/31
         * @Param [start, end]
         * @return java.lang.String
         **/
    @RequestMapping(value = "/news-list",method = RequestMethod.GET)
    public String showNewsList(HttpServletRequest request){

        logger.info("admin/news-list : admin 查看 news-list");

        //  news-list.html 是否展示公共界面的变量
        request.setAttribute("isAdmin",false);

        // 设置数据总数
        request.setAttribute("count",newsService.getNewsCount());


        return "/news/news-list";
    }

}
