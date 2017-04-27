package com.joye.basedata.流程;

import com.joye.basedata.majestic_.entity.AnchorTextEntity;

import org.junit.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static com.joye.basedata.流程.A2根据老域名获取锚文本.getMajesticInfo;
import static org.apache.poi.xssf.usermodel.XSSFWorkbookType.XLSX;

/**
 * Created by joye on 2017/4/25.
 */

public class All {
    public static String[] randomAnchorTexts=new String[]{""};

    /**
     * 1.根据老域名爬去锚文本
     * 2.根据老域名的锚文本爬对象站
     * 3.获取对象站集合
     * 4.生成一个对应的列表
     *
     */

    private String oldDomainPath="/Users/joye/Search/域名处理/2017-4-27/域名-未用.xlsx";
    private String newExcelPath="/Users/joye/Search/域名处理/2017-4-27/";
    private String newExcelName="处理域名排版结果";
    @Test
    public void testGetMajesticInfo() throws Exception {
        //A.根据老域名爬去锚文本
        getMajesticInfo(0,oldDomainPath , newExcelPath, newExcelName);

        //a.1过滤锚文本
        //B.老根据老域名的锚文本爬去对象站
        C1获取老域名多个对象站的信息.exculte(newExcelPath+newExcelName+ File.separator+XLSX.getExtension());

    }
    public void a(){

    }


}
