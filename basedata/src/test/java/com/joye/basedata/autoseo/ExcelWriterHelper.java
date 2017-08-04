package com.joye.basedata.autoseo;

import com.joye.basedata.ExcelUtils;
import com.joye.basedata.filter.OtherInfoEntity;
import com.joye.basedata.filter.ReplaceDomainEntity;

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
 * Created by joye on 2017/4/4.
 *
 * 写入Excel帮助类
 */

public class ExcelWriterHelper extends ExcelUtils{


    /**
     * 写入外部资源
     */
    public static void WriteExtralRerouse(List<UploadRowResourceEntity> mResourceEntities, String excelPath, String fileName) throws IOException {
//        String excelPath ="/Users/joye/downloads/";
//        String fileName="joye";
        //创建Excel文件
        Workbook workbook= createWorkBook(excelPath,fileName,EXCEL_TYPE_XLSX);
        //根据资源,写入内容
        writeContent(workbook,mResourceEntities);
        excelPath=excelPath+ File.separator+fileName+"."+EXCEL_TYPE_XLSX;
        //创建文件流
        OutputStream stream = new FileOutputStream(excelPath);
        //写入数据
        workbook.write(stream);
        //关闭文件流
        stream.close();
    }

    /**
     * DNS检查完毕之后检查失败的上传
     */
    public static void WriteAginUploadData(List<UploadRowResourceEntity> mResourceEntities, String excelPath, String fileName, List<String> ips, List<ReplaceDomainEntity> replaceDomainEntities, List<OtherInfoEntity> mOtherInfoEntitys) throws IOException {
//        String excelPath ="/Users/joye/downloads/";
//        String fileName="joye";
        //创建Excel文件
        Workbook workbook= createWorkBook(excelPath,fileName,EXCEL_TYPE_XLSX);
        //根据资源,写入内容
        writeContent(workbook,mResourceEntities);
        writeTypesetting(workbook,mResourceEntities,ips,true);
        //写入备用检查对象站
        writeNeedReplaces(workbook,replaceDomainEntities);
        //写入其他信息
        writeOthersReplaces(workbook,mOtherInfoEntitys);
        excelPath=excelPath+ File.separator+fileName+"."+EXCEL_TYPE_XLSX;
        //创建文件流
        OutputStream stream = new FileOutputStream(excelPath);
        //写入数据
        workbook.write(stream);
        //关闭文件流
        stream.close();
    }




    /**
     * 写入外部资源
     */
    public static void WriteExtralRerouse(List<UploadRowResourceEntity> mResourceEntities, String excelPath, String fileName,List<String>ips) throws IOException {
//        String excelPath ="/Users/joye/downloads/";
//        String fileName="joye";
        //创建Excel文件
        Workbook workbook= createWorkBook(excelPath,fileName,EXCEL_TYPE_XLSX);
        //根据资源,写入内容
        writeContent(workbook,mResourceEntities);

        excelPath=excelPath+ File.separator+fileName+"."+EXCEL_TYPE_XLSX;
        //创建文件流
        OutputStream stream = new FileOutputStream(excelPath);
        //写入数据
        workbook.write(stream);
        //关闭文件流
        stream.close();
    }

    /**
     * 写入上传检查
     *
      */
    public static void writeUploadCheck(List<UploadRowResourceEntity> mResourceEntities,
                                        String excelPath,
                                        String fileName,
                                        List<String>ips,
                                        List<ReplaceDomainEntity> replaceDomainEntities,
                                        List<OtherInfoEntity> mOtherInfoEntitys
    ) throws IOException {
        //创建Excel文件
        Workbook workbook= createWorkBook(excelPath,fileName,EXCEL_TYPE_XLSX);
        //根据资源,写入内容
        writeContent(workbook,mResourceEntities);
        //写入排版专用
        writeTypesetting(workbook,mResourceEntities,ips);
        //写入备用检查对象站
        writeNeedReplaces(workbook,replaceDomainEntities);
        //写入其他信息
        writeOthersReplaces(workbook,mOtherInfoEntitys);

        excelPath=excelPath+ File.separator+fileName+"."+EXCEL_TYPE_XLSX;
        //创建文件流
        OutputStream stream = new FileOutputStream(excelPath);
        //写入数据
        workbook.write(stream);
        //关闭文件流
        stream.close();
    }

