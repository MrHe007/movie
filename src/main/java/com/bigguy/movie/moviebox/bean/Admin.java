package com.bigguy.movie.moviebox.bean;/**
 * @Auther: hechen
 * @Date: 2019/4/15 10:58
 * @Description: ...
 */

/**
 * @author hechen
 * @data 2019/4/15
 */
public class Admin {

    private Integer aid;
    private String aname;
    private String apassword;

    public Admin(){}

    public Admin(String aname, String apassword) {
        this.aname = aname;
        this.apassword = apassword;
    }

    public Integer getAid() {
        return aid;
    }

    public void setAid(Integer aid) {
        this.aid = aid;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "aid=" + aid +
                ", aname='" + aname + '\'' +
                ", apassword='" + apassword + '\'' +
                '}';
    }

    public String getAname() {
        return aname;
    }

    public void setAname(String aname) {
        this.aname = aname;
    }

    public String getApassword() {
        return apassword;
    }

    public void setApassword(String apassword) {
        this.apassword = apassword;
    }
}
