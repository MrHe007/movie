package com.bigguy.movie.moviebox.mapper;

import com.bigguy.movie.moviebox.bean.NowPlayingRespDto;
import com.bigguy.movie.moviebox.dto.NowPlayingMovieDto;
import com.bigguy.movie.moviebox.resource.MovieUrlProperties;
import com.bigguy.movie.moviebox.utils.web.MyHttpClientUtils;
import com.bigguy.movie.moviebox.utils.UrlUtils;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.net.URLDecoder;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author bigguy_hc
 * @create 2019-05-12 18:36
 */
@Repository
public class MovieDao {

//    通过腾讯搜索框搜索指定的关键字
    Logger log = LoggerFactory.getLogger(MovieDao.class);

    @Autowired
    MovieUrlProperties movieUrlProperties;

    public String getTxDataByKeyword(String keyword){

        String prefixUrl = movieUrlProperties.getTxSearchUrl();

        String url = prefixUrl + keyword;

        String html = MyHttpClientUtils.getHtml(url);


        String pat = "jQuery\\d*_\\d*\\((\\{.+\\})\\)";
        Pattern pattern = Pattern.compile(pat);
        Matcher matcher = pattern.matcher(html);

//        System.out.println(matcher);
//        System.out.println(matcher.matches());
//        System.out.println(matcher.group(1));
//        System.out.println(matcher);
//        System.out.println(matcher.matches());

        if(matcher.matches()){      // 如果匹配成功就返回
            log.info(matcher.group(1));
            return matcher.group(1);
        }

        return "";

    }

    public NowPlayingRespDto getIndexPageData(){

        // 写死
        String url = "https://movie.douban.com/cinema/nowplaying/";     // 豆瓣热映电影 首页

        Document doc = UrlUtils.getDocumentByUrl(url);

        Element body = doc.body();

        Elements newPlaying = body.select("#wrapper");

        Elements content = newPlaying.select("#content");// 根据IP
        String cityName = content.select("h1").first().text();

        Elements movieList = content.select("#nowplaying").select("ul.lists>li");

        NowPlayingRespDto respDto = new NowPlayingRespDto();
        respDto.setCityName(cityName);

        for (Element element : movieList) {
            NowPlayingMovieDto dto = new NowPlayingMovieDto();

            String id = element.attr("id");
            String movieName = element.attr("data-title");
            String score = element.attr("data-score");
            String imrUrl = element.select(".poster img").attr("src");

            String maoYanUrl = "";
            // 有可能没有猫眼的链接
            if( element.selectFirst(".sbtn>a") !=null ){
                URLDecoder.decode(element.select(".sbtn>a").attr("href").substring(46));
            }


//            String directorys = element.attr("data-actors");
//            String region = element.attr("data-region");

            dto.setMaoYanUrl(maoYanUrl);
            dto.setImgUrl(imrUrl);
            dto.setMovieId(id);
            dto.setScore(score);
            dto.setMovieName(movieName);

            respDto.getNowPlayingMovieDtos().add(dto);      // 将每个电影加进去

        }

        // 即将上映的电影
        Elements upComing = content.select("#upcoming");
        Elements upComingMovieList = upComing.select("ul.lists>li");

        for (Element element : upComingMovieList) {
            NowPlayingMovieDto dto = new NowPlayingMovieDto();

            String id = element.attr("id");
            String movieName = element.attr("data-title");
            String score = element.attr("data-score");
            String imrUrl = element.select(".poster img").attr("src");
            String release = element.select(".release-date").text();    // 上映时间
//            String maoYanUrl = element.select(".sbtn>a").attr("href");
            String maoYanUrl = "";
            Elements maoYanUrlElement = element.select(".sbtn>a");
            if(maoYanUrlElement != null && maoYanUrlElement.size()>0){        // 有些电影没有这个链接
                maoYanUrl = URLDecoder.decode(element.select(".sbtn>a").attr("href").substring(46));
            }
//            String duration = element.attr("data-duration");
//            String actors = element.attr("data-actors");
//            String directors = element.attr("data-director");
//            String region = element.attr("data-region");

            dto.setMaoYanUrl(maoYanUrl);
            dto.setImgUrl(imrUrl);
            dto.setMovieId(id);
            dto.setScore(score);
            dto.setMovieName(movieName);
            dto.setDate(release);           // 时间

            respDto.getFuturePlayingMovieDtos().add(dto);      // 将每个电影加进去
        }

        return respDto;

    }

}

