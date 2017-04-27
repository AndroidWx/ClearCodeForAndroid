package com.joye.basedata.filter;

import com.joye.basedata.autoseo.UploadRowResourceEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by joye on 2017/4/19.
 */

public class FailedDomainInstance {
    private static final FailedDomainInstance ourInstance = new FailedDomainInstance();
    private List<UploadRowResourceEntity> totalDatas;

    static FailedDomainInstance getInstance() {
        return ourInstance;
    }

    private FailedDomainInstance() {
    }

    public List<String> getFailedDatas() {
        return failedDatas;
    }

    private List<String> failedDatas=new ArrayList<>();

    private List<String> successDatas=new ArrayList<>();

    public List<String> getSuccessDatas() {
        return successDatas;
    }

    public static FailedDomainInstance getOurInstance() {
        return ourInstance;
    }

    public void addSuccessDatas(String uploadRowResourceEntity){
        successDatas.add(uploadRowResourceEntity);
    }

    public void addFailedDatas(String uploadRowResourceEntity){
        failedDatas.add(uploadRowResourceEntity);
    }


    private List<String> list=new ArrayList<>();
    public void setTotalDatas(List<UploadRowResourceEntity> totalDatas) {
        this.totalDatas = totalDatas;
        for (UploadRowResourceEntity item:totalDatas
             ) {
            list.add("http://"+item.getOldDomainStr()+"/");
        }
    }

    public List<String> getList() {
        return list;
    }

    public List<UploadRowResourceEntity> getTotalDatas() {
        return totalDatas;
    }
}
