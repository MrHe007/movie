package com.bigguy.movie.moviebox.bean;

import java.util.List;

/**
 * @author shkstart
 * @create 2019-03-10 15:00
 */
public class MovieListNavDataBean {

    private List<String > types;
    private List<String > genres;
    private List<String > countries;
    private List<String > features;
    private List<String > years;

    public List<String> getTypes() {
        return types;
    }

    public void setTypes(List<String> types) {
        this.types = types;
    }

    public List<String> getGenres() {
        return genres;
    }

    public void setGenres(List<String> genres) {
        this.genres = genres;
    }

    public List<String> getCountries() {
        return countries;
    }

    public void setCountries(List<String> countries) {
        this.countries = countries;
    }

    public List<String> getFeatures() {
        return features;
    }

    public void setFeatures(List<String> features) {
        this.features = features;
    }

    public List<String> getYears() {
        return years;
    }

    public void setYears(List<String> years) {
        this.years = years;
    }

    @Override
    public String toString() {
        return "MovieListNavDataBean{" +
                "types=" + types +
                ", genres=" + genres +
                ", countries=" + countries +
                ", features=" + features +
                ", years=" + years +
                '}';
    }
}
