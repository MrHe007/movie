package com.bigguy.movie.moviebox.service;/**
 * @Auther: hechen
 * @Date: 2019/4/8 17:14
 * @Description: ...
 */

import com.bigguy.movie.moviebox.bean.Comment;
import com.bigguy.movie.moviebox.dto.CommentRespDto;
import com.bigguy.movie.moviebox.mapper.CommentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author hechen
 * @data 2019/4/8
 */
@Service
public class CommentService {

    @Autowired
    CommentMapper commentMapper;

    // 根据ID删除评论
    public boolean delComment(Integer id){
        return commentMapper.delCommentById(id);
    }

    // 根据ID修改用户是是否禁掉标志
    public boolean updateCommentState(Integer id, Integer state){
        return commentMapper.updateCommentStateById(id,state);
    }

    // 拿到评论总数
    public Integer getCommentCount(){
        return commentMapper.getCommentCount();
    }

    // 分页拿到评论列表数据
    public List<CommentRespDto> getCommentList(Integer start, Integer limit){
        return commentMapper.selectCommentList(start,limit);
    }

    // 保存评论
    public boolean saveComment(Comment comment){
        return commentMapper.addComment(comment);
    }

    // 通过电影 id 拿到评论列表
    public List<Comment> getCommentList(Integer mid){
        return commentMapper.selectCommentListByMovieId(mid);
    }

}
