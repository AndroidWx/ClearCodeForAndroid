package com.joye.basedata.filter;

import com.joye.basedata.autoseo.UploadRowResourceEntity;
import com.joye.basedata.combination.CombinationDelegate;
import com.joye.basedata.webcollector.WebCollectorDelegate;

import org.junit.Test;

import java.io.FileNotFoundException;
import java.util.List;

import edu.uci.ics.crawler4j.crawler.CrawlConfig;
import edu.uci.ics.crawler4j.crawler.CrawlController;
import edu.uci.ics.crawler4j.fetcher.PageFetcher;
import edu.uci.ics.crawler4j.robotstxt.RobotstxtConfig;
import edu.uci.ics.crawler4j.robotstxt.RobotstxtServer;

/**
 * Created by joye on 2017/4/19.
 *
 * 过滤失败的委托者
 *
 *
 */

public class FilterFailedDelegate {

    /**
     * 1.首先获取上传Excel信息
     * 2.获取数据，放入临时变量存储
     * 3.爬取所有上传之后的老域名信息
     * 4.
     */


    @Test
    public void testFailed() throws Exception {
        execulte("/Users/joye/Search/combination/spencer/2017-04-18.xlsx");

    }

    /**
     * 开始执行
     * @param filePath
     */
    public void execulte(String filePath) throws Exception {
        List<UploadRowResourceEntity> list=getUploadDatas(filePath);
        FailedDomainInstance.getOurInstance().setTotalDatas(list);
//        CrawlController controller=getCrawlController();
//        for (int i = 0; i < list.size(); i++) {
//            controller.addSeed("http://"+list.get(i).getOldDomainStr()+"/");
//        }
//        controller.start(FilterFailedCrawler.class,numberOfCrawlers);
        new FailedCrawler(list, new WebCollectorDelegate.ICrawlerCallBack() {
            @Override
            public void onValidateUrl(String url) {
                System.out.println("callback:"+url);
            }
        }).start();
//        Lock lockAnchor = new ReentrantLock();
//        try {
//            lockAnchor.lock();
//
//        } finally {
//            lockAnchor.unlock();
//        }


    }

    public static final String crawlStorageFolder = "/Users/joye/Search/crawler";
    public static final int numberOfCrawlers =9;


    private CrawlController getCrawlController() throws Exception {
        CrawlConfig config = new CrawlConfig();
        config.setCrawlStorageFolder(crawlStorageFolder);
        config.setMaxPagesToFetch(0);
        config.setMaxDepthOfCrawling(0);
        System.out.println(config.toString());
        config.setUserAgentString("Baiduspider+(+http://www.baidu.com/search/spider.htm)");
        /*
         * Instantiate the controller for this crawl.
         */
        PageFetcher pageFetcher = new PageFetcher(config);
        RobotstxtConfig robotstxtConfig = new RobotstxtConfig();
        RobotstxtServer robotstxtServer = new RobotstxtServer(robotstxtConfig, pageFetcher);
        CrawlController controller = new CrawlController(config, pageFetcher, robotstxtServer);
        return controller;

    }
    /**
     * 获取上传的数据列表
     * @param filePath 上传的文件路径
     * @return
     */
    public List<UploadRowResourceEntity> getUploadDatas(String filePath) throws FileNotFoundException {
        return CombinationDelegate.getUploadRowResourceEntitys(filePath);
    }
}
