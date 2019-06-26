package com.bigguy.movie.moviebox.spider;

import com.bigguy.movie.moviebox.dto.MovieRespDto;
import com.bigguy.movie.moviebox.utils.web.MovieSpiderUtils;
import org.springframework.stereotype.Service;

/**
 * @author bigguy_hc
 * @create 2019-05-14 11:03
 */

@Service
public class MovieSpider {

    public MovieRespDto getMovieDtoById(Integer id){
        return MovieSpiderUtils.getMovieRespDtoById(id);
    }

}
