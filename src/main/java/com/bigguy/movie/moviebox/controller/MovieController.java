package com.bigguy.movie.moviebox.controller;

import com.bigguy.movie.moviebox.bean.Comment;
import com.bigguy.movie.moviebox.bean.User;
import com.bigguy.movie.moviebox.service.CommentService;
import com.bigguy.movie.moviebox.service.MovieListService;
import com.bigguy.movie.moviebox.service.MovieWService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author shkstart
 * @create 2019-03-10 11:26
 */
@Controller
@RequestMapping("/movie")
public class MovieController {

    @Autowired
    MovieListService movieListService;

    @Autowired
    MovieWService movieWService;

    @Autowired
    CommentService commentService;

    Logger logger = LoggerFactory.getLogger(this.getClass());


    @ResponseBody
    @RequestMapping(value = "/comment",method = RequestMethod.POST)
    public String commentMovie(Comment comment, HttpSession session){

        // 能跳转到这里，说明用户是登入的，否则会被拦截器拦截到 login 界面
        User user = (User)session.getAttribute("user");

        if(null != user){
            comment.setUser(user);
        }

        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
        String time = df.format(new Date());// new Date()为获取当前系统时间

        // 将当前时间 set 进入
        comment.setTime(time);

        commentService.saveComment(comment);

        logger.info(comment.toString());

        return "OK";

    }

    @RequestMapping(value = "/subject/{id}",method = RequestMethod.GET)
    public String goToMovieDetailPage(@PathVariable("id") Integer id, HttpServletRequest request){

        logger.info(id + "");

        request.setAttribute("id",id);          // 设置ID

        List<Comment> commentList = commentService.getCommentList(id);

        // 将评论 set 到电影评论下面列表中
        request.setAttribute("commList",commentList);

        return "movie/movie-details";
    }



}
