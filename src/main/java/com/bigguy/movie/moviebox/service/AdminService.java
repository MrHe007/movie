package com.bigguy.movie.moviebox.service;/**
 * @Auther: hechen
 * @Date: 2019/4/15 11:03
 * @Description: ...
 */

import com.bigguy.movie.moviebox.bean.Admin;
import com.bigguy.movie.moviebox.bean.NewsItem;
import com.bigguy.movie.moviebox.bean.User;
import com.bigguy.movie.moviebox.mapper.AdminMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author hechen
 * @data 2019/4/15
 */
@Service
public class AdminService {

    @Autowired
    AdminMapper adminMapper;

    public boolean updatePassword(Admin admin, String newPass){
        return adminMapper.updateAdminPasswordById(admin, newPass);
    }

    public Integer getTotalUsers(){
        return adminMapper.findTotalUsers();
    }
    public Integer getTotalNewsItem(){
        return adminMapper.findTotalNewsItems();
    }


    public Admin login(Admin admin){
         return adminMapper.selectAdminByNameAndPassword(admin);
    }

    public List<User> getUserList(Integer start, Integer count) {
        List<User> userList = adminMapper.findUserList(start, count);
        return userList;
    }

    public List<NewsItem> getNewsItem(Integer start, Integer count){
       return adminMapper.findNewsItemList(start, count);
    }
}
