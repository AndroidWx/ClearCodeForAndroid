package com.joye.hk6.vu;

import android.content.Context;
import android.widget.TextView;

import com.joye.basedata.executor.JobExecutor_Factory;
import com.joye.hk6.R;
import com.joye.hk6.adapter.GateCountAdapter;
import com.joye.hk6.adapter.UpdateItemRecyclerViewAdapter;
import com.joye.hk6.vu.base.CoordinatorLayoutToolBarImageViewRecyclerVu;
import com.joye.hk6domain.constants.Hk6EnumHelp;
import com.joye.hk6domain.vo.GateCountVo;
import com.joye.hk6domain.vo.GateCountVo;

import java.util.List;

import rx.Observable;
import rx.Observer;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by xiang on 16/9/29.
 */

public class GateCountActivityVu extends CoordinatorLayoutToolBarImageViewRecyclerVu<GateCountVo> {
    @Override
    public void setToolbarTimeAndViewStubInflate() {
        toolbar.setTitle("门数走势预警");
        backdrop.setImageResource(R.drawable.gatecount);
        lableViewStub.setLayoutResource( R.layout.item_gatecount);
        lableViewStub.inflate();
    }

    @Override
    public UpdateItemRecyclerViewAdapter getRecylerViewAdapter(Context context) {
        return new GateCountAdapter(context);
    }

   int  gateCount1, gateCount2, gateCount3, gateCount4,gateCount5;
    @Override
    public void onNext(List<GateCountVo> GateCountVos) {
        super.onNext(GateCountVos);
        Observable.from(GateCountVos).filter(new Func1<GateCountVo, Boolean>() {
            @Override
            public Boolean call(GateCountVo compositeVo) {
                return compositeVo.getOpentimestamp() >= Hk6EnumHelp.Default2016;
            }
        }).subscribeOn(Schedulers.from(JobExecutor_Factory.INSTANCE.get())).subscribe(new Observer<GateCountVo>() {
            @Override
            public void onCompleted() {
                TextView.class.cast(view.findViewById(R.id.report_left_gateCount1)).setText(view.getResources().getString(R.string.gateCount1,gateCount1));
                TextView.class.cast(view.findViewById(R.id.report_left_gateCount2)).setText(view.getResources().getString(R.string.gateCount2,gateCount2));
                TextView.class.cast(view.findViewById(R.id.report_left_gateCount3)).setText(view.getResources().getString(R.string.gateCount3,gateCount3));
                TextView.class.cast(view.findViewById(R.id.report_left_gateCount4)).setText(view.getResources().getString(R.string.gateCount4,gateCount4));
                TextView.class.cast(view.findViewById(R.id.report_left_gateCount5)).setText(view.getResources().getString(R.string.gateCount5,gateCount5));
            }

            @Override
            public void onError(Throwable e) {
                e.printStackTrace();
            }

            @Override
            public void onNext(GateCountVo compositeVo) {
                if (compositeVo.gateCount1 == 0) {
                    gateCount1++;
                } else if (compositeVo.gateCount2== 0) {
                    gateCount2++;
                } else if (compositeVo.gateCount3 == 0) {
                    gateCount3++;
                } else if (compositeVo.gateCount4 == 0) {
                    gateCount4++;
                } else if (compositeVo.gateCount5 == 0) {
                    gateCount5++;
                }
            }
        });
    }
}
