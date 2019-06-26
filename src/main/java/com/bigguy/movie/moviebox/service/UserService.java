package com.bigguy.movie.moviebox.service;

import com.bigguy.movie.moviebox.bean.User;
import com.bigguy.movie.moviebox.mapper.UserMapper;
import com.bigguy.movie.moviebox.utils.CommonUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author bigguy_hc
 * @create 2019-02-11 11:50
 */
@Service
public class UserService {

    @Autowired
    UserMapper userMapper;

    Logger log = LoggerFactory.getLogger(this.getClass());


    public boolean addUser(User user){
       return userMapper.insertAllUserField(user);
    }

    public User getUser(Integer uid){
        User user = userMapper.selectUserById(uid);
        return user;
    }


    public boolean saveUser(String username,String password,boolean isEmail){
        User user = null;

        // 如果是邮箱
        user = new User( password);
        if(isEmail){
            user.setEmail(username);
        }
        user.setUsername(username);

        userMapper.insertUser(user);

       log.info("注册用户成功! "+user);

        return true;
    }

    public List<User> findUserList(){
        return userMapper.selectUserList();
    }

    public User login(String username, String password) {
        User user = null;
        if (CommonUtils.isEmail(username)){
            user = userMapper.selectUserByEmailAndPassword(username,password);
        }
            user = userMapper.selectUserByUsernameAndPassword(username, password);

        return user;

    }

    public User isUserExists(String username,String email){
        return userMapper.isUserExistsByNameOrEmaill(username,email);
    }


    public boolean updateUserImg(User user) {

        return userMapper.updateUserImg(user);

    }

    public boolean updateUserInfo(User user) {
        return userMapper.updateUser(user);
    }

    public boolean delUser(Integer id) {
        return userMapper.deleteUserById(id);
    }

    public boolean updateUserState(Integer id, Integer state) {
        return userMapper.updateUserState(id, state);
    }
}
