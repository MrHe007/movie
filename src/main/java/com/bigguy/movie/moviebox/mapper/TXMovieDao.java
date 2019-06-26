package com.bigguy.movie.moviebox.mapper;

import com.bigguy.movie.moviebox.dto.TxMovieListHeaderDto;
import com.bigguy.movie.moviebox.utils.HttpUtils;
import com.bigguy.movie.moviebox.utils.JsoupUtils;
import com.bigguy.movie.moviebox.utils.PublicUtils;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author bigguy_hc
 * @create 2019-05-10 22:01
 */
@Repository
public class TXMovieDao {
    // 专门处理腾讯视频工具类

    private static final String rootUrl = "https://v.qq.com/x/bu/pagesheet/list?append=1&channel=movie&listpage=2";

    // 通过请求参数拿到电影列表数据
    public List<Map<String,String>> getMovieListDataByReqParams(String okUrl){

        String url = rootUrl + okUrl;

        Element body = JsoupUtils.getRootElementByUrl(url);


        // 返回全部数据的 list
        List<Map<String,String>> list = new ArrayList<>();

        Elements elements = body.select(".list_item");
        for (Element element : elements) {
            Element aLink = element.select("a").first();
            Map<String,String> map = new HashMap<>();

            String movieUrl =aLink.attr("href");
            String imgUrl = aLink.select("img.figure_pic").attr("src");
            String imgTitle = aLink.select("img.figure_pic").attr("alt");
            String score = aLink.select("div.figure_score").text();

            String movieName = element.select("div.figure_detail>a").text();
            String stars = element.select("div.figure_detail").text();
            String viewCount = element.select(".figure_count").text();

            map.put("movieName",movieName);
            map.put("movieUrl",movieUrl);
            map.put("imgUrl",imgUrl);
            map.put("imgTitle",imgTitle);
            map.put("score",score);
            map.put("stars",stars);
            map.put("viewCount",viewCount);

            list.add(map);

        }

        if(list.size()>0){
            return list;
        }

        return null;
    }

    // 拿到电影列表头部信息
    public TxMovieListHeaderDto getTxMovieListHeaderDto(){
        String url = "https://v.qq.com/x/bu/pagesheet/list?append=5&channel=movie&itype=100062&offset=90&pagesize=30";
        Element body = JsoupUtils.getRootElementByUrl(url);

        TxMovieListHeaderDto headerDto = new TxMovieListHeaderDto();

        Elements headerList = body.select(".mod_list_filter");

        // 排序
        Elements sortsElements = headerList.select("[data-key='sort']");
        List<Map<String,String>> sortList = new ArrayList<Map<String,String>>();
        for(Element element : sortsElements.select("a")){

            Map<String,String> temMap = new HashMap<>();
            temMap.put("name", element.text());
            temMap.put("url", element.attr("href"));
            sortList.add(temMap);
        }
        headerDto.setSortType(sortList);

//        // 剧情
//        Elements generesElements = headerList.select("[data-key='itype']");
//        List<Map<String,String>> generesList = new ArrayList<Map<String,String>>();
//        for(Element element : generesElements.select("a")){
//            generesList.add(PublicUtils.getMapByElement(element));
//        }
//        headerDto.setGeneres(generesMap);

        // 地区
        Elements areasElements = headerList.select("[data-key='iarea']");
        List<Map<String,String>> areasList = new ArrayList<Map<String,String>>();
        for(Element element : areasElements.select("a")){
            areasList.add(PublicUtils.getMapByElement(element));
        }
        headerDto.setAreas(areasList);

        // 特色
        Elements featuresElements = headerList.select("[data-key='characteristic']");
        List<Map<String,String>> featuresList = new ArrayList<Map<String,String>>();
        for(Element element : featuresElements.select("a")){
            featuresList.add(PublicUtils.getMapByElement(element));
        }
        headerDto.setFeatures(featuresList);

        // 年份
        Elements yearsElements = headerList.select("[data-key='year']");
        List<Map<String,String>> yearList = new ArrayList<Map<String,String>>();
        for(Element element : yearsElements.select("a")){
            yearList.add(PublicUtils.getMapByElement(element));
        }
        headerDto.setYears(yearList);

        // 资费
        Elements chargesElements = headerList.select("[data-key='charge']");
        List<Map<String,String>> chargeList = new ArrayList<Map<String,String>>();
        for(Element element : chargesElements.select("a")){
            String key = element.text();
            String value = element.attr("href");
            chargeList.add(PublicUtils.getMapByElement(element));
        }
        headerDto.setCharge(chargeList);

//        System.out.println(headerDto);

        return headerDto;
    }


    // 传递偏移量和每页返回的数量  返回的是 url
    private  String getMovieListUrl(Integer offset, Integer pageSize) {

//        String url = "https://v.qq.com/channel/movie?listpage=1&channel=movie";

        String url = "https://v.qq.com/x/bu/pagesheet/list?append=1&channel=movie&itype=100062";

        HashMap<String, String> map = new HashMap<>();
        map.put("offset",offset.toString());
        map.put("pagesize",pageSize.toString());

        return HttpUtils.parseUrlWithParams(url,map);
    }

    // 拿到网页源 数据
    public  String getMovieListRowString(Integer offset, Integer pageSize){

        String url = getMovieListUrl(offset,pageSize);

        Element body = JsoupUtils.getRootElementByUrl(url);
        return body.html();
    }

    public  List<Map<String,String>> getMovieListDataByPage(Integer offset, Integer pageSize){

//
////        String url = "https://v.qq.com/x/bu/pagesheet/list?append=1&channel=movie&itype=100062";
//
//        // 正在作为分页请求的 url
//        String url = getMovieListUrl(offset,pageSize);
//
//        Element body = JsoupUtils.getElementBodyByUrl(url);
//
//
//        // 返回全部数据的 list
//        List<Map<String,String>> list = new ArrayList<>();
//
//        Elements elements = body.select(".list_item");
//        for (Element element : elements) {
//            Element aLink = element.select("a").first();
//            Map<String,String> map = new HashMap<>();
//
//            String movieUrl =aLink.attr("href");
//            String imgUrl = aLink.select("img.figure_pic").attr("src");
//            String imgTitle = aLink.select("img.figure_pic").attr("alt");
//            String score = aLink.select("div.figure_score").text();
//
//            String movieName = element.select("div.figure_detail>a").text();
//            String stars = element.select("div.figure_detail").text();
//            String viewCount = element.select(".figure_count").text();
//
//            map.put("movieName",movieName);
//            map.put("movieUrl",movieUrl);
//            map.put("imgUrl",imgUrl);
//            map.put("imgTitle",imgTitle);
//            map.put("score",score);
//            map.put("stars",stars);
//            map.put("viewCount",viewCount);
//
//            list.add(map);
//
//        }
//
//        if(list.size()>0){
//            return list;
//        }

        return null;
    }



}
