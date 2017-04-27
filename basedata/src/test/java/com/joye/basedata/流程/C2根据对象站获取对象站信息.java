package com.joye.basedata.流程;

import com.alibaba.dcm.DnsCache;
import com.alibaba.dcm.DnsCacheManipulator;
import com.joye.basedata.autoseo.ExtralResourceWriteDelegate;
import com.joye.basedata.crawler4j.AllDomainsDelegate;
import com.joye.basedata.crawler4j.team.BruceCrawler;
import com.joye.basedata.crawler4j.team.JoyeCrawler;
import com.joye.basedata.crawler4j.team.KevinCrawler;
import com.joye.basedata.crawler4j.team.LvanCrawler;
import com.joye.basedata.crawler4j.team.SpencerCrawler;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import edu.uci.ics.crawler4j.crawler.CrawlConfig;
import edu.uci.ics.crawler4j.crawler.CrawlController;
import edu.uci.ics.crawler4j.fetcher.PageFetcher;
import edu.uci.ics.crawler4j.robotstxt.RobotstxtConfig;
import edu.uci.ics.crawler4j.robotstxt.RobotstxtServer;

/**
 * Created by joye on 2017/4/7.
 */

public class C2根据对象站获取对象站信息 {
    public static final String crawlStorageFolder = "/Users/joye/Search/crawler";
    public static final int numberOfCrawlers =9;

    public static final String joyePath="/Users/joye/Downloads/spencer-20170408对象站.xlsx";
    @Test
    public void testJoye() throws Exception {
        testJoyeCrawler();
    }


    public static final String brucePath="/Users/joye/Downloads/域名大全.xlsx";
    @Test
    public void testBruce() throws Exception {
        testBruceCrawler();
    }


    public static final String kevinPath="/Users/joye/Downloads/2017-04-24-kevin-对象站.xlsx";
    @Test
    public void testKevin() throws Exception {
        testKevinCrawler();
    }


    public static final String spencerPath="/Users/joye/Downloads/2017-04-21-spencer爬站列表.xlsx";
    @Test
    public void testSpencer() throws Exception {
        testSpencerCrawler();
    }


    public static final String lvanPath="/Users/joye/Downloads/2017-04-21-spencer爬站列表.xlsx";
    @Test
    public void testLvan() throws Exception {
        testLvanCrawler();
    }

    @Test
    public void testLookDNS() throws Exception {
        DnsCacheManipulator.setDnsCache("www.hello.com", "192.168.1.1");
        DnsCache dnsCache = DnsCacheManipulator.getWholeDnsCache();
        System.out.println(dnsCache);

    }

    /**
     * 1.读取对象站列表
     * 2.把对象站加入
     * @throws Exception
     */
    @Test
    public void testBruceCrawler() throws Exception {
        DnsCacheManipulator.clearDnsCache();
        //设置爬虫数量
        AllDomainsDelegate.getInstance().setCrawlerTotal(numberOfCrawlers);
        //对象站列表
        List<String> domains=new ArrayList<>();
        //获取所有的对象站
        domains= ExtralResourceWriteDelegate.getAllKeysByFilePath(brucePath,1);
        CrawlController controller = getCrawlController();
        //获取老域名
        List<String> oldDomains=ExtralResourceWriteDelegate.getAllKeysByFilePath(brucePath);
        if(oldDomains==null||oldDomains.size()==0||domains==null||oldDomains.size()==0||oldDomains.size()!=domains.size()){
            System.out.println("对象站和老域名的数量必须一样");
          return;
        }

        for (int i=0;i< domains.size();i++){
            //加入爬虫
            try {
                controller.addSeed(domains.get(i));
            } catch (Exception e) {
                System.out.println(i);
                System.out.println(domains.get(i));
                e.printStackTrace();

            }

            //设置所有的对象站
            AllDomainsDelegate.getInstance().getListDomains().add(domains.get(i));
            AllDomainsDelegate.getInstance().getOldListDomains().add(oldDomains.get(i));
        }
        /*
         * Start the crawl. This is a blocking operation, meaning that your code
         * will reach the line after this only when crawling is finished.
         */
        controller.start(BruceCrawler.class, numberOfCrawlers);
    }


    /**
     * 1.读取对象站列表
     * 2.把对象站加入
     * @throws Exception
     */
    @Test
    public void testJoyeCrawler() throws Exception {
        AllDomainsDelegate.getInstance().setCrawlerTotal(numberOfCrawlers);
        List<String> domains=new ArrayList<>();
        domains= ExtralResourceWriteDelegate.getAllKeysByFilePath(joyePath,1);
        CrawlController controller = getCrawlController();
        //获取老域名
        List<String> oldDomains=ExtralResourceWriteDelegate.getAllKeysByFilePath(joyePath);
        if(oldDomains==null||oldDomains.size()==0||domains==null||oldDomains.size()==0||oldDomains.size()!=domains.size()){
            System.out.println("对象站和老域名的数量必须一样");
            return;
        }

        for (int i=0;i< domains.size();i++){
            //加入爬虫
            controller.addSeed(domains.get(i));
            //设置所有的对象站
            AllDomainsDelegate.getInstance().getListDomains().add(domains.get(i));
            AllDomainsDelegate.getInstance().getOldListDomains().add(oldDomains.get(i));
        }
        /*
         * Start the crawl. This is a blocking operation, meaning that your code
         * will reach the line after this only when crawling is finished.
         */
        controller.start(JoyeCrawler.class, numberOfCrawlers);
    }

