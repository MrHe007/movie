package com.bigguy.movie.moviebox.service;

import com.bigguy.movie.moviebox.mapper.MovieListMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author shkstart
 * @create 2019-03-10 11:22
 */
@Service
public class MovieListService {

    @Autowired
    MovieListMapper movieListMapper;

    public List<String> getCountriesList(){
        return movieListMapper.findAllCountries();
    }

    public List<String> getGenresList(){
        return movieListMapper.findAllGenres();
    }

    public List<String> getFeaturesList(){
        return movieListMapper.findAllFeatures();
    }

    public List<String> getTypesList(){
        return movieListMapper.findAllTypes();
    }

    public List<String> getYearsList(){
        return movieListMapper.findAllYeaes();
    }


}
