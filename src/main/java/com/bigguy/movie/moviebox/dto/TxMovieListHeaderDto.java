package com.bigguy.movie.moviebox.dto;

import java.util.List;
import java.util.Map;

/**
 * @author bigguy_hc
 * @create 2019-05-11 8:26
 *   // https://v.qq.com/channel/movie?listpage=1&channel=movie&itype=100062
 */
public class TxMovieListHeaderDto {

    private List<Map<String,String>> sortType;      // 排序方式
    private List<Map<String,String>> areas;         // 地区
    private List<Map<String,String>> features;      // 特色
    private List<Map<String,String>> years;         // 年份
    private List<Map<String,String>> charge;        // 资费方式

    @Override
    public String toString() {
        return "TxMovieListHeaderDto{" +
                "sortType=" + sortType +
                ", areas=" + areas +
                ", features=" + features +
                ", years=" + years +
                ", charge=" + charge +
                '}';
    }

    public List<Map<String, String>> getSortType() {
        return sortType;
    }

    public void setSortType(List<Map<String, String>> sortType) {
        this.sortType = sortType;
    }

    public List<Map<String, String>> getAreas() {
        return areas;
    }

    public void setAreas(List<Map<String, String>> areas) {
        this.areas = areas;
    }

    public List<Map<String, String>> getFeatures() {
        return features;
    }

    public void setFeatures(List<Map<String, String>> features) {
        this.features = features;
    }

    public List<Map<String, String>> getYears() {
        return years;
    }

    public void setYears(List<Map<String, String>> years) {
        this.years = years;
    }

    public List<Map<String, String>> getCharge() {
        return charge;
    }

    public void setCharge(List<Map<String, String>> charge) {
        this.charge = charge;
    }
}
