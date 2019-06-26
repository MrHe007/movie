package com.bigguy.movie.moviebox.utils;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;


/**
 * @author bigguy_hc
 * @create 2019-05-11 7:40
 */
public class JsoupUtils {

    static Logger logger = LoggerFactory.getLogger(JsoupUtils.class);

    public static Element getBodyElementByUrl(String url){
        return getRootElementByUrl(url).select("body").first();
    }

    public static Element getMainElementByUrl(String url){
        return getRootElementByUrl(url).select("#content").first();
    }

    public static String getHtmlByUrl(String url){
        return getRootElementByUrl(url).html();
    }

    public static Element getRootElementByUrl(String url){

        logger.info("URL: "+url);

        Connection connect = Jsoup.connect(url);
        connect.userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/70.0.3538.67 Safari/537.36");
        connect.timeout(10000);
        Document doc = null;
        try {
            doc = connect.get();
        } catch (IOException e) {
            e.printStackTrace();
        }

        if(doc!=null){
            return doc.body();
        }
        return null;
    }
}
