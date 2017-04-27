package com.joye.basedata.autoseo.bf88;

import com.joye.basedata.autoseo.ExtralResourceWriteDelegate;

import org.junit.Test;

/**
 * Created by joye on 2017/4/4.
 */

public class 必发Handle {

    @Test
    public void testHandleKeysExcel()  {
        try {
            /**
             * 关键字生成
             * AAA:88必发
             * AAA+AAAB+Random
             * 龙8娱乐_龙8娱乐客户端城_龙8娱乐手机下载
             */
            ExtralResourceWriteDelegate.handleKeysExcel("/Users/joye/search/word/88必发/88必发娱乐关键词整理.xlsx","/Users/joye/search/word/88必发/create","88必发娱乐组合");
            /**
             * 域名词+关键字生成
             * long8520龙8娱乐官网_long8520龙8娱乐官网下载_long8520龙8娱乐老虎机
             */
            ExtralResourceWriteDelegate.handleDomainKeys("/Users/joye/search/word/88必发/88必发娱乐关键词整理.xlsx","/Users/joye/search/word/88必发/88必发域词.xlsx","/Users/joye/search/word/88必发/create","88必发娱乐域加关键字组合");
            /**
             * 域名加关键字 组合成关键字
             * long8877龙8娱乐官网_龙8娱乐官网_龙8娱乐官网
             */
            ExtralResourceWriteDelegate.handleKeysExcel("/Users/joye/search/word/88必发/88必发娱乐关键词整理.xlsx","/Users/joye/search/word/88必发/88必发域词.xlsx","/Users/joye/search/word/88必发/create","88必发娱乐域加关键字作为组合");
            /**
             * 域名词+关键字生成
             * long8.cc龙8娱乐备用网址_www.long8.cc.com_龙8娱乐老虎机手机版
             */
            ExtralResourceWriteDelegate.handleWWWDomainKeys("/Users/joye/search/word/88必发/88必发娱乐关键词整理.xlsx","/Users/joye/search/word/88必发/88必发域词.xlsx","/Users/joye/search/word/88必发/create","88必发娱乐关键词+www域组合");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
