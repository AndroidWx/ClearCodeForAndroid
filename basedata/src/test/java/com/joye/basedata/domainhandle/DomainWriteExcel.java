package com.joye.basedata.domainhandle;

import com.joye.basedata.ExcelUtils;
import com.joye.basedata.majestic_.entity.AnchorTextEntity;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

/**
 * Created by joye on 2017/4/6.
 */

public class DomainWriteExcel extends ExcelUtils {
        public static void WriteDomainArchive(List<ArchiveResponse> mArchiveResponse, String excelPath, String fileName) throws IOException {
        //创建Excel文件
        Workbook workbook= createWorkBook(excelPath,fileName,EXCEL_TYPE_XLSX);
        Sheet sheet =workbook.createSheet("sheet1");
        //获取样式
        CellStyle mCellStyle=CreateCellStyle(workbook);
        //写入第一行
        createTitle(sheet,mCellStyle);
        //从第二行开始写入数据
        writeResourceEntityCellDataToRow(sheet,1,mArchiveResponse);

            excelPath=excelPath+ File.separator+fileName+"."+EXCEL_TYPE_XLSX;
            //创建文件流
            OutputStream stream = new FileOutputStream(excelPath);
            //写入数据
            workbook.write(stream);
            //关闭文件流
            stream.close();
    }

    public static void WriteDomainMajestic(List<AnchorTextEntity> AnchrTextEntitys,String excelPath,String fileName) throws IOException {
        //创建Excel文件
        Workbook workbook= createWorkBook(excelPath,fileName,EXCEL_TYPE_XLSX);
        Sheet sheet =workbook.createSheet("sheet1");
        //获取样式
        CellStyle mCellStyle=CreateCellStyle(workbook);
        //写入第一行
        createTitleByAnchorText(sheet,mCellStyle);
        //从第二行开始写入数据
        writeAnchorTextEntityCellDataToRow(sheet,1,AnchrTextEntitys);

        excelPath=excelPath+ File.separator+fileName+"."+EXCEL_TYPE_XLSX;
        //创建文件流
        OutputStream stream = new FileOutputStream(excelPath);
        //写入数据
        workbook.write(stream);
        //关闭文件流
        stream.close();
    }
    /**
     * 创建表头
     */
    private static void createTitleByAnchorText(Sheet  sheet,CellStyle mCellStyle){
        //创建第一行
        Row row = sheet.createRow(0);
        String[]titleRow= AnchorTextEntity.TITLES;
        Cell cell=null;
        for (int i =0;i<titleRow.length;i++){
            cell = row.createCell(i);
            cell.setCellValue(titleRow[i]);
            cell.setCellStyle(mCellStyle); // 样式，居中
            sheet.setColumnWidth(i, i==1?5*20 * 256:20*256);
        }
        row.setHeight((short) 540);
    }

    /**
     * 写入数据到单元行
     * @param sheet 工作薄
     * @param beginIndex 开始写入的位置
     * @param resourceEntities 数据源
     *
     */
    private static void writeResourceEntityCellDataToRow(Sheet sheet, int beginIndex, List<ArchiveResponse> resourceEntities){
        //循环写入行数据
        Row row=null;
        for (int i = 0; i < resourceEntities.size(); i++) {
            ArchiveResponse entiy= resourceEntities.get(i);
            row = (Row) sheet.createRow(i+beginIndex);
            row.setHeight((short) 500);
            entiy.setRow(row);
        }
    }

    /**
     * 写入数据到单元行
     * @param sheet 工作薄
     * @param beginIndex 开始写入的位置
     * @param resourceEntities 数据源
     *
     */
    private static void writeAnchorTextEntityCellDataToRow(Sheet sheet, int beginIndex, List<AnchorTextEntity> resourceEntities){
        //循环写入行数据
        Row row=null;
        for (int i = 0; i < resourceEntities.size(); i++) {
            List<AnchorTextEntity.AnchorTextBean.DataBean> datas = resourceEntities.get(i).getAnchorText().getData();
            row = (Row) sheet.createRow(i+beginIndex);
            row.setHeight((short) 500);
            row.createCell(0).setCellValue(resourceEntities.get(i).getOldDomainStr());
            for (int j = 0; j < datas.size(); j++) {
                row.createCell(j+1).setCellValue(datas.get(j).getAnchorText());
            }
        }
    }


    /**
     * 创建表头
     */
    private static void createTitle(Sheet  sheet,CellStyle mCellStyle){
        //创建第一行
        Row row = sheet.createRow(0);
        String[]titleRow= ArchiveResponse.TITLES;
        Cell cell=null;
        for (int i =0;i<titleRow.length;i++){
            cell = row.createCell(i);
            cell.setCellValue(titleRow[i]);
            cell.setCellStyle(mCellStyle); // 样式，居中
            sheet.setColumnWidth(i, 20 * 256);
        }
        row.setHeight((short) 540);
    }

}
