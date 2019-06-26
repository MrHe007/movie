package com.bigguy.movie.moviebox.controller;

import com.bigguy.movie.moviebox.bean.MovieListNavDataBean;
import com.bigguy.movie.moviebox.bean.MovieListWebTO;
import com.bigguy.movie.moviebox.bean.NowPlayingRespDto;
import com.bigguy.movie.moviebox.resource.MovieUrlProperties;
import com.bigguy.movie.moviebox.service.MovieListService;
import com.bigguy.movie.moviebox.service.MovieWService;
import com.bigguy.movie.moviebox.service.RedisService;
import com.bigguy.movie.moviebox.utils.CommonUtils;
import com.bigguy.movie.moviebox.utils.RedisUtils;
import com.bigguy.movie.moviebox.utils.UrlUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author shkstart
 * @create 2019-03-09 14:12
 */


@CrossOrigin
@RestController
@RequestMapping("/movie")
public class MovieRestController {



//    拿到url的链接
    @Autowired
    MovieUrlProperties movieUrlProperties;
    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    MovieListService movieListService;

    @Autowired
    MovieWService movieWService;

    // 将拿到的数据放到redis中

    @Autowired
    RedisService redisService;

    @RequestMapping("/search/{keyword}")
    public String getTxSearchDataByKeyWord(@PathVariable("keyword") String keyword){
        logger.info("search : "+keyword);
        return movieWService.getTxSearchDataByKeyWord(keyword);
    }


    @RequestMapping(value = "/{index.json}", method = RequestMethod.GET)
    public NowPlayingRespDto getMovieIndexPageData(){
        return movieWService.getMovieIndexData();
    }

// 相片
    @RequestMapping("/{id}/photos.json")
    public String getPhotos(@PathVariable("id") Integer id,HttpServletRequest request){

        logger.info("getPhotos");

        String subjectPrefixUrl = movieUrlProperties.getMoviePhotos();

        String queryString = request.getQueryString();

        // https://api.douban.com/v2/movie/subject/26865690/photos
        logger.info(queryString);

        // 拼接后的url
        String okUrl = subjectPrefixUrl +"/" + id +"/photos";

        String apikey = "apikey=0b2bdeda43b5688921839c8ecb20399b";

        okUrl +="?" + apikey +"&" +queryString;

        okUrl +="&client=&udid=";

        logger.info(okUrl);

        String html = RedisUtils.getHtml(redisService, okUrl);


        return html;

    }


    // Map 简单的额数据封装返回 map
    @RequestMapping("/boxoffer2.json")
    public String getRealTimeBoxOffer(HttpServletRequest request){

        logger.info("movielist");
        String boxOfferUrl = movieUrlProperties.getRealTimeBoxOffer();

        String queryString = request.getQueryString();

        logger.info("queryString : "+queryString);


        String okUrl = boxOfferUrl;

        if(queryString!=null || !org.thymeleaf.util.StringUtils.isEmpty(queryString)){

            okUrl = boxOfferUrl +"?" + queryString;
        }

        logger.info(okUrl);

        String data = UrlUtils.getHtml(okUrl);


        return data;

    }






    // Map 简单的额数据封装返回 map
    @RequestMapping("/boxoffer3.json")
    public Map<String,Object> getRealTimeBoxOffer2(HttpServletRequest request){

        Map<String,Object> map = new HashMap<>();
        map.put("code",0);
        map.put("msg","");
        map.put("count",25);


        logger.info("movielist");
        String boxOfferUrl = movieUrlProperties.getRealTimeBoxOffer();

        String queryString = request.getQueryString();

        logger.info("queryString : "+queryString);


        String okUrl = boxOfferUrl;

        if(queryString!=null || !org.thymeleaf.util.StringUtils.isEmpty(queryString)){

            okUrl = boxOfferUrl +"?" + queryString;
        }

        logger.info(okUrl);

        String data = UrlUtils.getHtml(okUrl);


        map.put("data",data);

        return map;

    }



    // 把头部导航的数据全部封装到 bean 里面
    @RequestMapping("/navdata.json")
    public MovieListNavDataBean movieListNavData(){

        MovieListNavDataBean movieListNavDataBean = new MovieListNavDataBean();

        movieListNavDataBean.setCountries(movieListService.getCountriesList());
        movieListNavDataBean.setFeatures(movieListService.getFeaturesList());
        movieListNavDataBean.setGenres(movieListService.getGenresList());
        movieListNavDataBean.setYears(movieListService.getYearsList());
        movieListNavDataBean.setTypes(movieListService.getTypesList());


        return movieListNavDataBean;
    }


