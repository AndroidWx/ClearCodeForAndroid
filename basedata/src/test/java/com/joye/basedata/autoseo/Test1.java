package com.joye.basedata.autoseo;

import org.junit.Test;

/**
 * Created by joye on 2017/4/4.
 */

public class Test1 {



    /**
     * 关键字生成
     * AAA:千亿国际
     * AAA+AAAB+Random
     * 龙8娱乐_龙8娱乐客户端城_龙8娱乐手机下载
     */
    @Test
    public void testHandleKeysExcel()  {
        try {
            ExtralResourceWriteDelegate.handleKeysExcel("/Users/joye/downloads/test2.xlsx","/Users/joye/downloads/","龙8娱乐组合");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testAll() throws Exception {


    }
/**
     * 域名词+关键字生成
     * long8520龙8娱乐官网_long8520龙8娱乐官网下载_long8520龙8娱乐老虎机
     */
    /**
     *
     * @throws Exception
     */
    @Test
    public void testHandleDomainKeys() throws Exception {
        ExtralResourceWriteDelegate.handleDomainKeys("/Users/joye/downloads/test2.xlsx","/Users/joye/downloads/龙8域词.xlsx","/Users/joye/downloads/","龙8域加关键字组合");
    }

    /**
     * 域名加关键字 组合成关键字
     * long8877龙8娱乐官网_龙8娱乐官网_龙8娱乐官网
     */
    @Test
    public void testHandleKeysExcel1()  {
        try {
            ExtralResourceWriteDelegate.handleKeysExcel("/Users/joye/downloads/test2.xlsx","/Users/joye/downloads/龙8域词.xlsx","/Users/joye/downloads/","龙8域加关键字作为组合");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 域名词+关键字生成
     * long8.cc龙8娱乐备用网址_www.long8.cc.com_龙8娱乐老虎机手机版
     */

    @Test
    public void testHandleWWWDomainKeys() throws Exception {
        ExtralResourceWriteDelegate.handleWWWDomainKeys("/Users/joye/downloads/test2.xlsx","/Users/joye/downloads/龙8域词.xlsx","/Users/joye/downloads/","龙8关键词+www域组合");
    }


    @Test
    public void testAbc() throws Exception {
        String s="142.234.221.71    twdwL.com";

        System.out.println(s.replaceAll("[^a-zA-Z.]",""));
        System.out.println(s.replaceAll("[^0-9.]",""));

    }
}
