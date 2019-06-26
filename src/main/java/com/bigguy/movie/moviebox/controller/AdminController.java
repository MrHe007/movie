package com.bigguy.movie.moviebox.controller;/**
 * @Auther: hechen
 * @Date: 2019/3/31 16:25
 * @Description: ...
 */

import com.bigguy.movie.moviebox.bean.Admin;
import com.bigguy.movie.moviebox.bean.NewsItem;
import com.bigguy.movie.moviebox.bean.User;
import com.bigguy.movie.moviebox.dto.UserListRespDto;
import com.bigguy.movie.moviebox.dto.NewsItemRespDto;
import com.bigguy.movie.moviebox.message.BaseMsg;
import com.bigguy.movie.moviebox.message.MsgTo;
import com.bigguy.movie.moviebox.service.AdminService;
import com.bigguy.movie.moviebox.service.NewsService;
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
import java.util.List;

/**
 * @author hechen
 * @data 2019/3/31
 */
@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    NewsService newsService;

    @Autowired
    AdminService adminService;


    Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String toAdminPage(){
        return "/admin/admin";
    }


    // 拿到所有用户的列表
    @ResponseBody
    @RequestMapping(value = "/user/list", method = RequestMethod.GET)
    public UserListRespDto getUserListByPage(Integer page, Integer limit){
        UserListRespDto respDto = new UserListRespDto();
        List<User> userList = adminService.getUserList((page-1)*limit, limit);
        Integer total = adminService.getTotalUsers();

        respDto.setData(userList);
        respDto.setCount(total);

        return respDto;
    }

    @ResponseBody
    @RequestMapping(value = "/news/list", method = RequestMethod.GET)
    public NewsItemRespDto getNewsItemListByPage(Integer page, Integer limit){
        NewsItemRespDto respDto = new NewsItemRespDto();
        List<NewsItem> newsItemList = adminService.getNewsItem((page - 1) * limit, limit);
        Integer total = adminService.getTotalNewsItem();

        respDto.setData(newsItemList);
        respDto.setCount(total);

        return respDto;
    }



    @RequestMapping(value = "/",method = RequestMethod.PUT)
    public String updateAdminInfo(Admin admin, String newPass, HttpServletRequest request){

        // 密码验证通过后才可以修改密码

        String rtnPageStr = "admin/safe-setting";

        Admin adminTemp = adminService.login(admin);

        MsgTo msg = null;

        if(null == adminTemp){
            // 405 表示用户名密码错误
            msg = new MsgTo(BaseMsg.LOGIN_PASSWORD_ERR,405);

            request.setAttribute("msg", msg);

            return rtnPageStr;
        }

        boolean flag = adminService.updatePassword(adminTemp, newPass);

        if (false == flag){
            // 500 表示未知异常
            msg = new MsgTo(BaseMsg.LOGIN_UNKNOW_ERR, 500);
        }else {
            msg = new MsgTo(BaseMsg.UPDATE_UPASSWORD, 200);
        }

        request.setAttribute("msg", msg);

        return rtnPageStr;
    }


/*
     * @Author hechen
     * @Description 注销登入后，跳到 admin 登入界面
     * @Date 14:24 2019/4/15
     * @Param [session]
     * @return java.lang.String
     **/
    @RequestMapping(value = "/logout",method = RequestMethod.GET)
    public String logout(HttpSession session){

        Object admin = session.getAttribute("admin");

        if (null != admin){
            session.removeAttribute("admin");
        }

        return "/admin/login";
    }

    @RequestMapping("/to/{pageName}")
    public String redirectToPage(@PathVariable("pageName") String pageName){

        logger.info("重定向到 -> "+pageName);

        return "/admin/" +pageName;

    }

    @RequestMapping("/login")
    public String toAdmingLoginPage(){

        logger.info("login");

        return "admin/login";
    }



    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String adminLogin(Admin admin, HttpServletRequest request){

        HttpSession session = request.getSession();

        Object adminObj = session.getAttribute("admin");


        // 如果 session 中有改记录，表示已经登入，直接跳到后台
        if(null != adminObj){
            return "admin/admin";
        }

        logger.info(admin.toString());

        Admin tempAdmin = adminService.login(admin);
        if(null==tempAdmin){    // 登入失败
            MsgTo msg = new MsgTo("用户名或者密码错误", 500);
            request.setAttribute("msg",msg);

            return "/admin/login";
        }

        // 登入成功，在 session 中记录域
        session.setAttribute("admin",tempAdmin);

        session.setAttribute("msg",new MsgTo("success"));

//        return "redirect:to/admin";
        return "admin/admin";
    }

