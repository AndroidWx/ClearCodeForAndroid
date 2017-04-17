package com.joye.basedata.webcollector;

import java.util.List;

/**
 * Created by joye on 2017/4/14.
 * 老域名信息实体
 */

 class OldDomainInfoBean {
    /**
     * 老域名
     */
    private String oldDomainStr;
    /**
     * 锚文本信息
     */
    private List<String> autherTxts;

    public OldDomainInfoBean() {
    }

    public OldDomainInfoBean(String oldDomainStr, List<String> autherTxts) {
        this.oldDomainStr = oldDomainStr;
        this.autherTxts = autherTxts;
    }

    public String getOldDomainStr() {
        return oldDomainStr;
    }

    public void setOldDomainStr(String oldDomainStr) {
        this.oldDomainStr = oldDomainStr;
    }

    public List<String> getAutherTxts() {
        return autherTxts;
    }

    public void setAutherTxts(List<String> autherTxts) {
        this.autherTxts = autherTxts;
    }
}
