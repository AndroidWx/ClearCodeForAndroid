package com.joye.hk6.vu;

import android.content.Context;
import android.widget.TextView;

import com.joye.basedata.executor.JobExecutor_Factory;
import com.joye.hk6.R;
import com.joye.hk6.adapter.SizeAdapter;
import com.joye.hk6.adapter.UpdateItemRecyclerViewAdapter;
import com.joye.hk6.report.SizeReport;
import com.joye.hk6.view.IPieChartCallback;
import com.joye.hk6.vu.base.CoordinatorLayoutToolBarImageViewRecyclerVu;
import com.joye.hk6domain.constants.Hk6EnumHelp;
import com.joye.hk6domain.vo.SizeVo;

import java.util.ArrayList;
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
public class SizeActivityVu extends CoordinatorLayoutToolBarImageViewRecyclerVu<SizeVo> {


    private IPieChartCallback callback;

    @Override
    public void setToolbarTimeAndViewStubInflate() {
        toolbar.setTitle("大小走势预警");
        backdrop.setImageResource(R.drawable.size);
        lableViewStub.setLayoutResource(R.layout.item_size);
        lableViewStub.inflate();
    }

    @Override
    public UpdateItemRecyclerViewAdapter getRecylerViewAdapter(Context context) {
        return new SizeAdapter(context);
    }

    int Small,Big;

    private Func1<SizeVo,Boolean> filterFunc1=new Func1<SizeVo, Boolean>() {
        @Override
        public Boolean call(SizeVo colorVo) {
            return colorVo.getOpentimestamp() >= Hk6EnumHelp.Default2016;
        }
    };
    private Func1<List<SizeVo>,List<SizeVo>> mapFunc1=new Func1<List<SizeVo>, List<SizeVo>>() {
        @Override
        public List<SizeVo> call(List<SizeVo> colorVos) {
            List<SizeVo> colors=new ArrayList<>();
            for (int i = 0; i < colorVos.size(); i++) {
                if(colorVos.get(i).getOpentimestamp()<=Hk6EnumHelp.Default2016){
                    colors.add(colorVos.get(i));
                }
            }
            return colors;
        }
    };

    @Override
    public void onNext(List<SizeVo> chineseZodiacVos) {
        super.onNext(chineseZodiacVos);
        Observable.just(chineseZodiacVos).subscribeOn(Schedulers.from(JobExecutor_Factory.INSTANCE.get())).subscribe(new Observer<List<SizeVo>>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(List<SizeVo> sizeVos) {
                new SizeReport(sizeVos).BubbleSort(callback);
            }
        });

        Observable.from(chineseZodiacVos).filter(filterFunc1).subscribeOn(Schedulers.from(JobExecutor_Factory.INSTANCE.get())).subscribe(new Observer<SizeVo>() {
            @Override
            public void onCompleted() {
                TextView.class.cast(view.findViewById(R.id.report_left_Big)).setText(view.getResources().getString(R.string.big, Big));
                TextView.class.cast(view.findViewById(R.id.report_left_Small)).setText(view.getResources().getString(R.string.small, Small));
            }

            @Override
            public void onError(Throwable e) {
                e.printStackTrace();
            }

            @Override
            public void onNext(SizeVo compositeVo) {
                if (compositeVo.Small == 0) {
                    Small++;
                } else if (compositeVo.Big == 0) {
                    Big++;
                }
            }
        });
    }

    public void setCallback(IPieChartCallback callback) {
        this.callback = callback;
    }
}
