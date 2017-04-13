package com.joye.basedata.autoseo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import edu.emory.mathcs.backport.java.util.Collections;

/**
 * Created by joye on 2017/4/4.
 */

public class HandleKey {
    /**
     * 处理相同的数据
     * @param list
     */
    private static void removeDuplicate(List list) {
        HashSet h = new HashSet(list);
        list.clear();
        list.addAll(h);
    }

    private static ThreadLocal<StringBuffer> tlpicsb = new ThreadLocal<StringBuffer>();




    /**
     * 根据域加关键字，返回所有的标题组合
     *qy8千亿国际+千亿国际+随便填写
     * long8520龙8娱乐官网_long8520龙8娱乐官网下载_long8520龙8娱乐老虎机
     * @return 所有的标题组合
     */
    public static List<String> getAllTitleResultByDomainKeys( List<String> allKeys,  List<String> allDomainKeys){
        StringBuffer sb=new StringBuffer();
        tlpicsb.set(sb);
        List<String> allResukt=new ArrayList<>();
        for (int i = 0; i < allKeys.size(); i++) {
            for (int j = 0; j < allDomainKeys.size(); j++) {
                int n = (int) (Math.random() * (allKeys.size() > 10 ? 10 : allKeys.size() - 1));
                tlpicsb.get().append(allDomainKeys.get(j)).append(allKeys.get(i)).append("_").append(allKeys.get(i)).append("_").append(allKeys.get(n));
                allResukt.add(tlpicsb.get().toString());
                System.out.println(tlpicsb.get().toString());
                tlpicsb.get().delete(0,tlpicsb.get().length());
            }
        }
        return allResukt;
    }

    /**
     * 获取所有title qy8千亿国际+www.qy8.com+随便填写
     * @param allKeys
     * @param allDomainKeys
     * @return
     */
    public static List<String> getAllDomainTitles( List<String> allKeys,  List<String> allDomainKeys){
        StringBuffer sb=new StringBuffer();
        tlpicsb.set(sb);
        List<String> allResukt=new ArrayList<>();
        for (int i = 0; i < allKeys.size(); i++) {
            for (int j = 0; j < allDomainKeys.size(); j++) {
                int n = (int) (Math.random() * (allKeys.size() > 10 ? 10 : allKeys.size() - 1));
                tlpicsb.get().append(allDomainKeys.get(j)).append(allKeys.get(i)).append("_").append("www.").append(allDomainKeys.get(j)).append(".com").append("_").append(allKeys.get(n));
                allResukt.add(tlpicsb.get().toString());
                System.out.println(tlpicsb.get().toString());
                tlpicsb.get().delete(0,tlpicsb.get().length());
            }
        }
        return allResukt;
    }

//    public static List<String> getAll


    /**
     * 根据所有的关键字 返回所有的标题组合
     * @param allKeys  所有的关键字
     */
    public  static List<String> getAllTitleResultByKeys(List<String> allKeys)  {
        List<String> allResult=new ArrayList<>();
        //总共相同的列表
        List<List<String>> someList = new ArrayList<>();
        //遍历所有的关键词
        for (String item : allKeys) {
            //关键词相同的集合
            List<String> someItemList = new ArrayList<>();
            //遍历关键词
            for (String itemElse : allKeys) {
                //如果其他关键词包含上面的
                if (itemElse.indexOf(item) == 0) {
                    someItemList.add(itemElse);
                }
            }
            //去除重复
            removeDuplicate(someItemList);
            //排序
            Collections.sort(someItemList);
            if (someItemList.size() >= 2) {
                someList.add(someItemList);
            }
        }
        removeDuplicate(someList);
        for (int i = 0; i < someList.size(); i++) {
            List<String> list = someList.get(i);
            allKeyshandle(list,allKeys,allResult);
        }
        removeDuplicate(allResult);
        System.out.println();
        for (int i = 0; i < allResult.size(); i++) {
            System.out.println(allResult.get(i));
        }
        return allResult;
    }

    /**
     *  整理item相似的站点
     *
     * @param list
     * @param allKeys
     * @param allResult
     */
    private static void allKeyshandle(List<String> list,List<String>allKeys,List<String> allResult ) {
        int n = (int) (Math.random() * (allKeys.size() > 10 ? 10 : allKeys.size() - 1));
        if (list.size() == 2) {
            String s = new String("");
            for (int j = 0; j < list.size(); j++) {
                s += (list.get(j) + "_");
            }
            s=s + allKeys.get(n);
            allResult.add(s);
        }
        //数据长度大于2的情况
        else {
            List<List<String>> allList = new ArrayList<>();
            for (int i = 0; i < list.size(); i++) {
                for (int j = i + 1; j < list.size(); j++) {
                    if(list.get(j).contains(list.get(i))) {
                        List<String> childs = new ArrayList<>();
                        childs.add(list.get(i));
                        childs.add(list.get(j));
                        allList.add(childs);
                        continue;
                    }
                }
            }
            for (int i = 0; i < allList.size(); i++) {
                allKeyshandle(allList.get(i),allKeys,allResult);
            }
        }
    }


}
