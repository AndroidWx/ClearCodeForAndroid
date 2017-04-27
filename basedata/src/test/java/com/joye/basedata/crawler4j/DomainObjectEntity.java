package com.joye.basedata.crawler4j;

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
        try {


        row.createCell(0).setCellValue(initObjectDomainStr);
        row.createCell(1).setCellValue(getUrl());
        String buildObjectDomain=getUrl().replace("http://","").replace("/","");
        row.createCell(2).setCellValue(buildObjectDomain);
        row.createCell(3).setCellValue(oldDomainStr);
        row.createCell(4).setCellValue(getSmallChartset().toLowerCase());
        row.createCell(5).setCellValue(getTitle());
        row.createCell(6).setCellValue(getKeywords());
        row.createCell(7).setCellValue(getDescription());
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void setRow(Row row,String initObjectDomainStr,String oldDomainStr,String index ) {
        try {

            row.createCell(0).setCellValue(index);
            row.createCell(1).setCellValue(initObjectDomainStr);
            row.createCell(2).setCellValue(getUrl());
            String buildObjectDomain = getUrl().replace("http://", "").replace("/", "");
            row.createCell(3).setCellValue(buildObjectDomain);
            row.createCell(4).setCellValue(oldDomainStr);
            row.createCell(5).setCellValue(getSmallChartset().toLowerCase());
            row.createCell(6).setCellValue(getTitle());
            row.createCell(7).setCellValue(getKeywords());
            row.createCell(8).setCellValue(getDescription());
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    public static String[] TITLES={"查询列表","能查询的对象站地址","外部资源需要对象站*","老域名*","编码*","标题","关键字*","描述"};
    public static String[] TITLES1={"对应的下标位置","查询列表","能查询的对象站地址","外部资源需要对象站*","老域名*","编码*","标题","关键字*","描述"};
}
