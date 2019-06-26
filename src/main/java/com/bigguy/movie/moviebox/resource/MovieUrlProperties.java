package com.bigguy.movie.moviebox.resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @author shkstart
 * @create 2019-03-09 14:18
 *
 * 将所有的url配置在了 resource/url.properties 中了
 *
 */
@Component
@PropertySource("classpath:resource/url.properties")
public class MovieUrlProperties {

    @Value("${suffix}")
    public String suffix;

    @Value("${txSearchUrl}")
    public String txSearchUrl;

    @Value("${realTimeBoxOffer}")
    public String realTimeBoxOffer;

    @Value("${celebrityUrl}")
    public String celebrityUrl;

    @Value("${moviePhotos}")
    public String moviePhotos;


    @Value("${inTheatersUrl}")
    public String inTheatersUrl;

    @Value("${movieListUrl}")
    private String movieListUrl;


    @Value("${topUrl}")
    private String topUrl;

    @Value("${searchUrl}")
    private String searchUrl;

    @Value("${subjectPrefixUrl}")
    private String subjectPrefixUrl;

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    public String getTxSearchUrl() {
        return txSearchUrl;
    }

    public void setTxSearchUrl(String txSearchUrl) {
        this.txSearchUrl = txSearchUrl;
    }

    public String getRealTimeBoxOffer() {
        return realTimeBoxOffer;
    }

    public void setRealTimeBoxOffer(String realTimeBoxOffer) {
        this.realTimeBoxOffer = realTimeBoxOffer;
    }

    public String getMovieListUrl() {
        return movieListUrl;
    }

    public void setMovieListUrl(String movieListUrl) {
        this.movieListUrl = movieListUrl;
    }

    public String getSubjectPrefixUrl() {
        return subjectPrefixUrl;
    }

    public void setSubjectPrefixUrl(String subjectPrefixUrl) {
        this.subjectPrefixUrl = subjectPrefixUrl;
    }

    public String getSearchUrl() {
        return searchUrl;
    }

    public void setSearchUrl(String searchUrl) {
        this.searchUrl = searchUrl;
    }

    public String getTopUrl() {
        return topUrl;
    }

    public void setTopUrl(String topUrl) {
        this.topUrl = topUrl;
    }

    public String getInTheatersUrl() {
        return inTheatersUrl;
    }

    public void setInTheatersUrl(String inTheatersUrl) {
        this.inTheatersUrl = inTheatersUrl;
    }

    public String getMoviePhotos() {
        return moviePhotos;
    }

    public String getCelebrityUrl() {
        return celebrityUrl;
    }

    public void setCelebrityUrl(String celebrityUrl) {
        this.celebrityUrl = celebrityUrl;
    }

    public void setMoviePhotos(String moviePhotos) {
        this.moviePhotos = moviePhotos;
    }
}
