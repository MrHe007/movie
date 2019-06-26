package com.bigguy.movie.moviebox;

import com.bigguy.movie.moviebox.bean.*;
import com.bigguy.movie.moviebox.mapper.MovieListMapper;
import com.bigguy.movie.moviebox.service.*;
import com.bigguy.movie.moviebox.utils.UrlUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MovieBoxApplicationTests {

    @Autowired
    MovieListMapper movieListMapper;

    @Autowired
    MovieWService service;

    @Autowired
    CelebrityWService celebrityWService;

    @Autowired
    RedisService redisService;

    @Autowired
    MovieWService movieWService;

    @Autowired
    NewsService newsService;

    @Autowired
    CommentService commentService;

    @Autowired
    AdminService adminService;

    @Autowired
    UserService userService;


    @Test
    public void testAddComment(){

        for (int i = 0; i < 100; i++) {
            Comment comment = new Comment(9.0,"hello world"+i , new User(2),"1992-9-2",26100958);
            commentService.saveComment(comment);

        }

    }

    @Test
    public void testAddUser(){

        for (int i=0; i<100; i++){
            User user = new User("bigguy" + i, "bigguy" + i, "bigguy" + i + "@163.com", "15570990166", "1997-3-3");
            userService.addUser(user);
        }


    }


    @Test
    public void testAdmin(){

        Admin admin = new Admin("admin","admin");

        admin = adminService.login(admin);


        boolean demo = adminService.updatePassword(admin, "demo");

        System.out.println(demo);


    }


    @Test
    public void testCommentList(){

        List<Comment> commentList = commentService.getCommentList(27602116);

        for (Comment comment : commentList) {
            System.out.println(comment);
            User user = comment.getUser();
            System.out.println(user);
        }

    }

    @Test
    public void testSaveComment(){



    }

    @Test
    public void testNewsService(){

        List<NewsItem> newsItems = newsService.selectNewsListByPage(0, 10);
        for (NewsItem newsItem : newsItems) {

            System.out.println(newsItem);

        }


    }


    @Test
    public void testRedisService(){


        redisService.setKey("name","jeckjeck");

        String name = redisService.getKey("name");

        System.out.println(name);

    }

    @Test
    public void testGetValueHashmap(){
        String key = "movie";
        String url = "movie/subject/27605698";
        String hashMap = redisService.getHashMap(key, url);

        System.out.println(hashMap);


    }

    @Test
    public void testHashMap(){

        String key = "movie";
        String url = "movie/subject/27605698";
        String link = "http://localhost/movie/subject/27605698";
        String html = UrlUtils.getHtml(link);

        System.out.println(html);

        redisService.setHashMap(key,url,html);


    }


    @Test
    public void testMovieWService(){

        int id = 26942674;
        MovieBean movieBeanById = service.getMovieBeanById(id);

        System.out.println(movieBeanById);

    }

    @Test
    public void testCelebrityWService(){
        int id = 1022614;
        Celebrity celebrity= celebrityWService.getCelebrityById(id);


    }


    @Test
    public void contextLoads() {


        List<String> allCountries = movieListMapper.findAllCountries();

        List<String> allFeatures = movieListMapper.findAllFeatures();

        List<String> allGenres = movieListMapper.findAllGenres();

        List<String> allTypes = movieListMapper.findAllTypes();

    }

}

