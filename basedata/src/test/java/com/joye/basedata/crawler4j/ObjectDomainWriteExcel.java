package com.joye.basedata.crawler4j;

import com.joye.basedata.ExcelUtils;

import org.apache.commons.lang.StringUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by joye on 2017/4/7.
 */

public class ObjectDomainWriteExcel extends ExcelUtils {

    /**
     * 开始写入
     *
     * @param oldDomains       老域名集合
     * @param objectDomains    对象站集合
     * @param mArchiveResponse 抓取的对象站是个体
     * @param excelPath        写入地址
     * @param fileName         文件名
     * @throws IOException
     */
    public static void WriteDomainArchive(List<String> oldDomains, List<String> objectDomains, List<DomainObjectEntity> mArchiveResponse, String excelPath, String fileName) throws IOException {
        //创建Excel文件
        Workbook workbook = createWorkBook(excelPath, fileName, EXCEL_TYPE_XLSX);
        Sheet sheet = workbook.createSheet("sheet1");
        //获取样式
        CellStyle mCellStyle = CreateCellStyle(workbook);
        //写入第一行
        createTitle(sheet, mCellStyle);
        //从第二行开始写入数据
        writeResourceEntityCellDataToRow(sheet, 1, mArchiveResponse, objectDomains, oldDomains);

        excelPath = excelPath + File.separator + fileName + "." + EXCEL_TYPE_XLSX;
        //创建文件流
        OutputStream stream = new FileOutputStream(excelPath);
        //写入数据
        workbook.write(stream);
        //关闭文件流
        stream.close();
    }


    /**
     * 开始写入
     *
     * @param oldDomains       老域名集合
     * @param objectDomains    对象站集合
     * @param mArchiveResponse 抓取的对象站是个体
     * @param excelPath        写入地址
     * @param fileName         文件名
     * @throws IOException
     */
    public static void WriteDomainArchive(List<String> oldDomains, List<String> objectDomains, List<DomainObjectEntity> mArchiveResponse, String excelPath, String fileName, List<String> indexs) throws IOException {
        //创建Excel文件
        Workbook workbook = createWorkBook(excelPath, fileName, EXCEL_TYPE_XLSX);
        Sheet sheet = workbook.createSheet("sheet1");
        //获取样式
        CellStyle mCellStyle = CreateCellStyle(workbook);
        //写入第一行
        createTitle(sheet, mCellStyle);
        //从第二行开始写入数据
        writeUseableResourceEntityCellDataToRow(sheet, 1, mArchiveResponse, objectDomains, oldDomains);

        excelPath = excelPath + File.separator + fileName + "." + EXCEL_TYPE_XLSX;
        //创建文件流
        OutputStream stream = new FileOutputStream(excelPath);
        //写入数据
        workbook.write(stream);
        //关闭文件流
        stream.close();
    }


//    /**
//     * 创建表头
//     */
//    private static void createTitleByAnchorText(Sheet  sheet,CellStyle mCellStyle){
//        //创建第一行
//        Row row = sheet.createRow(0);
//        String[]titleRow= AnchorTextEntity.TITLES;
//        Cell cell=null;
//        for (int i =0;i<titleRow.length;i++){
//            cell = row.createCell(i);
//            cell.setCellValue(titleRow[i]);
//            cell.setCellStyle(mCellStyle); // 样式，居中
//            int width=0;
//            if(i==0){
//                width=3*20 * 256;
//            }else if(i==1){
//                width=10*256;
//            }else if(i==2){
//                width=4*20*256;
//            }else if(i==3){
//                width=6*20*256;
//            }else if(i==4){
//                width=10*20*256;
//            }
//        }
//        row.setHeight((short) 540);
//    }

