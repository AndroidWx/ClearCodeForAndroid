package com.joye.basedata.流程;

import com.joye.basedata.autoseo.ExcelReaderHelper;
import com.joye.basedata.autoseo.ExtralResourceWriteDelegate;
import com.joye.basedata.majestic_.entity.AnchorTextEntity;

import org.junit.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import static com.joye.basedata.流程.A2根据老域名获取锚文本.getMajesticInfo;
import static org.apache.poi.xssf.usermodel.XSSFWorkbookType.XLSX;

/**
 * Created by joye on 2017/4/25.
 */

public class All {
//    public static String[] randomAnchorTexts=new String[]{""};
//
//    /**
//     * 1.根据老域名爬去锚文本
//     * 2.根据老域名的锚文本爬对象站
//     * 3.获取对象站集合
//     * 4.生成一个对应的列表
//     *
//     */
//
//    private String oldDomainPath="/Users/joye/Search/域名处理/2017-4-27/域名-未用.xlsx";
//    private String newExcelPath="/Users/joye/Search/域名处理/2017-4-27/";
//    private String newExcelName="处理域名排版结果";
//    @Test
//    public void testGetMajesticInfo() throws Exception {
//        //A.根据老域名爬去锚文本
//        getMajesticInfo(0,oldDomainPath , newExcelPath, newExcelName);
//
//        //a.1过滤锚文本
//        //B.老根据老域名的锚文本爬去对象站
//        C1获取老域名多个对象站的信息.exculte(newExcelPath+newExcelName+ File.separator+XLSX.getExtension());
//
//    }
//    public void a(){
//
//    }
//
    private List<String> oldDomains=new ArrayList<>();

    private List<String> objDomains=new ArrayList<>();
    String filePath = "/Users/joye/Downloads/a - 副本.xlsx";
    @Test
    public void testA() throws Exception {
        oldDomains = ExtralResourceWriteDelegate.getAllKeysByFilePath(filePath, 0);
        objDomains= ExtralResourceWriteDelegate.getAllKeysByFilePath(filePath, 1);
        System.out.println(oldDomains.size()+"  "+objDomains.size());
//        ExcelReaderHelper.getAllCellsByRowsIndex(0,)
        /**
         * 1.遍历老域名  100
         *
         * 2.根据元素来找所有相似的，遍历一次对象站  100*100
         *
         * 3.一次遍历前几位
         * 如果这个对象站设置长度为5位   if length==5 ;
         *                            (100*100)^2
         *
         * 是否包含前四位一次递归到前3位
         *
         *   indexof
         */
        String oldDomainItem;
        String objItem;
        Map<String,List<String>> map=new HashMap<>();
        for (int i = 0; i < oldDomains.size(); i++) {
            oldDomainItem=oldDomains.get(i);
            for (int j = 0; j < objDomains.size(); j++) {
                objItem=objDomains.get(j);
                int y=0;
                y=oldDomainItem.length()-2;
                for (int k = objItem.length(); k >y; k--) {
                    if(oldDomainItem.length()<objItem.length()){
                        continue;
                    }
//                    System.out.println(i+"-"+j+"-"+k);
                    if(oldDomainItem.indexOf(objItem.substring(0,k-1))==0){
                        List<String> lst = map.get(oldDomainItem);
                        if(lst==null){
                            lst=new ArrayList<>();
                        }
                        lst.add(objItem);
                        map.put(oldDomainItem,lst);
                        break;
                    }
                }
            }
        }

        Iterator<String> it = map.keySet().iterator();
        System.out.println(map.size());
        while (it.hasNext()){
            String domains=it.next();
            String str="";
            Collections.sort(map.get(domains));
            for (int i=0;i<map.get(domains).size();i++){
                str+=map.get(domains).get(i)+"_";
            }
            System.out.println(domains+":::"+str);
        }

    }


    @Test
    public void testB() throws Exception {
        int y=7;
        for (int i = 2; i <7 ; i++) {
            System.out.println("else if(cell.getColumnIndex()=="+y+"){");
            System.out.println("setE"+i+"Domains(cellValue);");
            System.out.println("}else if(cell.getColumnIndex()=="+(y+1)+"){");
            System.out.println("setE"+i+"Title(cellValue);");
            System.out.println("}");
            y+=2;
        }
    }
}
