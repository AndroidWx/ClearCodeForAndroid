package com.joye.basedata.流程;

import com.joye.basedata.autoseo.ExcelReaderHelper;
import com.joye.basedata.autoseo.ExcelWriterHelper;
import com.joye.basedata.autoseo.UploadRowResourceEntity;
import com.joye.basedata.combination.DomainHandleRowEntity;
import com.joye.basedata.crawler4j.MyCrawler;
import com.joye.basedata.filter.ReplaceDomainEntity;

import org.apache.commons.lang.StringUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
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
        execulteCombineAndTypeSetting("/Users/joye/Downloads/0508对象站.xlsx","/Users/joye/Search/combination/spencer/", MyCrawler.getTime());
    }

    @Test
    public void testKevin() throws Exception {
//        execulte("/Users/joye/Downloads/kevin_wusong_伟德_4.27.xlsx","/Users/joye/Search/combination/kevin/", MyCrawler.getTime());
        execulteCombineAndTypeSetting("/Users/joye/Downloads/待组合的对象站 (1).xlsx","/Users/joye/Search/combination/kevin/", MyCrawler.getTime());
    }
    @Test
    public void testBruce() throws Exception {
        execulteCombineAndTypeSetting("/Users/joye/Downloads/待组合的对象站 (1).xlsx","/Users/joye/Search/combination/bruce/", MyCrawler.getTime());
    }

    @Test
    public void testLvan() throws Exception {
//        execulte("/Users/joye/Downloads/ivan-对象站 (2).xlsx","/Users/joye/Search/combination/lvan/", MyCrawler.getTime());
        execulteCombineAndTypeSetting("/Users/joye/Downloads/0508对象站  -2.xlsx","/Users/joye/Search/combination/lvan/", MyCrawler.getTime());
    }



    @Test
    public void testJoye() throws Exception {
//        execulte("/Users/joye/Downloads/明仕亚洲上传检查 (1).xlsx","/Users/joye/Search/combination/joye/", MyCrawler.getTime());
        execulteCombineAndTypeSetting("/Users/joye/Downloads/待组合的对象站 - kevin (2).xlsx","/Users/joye/Search/combination/joye/", MyCrawler.getTime());

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

            /**
             *  把描述里面加入关键字
             *  1.分割以前的描述
             */
            String[] keystrArray = new String[6];
            String keystr_or_to = uploadRowResourceEntity.getReplaceKeyStr();
            int indexTo = keystr_or_to.indexOf("[to]");
            int indexOr = keystr_or_to.indexOf("[or]");
            keystrArray[0] = keystr_or_to.substring(indexTo+4, indexOr);
            keystr_or_to=keystr_or_to.substring(keystr_or_to.indexOf("[or]")+4,keystr_or_to.length());
            keystrArray[1] = keystr_or_to.substring(keystr_or_to.indexOf("[to]")+4, keystr_or_to.indexOf("[or]"));
            keystrArray[2] = keystr_or_to.substring(keystr_or_to.lastIndexOf("[to]")+4);
            keystrArray[3]=keystrArray[0];
            keystrArray[4]=keystrArray[1];
            keystrArray[5]=keystrArray[2];
            String description=domainHandleRowEntity.getDescription();
            String[]array_small=description.split(",");
            String[]array_big=description.split("，");

            //如果按，分割
            if(array_big.length>array_small.length){
                description=description.replaceAll(",","，");
                for (int j = 1; j <array_big.length ; j++) {

                    if(j==6){
                        break;
                    }
                    description=description.replace(array_big[j],keystrArray[j]+array_big[j]);
                }
            }else  {
                description=description.replaceAll("，",",");
                for (int j = 1; j <array_small.length ; j++) {

                    if(j==6){
                        break;
                    }
                    description=description.replace(array_small[j],keystrArray[j]+array_small[j]);
                }
            }


            /**
             *
             */
            uploadRowResourceEntity.setDescription(uploadRowResourceEntity.getTitle()+description);
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
                //头部加个链接
                needReplaceKeystr=  needReplaceKeystr+"[or]</head>[to]" +
                        //加入手机适配以及Google
                        "<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge,chrome=1\"/>" +
                        "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1, user-scalable=no\">"+
                        //加入关键字
                        "</head><h1><a href='http://www."+domainHandleRowEntity.getOldDomains()+"'>"+keystrArray[0]+"</a></h1>";
                //引入上面和下面
                needReplaceKeystr= needReplaceKeystr
                        +"[or]</body>[to]" +
                        //加入第一个外链
                        "<a href='http://www."+domainHandleRowEntity.getOtherOldDomains()+"' target=\"_blank\"><strong>"+domainHandleRowEntity.getOtherOldTitle()+"</strong>" +
                        "</a>" +
                        //加入第二个外链
                        "<a href='http://www."+domainHandleRowEntity.getElseOldDomains()+"' target=\"_blank\"><strong>"+domainHandleRowEntity.getElseOldTitle()+"</strong>" +
                        "</a>" +
                        //加入表格
                        "<table style='width:100%;border-collapse:collapse;text-align:center;' border='1'>" +
                            "<tr>" +
                                "<td><u>"+keystrArray[0]+"</u></td>" +
                                "<td><u>"+domainHandleRowEntity.getOtherOldTitle()+"</u></td>" +
                                "<td><u>"+domainHandleRowEntity.getElseOldTitle()+"</u></td>" +
                                "<td><a href='http://"+domainHandleRowEntity.getE1Domains()+"' target=\"_blank\"><strong>"+domainHandleRowEntity.getE1Title()+"<strong></a></td>" +
                            "</<tr>" +
                            "<tr>" +
                                "<td><a href='http://"+domainHandleRowEntity.getE2Domains()+"' target=\"_blank\"><strong>"+domainHandleRowEntity.getE2Title()+"<strong></a></td>" +
                                "<td><a href='http://"+domainHandleRowEntity.getE3Domains()+"' target=\"_blank\"><strong>"+domainHandleRowEntity.getE3Title()+"<strong></a></td>" +
                                "<td><a href='http://"+domainHandleRowEntity.getE4Domains()+"' target=\"_blank\"><strong>"+domainHandleRowEntity.getE4Title()+"<strong></a></td>" +
                                "<td><a href='http://"+domainHandleRowEntity.getE5Domains()+"' target=\"_blank\"><strong>"+domainHandleRowEntity.getE5Title()+"<strong></a></td>" +
                            "</<tr>" +
                            "<tr>" +
                                "<td><a href='http://"+domainHandleRowEntity.getE6Domains()+"' target=\"_blank\"><strong>"+domainHandleRowEntity.getE2Title()+"<strong></a></td>" +
                                "<td><u>"+domainHandleRowEntity.getOtherOldTitle()+"</u></td>" +
                                "<td><u>"+domainHandleRowEntity.getElseOldTitle()+"</u></td>" +
                                "<td><u>"+domainHandleRowEntity.getE6Title()+"</u></td>" +
                            "</<tr>" +
                            "<tr>" +
                                "<td><u>"+keystrArray[0]+"</u></td>" +
                                "<td><u>"+keystrArray[1]+"</u></td>" +
                                "<td><u>"+keystrArray[2]+"</u></td>" +
                                "<td><u>"+domainHandleRowEntity.getE1Title()+"</u></td>" +
                            "</<tr>" +
                            "<tr>" +
                                "<td><u>"+domainHandleRowEntity.getE2Title()+"</u></td>" +
                                "<td><u>"+domainHandleRowEntity.getE3Title()+"</u></td>" +
                                "<td><u>"+domainHandleRowEntity.getE4Title()+"</u></td>" +
                                "<td><u>"+domainHandleRowEntity.getE5Title()+"</u></td>" +
                            "</<tr>" +
                        "</table>" +
                    "</body>";
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
            entity.setRow(r);
            allResult.add(entity);
        }

        return allResult;

    }

    /**
     * 获取要替换的对象站
     * @param filePath
     * @return
     * @throws FileNotFoundException
     */
    public static List<ReplaceDomainEntity> getReplaeDomainEntitys(String filePath) throws FileNotFoundException {
        Workbook workBook = ExcelReaderHelper.getWorkBookByPath(filePath);
        List<ReplaceDomainEntity> allResult = new ArrayList<>();
        ReplaceDomainEntity entity;
        Sheet sheet = workBook.getSheetAt(3);
        int i=0;
        for (Row r:sheet) {
            if(i==0){
                i++;
                continue;
            }
            entity=new ReplaceDomainEntity();
            entity.setRow(r);
            allResult.add(entity);
        }
        return allResult;
    }

    /**
     * 获取服务器ips
     * @param filePath
     * @return
     * @throws FileNotFoundException
     */
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
