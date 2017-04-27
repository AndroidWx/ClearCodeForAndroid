package com.joye.basedata.流程;

import com.joye.basedata.autoseo.ExcelReaderHelper;
import com.joye.basedata.autoseo.ExtralResourceWriteDelegate;
import com.joye.basedata.crawler4j.AllDomainsDelegate;
import com.joye.basedata.crawler4j.team.JoyeCrawler;
import com.joye.basedata.crawler4j.team.TotalObjectCrawler;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import edu.uci.ics.crawler4j.crawler.CrawlConfig;
import edu.uci.ics.crawler4j.crawler.CrawlController;
import edu.uci.ics.crawler4j.fetcher.PageFetcher;
import edu.uci.ics.crawler4j.robotstxt.RobotstxtConfig;
import edu.uci.ics.crawler4j.robotstxt.RobotstxtServer;

import static org.apache.poi.xssf.usermodel.XSSFWorkbookType.XLSX;

/**
 * Created by joye on 2017/4/20.
 */

public class C1获取老域名多个对象站的信息 {

    public static final String crawlStorageFolder = "/Users/joye/Search/crawler";
    public static final int numberOfCrawlers =9;

    public static final String joyePath="/Users/joye/Downloads/2017-04-21-spencer爬站列表.xlsx";
    @Test
    public void testJoye() throws Exception {
        exculte("/Users/joye/Search/webconllector/joye/2017-04-27-joye爬站列表.xlsx");
    }

    private String oldDomainPath="/Users/joye/Search/域名处理/2017-4-27/域名-未用.xlsx";
    private String newExcelPath="/Users/joye/Search/域名处理/2017-4-27/";
    private String newExcelName="处理域名排版结果";



    /**
     * 1.获取老域名对应的信息以及对象站列表
     * 1.a.写入下标，老域名
     * 2.开始爬取这些站点的信息
     * 3.写入Excel列表查看
     *
     */

    public  static void  exculte(String path) throws Exception {
        //获取
        Workbook workbook= ExcelReaderHelper.getWorkBookByPath(path);
        List<Item> items=new ArrayList<>();
        for (Sheet sheet : workbook){
            int i=0;
            for (Row r : sheet) {
                if(i==0){
                    i++;
                    continue;
                }
                String rowNum=String.valueOf(r.getRowNum()+1);
                String oldDomain="";
                for (Cell cell:r){
                    if(cell.getColumnIndex()==0){
                        if(!cell.getStringCellValue().equals("")){
                            oldDomain=cell.getStringCellValue();
                        }
                    }else{
                        if(!cell.getStringCellValue().equals("")) {
                            Item item = new Item();
                            item.setIndex(rowNum);
                            item.setOldDomainStr(oldDomain);
                            item.setObjectDomainStr(cell.getStringCellValue());
                            items.add(item);
                        }
                    }
                }
            }
        }
        AllDomainsDelegate.getInstance().setCrawlerTotal(numberOfCrawlers);
        CrawlController controller = getCrawlController();
        for (int i=0;i< items.size();i++){
            //加入爬虫
            controller.addSeed(items.get(i).getObjectDomainStr());
            //设置所有的对象站
            AllDomainsDelegate.getInstance().getListDomains().add(items.get(i).getObjectDomainStr());
            AllDomainsDelegate.getInstance().getOldListDomains().add(items.get(i).getOldDomainStr());
            AllDomainsDelegate.getInstance().getIndexs().add(items.get(i).getIndex());
        }
        /*
         * Start the crawl. This is a blocking operation, meaning that your code
         * will reach the line after this only when crawling is finished.
         */
        Class<TotalObjectCrawler> totalObjectCrawlerClass=TotalObjectCrawler.class;
        controller.start(totalObjectCrawlerClass, numberOfCrawlers);


    }

     static class Item{
        /**
         * 下标
         */
        private String index;
        /**
         * 老域名
         */
        private String oldDomainStr;
        /**
         * 对象站
         */
        private String objectDomainStr;

         public String getIndex() {
             return index;
         }

         public void setIndex(String index) {
             this.index = index;
         }

         public String getOldDomainStr() {
             return oldDomainStr;
         }

         public void setOldDomainStr(String oldDomainStr) {
             this.oldDomainStr = oldDomainStr;
         }

         public String getObjectDomainStr() {
             return objectDomainStr;
         }

         public void setObjectDomainStr(String objectDomainStr) {
             this.objectDomainStr = objectDomainStr;
         }
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



    private static CrawlController getCrawlController() throws Exception {
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

}