    /**
     * 写入数据到单元行
     *
     * @param sheet            工作薄
     * @param beginIndex       开始写入的位置
     * @param resourceEntities 数据源
     * @param objectDomains    对象站
     * @param oldDomains       老域名
     */
    private static void writeResourceEntityCellDataToRow(Sheet sheet, int beginIndex,
                                                         List<DomainObjectEntity> resourceEntities,
                                                         List<String> objectDomains,
                                                         List<String> oldDomains) {
        //循环写入行数据
        Row row = null;
        for (int i = 0; i < objectDomains.size(); i++) {
            boolean write = false;
            int j = 0;
            for (; j < resourceEntities.size(); j++) {
                if (resourceEntities.get(j).getUrl().contains(objectDomains.get(i))) {
                    write = true;
                    break;
                }
            }
            if (write) {
                DomainObjectEntity entiy = resourceEntities.get(j);
                row = (Row) sheet.createRow(i + beginIndex);
                row.setHeight((short) 500);
                entiy.setRow(row, objectDomains.get(i), oldDomains.get(i));
            } else {
                row = (Row) sheet.createRow(i + beginIndex);
                row.setHeight((short) 500);
                row.createCell(0).setCellValue(objectDomains.get(i));
                row.createCell(3).setCellValue(oldDomains.get(i));
            }
        }
    }


    /**
     * 写入数据到单元行
     *
     * @param sheet            工作薄
     * @param beginIndex       开始写入的位置
     * @param resourceEntities 数据源
     * @param objectDomains    对象站
     * @param oldDomains       老域名
     */
    private static void writeUseableResourceEntityCellDataToRow(Sheet sheet, int beginIndex,
                                                                List<DomainObjectEntity> resourceEntities,
                                                                List<String> objectDomains,
                                                                List<String> oldDomains) {

        Row row = null;
        //已经搞好的老域名
        List<String> completeOldDomains = new ArrayList<>();
        int writeindex=0;
        for (int i = 0; i < oldDomains.size(); i++) {
            //如果这个老域名装配完，就不继续装配
            if (completeOldDomains.contains(oldDomains.get(i))) {
                continue;
            }
            boolean write=false;
            haveNext:
            //遍历查询到所有的对象站信息实体
            for (int j = 0; j < resourceEntities.size(); j++) {
                    //如果遍历到这个对象站的时候
                    if (objectDomains.get(i).equals(resourceEntities.get(j).getUrl())) {
                        //如果这个对象站TDK满足满足条件
                        if (StringUtils.isNotBlank(resourceEntities.get(j).getTitle()) &&
                                StringUtils.isNotBlank(resourceEntities.get(j).getDescription()) &&
                                StringUtils.isNotBlank(resourceEntities.get(j).getKeywords())) {
                            DomainObjectEntity entiy = resourceEntities.get(j);
                            row = (Row) sheet.createRow(writeindex + beginIndex);
                            row.setHeight((short) 500);
                            entiy.setRow(row, objectDomains.get(i), oldDomains.get(i));
                            completeOldDomains.add(oldDomains.get(i));
                            writeindex++;
                            write=true;
                            continue haveNext;
                        }
                    }
            }
            if(!write){
                row = (Row) sheet.createRow(writeindex + beginIndex);
                row.setHeight((short) 500);
                row.createCell(3).setCellValue(oldDomains.get(i));
                writeindex++;
                completeOldDomains.add(oldDomains.get(i));
            }
        }

//        int i = 0;
//        //遍历所有的对象站
//        for (int k = 0; k < objectDomains.size(); k++) {
//
//
//            //遍历查询到所有的对象站信息实体
//            for (int j = 0; j < resourceEntities.size(); j++) {
//                //如果这条老域名查找的对象战被写入之后， 满足条件之后，不执行
//                if (objectDomains.get(k).equals(resourceEntities.get(j).getUrl())) {
//                    //如果这个
//                    if (StringUtils.isNotBlank(resourceEntities.get(j).getTitle()) &&
//                            StringUtils.isNotBlank(resourceEntities.get(j).getDescription()) &&
//                            StringUtils.isNotBlank(resourceEntities.get(j).getKeywords())) {
//                        DomainObjectEntity entiy = resourceEntities.get(j);
//                        row = (Row) sheet.createRow(i + 1);
//                        row.setHeight((short) 500);
//                        entiy.setRow(row, objectDomains.get(k), oldDomains.get(k));
//                        completeOldDomains.add(oldDomains.get(k));
//                        break;
//                    }
//                }
//            }
//            if(!write){
//                row = (Row) sheet.createRow(i + beginIndex);
//                row.setHeight((short) 500);
//                row.createCell(3).setCellValue(oldDomains.get(i));
//                i++;
//            }
//        }

//        }


//        //遍历所有对象站次数很多
//        for (int i = 0; i < objectDomains.size(); i++) {
//            //是否写入
//            boolean write=false;
//            int j=0;
//            //获取所有的对象站信息遍历所有对象站
//            for (; j <resourceEntities.size() ; j++) {
//                //如果包含对象站
//                if(resourceEntities.get(j).getUrl().contains(objectDomains.get(i))){
//                    if(StringUtils.isNotBlank(resourceEntities.get(j).getTitle())&&
//                            StringUtils.isNotBlank(resourceEntities.get(j).getDescription())&&
//                            StringUtils.isNotBlank(resourceEntities.get(j).getKeywords())) {
//                        write = true;
//                        break;
//                    }
//
//                }
//            }
//            if(write) {
//                DomainObjectEntity entiy = resourceEntities.get(j);
//                row = (Row) sheet.createRow(i + beginIndex);
//                row.setHeight((short) 500);
//                entiy.setRow(row,objectDomains.get(i),oldDomains.get(i));
//            }else{
//                row = (Row) sheet.createRow(i + beginIndex);
//                row.setHeight((short) 500);
//                row.createCell(0).setCellValue(objectDomains.get(i));
//                row.createCell(3).setCellValue(oldDomains.get(i));
//            }
//        }
    }


