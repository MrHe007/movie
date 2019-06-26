package com.bigguy.movie.moviebox.controller;

import com.bigguy.movie.moviebox.dto.TxMovieListHeaderDto;
import com.bigguy.movie.moviebox.dto.TxMovieListReqParamsDto;
import com.bigguy.movie.moviebox.service.TxMovieService;
import com.bigguy.movie.moviebox.utils.JsoupUtils;
import com.bigguy.movie.moviebox.utils.TxMovieListReqParamsUtils;
import org.jsoup.nodes.Element;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @author bigguy_hc
 * @create 2019-05-11 7:27
 */
@RestController
@RequestMapping("api/movie")
public class TxMovieRestController {

    @Autowired
    TxMovieService txMovieService;

    @RequestMapping("/search/{word}")
    public String getTxSearchDataByKeyword(@PathVariable("word") String word){
        String prefixUrl="https://s.video.qq.com/smartbox?callback=jQuery19108297668843347656_1557542215608&plat=2&ver=0&num=2&otype=json&uid=b2b7eaeb-939a-44ff-80cd-1a70a17fc119&_=1557542215622&query=";
        String keyWord = "飞驰人生";
        String url = prefixUrl + keyWord;

        Element body = JsoupUtils.getRootElementByUrl(url);
        return body.html();
    }


    // 增加一些参数来拿到对应类型的数据
    @RequestMapping(value = "/plist", method = RequestMethod.GET)
    public List<Map<String,String>> getMovieListDataWithParams(TxMovieListReqParamsDto paramsDto){

        // 判断一些逻辑
        // 是否有分页数据，或者是其他的数据
        String reqParams = TxMovieListReqParamsUtils.parseParam(paramsDto); // 返回拼接好的请求参数
        List<Map<String, String>> movieListData = txMovieService.getMovieListDataByReqParam(reqParams);

        return movieListData;
    }


    // 拿到movie-list 头部的json 格式
    @RequestMapping("/header.json")
    public TxMovieListHeaderDto movieListHeaderDto(){

        return txMovieService.getTxMovieListHeaderDto();

    }

    @RequestMapping("/demo")
    public String demo(){
        return "hello world";
    }

    // 传入请求偏移量 和 单页数
    @RequestMapping(value = "/list.json",method = RequestMethod.GET)
    public List<Map<String,String>> getMovieList(Integer offset, Integer pagesize){

        // 没有这个参数表示从0 开始查
        if(offset==null){
            offset = 0;
        }
        List<Map<String, String>> movieList = txMovieService.getMovieList(offset, pagesize);

        return movieList;
    }

}
