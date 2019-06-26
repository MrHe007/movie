package com.bigguy.movie.moviebox.bean;/**
 * @author shkstart
 * @create 2019-03-20 11:05
 */

import java.util.List;

/**
 * @author hechen
 * @data 2019/3/20
 *
 */
public class Work {

    List<String >roles;

    MovieBean subject;

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

    public MovieBean getSubject() {
        return subject;
    }

    public void setSubject(MovieBean subject) {
        this.subject = subject;
    }

    @Override
    public String toString() {
        return "Work{" +
                "roles=" + roles +
                ", subject=" + subject +
                '}';
    }
}
