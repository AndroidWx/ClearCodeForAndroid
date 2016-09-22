package com.joye.hk6data.entity;

/**
 * Created by W,x (JoyeWang)
 * on 2016/9/22.
 * 304622254@qq.com
 * Remeark:
 */
public class DataTransformerEntity {
    private String[] mEvictors;
    private String  winningNumber;

    public DataTransformerEntity(String[] mEvictors, String winningNumber) {
        this.mEvictors = mEvictors;
        this.winningNumber = winningNumber;
    }

    public String[] getmEvictors() {
        return mEvictors;
    }

    public void setmEvictors(String[] mEvictors) {
        this.mEvictors = mEvictors;
    }

    public String getWinningNumber() {
        return winningNumber;
    }

    public void setWinningNumber(String winningNumber) {
        this.winningNumber = winningNumber;
    }
}
