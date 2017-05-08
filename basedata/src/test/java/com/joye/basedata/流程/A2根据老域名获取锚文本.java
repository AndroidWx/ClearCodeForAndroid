package com.joye.basedata.流程;

import com.joye.basedata.autoseo.ExtralResourceWriteDelegate;
import com.joye.basedata.domainhandle.ArchiveNetApiImpl;
import com.joye.basedata.domainhandle.ArchiveResponse;
import com.joye.basedata.domainhandle.DomainWriteExcel;
import com.joye.basedata.majestic_.api.MajetsicApiRestImpl;
import com.joye.basedata.majestic_.entity.AnchorTextEntity;
import com.joye.basedata.majestic_.entity.MajetsicCommResponse;

import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import rx.Observable;
import rx.Observer;
import rx.schedulers.Schedulers;

/**
 * Created by joye on 2017/4/20.
 */

public class A2根据老域名获取锚文本 {
    /**
     * 根据老域名，获取老域名快照， 并把信息写入Excel里面
     *
     * @throws Exception
     */
    @Test
    public void testFirstArchiveAndMajectsict() throws Exception {
        List<ArchiveResponse> ArchiveResponses = new ArrayList<>();
        List<ArchiveResponse> MajetsicList = new ArrayList<>();
        List<MajetsicCommResponse<AnchorTextEntity>> AnchorTextEntityLists = new ArrayList<>();
        List<String> urls = ExtralResourceWriteDelegate.getAllKeysByFilePath("/Users/joye/Search/a/域名.xlsx");
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




    private String oldDomainPath="/Users/joye/Search/域名处理/2017-5-8/域名-未用.xlsx";
    private String newExcelPath="/Users/joye/Search/域名处理/2017-5-8/";
    private String newExcelName="处理域名排版结果";
    @Test
    public void testGetMajesticInfo() throws Exception {
        getMajesticInfo(0,oldDomainPath , newExcelPath, newExcelName);
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
            int j=0;
            while (j<urls.size()) {
                for (int i = 0; i < urls.size(); i++) {
                    j++;
                    int finalI=i;
                    new MajetsicApiRestImpl().GetAnchorText(urls.get(i), "1", "0", "", "", "", "", "").subscribe(new Observer<MajetsicCommResponse<AnchorTextEntity>>() {
                        @Override
                        public void onCompleted() {

                        }

                        @Override
                        public void onError(Throwable e) {
                            //失败的情况下，构建一个锚文本
                            MajetsicCommResponse<AnchorTextEntity> response =new MajetsicCommResponse<AnchorTextEntity>();
                            AnchorTextEntity anchorText=new AnchorTextEntity();
                            anchorText.setOldDomainStr(urls.get(finalI));
                            AnchorTextEntity.AnchorTextBean anchorbean =new AnchorTextEntity.AnchorTextBean();
                            List<AnchorTextEntity.AnchorTextBean.DataBean> datas=new ArrayList<AnchorTextEntity.AnchorTextBean.DataBean>();
                            AnchorTextEntity.AnchorTextBean.DataBean dataBean=new AnchorTextEntity.AnchorTextBean.DataBean();
                            dataBean.setAnchorText("");
                            datas.add(dataBean);
                            anchorbean.setData(datas);
                            anchorText.setAnchorText(anchorbean);
                            response.setDataTables(anchorText);
                            AnchorTextEntityLists.add(response);
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




}
