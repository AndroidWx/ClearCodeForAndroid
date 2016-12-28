package com.joye.hk6.presenter;

import android.support.v7.app.ActionBar;
import android.view.View;

import com.joye.basedomain.interactor.DefaultSubscriber;
import com.joye.basedomain.interactor.UseCase;
import com.joye.basepresentation.internal.di.PerActivity;
import com.joye.hk6.R;
import com.joye.hk6.mvp.Presenter;
import com.joye.hk6.view.OddEvenActivity;
import com.joye.hk6.vu.OddEvenActivityVu;
import com.joye.hk6domain.interactor.GetOddEvenUseCase;
import com.joye.hk6domain.vo.OddEvenVo;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

/**
 * Created by W,x (JoyeWang)
 * on 2016/9/22.
 * 304622254@qq.com
 * Remeark:大小概率
 */
@PerActivity
public class OddEvenActivityPresenter implements Presenter<OddEvenActivityVu> {


    private final UseCase mHk6DataUseCase;

    private OddEvenActivityVu vu;

    private OddEvenActivity sizeActivity;

    @Inject
    public OddEvenActivityPresenter(@Named("GetOddEvenUseCase")UseCase getHk6DataUseCase) {
        this.mHk6DataUseCase = getHk6DataUseCase;
    }


    @Override
    public void setView(OddEvenActivityVu chineseZodiacProbilityFragmentVu) {
        this.vu=chineseZodiacProbilityFragmentVu;
    }

    public void initalize(OddEvenActivity sizeActivity ){
        this.sizeActivity=sizeActivity;
        sizeActivity.setSupportActionBar(vu.toolbar);
        final ActionBar ab = sizeActivity.getSupportActionBar();
        ab.setHomeAsUpIndicator(R.drawable.ic_arrow_back_black_24dp);
        ab.setDisplayHomeAsUpEnabled(true);
        loadHk6Data();
        vu.toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OddEvenActivityPresenter.this.sizeActivity.finish();
            }
        });
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

    public final class Hk6ListDataSubscriber extends DefaultSubscriber<List<OddEvenVo>>{
        @Override
        public void onCompleted() {
            OddEvenActivityPresenter.this.vu.showContent();
        }

        @Override
        public void onError(Throwable e) {
            vu.showError(e);
        }

        @Override
        public void onNext(List<OddEvenVo> hk6UiDatas) {
            vu.onNext(hk6UiDatas);
        }
    }

    @Override
    public void destroy() {
        mHk6DataUseCase.unsubscribe();
    }

    public View.OnClickListener getErrorRetryListener(){
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getHk6ListData();
            }
        };
    }
}
