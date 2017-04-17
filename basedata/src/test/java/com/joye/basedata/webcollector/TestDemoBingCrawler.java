package com.joye.basedata.webcollector;

import com.joye.basedata.autoseo.ExcelReaderHelper;
import com.joye.basedata.autoseo.UploadRowResourceEntity;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.joye.basedata.webcollector.DemoBingCrawler.regex1;

/**
 * Created by joye on 2017/4/13.
 */

public class TestDemoBingCrawler {

    @Test
    public void testUrlValidate() throws Exception {
        OldDomainInfoBean info=new OldDomainInfoBean();
        info.setOldDomainStr("www.baidu.com");
    }



    @Test
    public void testCrawler() throws Exception {



        DemoBingCrawler crawler=new DemoBingCrawler("广州学邦",1);
//        crawler.addRegex("-.*\\\\.(jpg|png|gif).*");
        crawler.addRegex("((http|https):\\/\\/)?www\\.(.*)\\.(com|cn)");
         /*不要爬取包含"#"的链接*/
        crawler.addRegex("-.*#.*");
        crawler.setTopN(5);
        crawler.start(3);

    }

}
