package com.joye.basedata;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * Created by joye on 2017/4/6.
 */

public class ExcelUtils {
    public static final String EXCEL_TYPE_XLS="xls";
    public static final String EXCEL_TYPE_XLSX="xlsx";
    /**
     * 创建样式
     * @param workbook
     * @return
     */
    public static CellStyle CreateCellStyle(Workbook workbook) {
        CellStyle style = workbook.createCellStyle(); // 样式对象
        // 设置单元格的背景颜色为淡蓝色
        style.setFillForegroundColor(HSSFColor.PALE_BLUE.index);

        style.setVerticalAlignment(CellStyle.VERTICAL_CENTER);// 垂直
        style.setAlignment(CellStyle.ALIGN_CENTER);// 水平
        style.setWrapText(true);// 指定当单元格内容显示不下时自动换行

        // cell.setCellStyle(style); // 样式，居中

        Font font = workbook.createFont();
        font.setBoldweight(Font.BOLDWEIGHT_BOLD);
        font.setFontName("宋体");
        font.setFontHeight((short) 280);
        style.setFont(font);
        return style;
    }

    /**
     *  创建一个Excel文件
     * @param excelPath 文件路径
     * @param fileName 文件名
     * @param fileType 文件类型
     * @return
     */
    public static Workbook createWorkBook(String excelPath, String fileName, String fileType) throws IOException {
        Workbook wb=null;
        File file=new File(excelPath);
        //声明一个工作薄
        Sheet sheet=null;
        //如果文件不存在
        if(!file.exists()){
            if(isEqulas(fileType,EXCEL_TYPE_XLS)){
                wb=new HSSFWorkbook();
            }else if(isEqulas( fileType,EXCEL_TYPE_XLSX)) {
                wb = new XSSFWorkbook();
            } else {
                throw new IllegalArgumentException("文件格式不正确");
            }
            OutputStream outputStream = new FileOutputStream(excelPath);
            wb.write(outputStream);
            outputStream.flush();
            outputStream.close();
        }else{
            if (fileType.equals(EXCEL_TYPE_XLS)) {
                wb = new HSSFWorkbook();

            } else if(fileType.equals(EXCEL_TYPE_XLSX)) {
                wb = new XSSFWorkbook();

            } else {
                throw new IllegalArgumentException("文件格式不正确");
            }
        }
        return wb;
    }

    protected static boolean isEqulas(String s1,String s2){
        if(null==s1||null==s2){
            return false;
        }
        if(s1.equals(s2)){
            return true;
        }
        return false;
    }
}
