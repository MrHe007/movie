package com.bigguy.movie.moviebox.bean;

import java.util.Map;

/**
 * @author shkstart
 * @create 2019-03-17 10:58
 */
public class Director {
    private String alt;

    private Map<String ,String> avatars;

    private int id;
    private String name;

    public String getAlt() {
        return alt;
    }

    public void setAlt(String alt) {
        this.alt = alt;
    }

    public Map<String, String> getAvatars() {
        return avatars;
    }

    public void setAvatars(Map<String, String> avatars) {
        this.avatars = avatars;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
