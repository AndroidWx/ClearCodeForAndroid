package com.joye.hk6.vu;

import android.content.Context;
import android.widget.TextView;

import com.joye.basedata.executor.JobExecutor_Factory;
import com.joye.hk6.R;
import com.joye.hk6.adapter.HeadTwosAdapter;
import com.joye.hk6.adapter.Modular3Adapter;
import com.joye.hk6.adapter.UpdateItemRecyclerViewAdapter;
import com.joye.hk6.vu.base.CoordinatorLayoutToolBarImageViewRecyclerVu;
import com.joye.hk6domain.constants.Hk6EnumHelp;
import com.joye.hk6domain.constants.Modular3;
import com.joye.hk6domain.vo.Modular3Vo;
import com.joye.hk6domain.vo.Modular3Vo;

import java.util.List;

import rx.Observable;
import rx.Observer;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by xiang on 16/9/29.
 */

public class Modular3ActivityVu extends CoordinatorLayoutToolBarImageViewRecyclerVu<Modular3Vo> {
    @Override
    public void setToolbarTimeAndViewStubInflate() {
        toolbar.setTitle("模3数走势预警");
        backdrop.setImageResource(R.drawable.modular3);
        lableViewStub.setLayoutResource( R.layout.item_modular3);
        lableViewStub.inflate();
    }

    @Override
    public UpdateItemRecyclerViewAdapter getRecylerViewAdapter(Context context) {
        return new Modular3Adapter(context);
    }

    int M0, M1, M2;
    @Override
    public void onNext(List<Modular3Vo> Modular3Vos) {
        super.onNext(Modular3Vos);
        Observable.from(Modular3Vos).filter(new Func1<Modular3Vo, Boolean>() {
            @Override
            public Boolean call(Modular3Vo compositeVo) {
                return compositeVo.getOpentimestamp() >= Hk6EnumHelp.Default2016;
            }
        }).subscribeOn(Schedulers.from(JobExecutor_Factory.INSTANCE.get())).subscribe(new Observer<Modular3Vo>() {
            @Override
            public void onCompleted() {
                TextView.class.cast(view.findViewById(R.id.report_left_modular_3_0)).setText(view.getResources().getString(R.string.modular_3_0,M0));
                TextView.class.cast(view.findViewById(R.id.report_left_modular_3_1)).setText(view.getResources().getString(R.string.modular_3_1,M1));
                TextView.class.cast(view.findViewById(R.id.report_left_modular_3_2)).setText(view.getResources().getString(R.string.modular_3_2,M2));
            }

            @Override
            public void onError(Throwable e) {
                e.printStackTrace();
            }

            @Override
            public void onNext(Modular3Vo compositeVo) {
                if (compositeVo.M0 == 0) {
                    M0++;
                } else if (compositeVo.M1== 0) {
                    M1++;
                } else if (compositeVo.M2 == 0) {
                    M2++;
                }
            }
        });
    }
    
}
