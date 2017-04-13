package com.joye.basedata.crawler4j;

import com.joye.basedata.autoseo.ExcelWriterHelper;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.regex.Pattern;

import edu.uci.ics.crawler4j.crawler.Page;
import edu.uci.ics.crawler4j.crawler.WebCrawler;
import edu.uci.ics.crawler4j.parser.HtmlParseData;
import edu.uci.ics.crawler4j.url.WebURL;

/**
 * Created by joye on 2017/4/7.
 */

public class MyCrawler extends WebCrawler{
    private static final Pattern IMAGE_EXTENSIONS = Pattern.compile(".*(\\.(css|js|bmp|gif|jpe?g|png|tiff?|mid|mp2|mp3|mp4|wav|avi|mov|mpeg|ram|m4v|pdf"
            + "|rm|smil|wmv|swf|wma|zip|rar|gz))$");

    /**
     *此方法接收两个参数。第一个参数是页面
     *在其中我们发现了这个新的URL和第二个参数是
     *新网址。你应该实现这个函数来指定是否
     *给定的URL应抓取或不（基于您的爬行逻辑）。
     *在这个例子中，我们指示爬虫忽略URL
     *有CSS，JS，Git，…扩展和只接受网址，开始
     *“HTTP：/ / www.ics。UCI .edu /”。在这种情况下，我们不需要
     * referringpage参数作出决定。
     */
    @Override
    public boolean shouldVisit(Page referringPage, WebURL url) {
        String href = url.getURL().toLowerCase();
        return !IMAGE_EXTENSIONS.matcher(href).matches()
                && AllDomainsDelegate.getInstance().getListDomains().contains(href);
    }
    DomainObjectEntity domainObjectEntity=new DomainObjectEntity();
    public static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    private static Calendar cale = Calendar.getInstance();
    public static String getTime(){
        return sdf.format(cale.getTime());
    }
    /**
     *该函数被调用时，一个页面是获取和准备
     *由您的程序处理。
     */
    @Override
    public void visit(Page page) {
        String url = page.getWebURL().getURL();
         if (page.getParseData() instanceof HtmlParseData) {
            domainObjectEntity=new DomainObjectEntity();
            domainObjectEntity.setUrl(url);
            domainObjectEntity.setSmallChartset(page.getContentCharset());
            HtmlParseData htmlParseData = (HtmlParseData) page.getParseData();
            Iterator<String> localItertor = ((HtmlParseData) page.getParseData()).getMetaTags().keySet().iterator();
            while (localItertor.hasNext()){
                String nextKeyStr=localItertor.next();
                String value = ((HtmlParseData) page.getParseData()).getMetaTags().get(nextKeyStr);
                if (nextKeyStr.contains("content-type")) {
                    domainObjectEntity.setChartset(value);
                }else if(nextKeyStr.contains("keywords")){
                    domainObjectEntity.setKeywords(value);
                }else if(nextKeyStr.contains("dc:title")){
                    domainObjectEntity.setTitle(value);
                }else if(nextKeyStr.contains("description")){
                    domainObjectEntity.setDescription(value);
                }
            }
            AllDomainsDelegate.getInstance().add(domainObjectEntity);
//            Set<WebURL> links = htmlParseData.getOutgoingUrls();
        }
    }

    @Override
    public void onStart() {
        super.onStart();
        System.out.println("---------------------------------启动");
    }


}
