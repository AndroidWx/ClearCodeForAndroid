package com.joye.basedata.filter;

import com.joye.basedata.crawler4j.MyCrawler;

import java.util.Iterator;
import java.util.regex.Pattern;

import edu.uci.ics.crawler4j.crawler.Page;
import edu.uci.ics.crawler4j.parser.HtmlParseData;
import edu.uci.ics.crawler4j.url.WebURL;

/**
 * Created by joye on 2017/4/19.
 */
@Deprecated
public class FilterFailedCrawler extends MyCrawler {



                       public static String regex1="((http|https):\\/\\/)?www\\.(.*)\\.(com|cn)\\/?";
                         public static Pattern p = Pattern.compile(regex1);
    @Override
    public boolean shouldVisit(Page referringPage, WebURL url) {
        String href = url.getURL().toLowerCase();
        System.out.println(href+":"+((matcher(href)&&p.matcher(href).matches()&&FailedDomainInstance.getOurInstance().getList().contains(href))?"抓取":"不抓"));
        return matcher(href)&&p.matcher(href).matches()&&FailedDomainInstance.getOurInstance().getList().contains(href);
    }

    @Override
    public void visit(Page page) {
        super.visit(page);
        String url=page.getWebURL().getURL();
        System.out.println("FilterFailedCrawler-------" +url);
        if(page.getParseData() instanceof HtmlParseData){
            HtmlParseData htmlParseData= (HtmlParseData) page.getParseData();
            Iterator<String> localItertor= htmlParseData.getMetaTags().keySet().iterator();
            while (localItertor.hasNext()){
                String nextKeyStr=localItertor.next();
                String value=htmlParseData.getMetaTags().get(nextKeyStr);
//                System.out.println(value);
                if(nextKeyStr.contains("dc:title")){
                    if(value.equals("11")){
                        System.out.println("11-----"+url);
                        FailedDomainInstance.getOurInstance().addFailedDatas(url);
                    }else{
                        System.out.println("success:"+url);
                        FailedDomainInstance.getOurInstance().addSuccessDatas(url);
                    }
                }

            }
        }
    }

    @Override
    public void onBeforeExit() {
        super.onBeforeExit();
        if(getMyId()==FilterFailedDelegate.numberOfCrawlers) {
            System.out.println(FailedDomainInstance.getOurInstance().getTotalDatas().size() + " ");
            System.out.println(FailedDomainInstance.getOurInstance().getFailedDatas().size());
            System.out.println(FailedDomainInstance.getOurInstance().getSuccessDatas().size());
        }
    }
}
