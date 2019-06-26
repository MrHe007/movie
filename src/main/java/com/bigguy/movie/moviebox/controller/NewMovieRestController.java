package com.bigguy.movie.moviebox.controller;

import com.bigguy.movie.moviebox.bean.NowPlayingRespDto;
import com.bigguy.movie.moviebox.dto.AllCelebritesDto;
import com.bigguy.movie.moviebox.dto.MovieRespDto;
import com.bigguy.movie.moviebox.service.NewPublicApiService;
import com.bigguy.movie.moviebox.spider.MovieSpider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author bigguy_hc
 * @create 2019-05-14 11:24
 * @intro: 主要是网络爬虫的API
 */
@RestController
@RequestMapping("/api/movie")
public class NewMovieRestController {

    @Autowired
    MovieSpider movieSpider;

    @Autowired
    NewPublicApiService publicApiService;

    Logger logger = LoggerFactory.getLogger(NewMovieRestController.class);


    // 首页的index.json
    @RequestMapping(value = "/{index.json}", method = RequestMethod.GET)
    public NowPlayingRespDto getMovieIndexPageData(){
        return publicApiService.getMovieIndexData();
    }

    // 新的搜索接口
    // searchUrl
    @RequestMapping(value = "/search" , method = RequestMethod.GET)
    public String search(String q){
        // q 表示输入的关键字
        String top250Data = publicApiService.getSearchDataByQ(q);
        return top250Data;
    }


    // 拿到top250数据
    @RequestMapping(value = "/top250" , method = RequestMethod.GET)
    public String getTop250Data(Integer start, Integer count){
        logger.info("getTop25p : "+"start="+start +",count="+count);
        String top250Data = publicApiService.getTop250(start, count);
        return top250Data;
    }

    // 通过ID拿到影人数据
    @RequestMapping(value = "/celebrity/{id}" , method = RequestMethod.GET)
    public String getCelebrity(@PathVariable("id") Integer id){
        logger.info("celebrity : "+id);
        String data = publicApiService.getCelebrityDataById(id);
        return data;
    }

    // 通过ID拿到影人照片集
    @RequestMapping(value = "/celebrity/{id}/photos" , method = RequestMethod.GET)
    public String getCelebrityPhotos(@PathVariable("id") Integer id, Integer start, Integer count){
        logger.info("celebrity/photos : "+id);
        String data = publicApiService.getCelebrityPhotosById(id, start, count);
        return data;
    }

    // 通过ID 拿到影人作品
    @RequestMapping(value = "/celebrity/{id}/works" , method = RequestMethod.GET)
    public String getCelebrityWorks(@PathVariable("id") Integer id, Integer start, Integer count){
        logger.info("celebrity/works : "+id);
        String data = publicApiService.getCelebrityWorksById(id, start, count);
        return data;
    }

    // 通过ID拿到 - 电影照片集
    @RequestMapping(value = "/subject/{id}/photos", method = RequestMethod.GET)
    public String getMoviePhotosById(@PathVariable("id") Integer id, HttpServletRequest request){
        logger.info("getMoviePhotos : "+id);

        // 如果start | count 不为空就取
        String queryString = request.getQueryString();

        return publicApiService.getMoviePhotosById(id,queryString);
    }

    // 通过电影ID 爬虫拿到拿到全部演职人员数据
    @RequestMapping(value = "/subject/{id}/celebrities", method = RequestMethod.GET)
    public AllCelebritesDto getCelebritiesDto(@PathVariable("id") Integer id){

        logger.info("get AllCelebrities Info : "+id);
        AllCelebritesDto allCelebritesDto = publicApiService.getCelebritiesDto(id);

        return allCelebritesDto;

    }

    // 通过电影ID，爬虫 =》电影详情数据
    @RequestMapping(value = "/subject/{id}", method = RequestMethod.GET)
    public MovieRespDto getMovieRespDto(@PathVariable("id") Integer id){

        logger.info("/subject/id= "+id);
        MovieRespDto movieDtoById = publicApiService.getMovieRespDtoById(id);
        movieDtoById.setId(id);
        return movieDtoById;
    }

}
