package com.joye.hk6.vu;

import android.content.Context;
import android.widget.TextView;

import com.joye.basedata.executor.JobExecutor_Factory;
import com.joye.hk6.R;
import com.joye.hk6.adapter.Modular5Adapter;
import com.joye.hk6.adapter.Modular6Adapter;
import com.joye.hk6.adapter.UpdateItemRecyclerViewAdapter;
import com.joye.hk6.vu.base.CoordinatorLayoutToolBarImageViewRecyclerVu;
import com.joye.hk6domain.constants.Hk6EnumHelp;
import com.joye.hk6domain.vo.Modular6Vo;

import java.util.List;

import rx.Observable;
import rx.Observer;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by xiang on 16/9/29.
 */

public class Modular6ActivityVu extends CoordinatorLayoutToolBarImageViewRecyclerVu<Modular6Vo> {
    @Override
    public void setToolbarTimeAndViewStubInflate() {
        toolbar.setTitle("模6数走势预警");
        backdrop.setImageResource(R.drawable.modular6);
        lableViewStub.setLayoutResource( R.layout.item_modular6);
        lableViewStub.inflate();
    }

    @Override
    public UpdateItemRecyclerViewAdapter getRecylerViewAdapter(Context context) {
        return new Modular6Adapter(context);
    }

    int M0, M1, M2,M3,M4,M5;
    @Override
    public void onNext(List<Modular6Vo> Modular6Vos) {
        super.onNext(Modular6Vos);
        Observable.from(Modular6Vos).filter(new Func1<Modular6Vo, Boolean>() {
            @Override
            public Boolean call(Modular6Vo compositeVo) {
                return compositeVo.getOpentimestamp() >= Hk6EnumHelp.Default2016;
            }
        }).subscribeOn(Schedulers.from(JobExecutor_Factory.INSTANCE.get())).subscribe(new Observer<Modular6Vo>() {
            @Override
            public void onCompleted() {
                TextView.class.cast(view.findViewById(R.id.report_left_modular_6_0)).setText(view.getResources().getString(R.string.modular_6_0,M0));
                TextView.class.cast(view.findViewById(R.id.report_left_modular_6_1)).setText(view.getResources().getString(R.string.modular_6_1,M1));
                TextView.class.cast(view.findViewById(R.id.report_left_modular_6_2)).setText(view.getResources().getString(R.string.modular_6_2,M2));
                TextView.class.cast(view.findViewById(R.id.report_left_modular_6_3)).setText(view.getResources().getString(R.string.modular_6_3,M3));
                TextView.class.cast(view.findViewById(R.id.report_left_modular_6_4)).setText(view.getResources().getString(R.string.modular_6_4,M4));
                TextView.class.cast(view.findViewById(R.id.report_left_modular_6_5)).setText(view.getResources().getString(R.string.modular_6_5,M5));
            }

            @Override
            public void onError(Throwable e) {
                e.printStackTrace();
            }

            @Override
            public void onNext(Modular6Vo compositeVo) {
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
                }else if (compositeVo.M5 == 0) {
                    M5++;
                }
            }
        });
    }

    
}
