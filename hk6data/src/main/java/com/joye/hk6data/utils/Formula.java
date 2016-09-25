package com.joye.hk6data.utils;

import java.text.DecimalFormat;

import javax.inject.Singleton;

/**
 * Created by W,x (JoyeWang)
 * on 2016/9/21.
 * 304622254@qq.com
 * Remeark: 公式
 */
@Singleton
public class Formula {
    public static final DecimalFormat df = new DecimalFormat(".#");

    /**
     * 世界上最流行的博彩公式
     *
     * @param dc 发生的可能性
     * @param p  理论中奖概率
     * @return 间隔期数，遗漏值
     */
    public static String lottery(double dc, double p) {
        return df.format(Math.log(1 - dc) / Math.log(1 - p));
    }
    /**
     * 世界上最流行的博彩公式
     *
     * @param dc 发生的可能性
     * @param p  理论中奖概率
     * @return 间隔期数，遗漏值
     */
    public static double lotteryDobule(double dc, double p) {
        return  Math.log(1 - dc) / Math.log(1 - p) ;
    }
}
