package com.joye.basedata.domainhandle;

import com.joye.basedata.autoseo.ExcelReaderHelper;
import com.joye.basedata.autoseo.ExtralResourceWriteDelegate;
import com.joye.basedata.majestic_.api.MajetsicApiRestImpl;
import com.joye.basedata.majestic_.entity.AnchorTextEntity;
import com.joye.basedata.majestic_.entity.MajetsicCommResponse;
import com.joye.basedata.utils.AntorUtils;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import rx.Observable;
import rx.Observer;
import rx.schedulers.Schedulers;

import static com.joye.basedata.ExcelUtils.CreateCellStyle;
import static com.joye.basedata.ExcelUtils.EXCEL_TYPE_XLSX;
import static com.joye.basedata.ExcelUtils.createWorkBook;

/**
 * Created by joye on 2017/4/5.
 */

public class DomainDelegate {

    @Test
    public void testMajetsicApi() throws Exception {


    }

    /**
     * 根据老域名，获取老域名快照， 并把信息写入Excel里面
     *
     * @throws Exception
     */
    @Test
    public void testUrlArchive() throws Exception {
        List<ArchiveResponse> ArchiveResponses = new ArrayList<>();
        List<ArchiveResponse> MajetsicList = new ArrayList<>();
        List<MajetsicCommResponse<AnchorTextEntity>> AnchorTextEntityLists = new ArrayList<>();
        List<String> urls = ExtralResourceWriteDelegate.getAllKeysByFilePath("/Users/joye/Search/a/域名-未用-4-10.xlsx");
        System.out.println(urls.size());
        boolean archiveBoolean = true;
        Lock lock = new ReentrantLock();
        try {
            lock.lock();
            while (archiveBoolean) {
                for (int i = 0; i < urls.size(); i++) {
                    int finalI = i;
                    new ArchiveNetApiImpl().getArchive(urls.get(i), "").subscribe(new Observer<ArchiveResponse>() {
                        @Override
                        public void onCompleted() {
                            System.out.println("onCompleted");
                        }

                        @Override
                        public void onError(Throwable e) {
                            if (e instanceof java.net.SocketTimeoutException) {
                                System.out.println(urls.get(finalI) + "超时");
                                ArchiveResponse reponse = new ArchiveResponse();
                                reponse.setOldDomainStr(urls.get(finalI));
                                MajetsicList.add(reponse);
                            } else {
                                e.printStackTrace();
                            }

                        }

                        @Override
                        public void onNext(ArchiveResponse archiveResponse) {
//                    System.out.println(archiveResponse.toString());
                            archiveResponse.setOldDomainStr(urls.get(finalI));
                            if (archiveResponse.getArchived_snapshots() == null) {
                                MajetsicList.add(archiveResponse);
                            } else {
                                if (archiveResponse.getArchived_snapshots().getClosest() != null && archiveResponse.getArchived_snapshots().getClosest().isAvailable()) {
                                    ArchiveResponses.add(archiveResponse);
                                } else {
                                    MajetsicList.add(archiveResponse);
                                }
                            }
                        }
                    });
                    if (finalI == urls.size() - 1) {
                        archiveBoolean = false;
                    }
                }
            }
        } finally {
            lock.unlock();
        }
        System.out.println(ArchiveResponses.size());
        DomainWriteExcel.WriteDomainArchive(ArchiveResponses, "/Users/joye/downloads/", "老域名处理结果_archive");

        System.out.println("开始处理 Anchor");
        Lock lockAnchor = new ReentrantLock();
        try {
            lockAnchor.lock();
            while (AnchorTextEntityLists.size() < MajetsicList.size()) {
                for (int i = 0; i < MajetsicList.size(); i++) {
                    int finalI = i;
                    new MajetsicApiRestImpl().GetAnchorText(MajetsicList.get(i).getOldDomainStr(), "1", "0", "", "", "", "", "").subscribe(new Observer<MajetsicCommResponse<AnchorTextEntity>>() {
                        @Override
                        public void onCompleted() {

                        }

                        @Override
                        public void onError(Throwable e) {
                            e.printStackTrace();
                        }

                        @Override
                        public void onNext(MajetsicCommResponse<AnchorTextEntity> anchorTextEntityMajetsicCommResponse) {
                            anchorTextEntityMajetsicCommResponse.getDataTables().setOldDomainStr(MajetsicList.get(finalI).getOldDomainStr());
                            AnchorTextEntityLists.add(anchorTextEntityMajetsicCommResponse);
                        }
                    });
                }
            }
        } finally {
            lockAnchor.unlock();
        }
        System.out.println(AnchorTextEntityLists.size());

        List<AnchorTextEntity> list = new ArrayList<>();
        for (int i = 0; i < AnchorTextEntityLists.size(); i++) {
            AnchorTextEntity item = AnchorTextEntityLists.get(i).getDataTables();
            list.add(item);
        }
        DomainWriteExcel.WriteDomainMajestic(list, "/Users/joye/downloads/", "老域名处理结果_Majestic");
    }


