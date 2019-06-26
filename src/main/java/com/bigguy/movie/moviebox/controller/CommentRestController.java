package com.bigguy.movie.moviebox.controller;/**
 * @Auther: hechen
 * @Date: 2019/4/8 19:36
 * @Description: ...
 */

import com.bigguy.movie.moviebox.bean.Comment;
import com.bigguy.movie.moviebox.dto.CommentRespDto;
import com.bigguy.movie.moviebox.dto.CommentTableRespDto;
import com.bigguy.movie.moviebox.message.MsgTo;
import com.bigguy.movie.moviebox.service.CommentService;
import com.bigguy.movie.moviebox.service.NewPublicApiService;
import com.bigguy.movie.moviebox.service.UserService;
import com.bigguy.movie.moviebox.spider.MovieSpider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author hechen
 * @data 2019/4/8
 */
@RestController
@RequestMapping("/comment")
public class CommentRestController {

    Logger logger = LoggerFactory.getLogger(CommentRestController.class);

    @Autowired
    CommentService commentService;

    @Autowired
    MovieSpider movieSpider;

    @Autowired
    UserService userService;

    @Autowired
    NewPublicApiService publicApiService;

    @RequestMapping("/update/{id}")
    public MsgTo updateCommentState(@PathVariable Integer id, Integer state){

        logger.info(String.format("update comment state , id=%d, state=%d ",id, state));

        commentService.updateCommentState(id, state);
        return new MsgTo("ok");
    }


    // 根据ID删除
    @RequestMapping("/del/{id}")
    public MsgTo delComment(@PathVariable Integer id){
        logger.info(String.format("del comment , id=%d ",id));

        commentService.delComment(id);

        return new MsgTo("ok");
    }


    //分页 拿到所有的评论列表
    @RequestMapping(value = "get/list",method = RequestMethod.GET)
    public CommentTableRespDto getCommentList(Integer page, Integer limit){

        logger.info( String.format("/get/list: page=%s, limit=%s",page,limit) );

        CommentTableRespDto tableRespDto = new CommentTableRespDto();

        Integer commentCount = commentService.getCommentCount();

        List<CommentRespDto> commentList = commentService.getCommentList((page-1)*limit, limit);

        for (CommentRespDto commentRespDto : commentList) {         // 轮询设置爬虫电影，仅仅是为了拿到电影名
            commentRespDto.setMovieName(publicApiService.getMovieRespDtoById(commentRespDto.getMid()).getName());
            commentRespDto.setUserName( userService.getUser(commentRespDto.getUid()).getUsername() );
        }

        tableRespDto.setData(commentList);
        tableRespDto.setCount(commentCount);
        return tableRespDto;
    }



    // 根据电影ID拿导评论列表
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public List<Comment> commentList(@PathVariable("id") Integer id){

        List<Comment> commentList = commentService.getCommentList(id);

        return commentList;
    }


}
