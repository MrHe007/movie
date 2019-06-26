package com.bigguy.movie.moviebox.dto;

/**
 * @author bigguy_hc
 * @create 2019-05-11 9:06
 */
public class TxMovieListReqParamsDto {

    // 在进行定义列表数据的请求中可能会出现的参数 , 这是默认值
    private Integer offset=0;     // 偏移量
    private Integer pagesize=30;   // 每页的数据

    // 默认是最近热播
    private Integer sort= 18;       // 最近热播 最新上架 豆瓣好评
    private Integer itype=-1;      // 剧情、青春 ..
    private Integer iarea=-1;       // 地区
    private Integer characteristic=-1;       // 院线 网络电影 独播 原声 粤语 蓝光 奥斯卡
    private Integer year=-1;       // 年份
    private Integer charge =-1;       // 免费 包月 用券 付费

    public Integer getItype() {
        return itype;
    }

    @Override
    public String toString() {
        return "TxMovieListReqParamsDto{" +
                "offset=" + offset +
                ", pagesize=" + pagesize +
                ", sort=" + sort +
                ", itype=" + itype +
                ", iarea=" + iarea +
                ", characteristic=" + characteristic +
                ", year=" + year +
                ", charge=" + charge +
                '}';
    }

    public void setItype(Integer itype) {
        this.itype = itype;
    }

    public Integer getOffset() {
        return offset;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public Integer getPagesize() {
        return pagesize;
    }

    public void setPagesize(Integer pagesize) {
        this.pagesize = pagesize;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Integer getIarea() {
        return iarea;
    }

    public void setIarea(Integer iarea) {
        this.iarea = iarea;
    }

    public Integer getCharacteristic() {
        return characteristic;
    }

    public void setCharacteristic(Integer characteristic) {
        this.characteristic = characteristic;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getCharge() {
        return charge;
    }

    public void setCharge(Integer charge) {
        this.charge = charge;
    }
}