    @Test
    public void testGetMajesticInfo() throws Exception {
        getMajesticInfo(0, "/Users/joye/Search/域名处理/2017-4-20/ivan-域名.xlsx", "/Users/joye/Search/域名处理/2017-4-20/", "处理域名排版结果");
    }

    @Test
    public void testGetMajesticInfoAsync() throws Exception {
        getMajesticInfoAsync(0, "/Users/joye/Search/域名处理/2017-4-20/ivan-域名.xlsx", "/Users/joye/Search/域名处理/2017-4-20/", "处理域名排版结果");

    }

    /**
     * 根据老域名列表，获取老域名所有的处理结果
     *
     * @param filePath  文件路劲
     * @param writePath 写入位置
     * @param fileName  文件名
     * @throws IOException
     */
    public static void getMajesticInfo(int index, String filePath, String writePath, String fileName) throws IOException {
        List<MajetsicCommResponse<AnchorTextEntity>> AnchorTextEntityLists = new ArrayList<>();
        List<String> urls = ExtralResourceWriteDelegate.getAllKeysByFilePath(filePath, index);
        Lock lockAnchor = new ReentrantLock();
        try {
            lockAnchor.lock();
            while (AnchorTextEntityLists.size() < urls.size()) {
                for (int i = 0; i < urls.size(); i++) {
                    int finalI = i;
                    new MajetsicApiRestImpl().GetAnchorText(urls.get(i), "1", "0", "", "", "", "", "").subscribe(new Observer<MajetsicCommResponse<AnchorTextEntity>>() {
                        @Override
                        public void onCompleted() {

                        }

                        @Override
                        public void onError(Throwable e) {
                            e.printStackTrace();
                        }

                        @Override
                        public void onNext(MajetsicCommResponse<AnchorTextEntity> anchorTextEntityMajetsicCommResponse) {
                            anchorTextEntityMajetsicCommResponse.getDataTables().setOldDomainStr(urls.get(finalI));
                            AnchorTextEntityLists.add(anchorTextEntityMajetsicCommResponse);
                        }
                    });
                }
            }
        } finally {
            lockAnchor.unlock();
        }
        System.out.println(AnchorTextEntityLists.size());

        List<AnchorTextEntity> list = new ArrayList<>();
        for (int i = 0; i < AnchorTextEntityLists.size(); i++) {
            AnchorTextEntity item = AnchorTextEntityLists.get(i).getDataTables();
            list.add(item);
        }
        DomainWriteExcel.WriteDomainMajestic(list, writePath, fileName);
    }


