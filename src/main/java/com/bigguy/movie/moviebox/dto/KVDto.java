package com.bigguy.movie.moviebox.dto;

/**
 * @author bigguy_hc
 * @create 2019-05-14 9:29
 */
public class KVDto {

    private String key;
    private String val;

    public KVDto(){}

    public KVDto(String key, String val) {
        this.key = key;
        this.val = val;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getVal() {
        return val;
    }

    public void setVal(String val) {
        this.val = val;
    }
}
