package com.joye.hk6.report;

import com.joye.hk6.view.IPieChartCallback;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by xiang on 16/11/18.
 */

public abstract class BaseReport {



    protected Map<Integer, Integer> mBubbleSort(List<Statistics> blueStatistics){
        Statistics[] vos=new Statistics[blueStatistics.size()];
        vos= blueStatistics.toArray(vos);
        Statistics temp = vos[0];
        for (int i = vos.length - 1; i > 0; --i)
        {
            for (int j = 0; j < i; ++j)
            {
                if (vos[j + 1].thresholdKey < vos[j].thresholdKey)
                {
                    temp = vos[j];
                    vos[j] = vos[j + 1];
                    vos[j + 1] = temp;
                }
            }
        }
        Map<Integer,Integer> realMap=new TreeMap();
        for (int i=0;i<vos.length;i++){
            int realValue=vos[i].getThresholdValue();
            for(int j=i+1;j<vos.length;j++){
                realValue=realValue-vos[j].getThresholdValue();
                realMap.put(vos[i].getThresholdKey(),realValue);
                break;
            }
            if((i+1)==vos.length){
                realMap.put(vos[i].getThresholdKey(),realValue);
            }

        }

        return realMap;
    }
    protected PieChartImpl demarcationPieChartImpl(Map<Integer,Integer> map, String contentText){
        PieChartImpl item=new PieChartImpl();
        item.setContentText(contentText);
        ArrayList<Float> redFloatList=new ArrayList<Float>();
        ArrayList<String> lableList=new ArrayList<String>();
        Iterator<Map.Entry<Integer, Integer>> intera = map.entrySet().iterator();
        while (intera.hasNext()){
            Map.Entry entry = (Map.Entry) intera.next();
            Integer val = (Integer) entry.getValue();
            if(val>0) {
                lableList.add("连出" + entry.getKey() + "期共" + map.get(entry.getKey())+"次");
                redFloatList.add(val.floatValue() * 100.0f);
            }
        }
        item.setPieEntryFlotArrayList(redFloatList);
        item.setPieEntryLabelArrayList(lableList);
        return item;
    }



    protected PieChartImpl genPieChartImpl(Map<Integer,Integer> map,String contentText){
        PieChartImpl item=new PieChartImpl();
        item.setContentText(contentText);
        ArrayList<Float> redFloatList=new ArrayList<Float>();
        ArrayList<String> lableList=new ArrayList<String>();
        Iterator<Map.Entry<Integer, Integer>> intera = map.entrySet().iterator();
        while (intera.hasNext()){
            Map.Entry entry = (Map.Entry) intera.next();
            Integer val = (Integer) entry.getValue();
            if(val>0) {
                lableList.add("阈" + entry.getKey() + "共" + map.get(entry.getKey()));
                redFloatList.add(val.floatValue() * 100.0f);
            }
        }
        item.setPieEntryFlotArrayList(redFloatList);
        item.setPieEntryLabelArrayList(lableList);
        return item;
    }

    public abstract void BubbleSort(IPieChartCallback callback);
    public abstract void Demarcations(  IPieChartCallback callback);
}