    /**
     * 根据老域名列表，获取老域名所有的处理结果
     *
     * @param filePath  文件路劲
     * @param writePath 写入位置
     * @param fileName  文件名
     * @throws IOException
     */
    public static void getMajesticInfoAsync(int index, String filePath, String writePath, String fileName) throws IOException {
        List<MajetsicCommResponse<AnchorTextEntity>> AnchorTextEntityLists = new ArrayList<>();
        List<String> urls = ExtralResourceWriteDelegate.getAllKeysByFilePath(filePath, index);
        Lock lockAnchor = new ReentrantLock();
        try {
            lockAnchor.lock();
            while (AnchorTextEntityLists.size() < urls.size()) {
                int finalI = 0;
                if(finalI>=urls.size()){
                    break;
                }
                for (int i = 0; i < urls.size(); i++) {
                    new MajetsicApiRestImpl().GetAnchorText(urls.get(i), "1", "0", "", "", "", "", "")
                            .subscribeOn(Schedulers.io()).subscribe(new Observer<MajetsicCommResponse<AnchorTextEntity>>() {
                        @Override
                        public void onCompleted() {

                        }

                        @Override
                        public void onError(Throwable e) {
                            e.printStackTrace();
                        }

                        @Override
                        public void onNext(MajetsicCommResponse<AnchorTextEntity> anchorTextEntityMajetsicCommResponse) {
                            anchorTextEntityMajetsicCommResponse.getDataTables().setOldDomainStr(urls.get(finalI));
                            AnchorTextEntityLists.add(anchorTextEntityMajetsicCommResponse);
                        }
                    });
                }
            }
        } finally {
            lockAnchor.unlock();
        }
        System.out.println(AnchorTextEntityLists.size());

        List<AnchorTextEntity> list = new ArrayList<>();
        for (int i = 0; i < AnchorTextEntityLists.size(); i++) {
            AnchorTextEntity item = AnchorTextEntityLists.get(i).getDataTables();
            list.add(item);
        }
        DomainWriteExcel.WriteDomainMajestic(list, writePath, fileName);
    }

