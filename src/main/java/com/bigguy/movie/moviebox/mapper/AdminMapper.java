package com.bigguy.movie.moviebox.mapper;/**
 * @Auther: hechen
 * @Date: 2019/4/15 11:04
 * @Description: ...
 */

import com.bigguy.movie.moviebox.bean.Admin;
import com.bigguy.movie.moviebox.bean.NewsItem;
import com.bigguy.movie.moviebox.bean.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * @author hechen
 * @data 2019/4/15
 */
@Mapper
public interface AdminMapper {

    @Select("select *from admin where aname=#{aname} and apassword=#{apassword}")
    public Admin selectAdminByNameAndPassword(Admin admin);

    @Update("update admin set apassword=#{newPass} where aid=#{admin.aid}")
    public boolean updateAdminPasswordById(@Param("admin") Admin admin, @Param("newPass") String newPass);

    // 拿到所有用户的总数
    @Select("SELECT COUNT(*) FROM tb_user")
    public Integer findTotalUsers();

    // 用户列表分页
    @Select("SELECT *FROM tb_user LIMIT #{start},#{count} ")
    List<User> findUserList(@Param("start") Integer start, @Param("count") Integer count);

    // 拿到新闻总数
    @Select("SELECT COUNT(*) news_item")
    public Integer findTotalNewsItems();

    // 新闻列表分列
    @Select("SELECT *FROM news_item LIMIT #{start},#{count}")
    public List<NewsItem> findNewsItemList(@Param("start") Integer start, @Param("count") Integer count);

}
