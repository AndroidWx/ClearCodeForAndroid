package com.joye.basedata.流程;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.junit.Test;

import java.util.Date;

/**
 * Created by joye on 2017/9/5.
 */

public class GCheck {
    @Test
    public void testCheck() throws Exception {
        String website="http://www.xmh1998.com";
        Document doc = Jsoup.connect(website).userAgent("Mozilla/5.0(compatible; Baiduspider/2.0; +http://www.baidu.com/search/spider.html)").timeout(5000).followRedirects(false).get();
        Elements elements = doc.getElementsByTag("title");
        System.out.println(elements.text());
    }
}
