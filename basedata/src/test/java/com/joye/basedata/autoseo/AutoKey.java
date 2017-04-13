package com.joye.basedata.autoseo;

import com.monitorjbl.xlsx.StreamingReader;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import edu.emory.mathcs.backport.java.util.Collections;

/**
 * Created by joye on 2017/3/26.
 */

public class AutoKey {
   /* private List<String> all = new ArrayList<>();
    private  List<String>allResult=new ArrayList<>();
    @Before
    public void setUp() throws Exception {
        InputStream is = new FileInputStream(new File("/Users/joye/downloads/test3.xlsx"));
        Workbook workbook = StreamingReader.builder()
                .rowCacheSize(100)    // number of rows to keep in memory (defaults to 10)
                .bufferSize(4096)     // buffer size to use when reading InputStream to file (defaults to 1024)
                .open(is);
        for (Sheet sheet : workbook){
            System.out.println(sheet.getSheetName());
            for (Row r : sheet) {
                for (Cell c : r) {
                    if(c.getStringCellValue().contains("亚虎国际")){
                        all.add(c.getStringCellValue());
                        break;
                    }

                }
            }
        }
        System.out.println(all);
        System.out.println("----------");
        for (int i = 0; i < all.size(); i++) {
            System.out.println(all.get(i));
        }
    }

    @Test
    public void testReader() throws Exception {
        getAllKeys("/Users/joye/downloads/test3.xlsx");


    }

    *//**
     * 获取所有的关键字
     * @param path  路径
     * @throws Exception
     *//*
    private List<String> getAllKeys(String path) throws FileNotFoundException {
        List<String> allResult=new ArrayList<>();
        InputStream is = new FileInputStream(new File(path));
        Workbook workbook = StreamingReader.builder()
                .rowCacheSize(100)    // number of rows to keep in memory (defaults to 10)
                .bufferSize(4096)     // buffer size to use when reading InputStream to file (defaults to 1024)
                .open(is);
        for (Sheet sheet : workbook){
            for (Row r : sheet) {
                for (Cell cell:r){
                    if(cell.getColumnIndex()==0&&!cell.getStringCellValue().equals(""))
                    allResult.add(cell.getStringCellValue());
                }

            }
        }
        return allResult;
    }

    @Test
    public void testFilter() throws Exception {
        all.addAll(getAllKeys("/Users/joye/downloads/test3.xlsx"));
        //总共相同的列表
        List<List<String>> someList = new ArrayList<>();
        //遍历所有的关键词
        for (String item : all) {
            //关键词相同的集合
            List<String> someItemList = new ArrayList<>();
            //遍历关键词
            for (String itemElse : all) {
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
            handle(list);
        }
        removeDuplicate(allResult);
        System.out.println();
        for (int i = 0; i < allResult.size(); i++) {
            System.out.println(allResult.get(i));
        }
    }

    *//**
     * 整理item相似的站点
     *
     * @param list
     *//*
    public void handle(List<String> list) {
        int n = (int) (Math.random() * (all.size() > 10 ? 10 : all.size() - 1));
        if (list.size() == 2) {
            String s = new String("");
            for (int j = 0; j < list.size(); j++) {
                s += (list.get(j) + "_");
            }
            s=s + all.get(n);
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
                handle(allList.get(i));
            }
        }
    }

    public static void removeDuplicate(List list) {
        HashSet h = new HashSet(list);
        list.clear();
        list.addAll(h);
    }

    @Test
    public void testZip() throws Exception {


    }

//    @Test
//    public void testAutoCreate() throws Exception {
//        String[] preceding = {};
//        List<List<String>> listAll = new ArrayList<>();
//        Comb(preceding, keys, listAll);
//
//    }

//    private void Print(String[] list) {
//        if (list.length < 2) {
//            return;
//        }
//        for (int i = 0; i < list.length; ++i) {
//            System.out.print(list[i] + ((i != list.length - 1) ? "_" : ""));
//        }
//        System.out.println();
//    }

    private void Copy(String[] destination, String[] source, int start) {
        for (int i = start; i < source.length; ++i) {
            destination[i - start] = source[i];
        }
    }

    public void Comb(String[] preceding, String[] list, List<List<String>> listAll) {
        if (list.length == 0) {
            if (preceding.length >= 2) {
                for (int i = 0; i < preceding.length; i++) {
                    List<String> childs = new ArrayList<>();
                    for (int j = i + 1; j < preceding.length; j++) {
                        childs.add(preceding[i]);
                        childs.add(preceding[j]);
                        break;
                    }
                    if (childs.size() != 0)
                        listAll.add(childs);
                }
                removeDuplicate(listAll);
                for (List<String> item :
                        listAll) {
                    System.out.println(item);
                }
            }
//            Print(preceding);
        } else {
            //前面的集合
            String[] newPreceding = new String[preceding.length + 1];
            //复制
            Copy(newPreceding, preceding, 0);
            //第0个
            newPreceding[preceding.length] = list[0];
            //新的集合
            String[] newList = new String[list.length - 1];
            Copy(newList, list, 1);
            Comb(newPreceding, newList, listAll);
            Comb(preceding, newList, listAll);
        }
    }*/
}
