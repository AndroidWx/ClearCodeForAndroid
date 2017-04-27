package com.joye.basedata.webcollector;

import org.junit.Test;

/**
 * Created by joye on 2017/4/13.
 */

public class TestDemoBingCrawler {

    @Test
    public void testUrlValidate() throws Exception {
        OldDomainInfoBean info=new OldDomainInfoBean();
        info.setOldDomainStr("www.baidu.com");
    }



    @Test
    public void testCrawler() throws Exception {



        DemoBingCrawler crawler=new DemoBingCrawler("广州学邦",1);
//        crawler.addRegex("-.*\\\\.(jpg|png|gif).*");
        crawler.addRegex("((http|https):\\/\\/)?www\\.(.*)\\.(com|cn)");
         /*不要爬取包含"#"的链接*/
        crawler.addRegex("-.*#.*");
        crawler.setTopN(5);
        crawler.start(3);

    }

}
