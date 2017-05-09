package com.joye.basedata.autoseo;

import com.joye.basedata.utils.AntorUtils;

import org.apache.poi.ss.usermodel.Workbook;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by joye on 2017/4/4.
 */

public class ExtralResourceWriteDelegate {


    /**
     * 根据关键字搜索次数组合，自动生成外部资源
     * @param path 搜索次数排名Excel
     * @param excelWritePath 写入Excel地址
     * @param fileName 文件名
     * @throws Exception
     */
    public static void handleKeysExcel(String path, String excelWritePath, String fileName) throws Exception {
        //获取所有组合title
        List<String> results= HandleKey.getAllTitleResultByKeys(getAllKeysByFilePath(path));
        List<UploadRowResourceEntity> resources=completeDatas(results,null);
        ExcelWriterHelper.WriteExtralRerouse(resources,excelWritePath,fileName);
    }


    /**
     * 根据域关键词和搜索次数出来的关键字组合，自动生成外部资源
     * long8520龙8娱乐官网_long8520龙8娱乐官网下载_long8520龙8娱乐老虎机
     * @param path 搜索次数排名的关键词
     * @param path1 域词语关键词
     * @param excelWritePath 写入Excel地址
     * @param fileName 文件名
     */
    public static void handleDomainKeys(String path,String path1,String excelWritePath, String fileName) throws IOException {
        //获取所有关键字
        List<String> allKeys=getAllKeysByFilePath(path);
        //获取所有域词
        List<String> allDomainKeys=getAllKeysByFilePath(path1);

        List<String> results=HandleKey.getAllTitleResultByDomainKeys(allKeys,allDomainKeys);
        List<UploadRowResourceEntity> resources=completeDatas(results,null);
        ExcelWriterHelper.WriteExtralRerouse(resources,excelWritePath,fileName);
    }

    /**
     * 根据域关键词和搜索次数出来的关键字组合，自动生成外部资源
     * long8520龙8娱乐官网_long8520龙8娱乐官网下载_long8520龙8娱乐老虎机
     * @param path 搜索次数排名的关键词
     * @param excelWritePath 写入Excel地址
     * @param fileName 文件名
     */
    public static void handleDomainKeys(int index,String path,String excelWritePath, String fileName) throws IOException {
        //获取所有关键字
        List<String> allKeys=getAllKeysByFilePath(path);
        //获取所有域词
        List<String> allDomainKeys=getAllKeysByFilePath(path,index);

        List<String> results=HandleKey.getAllTitleResultByDomainKeys(allKeys,allDomainKeys);
        List<UploadRowResourceEntity> resources=completeDatas(results,null);
        ExcelWriterHelper.WriteExtralRerouse(resources,excelWritePath,fileName);
    }


    /**
     * 根据域关键词和搜索次数出来的关键字组合，自动生成外部资源
     * qy8千亿国际+www.qy8.com+随便填写
     * @param path 搜索次数排名的关键词
     * @param path1 域词语关键词
     * @param excelWritePath 写入Excel地址
     * @param fileName 文件名
     */
    public static void handleWWWDomainKeys(String path,String path1,String excelWritePath, String fileName) throws IOException {
        //获取所有关键字
        List<String> allKeys=getAllKeysByFilePath(path);
        //获取所有域词
        List<String> allDomainKeys=getAllKeysByFilePath(path1);
        //获取所有title qy8千亿国际+www.qy8.com+随便填写
        List<String> results=HandleKey.getAllDomainTitles(allKeys,allDomainKeys);
        List<UploadRowResourceEntity> resources=completeDatas(results,null);
        ExcelWriterHelper.WriteExtralRerouse(resources,excelWritePath,fileName);
    }

    /**
     * 根据域关键词和搜索次数出来的关键字组合，自动生成外部资源
     * qy8千亿国际+www.qy8.com+随便填写
     * @param path 搜索次数排名的关键词
     * @param excelWritePath 写入Excel地址
     * @param fileName 文件名
     */
    public static void handleWWWDomainKeys(int index,String path,String excelWritePath, String fileName) throws IOException {
        //获取所有关键字
        List<String> allKeys=getAllKeysByFilePath(path);
        //获取所有域词
        List<String> allDomainKeys=getAllKeysByFilePath(path,index);
        //获取所有title qy8千亿国际+www.qy8.com+随便填写
        List<String> results=HandleKey.getAllDomainTitles(allKeys,allDomainKeys);
        List<UploadRowResourceEntity> resources=completeDatas(results,null);
        ExcelWriterHelper.WriteExtralRerouse(resources,excelWritePath,fileName);
    }



    /**
     * 根据域关键词和搜索次数出来的关键字组合，自动生成外部资源
     * 千亿国际+www.qy8.com+随便填写
     * @param path 搜索次数排名的关键词
     * @param path1 域词语关键词
     * @param excelWritePath 写入Excel地址
     * @param fileName 文件名
     */
    public static void handleWWWDomainKeysOnlyKeys(String path,String path1,String excelWritePath, String fileName) throws IOException {
        //获取所有关键字
        List<String> allKeys=getAllKeysByFilePath(path);
        //获取所有域词
        List<String> allDomainKeys=getAllKeysByFilePath(path1);
        //获取所有title qy8千亿国际+www.qy8.com+随便填写
        List<String> results=HandleKey.getAllDomainTitlesByKeys(allKeys,allDomainKeys);
        List<UploadRowResourceEntity> resources=completeDatas(results,null);
        ExcelWriterHelper.WriteExtralRerouse(resources,excelWritePath,fileName);
    }

