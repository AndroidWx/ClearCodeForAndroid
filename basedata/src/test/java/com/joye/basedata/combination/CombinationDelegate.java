package com.joye.basedata.combination;

import com.joye.basedata.autoseo.ExcelReaderHelper;
import com.joye.basedata.autoseo.ExcelWriterHelper;
import com.joye.basedata.autoseo.UploadRowResourceEntity;
import com.joye.basedata.crawler4j.MyCrawler;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import rx.Observable;
import rx.Observer;
import rx.functions.Func2;

/**
 * Created by joye on 2017/4/9.
 */

public class CombinationDelegate {
    /**
     * 1、获取生成的关键字组合
     * 2、获取对象站以及老域名情况
     * 3、生成新的上站Excel
     */

    @Test
    public void testSpencer() throws Exception {
        execulte("/Users/joye/Downloads/spencer-20170408对象站 (3).xlsx","/Users/joye/Search/combination/spencer", MyCrawler.getTime());
    }

    @Test
    public void testKevin() throws Exception {
        execulte("/Users/joye/Downloads/kevin_w88_4.12.xlsx","/Users/joye/Search/combination/kevin", "kevin_w88_4.12"+MyCrawler.getTime());
    }
    @Test
    public void testBruce() throws Exception {
        execulte("/Users/joye/Downloads/梦之城10个w88 16个待组合20170412.xlsx","/Users/joye/Search/combination/bruce", MyCrawler.getTime());
    }







    /**
     * 开始执行合并
     * @param autoKeyCreateFilePath 关键字文档
     * @param newPath
     * @param newFileName
     */
    public void execulte(String autoKeyCreateFilePath,String newPath,String newFileName) throws IOException {
        List<UploadRowResourceEntity> mUploadRowResourceEntitys=getUploadRowResourceEntitys(autoKeyCreateFilePath);
        List<DomainHandleRowEntity> mDomainHandleRowEntitys=getDomainHandleRowEntitys(autoKeyCreateFilePath);
        if(mUploadRowResourceEntitys==null||mDomainHandleRowEntitys==null||mDomainHandleRowEntitys.size()!=mUploadRowResourceEntitys.size()){
            System.out.println(mUploadRowResourceEntitys.size()+":"+ mDomainHandleRowEntitys.size());
            throw new IllegalArgumentException("数量不一致");
        }
        List<UploadRowResourceEntity> combinationEntitys=new ArrayList<>();
        UploadRowResourceEntity uploadRowResourceEntity;
        DomainHandleRowEntity domainHandleRowEntity;
        for (int i = 0; i < mUploadRowResourceEntitys.size(); i++) {
            uploadRowResourceEntity=mUploadRowResourceEntitys.get(i);
            domainHandleRowEntity=mDomainHandleRowEntitys.get(i);
            //老域名
            uploadRowResourceEntity.setOldDomainStr("www."+domainHandleRowEntity.getOldDomains());
            //对象站
            uploadRowResourceEntity.setObjectDomain(domainHandleRowEntity.getCombinationDomains());
            //编码
            uploadRowResourceEntity.setChartsetStr(domainHandleRowEntity.getCharset());
            String needReplaceKeystr=uploadRowResourceEntity.getReplaceKeyStr();
            String keystr=domainHandleRowEntity.getKeys();
            if(keystr==null){
                System.out.println(i);
            }
            String[]keys=keystr.split("，");
            if(keys==null){
                System.out.println(i);
            }
            try {
                needReplaceKeystr = needReplaceKeystr.replaceFirst("\\[to\\]", keys[0] + "[to]");
                needReplaceKeystr = needReplaceKeystr.replaceFirst("\\[or\\]\\[to\\]", "\\[or\\]" + keys[1] + "\\[to\\]");
                needReplaceKeystr = needReplaceKeystr.replaceFirst("\\[or\\]\\[to\\]", "\\[or\\]" + keys[2] + "\\[to\\]");
                uploadRowResourceEntity.setReplaceKeyStr(needReplaceKeystr);
            }catch (Exception e){
                System.out.println("出错的地方"+i);
                throw new IllegalArgumentException(e);
            }
            combinationEntitys.add(uploadRowResourceEntity);
        }
        ExcelWriterHelper.WriteExtralRerouse(combinationEntitys,newPath,newFileName);


    }

