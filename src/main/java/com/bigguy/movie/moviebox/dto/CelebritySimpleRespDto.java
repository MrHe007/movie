package com.bigguy.movie.moviebox.dto;

import java.util.List;

/**
 * @author bigguy_hc
 * @create 2019-05-15 9:52
 */
public class CelebritySimpleRespDto {

    private Integer id;         // 影人ID
    private String link;        // 影人豆瓣链接
    private String imgUrl;      // 影人图片
    private String name;        // 影人名
    private String role;        // 职责，如导演、演员、编剧、制片人
    private List<KVDto> works;      // 代表作

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public List<KVDto> getWorks() {
        return works;
    }

    public void setWorks(List<KVDto> works) {
        this.works = works;
    }
}
