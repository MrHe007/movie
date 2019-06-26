package com.bigguy.movie.moviebox.bean;/**
 * @author shkstart
 * @create 2019-03-20 11:03
 */

import java.util.List;
import java.util.Map;

/**
 * @author hechen
 * @data 2019/3/20
 *
 */
public class Celebrity {

    // 更多中文名字
    List<String> aka;

    // 更多英文名
    List<String> aka_en;

    String alt;

    Map<String,String > avatars;

    private String born_place;
    private String gender;
    private int id;
    private String mobile_url;

    private String name;
    private String name_en;

    List<Work> works;

    public List<String> getAka() {
        return aka;
    }

    public void setAka(List<String> aka) {
        this.aka = aka;
    }

    public List<String> getAka_en() {
        return aka_en;
    }

    public void setAka_en(List<String> aka_en) {
        this.aka_en = aka_en;
    }

    public String getAlt() {
        return alt;
    }

    public void setAlt(String alt) {
        this.alt = alt;
    }

    @Override
    public String toString() {
        return "Celebrity{" +
                "aka=" + aka +
                ", aka_en=" + aka_en +
                ", alt='" + alt + '\'' +
                ", avatars=" + avatars +
                ", born_place='" + born_place + '\'' +
                ", gender='" + gender + '\'' +
                ", id=" + id +
                ", mobile_url='" + mobile_url + '\'' +
                ", name='" + name + '\'' +
                ", name_en='" + name_en + '\'' +
                ", works=" + works +
                '}';
    }

    public Map<String, String> getAvatars() {
        return avatars;
    }

    public void setAvatars(Map<String, String> avatars) {
        this.avatars = avatars;
    }

    public String getBorn_place() {
        return born_place;
    }

    public void setBorn_place(String born_place) {
        this.born_place = born_place;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMobile_url() {
        return mobile_url;
    }

    public void setMobile_url(String mobile_url) {
        this.mobile_url = mobile_url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName_en() {
        return name_en;
    }

    public void setName_en(String name_en) {
        this.name_en = name_en;
    }

    public List<Work> getWorks() {
        return works;
    }

    public void setWorks(List<Work> works) {
        this.works = works;
    }
}
