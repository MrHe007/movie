package com.bigguy.movie.moviebox.config;

import com.bigguy.movie.moviebox.interceptor.AdminLoginInterceptor;
import com.bigguy.movie.moviebox.interceptor.UserLoginInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author bigguy_hc
 * @create 2019-02-12 11:04
 */

@Configuration
public class MyWebMvcConfig extends WebMvcConfigurerAdapter {


    @Bean
    public WebMvcConfigurerAdapter webMvcConfigurerAdapter(){
        WebMvcConfigurerAdapter webMvcConfigurerAdapter = new WebMvcConfigurerAdapter() {
            @Override
            public void addViewControllers(ViewControllerRegistry registry) {

//                主页映射
                registry.addViewController("/").setViewName("home");
                registry.addViewController("/index.html").setViewName("home");


////                电影映射
//                registry.addViewController("/movie/movie-details.html").setViewName("movie/movie-details");
//                registry.addViewController("/movie/movie-list.html").setViewName("movie/movie-list");
//                registry.addViewController("/movie/movie-news-list.html").setViewName("movie/movie-news-list");
//
////                公共页面
//                registry.addViewController("/load.html").setViewName("/page/load");
//
////                用户登入注册
//                registry.addViewController("/user/login.html").setViewName("user/login");
//                registry.addViewController("/user/reg.html").setViewName("user/reg");
//
//                registry.addViewController("/test/demo.html").setViewName("test/demo");
//
//
////                新闻
//                registry.addViewController("/news/news-list.html").setViewName("news/news-list");
//
//                registry.addViewController("/demo").setViewName("test/demo");
//
//
////                跳转到新闻的编辑页面
//                registry.addViewController("/admin/news-edit.html").setViewName("admin/news-edit");
//
////                后台首页
                registry.addViewController("/admin/admin.html").setViewName("admin/admin");
                registry.addViewController("/admin/").setViewName("admin/admin");
                registry.addViewController("/admin/admin").setViewName("admin/admin");

            }
        };

        return webMvcConfigurerAdapter;
    }

    // 注册拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        // 用户登录拦截器

        registry.addInterceptor(new UserLoginInterceptor())
                .addPathPatterns("/page/user/user-info.html")       // 查看用户信息之前需要登入
                .addPathPatterns("/page/user/user-info")
                .addPathPatterns("/movie/comment");                 // 评论电影前需要登入
        registry.addInterceptor(new AdminLoginInterceptor())
                .addPathPatterns("/admin/admin")
                .addPathPatterns("/admin/admin.html")
                .addPathPatterns("/page/admin/admin.html")
                .addPathPatterns("/admin/")
                .addPathPatterns("/admin");


    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {

        registry.addMapping("/**")
                .allowCredentials(true)
                .allowedHeaders("*")
                .allowedOrigins("*")
                .allowedMethods("*");
    }

}
