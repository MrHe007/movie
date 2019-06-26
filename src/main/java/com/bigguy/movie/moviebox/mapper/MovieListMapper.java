package com.bigguy.movie.moviebox.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author shkstart
 * @create 2019-03-10 10:52
    用于获取电影列表上的数据
 */


@Mapper
public interface MovieListMapper {




    @Select("select name from types")
    public List<String> findAllTypes();

    @Select("select name from genres")
    public List<String> findAllGenres();


    @Select("select name from countries")
    public List<String> findAllCountries();

    @Select("select name from years")
    public List<String> findAllYeaes();

    @Select("select name from features")
    public List<String> findAllFeatures();


}
