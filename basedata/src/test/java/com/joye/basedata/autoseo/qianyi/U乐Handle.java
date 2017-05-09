package com.joye.basedata.autoseo.qianyi;

import com.joye.basedata.autoseo.ExtralResourceWriteDelegate;

import org.junit.Test;

/**
 * Created by joye on 2017/4/4.
 */

public class U乐Handle {

    @Test
    public void testHandleKeysExcel()  {
        try {
            /**
             * 关键字生成
             * AAA:u发国际
             * AAA+AAAB+Random
             * 龙8娱乐_龙8娱乐客户端城_龙8娱乐手机下载
             */
            ExtralResourceWriteDelegate.handleKeysExcel("/Users/joye/search/word/千亿公司/优乐/优乐.xlsx","/Users/joye/search/word/千亿公司/优乐/create","1.优乐组合");
            /**
             * 域名词+关键字生成
             * long8520龙8娱乐官网_long8520龙8娱乐官网下载_long8520龙8娱乐老虎机
             */
            ExtralResourceWriteDelegate.handleDomainKeys(1,"/Users/joye/search/word/千亿公司/优乐/优乐.xlsx","/Users/joye/search/word/千亿公司/优乐/create","5.优乐域加关键字组合");
            /**
             * 域名加关键字 组合成关键字
             * long8877龙8娱乐官网_龙8娱乐官网_龙8娱乐官网
             */
            ExtralResourceWriteDelegate.handleKeysExcel(1,"/Users/joye/search/word/千亿公司/优乐/优乐.xlsx","/Users/joye/search/word/千亿公司/优乐/create","4.优乐域加关键字作为组合");
            /**
             * 域名词+关键字生成
             * long8.cc龙8娱乐备用网址_www.long8.cc.com_龙8娱乐老虎机手机版
             */
            ExtralResourceWriteDelegate.handleWWWDomainKeys(1,"/Users/joye/search/word/千亿公司/优乐/优乐.xlsx","/Users/joye/search/word/千亿公司/优乐/create","2.优乐域加关键词+www域组合");

            ExtralResourceWriteDelegate.handleWWWDomainKeysOnlyKeys(1,"/Users/joye/search/word/千亿公司/优乐/优乐.xlsx","/Users/joye/search/word/千亿公司/优乐/create","3.优乐关键词+www域组合");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
