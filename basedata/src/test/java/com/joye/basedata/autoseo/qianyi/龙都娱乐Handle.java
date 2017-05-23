package com.joye.basedata.autoseo.qianyi;

import com.joye.basedata.autoseo.ExtralResourceWriteDelegate;

import org.junit.Test;

/**
 * Created by joye on 2017/4/4.
 */

public class 龙都娱乐Handle {

    @Test
    public void testHandleKeysExcel()  {
        try {
            /**
             * 关键字生成
             * AAA:u发国际
             * AAA+AAAB+Random
             * 龙都娱乐_龙都娱乐客户端城_龙都娱乐手机下载
             */
            ExtralResourceWriteDelegate.handleKeysExcel("/Users/joye/search/word/千亿公司/龙都/龙都.xlsx","/Users/joye/search/word/千亿公司/龙都/create","1.龙都组合");
            /**
             * 域名词+关键字生成
             * long8520龙都娱乐官网_long8520龙都娱乐官网下载_long8520龙都娱乐老虎机
             */
            ExtralResourceWriteDelegate.handleDomainKeys(1,"/Users/joye/search/word/千亿公司/龙都/龙都.xlsx","/Users/joye/search/word/千亿公司/龙都/create","5.龙都域加关键字组合");
            /**
             * 域名加关键字 组合成关键字
             * long8877龙都娱乐官网_龙都娱乐官网_龙都娱乐官网
             */
            ExtralResourceWriteDelegate.handleKeysExcel(1,"/Users/joye/search/word/千亿公司/龙都/龙都.xlsx","/Users/joye/search/word/千亿公司/龙都/create","4.龙都域加关键字作为组合");
            /**
             * 域名词+关键字生成
             * long8.cc龙都娱乐备用网址_www.long8.cc.com_龙都娱乐老虎机手机版
             */
            ExtralResourceWriteDelegate.handleWWWDomainKeys(1,"/Users/joye/search/word/千亿公司/龙都/龙都.xlsx","/Users/joye/search/word/千亿公司/龙都/create","2.龙都域加关键词+www域组合");

            ExtralResourceWriteDelegate.handleWWWDomainKeysOnlyKeys(1,"/Users/joye/search/word/千亿公司/龙都/龙都.xlsx","/Users/joye/search/word/千亿公司/龙都/create","3.龙都关键词+www域组合");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



}
