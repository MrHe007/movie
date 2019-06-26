package com.bigguy.movie.moviebox.dto;

import java.util.List;

/**
 * @author bigguy_hc
 * @create 2019-05-15 9:54
 */
public class AllCelebritesDto {

    private List<CelebritySimpleRespDto> directorList;     // 导演列表
    private List<CelebritySimpleRespDto> actorList;     // 导演列表
    private List<CelebritySimpleRespDto> writerList;     // 编剧列表
    private List<CelebritySimpleRespDto> producerList;     // 制作人列表

    public List<CelebritySimpleRespDto> getDirectorList() {
        return directorList;
    }

    public void setDirectorList(List<CelebritySimpleRespDto> directorList) {
        this.directorList = directorList;
    }

    public List<CelebritySimpleRespDto> getActorList() {
        return actorList;
    }

    public void setActorList(List<CelebritySimpleRespDto> actorList) {
        this.actorList = actorList;
    }

    public List<CelebritySimpleRespDto> getWriterList() {
        return writerList;
    }

    public void setWriterList(List<CelebritySimpleRespDto> writerList) {
        this.writerList = writerList;
    }

    public List<CelebritySimpleRespDto> getProducerList() {
        return producerList;
    }

    public void setProducerList(List<CelebritySimpleRespDto> producerList) {
        this.producerList = producerList;
    }
}
