package com.joye.hk6data.entity;

/**
 * Created by W,x (JoyeWang)
 * on 2016/9/20.
 * 304622254@qq.com
 * Remeark: 六合彩实体
 */

public class Hk6Entity {

    /**
     * expect : 2016107
     * opencode : **,18,42,25,03,31+26
     * opentime : 2016-09-17 21:35:29
     * opentimestamp : 1474119329
     */
    //日期
    private String expect;
    //开奖号码
    private String opencode;
    //开奖时间
    private String opentime;
    //开奖时间戳
    private int opentimestamp;

    /**
     *
     * @return 开奖日期
     */
    public String getExpect() {
        return expect;
    }

    public void setExpect(String expect) {
        this.expect = expect;
    }

    /**
     *
     * @return 开奖号码
     */
    public String getOpencode() {
        return opencode;
    }

    public void setOpencode(String opencode) {
        this.opencode = opencode;
    }

    /**
     *
     * @return 开奖日期
     */
    public String getOpentime() {
        return opentime;
    }

    public void setOpentime(String opentime) {
        this.opentime = opentime;
    }

    /**
     *
     * @return 开奖时间戳
     */
    public int getOpentimestamp() {
        return opentimestamp;
    }

    public void setOpentimestamp(int opentimestamp) {
        this.opentimestamp = opentimestamp;
    }
}
