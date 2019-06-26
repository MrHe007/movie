package com.bigguy.movie.moviebox.dto;

import java.util.List;
import java.util.Map;

/**
 * @author bigguy_hc
 * @create 2019-05-14 11:04
 */
public class MovieRespDto {

    private Integer id;      // 电影ID
    private String name;    // 电影名
    private String score;   // 分数
    private String imgUrl;  // 图片
    private String movieIntro;  // 电影简介

    private List<KVDto> playAddrList;       // 电影播放列表 腾讯视频-爱奇艺

    private List<Map<String,String>> celebritysList;    // 相关影人
    private List<KVDto> directorsList;     // 导演
    private List<KVDto> screenwriterList;  // 编剧
    private List<KVDto> actorsList;  // 编剧

    private List<String> genresList;    // 剧情列表
    private String releaseTime;    // 上映时间
    private String duration;       // 影片时长


    public List<KVDto> getPlayAddrList() {
        return playAddrList;
    }

    public void setPlayAddrList(List<KVDto> playAddrList) {
        this.playAddrList = playAddrList;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "MovieRespDto{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", score='" + score + '\'' +
                ", imgUrl='" + imgUrl + '\'' +
                ", movieIntro='" + movieIntro + '\'' +
                ", celebritysList=" + celebritysList +
                ", directorsList=" + directorsList +
                ", screenwriterList=" + screenwriterList +
                ", actorsList=" + actorsList +
                ", genresList=" + genresList +
                ", releaseTime='" + releaseTime + '\'' +
                ", duration='" + duration + '\'' +
                '}';
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getMovieIntro() {
        return movieIntro;
    }

    public void setMovieIntro(String movieIntro) {
        this.movieIntro = movieIntro;
    }

    public List<Map<String, String>> getCelebritysList() {
        return celebritysList;
    }

    public void setCelebritysList(List<Map<String, String>> celebritysList) {
        this.celebritysList = celebritysList;
    }

    public List<KVDto> getDirectorsList() {
        return directorsList;
    }

    public void setDirectorsList(List<KVDto> directorsList) {
        this.directorsList = directorsList;
    }

    public List<KVDto> getScreenwriterList() {
        return screenwriterList;
    }

    public void setScreenwriterList(List<KVDto> screenwriterList) {
        this.screenwriterList = screenwriterList;
    }

    public List<KVDto> getActorsList() {
        return actorsList;
    }

    public void setActorsList(List<KVDto> actorsList) {
        this.actorsList = actorsList;
    }

    public List<String> getGenresList() {
        return genresList;
    }

    public void setGenresList(List<String> genresList) {
        this.genresList = genresList;
    }

    public String getReleaseTime() {
        return releaseTime;
    }

    public void setReleaseTime(String releaseTime) {
        this.releaseTime = releaseTime;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }
}
