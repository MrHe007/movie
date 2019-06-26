package com.bigguy.movie.moviebox.controller;

import com.bigguy.movie.moviebox.bean.User;
import com.bigguy.movie.moviebox.message.MsgTo;
import com.bigguy.movie.moviebox.service.UserService;
import com.bigguy.movie.moviebox.utils.CommonUtils;
import com.bigguy.movie.moviebox.utils.UploadUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * @author bigguy_hc
 * @create 2019-02-11 11:51
 */
@RequestMapping("/user")
@Controller
public class UserController {

    @Autowired
    UserService userService;

    Logger logger = LoggerFactory.getLogger(this.getClass());





    @RequestMapping(value = "/", method = RequestMethod.PUT)
    public String updatePassword(User user,String rePass){



//        userService.updateUserPass(user,rePass);

        return "";
    }


    @RequestMapping(value = "/edit",method = RequestMethod.POST)
    public String edit(User user,HttpSession session){
        // 在 user-info.html 中有一个隐藏域
        userService.updateUserInfo(user);
        // 更新session 中的user
        User newUser  = userService.getUser(user.getUid());
        session.setAttribute("user",newUser);

        return "/user/user-info";
    }



    @ResponseBody
    @RequestMapping("/upload")
    public MsgTo upload(@RequestParam("imgFile")MultipartFile imgFile, HttpServletRequest request, HttpSession session){


        Object userObj = session.getAttribute("user");
        User user = null;

        // 如果此时用户登入了，将图片地址放到
        if(session.getAttribute("user")!=null && userObj instanceof User ){
            user = (User) userObj;
        }


        MsgTo msg = new MsgTo();
        if (imgFile.isEmpty()) {
            // 设置错误状态码
            msg.setCode(500);
            msg.setMsg("上传失败，请选择文件");
            return msg;
        }


        // 拿到文件名
        String filename = imgFile.getOriginalFilename();

        // 更新用户图片地址
        if(null!=user){
            user.setImgUrl(UploadUtils.IMG_PATH_PREFIX + filename);
        }
        // service 更新用户图片地址
        userService.updateUserImg(user);


        File fileDir = UploadUtils.getImgDirFile();
        System.out.println(fileDir.getAbsolutePath());

        // 获取容器实际根路径地址
//        String realPath=request.getSession().getServletContext().getRealPath("/");

//        File fileDir = new File(realPath,UploadUtils.IMG_PATH_PREFIX);


        logger.info("absolute : " + fileDir.getAbsolutePath());

        try {
            // 文件上传

            File newFile = new File(fileDir.getAbsolutePath() + File.separator + filename);
            System.out.println(newFile.getAbsolutePath());

            imgFile.transferTo(newFile);


            msg.setMsg("上传成功!");
        } catch (IOException e) {
            e.printStackTrace();
        }

        return msg;
    }





    /*
         * @Author hechen
         * @Description //TODO 
         * @Date 15:54 2019/4/10
         * @Param [session]
         * @return java.lang.String
         **/
    @RequestMapping(value = "/logout",method = RequestMethod.GET)
    public String logout(HttpSession session){

        // 在 session 中去掉 user
        session.removeAttribute("user");


        return "home";
    }


    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(String username, String password, HttpSession session, HttpServletRequest request){
        logger.info(username+" "+password);
        User user = userService.login(username, password);
        MsgTo msg = null;
//        将 user set 到session 中
        if (user!=null){
            msg = new MsgTo("ok",200);
            request.setAttribute("msg",msg);
            session.setAttribute("user",user);
            return "home";
        }
        // 表示出错代码
        msg = new MsgTo("用户名或密码错误!",500);
        request.setAttribute("msg",msg);
        return "user/login";
    }

//跳转到登入页面
    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String toLoginPage(){
        logger.info("toLoginPage");
        return "user/login";
    }


//    跳转到注册页面
    @RequestMapping(value = "/reg",method = RequestMethod.GET)
    public String toRegPage(){

        logger.info("toRegPage");

        return "user/reg";
    }

//    注册用户  - 可用用户名或者邮箱
    @ResponseBody
    @RequestMapping(value = "/reg",method = RequestMethod.POST)
    public MsgTo reg(String username, String password){

        logger.info("注册账号信息 : "+username+" "+password);

        // 假设通过前台 js 已经确认了两个密码一致了
        // 注册时判断用户是否已经存在

        // 因为登入可以用用户名，也可以用邮箱
        User userExists = userService.isUserExists(username, username);

        MsgTo msg = new MsgTo("ok");
        // 用户存在，返回消息给前端
        if(userExists!=null){
            msg.setCode(400);
            logger.info(username + "这个用户名已经存在!");
            msg.setMsg("用户已存在!");
            return msg;
        }


        // 判断是否是邮箱
        if (CommonUtils.isEmail(username)){
            userService.saveUser(username,password,true);

        }else{
            // 不是通过；邮箱登入
            userService.saveUser(username,password,false);

        }


        return msg;
    }

    @ResponseBody
    @RequestMapping("/list")
    public List<User> getUserList(){
        return userService.findUserList();
    }


}