    /**
     *
     * @param workbook
     * @param resourceEntities
     */

    private static void writeContent(Workbook workbook, List<UploadRowResourceEntity> resourceEntities){
        Sheet sheet =workbook.createSheet("上站文档");
        //获取样式
        CellStyle mCellStyle=CreateCellStyle(workbook);
        //写入第一行
        createTitle(sheet,mCellStyle);
        //从第二行开始写入数据
        writeResourceEntityCellDataToRow(sheet,1,resourceEntities);

    }

    public static void writeNeedReplaces(Workbook workbook, List<ReplaceDomainEntity> resourceEntities){
        Sheet sheet =workbook.createSheet("备用站替换");
        //获取样式
        CellStyle mCellStyle=CreateCellStyle(workbook);
        //创建第一行
        Row row = sheet.createRow(0);
        String[]titleRow=new String[]{"对象站*","关键词*","编码*"};
        Cell cell=null;
        for (int i =0;i<titleRow.length;i++){
            cell = row.createCell(i);
            cell.setCellValue(titleRow[i]);
            cell.setCellStyle(mCellStyle); // 样式，居中
            sheet.setColumnWidth(i, 20 * 256);
        }
        row.setHeight((short) 540);
        for (int i = 0; i < resourceEntities.size(); i++) {
            ReplaceDomainEntity entiy= resourceEntities.get(i);
            row = (Row) sheet.createRow(i+1);
            row.setHeight((short) 500);
            row.createCell(0).setCellValue(entiy.getDomain());
            row.createCell(1).setCellValue(entiy.getKeystr());
            row.createCell(2).setCellValue(entiy.getCharsert());
        }
    }

    public static void writeOthersReplaces(Workbook workbook, List<OtherInfoEntity> resourceEntities){
        Sheet sheet =workbook.createSheet("预备替换");
        //获取样式
        CellStyle mCellStyle=CreateCellStyle(workbook);
        //创建第一行
        Row row = sheet.createRow(0);
        String[]titleRow=new String[]{"循环交叉第1台服务器域名",
                "循环交叉第1台关键词","循环交叉第2台服务器域名","循环交叉第2台服务器域名","已上第一台域名","已上第一台标题",
                "已上第二台域名","已上第二台标题","已上第三台域名","已上第三台标题","已上第四台域名","已上第四台标题","已上第五台域名","已上第五台标题","已上第六台域名","已上第六台标题"};
        Cell cell=null;
        for (int i =0;i<titleRow.length;i++){
            cell = row.createCell(i);
            cell.setCellValue(titleRow[i]);
            cell.setCellStyle(mCellStyle); // 样式，居中
            sheet.setColumnWidth(i, 20 * 256);
        }
        row.setHeight((short) 540);
        for (int i = 0; i < resourceEntities.size(); i++) {
            OtherInfoEntity entiy= resourceEntities.get(i);
            row = (Row) sheet.createRow(i+1);
            row.setHeight((short) 500);
            row.createCell(0).setCellValue(entiy.getOtherOldDomains());
            row.createCell(1).setCellValue(entiy.getOtherOldTitle());
            row.createCell(2).setCellValue(entiy.getElseOldDomains());
            row.createCell(3).setCellValue(entiy.getElseOldTitle());
            row.createCell(4).setCellValue(entiy.getE1Domains());
            row.createCell(5).setCellValue(entiy.getE1Title());
            row.createCell(6).setCellValue(entiy.getE2Domains());
            row.createCell(7).setCellValue(entiy.getE2Title());
            row.createCell(8).setCellValue(entiy.getE3Domains());
            row.createCell(9).setCellValue(entiy.getE3Title());
            row.createCell(10).setCellValue(entiy.getE4Domains());
            row.createCell(11).setCellValue(entiy.getE4Title());
            row.createCell(12).setCellValue(entiy.getE5Domains());
            row.createCell(13).setCellValue(entiy.getE5Title());
            row.createCell(14).setCellValue(entiy.getE6Domains());
            row.createCell(15).setCellValue(entiy.getE6Title());
        }
    }

