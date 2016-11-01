package com.joye.hk6.vu;

import android.content.Context;
import android.widget.TextView;

import com.joye.basedata.executor.JobExecutor_Factory;
import com.joye.hk6.R;
import com.joye.hk6.adapter.ColorTwosAdapter;
import com.joye.hk6.adapter.UpdateItemRecyclerViewAdapter;
import com.joye.hk6.vu.base.CoordinatorLayoutToolBarImageViewRecyclerVu;
import com.joye.hk6domain.constants.Hk6EnumHelp;
import com.joye.hk6domain.vo.ColorTwosVo;
import com.joye.hk6domain.vo.ColorTwosVo;

import java.util.List;

import rx.Observable;
import rx.Observer;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by xiang on 16/9/29.
 */

public class ColorTwosActivityVu extends CoordinatorLayoutToolBarImageViewRecyclerVu<ColorTwosVo> {
    @Override
    public void setToolbarTimeAndViewStubInflate() {
        toolbar.setTitle("半波走势预警");
        backdrop.setImageResource(R.drawable.colortwos);
        lableViewStub.setLayoutResource( R.layout.item_colortwos);
        lableViewStub.inflate();
    }

    @Override
    public UpdateItemRecyclerViewAdapter getRecylerViewAdapter(Context context) {
        return new ColorTwosAdapter(context);
    }
    int redEven, redOdd, blueEven, blueOdd, greenEven, greenOdd;

    @Override
    public void onNext(List<ColorTwosVo> ColorTwosVos) {
        super.onNext(ColorTwosVos);
        Observable.from(ColorTwosVos).filter(new Func1<ColorTwosVo, Boolean>() {
            @Override
            public Boolean call(ColorTwosVo compositeVo) {
                return compositeVo.getOpentimestamp() >= Hk6EnumHelp.Default2016;
            }
        }).subscribeOn(Schedulers.from(JobExecutor_Factory.INSTANCE.get())).subscribe(new Observer<ColorTwosVo>() {
            @Override
            public void onCompleted() {
                TextView.class.cast(view.findViewById(R.id.report_left_redEven)).setText(view.getResources().getString(R.string.redEven,redEven));
                TextView.class.cast(view.findViewById(R.id.report_left_redOdd)).setText(view.getResources().getString(R.string.redOdd,redOdd));
                TextView.class.cast(view.findViewById(R.id.report_left_blueOdd)).setText(view.getResources().getString(R.string.blueOdd,blueOdd));
                TextView.class.cast(view.findViewById(R.id.report_left_blueEven)).setText(view.getResources().getString(R.string.blueEven,blueEven));
                TextView.class.cast(view.findViewById(R.id.report_left_greenEven)).setText(view.getResources().getString(R.string.greenEven,greenEven));
                TextView.class.cast(view.findViewById(R.id.report_left_greenOdd)).setText(view.getResources().getString(R.string.greenOdd,greenOdd));
            }

            @Override
            public void onError(Throwable e) {
                e.printStackTrace();
            }
            @Override
            public void onNext(ColorTwosVo compositeVo) {
                if (compositeVo.redEven == 0) {
                    redEven++;
                } else if (compositeVo.redOdd == 0) {
                    redOdd++;
                } else if (compositeVo.blueOdd == 0) {
                    blueOdd++;
                } else if (compositeVo.blueEven == 0) {
                    blueEven++;
                } else if (compositeVo.greenEven == 0) {
                    greenEven++;
                } else if (compositeVo.greenOdd == 0) {
                    greenOdd++;
                }
            }
        });
    }
}
