package com.joye.hk6data.repository;

import android.content.Context;

import com.joye.hk6data.entity.DataTransformerEntity;
import com.joye.hk6data.entity.Hk6Entity;
import com.joye.hk6data.repository.datasource.Hk6DataStore;
import com.joye.hk6data.repository.datasource.Hk6DataStoreFactory;
import com.joye.hk6domain.entity.Hk6UiData;
import com.joye.hk6domain.repository.Hk6Repository;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import rx.Observable;
import rx.functions.Func1;

/**
 * Created by W,x (JoyeWang)
 * on 2016/9/20.
 * 304622254@qq.com
 * Remeark:
 */
@Singleton
public class Hk6DataRepository  implements Hk6Repository {
    private final Hk6DataStoreFactory hk6DataStoreFactory;
    @Inject
    public Hk6DataRepository(Hk6DataStoreFactory hk6DataStore ) {
        this.hk6DataStoreFactory = hk6DataStore;
    }

    @Override
    public Observable<List<Hk6UiData>> getHk6Data(String date) {
        final Hk6DataStore hk6DataStore=hk6DataStoreFactory.create(date);
        return hk6DataStore.getHk6ListData(date).flatMap(new Func1<List<Hk6Entity>, Observable<List<Hk6UiData>>>() {
            @Override
            public Observable<List<Hk6UiData>> call(List<Hk6Entity> hk6EntityList) {
                List<Hk6UiData> retListData=new ArrayList<Hk6UiData>(hk6EntityList.size());
                Hk6UiData uiData;
                Hk6Entity hk6Entity;
                DataTransformerEntity dataTransformerEntity;
                for (int i=0;i<hk6EntityList.size();i++){
                    hk6Entity=hk6EntityList.get(i);
                    uiData=new Hk6UiData();
                    dataTransformerEntity=hk6Entity.getDataTransformerEntity();
                    uiData.setExpect(hk6Entity.getExpect().substring(4,7)+"期");
                    uiData.setEvictors(dataTransformerEntity.getmEvictors());
                    uiData.setOpentime(hk6Entity.getOpentime());
                    uiData.setOpentimestamp(hk6Entity.getOpentimestamp());
                    uiData.setWinningNumber(dataTransformerEntity.getWinningNumber());
                    retListData.add(uiData);
                }
                return Observable.just(retListData);
            }
        });
    }



}
