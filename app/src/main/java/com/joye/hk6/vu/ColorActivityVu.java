package com.joye.hk6.vu;

import android.content.Context;
import android.widget.TextView;

import com.joye.basedata.executor.JobExecutor_Factory;
import com.joye.hk6.R;
import com.joye.hk6.adapter.ColorAdapter;
import com.joye.hk6.adapter.UpdateItemRecyclerViewAdapter;
import com.joye.hk6.vu.base.CoordinatorLayoutToolBarImageViewRecyclerVu;
import com.joye.hk6domain.constants.Hk6EnumHelp;
import com.joye.hk6domain.vo.ChineseZodiacVo;
import com.joye.hk6domain.vo.ColorVo;
import com.joye.layouts.BorderTextView;

import java.util.List;

import butterknife.BindView;
import rx.Observable;
import rx.Observer;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by xiang on 16/9/29.
 */

public class ColorActivityVu extends CoordinatorLayoutToolBarImageViewRecyclerVu<ColorVo> {

    @Override
    public void setToolbarTimeAndViewStubInflate() {
        toolbar.setTitle("波色走势预警");
        backdrop.setImageResource(R.drawable.color);
        lableViewStub.setLayoutResource(R.layout.item_color);
        lableViewStub.inflate();
    }

    @Override
    public UpdateItemRecyclerViewAdapter getRecylerViewAdapter(Context context) {
        return new ColorAdapter(context);
    }
    int Red,Blue,Green;
    @Override
    public void onNext(List<ColorVo> chineseZodiacVos) {
        super.onNext(chineseZodiacVos);
        Observable.from(chineseZodiacVos).filter(new Func1<ColorVo, Boolean>() {
            @Override
            public Boolean call(ColorVo compositeVo) {
                return compositeVo.getOpentimestamp() >= Hk6EnumHelp.Default2016;
            }
        }).subscribeOn(Schedulers.from(JobExecutor_Factory.INSTANCE.get())).subscribe(new Observer<ColorVo>() {
            @Override
            public void onCompleted() {
                TextView.class.cast(view.findViewById(R.id.Red)).setText(view.getResources().getString(R.string.red, Red));
                TextView.class.cast(view.findViewById(R.id.Blue)).setText(view.getResources().getString(R.string.blue, Blue));
                TextView.class.cast(view.findViewById(R.id.Green)).setText(view.getResources().getString(R.string.green, Green));
            }

            @Override
            public void onError(Throwable e) {
                e.printStackTrace();
            }

            @Override
            public void onNext(ColorVo compositeVo) {
                if (compositeVo.Red == 0) {
                    Red++;
                } else if (compositeVo.Blue == 0) {
                    Blue++;
                } else if (compositeVo.Green == 0) {
                    Green++;
                }
            }
        });
    }
}
