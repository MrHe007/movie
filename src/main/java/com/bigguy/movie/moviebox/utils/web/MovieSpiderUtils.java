package com.bigguy.movie.moviebox.utils.web;

import com.bigguy.movie.moviebox.dto.AllCelebritesDto;
import com.bigguy.movie.moviebox.dto.CelebritySimpleRespDto;
import com.bigguy.movie.moviebox.dto.KVDto;
import com.bigguy.movie.moviebox.dto.MovieRespDto;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author bigguy_hc
 * @create 2019-05-14 11:15
 */
public class MovieSpiderUtils {

    public static AllCelebritesDto getCelebritiesById(Integer id){
        // 影人
        String url = "https://movie.douban.com/subject/";      // 抽取出来

        url += id + "/" +"celebrities";           // 拼接成一个完整的电影路径

        Element mainElement = MyHttpClientUtils.getMainElementByUrl(url);

        Elements listWrapperElements = mainElement.select(".celebrities .list-wrapper");

//        List<CelebritySimpleRespDto>
        int index = 0;
        AllCelebritesDto allCelebritesDto = new AllCelebritesDto();
        for (Element element : listWrapperElements) {

            if(index == 0){
                allCelebritesDto.setDirectorList(parseCelebrityListByElement(element));         // 导演
            }else if (index == 1){
                allCelebritesDto.setActorList(parseCelebrityListByElement(element));            // 演员
            }else if( index == 2){
                // 编剧
                allCelebritesDto.setWriterList(parseCelebrityListByElement(element));
            }else if( index == 3){
                allCelebritesDto.setProducerList(parseCelebrityListByElement(element));        // 制片人
            }else {
                break;              // 直接说前面几个类别
            }
            index++;                // 累加

        }
        return allCelebritesDto;
    }

    public static MovieRespDto getMovieRespDtoById(Integer id){

        MovieRespDto respDto = new MovieRespDto();

        String url = "https://movie.douban.com/subject/";
        url += id;

        Element mainElement = MyHttpClientUtils.getMainElementByUrl(url);

        // 播放链接地址

        Elements playAddrElemnts = mainElement.select(".aside .gray_ad ul li");
        List<KVDto> playAddrList = new ArrayList<>();
        for (Element element : playAddrElemnts) {

            String key = element.selectFirst("a").attr("data-cn");
            String val = element.selectFirst("a").attr("href");         // 这里需要解析出 url后面的字符
            val = val.substring(val.indexOf("url=")+4);
            playAddrList.add(new KVDto(key,val));           // 增加到播放列表里面
        }

        respDto.setPlayAddrList(playAddrList);              //  set


        Element articleElemt = mainElement.select(".article").first();

        String movieName = mainElement.selectFirst("h1").selectFirst("span").text();                                // 名字
        respDto.setName(movieName);

        String movieIntro = articleElemt.select(".related-info .indent").text();     // 电影简介
        respDto.setMovieIntro(movieIntro);

        // 影人
        List<Map<String,String>> celebritysList = new ArrayList<>();

        Elements celebrities = articleElemt.select("#celebrities");

        Map<String, String> mapTmp = null;
        for (Element celebrity : celebrities.select("ul.celebrities-list li")) {
            mapTmp = new HashMap<>();

            Element aElement = celebrity.select("a").first();
            String aLink = aElement.attr("href");
            String celebrityImgUrl = aElement.selectFirst(".avatar").attr("style");

            Element roleElement = celebrity.selectFirst(".info");
            String celebrityName = roleElement.selectFirst(".name").text();
            String celebrityRole = roleElement.selectFirst(".role").text();
            mapTmp.put("linkUrl",aLink);
            mapTmp.put("imgUrl",celebrityImgUrl);
            mapTmp.put("name",celebrityName);
            mapTmp.put("role",celebrityRole);
            celebritysList.add(mapTmp);             // 添加到影人列表

        }
        respDto.setCelebritysList(celebritysList);       // ---- setCelebritysList


        Elements basicInfoElement = articleElemt.select(".indent .subjectwrap");

        String movieScore = basicInfoElement.select("strong.rating_num").text();                // 评分
        respDto.setScore(movieScore);                                              // set

        String imgUrl = basicInfoElement.select("#mainpic img").attr("src");
        respDto.setImgUrl(imgUrl);                                                      // set

        basicInfoElement =  basicInfoElement.select("#info");

        // 导演
        List<KVDto> directors = new ArrayList<>();
        // 编剧
        List<KVDto> screenwriter = new ArrayList<>();
        // 主演
        List<KVDto> actors = new ArrayList<>();
        // 导演
        Elements actorsElements = basicInfoElement.select("span>span.attrs");

        int i = 0;
        for (Element element : actorsElements) {
            Elements aElements = element.select("a");

            if(i==0){       // 导演
                for (Element aElement : aElements) {
                    String aLink = aElement.attr("href");
                    String aText = aElement.text();
                    directors.add(new KVDto(aText,aLink));      // 加入编剧列表里面
                }

            }else if(i==1){ // 编剧
                for (Element aElement : aElements) {
                    String aLink = aElement.attr("href");
                    String aText = aElement.text();
                    screenwriter.add(new KVDto(aText,aLink));      // 加入编剧列表里面
                }

            }else if(i==2){ // 主演
                for (Element aElement : aElements) {
                    String aLink = aElement.attr("href");
                    String aText = aElement.text();
                    actors.add(new KVDto(aText,aLink));      // 加入编剧列表里面
                }
            }else{
               break;           // 退出
            }
            i++;
        }

        respDto.setActorsList(actors);                  // set
        respDto.setDirectorsList(directors);            // set
        respDto.setScreenwriterList(screenwriter);      // set

        // 剧情
        List<String> genres = new ArrayList<>();
        for (Element element : basicInfoElement.select("span[property*=genre]")) {
            genres.add(element.text());
        }
        // 上映时间
        String releaseTime = basicInfoElement.select("span[property*=initialReleaseDate]").first().text();

        // 片长
        String duration = basicInfoElement.select("span[property*=runtime]").first().text();

        respDto.setGenresList(genres);
        respDto.setScreenwriterList(screenwriter);
        respDto.setReleaseTime(releaseTime);
        respDto.setDuration(duration);

        return respDto;
    }


