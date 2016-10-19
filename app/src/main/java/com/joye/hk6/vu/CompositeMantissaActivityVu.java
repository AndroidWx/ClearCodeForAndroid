package com.joye.hk6.vu;

import android.content.Context;
import android.widget.TextView;

import com.joye.basedata.executor.JobExecutor_Factory;
import com.joye.hk6.R;
import com.joye.hk6.adapter.CompositeMantissaAdapter;
import com.joye.hk6.adapter.UpdateItemRecyclerViewAdapter;
import com.joye.hk6.vu.base.CoordinatorLayoutToolBarImageViewRecyclerVu;
import com.joye.hk6domain.constants.Hk6EnumHelp;
import com.joye.hk6domain.vo.CompositeMantissaVo;
import com.joye.hk6domain.vo.CompositeMantissaVo;

import java.util.List;

import rx.Observable;
import rx.Observer;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by xiang on 16/9/29.
 */

public class CompositeMantissaActivityVu extends CoordinatorLayoutToolBarImageViewRecyclerVu<CompositeMantissaVo> {
    @Override
    public void setToolbarTimeAndViewStubInflate() {
        toolbar.setTitle("合尾走势预警");
        backdrop.setImageResource(R.drawable.compositemantissa);
        lableViewStub.setLayoutResource( R.layout.item_composite_mantissa);
        lableViewStub.inflate();
    }

    @Override
    public UpdateItemRecyclerViewAdapter getRecylerViewAdapter(Context context) {
        return new CompositeMantissaAdapter(context);
    }

    int composite0,composite1, composite2, composite3, composite4, composite5;
      int composite6, composite7, composite8, composite9;
    @Override
    public void onNext(List<CompositeMantissaVo> CompositeMantissaVos) {
        super.onNext(CompositeMantissaVos);
        Observable.from(CompositeMantissaVos).filter(new Func1<CompositeMantissaVo, Boolean>() {
            @Override
            public Boolean call(CompositeMantissaVo compositeVo) {
                return compositeVo.getOpentimestamp() >= Hk6EnumHelp.Default2016;
            }
        }).subscribeOn(Schedulers.from(JobExecutor_Factory.INSTANCE.get())).subscribe(new Observer<CompositeMantissaVo>() {
            @Override
            public void onCompleted() {
                TextView.class.cast(view.findViewById(R.id.report_left_composite_0)).setText(view.getResources().getString(R.string.compositeMantissa0, composite0));
                TextView.class.cast(view.findViewById(R.id.report_left_composite_1)).setText(view.getResources().getString(R.string.compositeMantissa1,composite1));
                TextView.class.cast(view.findViewById(R.id.report_left_composite_2)).setText(view.getResources().getString(R.string.compositeMantissa2,composite2));
                TextView.class.cast(view.findViewById(R.id.report_left_composite_3)).setText(view.getResources().getString(R.string.compositeMantissa3,composite3));
                TextView.class.cast(view.findViewById(R.id.report_left_composite_4)).setText(view.getResources().getString(R.string.compositeMantissa4,composite4));
                TextView.class.cast(view.findViewById(R.id.report_left_composite_5)).setText(view.getResources().getString(R.string.compositeMantissa5,composite5));
                TextView.class.cast(view.findViewById(R.id.report_left_composite_6)).setText(view.getResources().getString(R.string.compositeMantissa6,composite6));
                TextView.class.cast(view.findViewById(R.id.report_left_composite_7)).setText(view.getResources().getString(R.string.compositeMantissa7,composite7));
                TextView.class.cast(view.findViewById(R.id.report_left_composite_8)).setText(view.getResources().getString(R.string.compositeMantissa8,composite8));
                TextView.class.cast(view.findViewById(R.id.report_left_composite_9)).setText(view.getResources().getString(R.string.compositeMantissa9,composite9));
            }

            @Override
            public void onError(Throwable e) {
                e.printStackTrace();
            }

            @Override
            public void onNext(CompositeMantissaVo compositeVo) {
                if (compositeVo.composite0 == 0) {
                    composite0++;
                } else if (compositeVo.composite1 == 0) {
                    composite1++;
                } else if (compositeVo.composite2 == 0) {
                    composite2++;
                } else if (compositeVo.composite3 == 0) {
                    composite3++;
                } else if (compositeVo.composite4 == 0) {
                    composite4++;
                } else if (compositeVo.composite5 == 0) {
                    composite5++;
                } else if (compositeVo.composite6 == 0) {
                    composite6++;
                } else if (compositeVo.composite7 == 0) {
                    composite7++;
                } else if (compositeVo.composite8 == 0) {
                    composite8++;
                } else if (compositeVo.composite9 == 0) {
                    composite9++;
                }
            }
        });
    }
}
