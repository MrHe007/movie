package com.bigguy.movie.moviebox.bean;

import java.util.List;
import java.util.Map;

/**
 * @author shkstart
 * @create 2019-03-17 10:42
 */
public class MovieBean {


    private List<String> aka;

    // 指向豆瓣的页面
    private String alt;

    // 导演链接
    private List<Cast> casts;

    private int collect_count;
    private int comments_count;

//    private Map<String,String> countries;

    private List<String> countries;

    private String current_season;
    private List<Director> directors;

    private int do_count;
    private String douban_site;
    private String episodes_count;

    private List<String> genres;

    // 电影 id
    private int id;

    private Map<String,String> images;

    public Map<String, String> getImages() {
        return images;
    }

    public void setImages(Map<String, String> images) {
        this.images = images;
    }

    private String mmobile_url;

    private String original_title;

    private Rating rating;

    private int ratings_count;
    private int reviews_count;

    private String schedule_url;
    private String seasons_count;

    private String share_url;
    private String subtype;


    private String summary;
    private String  title;
    private int wish_count;
    private String year;

    private String mobile_url;

    public String getMobile_url() {
        return mobile_url;
    }

    public void setMobile_url(String mobile_url) {
        this.mobile_url = mobile_url;
    }

    @Override
    public String toString() {
        return "MovieBean{" +
                "aka=" + aka +
                ", alt='" + alt + '\'' +
                ", casts=" + casts +
                ", collect_count=" + collect_count +
                ", comments_count=" + comments_count +
                ", countries=" + countries +
                ", current_season='" + current_season + '\'' +
                ", directors=" + directors +
                ", do_count=" + do_count +
                ", douban_site='" + douban_site + '\'' +
                ", episodes_count='" + episodes_count + '\'' +
                ", genres=" + genres +
                ", id=" + id +
                ", images=" + images +
                ", mmobile_url='" + mmobile_url + '\'' +
                ", original_title='" + original_title + '\'' +
                ", rating=" + rating +
                ", ratings_count=" + ratings_count +
                ", reviews_count=" + reviews_count +
                ", schedule_url='" + schedule_url + '\'' +
                ", seasons_count='" + seasons_count + '\'' +
                ", share_url='" + share_url + '\'' +
                ", subtype='" + subtype + '\'' +
                ", summary='" + summary + '\'' +
                ", title='" + title + '\'' +
                ", wish_count=" + wish_count +
                ", year='" + year + '\'' +
                ", mobile_url='" + mobile_url + '\'' +
                '}';
    }

    public List<String> getAka() {
        return aka;
    }

    public void setAka(List<String> aka) {
        this.aka = aka;
    }

    public String getAlt() {
        return alt;
    }

    public void setAlt(String alt) {
        this.alt = alt;
    }

    public List<Cast> getCasts() {
        return casts;
    }

    public void setCasts(List<Cast> casts) {
        this.casts = casts;
    }

    public int getCollect_count() {
        return collect_count;
    }

    public void setCollect_count(int collect_count) {
        this.collect_count = collect_count;
    }

    public int getComments_count() {
        return comments_count;
    }

    public void setComments_count(int comments_count) {
        this.comments_count = comments_count;
    }

    public List<String> getCountries() {
        return countries;
    }

    public void setCountries(List<String> countries) {
        this.countries = countries;
    }

    public String getCurrent_season() {
        return current_season;
    }

    public void setCurrent_season(String current_season) {
        this.current_season = current_season;
    }

    public List<Director> getDirectors() {
        return directors;
    }

    public void setDirectors(List<Director> directors) {
        this.directors = directors;
    }

    public int getDo_count() {
        return do_count;
    }

    public void setDo_count(int do_count) {
        this.do_count = do_count;
    }

    public String getDouban_site() {
        return douban_site;
    }

    public void setDouban_site(String douban_site) {
        this.douban_site = douban_site;
    }

    public String getEpisodes_count() {
        return episodes_count;
    }

    public void setEpisodes_count(String episodes_count) {
        this.episodes_count = episodes_count;
    }

    public List<String> getGenres() {
        return genres;
    }

    public void setGenres(List<String> genres) {
        this.genres = genres;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMmobile_url() {
        return mmobile_url;
    }

    public void setMmobile_url(String mmobile_url) {
        this.mmobile_url = mmobile_url;
    }

    public String getOriginal_title() {
        return original_title;
    }

    public void setOriginal_title(String original_title) {
        this.original_title = original_title;
    }

    public Rating getRating() {
        return rating;
    }

    public void setRating(Rating rating) {
        this.rating = rating;
    }

    public int getRatings_count() {
        return ratings_count;
    }

    public void setRatings_count(int ratings_count) {
        this.ratings_count = ratings_count;
    }

    public int getReviews_count() {
        return reviews_count;
    }

    public void setReviews_count(int reviews_count) {
        this.reviews_count = reviews_count;
    }

    public String getSchedule_url() {
        return schedule_url;
    }

    public void setSchedule_url(String schedule_url) {
        this.schedule_url = schedule_url;
    }

    public String getSeasons_count() {
        return seasons_count;
    }

    public void setSeasons_count(String seasons_count) {
        this.seasons_count = seasons_count;
    }

    public String getShare_url() {
        return share_url;
    }

    public void setShare_url(String share_url) {
        this.share_url = share_url;
    }

    public String getSubtype() {
        return subtype;
    }

    public void setSubtype(String subtype) {
        this.subtype = subtype;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getWish_count() {
        return wish_count;
    }

    public void setWish_count(int wish_count) {
        this.wish_count = wish_count;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }
}