    @Test
    public void testAllUrls() throws Exception {
        List<String> urls = null;
        try {
            urls = ExtralResourceWriteDelegate.getAllKeysByFilePath("/Users/joye/downloads/域名-未用.xlsx");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(urls.size());
        queryDomainArchive(urls);

    }
    /**
     * 1.读取所有的老域名
     * 2.调用archiveApi获取老域名信息
     * 3.写入老域名档案
     */

    /**
     * 获取所有老域名档案
     *
     * @param urls 老域名集合
     */
    public static void queryDomainArchive(List<String> urls) {
        Observable.from(urls).subscribeOn(Schedulers.io()).observeOn(Schedulers.io()).subscribe(new Observer<String>() {
            private List<ArchiveResponse> mArchiveResponses = new ArrayList<ArchiveResponse>();


            @Override
            public void onCompleted() {
                System.out.println(mArchiveResponses.size());
            }

            @Override
            public void onError(Throwable e) {
                System.out.println(e);
            }

            @Override
            public void onNext(String s) {
                new ArchiveNetApiImpl().getArchive(s, "").subscribeOn(Schedulers.io()).observeOn(Schedulers.io()).subscribe(new Observer<ArchiveResponse>() {
                    @Override
                    public void onCompleted() {
                        System.out.println(s + " -  complete");
                    }

                    @Override
                    public void onError(Throwable e) {
                        System.out.println(e);
                    }

                    @Override
                    public void onNext(ArchiveResponse archiveResponse) {
                        mArchiveResponses.add(archiveResponse);
                    }
                });
            }
        });

    }

    @Test
    public void testABC123() throws Exception {
//        for (int i = 0; i < TITLE.length; i++) {
//            System.out.println("else if(cell.getColumnIndex() == "+i+") {");
//            System.out.println("entity.setm"+TITLE[i]+"(cellValue);");
//            System.out.println("}");
//        }
//row.createCell(0).setCellValue(allResult.get(j).getDomain());
        for (int i = 0; i < TITLE.length; i++) {
            System.out.println("row.createCell("+i+").setCellValue(allResult.get(j).getm"+TITLE[i]+"());");
        }
    }

    public static final String []TITLE=new String[]{"Item"	,"锚文本",	"ExternalBacklinks",	"ExternalBacklinksEDU",
            "ExternalBacklinksGOV",	"ReferringDomains",
            "ReferringDomainsEDU",
            "ReferringDomainsGOV"
            ,"IPAddresses",	"ClassCSubnets",
            "TrustFlow",
            "CitationFlow",
            "TopicalTrustFlowTopic0"
            ,"TopicalTrustFlowValue0",
            "TopicalTrustFlowTopic1",
            "TopicalTrustFlowValue1",
            "TopicalTrustFlowTopic2"
            ,"TopicalTrustFlowValue2"
            ,"TopicalTrustFlowTopic3"
            ,"TopicalTrustFlowValue3"
            ,"TopicalTrustFlowTopic4"
            ,"TopicalTrustFlowValue4"
            ,"TopicalTrustFlowTopic5"
            ,"TopicalTrustFlowValue5"
            ,"TopicalTrustFlowTopic6"
            ,"TopicalTrustFlowValue6"
            ,"TopicalTrustFlowTopic7"
            ,"TopicalTrustFlowValue7"
            ,"TopicalTrustFlowTopic8"
            ,"TopicalTrustFlowValue8"
            ,"TopicalTrustFlowTopic9"
            ,"TopicalTrustFlowValue9"};
    public static class Item {
        private String domain;
        private String antor;
        private String mExternalBacklinks;
        private String mExternalBacklinksEDU;
        private String mExternalBacklinksGOV;
        private String mReferringDomains;
        private String mReferringDomainsEDU;
        private String mReferringDomainsGOV;
        private String mIPAddresses;
        private String mClassCSubnets;
        private String mTrustFlow;
        private String mCitationFlow;
        private String mTopicalTrustFlowTopic0;
        private String mTopicalTrustFlowValue0;
        private String mTopicalTrustFlowTopic1;
        private String mTopicalTrustFlowValue1;
        private String mTopicalTrustFlowTopic2;
        private String mTopicalTrustFlowValue2;
        private String mTopicalTrustFlowTopic3;
        private String mTopicalTrustFlowValue3;
        private String mTopicalTrustFlowTopic4;
        private String mTopicalTrustFlowValue4;
        private String mTopicalTrustFlowTopic5;
        private String mTopicalTrustFlowValue5;
        private String mTopicalTrustFlowTopic6;
        private String mTopicalTrustFlowValue6;
        private String mTopicalTrustFlowTopic7;
        private String mTopicalTrustFlowValue7;
        private String mTopicalTrustFlowTopic8;
        private String mTopicalTrustFlowValue8;
        private String mTopicalTrustFlowTopic9;
        private String mTopicalTrustFlowValue9;
        public String getDomain() {
            return domain;
        }

        public void setDomain(String domain) {
            this.domain = domain;
        }

        public String getAntor() {
            return antor;
        }

        public void setAntor(String antor) {
            this.antor = antor;
        }

        public String getmExternalBacklinks() {
            return mExternalBacklinks;
        }

        public void setmExternalBacklinks(String mExternalBacklinks) {
            this.mExternalBacklinks = mExternalBacklinks;
        }

        public String getmExternalBacklinksEDU() {
            return mExternalBacklinksEDU;
        }

        public void setmExternalBacklinksEDU(String mExternalBacklinksEDU) {
            this.mExternalBacklinksEDU = mExternalBacklinksEDU;
        }

        public String getmExternalBacklinksGOV() {
            return mExternalBacklinksGOV;
        }

        public void setmExternalBacklinksGOV(String mExternalBacklinksGOV) {
            this.mExternalBacklinksGOV = mExternalBacklinksGOV;
        }

        public String getmReferringDomains() {
            return mReferringDomains;
        }

        public void setmReferringDomains(String mReferringDomains) {
            this.mReferringDomains = mReferringDomains;
        }

        public String getmReferringDomainsEDU() {
            return mReferringDomainsEDU;
        }

        public void setmReferringDomainsEDU(String mReferringDomainsEDU) {
            this.mReferringDomainsEDU = mReferringDomainsEDU;
        }

        public String getmReferringDomainsGOV() {
            return mReferringDomainsGOV;
        }

        public void setmReferringDomainsGOV(String mReferringDomainsGOV) {
            this.mReferringDomainsGOV = mReferringDomainsGOV;
        }

        public String getmIPAddresses() {
            return mIPAddresses;
        }

        public void setmIPAddresses(String mIPAddresses) {
            this.mIPAddresses = mIPAddresses;
        }

        public String getmClassCSubnets() {
            return mClassCSubnets;
        }

        public void setmClassCSubnets(String mClassCSubnets) {
            this.mClassCSubnets = mClassCSubnets;
        }

        public String getmTrustFlow() {
            return mTrustFlow;
        }

        public void setmTrustFlow(String mTrustFlow) {
            this.mTrustFlow = mTrustFlow;
        }

        public String getmCitationFlow() {
            return mCitationFlow;
        }

        public void setmCitationFlow(String mCitationFlow) {
            this.mCitationFlow = mCitationFlow;
        }

        public String getmTopicalTrustFlowTopic0() {
            return mTopicalTrustFlowTopic0;
        }

        public void setmTopicalTrustFlowTopic0(String mTopicalTrustFlowTopic0) {
            this.mTopicalTrustFlowTopic0 = mTopicalTrustFlowTopic0;
        }

        public String getmTopicalTrustFlowValue0() {
            return mTopicalTrustFlowValue0;
        }

        public void setmTopicalTrustFlowValue0(String mTopicalTrustFlowValue0) {
            this.mTopicalTrustFlowValue0 = mTopicalTrustFlowValue0;
        }

        public String getmTopicalTrustFlowTopic1() {
            return mTopicalTrustFlowTopic1;
        }

        public void setmTopicalTrustFlowTopic1(String mTopicalTrustFlowTopic1) {
            this.mTopicalTrustFlowTopic1 = mTopicalTrustFlowTopic1;
        }

        public String getmTopicalTrustFlowValue1() {
            return mTopicalTrustFlowValue1;
        }

        public void setmTopicalTrustFlowValue1(String mTopicalTrustFlowValue1) {
            this.mTopicalTrustFlowValue1 = mTopicalTrustFlowValue1;
        }

        public String getmTopicalTrustFlowTopic2() {
            return mTopicalTrustFlowTopic2;
        }

        public void setmTopicalTrustFlowTopic2(String mTopicalTrustFlowTopic2) {
            this.mTopicalTrustFlowTopic2 = mTopicalTrustFlowTopic2;
        }

        public String getmTopicalTrustFlowValue2() {
            return mTopicalTrustFlowValue2;
        }

        public void setmTopicalTrustFlowValue2(String mTopicalTrustFlowValue2) {
            this.mTopicalTrustFlowValue2 = mTopicalTrustFlowValue2;
        }

        public String getmTopicalTrustFlowTopic3() {
            return mTopicalTrustFlowTopic3;
        }

        public void setmTopicalTrustFlowTopic3(String mTopicalTrustFlowTopic3) {
            this.mTopicalTrustFlowTopic3 = mTopicalTrustFlowTopic3;
        }

        public String getmTopicalTrustFlowValue3() {
            return mTopicalTrustFlowValue3;
        }

        public void setmTopicalTrustFlowValue3(String mTopicalTrustFlowValue3) {
            this.mTopicalTrustFlowValue3 = mTopicalTrustFlowValue3;
        }

        public String getmTopicalTrustFlowTopic4() {
            return mTopicalTrustFlowTopic4;
        }

        public void setmTopicalTrustFlowTopic4(String mTopicalTrustFlowTopic4) {
            this.mTopicalTrustFlowTopic4 = mTopicalTrustFlowTopic4;
        }

        public String getmTopicalTrustFlowValue4() {
            return mTopicalTrustFlowValue4;
        }

        public void setmTopicalTrustFlowValue4(String mTopicalTrustFlowValue4) {
            this.mTopicalTrustFlowValue4 = mTopicalTrustFlowValue4;
        }

        public String getmTopicalTrustFlowTopic5() {
            return mTopicalTrustFlowTopic5;
        }

        public void setmTopicalTrustFlowTopic5(String mTopicalTrustFlowTopic5) {
            this.mTopicalTrustFlowTopic5 = mTopicalTrustFlowTopic5;
        }

        public String getmTopicalTrustFlowValue5() {
            return mTopicalTrustFlowValue5;
        }

        public void setmTopicalTrustFlowValue5(String mTopicalTrustFlowValue5) {
            this.mTopicalTrustFlowValue5 = mTopicalTrustFlowValue5;
        }

        public String getmTopicalTrustFlowTopic6() {
            return mTopicalTrustFlowTopic6;
        }

        public void setmTopicalTrustFlowTopic6(String mTopicalTrustFlowTopic6) {
            this.mTopicalTrustFlowTopic6 = mTopicalTrustFlowTopic6;
        }

        public String getmTopicalTrustFlowValue6() {
            return mTopicalTrustFlowValue6;
        }

        public void setmTopicalTrustFlowValue6(String mTopicalTrustFlowValue6) {
            this.mTopicalTrustFlowValue6 = mTopicalTrustFlowValue6;
        }

        public String getmTopicalTrustFlowTopic7() {
            return mTopicalTrustFlowTopic7;
        }

        public void setmTopicalTrustFlowTopic7(String mTopicalTrustFlowTopic7) {
            this.mTopicalTrustFlowTopic7 = mTopicalTrustFlowTopic7;
        }

        public String getmTopicalTrustFlowValue7() {
            return mTopicalTrustFlowValue7;
        }

        public void setmTopicalTrustFlowValue7(String mTopicalTrustFlowValue7) {
            this.mTopicalTrustFlowValue7 = mTopicalTrustFlowValue7;
        }

        public String getmTopicalTrustFlowTopic8() {
            return mTopicalTrustFlowTopic8;
        }

        public void setmTopicalTrustFlowTopic8(String mTopicalTrustFlowTopic8) {
            this.mTopicalTrustFlowTopic8 = mTopicalTrustFlowTopic8;
        }

        public String getmTopicalTrustFlowValue8() {
            return mTopicalTrustFlowValue8;
        }

        public void setmTopicalTrustFlowValue8(String mTopicalTrustFlowValue8) {
            this.mTopicalTrustFlowValue8 = mTopicalTrustFlowValue8;
        }

        public String getmTopicalTrustFlowTopic9() {
            return mTopicalTrustFlowTopic9;
        }

        public void setmTopicalTrustFlowTopic9(String mTopicalTrustFlowTopic9) {
            this.mTopicalTrustFlowTopic9 = mTopicalTrustFlowTopic9;
        }

        public String getmTopicalTrustFlowValue9() {
            return mTopicalTrustFlowValue9;
        }

        public void setmTopicalTrustFlowValue9(String mTopicalTrustFlowValue9) {
            this.mTopicalTrustFlowValue9 = mTopicalTrustFlowValue9;
        }
    }

    /**
     * 过滤域名排版
     * @throws Exception
     */
    @Test
    public void testDomain() throws Exception {
        Workbook workBook = ExcelReaderHelper.getWorkBookByPath("/Users/joye/Downloads/4-22-删除.xlsx");
        List<Item> allResult = new ArrayList<>();
        Item entity;
        String cellValue = "";
        Sheet sheet = workBook.getSheetAt(0);
        int i = 0;
        for (Row r : sheet) {
            entity = new Item();
            for (Cell cell : r) {
                cellValue = cell.getStringCellValue();
                if(cellValue==null){
                    cellValue="";
                }
                if (cell.getColumnIndex() == 0) {
                    entity.setDomain(cellValue);
                } else if (cell.getColumnIndex() == 1) {
                    entity.setAntor(cellValue);
                } else {
                    break;
                }
            }
            String antor = entity.getAntor();
            if(AntorUtils.antorIsTure(antor)
                    ) {
                allResult.add(entity);
            }
        }



        Workbook workbook= createWorkBook("/Users/joye/Downloads/","描文本4-19-整理-新",EXCEL_TYPE_XLSX);
        //根据资源,写入内容
        Sheet sheet1 =workbook.createSheet("sheet1");
        //获取样式
        CellStyle mCellStyle=CreateCellStyle(workbook);

        Row row=null;
        for (int j = 0; j < allResult.size(); j++) {
            Item entiy= allResult.get(j);
            row = (Row) sheet1.createRow(j);
            row.setHeight((short) 500);
            row.createCell(0).setCellValue(allResult.get(j).getDomain());
            row.createCell(1).setCellValue(allResult.get(j).getAntor());
        }
        //创建文件流
        OutputStream stream = new FileOutputStream("/Users/joye/Downloads/"+File.separator+"描文本4-19-整理-新."+EXCEL_TYPE_XLSX);
        //写入数据
        workbook.write(stream);
        //关闭文件流
        stream.close();

    }



    @Test
    public void testABC() throws Exception {
        try {
            String key = "广州学邦"; //查询关键字
            key = URLEncoder.encode(key, "utf-8");
            URL u = new URL("http://www.baidu.com.cn/s?wd=" + key + "&cl=3");
            URLConnection conn = u.openConnection();
            BufferedReader reader = new BufferedReader(new InputStreamReader(
                    conn.getInputStream(), "gb2312"));
            String str = reader.readLine();
            while (str != null) {
                System.out.println(str);
                str = reader.readLine();
            }

            reader.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
}
