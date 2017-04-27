package com.joye.basedata.crawler4j.team;

import com.joye.basedata.crawler4j.AllDomainsDelegate;
import com.joye.basedata.crawler4j.MyCrawler;
import com.joye.basedata.crawler4j.ObjectDomainWriteExcel;

import java.io.IOException;

/**
 * Created by joye on 2017/4/8.
 */

public class TotalObjectCrawler extends MyCrawler{


    @Override
    public void onBeforeExit() {
        super.onBeforeExit();
        System.out.println("onBeforExit"+myId);
        if(getMyId()== AllDomainsDelegate.getInstance().getCrawlerTotal()){
            //处理打印
            System.out.println(AllDomainsDelegate.getInstance().getListDatas().size() +"---total"+AllDomainsDelegate.getInstance().getCrawlerTotal());
            try {
                ObjectDomainWriteExcel.WriteDomainArchive(
                        AllDomainsDelegate.getInstance().getOldListDomains(),
                        AllDomainsDelegate.getInstance().getListDomains(),
                        AllDomainsDelegate.getInstance().getListDatas(),
                        "/Users/joye/Search/crawler/joye",
                        "joye-"+getTime()+"对象站",AllDomainsDelegate.getInstance().getIndexs());

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
