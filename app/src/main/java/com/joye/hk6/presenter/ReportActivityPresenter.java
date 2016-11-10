package com.joye.hk6.presenter;

import android.support.v7.app.ActionBar;
import android.view.View;

import com.joye.basedomain.interactor.DefaultSubscriber;
import com.joye.basedomain.interactor.UseCase;
import com.joye.basepresentation.internal.di.PerActivity;
import com.joye.hk6.R;
import com.joye.hk6.mvp.Presenter;
import com.joye.hk6.view.ReportActivity;
import com.joye.hk6.view.SizeActivity;
import com.joye.hk6.vu.ReportActivityVu;
import com.joye.hk6.vu.SizeActivityVu;
import com.joye.hk6domain.vo.SizeVo;

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
public class ReportActivityPresenter implements Presenter<ReportActivityVu> {



    private ReportActivityVu vu;

    private ReportActivity sizeActivity;

    @Inject
    public ReportActivityPresenter( ) {
    }


    @Override
    public void setView(ReportActivityVu chineseZodiacProbilityFragmentVu) {
        this.vu=chineseZodiacProbilityFragmentVu;
    }

    public void initalize(ReportActivity sizeActivity ){
        this.sizeActivity=sizeActivity;
        sizeActivity.setSupportActionBar(vu.toolbar);
        final ActionBar ab = sizeActivity.getSupportActionBar();
        ab.setHomeAsUpIndicator(R.drawable.ic_arrow_back_black_24dp);
        ab.setDisplayHomeAsUpEnabled(true);
        vu.toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ReportActivityPresenter.this.sizeActivity.finish();
            }
        });
    }

    @Override
    public void resume() {

    }

    @Override
    public void pause() {

    }

    @Override
    public void destroy() {

    }

}
