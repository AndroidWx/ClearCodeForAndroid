package com.joye.basedata.filter;

/**
 * Created by joye on 2017/4/21.
 * 替换的对象站信息
 */

public class ReplaceDomainEntity {
    private String domain;
    private String keystr;
    private String charsert;
    private String[]keys;

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getKeystr() {
        return keystr;
    }

    public void setKeystr(String keys) {
        this.keystr = keys;
    }

    public String getCharsert() {
        return charsert;
    }

    public void setCharsert(String charsert) {
        this.charsert = charsert;
    }

    public String[]getkeys(){
        if(keys==null||keys.length<3){
            keys=keystr.split("，");
        }
        return keys;
    }
}
