package com.joye.hk6.report;

/**
 * Created by xiang on 16/11/5.
 */
public class Statistics {
    public String typeName;
    public int thresholdKey;
    public int thresholdValue;

    public Statistics(int thresholdKey, int thresholdValue)
    {
        this("",thresholdKey,thresholdValue);
    }
    public Statistics(String typeName, int thresholdKey, int thresholdValue) {
        this.typeName = typeName;
        this.thresholdKey = thresholdKey;
        this.thresholdValue = thresholdValue;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public int getThresholdKey() {
        return thresholdKey;
    }

    public void setThresholdKey(int thresholdKey) {
        this.thresholdKey = thresholdKey;
    }

    public int getThresholdValue() {
        return thresholdValue;
    }

    public void setThresholdValue(int thresholdValue) {
        this.thresholdValue = thresholdValue;
    }
}
