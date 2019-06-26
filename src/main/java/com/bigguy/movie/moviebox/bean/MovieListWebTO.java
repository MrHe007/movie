package com.bigguy.movie.moviebox.bean;

/**
 * @author shkstart
 * @create 2019-03-12 9:22
 */
public class MovieListWebTO {

    private String sort = "U";
    private int start = 0;

//    类型 types
    private String tags = "电影";

    //  年代
    private int startYear;
    private int endYear;

    // 电影类型
    private String genres;

    // 特色
    private String features;
    private String countries;

    // 年代
    private int rangeStart;
    private int rangeEnd;

    @Override
    public String toString() {
        return "MovieListWebTO{" +
                "sort='" + sort + '\'' +
                ", start=" + start +
                ", tags='" + tags + '\'' +
                ", startYear=" + startYear +
                ", endYear=" + endYear +
                ", features='" + features + '\'' +
                ", countries='" + countries + '\'' +
                ", rangeStart=" + rangeStart +
                ", rangeEnd=" + rangeEnd +
                '}';
    }

    public String getGenres() {
        return genres;
    }

    public void setGenres(String genres) {
        this.genres = genres;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public int getStartYear() {
        return startYear;
    }

    public void setStartYear(int startYear) {
        this.startYear = startYear;
    }

    public int getEndYear() {
        return endYear;
    }

    public void setEndYear(int endYear) {
        this.endYear = endYear;
    }

    public String getFeatures() {
        return features;
    }

    public void setFeatures(String features) {
        this.features = features;
    }

    public String getCountries() {
        return countries;
    }

    public void setCountries(String countries) {
        this.countries = countries;
    }

    public int getRangeStart() {
        return rangeStart;
    }

    public void setRangeStart(int rangeStart) {
        this.rangeStart = rangeStart;
    }

    public int getRangeEnd() {
        return rangeEnd;
    }

    public void setRangeEnd(int rangeEnd) {
        this.rangeEnd = rangeEnd;
    }
}
