package com.bigguy.movie.moviebox.test;/**
 * @Auther: hechen
 * @Date: 2019/4/23 11:07
 * @Description: ...
 */

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author hechen
 * @data 2019/4/23
 */

@Component
@ConfigurationProperties(prefix = "person")
public class PersonUtils {


    private String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "PersonUtils{" +
                "url='" + url + '\'' +
                '}';
    }
}
