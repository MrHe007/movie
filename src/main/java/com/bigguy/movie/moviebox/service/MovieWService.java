package com.bigguy.movie.moviebox.service;

import com.bigguy.movie.moviebox.bean.MovieBean;
import com.bigguy.movie.moviebox.bean.NowPlayingRespDto;
import com.bigguy.movie.moviebox.mapper.MovieDao;
import com.bigguy.movie.moviebox.resource.MovieUrlProperties;
import com.bigguy.movie.moviebox.utils.RedisUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * @author shkstart
 * @create 2019-03-17 11:06
 */

// 从网络中拿到数据的 service

@Service
public class MovieWService {

    @Autowired
    MovieUrlProperties movieUrlProperties;

    @Autowired
    RedisService redisService;

    @Autowired
    MovieDao movieDao;

    public String getTxSearchDataByKeyWord(String keyword){
        return movieDao.getTxDataByKeyword(keyword);
    }

    // 没有放到 redis 中
    public NowPlayingRespDto getMovieIndexData(){
        return movieDao.getIndexPageData();
    }


    public MovieBean getMovieBeanById(Integer id){

        Logger logger = LoggerFactory.getLogger(this.getClass());

        String subjectPrefixUrl = movieUrlProperties.getSubjectPrefixUrl();


        // 拼接后的url
        String okUrl = subjectPrefixUrl +"/" + id + "?" + movieUrlProperties.getSuffix();
        logger.info(okUrl);

        String html = RedisUtils.getHtml(redisService,okUrl);

        ObjectMapper mapper = new ObjectMapper();

        MovieBean movieBean = null;

        try {
            movieBean = mapper.readValue(html, MovieBean.class);
            System.out.println(movieBean);
        } catch (IOException e) {
            e.printStackTrace();
        }


        return movieBean;
    }

}
