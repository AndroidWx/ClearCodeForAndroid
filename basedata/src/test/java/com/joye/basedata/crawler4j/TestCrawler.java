package com.joye.basedata.crawler4j;

import com.joye.basedata.autoseo.ExcelReaderHelper;
import com.joye.basedata.autoseo.ExcelWriterHelper;
import com.joye.basedata.autoseo.ExtralResourceWriteDelegate;
import com.joye.basedata.crawler4j.team.BruceCrawler;
import com.joye.basedata.crawler4j.team.JoyeCrawler;
import com.joye.basedata.crawler4j.team.KevinCrawler;
import com.joye.basedata.crawler4j.team.LvanCrawler;
import com.joye.basedata.crawler4j.team.SpencerCrawler;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import edu.uci.ics.crawler4j.crawler.CrawlConfig;
import edu.uci.ics.crawler4j.crawler.CrawlController;
import edu.uci.ics.crawler4j.fetcher.PageFetcher;
import edu.uci.ics.crawler4j.robotstxt.RobotstxtConfig;
import edu.uci.ics.crawler4j.robotstxt.RobotstxtServer;

/**
 * Created by joye on 2017/4/7.
 */

public class TestCrawler {
    public static final String crawlStorageFolder = "/Users/joye/Search/crawler";
    public static final int numberOfCrawlers =9;

    public static final String joyePath="/Users/joye/Downloads/spencer-20170408对象站.xlsx";
    @Test
    public void testJoye() throws Exception {
        testJoyeCrawler();
    }


    public static final String brucePath="/Users/joye/Downloads/找的对象站-bruce.xlsx";
    @Test
    public void testBruce() throws Exception {
        testBruceCrawler();
    }


    public static final String kevinPath="/Users/joye/Downloads/second_4.12.xlsx";
    @Test
    public void testKevin() throws Exception {
        testKevinCrawler();
    }


    public static final String spencerPath="/Users/joye/Downloads/spencer-20170408对象站 (2).xlsx";
    @Test
    public void testSpencer() throws Exception {
        testSpencerCrawler();
    }


    public static final String lvanPath="/Users/joye/Downloads/spencer-20170408对象站.xlsx";
    @Test
    public void testLvan() throws Exception {
        testLvan();
    }

    /**
     * 1.读取对象站列表
     * 2.把对象站加入
     * @throws Exception
     */
    @Test
    public void testBruceCrawler() throws Exception {
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
            controller.addSeed(domains.get(i));
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
        controller.start(LvanCrawler.class, numberOfCrawlers);
    }





    private CrawlController getCrawlController() throws Exception {
        CrawlConfig config = new CrawlConfig();
        config.setCrawlStorageFolder(crawlStorageFolder);
        config.setMaxConnectionsPerHost(1);
        /*
         * Instantiate the controller for this crawl.
         */
        PageFetcher pageFetcher = new PageFetcher(config);
        RobotstxtConfig robotstxtConfig = new RobotstxtConfig();
        RobotstxtServer robotstxtServer = new RobotstxtServer(robotstxtConfig, pageFetcher);
        CrawlController controller = new CrawlController(config, pageFetcher, robotstxtServer);
        return controller;

    }









    @Test
    public void testElse() throws Exception {

        String []args=new String[]{"/Users/joye/Search/crawler","1"};
        /*
     * crawlStorageFolder is a folder where intermediate crawl data is
     * stored.
     */
        String crawlStorageFolder = args[0];

    /*
     * numberOfCrawlers shows the number of concurrent threads that should
     * be initiated for crawling.
     */
        int numberOfCrawlers = Integer.parseInt(args[1]);

        CrawlConfig config = new CrawlConfig();

        config.setCrawlStorageFolder(crawlStorageFolder);

    /*
     * Be polite: Make sure that we don't send more than 1 request per
     * second (1000 milliseconds between requests).
     */
        config.setPolitenessDelay(1000);

    /*
     * You can set the maximum crawl depth here. The default value is -1 for
     * unlimited depth
     */
        config.setMaxDepthOfCrawling(2);

    /*
     * You can set the maximum number of pages to crawl. The default value
     * is -1 for unlimited number of pages
     */
        config.setMaxPagesToFetch(1000);

        /**
         * Do you want crawler4j to crawl also binary data ?
         * example: the contents of pdf, or the metadata of images etc
         */
        config.setIncludeBinaryContentInCrawling(false);

    /*
     * Do you need to set a proxy? If so, you can use:
     * config.setProxyHost("proxyserver.example.com");
     * config.setProxyPort(8080);
     *
     * If your proxy also needs authentication:
     * config.setProxyUsername(username); config.getProxyPassword(password);
     */

    /*
     * This config parameter can be used to set your crawl to be resumable
     * (meaning that you can resume the crawl from a previously
     * interrupted/crashed crawl). Note: if you enable resuming feature and
     * want to start a fresh crawl, you need to delete the contents of
     * rootFolder manually.
     */
        config.setResumableCrawling(false);

    /*
     * Instantiate the controller for this crawl.
     */
        PageFetcher pageFetcher = new PageFetcher(config);
        RobotstxtConfig robotstxtConfig = new RobotstxtConfig();
        RobotstxtServer robotstxtServer = new RobotstxtServer(robotstxtConfig, pageFetcher);
        CrawlController controller = new CrawlController(config, pageFetcher, robotstxtServer);

    /*
     * For each crawl, you need to add some seed urls. These are the first
     * URLs that are fetched and then the crawler starts following links
     * which are found in these pages
     */
        controller.addSeed("http://www.xuebangsoft.com/");

    /*
     * Start the crawl. This is a blocking operation, meaning that your code
     * will reach the line after this only when crawling is finished.
     */
        controller.start(BasicCrawler.class, numberOfCrawlers);

    }
}
