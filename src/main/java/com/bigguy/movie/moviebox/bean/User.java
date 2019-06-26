package com.bigguy.movie.moviebox.bean;

/**
 * @author bigguy_hc
 * @create 2019-02-11 11:42
 */
public class User {

    private Integer uid;
    private String username;
    private String password;
    private String email = "";

    private String imgUrl;
    private String phone;

    private String birthday;

    private short state;            // 用户是否允许登入：1:允许，0：不允许


    public User(String username, String password, String email, String imgUrl, String phone, String birthday, short state) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.imgUrl = imgUrl;
        this.phone = phone;
        this.birthday = birthday;
        this.state = state;
    }

    public short getState() {
        return state;
    }

    public void setState(short state) {
        this.state = state;
    }

    public User(){

    }

    public User(String username, String password, String email, String phone, String birthday) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.phone = phone;
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "User{" +
                "uid='" + uid + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", imgUrl='" + imgUrl + '\'' +
                ", phone=" + phone +

                ", birthday='" + birthday + '\'' +
                '}';
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public User(String password){
        this.password = password;
    }

    public User(Integer uid) {
        this.uid = uid;
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

}
