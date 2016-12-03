package com.joye.hk6.vu;

import android.content.Context;
import android.widget.TextView;

import com.joye.basedata.executor.JobExecutor_Factory;
import com.joye.hk6.R;
import com.joye.hk6.adapter.Modular4Adapter;
import com.joye.hk6.adapter.UpdateItemRecyclerViewAdapter;
import com.joye.hk6.report.Modular4Report;
import com.joye.hk6.vu.base.CoordinatorLayoutToolBarImageViewRecyclerVu;
import com.joye.hk6domain.constants.Hk6EnumHelp;
import com.joye.hk6domain.vo.Modular4Vo;

import java.util.List;

import rx.Observable;
import rx.Observer;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by xiang on 16/9/29.
 */

public class Modular4ActivityVu extends CoordinatorLayoutToolBarImageViewRecyclerVu<Modular4Vo> {
    @Override
    public void setToolbarTimeAndViewStubInflate() {
        toolbar.setTitle("模4数走势预警");
        backdrop.setImageResource(R.drawable.modular4);
        lableViewStub.setLayoutResource( R.layout.item_modular4);
        lableViewStub.inflate();
    }

    @Override
    public UpdateItemRecyclerViewAdapter getRecylerViewAdapter(Context context) {
        return new Modular4Adapter(context);
    }

    int M0, M1, M2,M3;
    @Override
    public void onNext(List<Modular4Vo> Modular4Vos) {
        super.onNext(Modular4Vos);
        Observable.just(Modular4Vos).subscribeOn(Schedulers.from(JobExecutor_Factory.INSTANCE.get())).subscribe(new Observer<List<Modular4Vo>>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(List<Modular4Vo> colorVos) {
                new Modular4Report(colorVos).BubbleSort(callback);
            }
        });
        Observable.from(Modular4Vos).filter(new Func1<Modular4Vo, Boolean>() {
            @Override
            public Boolean call(Modular4Vo compositeVo) {
                return compositeVo.getOpentimestamp() >= Hk6EnumHelp.Default2016;
            }
        }).subscribeOn(Schedulers.from(JobExecutor_Factory.INSTANCE.get())).subscribe(new Observer<Modular4Vo>() {
            @Override
            public void onCompleted() {
                TextView.class.cast(view.findViewById(R.id.report_left_modular_4_0)).setText(view.getResources().getString(R.string.modular_4_0,M0));
                TextView.class.cast(view.findViewById(R.id.report_left_modular_4_1)).setText(view.getResources().getString(R.string.modular_4_1,M1));
                TextView.class.cast(view.findViewById(R.id.report_left_modular_4_2)).setText(view.getResources().getString(R.string.modular_4_2,M2));
                TextView.class.cast(view.findViewById(R.id.report_left_modular_4_3)).setText(view.getResources().getString(R.string.modular_4_3,M3));
            }

            @Override
            public void onError(Throwable e) {
                e.printStackTrace();
            }

            @Override
            public void onNext(Modular4Vo compositeVo) {
                if (compositeVo.M0 == 0) {
                    M0++;
                } else if (compositeVo.M1== 0) {
                    M1++;
                } else if (compositeVo.M2 == 0) {
                    M2++;
                }else if (compositeVo.M3 == 0) {
                    M3++;
                }
            }
        });
    }
}
