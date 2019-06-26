package com.bigguy.movie.moviebox.service;

import com.bigguy.movie.moviebox.dto.TxMovieListHeaderDto;
import com.bigguy.movie.moviebox.dto.TxMovieListReqParamsDto;
import com.bigguy.movie.moviebox.mapper.TXMovieDao;
import com.bigguy.movie.moviebox.utils.TxMovieListReqParamsUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author bigguy_hc
 * @create 2019-05-11 7:29
 */
@Service
public class TxMovieService {
    @Autowired
    TXMovieDao movieDao;

    public  List<Map<String,String>> getMovieListDataByReqParam(String okParams){

        List<Map<String, String>> movieListDataByReqParams = movieDao.getMovieListDataByReqParams(okParams);

        return movieListDataByReqParams;
    }

    public TxMovieListHeaderDto getTxMovieListHeaderDto(){

        TxMovieListHeaderDto txMovieListHeaderDto = movieDao.getTxMovieListHeaderDto();
        return txMovieListHeaderDto;
    }

    // 分页
    public List<Map<String,String>> getMovieList(Integer offset, Integer pagesize){

        TxMovieListReqParamsDto paramsDto = new TxMovieListReqParamsDto();
        paramsDto.setOffset(offset);
        paramsDto.setPagesize(pagesize);

        String okParams = TxMovieListReqParamsUtils.parseParam(paramsDto);
        List<Map<String, String>> movieListDataByReqParam = this.getMovieListDataByReqParam(okParams);

        return movieListDataByReqParam;
    }

}