    /**
     * 根据域关键词和搜索次数出来的关键字组合，自动生成外部资源
     * 千亿国际+www.qy8.com+随便填写
     * @param path 搜索次数排名的关键词
     * @param excelWritePath 写入Excel地址
     * @param fileName 文件名
     */
    public static void handleWWWDomainKeysOnlyKeys(int index,String path,String excelWritePath, String fileName) throws IOException {
        //获取所有关键字
        List<String> allKeys=getAllKeysByFilePath(path);
        //获取所有域词
        List<String> allDomainKeys=getAllKeysByFilePath(path,index);
        //获取所有title qy8千亿国际+www.qy8.com+随便填写
        List<String> results=HandleKey.getAllDomainTitlesByKeys(allKeys,allDomainKeys);
        List<UploadRowResourceEntity> resources=completeDatas(results,null);
        ExcelWriterHelper.WriteExtralRerouse(resources,excelWritePath,fileName);
    }


    /**
     * 根据域关键词和搜索次数出来的关键字组合，自动生成外部资源
     * @param path 搜索次数排名的关键词
     * @param path1 域词语关键词
     * @param excelWritePath 写入Excel地址
     * @param fileName 文件名
     */
    public static void handleKeysExcel(String path,String path1,String excelWritePath, String fileName) throws IOException {
        //获取所有关键字
        List<String> allKeys=getAllKeysByFilePath(path);
        //获取所有域词
        List<String> allDomainKeys=getAllKeysByFilePath(path1);
        //所有新的关键字
        List<String> allNewAllKeys=new ArrayList<>();
        for (int i = 0; i < allKeys.size(); i++) {
            //所有域词
            for (int j = 0; j < allDomainKeys.size(); j++) {
                //关键字
                String keys = allKeys.get(i);
                if(!AntorUtils.isContainChinese(keys.substring(0,1))) {
                    while (!AntorUtils.isContainChinese(keys.substring(0, 1))) {
                        keys = keys.substring(1, keys.length());
                    }
                }

                allNewAllKeys.add(allDomainKeys.get(j)+keys);
            }
        }

        List<String> results=HandleKey.getAllTitleResultByKeys(allNewAllKeys);
        List<UploadRowResourceEntity> resources=completeDatas(results,null);
        ExcelWriterHelper.WriteExtralRerouse(resources,excelWritePath,fileName);
    }


    /**
     * 根据域关键词和搜索次数出来的关键字组合，自动生成外部资源
     * @param path 搜索次数排名的关键词
     * @param excelWritePath 写入Excel地址
     * @param fileName 文件名
     */
    public static void handleKeysExcel(int index,String path,String excelWritePath, String fileName) throws IOException {
        //获取所有关键字
        List<String> allKeys=getAllKeysByFilePath(path);
        //获取所有域词
        List<String> allDomainKeys=getAllKeysByFilePath(path,1);
        //所有新的关键字
        List<String> allNewAllKeys=new ArrayList<>();
        for (int i = 0; i < allKeys.size(); i++) {
            //所有域词
            for (int j = 0; j < allDomainKeys.size(); j++) {
                //关键字
                String keys = allKeys.get(i);
                if(!AntorUtils.isContainChinese(keys.substring(0,1))) {
                    while (!AntorUtils.isContainChinese(keys.substring(0, 1))) {
                        keys = keys.substring(1, keys.length());
                    }
                }

                allNewAllKeys.add(allDomainKeys.get(j)+keys);
            }
        }

        List<String> results=HandleKey.getAllTitleResultByKeys(allNewAllKeys);
        List<UploadRowResourceEntity> resources=completeDatas(results,null);
        ExcelWriterHelper.WriteExtralRerouse(resources,excelWritePath,fileName);
    }



    /**
     * 获取所有关键字集合
     * @param path 文件路径
     * @return
     * @throws FileNotFoundException
     */
    public static List<String> getAllKeysByFilePath(String path) throws FileNotFoundException {
       return getAllKeysByFilePath(path,0);
    }

    /**
     * 获取所有关键字集合
     * @param path 文件路径
     * @return
     * @throws FileNotFoundException
     */
    public static List<String> getAllKeysByFilePath(String path,int index) throws FileNotFoundException {
        //获取关键字挖掘Excel
        Workbook workbook= ExcelReaderHelper.getWorkBookByPath(path);
        //获取所有关键字
        List<String> allKeys= ExcelReaderHelper.getAllCellsByRowsIndex(index,workbook);
        return allKeys;
    }

    /**
     * 装配数据
     * @return
     */
    private static List<UploadRowResourceEntity> completeDatas(List<String>  allTitles, List<String>description){
        List<UploadRowResourceEntity> result=new ArrayList<>();
        UploadRowResourceEntity rowData;
        String ip="192.151.213.";
        String key="";
        String str_Index_0="";
        String s="";
        for (int i = 0; i < allTitles.size(); i++) {
            rowData=new UploadRowResourceEntity();
            rowData.setIpStr(ip+(100+i));

            s = allTitles.get(i);
            str_Index_0= s.substring(0, s.indexOf("_"));
            rowData.setKey(str_Index_0);
            rowData.setTitle(s);
//            rowData.setDescription(s+description.get(i));
            s=s.replaceAll("_","[or][to]");
            s="[to]"+s;
            rowData.setReplaceKeyStr(s);

            result.add(rowData);
        }
        return result;
    }

}
