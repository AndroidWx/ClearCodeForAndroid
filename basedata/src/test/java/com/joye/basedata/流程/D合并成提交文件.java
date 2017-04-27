package com.joye.basedata.流程;

import com.joye.basedata.autoseo.ExcelReaderHelper;
import com.joye.basedata.autoseo.ExcelWriterHelper;
import com.joye.basedata.autoseo.UploadRowResourceEntity;
import com.joye.basedata.combination.DomainHandleRowEntity;
import com.joye.basedata.crawler4j.MyCrawler;
import com.joye.basedata.filter.ReplaceDomainEntity;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by joye on 2017/4/9.
 */

public class D合并成提交文件 {
    /**
     * 1、获取生成的关键字组合
     * 2、获取对象站以及老域名情况
     * 3、生成新的上站Excel
     */

    @Test
    public void testSpencer() throws Exception {
//        execulte("/Users/joye/Downloads/0426对象站.xlsx","/Users/joye/Search/combination/spencer/", MyCrawler.getTime());
        execulteCombineAndTypeSetting("/Users/joye/Downloads/0427对象站.xlsx","/Users/joye/Search/combination/spencer/", MyCrawler.getTime());
    }

    @Test
    public void testKevin() throws Exception {
//        execulte("/Users/joye/Downloads/kevin_wusong_伟德_4.27.xlsx","/Users/joye/Search/combination/kevin/", MyCrawler.getTime());
        execulteCombineAndTypeSetting("/Users/joye/Downloads/待组合的对象站 - kevin.xlsx","/Users/joye/Search/combination/kevin/", MyCrawler.getTime());
    }
    @Test
    public void testBruce() throws Exception {
        execulteCombineAndTypeSetting("/Users/joye/Downloads/待组合的对象站 (1).xlsx","/Users/joye/Search/combination/bruce/", MyCrawler.getTime());
    }

    @Test
    public void testLvan() throws Exception {
//        execulte("/Users/joye/Downloads/ivan-对象站 (2).xlsx","/Users/joye/Search/combination/lvan/", MyCrawler.getTime());
        execulteCombineAndTypeSetting("/Users/joye/Downloads/待组合的对象站 (1).xlsx","/Users/joye/Search/combination/bruce/", MyCrawler.getTime());
    }



    @Test
    public void testJoye() throws Exception {
//        execulte("/Users/joye/Downloads/明仕亚洲上传检查 (1).xlsx","/Users/joye/Search/combination/joye/", MyCrawler.getTime());
        execulteCombineAndTypeSetting("/Users/joye/Downloads/明仕亚洲上传检查 (1).xlsx","/Users/joye/Search/combination/joye/", MyCrawler.getTime());

    }


    /**
     * 生成批量提交文档
     * @param autoKeyCreateFilePath
     * @return
     * @throws FileNotFoundException
     */
    public List<UploadRowResourceEntity> getCombineDatas(String autoKeyCreateFilePath) throws FileNotFoundException {
        List<UploadRowResourceEntity> mUploadRowResourceEntitys=getUploadRowResourceEntitys(autoKeyCreateFilePath);
        List<DomainHandleRowEntity> mDomainHandleRowEntitys=getDomainHandleRowEntitys(autoKeyCreateFilePath);
        if(mUploadRowResourceEntitys==null||
                mDomainHandleRowEntitys==null||
                mDomainHandleRowEntitys.size()!=mUploadRowResourceEntitys.size()
                ){
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
            uploadRowResourceEntity.setOldDomainNoFrefix(domainHandleRowEntity.getOldDomains());
            //对象站
            uploadRowResourceEntity.setObjectDomain(domainHandleRowEntity.getCombinationDomains());
            //编码
            uploadRowResourceEntity.setChartsetStr(domainHandleRowEntity.getCharset());
            uploadRowResourceEntity.setDescription(uploadRowResourceEntity.getTitle()+domainHandleRowEntity.getDescription());
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
        return combinationEntitys;
    }



    public void execulteCombineAndTypeSetting(String autoKeyCreateFilePath,String newPath,String newFileName) throws IOException {

        List<String> ips=getIps(autoKeyCreateFilePath);
        List<ReplaceDomainEntity> replaceDomainEntityList=getReplaeDomainEntitys(autoKeyCreateFilePath);
        ExcelWriterHelper.writeUploadCheck(getCombineDatas(autoKeyCreateFilePath),newPath,newFileName,ips,replaceDomainEntityList);
    }



    /**
     * 开始执行合并
     * @param autoKeyCreateFilePath 关键字文档
     * @param newPath
     * @param newFileName
     */
    public void execulte(String autoKeyCreateFilePath,String newPath,String newFileName) throws IOException {
        ExcelWriterHelper.WriteExtralRerouse(getCombineDatas(autoKeyCreateFilePath),newPath,newFileName);
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

    public static List<ReplaceDomainEntity> getReplaeDomainEntitys(String filePath) throws FileNotFoundException {
        Workbook workBook = ExcelReaderHelper.getWorkBookByPath(filePath);
        List<ReplaceDomainEntity> allResult = new ArrayList<>();
        ReplaceDomainEntity entity;
        String cellValue = "";
        Sheet sheet = workBook.getSheetAt(3);
        int i=0;
        for (Row r:sheet) {
            if(i==0){
                i++;
                continue;
            }
            entity=new ReplaceDomainEntity();
            for (Cell cell : r) {
                cellValue = cell.getStringCellValue();
                if (cell.getColumnIndex() == 0) {
                    entity.setDomain(cellValue);
                }else if (cell.getColumnIndex() == 1) {
                    entity.setKeystr(cellValue);
                }else if(cell.getColumnIndex()==2){
                    entity.setCharsert(cellValue);
                }
            }
            allResult.add(entity);
        }
        return allResult;
    }

    public static List<String> getIps(String filePath) throws FileNotFoundException {
        Workbook workBook = ExcelReaderHelper.getWorkBookByPath(filePath);
        List<String> allResult = new ArrayList<>();
        UploadRowResourceEntity entity;
        String cellValue = "";
        Sheet sheet = workBook.getSheetAt(2);
        for (Row r:sheet) {
            for (Cell cell : r) {
                cellValue = cell.getStringCellValue();
                if (cell.getColumnIndex() == 0) {
                    allResult.add(cellValue);
                }
            }
        }
        return allResult;
    }
    /**
     * 根据文件路径,获取自动生成
     *
     * @param filePath
     * @return
     */
    public static List<UploadRowResourceEntity> getUploadRowResourceEntitys(String filePath) throws FileNotFoundException {
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
