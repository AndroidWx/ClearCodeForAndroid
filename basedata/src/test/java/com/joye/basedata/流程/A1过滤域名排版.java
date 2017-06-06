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
//        filter("/Users/joye/Downloads/5-18.xlsx","/Users/joye/Downloads/","描文本5-18-整理-新");
//        filter("/Users/joye/Downloads/5-19.xlsx","/Users/joye/Downloads/","描文本5-19-整理-新");
        filter("/Users/joye/Downloads/5-31.xlsx","/Users/joye/Downloads/","描文本5-31-整理-新");
      //  filter("/Users/joye/Downloads/5-27.xlsx","/Users/joye/Downloads/","描文本5-27-整理-新");
        //filter("/Users/joye/Downloads/5-28.xlsx","/Users/joye/Downloads/","描文本5-28-整理-新");
//        filter("/Users/joye/Downloads/5-17.xlsx","/Users/joye/Downloads/","描文本5-17-整理-新");
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
                } else if(cell.getColumnIndex() == 2) {
                    entity.setmExternalBacklinks(cellValue);
                }
                else if(cell.getColumnIndex() == 3) {
                    entity.setmExternalBacklinksEDU(cellValue);
                }
                else if(cell.getColumnIndex() == 4) {
                    entity.setmExternalBacklinksGOV(cellValue);
                }
                else if(cell.getColumnIndex() == 5) {
                    entity.setmReferringDomains(cellValue);
                }
                else if(cell.getColumnIndex() == 6) {
                    entity.setmReferringDomainsEDU(cellValue);
                }
                else if(cell.getColumnIndex() == 7) {
                    entity.setmReferringDomainsGOV(cellValue);
                }
                else if(cell.getColumnIndex() == 8) {
                    entity.setmIPAddresses(cellValue);
                }
                else if(cell.getColumnIndex() == 9) {
                    entity.setmClassCSubnets(cellValue);
                }
                else if(cell.getColumnIndex() == 10) {
                    entity.setmTrustFlow(cellValue);
                }
                else if(cell.getColumnIndex() == 11) {
                    entity.setmCitationFlow(cellValue);
                }
                else if(cell.getColumnIndex() == 12) {
                    entity.setmTopicalTrustFlowTopic0(cellValue);
                }
                else if(cell.getColumnIndex() == 13) {
                    entity.setmTopicalTrustFlowValue0(cellValue);
                }
                else if(cell.getColumnIndex() == 14) {
                    entity.setmTopicalTrustFlowTopic1(cellValue);
                }
                else if(cell.getColumnIndex() == 15) {
                    entity.setmTopicalTrustFlowValue1(cellValue);
                }
                else if(cell.getColumnIndex() == 16) {
                    entity.setmTopicalTrustFlowTopic2(cellValue);
                }
                else if(cell.getColumnIndex() == 17) {
                    entity.setmTopicalTrustFlowValue2(cellValue);
                }
                else if(cell.getColumnIndex() == 18) {
                    entity.setmTopicalTrustFlowTopic3(cellValue);
                }
                else if(cell.getColumnIndex() == 19) {
                    entity.setmTopicalTrustFlowValue3(cellValue);
                }
                else if(cell.getColumnIndex() == 20) {
                    entity.setmTopicalTrustFlowTopic4(cellValue);
                }
                else if(cell.getColumnIndex() == 21) {
                    entity.setmTopicalTrustFlowValue4(cellValue);
                }
                else if(cell.getColumnIndex() == 22) {
                    entity.setmTopicalTrustFlowTopic5(cellValue);
                }
                else if(cell.getColumnIndex() == 23) {
                    entity.setmTopicalTrustFlowValue5(cellValue);
                }
                else if(cell.getColumnIndex() == 24) {
                    entity.setmTopicalTrustFlowTopic6(cellValue);
                }
                else if(cell.getColumnIndex() == 25) {
                    entity.setmTopicalTrustFlowValue6(cellValue);
                }
                else if(cell.getColumnIndex() == 26) {
                    entity.setmTopicalTrustFlowTopic7(cellValue);
                }
                else if(cell.getColumnIndex() == 27) {
                    entity.setmTopicalTrustFlowValue7(cellValue);
                }
                else if(cell.getColumnIndex() == 28) {
                    entity.setmTopicalTrustFlowTopic8(cellValue);
                }
                else if(cell.getColumnIndex() == 29) {
                    entity.setmTopicalTrustFlowValue8(cellValue);
                }
                else if(cell.getColumnIndex() == 30) {
                    entity.setmTopicalTrustFlowTopic9(cellValue);
                }
                else if(cell.getColumnIndex() == 31) {
                    entity.setmTopicalTrustFlowValue9(cellValue);
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
            row.createCell(2).setCellValue(allResult.get(j).getmExternalBacklinks());
            row.createCell(3).setCellValue(allResult.get(j).getmExternalBacklinksEDU());
            row.createCell(4).setCellValue(allResult.get(j).getmExternalBacklinksGOV());
            row.createCell(5).setCellValue(allResult.get(j).getmReferringDomains());
            row.createCell(6).setCellValue(allResult.get(j).getmReferringDomainsEDU());
            row.createCell(7).setCellValue(allResult.get(j).getmReferringDomainsGOV());
            row.createCell(8).setCellValue(allResult.get(j).getmIPAddresses());
            row.createCell(9).setCellValue(allResult.get(j).getmClassCSubnets());
            row.createCell(10).setCellValue(allResult.get(j).getmTrustFlow());
            row.createCell(11).setCellValue(allResult.get(j).getmCitationFlow());
            row.createCell(12).setCellValue(allResult.get(j).getmTopicalTrustFlowTopic0());
            row.createCell(13).setCellValue(allResult.get(j).getmTopicalTrustFlowValue0());
            row.createCell(14).setCellValue(allResult.get(j).getmTopicalTrustFlowTopic1());
            row.createCell(15).setCellValue(allResult.get(j).getmTopicalTrustFlowValue1());
            row.createCell(16).setCellValue(allResult.get(j).getmTopicalTrustFlowTopic2());
            row.createCell(17).setCellValue(allResult.get(j).getmTopicalTrustFlowValue2());
            row.createCell(18).setCellValue(allResult.get(j).getmTopicalTrustFlowTopic3());
            row.createCell(19).setCellValue(allResult.get(j).getmTopicalTrustFlowValue3());
            row.createCell(20).setCellValue(allResult.get(j).getmTopicalTrustFlowTopic4());
            row.createCell(21).setCellValue(allResult.get(j).getmTopicalTrustFlowValue4());
            row.createCell(22).setCellValue(allResult.get(j).getmTopicalTrustFlowTopic5());
            row.createCell(23).setCellValue(allResult.get(j).getmTopicalTrustFlowValue5());
            row.createCell(24).setCellValue(allResult.get(j).getmTopicalTrustFlowTopic6());
            row.createCell(25).setCellValue(allResult.get(j).getmTopicalTrustFlowValue6());
            row.createCell(26).setCellValue(allResult.get(j).getmTopicalTrustFlowTopic7());
            row.createCell(27).setCellValue(allResult.get(j).getmTopicalTrustFlowValue7());
            row.createCell(28).setCellValue(allResult.get(j).getmTopicalTrustFlowTopic8());
            row.createCell(29).setCellValue(allResult.get(j).getmTopicalTrustFlowValue8());
            row.createCell(30).setCellValue(allResult.get(j).getmTopicalTrustFlowTopic9());
            row.createCell(31).setCellValue(allResult.get(j).getmTopicalTrustFlowValue9());
        }
        //创建文件流
        OutputStream stream = new FileOutputStream(newBookPath+ File.separator+newExcelName+"."+EXCEL_TYPE_XLSX);
        //写入数据
        workbook.write(stream);
        //关闭文件流
        stream.close();
    }

}