//    @RequestMapping(value = "/admin",method = RequestMethod.GET)
//    public String toAdminPage(){
//        logger.info("toAdminPage");
//        return "admin/admin";
//    }


    /*
         * @Author hechen
         * @Description 后台管理员查看新闻列表,设置一个变量表示是后台查看
         *  实际上和 前台查看新闻列表用的是同一个 html 文件
         * @Date 9:56 2019/4/1
         * @Param []
         * @return java.lang.String
         **/

//    异步请求电影数据

    // 请求的页号，和每页请求的数据总数
    @ResponseBody
    @RequestMapping(value = "/news-list.json",method = RequestMethod.GET)
    public List<NewsItem> getNewsListJson(Integer curr , Integer limit, HttpServletRequest request){


        logger.info("获取json : admin 查看 news-list.json");

        if(null==curr || null==limit){
            curr = 0;
            limit = 10;
        }

        List<NewsItem> newsItems = newsService.selectNewsListByPage(curr, limit);


        return newsItems;
    }



    @RequestMapping(value ="news-details/{id}",method = RequestMethod.GET)
    public String toNewsItemPage(@PathVariable("id") Integer id, HttpServletRequest request){
        logger.info("admin ->  news-details.html ");

        request.setAttribute("isAdminRole",true);

        NewsItem newsItem = newsService.getNewsItem(id);

        request.setAttribute("newsItem", newsItem);


        return "news/news-details";
    }



    /*
     * @Author hechen
     * @Description //通过 id 跳到修改页面
     * @Date 15:00 2019/4/1
     * @Param
     * @return
     **/

    @RequestMapping(value = "/news-edit-list",method = RequestMethod.GET)
    public String toEditList(HttpServletRequest request){
        logger.info("admin/news-list : admin 跳到查看修改新闻列表");

        // 设置数据总数
        request.setAttribute("count",newsService.getNewsCount());

        return "/admin/news-edit-list";

    }

    @RequestMapping(value = "/news/del/{id}",method = RequestMethod.GET)
    public String delNewsById(@PathVariable("id")Integer id, HttpServletRequest request){

        logger.info("删除新闻 -> "+id);


        boolean flag = newsService.delNewsItem(id);

        logger.info("删除 newsItem success -> "+id);


        return "/admin/news-list";
    }



    @RequestMapping(value = "/news-list",method = RequestMethod.GET)
    public String toNewsList(HttpServletRequest request){


        logger.info("admin/news-list : admin 查看 news-list");

        //  news-list.html 是否展示公共界面的变量
        request.setAttribute("isAdmin",true);

        // 设置数据总数
        request.setAttribute("count",newsService.getNewsCount());


        return "/admin/news-list";
    }








    @RequestMapping(value ="news-edit/{id}",method = RequestMethod.GET)
    public String editNews(@PathVariable("id") Integer id, HttpServletRequest request){
        logger.info("跳转到 news-details.html ");
        NewsItem newsItem = newsService.getNewsItem(id);
        request.setAttribute("newsItem", newsItem);
        return "admin/news-edit";
    }


    /*
         * @Author hechen
         * @Description // 修改数据， REST 风格
         * @Date 15:18 2019/4/1
         * @Param [newsItem]
         * @return java.lang.String
         **/
    @RequestMapping(value = "news/editNewsItem",method = RequestMethod.POST)
    public String updateNewsItem(NewsItem newsItem){
        System.out.println("updateNewsItem");

        logger.info("updateNewsItem");

        // 修改数据
        newsService.updateNewItem(newsItem);

        return "/admin/news-list";
    }

    /*
         * @Author hechen
         * @Description 页面跳转
         * @Date 19:31 2019/4/19
         * @Param [pageNamee]
         * @return java.lang.String
         **/
    @RequestMapping(value = "/{pageName}.html",method = RequestMethod.GET)
    public String toHtmlPage(@PathVariable("pageName") String pageNamee){

        logger.info("跳转到页面 -> "+pageNamee);
        return "/admin/" + pageNamee;

    }



    /*
         * @Author hechen
         * @Description 管理员 - 增加新闻
         * @Date 16:28 2019/3/31
         * @Param
         * @return
         **/

    @RequestMapping(value = "news/addNewsItem",method = RequestMethod.POST)
    public String addNewsItemPost(NewsItem newsItem){

        logger.info("addNewsItem");

        newsService.saveNewItem(newsItem);

        return "/admin/news-list";
    }

}
