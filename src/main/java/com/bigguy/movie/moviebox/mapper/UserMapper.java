package com.bigguy.movie.moviebox.mapper;

import com.bigguy.movie.moviebox.bean.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author bigguy_hc
 * @create 2019-02-11 11:42
 */
@Mapper
public interface UserMapper {

    @Select("select *from tb_user")
    public List<User> selectUserList();

    @Insert("insert into tb_user (username,password,email) values (#{username},#{password},#{email})")
    boolean insertUser(User user);

    @Select("select *from tb_user where email=#{email} and password=#{password}")
    User selectUserByEmailAndPassword(@Param("email") String email, @Param("password") String password);

    // 登入时判断用户账号密码是否匹配
    @Select("select *from tb_user where username=#{username} and password=#{password}")
    User selectUserByUsernameAndPassword(@Param("username") String username, @Param("password") String password);

    // 注册用户时判断用户是否存在
    @Select("SELECT *FROM tb_user WHERE username = #{username} OR email=#{email}")
    public User isUserExistsByNameOrEmaill(@Param("username") String username,@Param("email") String email);

    @Update("update tb_user set imgUrl = #{imgUrl} where uid=#{uid}")
    boolean updateUserImg(User user);

    @Update("update tb_user set email=#{email},phone=#{phone},birthday=#{birthday} where uid=#{uid}")
    boolean updateUser(User user);

    @Select("select *from tb_user where uid=#{uid}")
    User selectUserById(Integer uid);

    @Update("update tb_user set state=0 where uid=#{uid}")
    boolean updateUserState(@Param("uid")Integer uid, @Param("state") Integer state);

    @Delete("delete from tb_user where uid=#{uid}")
    boolean deleteUserById(Integer uid);

    @Insert("INSERT INTO tb_user(username,password,email,phone,birthday) VALUES( #{username}, #{password}, #{email}, #{phone}, #{birthday})")
    boolean insertAllUserField(User user);
}
