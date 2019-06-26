package com.bigguy.movie.moviebox.dto;

/**
 * @author bigguy_hc
 * @create 2019-05-11 7:30
 */
public class TxMovieDto {

    private String movieName;;
    private String movieUrl;
    private String imgUrl;
    private String imgTitle;
    private Double movieScore;
    private String stars;
    private String viewCount;

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getMovieUrl() {
        return movieUrl;
    }

    public void setMovieUrl(String movieUrl) {
        this.movieUrl = movieUrl;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getImgTitle() {
        return imgTitle;
    }

    public void setImgTitle(String imgTitle) {
        this.imgTitle = imgTitle;
    }

    public Double getMovieScore() {
        return movieScore;
    }

    public void setMovieScore(Double movieScore) {
        this.movieScore = movieScore;
    }

    public String getStars() {
        return stars;
    }

    public void setStars(String stars) {
        this.stars = stars;
    }

    public String getViewCount() {
        return viewCount;
    }

    public void setViewCount(String viewCount) {
        this.viewCount = viewCount;
    }

    @Override
    public String toString() {
        return "TxMovieDto{" +
                "movieName='" + movieName + '\'' +
                ", movieUrl='" + movieUrl + '\'' +
                ", imgUrl='" + imgUrl + '\'' +
                ", imgTitle='" + imgTitle + '\'' +
                ", movieScore=" + movieScore +
                ", stars='" + stars + '\'' +
                ", viewCount='" + viewCount + '\'' +
                '}';
    }
}
