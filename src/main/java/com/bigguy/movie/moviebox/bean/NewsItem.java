package com.bigguy.movie.moviebox.bean;/**
 * @author shkstart
 * @create 2019-03-27 17:17
 */

/**
 * @author hechen
 * @data 2019/3/27
 *
 */
public class NewsItem {

    private int id;
    private String imgUrl;
    private String title;
    private String simpleText;
    private String content;

    // 时间
    private String date;

    // 观看人数
    private int viewCount;

    @Override
    public String toString() {
        return "NewsItem{" +
                "id=" + id +
                ", imgUrl='" + imgUrl + '\'' +
                ", title='" + title + '\'' +
                ", simpleText='" + simpleText + '\'' +
                ", content='" + content + '\'' +
                ", date='" + date + '\'' +
                ", viewCount=" + viewCount +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSimpleText() {
        return simpleText;
    }

    public void setSimpleText(String simpleText) {
        this.simpleText = simpleText;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getViewCount() {
        return viewCount;
    }

    public void setViewCount(int viewCount) {
        this.viewCount = viewCount;
    }
}