    @Test
    public void testGetDomainHandleRowEntitys() throws Exception {
        getDomainHandleRowEntitys("/Users/joye/Downloads/spencer-20170408对象站.xlsx");
    }

    /**
     *
     * @param filePath
     * @return
     * @throws FileNotFoundException
     */
    private List<DomainHandleRowEntity> getDomainHandleRowEntitys(String filePath) throws FileNotFoundException {
        Workbook workBook = ExcelReaderHelper.getWorkBookByPath(filePath);
        List<DomainHandleRowEntity> allResult = new ArrayList<>();
        DomainHandleRowEntity entity;
        String cellValue="";
        Sheet sheet=workBook.getSheetAt(1);
        int i=0;
        for (Row r : sheet) {
            if(i==0){
                i++;
                continue;
            }

            entity=new DomainHandleRowEntity();
            for (Cell cell:r){
                cellValue=cell.getStringCellValue();
                if(cell.getColumnIndex()==0){
                    entity.setInitObjectDomains(cellValue);
                }else if(cell.getColumnIndex()==1){
                    entity.setQueryObjectDomains(cellValue);
                }else if(cell.getColumnIndex()==2){
                    entity.setCombinationDomains(cellValue);
                }else if(cell.getColumnIndex()==3){
                    entity.setOldDomains(cellValue);
                }else if(cell.getColumnIndex()==4){
                    entity.setCharset(cellValue);
                }else if(cell.getColumnIndex()==5){
                    entity.setTitle(cellValue);
                }else if(cell.getColumnIndex()==6){
                    entity.setKeys(cellValue);
                }else if(cell.getColumnIndex()==7){
                    entity.setDescription(cellValue);
                }
            }
            allResult.add(entity);
        }

        return allResult;

    }

    /**
     * 根据文件路径,获取自动生成
     *
     * @param filePath
     * @return
     */
    private List<UploadRowResourceEntity> getUploadRowResourceEntitys(String filePath) throws FileNotFoundException {
        Workbook workBook = ExcelReaderHelper.getWorkBookByPath(filePath);
        List<UploadRowResourceEntity> allResult = new ArrayList<>();
        UploadRowResourceEntity entity;
        String cellValue = "";
        Sheet sheet = workBook.getSheetAt(0);
        int i=0;
        for (Row r:sheet) {
            if(i==0){
                i++;
                continue;
            }

            entity = new UploadRowResourceEntity();
            for (Cell cell : r) {
                cellValue = cell.getStringCellValue();
                if (cell.getColumnIndex() == 0) {
                    entity.setTime(cellValue);
                } else if (cell.getColumnIndex() == 1) {
                    entity.setIpStr(cellValue);
                } else if (cell.getColumnIndex() == 2) {
                    entity.setOldDomainStr(cellValue);
                } else if (cell.getColumnIndex() == 3) {
                    entity.setIsOKStr(cellValue);
                } else if (cell.getColumnIndex() == 4) {
                    entity.setKey(cellValue);
                } else if (cell.getColumnIndex() == 5) {
                    entity.setTitle(cellValue);
                } else if (cell.getColumnIndex() == 6) {
                    entity.setLongEndKey(cellValue);
                } else if (cell.getColumnIndex() == 7) {
                    entity.setDescription(cellValue);
                } else if (cell.getColumnIndex() == 9) {
                    entity.setObjectDomain(cellValue);
                } else if (cell.getColumnIndex() == 10) {
                    entity.setReplaceKeyStr(cellValue);
                } else if (cell.getColumnIndex() == 11) {
                    entity.setChartsetStr(cellValue);
                }
            }
            allResult.add(entity);
        }
        return allResult;
    }

}
