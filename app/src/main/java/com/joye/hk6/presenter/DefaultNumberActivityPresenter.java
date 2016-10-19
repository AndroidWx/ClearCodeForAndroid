package com.joye.hk6.presenter;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.joye.basedomain.interactor.DefaultSubscriber;
import com.joye.basedomain.interactor.UseCase;
import com.joye.basepresentation.internal.di.PerActivity;
import com.joye.hk6.R;
import com.joye.hk6.mvp.Presenter;
import com.joye.hk6.vu.ChineseZodiacActivityVu;
import com.joye.hk6.vu.DefaultNumberActivityVu;
import com.joye.hk6domain.interactor.GetDefaultNumberUseCase;
import com.joye.hk6domain.vo.ChineseZodiacVo;
import com.joye.hk6domain.vo.DefaultNumberVo;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

/**
 * Created by xiang on 16/9/29.
 */
@PerActivity
public class DefaultNumberActivityPresenter implements Presenter<DefaultNumberActivityVu> {
    protected UseCase mHk6DataUseCase;

    private DefaultNumberActivityVu vu;

    private AppCompatActivity regionActivity;

    @Override
    public void setView(DefaultNumberActivityVu chineseZodiacProbilityFragmentVu) {
        this.vu = chineseZodiacProbilityFragmentVu;
    }

    public void initalize(AppCompatActivity regionActivity) {
        this.regionActivity = regionActivity;
        regionActivity.setSupportActionBar(vu.toolbar);
        final ActionBar ab = regionActivity.getSupportActionBar();
        ab.setHomeAsUpIndicator(R.drawable.ic_arrow_back_black_24dp);
        ab.setDisplayHomeAsUpEnabled(true);
        loadHk6Data();
        vu.toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DefaultNumberActivityPresenter.this.regionActivity.finish();
            }
        });
    }

    private void getHk6ListData() {
        mHk6DataUseCase.execute(new DefaultNumberActivityPresenter.Hk6ListDataSubscriber());
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

    public final class Hk6ListDataSubscriber extends DefaultSubscriber<List<DefaultNumberVo>> {
        @Override
        public void onCompleted() {
            DefaultNumberActivityPresenter.this.vu.showContent();
        }

        @Override
        public void onError(Throwable e) {
            vu.showError(e);
        }

        @Override
        public void onNext(List<DefaultNumberVo> hk6UiDatas) {
            vu.onNext(hk6UiDatas);
        }
    }

    @Override
    public void destroy() {
        mHk6DataUseCase.unsubscribe();
    }

    public View.OnClickListener getErrorRetryListener() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getHk6ListData();
            }
        };
    }

    @Inject
    public DefaultNumberActivityPresenter(@Named("GetDefaultNumberUseCase") UseCase getHk6DataUseCase) {
        this.mHk6DataUseCase = getHk6DataUseCase;
    }

}
