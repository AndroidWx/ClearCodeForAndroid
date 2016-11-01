package com.joye.hk6.vu;

import android.content.Context;
import android.widget.TextView;

import com.joye.basedata.executor.JobExecutor_Factory;
import com.joye.hk6.R;
import com.joye.hk6.adapter.Modular6Adapter;
import com.joye.hk6.adapter.Modular7Adapter;
import com.joye.hk6.adapter.UpdateItemRecyclerViewAdapter;
import com.joye.hk6.vu.base.CoordinatorLayoutToolBarImageViewRecyclerVu;
import com.joye.hk6domain.constants.Hk6EnumHelp;
import com.joye.hk6domain.vo.Modular7Vo;
import com.joye.hk6domain.vo.Modular7Vo;

import java.util.List;

import rx.Observable;
import rx.Observer;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by xiang on 16/9/29.
 */

public class Modular7ActivityVu extends CoordinatorLayoutToolBarImageViewRecyclerVu<Modular7Vo> {
    @Override
    public void setToolbarTimeAndViewStubInflate() {
        toolbar.setTitle("模7数走势预警");
        backdrop.setImageResource(R.drawable.modular7);
        lableViewStub.setLayoutResource( R.layout.item_modular7);
        lableViewStub.inflate();
    }

    @Override
    public UpdateItemRecyclerViewAdapter getRecylerViewAdapter(Context context) {
        return new Modular7Adapter(context);
    }

    int M0, M1, M2,M3,M4,M5,M6;
    @Override
    public void onNext(List<Modular7Vo> Modular7Vos) {
        super.onNext(Modular7Vos);
        Observable.from(Modular7Vos).filter(new Func1<Modular7Vo, Boolean>() {
            @Override
            public Boolean call(Modular7Vo compositeVo) {
                return compositeVo.getOpentimestamp() >= Hk6EnumHelp.Default2016;
            }
        }).subscribeOn(Schedulers.from(JobExecutor_Factory.INSTANCE.get())).subscribe(new Observer<Modular7Vo>() {
            @Override
            public void onCompleted() {
                TextView.class.cast(view.findViewById(R.id.report_left_modular_7_0)).setText(view.getResources().getString(R.string.modular_7_0,M0));
                TextView.class.cast(view.findViewById(R.id.report_left_modular_7_1)).setText(view.getResources().getString(R.string.modular_7_1,M1));
                TextView.class.cast(view.findViewById(R.id.report_left_modular_7_2)).setText(view.getResources().getString(R.string.modular_7_2,M2));
                TextView.class.cast(view.findViewById(R.id.report_left_modular_7_3)).setText(view.getResources().getString(R.string.modular_7_3,M3));
                TextView.class.cast(view.findViewById(R.id.report_left_modular_7_4)).setText(view.getResources().getString(R.string.modular_7_4,M4));
                TextView.class.cast(view.findViewById(R.id.report_left_modular_7_5)).setText(view.getResources().getString(R.string.modular_7_5,M5));
                TextView.class.cast(view.findViewById(R.id.report_left_modular_7_6)).setText(view.getResources().getString(R.string.modular_7_6,M6));
            }

            @Override
            public void onError(Throwable e) {
                e.printStackTrace();
            }

            @Override
            public void onNext(Modular7Vo compositeVo) {
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
                }else if (compositeVo.M6 == 0) {
                    M6++;
                }
            }
        });
    }
    
}
