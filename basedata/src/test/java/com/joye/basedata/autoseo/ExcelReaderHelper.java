package com.joye.basedata.autoseo;

import com.monitorjbl.xlsx.StreamingReader;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by joye on 2017/4/4.
 */

public class ExcelReaderHelper {

    public static Workbook getWorkBookByPath(String path) throws FileNotFoundException {
        InputStream is = new FileInputStream(new File(path));
        Workbook workbook = StreamingReader.builder()
                .rowCacheSize(100)    // number of rows to keep in memory (defaults to 10)
                .bufferSize(4096)     // buffer size to use when reading InputStream to file (defaults to 1024)
                .open(is);
        return workbook;
    }

    /**
     * 获取某列的单元格的值
     * 比如获取所有的搜索次数下来的排名
     * @param index 下标
     * @param workbook  工作本
     * @return
     */
    public static List<String> getAllCellsByRowsIndex(int index,Workbook workbook){
        List<String> allResult=new ArrayList<>();
        for (Sheet sheet : workbook){
            for (Row r : sheet) {
                for (Cell cell:r){
                    if(cell.getColumnIndex()==index&&!cell.getStringCellValue().equals(""))
                        allResult.add(cell.getStringCellValue());
                }

            }
        }
        return allResult;
    }
}
