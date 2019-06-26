package com.bigguy.movie.moviebox.utils;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

/**
 * @author shkstart
 * @create 2019-03-09 14:05
 */
public class UrlUtils {

    public static Document getDocumentByUrl(String url){

        Document doc = null;
        try {
            doc = Jsoup.connect(url)
                    .userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/72.0.3626.121 Safari/537.36")
                    .timeout(3000)
                    .ignoreContentType(true)
                    .get();
            if (doc != null) {
                return doc;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return doc;

    }


    public static String getHtml(String url) {

        Document doc = null;
        try {
            doc = Jsoup.connect(url)
                    .userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/72.0.3626.121 Safari/537.36")
                    .timeout(3000)
                    .ignoreContentType(true)
                    .get();
            if (doc != null) {
                return doc.select("body").html();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        String url = "https://api.douban.com/v2/movie/in_theaters";
        String html = getHtml(url);

        System.out.println(html);

    }

}
