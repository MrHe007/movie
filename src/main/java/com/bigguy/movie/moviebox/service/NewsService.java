package com.bigguy.movie.moviebox.service;/**
 * @Auther: hechen
 * @Date: 2019/3/29 14:35
 * @Description: ...
 */

import com.bigguy.movie.moviebox.bean.NewsItem;
import com.bigguy.movie.moviebox.mapper.NewsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author hechen
 * @data 2019/3/29
 */
@Service
public class NewsService {

    @Autowired
    NewsMapper newsMapper;
    
    public boolean saveNewItem(NewsItem newsItem){
        return newsMapper.addNewsItem(newsItem);
    }

    public List<NewsItem> selectNewsListByPage(Integer curr,Integer limit){
        // 计算得到数据的起始号
        return newsMapper.selectNewsListByPage((curr-1)*limit,curr*limit);
    }

    public NewsItem getNewsItem(Integer id){
        return newsMapper.selectNewsItemById(id);
    }

    public Integer getNewsCount(){
        return newsMapper.getNewsCount();
    }


    public boolean updateNewItem(NewsItem newsItem) {

        boolean b = newsMapper.updateNewsItem(newsItem);
        return b;

    }

    public boolean delNewsItem(Integer id){
        boolean b = newsMapper.deleteNewsItemById(id);
        return b;
    }

}
