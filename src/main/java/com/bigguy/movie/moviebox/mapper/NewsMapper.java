package com.bigguy.movie.moviebox.mapper;/**
 * @Auther: hechen
 * @Date: 2019/3/29 14:36
 * @Description: ...
 */

import com.bigguy.movie.moviebox.bean.NewsItem;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author hechen
 * @data 2019/3/29
 */
public interface NewsMapper {

    @Insert("insert into news_item(img_url,title,content,simple_text,date) values(#{imgUrl},#{title},#{content},#{simpleText},#{date} )")
    public boolean addNewsItem(NewsItem newsItem);

    @Select("SELECT  id,img_url imgUrl,title ,content,simple_text simpleText,date,view_count viewCount FROM news_item LIMIT #{start},#{end}")
    public List<NewsItem> selectNewsListByPage(@Param("start") int start,@Param("end") int end);

    @Select("SELECT  id,img_url imgUrl,title ,content,simple_text simpleText,view_count viewCount,date FROM news_item where id = #{id}")
    public NewsItem selectNewsItemById(Integer id);

    @Select("SELECT COUNT(*) FROM news_item")
    public Integer getNewsCount();

    @Update("update news_item set img_url=#{imgUrl},title=#{title},simple_text=#{simpleText},content=#{content},date=#{date} where id=#{id} ")
    boolean updateNewsItem(NewsItem newsItem);

    @Delete("delete from news_item where id = #{id}")
    public boolean deleteNewsItemById(Integer id);

}
