package com.joye.hk6.presenter;

import com.joye.basedomain.interactor.DefaultSubscriber;
import com.joye.basedomain.interactor.UseCase;
import com.joye.basepresentation.internal.di.PerActivity;
import com.joye.hk6.mvp.Presenter;
import com.joye.hk6.vu.ChineseZodiacProbilityFragmentVu;
import com.joye.hk6domain.entity.Hk6UiData;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by W,x (JoyeWang)
 * on 2016/9/22.
 * 304622254@qq.com
 * Remeark:生肖概率
 */
@PerActivity
public class ChineseZodiacProbilityPresenter implements Presenter<ChineseZodiacProbilityFragmentVu> {


    private final UseCase mHk6DataUseCase;

    private ChineseZodiacProbilityFragmentVu vu;


    @Inject
    public ChineseZodiacProbilityPresenter(  UseCase getHk6DataUseCase) {
        this.mHk6DataUseCase = getHk6DataUseCase;
    }


    @Override
    public void setView(ChineseZodiacProbilityFragmentVu chineseZodiacProbilityFragmentVu) {
        this.vu=chineseZodiacProbilityFragmentVu;
    }

    public void initalize( ){
        loadHk6Data();
    }
    private void getHk6ListData(){
            mHk6DataUseCase.execute(new Hk6ListDataSubscriber());
    }
    private void loadHk6Data() {
        vu.showLoading();
        getHk6ListData();
    }

    @Override
    public void resume() {

    }

    @Override
    public void pause() {

    }

    public final class Hk6ListDataSubscriber extends DefaultSubscriber<List<Hk6UiData>>{
        @Override
        public void onCompleted() {
            ChineseZodiacProbilityPresenter.this.vu.showContent();
        }

        @Override
        public void onError(Throwable e) {
            vu.showError(e);
        }

        @Override
        public void onNext(List<Hk6UiData> hk6UiDatas) {
            vu.onNext(hk6UiDatas);
        }
    }

    @Override
    public void destroy() {
        mHk6DataUseCase.unsubscribe();
    }
}