    public static void writeTypesetting(Workbook workbook,List<UploadRowResourceEntity> oldmains,List<String> ips,boolean isReUpload){
        Sheet sheet =workbook.createSheet("排版专用");
        //获取样式
        CellStyle mCellStyle=CreateCellStyle(workbook);
        //循环写入行数据
        Row row=null;
        for (int i = 0; i < oldmains.size(); i++) {
            String oldDomain= oldmains.get(i).getOldDomainNoFrefix();
            row = (Row) sheet.createRow(i);
            row.setHeight((short) 500);
            row.createCell(0).setCellValue(isReUpload?oldmains.get(i).getOldDomainStr():"www."+oldDomain);
            row.createCell(1).setCellValue("#");
            row.createCell(2).setCellValue(ips.get(i));
            row.createCell(3).setCellValue(isReUpload?oldmains.get(i).getOldDomainStr():"www."+oldDomain);
            row.createCell(4).setCellValue("#");
            row.createCell(5).setCellValue(ips.get(i));
            row.createCell(6).setCellValue(isReUpload?oldmains.get(i).getOldDomainStr().substring(4,oldmains.get(i).getOldDomainStr().length()):oldDomain);
            row.createCell(7).setCellValue("");
            row.createCell(8).setCellValue("");
            row.createCell(9).setCellValue("http://");
            row.createCell(10).setCellValue(isReUpload?"http://"+oldmains.get(i).getOldDomainStr():"http://www."+oldDomain);
            row.createCell(11).setCellValue("");
            row.createCell(12).setCellValue(isReUpload?oldmains.get(i).getOldDomainStr():oldDomain);
            row.createCell(13).setCellValue("|");
            row.createCell(14).setCellValue("@");
            row.createCell(15).setCellValue("|");
            row.createCell(16).setCellValue("A");
            row.createCell(17).setCellValue("|");
            row.createCell(18).setCellValue(ips.get(i));
            row.createCell(19).setCellValue("|");
            row.createCell(20).setCellValue("默认");
            row.createCell(21).setCellValue("我就是要分割");
            row.createCell(22).setCellValue(isReUpload?oldmains.get(i).getOldDomainStr():oldDomain);
            row.createCell(23).setCellValue("|");
            row.createCell(24).setCellValue("*");
            row.createCell(25).setCellValue("|");
            row.createCell(26).setCellValue("A");
            row.createCell(27).setCellValue("|");
            row.createCell(28).setCellValue(ips.get(i));
            row.createCell(29).setCellValue("|");
            row.createCell(30).setCellValue("默认");
            row.createCell(31).setCellValue("你拿我咋滴");
            row.createCell(32).setCellValue(isReUpload?oldmains.get(i).getOldDomainStr():oldDomain);
            row.createCell(33).setCellValue("|");
            row.createCell(34).setCellValue("www");
            row.createCell(35).setCellValue("|");
            row.createCell(36).setCellValue("A");
            row.createCell(37).setCellValue("|");
            row.createCell(38).setCellValue(ips.get(i));
            row.createCell(39).setCellValue("|");
            row.createCell(40).setCellValue("默认");
            ;
//            row.createCell(9).setCellValue(getObjectDomain());
//            row.createCell(10).setCellValue(getReplaceKeyStr());
//            row.createCell(11).setCellValue(getChartsetStr());
        }
    }

    /**
     * 写入排版专用
     * @param oldmains 老域名
     * @param ips
     */
    public static void writeTypesetting(Workbook workbook,List<UploadRowResourceEntity> oldmains,List<String> ips){
        writeTypesetting(workbook,oldmains,ips,false);

    }



    /**
     * 写入数据到单元行
     * @param sheet 工作薄
     * @param beginIndex 开始写入的位置
     * @param resourceEntities 数据源
     *
     */
    private static void writeResourceEntityCellDataToRow(Sheet sheet, int beginIndex, List<UploadRowResourceEntity> resourceEntities){
        //循环写入行数据
        Row row=null;
        for (int i = 0; i < resourceEntities.size(); i++) {
            UploadRowResourceEntity entiy= resourceEntities.get(i);
            row = (Row) sheet.createRow(i+beginIndex);
            row.setHeight((short) 500);
            entiy.setRow(row);
        }
    }


    /**
     * 创建表头
     */
    private static void createTitle(Sheet  sheet,CellStyle mCellStyle){
        //创建第一行
        Row row = sheet.createRow(0);
        String[]titleRow= UploadRowResourceEntity.TITLES;
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
