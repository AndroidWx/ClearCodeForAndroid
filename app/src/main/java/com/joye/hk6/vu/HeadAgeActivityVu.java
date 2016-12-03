package com.joye.hk6.vu;

import android.content.Context;
import android.widget.TextView;

import com.joye.basedata.executor.JobExecutor_Factory;
import com.joye.hk6.R;
import com.joye.hk6.adapter.HeadAgeAdapter;
import com.joye.hk6.adapter.UpdateItemRecyclerViewAdapter;
import com.joye.hk6.report.HeadAgeReport;
import com.joye.hk6.vu.base.CoordinatorLayoutToolBarImageViewRecyclerVu;
import com.joye.hk6domain.constants.Hk6EnumHelp;
import com.joye.hk6domain.vo.HeadAgeVo;

import java.util.List;

import rx.Observable;
import rx.Observer;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by xiang on 16/9/29.
 */

public class HeadAgeActivityVu extends CoordinatorLayoutToolBarImageViewRecyclerVu<HeadAgeVo> {
    @Override
    public void setToolbarTimeAndViewStubInflate() {
        toolbar.setTitle("头数走势预警");
        backdrop.setImageResource(R.drawable.headage);
        lableViewStub.setLayoutResource( R.layout.item_headage);
        lableViewStub.inflate();
    }

    @Override
    public UpdateItemRecyclerViewAdapter getRecylerViewAdapter(Context context) {
        return new HeadAgeAdapter(context);
    }


    int headage0, headage1, headage2, headage3, headage4;
    @Override
    public void onNext(List<HeadAgeVo> HeadAgeVos) {
        super.onNext(HeadAgeVos);
        Observable.just(HeadAgeVos).subscribeOn(Schedulers.from(JobExecutor_Factory.INSTANCE.get())).subscribe(new Observer<List<HeadAgeVo>>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(List<HeadAgeVo> colorVos) {
                new HeadAgeReport(colorVos).BubbleSort(callback);
            }
        });

        Observable.from(HeadAgeVos).filter(new Func1<HeadAgeVo, Boolean>() {
            @Override
            public Boolean call(HeadAgeVo compositeVo) {
                return compositeVo.getOpentimestamp() >= Hk6EnumHelp.Default2016;
            }
        }).subscribeOn(Schedulers.from(JobExecutor_Factory.INSTANCE.get())).subscribe(new Observer<HeadAgeVo>() {
            @Override
            public void onCompleted() {
                TextView.class.cast(view.findViewById(R.id.report_left_headage0)).setText(view.getResources().getString(R.string.headage0,headage0));
                TextView.class.cast(view.findViewById(R.id.report_left_headage1)).setText(view.getResources().getString(R.string.headage1,headage1));
                TextView.class.cast(view.findViewById(R.id.report_left_headage2)).setText(view.getResources().getString(R.string.headage2,headage2));
                TextView.class.cast(view.findViewById(R.id.report_left_headage3)).setText(view.getResources().getString(R.string.headage3,headage3));
                TextView.class.cast(view.findViewById(R.id.report_left_headage4)).setText(view.getResources().getString(R.string.headage4,headage4));
            }

            @Override
            public void onError(Throwable e) {
                e.printStackTrace();
            }

            @Override
            public void onNext(HeadAgeVo compositeVo) {
                if (compositeVo.headage0 == 0) {
                    headage0++;
                } else if (compositeVo.headage1== 0) {
                    headage1++;
                } else if (compositeVo.headage2 == 0) {
                    headage2++;
                } else if (compositeVo.headage3 == 0) {
                    headage3++;
                } else if (compositeVo.headage4 == 0) {
                    headage4++;
                }
            }
        });
    }
}
