package com.joye.hk6.vu;

import android.content.Context;
import android.widget.TextView;

import com.joye.basedata.executor.JobExecutor_Factory;
import com.joye.hk6.R;
import com.joye.hk6.adapter.MantissaAdapter;
import com.joye.hk6.adapter.UpdateItemRecyclerViewAdapter;
import com.joye.hk6.vu.base.CoordinatorLayoutToolBarImageViewRecyclerVu;
import com.joye.hk6domain.constants.Hk6EnumHelp;
import com.joye.hk6domain.vo.MantissaVo;
import com.joye.hk6domain.vo.MantissaVo;

import java.util.List;

import rx.Observable;
import rx.Observer;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by xiang on 16/9/29.
 */

public class MantissaActivityVu extends CoordinatorLayoutToolBarImageViewRecyclerVu<MantissaVo> {
    @Override
    public void setToolbarTimeAndViewStubInflate() {
        toolbar.setTitle("尾数走势预警");
        backdrop.setImageResource(R.drawable.mantissa);
        lableViewStub.setLayoutResource( R.layout.item_mantissa);
        lableViewStub.inflate();
    }

    @Override
    public UpdateItemRecyclerViewAdapter getRecylerViewAdapter(Context context) {
        return new MantissaAdapter(context);
    }

    int Mantissa0, Mantissa1, Mantissa2, Mantissa3, Mantissa4,Mantissa5,Mantissa6,Mantissa7,Mantissa8,Mantissa9;
    @Override
    public void onNext(List<MantissaVo> MantissaVos) {
        super.onNext(MantissaVos);
        Observable.from(MantissaVos).filter(new Func1<MantissaVo, Boolean>() {
            @Override
            public Boolean call(MantissaVo compositeVo) {
                return compositeVo.getOpentimestamp() >= Hk6EnumHelp.Default2016;
            }
        }).subscribeOn(Schedulers.from(JobExecutor_Factory.INSTANCE.get())).subscribe(new Observer<MantissaVo>() {
            @Override
            public void onCompleted() {
                TextView.class.cast(view.findViewById(R.id.report_left_mantissa0)).setText(view.getResources().getString(R.string.mantissa0,Mantissa0));
                TextView.class.cast(view.findViewById(R.id.report_left_mantissa1)).setText(view.getResources().getString(R.string.mantissa1,Mantissa1));
                TextView.class.cast(view.findViewById(R.id.report_left_mantissa2)).setText(view.getResources().getString(R.string.mantissa2,Mantissa2));
                TextView.class.cast(view.findViewById(R.id.report_left_mantissa3)).setText(view.getResources().getString(R.string.mantissa3,Mantissa3));
                TextView.class.cast(view.findViewById(R.id.report_left_mantissa4)).setText(view.getResources().getString(R.string.mantissa4,Mantissa4));
                TextView.class.cast(view.findViewById(R.id.report_left_mantissa5)).setText(view.getResources().getString(R.string.mantissa5,Mantissa5));
                TextView.class.cast(view.findViewById(R.id.report_left_mantissa6)).setText(view.getResources().getString(R.string.mantissa6,Mantissa6));
                TextView.class.cast(view.findViewById(R.id.report_left_mantissa7)).setText(view.getResources().getString(R.string.mantissa7,Mantissa7));
                TextView.class.cast(view.findViewById(R.id.report_left_mantissa8)).setText(view.getResources().getString(R.string.mantissa8,Mantissa8));
                TextView.class.cast(view.findViewById(R.id.report_left_mantissa9)).setText(view.getResources().getString(R.string.mantissa9,Mantissa9));
            }

            @Override
            public void onError(Throwable e) {
                e.printStackTrace();
            }

            @Override
            public void onNext(MantissaVo compositeVo) {
                if (compositeVo.Mantissa0 == 0) {
                    Mantissa0++;
                } else if (compositeVo.Mantissa1== 0) {
                    Mantissa1++;
                } else if (compositeVo.Mantissa2 == 0) {
                    Mantissa2++;
                } else if (compositeVo.Mantissa3 == 0) {
                    Mantissa3++;
                } else if (compositeVo.Mantissa4 == 0) {
                    Mantissa4++;
                }else if (compositeVo.Mantissa5 == 0) {
                    Mantissa5++;
                } else if (compositeVo.Mantissa6== 0) {
                    Mantissa6++;
                } else if (compositeVo.Mantissa7 == 0) {
                    Mantissa7++;
                } else if (compositeVo.Mantissa8 == 0) {
                    Mantissa8++;
                } else if (compositeVo.Mantissa9 == 0) {
                    Mantissa9++;
                }
            }
        });
    }
}
