package com.joye.basedata.crawler4j;

import org.junit.Test;

import java.util.ArrayList;

import edu.uci.ics.crawler4j.crawler.CrawlConfig;
import edu.uci.ics.crawler4j.crawler.CrawlController;
import edu.uci.ics.crawler4j.fetcher.PageFetcher;
import edu.uci.ics.crawler4j.robotstxt.RobotstxtConfig;
import edu.uci.ics.crawler4j.robotstxt.RobotstxtServer;

/**
 * Created by joye on 2017/4/8.
 */

public class Handler {
    @Test
    public void testCrawlderDomainInfo() throws Exception {
        String crawlStorageFolder = "/Users/joye/Search/crawler";
        int numberOfCrawlers = 9;
        AllDomainsDelegate.getInstance().setCrawlerTotal(numberOfCrawlers);
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

        ArrayList<String> domains=new ArrayList<>();
//        domains= ExtralResourceWriteDelegate.getAllKeysByFilePath("");
        for (String item:domains){
            controller.addSeed(item);
            AllDomainsDelegate.getInstance().getListDomains().add(item);
        }



        /*
         * Start the crawl. This is a blocking operation, meaning that your code
         * will reach the line after this only when crawling is finished.
         */
        controller.start(MyCrawler.class, numberOfCrawlers);

    }
}
