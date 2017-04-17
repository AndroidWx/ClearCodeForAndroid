package com.joye.basedata.webcollector;

import com.joye.basedata.ExcelUtils;
import com.joye.basedata.autoseo.ExcelReaderHelper;
import com.joye.basedata.autoseo.ExcelWriterHelper;
import com.joye.basedata.autoseo.HandleKey;
import com.joye.basedata.utils.AntorUtils;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by joye on 2017/4/14.
 */

public class WebCollectorDelegate {
    /**
     * 1.读取描文本信息列表
     * 2.过滤锚文本不为空的信息
     * 3.开始根据关键字爬去相对应的站点列表
     * 4.不为空的加入到里面去
     */

    @Test
    public void testExecute() throws Exception {
//     execute("/Users/joye/Search/域名处理/2017-4-14/处理域名排版结果1.xlsx");
//        OldDomainInfoBean item=new OldDomainInfoBean();
//        item.setOldDomainStr("");
//        List<String>au=new ArrayList<>();
//        au.add("广州学邦");
//        item.setAutherTxts(au);
//        JoyeBingCrawler crawler=new  JoyeBingCrawler(item, new ICrawlerCallBack() {
//             @Override
//             public void onValidateUrl(String url) {
//                 System.out.println(url);
//             }
//         });
//        crawler.addRegex("((http|https):\\/\\/)?www\\.(.*)\\.(com|cn)");
//        crawler.addRegex("-.*#.*");
//        crawler.setTopN(5);
//        crawler.start(3);
        execute("/Users/joye/Downloads/spencer-2017041描述本.xlsx","/Users/joye/Downloads/","spencer-20170417描述本spaider结果");
    }

    /**
     * 开始执行
     */
    public void execute(String filePath,String writeExcelPath,String fileName) throws Exception {
        List<OldDomainInfoBean> infoBeans=getOldDomainInfos(filePath);
        List<OldDomainInfoBean> executeList=new ArrayList<>();
        List<OldDomainInfoBean> waitList=new ArrayList<>();
        for (OldDomainInfoBean item:infoBeans
             ) {
            if(item.getAutherTxts().isEmpty()){
                waitList.add(item);
            }else {
                executeList.add(item);
            }
        }

        Map<OldDomainInfoBean,LinkedList<String>> map=new HashMap<>();
        Lock lockAnchor = new ReentrantLock();
        try {
            lockAnchor.lock();
            for (OldDomainInfoBean item : executeList
                    ) {
                LinkedList<String> linkedList = new LinkedList<>();
                map.put(item, linkedList);
                new JoyeBingCrawler(item, new ICrawlerCallBack() {
                    @Override
                    public void onValidateUrl(String url) {
                        linkedList.add(url);
                        HandleKey.removeDuplicate(linkedList);
                        map.put(item, linkedList);
                    }
                }).start(2);
            }
        } finally {
            lockAnchor.unlock();
        }
        write(map,writeExcelPath,fileName);
    }

    public void write(Map<OldDomainInfoBean, LinkedList<String>> map, String excelPath, String fileName) throws IOException {
        /**
         * 写入对象站
         */
        Set<OldDomainInfoBean> sets = map.keySet();
        Iterator<OldDomainInfoBean> it = sets.iterator();
        List<OldDomainCoincideEntity> lists=new LinkedList<>();
        OldDomainCoincideEntity entity;
        while(it.hasNext()){
            entity=new OldDomainCoincideEntity();
            OldDomainInfoBean item=it.next();
            entity.setOldDomainStr(item.getOldDomainStr());
            entity.setCoincideLists(map.get(item));
            lists.add(entity);
        }
        WebCollectorWriteExcel.WriteObjectDomains(lists,excelPath,fileName);
    }


    public   interface  ICrawlerCallBack{
        void onValidateUrl(String url);
    }



    /**
     * 获取老域名信息
     * @param filePath 文件路劲
     * @return
     */
    public static List<OldDomainInfoBean> getOldDomainInfos(String filePath) throws FileNotFoundException {
        Workbook workBook = ExcelReaderHelper.getWorkBookByPath(filePath);
        List<OldDomainInfoBean> allResult = new ArrayList<>();
        OldDomainInfoBean entity;
        Sheet sheet = workBook.getSheetAt(0);
        int i=0;
        for (Row r:sheet) {
            if(i==0){
                i++;
                continue;
            }
            List<String> antors=new ArrayList<>();
            entity = new OldDomainInfoBean();
            for (Cell cell : r) {
                String value=cell.getStringCellValue();
                if(cell.getColumnIndex()==0){
                    entity.setOldDomainStr(value);
                }else{
                    if(value!=null&&!value.equals("")&& AntorUtils.antorIsTure(value)){
                        antors.add(value);
                    }
                }
            }
            entity.setAutherTxts(antors);
            allResult.add(entity);
        }
        return allResult;
    }
}
