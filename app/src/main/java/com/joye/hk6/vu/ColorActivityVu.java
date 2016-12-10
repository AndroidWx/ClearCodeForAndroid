package com.joye.hk6.vu;

import android.content.Context;
import android.widget.TextView;

import com.joye.basedata.executor.JobExecutor_Factory;
import com.joye.hk6.R;
import com.joye.hk6.adapter.ColorAdapter;
import com.joye.hk6.adapter.UpdateItemRecyclerViewAdapter;
import com.joye.hk6.report.ColorReport;
import com.joye.hk6.vu.base.CoordinatorLayoutToolBarImageViewRecyclerVu;
import com.joye.hk6domain.constants.Hk6EnumHelp;
import com.joye.hk6domain.vo.ColorVo;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;
import rx.Observer;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

import static com.joye.hk6.view.ColorActivity.PICRESID;
import static com.joye.hk6.view.ColorActivity.TITLE;

/**
 * Created by xiang on 16/9/29.
 */

public class ColorActivityVu extends CoordinatorLayoutToolBarImageViewRecyclerVu<ColorVo> {



    @Override
    public void setToolbarTimeAndViewStubInflate() {
        toolbar.setTitle(TITLE);
        backdrop.setImageResource(PICRESID);
        lableViewStub.setLayoutResource(R.layout.item_color);
        lableViewStub.inflate();
    }

    @Override
    public UpdateItemRecyclerViewAdapter getRecylerViewAdapter(Context context) {
        return new ColorAdapter(context);
    }
    int Red,Blue,Green;

    private Func1<ColorVo,Boolean> filterFunc1=new Func1<ColorVo, Boolean>() {
        @Override
        public Boolean call(ColorVo colorVo) {
            return colorVo.getOpentimestamp() >= Hk6EnumHelp.Default2016;
        }
    };
    private Func1<List<ColorVo>,List<ColorVo>> mapFunc1=new Func1<List<ColorVo>, List<ColorVo>>() {
        @Override
        public List<ColorVo> call(List<ColorVo> colorVos) {
            List<ColorVo> colors=new ArrayList<>();
            for (int i = 0; i < colorVos.size(); i++) {
                if(colorVos.get(i).getOpentimestamp()<=Hk6EnumHelp.Default2016){
                    colors.add(colorVos.get(i));
                }
            }
            return colors;
        }
    };



    @Override
    public void onNext(List<ColorVo> chineseZodiacVos) {
        super.onNext(chineseZodiacVos);
        Observable.just(chineseZodiacVos).subscribeOn(Schedulers.from(JobExecutor_Factory.INSTANCE.get())).subscribe(new Observer<List<ColorVo>>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(List<ColorVo> colorVos) {
                ColorReport report=new ColorReport(colorVos);
                report.BubbleSort(callback);
                report.Demarcations(callback);
            }
        });

        Observable.from(chineseZodiacVos).filter(filterFunc1).subscribeOn(Schedulers.from(JobExecutor_Factory.INSTANCE.get())).subscribe(new Observer<ColorVo>() {
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
