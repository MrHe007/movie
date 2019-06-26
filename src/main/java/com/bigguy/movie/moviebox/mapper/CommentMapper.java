package com.bigguy.movie.moviebox.mapper;/**
 * @Auther: hechen
 * @Date: 2019/4/8 17:12
 * @Description: ...
 */

import com.bigguy.movie.moviebox.bean.Comment;
import com.bigguy.movie.moviebox.dto.CommentRespDto;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author hechen
 * @data 2019/4/8
 */
@Mapper
public interface CommentMapper {

    //
    @Delete("delete from comment where id=#{id}")
    public Boolean delCommentById(Integer id);

    @Update("update comment set state=#{state} where id=#{id}")
    public Boolean updateCommentStateById(@Param("id")Integer id, @Param("state") Integer state);

    // 拿到总的评论数
    @Select("SELECT COUNT(*) FROM COMMENT ")
    public Integer getCommentCount();

    @Insert("insert into comment(score,content,mid,uid,time) values(#{score},#{content},#{mid},#{user.uid},#{time} )")
    public boolean addComment(Comment comment);

    @Select("select *from comment where mid=#{id}")
    public List<Comment> getCommentListByID(Integer id);


    // 通过电影 id 查出所有的评论
    public List<Comment> selectCommentListByMovieId(Integer mid);

    List<CommentRespDto> selectCommentList(@Param("start") Integer start, @Param("limit") Integer limit);
}