    /**
     * 创建表头
     */
    private static void createTitle(Sheet sheet, CellStyle mCellStyle) {
        //创建第一行
        Row row = sheet.createRow(0);
        String[] titleRow = DomainObjectEntity.TITLES;
        Cell cell = null;
        for (int i = 0; i < titleRow.length; i++) {
            cell = row.createCell(i);
            cell.setCellValue(titleRow[i]);
            cell.setCellStyle(mCellStyle); // 样式，居中
            int width = 0;
            if (i == 0) {
                width = 20 * 256;
            } else if (i == 1) {
                width = 20 * 256;
            } else if (i == 2) {
                width = 20 * 256;
            } else if (i == 3) {
                width = 20 * 256;
            } else if (i == 4) {
                width = 5 * 256;
            } else if (i == 5) {
                width = 4 * 20 * 256;
            } else if (i == 6 || i == 7 || i == 8 || i == 9) {
                width = 7 * 20 * 256;
            }
            sheet.setColumnWidth(i, width);
        }
        row.setHeight((short) 540);
    }

    /**
     * 创建表头
     */
    private static void createTitle1(Sheet sheet, CellStyle mCellStyle) {
        //创建第一行
        Row row = sheet.createRow(0);
        String[] titleRow = DomainObjectEntity.TITLES1;
        Cell cell = null;
        for (int i = 0; i < titleRow.length; i++) {
            cell = row.createCell(i);
            cell.setCellValue(titleRow[i]);
            cell.setCellStyle(mCellStyle); // 样式，居中
            int width = 0;
            if (i == 0) {
                width = 20 * 256;
            } else if (i == 1) {
                width = 23 * 256;
            } else if (i == 2) {
                width = 23 * 256;
            } else if (i == 3) {
                width = 18 * 256;
            } else if (i == 4) {
                width = 20 * 256;
            } else if (i == 5) {
                width = 4 * 256;
            } else if (i == 6) {
                width = 3 * 20 * 256;

            } else if (i == 7) {
                width = 20 * 256;
            } else if (i == 8 || i == 9) {
                width = 7 * 20 * 256;
            }
            sheet.setColumnWidth(i, width);
        }
        row.setHeight((short) 540);
    }
}
