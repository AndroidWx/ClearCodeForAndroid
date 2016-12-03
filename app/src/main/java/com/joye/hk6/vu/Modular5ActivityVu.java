package com.joye.hk6.vu;

import android.content.Context;
import android.widget.TextView;

import com.joye.basedata.executor.JobExecutor_Factory;
import com.joye.hk6.R;
import com.joye.hk6.adapter.Modular5Adapter;
import com.joye.hk6.adapter.UpdateItemRecyclerViewAdapter;
import com.joye.hk6.report.Modular5Report;
import com.joye.hk6.vu.base.CoordinatorLayoutToolBarImageViewRecyclerVu;
import com.joye.hk6domain.constants.Hk6EnumHelp;
import com.joye.hk6domain.vo.Modular5Vo;

import java.util.List;

import rx.Observable;
import rx.Observer;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by xiang on 16/9/29.
 */

public class Modular5ActivityVu extends CoordinatorLayoutToolBarImageViewRecyclerVu<Modular5Vo> {
    @Override
    public void setToolbarTimeAndViewStubInflate() {
        toolbar.setTitle("模5数走势预警");
        backdrop.setImageResource(R.drawable.modular5);
        lableViewStub.setLayoutResource( R.layout.item_modular5);
        lableViewStub.inflate();
    }

    @Override
    public UpdateItemRecyclerViewAdapter getRecylerViewAdapter(Context context) {
        return new Modular5Adapter(context);
    }

    int M0, M1, M2,M3,M4;
    @Override
    public void onNext(List<Modular5Vo> Modular5Vos) {
        super.onNext(Modular5Vos);
        Observable.just(Modular5Vos).subscribeOn(Schedulers.from(JobExecutor_Factory.INSTANCE.get())).subscribe(new Observer<List<Modular5Vo>>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(List<Modular5Vo> colorVos) {
                new Modular5Report(colorVos).BubbleSort(callback);
            }
        });
        Observable.from(Modular5Vos).filter(new Func1<Modular5Vo, Boolean>() {
            @Override
            public Boolean call(Modular5Vo compositeVo) {
                return compositeVo.getOpentimestamp() >= Hk6EnumHelp.Default2016;
            }
        }).subscribeOn(Schedulers.from(JobExecutor_Factory.INSTANCE.get())).subscribe(new Observer<Modular5Vo>() {
            @Override
            public void onCompleted() {
                TextView.class.cast(view.findViewById(R.id.report_left_modular_5_0)).setText(view.getResources().getString(R.string.modular_5_0,M0));
                TextView.class.cast(view.findViewById(R.id.report_left_modular_5_1)).setText(view.getResources().getString(R.string.modular_5_1,M1));
                TextView.class.cast(view.findViewById(R.id.report_left_modular_5_2)).setText(view.getResources().getString(R.string.modular_5_2,M2));
                TextView.class.cast(view.findViewById(R.id.report_left_modular_5_3)).setText(view.getResources().getString(R.string.modular_5_3,M3));
                TextView.class.cast(view.findViewById(R.id.report_left_modular_5_4)).setText(view.getResources().getString(R.string.modular_5_4,M4));
            }

            @Override
            public void onError(Throwable e) {
                e.printStackTrace();
            }

            @Override
            public void onNext(Modular5Vo compositeVo) {
                if (compositeVo.M0 == 0) {
                    M0++;
                } else if (compositeVo.M1== 0) {
                    M1++;
                } else if (compositeVo.M2 == 0) {
                    M2++;
                }else if (compositeVo.M3 == 0) {
                    M3++;
                }else if (compositeVo.M4 == 0) {
                    M4++;
                }
            }
        });
    }
    
}
