package com.joye.basedata.流程;

import com.joye.basedata.crawler4j.MyCrawler;
import com.joye.basedata.webcollector.WebCollectorDelegate;

import org.junit.Test;

/**
 * Created by joye on 2017/4/18.
 */

public class B根据锚文本抓取对象站 {
    public static final String spencerFilePath="/Users/joye/Downloads/Spencer-04-21.xlsx";
    @Test
    public void testSpencer() throws Exception {
        WebCollectorDelegate.execute(spencerFilePath,"/Users/joye/Search/webconllector/spencer/",MyCrawler.getTime()+"-spencer爬站列表");
    }


    public static final String kevinFilePath="/Users/joye/Downloads/处理域名排版结果 (1).xlsx";
    @Test
    public void testKevin() throws Exception {
        WebCollectorDelegate.execute(kevinFilePath,"/Users/joye/Search/webconllector/kevin/",MyCrawler.getTime()+"-kevin爬站列表");
    }


    public static final String joyeFilePath="/Users/joye/Downloads/spencer-20170418描述本.xlsx";
    @Test
    public void testJoye() throws Exception {
        WebCollectorDelegate.execute(joyeFilePath,"/Users/joye/Search/webconllector/joye/",MyCrawler.getTime()+"-joye爬站列表");
    }


    public static final String bruceFilePath="/Users/joye/Downloads/spencer-20170418描述本.xlsx";
    @Test
    public void testBruceF() throws Exception {
        WebCollectorDelegate.execute(bruceFilePath,"/Users/joye/Search/webconllector/bruce/",MyCrawler.getTime()+"-bruce爬站列表");
    }


    public static final String lvanFilePath="/Users/joye/Downloads/ivan爬对象站.xlsx";
    @Test
    public void testLvan() throws Exception {
        WebCollectorDelegate.execute(lvanFilePath,"/Users/joye/Search/webconllector/lvan/",MyCrawler.getTime()+"-lvan爬站列表");
    }

    public static final String totalFilePath="/Users/joye/Search/域名处理/2017-4-27/处理域名排版结果.xlsx";
    /**
     * 选取最合适的对象站信息
     * @throws Exception
     */
    @Test
    public void testTotal() throws Exception {
        WebCollectorDelegate.executeDomain(totalFilePath,"/Users/joye/Search/webconllector/joye/",MyCrawler.getTime()+"-joye爬站列表");
    }

}
