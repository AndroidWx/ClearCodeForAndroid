package com.joye.basedata.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by joye on 2017/4/14.
 */

public class AntorUtils {
    /**
     * 锚文本是否合适
     * @param antor
     * @return
     */
    public static boolean antorIsTure(String antor) {
        return isContainChinese(antor)&&!antor.contains("娱乐")&&!antor.contains("传奇")&&!antor.contains("合击")
                &&!antor.contains("游戏")&&!antor.contains("全讯网")&&!antor.contains("seo")&&!antor.contains("私服")
                &&!antor.contains("癫病")&&!antor.contains("博彩")&&!antor.contains("六合彩")&&!antor.contains("时时彩")
                &&!antor.contains("合彩")&&!antor.contains("马会")&&!antor.contains("香港")&&!antor.contains("色站")
                &&!antor.contains("特码")&&!antor.contains("美女图片")&&!antor.contains("美眉")&&!antor.contains("发票")
                &&!antor.contains("七星彩")&&!antor.contains("人体艺术")&&!antor.contains("淘宝")&&!antor.contains("性感")
                &&!antor.contains("皇冠")&&!antor.contains("现金")&&!antor.contains("真人")&&!antor.contains("医药")
                &&!antor.contains("冰毒")&&!antor.contains("美女图片")&&!antor.contains("新开")&&!antor.contains("赌场")
                &&!antor.contains("cf")&&!antor.contains("成人")&&!antor.contains("开户")&&!antor.contains("做爱")
                &&!antor.contains("裸聊")&&!antor.contains("捕鱼")&&!antor.contains("漫画")&&!antor.contains("热血")
                &&!antor.contains("代孕")&&!antor.contains("撸")&&!antor.contains("哥哥射")&&!antor.contains("偷偷色");
    }


    public static boolean isContainChinese(String str) {
        try {
            Pattern p = Pattern.compile("[\u4e00-\u9fa5]");
            Matcher m = p.matcher(str);
            if (m == null) {
                return false;
            }
            if (m.find()) {
                return true;
            }
            return false;
        }catch (Exception e){
            return false;
        }
    }
}
