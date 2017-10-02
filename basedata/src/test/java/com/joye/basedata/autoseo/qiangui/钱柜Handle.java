package com.joye.basedata.autoseo.qiangui;

import com.joye.basedata.autoseo.ExtralResourceWriteDelegate;
import com.joye.basedata.autoseo.UploadRowResourceEntity;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.Validate;
import org.junit.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static com.joye.basedata.流程.D合并成提交文件.getUploadRowResourceEntitys;

/**
 * Created by joye on 2017/4/4.
 */

public class 钱柜Handle {

    @Test
    public void testHandleKeysExcel()  {
        try {
            /**
             * 关键字生成
             * AAA:钱柜
             * AAA+AAAB+Random
             * 龙8娱乐_龙8娱乐客户端城_龙8娱乐手机下载
             */
            ExtralResourceWriteDelegate.handleKeysExcelByName("/Users/joye/search/word/tiger/腾博会.xlsx","/Users/joye/search/word/tiger/create","1.腾博会2","腾博会官网");
            /**
             * 域名词+关键字生成
             * long8520龙8娱乐娱乐_long8520龙8娱乐娱乐下载_long8520龙8娱乐娱乐
             */
//            ExtralResourceWriteDelegate.handleDomainKeys("/Users/joye/search/word/钱柜/钱柜关键词.xlsx","/Users/joye/search/word/钱柜/钱柜域词.xlsx","/Users/joye/search/word/钱柜/create","~~~4.钱柜关键词域加关键字组合");
            /**
             * 域名加关键字 组合成关键字
             * long8877龙8娱乐娱乐_龙8娱乐娱乐_龙8娱乐娱乐
             */
//            ExtralResourceWriteDelegate.handleKeysExcel("/Users/joye/search/word/钱柜/钱柜关键词.xlsx","/Users/joye/search/word/钱柜/钱柜域词.xlsx","/Users/joye/search/word/钱柜/create","~~~3.钱柜关键词域加关键字作为组合");
            /**
             * 域名词+关键字生成
             * long8.cc龙8娱乐备用网址_www.long8.cc.com_龙8娱乐娱乐手机版
             */
//            ExtralResourceWriteDelegate.handleWWWDomainKeys("/Users/joye/search/word/钱柜/钱柜关键词.xlsx","/Users/joye/search/word/钱柜/钱柜域词.xlsx","/Users/joye/search/word/钱柜/create","~~~5.钱柜关键词域关键词+www域组合");


            /**
             * 域名词+关键字生成
             * 龙8娱乐备用网址_www.long8.cc.com_龙8娱乐娱乐手机版
             */
//            ExtralResourceWriteDelegate.handleWWWDomainKeysOnlyKeys("/Users/joye/search/word/钱柜/钱柜关键词.xlsx","/Users/joye/search/word/钱柜/钱柜域词.xlsx","/Users/joye/search/word/钱柜/create","~~~2.钱柜关键词关键词+www域组合");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Test
    public void testABC() throws Exception {
        String lines="";
        String autoKeyCreateFilePath="/Users/joye/Search/word/tiger/create/1.腾博会.xlsx";
        List<UploadRowResourceEntity> mUploadRowResourceEntitys=getUploadRowResourceEntitys(autoKeyCreateFilePath);
        for (int i = 0; i < mUploadRowResourceEntitys.size(); i++) {
            String[]array=mUploadRowResourceEntitys.get(i).getTitle().split("_");
            Set<String> set = new HashSet<>();
            for(int j=0;j<array.length;j++){
                set.add(array[j]);
            }
            if(set.size()!=3){
                lines+=(i+2)+",";
            }
        }

        if(!StringUtils.isBlank(lines)){
            Validate.isTrue(false,(lines+"行标题关键字重复"));
        }

    }
}
