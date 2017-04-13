package com.joye.basedata.autoseo;

import org.apache.poi.ss.usermodel.Row;

/**
 * Created by joye on 2017/4/4.
 */

public class UploadRowResourceEntity {
    public static final String TITLE_TIME="得标时间";
    private String time="";

    public static final String TITLE_IPSTR="IP";
    //ip地址
    private String ipStr="";
    public static final String TITLE_OLDMAINSTR="老域名*(全小写)";
    //老域名
    private String oldDomainStr="";
    public static final String TITLE_ISOK="是否OK";
    //是否OK
    private String isOKStr="";
    public static final String TITLE_KEY="关键字*";
    //关键字
    private String key="";
    public static final String TITLE_TITLE="标题*";
    //标题
    private String title="";
    public static final String TITLE_LONGENDKEY="长尾关键词";
    //长尾关键字
    private String longEndKey="";
    public static final String TITLE_DESCRIPTION="描述*";
    //描述
    private String description="";

    public static final String TITLE_DNSACCOUT="dnspod.cn解析账号";
    //dnspod.cn解析账号
    private String dnsAccout="";
    public static final String TITLE_OBJECTDOMAIN="对象站*";
    //对象站
    private String objectDomain="";

    public static final String TITLE_REPLACEKEYSTR="关键字替换";
    //关键字替换
    private String replaceKeyStr="";
    public static final String TITLE_CHARTSETSTR="网站编码";

    //网站编码
    private String chartsetStr;



    public String getIpStr() {
        return ipStr;
    }

    public void setIpStr(String ipStr) {
        this.ipStr = ipStr;
    }

    public String getOldDomainStr() {
        return oldDomainStr;
    }

    public void setOldDomainStr(String oldDomainStr) {
        this.oldDomainStr = oldDomainStr;
    }

    public String getIsOKStr() {
        return isOKStr;
    }

    public void setIsOKStr(String isOKStr) {
        this.isOKStr = isOKStr;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLongEndKey() {
        return longEndKey;
    }

    public void setLongEndKey(String longEndKey) {
        this.longEndKey = longEndKey;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getObjectDomain() {
        return objectDomain;
    }

    public void setObjectDomain(String objectDomain) {
        this.objectDomain = objectDomain;
    }

    public String getReplaceKeyStr() {
        return replaceKeyStr;
    }

    public void setReplaceKeyStr(String replaceKeyStr) {
        this.replaceKeyStr = replaceKeyStr;
    }

    public String getChartsetStr() {
        return chartsetStr;
    }

    public void setChartsetStr(String chartsetStr) {
        this.chartsetStr = chartsetStr;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDnsAccout() {
        return dnsAccout;
    }

    public void setDnsAccout(String dnsAccout) {
        this.dnsAccout = dnsAccout;
    }

    public void setRow(Row row) {
        row.createCell(0).setCellValue(getTime());
        row.createCell(1).setCellValue(getIpStr());
        row.createCell(2).setCellValue(getOldDomainStr());
        row.createCell(3).setCellValue("");
        row.createCell(4).setCellValue(getKey());
        row.createCell(5).setCellValue(getTitle());
        row.createCell(6).setCellValue(getLongEndKey());
        row.createCell(7).setCellValue(getDescription());
        row.createCell(8).setCellValue("");
        row.createCell(9).setCellValue(getObjectDomain());
        row.createCell(10).setCellValue(getReplaceKeyStr());
        row.createCell(11).setCellValue(getChartsetStr());
    }


    public static final String []TITLES={TITLE_TIME,TITLE_IPSTR,TITLE_OLDMAINSTR,TITLE_ISOK,
            TITLE_KEY,TITLE_TITLE,TITLE_LONGENDKEY,TITLE_DESCRIPTION,TITLE_DNSACCOUT,TITLE_OBJECTDOMAIN
            ,TITLE_REPLACEKEYSTR,TITLE_CHARTSETSTR};

}
