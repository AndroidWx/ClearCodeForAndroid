package com.joye.basedata.流程;

import com.joye.basedata.autoseo.ExcelReaderHelper;
import com.joye.basedata.filter.ItemEntity;
import com.joye.basedata.utils.AntorUtils;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * Created by joye on 2017/4/21.
 */

public class E批量检查失败的程序 {
    @Test
    public void testA() throws Exception {


        Workbook workBook= ExcelReaderHelper.getWorkBookByPath("/Users/joye/Search/combination/joye/04-24上传检查.xlsx");
        List<String> allResult = new ArrayList<>();
        Sheet sheet = workBook.getSheetAt(0);
        for (Row r:sheet) {
            for (Cell cell : r) {
                String value = cell.getStringCellValue();
                if (cell.getColumnIndex() == 2) {
                    allResult.add(value);
                }

            }
        }
        workBook= ExcelReaderHelper.getWorkBookByPath("/Users/joye/Search/combination/joye/04-26上传检查5个过户.xlsx");
        sheet = workBook.getSheetAt(0);
        for (Row r:sheet) {
            for (Cell cell : r) {
                String value = cell.getStringCellValue();
                if (cell.getColumnIndex() == 2) {
                    allResult.add(value);
                }

            }
        }
        List<String> lst=new ArrayList<>();
        for (int i = 2; i <255 ; i++) {
            lst.add("147.255.181."+i);
        }
        System.out.println(lst.removeAll(allResult));
        System.out.println(lst.size());

//        for (String it :
//                lst) {
//            System.out.println(it);
//        }
        Set<String> set=new HashSet<>(lst);
        Iterator<String> it = set.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }
    }
}
