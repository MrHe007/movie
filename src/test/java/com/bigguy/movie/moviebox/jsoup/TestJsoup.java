package com.bigguy.movie.moviebox.jsoup;/**
 * @author shkstart
 * @create 2019-03-26 17:53
 */

import com.bigguy.movie.moviebox.utils.TXPageUtils;
import com.bigguy.movie.moviebox.utils.UrlUtils;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;

import java.io.IOException;
import java.net.URLDecoder;

/**
 * @author hechen
 * @data 2019/3/26
 *
 */
public class TestJsoup {

    @Test
    public void testTxSearch(){

        String prefixUrl="https://s.video.qq.com/smartbox?callback=jQuery19108297668843347656_1557542215608&plat=2&ver=0&num=2&otype=json&uid=b2b7eaeb-939a-44ff-80cd-1a70a17fc119&_=1557542215622&query=";
        String keyWord = "飞驰人生";
        String url = prefixUrl + keyWord;

        Document doc = UrlUtils.getDocumentByUrl(url);


    }

    @Test
    public void testUrl(){

        String url = "https://movie.douban.com/ticket/redirect/?url=https%3A%2F%2Fm.maoyan.com%2Fcinema%2Fmovie%2F346629%3F_v_%3Dyes%26merCode%3D1000011\n";

        int i = url.indexOf("=");
        System.out.println(i);

        String decode = URLDecoder.decode(url);
        System.out.println(decode);

    }

    @Test
    public void testCirema(){

        String url = "https://movie.douban.com/cinema/nowplaying/";

        Document doc = UrlUtils.getDocumentByUrl(url);

        Element body = doc.body();

        Elements newPlaying = body.select("#wrapper");

        Elements content = newPlaying.select("#content");// 根据IP
        String cityName = content.select("h1").first().text();

        Elements movieList = content.select("#nowplaying").select("ul.lists>li");

        for (Element element : movieList) {
            String id = element.attr("id");
            String movieName = element.attr("data-title");
            String score = element.attr("data-score");
            String directorys = element.attr("data-actors");
            String region = element.attr("data-region");
            String imrUrl = element.select(".poster img").attr("src");
            String maoYanUrl = URLDecoder.decode(element.select(".sbtn>a").attr("href").substring(46));
            System.out.println("-");

        }

        // 即将上映的电影
        Elements upComing = content.select("#upcoming");
        Elements upComingMovieList = upComing.select("ul.lists>li");

        for (Element element : upComingMovieList) {
            String id = element.attr("id");
            String movieName = element.attr("data-title");
            String duration = element.attr("data-duration");
            String actors = element.attr("data-actors");
            String directors = element.attr("data-director");
            String region = element.attr("data-region");

            String imrUrl = element.select(".poster img").attr("src");
            String release = element.select(".release-date").text();    // 上映时间
            String maoYanUrl = element.select(".sbtn>a").attr("href");
            System.out.println("-");

        }


        System.out.println(newPlaying.html());


    }

    @Test
    public void testTXPageUtils() throws IOException {


        String movieListUrl = TXPageUtils.getMovieListUrl(30, 30);

        System.out.println(movieListUrl);

        Connection connect = Jsoup.connect(movieListUrl);
        connect.userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/70.0.3538.67 Safari/537.36");
        connect.timeout(3000);
        Document doc = connect.get();

        System.out.println(doc.body());


    }


    @Test
    public void testTecent() throws IOException {

//        String url = "https://v.qq.com/x/bu/pagesheet/list?append=1&channel=movie&itype=100062&listpage=2&offset=90&pagesize=30";

        String url = "https://v.qq.com/x/bu/pagesheet/list?append=1&channel=movie&itype=100062";

        Connection connect = Jsoup.connect(url);
            connect.userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/70.0.3538.67 Safari/537.36");
            connect.timeout(3000);
        Document doc = connect.get();

        Element body = doc.body();

        Elements elements = body.select(".list_item");
        for (Element element : elements) {
            Element aLink = element.select("a").first();

            String movieUrl =aLink.attr("href");
            String imgUrl = aLink.select("img.figure_pic").attr("src");
            String imgTitle = aLink.select("img.figure_pic").attr("alt");
            String score = aLink.select("div.figure_score").text();

            String stars = element.select("div.figure_detail").text();
            String viewCount = element.select(".figure_count").text();
        }

        System.out.println(body);


    }

    @Test
    public void testNews(){

        String url = "https://maoyan.com/news?showTab=2";

        String userAgent = "";

        Document doc = null;
        try {
            doc = Jsoup.connect("http://example.com/")
                    .userAgent(userAgent).get();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String title = doc.title();

    }
}
