package com.joye.basedata.autoseo.qianyi;

import com.joye.basedata.autoseo.ExtralResourceWriteDelegate;

import org.junit.Test;

/**
 * Created by joye on 2017/4/4.
 */

public class 龙虎娱乐Handle {

    @Test
    public void testHandleKeysExcel()  {
        try {
            /**
             * 关键字生成
             * AAA:u发国际
             * AAA+AAAB+Random
             * 龙虎娱乐_龙虎娱乐客户端城_龙虎娱乐手机下载
             */
            ExtralResourceWriteDelegate.handleKeysExcel("/Users/joye/search/word/千亿公司/龙虎/龙虎.xlsx","/Users/joye/search/word/千亿公司/龙虎/create","1.龙虎组合");
            /**
             * 域名词+关键字生成
             * long8520龙虎娱乐官网_long8520龙虎娱乐官网下载_long8520龙虎娱乐老虎机
             */
            ExtralResourceWriteDelegate.handleDomainKeys(1,"/Users/joye/search/word/千亿公司/龙虎/龙虎.xlsx","/Users/joye/search/word/千亿公司/龙虎/create","5.龙虎域加关键字组合");
            /**
             * 域名加关键字 组合成关键字
             * long8877龙虎娱乐官网_龙虎娱乐官网_龙虎娱乐官网
             */
            ExtralResourceWriteDelegate.handleKeysExcel(1,"/Users/joye/search/word/千亿公司/龙虎/龙虎.xlsx","/Users/joye/search/word/千亿公司/龙虎/create","4.龙虎域加关键字作为组合");
            /**
             * 域名词+关键字生成
             * long8.cc龙虎娱乐备用网址_www.long8.cc.com_龙虎娱乐老虎机手机版
             */
            ExtralResourceWriteDelegate.handleWWWDomainKeys(1,"/Users/joye/search/word/千亿公司/龙虎/龙虎.xlsx","/Users/joye/search/word/千亿公司/龙虎/create","2.龙虎域加关键词+www域组合");

            ExtralResourceWriteDelegate.handleWWWDomainKeysOnlyKeys(1,"/Users/joye/search/word/千亿公司/龙虎/龙虎.xlsx","/Users/joye/search/word/千亿公司/龙虎/create","3.龙虎关键词+www域组合");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



}
