package com.joye.hk6.vu;

import android.content.Context;
import android.widget.TextView;

import com.joye.basedata.executor.JobExecutor_Factory;
import com.joye.hk6.R;
import com.joye.hk6.adapter.OddEvenAdapter;
import com.joye.hk6.adapter.SizeAdapter;
import com.joye.hk6.adapter.UpdateItemRecyclerViewAdapter;
import com.joye.hk6.report.OddEvenReport;
import com.joye.hk6.report.SizeReport;
import com.joye.hk6.view.IPieChartCallback;
import com.joye.hk6.vu.base.CoordinatorLayoutToolBarImageViewRecyclerVu;
import com.joye.hk6domain.constants.Hk6EnumHelp;
import com.joye.hk6domain.vo.OddEvenVo;

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
public class OddEvenActivityVu extends CoordinatorLayoutToolBarImageViewRecyclerVu<OddEvenVo> {


    private IPieChartCallback callback;

    @Override
    public void setToolbarTimeAndViewStubInflate() {
        toolbar.setTitle("单双走势预警");
        backdrop.setImageResource(R.drawable.oddeven);
        lableViewStub.setLayoutResource(R.layout.item_size);
        lableViewStub.inflate();
    }

    @Override
    public UpdateItemRecyclerViewAdapter getRecylerViewAdapter(Context context) {
        return new OddEvenAdapter(context);
    }

    int Odd, Even;

    private Func1<OddEvenVo,Boolean> filterFunc1=new Func1<OddEvenVo, Boolean>() {
        @Override
        public Boolean call(OddEvenVo colorVo) {
            return colorVo.getOpentimestamp() >= Hk6EnumHelp.Default2016;
        }
    };
    private Func1<List<OddEvenVo>,List<OddEvenVo>> mapFunc1=new Func1<List<OddEvenVo>, List<OddEvenVo>>() {
        @Override
        public List<OddEvenVo> call(List<OddEvenVo> colorVos) {
            List<OddEvenVo> colors=new ArrayList<>();
            for (int i = 0; i < colorVos.size(); i++) {
                if(colorVos.get(i).getOpentimestamp()<=Hk6EnumHelp.Default2016){
                    colors.add(colorVos.get(i));
                }
            }
            return colors;
        }
    };

    @Override
    public void onNext(List<OddEvenVo> chineseZodiacVos) {
        super.onNext(chineseZodiacVos);
        Observable.just(chineseZodiacVos).subscribeOn(Schedulers.from(JobExecutor_Factory.INSTANCE.get())).subscribe(new Observer<List<OddEvenVo>>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(List<OddEvenVo> OddEvenVos) {
                OddEvenReport report= new OddEvenReport(OddEvenVos);
                report.BubbleSort(callback);
                report.Demarcations(callback);
            }
        });

        Observable.from(chineseZodiacVos).filter(filterFunc1).subscribeOn(Schedulers.from(JobExecutor_Factory.INSTANCE.get())).subscribe(new Observer<OddEvenVo>() {
            @Override
            public void onCompleted() {
                TextView.class.cast(view.findViewById(R.id.report_left_Big)).setText(view.getResources().getString(R.string.even, Even));
                TextView.class.cast(view.findViewById(R.id.report_left_Small)).setText(view.getResources().getString(R.string.odd, Odd));
            }

            @Override
            public void onError(Throwable e) {
                e.printStackTrace();
            }

            @Override
            public void onNext(OddEvenVo compositeVo) {
                if (compositeVo.Odd == 0) {
                    Odd++;
                } else if (compositeVo.Even == 0) {
                    Even++;
                }
            }
        });
    }

    public void setCallback(IPieChartCallback callback) {
        this.callback = callback;
    }
}
