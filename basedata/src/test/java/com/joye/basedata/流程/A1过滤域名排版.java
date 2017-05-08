package com.joye.basedata.流程;

import com.joye.basedata.autoseo.ExcelReaderHelper;
import com.joye.basedata.domainhandle.DomainDelegate;
import com.joye.basedata.utils.AntorUtils;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.junit.Test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import static com.joye.basedata.ExcelUtils.CreateCellStyle;
import static com.joye.basedata.ExcelUtils.EXCEL_TYPE_XLSX;
import static com.joye.basedata.ExcelUtils.createWorkBook;

/**
 * Created by joye on 2017/4/20.
 */

public class A1过滤域名排版 {


    /**
     * 过滤域名排版
     * @throws Exception
     */
    @Test
    public void testDomain() throws Exception {
//        filter("/Users/joye/Downloads/4-24.xlsx","/Users/joye/Downloads/","描文本4-24-整理-新");
//        filter("/Users/joye/Downloads/4-25.xlsx","/Users/joye/Downloads/","描文本4-25-整理-新");
//        filter("/Users/joye/Downloads/4-26.xlsx","/Users/joye/Downloads/","描文本4-26-整理-新");
        filter("/Users/joye/Downloads/5-8.xlsx","/Users/joye/Downloads/","描文本5-8-整理-新");
//        filter("/Users/joye/Downloads/5-6.xlsx","/Users/joye/Downloads/","描文本5-6-整理-新");
//        filter("/Users/joye/Downloads/5-7.xlsx","/Users/joye/Downloads/","描文本5-7-整理-新");
//        filter("/Users/joye/Downloads/4-30.xlsx","/Users/joye/Downloads/","描文本4-30-整理-新");

    }

    private void filter(String filePath,String newBookPath,String newExcelName) throws IOException {
        Workbook workBook = ExcelReaderHelper.getWorkBookByPath(filePath);
        List<DomainDelegate.Item> allResult = new ArrayList<>();
        DomainDelegate.Item entity;
        String cellValue = "";
        Sheet sheet = workBook.getSheetAt(0);
        int i = 0;
        for (Row r : sheet) {
            entity = new DomainDelegate.Item();
            for (Cell cell : r) {
                cellValue = cell.getStringCellValue();
                if(cellValue==null){
                    cellValue="";
                }
                if (cell.getColumnIndex() == 0) {
                    entity.setDomain(cellValue);
                } else if (cell.getColumnIndex() == 1) {
                    entity.setAntor(cellValue);
                } else {
                    break;
                }
            }
            String antor = entity.getAntor();
            if(AntorUtils.antorIsTure(antor)
                    ) {
                allResult.add(entity);
            }
        }


        Workbook workbook= createWorkBook(newBookPath,newExcelName,EXCEL_TYPE_XLSX);
        //根据资源,写入内容
        Sheet sheet1 =workbook.createSheet("sheet1");
        //获取样式
        CellStyle mCellStyle=CreateCellStyle(workbook);

        Row row=null;
        for (int j = 0; j < allResult.size(); j++) {
            DomainDelegate.Item entiy= allResult.get(j);
            row = (Row) sheet1.createRow(j);
            row.setHeight((short) 500);
            row.createCell(0).setCellValue(allResult.get(j).getDomain());
            row.createCell(1).setCellValue(allResult.get(j).getAntor());
        }
        //创建文件流
        OutputStream stream = new FileOutputStream(newBookPath+ File.separator+newExcelName+"."+EXCEL_TYPE_XLSX);
        //写入数据
        workbook.write(stream);
        //关闭文件流
        stream.close();
    }

}
