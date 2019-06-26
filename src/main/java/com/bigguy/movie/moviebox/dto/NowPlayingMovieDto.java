package com.bigguy.movie.moviebox.dto;

import java.io.Serializable;

/**
 * @author bigguy_hc
 * @create 2019-05-12 16:56
 */
public class NowPlayingMovieDto implements Serializable {

    private String movieName;
    private String movieId;     // 电影ID  - 》 从连接里面爬取
    private String imgUrl;
    private String score;
    private String maoYanUrl;      // 跳转到猫眼电影链接
    private String date;        //上映日期

    public String getMaoYanUrl() {
        return maoYanUrl;
    }

    public void setMaoYanUrl(String maoYanUrl) {
        this.maoYanUrl = maoYanUrl;
    }

    public String getMovieId() {
        return movieId;
    }

    public void setMovieId(String movieId) {
        this.movieId = movieId;
    }

    @Override
    public String toString() {
        return "NowPlayingMovieDto{" +
                "movieName='" + movieName + '\'' +
                ", movieId='" + movieId + '\'' +
                ", imgUrl='" + imgUrl + '\'' +
                ", score='" + score + '\'' +
                ", maoYanUrl='" + maoYanUrl + '\'' +
                ", date='" + date + '\'' +
                '}';
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }



    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