    @RequestMapping("/features.json")
    public List<String> getFeaturesList(){
        return movieListService.getFeaturesList();
    }


    @RequestMapping("/genres.json")
    public List<String> getGenresList(){
        return movieListService.getGenresList();
    }

    @RequestMapping("/countries.json")
    public List<String> getCountriesList(){
        return movieListService.getCountriesList();
    }

    @RequestMapping("/types.json")
    public List<String> getTypesList(){
        return movieListService.getTypesList();
    }


    @RequestMapping("/list.json")          // 接口地址
    public String movieList(HttpServletRequest request, MovieListWebTO obj){    // MovieListWebTO 类用于封装请求参数
        logger.info("movielist");
        String topUrl = movieUrlProperties.getMovieListUrl();                   // 电影列表的前缀，配置在文件中，后注入到类实例中，通过该类的get方法即可取到
        String queryString = CommonUtils.parseObjToStr(obj);                    // 拼接请求参数
        logger.info("queryString : "+queryString);                              // 打印请求参数
        String okUrl = topUrl + queryString;                                    // 真正访问的链接
        logger.info(okUrl);                                                     // 打印拼接好的字符串
        return RedisUtils.getHtml(redisService,okUrl);                          // 通过工具类拿到请求链接返回的数据，这里放到 redis中做缓存
    }



//    通过id获得对应的影片
    @RequestMapping(value = "/subject/{id}.json", method = RequestMethod.GET)
    public String subjectInfo(HttpServletRequest request, @PathVariable("id") Integer id){

        logger.info("subjectInfo");

        String subjectPrefixUrl = movieUrlProperties.getSubjectPrefixUrl();


        // 拼接后的url
        String okUrl = subjectPrefixUrl +"/" + id + "?" + movieUrlProperties.getSuffix();
        logger.info(okUrl);

        return  RedisUtils.getHtml(redisService, okUrl);

    }


    @RequestMapping("/search.json")
    public String searchMovie(HttpServletRequest request){

        logger.info("searchMovie");

        String topUrl = movieUrlProperties.getSearchUrl();

        String queryString = request.getQueryString();

        logger.info("queryString : "+queryString);

        String okUrl = topUrl;

        // 如果有访问参数就加进去
        if (queryString != null) {
            okUrl = okUrl +"?" +queryString;
        }

        // 拼接后的url
        logger.info(okUrl);

        return RedisUtils.getHtml(redisService, okUrl);

    }


// top250
    @RequestMapping("/top.json")
    public String getTopMovie(HttpServletRequest request){

        logger.info("getTopMovie");
        String topUrl = movieUrlProperties.getTopUrl();

        String queryString = request.getQueryString();

        logger.info("queryString : "+queryString);

        String okUrl = topUrl;

        // 如果有访问参数就加进去
        if (queryString != null) {
            okUrl = okUrl +"?" +queryString + "&" + movieUrlProperties.getSuffix();
        }

        // 拼接后的url
        logger.info(okUrl);

        return RedisUtils.getHtml(redisService, okUrl);


    }

//     获得热映电影
    @RequestMapping("/in_theaters.json")
    public String getMovieIntTheaters(HttpServletRequest request){

        logger.info("getMovieIntTheaters");

        // http://localhost/movie/in_theaters?city=%E5%8C%97%E4%BA%AC&count=10

        // 拿到请求参数部分 request.getQueryString()

//        System.out.println(request.getQueryString());           //  /movie/in_theaters
//        System.out.println(request.getRequestURI());            //  city=%E5%8C%97%E4%BA%AC&count=10

        // 拿到热映电影的url
        String inTheatersUrl = movieUrlProperties.getInTheatersUrl();

        String queryString = request.getQueryString();

        logger.info("queryString : "+queryString);

        String okUrl = inTheatersUrl + "?" + movieUrlProperties.getSuffix();

        // 如果有访问参数就加进去
        if (queryString != null) {
            okUrl = okUrl + "&" + queryString;
        }

        // 拼接后的url
        logger.info(okUrl);

        return RedisUtils.getHtml(redisService, okUrl);
    }

}
