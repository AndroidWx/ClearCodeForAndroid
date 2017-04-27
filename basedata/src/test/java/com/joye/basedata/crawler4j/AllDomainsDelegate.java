package com.joye.basedata.crawler4j;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by joye on 2017/4/7.
 */

public class AllDomainsDelegate {
    private static final AllDomainsDelegate ourInstance = new AllDomainsDelegate();

    public static AllDomainsDelegate getInstance() {
        return ourInstance;
    }

    private AllDomainsDelegate() {
    }



    private List<DomainObjectEntity> listDatas=new ArrayList<>();

    public void add(DomainObjectEntity item){
        listDatas.add(item);
    }

    public List<DomainObjectEntity> getListDatas() {
        return listDatas;
    }

    private int crawlerTotal;

    public int getCrawlerTotal() {
        return crawlerTotal;
    }

    public void setCrawlerTotal(int crawlerTotal) {
        this.crawlerTotal = crawlerTotal;
    }

    private List<String> listDomains=new ArrayList<>();
    private List<String> OldListDomains=new ArrayList<>();

    /**
     * 老域名集合
     * @return
     */
    public List<String> getOldListDomains() {
        return OldListDomains;
    }



    private List<String> Indexs=new ArrayList<>();

    public List<String> getIndexs() {
        return Indexs;
    }


    /**
     * 对象站集合
     */
    public List<String> getListDomains() {
        return listDomains;
    }

}
