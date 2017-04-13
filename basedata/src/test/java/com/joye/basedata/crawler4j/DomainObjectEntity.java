package com.joye.basedata.crawler4j;

import com.joye.basedata.domainhandle.ArchiveResponse;

import org.apache.poi.ss.usermodel.Row;

/**
 * Created by joye on 2017/4/7.
 */

public class DomainObjectEntity {
    private String chartset="";
    private String keywords="";
    private String title="";
    private String description="";
    private String smallChartset="";

    private String url="";

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getChartset() {
        return chartset;
    }

    public void setChartset(String chartset) {
        this.chartset = chartset;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSmallChartset() {
        return smallChartset;
    }

    public void setSmallChartset(String smallChartset) {
        this.smallChartset = smallChartset;
    }

    public void setRow(Row row,String initObjectDomainStr,String oldDomainStr ) {
        row.createCell(0).setCellValue(initObjectDomainStr);
        row.createCell(1).setCellValue(getUrl());
        String buildObjectDomain=getUrl().replace("http://","").replace("/","");
        row.createCell(2).setCellValue(buildObjectDomain);
        row.createCell(3).setCellValue(oldDomainStr);
        row.createCell(4).setCellValue(getSmallChartset().toLowerCase());
        row.createCell(5).setCellValue(getTitle());
        row.createCell(6).setCellValue(getKeywords());
        row.createCell(7).setCellValue(getDescription());
    }

    public static String[] TITLES={"查询列表","能查询的对象站地址","外部资源需要对象站*","老域名*","编码*","标题","关键字*","描述"};
}
