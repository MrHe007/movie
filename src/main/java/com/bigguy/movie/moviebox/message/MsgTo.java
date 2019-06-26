package com.bigguy.movie.moviebox.message;

/**
 * @author bigguy_hc
 * @create 2019-02-12 20:58
 */
public class MsgTo extends BaseMsg{
    private String msg = "ok";
    private int code =200;

    public MsgTo(){

    }

    public MsgTo(String msg){
        this.msg = msg;
    }


    public MsgTo(String msg, int code) {
        this.msg = msg;
        this.code = code;
    }

    @Override
    public String toString() {
        return "MsgTo{" +
                "msg='" + msg + '\'' +
                ", code=" + code +
                '}';
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
