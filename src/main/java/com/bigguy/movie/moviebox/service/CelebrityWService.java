package com.bigguy.movie.moviebox.service;/**
 * @author shkstart
 * @create 2019-03-20 11:11
 */

import com.bigguy.movie.moviebox.bean.Celebrity;
import com.bigguy.movie.moviebox.resource.MovieUrlProperties;
import com.bigguy.movie.moviebox.utils.UrlUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * @author hechen
 * @data 2019/3/20
 *
 */

@Service
public class CelebrityWService {

    @Autowired
    MovieUrlProperties movieUrlProperties;

    final Logger logger = LoggerFactory.getLogger(this.getClass());
    
    public Celebrity getCelebrityById(Integer id){

        String celebrityUrl = movieUrlProperties.getCelebrityUrl();
        
        String okUrl = celebrityUrl + id +"?" +movieUrlProperties.getSuffix();

        logger.info(okUrl);

        String html = UrlUtils.getHtml(okUrl);

        ObjectMapper mapper = new ObjectMapper();

        Celebrity celebrity = null;

        try {
            celebrity = mapper.readValue(html, Celebrity.class);

            System.out.println(celebrity);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return celebrity;
    }

}