    public static List<CelebritySimpleRespDto> parseCelebrityListByElement(Element element){
        List<CelebritySimpleRespDto> list = new ArrayList<>();

        Elements ulLiElements = element.select("ul li");
        CelebritySimpleRespDto dto = null;
        for (Element liElement : ulLiElements) {        // 每个人
            dto = new CelebritySimpleRespDto();
            String link = liElement.selectFirst("a").attr("href");      // 从这里解析出ID
            link = link.substring(0,link.length()-1);       // 去掉 /
            Integer id = link.lastIndexOf("/"+1);

            String name = liElement.selectFirst("a").attr("title");
            String imgUrl = liElement.selectFirst("a .avatar").attr("style");

            imgUrl = imgUrl.substring(imgUrl.indexOf("(")+1, imgUrl.lastIndexOf(")"));

            Element infoElement = liElement.selectFirst(".info");
            String role = infoElement.selectFirst(".role").text();

            List<KVDto> works = new ArrayList<>();
            for (Element workElement : infoElement.select(".works a")) {
                works.add(new KVDto(workElement.text() , workElement.attr("href")));
            }

            dto.setId(id);
            dto.setImgUrl(imgUrl);          // 放值
            dto.setName(name);
            dto.setRole(role);
            dto.setLink(link);
            dto.setWorks(works);

            list.add(dto);

        }
        return list;
    }


    // 通过ID获取电影图集
    public static String getPhotosByMovieId(Integer id, String queryString){
        String url = "https://api.douban.com/v2/movie/subject/";

        url += id;
        url += "/photos";       // 内容
        url += "?apikey=0b2bdeda43b5688921839c8ecb20399b&client=something&udid=dddddddddddddddddddddd";     // apiKey

       if(queryString != null){
           url += queryString;
       }

        String html = MyHttpClientUtils.getJsonData(url);
        return html;

    }
}