    /**
     * 1.读取对象站列表
     * 2.把对象站加入
     * @throws Exception
     */
    @Test
    public void testSpencerCrawler() throws Exception {
        AllDomainsDelegate.getInstance().setCrawlerTotal(numberOfCrawlers);
        List<String> domains=new ArrayList<>();
        domains= ExtralResourceWriteDelegate.getAllKeysByFilePath(spencerPath,1);
        CrawlController controller = getCrawlController();
        //获取老域名
        List<String> oldDomains=ExtralResourceWriteDelegate.getAllKeysByFilePath(spencerPath);
        if(oldDomains==null||oldDomains.size()==0||domains==null||oldDomains.size()==0||oldDomains.size()!=domains.size()){
            System.out.println("对象站和老域名的数量必须一样");
            return;
        }

        for (int i=0;i< domains.size();i++){
            //加入爬虫
            controller.addSeed(domains.get(i));
            //设置所有的对象站
            AllDomainsDelegate.getInstance().getListDomains().add(domains.get(i));
            AllDomainsDelegate.getInstance().getOldListDomains().add(oldDomains.get(i));
        }
        /*
         * Start the crawl. This is a blocking operation, meaning that your code
         * will reach the line after this only when crawling is finished.
         */
        controller.start(SpencerCrawler.class, numberOfCrawlers);
    }

    /**
     * 1.读取对象站列表
     * 2.把对象站加入
     * @throws Exception
     */
    @Test
    public void testKevinCrawler() throws Exception {
        AllDomainsDelegate.getInstance().setCrawlerTotal(numberOfCrawlers);
        List<String> domains=new ArrayList<>();
        domains= ExtralResourceWriteDelegate.getAllKeysByFilePath(kevinPath,1);
        CrawlController controller = getCrawlController();
        //获取老域名
        List<String> oldDomains=ExtralResourceWriteDelegate.getAllKeysByFilePath(kevinPath);
        if(oldDomains==null||oldDomains.size()==0||domains==null||oldDomains.size()==0||oldDomains.size()!=domains.size()){
            System.out.println("对象站和老域名的数量必须一样");
            return;
        }

        for (int i=0;i< domains.size();i++){
            //加入爬虫
            controller.addSeed(domains.get(i));
            //设置所有的对象站
            AllDomainsDelegate.getInstance().getListDomains().add(domains.get(i));
            AllDomainsDelegate.getInstance().getOldListDomains().add(oldDomains.get(i));
        }
        /*
         * Start the crawl. This is a blocking operation, meaning that your code
         * will reach the line after this only when crawling is finished.
         */
        controller.start(KevinCrawler.class, numberOfCrawlers);
    }


    /**
     * 1.读取对象站列表
     * 2.把对象站加入
     * @throws Exception
     */
    @Test
    public void testLvanCrawler() throws Exception {
        AllDomainsDelegate.getInstance().setCrawlerTotal(numberOfCrawlers);
        List<String> domains=new ArrayList<>();
        domains= ExtralResourceWriteDelegate.getAllKeysByFilePath(lvanPath,1);
        CrawlController controller = getCrawlController();
        //获取老域名
        List<String> oldDomains=ExtralResourceWriteDelegate.getAllKeysByFilePath(lvanPath);
        if(oldDomains==null||oldDomains.size()==0||domains==null||oldDomains.size()==0||oldDomains.size()!=domains.size()){
            System.out.println("对象站和老域名的数量必须一样"+domains.size()+"----老域名数量"+oldDomains.size());
            return;
        }

        for (int i=0;i< domains.size();i++){
            //加入爬虫
            controller.addSeed(domains.get(i));
            //设置所有的对象站
            AllDomainsDelegate.getInstance().getListDomains().add(domains.get(i));
            AllDomainsDelegate.getInstance().getOldListDomains().add(oldDomains.get(i));
        }
        /*
         * Start the crawl. This is a blocking operation, meaning that your code
         * will reach the line after this only when crawling is finished.
         */
        controller.start(LvanCrawler.class, numberOfCrawlers);
    }





    private CrawlController getCrawlController() throws Exception {
        CrawlConfig config = new CrawlConfig();
        config.setCrawlStorageFolder(crawlStorageFolder);
        config.setMaxConnectionsPerHost(1);
//        config.setMaxDepthOfCrawling(1);
//        config.setMaxPagesToFetch(1);
        /*
         * Instantiate the controller for this crawl.
         */
        PageFetcher pageFetcher = new PageFetcher(config);
        RobotstxtConfig robotstxtConfig = new RobotstxtConfig();
        RobotstxtServer robotstxtServer = new RobotstxtServer(robotstxtConfig, pageFetcher);
        CrawlController controller = new CrawlController(config, pageFetcher, robotstxtServer);
        return controller;

    }







}
