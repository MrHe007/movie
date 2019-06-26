package com.bigguy.movie.moviebox.service;

import com.bigguy.movie.moviebox.bean.NowPlayingRespDto;
import com.bigguy.movie.moviebox.dto.AllCelebritesDto;
import com.bigguy.movie.moviebox.dto.MovieRespDto;
import com.bigguy.movie.moviebox.resource.MovieUrlProperties;
import com.bigguy.movie.moviebox.spider.MovieSpider;
import com.bigguy.movie.moviebox.utils.PublicUtils;
import com.bigguy.movie.moviebox.utils.web.MovieSpiderUtils;
import com.bigguy.movie.moviebox.utils.web.MyHttpClientUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author bigguy_hc
 * @create 2019-05-15 17:55
 */
@Service
public class NewPublicApiService {

    @Autowired
    MovieUrlProperties properties;

    @Autowired
    MovieSpider movieSpider;

    @Autowired
    MovieWService movieWService;

    // 拿到首页数据
    public NowPlayingRespDto getMovieIndexData(){
        return movieWService.getMovieIndexData();
    }


    public String getSearchDataByQ(String keyword){
        String searchUrl = properties.getSearchUrl();
        String url = searchUrl +"&q=" + keyword;
        return MyHttpClientUtils.getJsonData(url);

    }

    // 拿到top250
    public String getTop250(Integer start, Integer count){
        String top250Url = properties.getTopUrl();          // 数据已经加上了 apiKey
        String url = top250Url + PublicUtils.parsePageParam(start, count);  // 封装分页请求参数
        String data = MyHttpClientUtils.getJsonData(url);                   // 网络请求数据
        return data;
    }


    // 获得影片详情数据
    public MovieRespDto getMovieRespDtoById(Integer id){
        MovieRespDto movieDtoById = movieSpider.getMovieDtoById(id);
        return movieDtoById;
    }

    // 全部演职人员数据
    public AllCelebritesDto getCelebritiesDto(Integer id){
        return MovieSpiderUtils.getCelebritiesById(id);
    }

    // 获得影片图集
    public String getMoviePhotosById(Integer id, String queryString){
        return MovieSpiderUtils.getPhotosByMovieId(id, queryString);
    }

    // 获得影人详情
    public String getCelebrityDataById(Integer id){

        String celebrityUrl = properties.getCelebrityUrl() + id;
        String url = celebrityUrl +"?" + properties.getSuffix();         // 封装apiKey
        String jsonData = MyHttpClientUtils.getJsonData(url);
        return jsonData;
    }

    // 获得影人剧照
    public String getCelebrityPhotosById(Integer id, Integer start, Integer count){
        String celebrityUrl = properties.getCelebrityUrl() + id;
        String url = celebrityUrl + "/photos";

        url += "?" +  properties.getSuffix();
        url += PublicUtils.parsePageParam(start,count);

        String jsonData = MyHttpClientUtils.getJsonData(url);
        return jsonData;
    }

    // 获得影人作品
    public String getCelebrityWorksById(Integer id, Integer start, Integer count){
        String celebrityUrl = properties.getCelebrityUrl() + id;
        String url = celebrityUrl + "/works";

        url += "?" + properties.getSuffix();

        url +=  PublicUtils.parsePageParam(start,count);

        String jsonData = MyHttpClientUtils.getJsonData(url);
        return jsonData;
    }

}
