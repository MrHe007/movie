package com.bigguy.movie.moviebox.bean;/**
 * @Auther: hechen
 * @Date: 2019/4/8 17:15
 * @Description: ...
 */

/**
 * @author hechen
 * @data 2019/4/8
 */
public class Comment {
    private Integer id;
    private Double score;
    private String content;

    //  user，表示某个用户评论的
    private User user;

    // 评论的时间
    private String time;

    // 通过 mid 将评论绑定到相应的影片
    private Integer mid;
    public Comment(){}

    public Comment(Double score, String content, User user, String time, Integer mid) {
        this.score = score;
        this.content = content;
        this.user = user;
        this.time = time;
        this.mid = mid;
    }

    public Comment(Double score, String content) {
        this.score = score;
        this.content = content;
    }


    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", score=" + score +
                ", content='" + content + '\'' +
                ", mid=" + mid +
                '}';
    }

    public Integer getMid() {
        return mid;
    }

    public void setMid(Integer mid) {
        this.mid = mid;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
