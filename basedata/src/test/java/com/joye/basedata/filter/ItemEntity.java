package com.joye.basedata.filter;

/**
 * Created by joye on 2017/4/21.
 */

public class ItemEntity {

    String ip;
    String prefixDomain;
    String domain;
    String httpStr;

    public String getHttpStr() {
        return httpStr;
    }

    public void setHttpStr(String httpStr) {
        this.httpStr = httpStr;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getPrefixDomain() {
        return prefixDomain;
    }

    public void setPrefixDomain(String prefixDomain) {
        this.prefixDomain = prefixDomain;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }
}
