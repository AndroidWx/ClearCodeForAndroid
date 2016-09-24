package com.joye.hk6domain.entity;

/**
 * Created by W,x (JoyeWang)
 * on 2016/9/20.
 * 304622254@qq.com
 * Remeark:
 */

public class Hk6UiData  implements ReportI{
    /**
     * 期数
     */
    private String expect;
    /**
     * 平码
     */
    private String[]evictors;

    /**
     * 中奖号码
     */
    private int openCode;

    /**
     * 开奖时间
     */
    private String opentime;

    /**
     * 开奖时间戳
     */
    private long opentimestamp;

    /**
     *
     * @return 开奖期数
     */
    public String getExpect() {
        return expect;
    }


    public void setExpect(String expect) {
        this.expect = expect;
    }

    /**
     *
     * @return 平码s
     */
    public String[] getEvictors() {
        return evictors;
    }

    public void setEvictors(String[] evictors) {
        this.evictors = evictors;
    }

    /**
     *
     * @return 中奖号码
     */
    @Override
    public int getOpenCode() {
        return openCode;
    }

    public void setOpenCode(int openCode) {
        this.openCode = openCode;
    }

    /**
     *
     * @return 开奖时间
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
    public long getOpentimestamp() {
        return opentimestamp;
    }

    public void setOpentimestamp(long opentimestamp) {
        this.opentimestamp = opentimestamp;
    }

}
