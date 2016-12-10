package com.joye.hk6.vu;

import android.content.Context;
import android.widget.TextView;

import com.joye.basedata.executor.JobExecutor_Factory;
import com.joye.hk6.R;
import com.joye.hk6.adapter.SizeTwosAdapter;
import com.joye.hk6.adapter.UpdateItemRecyclerViewAdapter;
import com.joye.hk6.report.SizeTowsReport;
import com.joye.hk6.view.IPieChartCallback;
import com.joye.hk6.vu.base.CoordinatorLayoutToolBarImageViewRecyclerVu;
import com.joye.hk6domain.constants.Hk6EnumHelp;
import com.joye.hk6domain.vo.SizeTwosVo;

import java.util.List;

import rx.Observable;
import rx.Observer;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by xiang on 16/9/29.
 */

public class SizeTwosActivityVu extends CoordinatorLayoutToolBarImageViewRecyclerVu<SizeTwosVo> {
    private IPieChartCallback callback;
    @Override
    public void setToolbarTimeAndViewStubInflate() {
        toolbar.setTitle("半单双走势预警");
        backdrop.setImageResource(R.drawable.sizetwos);
        lableViewStub.setLayoutResource( R.layout.item_sizetwos);
        lableViewStub.inflate();
    }

    @Override
    public UpdateItemRecyclerViewAdapter getRecylerViewAdapter(Context context) {
        return new SizeTwosAdapter(context);
    }


    int SmallOdd,SmallEven,BigOdd,BigEven;
    @Override
    public void onNext(List<SizeTwosVo> SizeTwosVos) {
        super.onNext(SizeTwosVos);
        Observable.just(SizeTwosVos).subscribeOn(Schedulers.from(JobExecutor_Factory.INSTANCE.get())).subscribe(new Observer<List<SizeTwosVo>>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(List<SizeTwosVo> colorVos) {
                SizeTowsReport report=new SizeTowsReport(colorVos);
                report.BubbleSort(callback);
                report.Demarcations(callback);
            }
        });
        Observable.from(SizeTwosVos).filter(new Func1<SizeTwosVo, Boolean>() {
            @Override
            public Boolean call(SizeTwosVo compositeVo) {
                return compositeVo.getOpentimestamp() >= Hk6EnumHelp.Default2016;
            }
        }).subscribeOn(Schedulers.from(JobExecutor_Factory.INSTANCE.get())).subscribe(new Observer<SizeTwosVo>() {
            @Override
            public void onCompleted() {
                TextView.class.cast(view.findViewById(R.id.SmallOdd)).setText(view.getResources().getString(R.string.SmallOdd, SmallOdd));
                TextView.class.cast(view.findViewById(R.id.SmallEven)).setText(view.getResources().getString(R.string.SmallEven,SmallEven));
                TextView.class.cast(view.findViewById(R.id.BigOdd)).setText(view.getResources().getString(R.string.BigOdd,BigOdd));
                TextView.class.cast(view.findViewById(R.id.BigEven)).setText(view.getResources().getString(R.string.BigEven,BigEven));
            }

            @Override
            public void onError(Throwable e) {
                e.printStackTrace();
            }

            @Override
            public void onNext(SizeTwosVo compositeVo) {
                if (compositeVo.SmallEven == 0) {
                    SmallEven++;
                } else if (compositeVo.SmallOdd == 0) {
                    SmallOdd++;
                } else if (compositeVo.BigOdd == 0) {
                    BigOdd++;
                } else if (compositeVo.BigEven == 0) {
                    BigEven++;
                }
            }
        });
    }
    public void setCallback(IPieChartCallback callback) {
        this.callback = callback;
    }
}
