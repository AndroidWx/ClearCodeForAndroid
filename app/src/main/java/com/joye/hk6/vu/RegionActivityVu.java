package com.joye.hk6.vu;

import android.widget.TextView;

import com.joye.basedata.executor.JobExecutor_Factory;
import com.joye.hk6.R;
import com.joye.hk6.vu.base.CoordinatorLayoutToolBarImageViewRecyclerVu;
import com.joye.hk6domain.constants.Hk6EnumHelp;
import com.joye.hk6domain.vo.RegionVo;

import java.util.List;

import rx.Observable;
import rx.Observer;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by W,x (JoyeWang)
 * on 2016/9/29.
 * 304622254@qq.com
 * Remeark:
 */
public class RegionActivityVu extends CoordinatorLayoutToolBarImageViewRecyclerVu<RegionVo> {

    int One, Two, Three, Four, Five, Sex, Seven;
    @Override
    public void setToolbarTimeAndViewStubInflate() {
        toolbar.setTitle("段位走势预警");
        lableViewStub.setLayoutResource(R.layout.item_region);
        lableViewStub.inflate();
    }
    @Override
    public void onNext(List<RegionVo> chineseZodiacVos) {
        super.onNext(chineseZodiacVos);
        Observable.from(chineseZodiacVos).filter(new Func1<RegionVo, Boolean>() {
            @Override
            public Boolean call(RegionVo compositeVo) {
                return compositeVo.getOpentimestamp() >= Hk6EnumHelp.Default2016;
            }
        }).subscribeOn(Schedulers.from(JobExecutor_Factory.INSTANCE.get())).subscribe(new Observer<RegionVo>() {
            @Override
            public void onCompleted() {
                TextView.class.cast(view.findViewById(R.id.report_left_Region1)).setText(view.getResources().getString(R.string.region_1,One));
                TextView.class.cast(view.findViewById(R.id.report_left_Region2)).setText(view.getResources().getString(R.string.region_2,Two));
                TextView.class.cast(view.findViewById(R.id.report_left_Region3)).setText(view.getResources().getString(R.string.region_3,Three));
                TextView.class.cast(view.findViewById(R.id.report_left_Region4)).setText(view.getResources().getString(R.string.region_4,Four));
                TextView.class.cast(view.findViewById(R.id.report_left_Region5)).setText(view.getResources().getString(R.string.region_5,Five));
                TextView.class.cast(view.findViewById(R.id.report_left_Region6)).setText(view.getResources().getString(R.string.region_6,Sex));
                TextView.class.cast(view.findViewById(R.id.report_left_Region7)).setText(view.getResources().getString(R.string.region_7,Seven));
            }

            @Override
            public void onError(Throwable e) {
                e.printStackTrace();
            }

            @Override
            public void onNext(RegionVo compositeVo) {
                if (compositeVo.One == 0) {
                    One++;
                } else if (compositeVo.Two == 0) {
                    Two++;
                } else if (compositeVo.Three == 0) {
                    Three++;
                } else if (compositeVo.Four == 0) {
                    Four++;
                } else if (compositeVo.Five == 0) {
                    Five++;
                } else if (compositeVo.Sex == 0) {
                    Sex++;
                } else if (compositeVo.Seven == 0) {
                    Seven++;
                }
            }
        });
    }
}
