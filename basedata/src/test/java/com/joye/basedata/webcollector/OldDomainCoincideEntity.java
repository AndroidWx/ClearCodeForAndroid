package com.joye.basedata.webcollector;

import java.util.List;

/**
 * Created by joye on 2017/4/17.
 *
 * 老域名对应实体
 *
 *
 */

public class OldDomainCoincideEntity  {


    private String oldDomainStr;

    private List<String> coincideLists;

    public String getOldDomainStr() {
        return oldDomainStr;
    }

    public void setOldDomainStr(String oldDomainStr) {
        this.oldDomainStr = oldDomainStr;
    }

    public List<String> getCoincideLists() {
        return coincideLists;
    }

    public void setCoincideLists(List<String> coincideLists) {
        this.coincideLists = coincideLists;
    }
}
