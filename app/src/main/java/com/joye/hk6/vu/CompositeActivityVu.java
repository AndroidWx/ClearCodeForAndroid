package com.joye.hk6.vu;

import android.content.Context;
import android.widget.TextView;

import com.joye.basedata.executor.JobExecutor_Factory;
import com.joye.hk6.R;
import com.joye.hk6.adapter.CompositeAdapter;
import com.joye.hk6.adapter.UpdateItemRecyclerViewAdapter;
import com.joye.hk6.report.CompositeReport;
import com.joye.hk6.vu.base.CoordinatorLayoutToolBarImageViewRecyclerVu;
import com.joye.hk6domain.constants.Hk6EnumHelp;
import com.joye.hk6domain.vo.CompositeVo;

import java.util.List;

import rx.Observable;
import rx.Observer;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by xiang on 16/9/29.
 */

public class CompositeActivityVu extends CoordinatorLayoutToolBarImageViewRecyclerVu<CompositeVo> {


    @Override
    public void setToolbarTimeAndViewStubInflate() {
        toolbar.setTitle("合数走势预警");
        backdrop.setImageResource(R.drawable.composite);
        lableViewStub.setLayoutResource(R.layout.item_composite);
        lableViewStub.inflate();
    }

    @Override
    public UpdateItemRecyclerViewAdapter getRecylerViewAdapter(Context context) {
        return new CompositeAdapter(context);
    }

    int composite1 = 0, composite2 = 0, composite3 = 0, composite4 = 0, composite5 = 0;
    int composite6 = 0, composite7 = 0, composite8 = 0, composite9 = 0, composite10 = 0;
    int composite11 = 0, composite12 = 0, composite13 = 0;

    @Override
    public void onNext(List<CompositeVo> chineseZodiacVos) {
        super.onNext(chineseZodiacVos);
        Observable.just(chineseZodiacVos).subscribeOn(Schedulers.from(JobExecutor_Factory.INSTANCE.get())).subscribe(new Observer<List<CompositeVo>>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(List<CompositeVo> colorVos) {
                CompositeReport report = new CompositeReport(colorVos);
                report.BubbleSort(callback);
                report.Demarcations(callback);
            }
        });

        Observable.from(chineseZodiacVos).filter(new Func1<CompositeVo, Boolean>() {
            @Override
            public Boolean call(CompositeVo compositeVo) {
                return compositeVo.getOpentimestamp() >= Hk6EnumHelp.Default2016;
            }
        }).subscribeOn(Schedulers.from(JobExecutor_Factory.INSTANCE.get())).subscribe(new Observer<CompositeVo>() {
            @Override
            public void onCompleted() {
                TextView.class.cast(view.findViewById(R.id.report_left_composite_1)).setText(view.getResources().getString(R.string.composite_1, composite1));
                TextView.class.cast(view.findViewById(R.id.report_left_composite_2)).setText(view.getResources().getString(R.string.composite_2, composite2));
                TextView.class.cast(view.findViewById(R.id.report_left_composite_3)).setText(view.getResources().getString(R.string.composite_3, composite3));
                TextView.class.cast(view.findViewById(R.id.report_left_composite_4)).setText(view.getResources().getString(R.string.composite_4, composite4));
                TextView.class.cast(view.findViewById(R.id.report_left_composite_5)).setText(view.getResources().getString(R.string.composite_5, composite5));
                TextView.class.cast(view.findViewById(R.id.report_left_composite_6)).setText(view.getResources().getString(R.string.composite_6, composite6));
                TextView.class.cast(view.findViewById(R.id.report_left_composite_7)).setText(view.getResources().getString(R.string.composite_7, composite7));
                TextView.class.cast(view.findViewById(R.id.report_left_composite_8)).setText(view.getResources().getString(R.string.composite_8, composite8));
                TextView.class.cast(view.findViewById(R.id.report_left_composite_9)).setText(view.getResources().getString(R.string.composite_9, composite9));
                TextView.class.cast(view.findViewById(R.id.report_left_composite_10)).setText(view.getResources().getString(R.string.composite_10, composite10));
                TextView.class.cast(view.findViewById(R.id.report_left_composite_11)).setText(view.getResources().getString(R.string.composite_11, composite11));
                TextView.class.cast(view.findViewById(R.id.report_left_composite_12)).setText(view.getResources().getString(R.string.composite_12, composite12));
                TextView.class.cast(view.findViewById(R.id.report_left_composite_13)).setText(view.getResources().getString(R.string.composite_13, composite13));
            }

            @Override
            public void onError(Throwable e) {
                e.printStackTrace();
            }

            @Override
            public void onNext(CompositeVo compositeVo) {
                if (compositeVo.composite1 == 0) {
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
                } else if (compositeVo.composite10 == 0) {
                    composite10++;
                } else if (compositeVo.composite11 == 0) {
                    composite11++;
                } else if (compositeVo.composite12 == 0) {
                    composite12++;
                } else if (compositeVo.composite13 == 0) {
                    composite13++;
                }
            }
        });
    }
}
