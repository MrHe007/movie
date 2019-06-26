package com.bigguy.movie.moviebox.bean;

import com.bigguy.movie.moviebox.dto.NowPlayingMovieDto;

import java.util.ArrayList;
import java.util.List;

/**
 * @author bigguy_hc
 * @create 2019-05-12 16:55
 */
public class NowPlayingRespDto {

    private String cityName;    // 所在城市名字
    private List<NowPlayingMovieDto> nowPlayingMovieDtos = new ArrayList<>();   // 正在 热映电影列表

    private List<NowPlayingMovieDto> futurePlayingMovieDtos = new ArrayList<>();    // 即将上映电影

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public List<NowPlayingMovieDto> getNowPlayingMovieDtos() {
        return nowPlayingMovieDtos;
    }

    public void setNowPlayingMovieDtos(List<NowPlayingMovieDto> nowPlayingMovieDtos) {
        this.nowPlayingMovieDtos = nowPlayingMovieDtos;
    }

    public List<NowPlayingMovieDto> getFuturePlayingMovieDtos() {
        return futurePlayingMovieDtos;
    }

    public void setFuturePlayingMovieDtos(List<NowPlayingMovieDto> futurePlayingMovieDtos) {
        this.futurePlayingMovieDtos = futurePlayingMovieDtos;
    }
}
