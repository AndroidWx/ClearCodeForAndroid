package com.joye.basedata.autoseo.qianyi;

import com.joye.basedata.autoseo.ExtralResourceWriteDelegate;

import org.junit.Test;

/**
 * Created by joye on 2017/4/4.
 */

public class 武松娱乐Handle {

    @Test
    public void testHandleKeysExcel()  {
        try {
            /**
             * 关键字生成
             * AAA:武松娱乐国际
             * AAA+AAAB+Random
             * 龙8娱乐_龙8娱乐客户端城_龙8娱乐手机下载
             */
             ExtralResourceWriteDelegate.handleKeysExcel("/Users/joye/search/word/千亿公司/武松娱乐/武松娱乐关键字整理.xlsx","/Users/joye/search/word/千亿公司/武松娱乐/create","1.武松娱乐组合");
            /**
             * 域名词+关键字生成
             * long8520龙8娱乐官网_long8520龙8娱乐官网下载_long8520龙8娱乐老虎机
             */
            ExtralResourceWriteDelegate.handleDomainKeys("/Users/joye/search/word/千亿公司/武松娱乐/武松娱乐关键字整理.xlsx","/Users/joye/search/word/千亿公司/武松娱乐/武松娱乐域词.xlsx","/Users/joye/search/word/千亿公司/武松娱乐/create","4.武松娱乐域加关键字组合");
            /**
             * 域名加关键字 组合成关键字
             * long8877龙8娱乐官网_龙8娱乐官网_龙8娱乐官网
             */
            ExtralResourceWriteDelegate.handleKeysExcel("/Users/joye/search/word/千亿公司/武松娱乐/武松娱乐关键字整理.xlsx","/Users/joye/search/word/千亿公司/武松娱乐/武松娱乐域词.xlsx","/Users/joye/search/word/千亿公司/武松娱乐/create","3.武松娱乐域加关键字作为组合");
            /**
             * 域名词+关键字生成
             * long8.cc龙8娱乐备用网址_www.long8.cc.com_龙8娱乐老虎机手机版
             */
             ExtralResourceWriteDelegate.handleWWWDomainKeys("/Users/joye/search/word/千亿公司/武松娱乐/武松娱乐关键字整理.xlsx","/Users/joye/search/word/千亿公司/武松娱乐/武松娱乐域词.xlsx","/Users/joye/search/word/千亿公司/武松娱乐/create","5.武松娱乐域加关键词+www域组合");

            ExtralResourceWriteDelegate.handleWWWDomainKeysOnlyKeys("/Users/joye/search/word/千亿公司/武松娱乐/武松娱乐关键字整理.xlsx","/Users/joye/search/word/千亿公司/武松娱乐/武松娱乐域词.xlsx","/Users/joye/search/word/千亿公司/武松娱乐/create","2.武松娱乐关键词+www域组合");


        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
