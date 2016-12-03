package com.joye.hk6.vu;

import android.content.Context;
import android.widget.TextView;

import com.joye.basedata.executor.JobExecutor_Factory;
import com.joye.hk6.R;
import com.joye.hk6.adapter.MantissaSizeAdapter;
import com.joye.hk6.adapter.UpdateItemRecyclerViewAdapter;
import com.joye.hk6.report.MantissaSizeReport;
import com.joye.hk6.vu.base.CoordinatorLayoutToolBarImageViewRecyclerVu;
import com.joye.hk6domain.constants.Hk6EnumHelp;
import com.joye.hk6domain.vo.MantissaSizeVo;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;
import rx.Observer;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by xiang on 16/9/29.
 */

public class MantissaSizeActivityVu extends CoordinatorLayoutToolBarImageViewRecyclerVu<MantissaSizeVo> {
    @Override
    public void setToolbarTimeAndViewStubInflate() {
        toolbar.setTitle("尾数大小走势预警");
        backdrop.setImageResource(R.drawable.mantissasize);
        lableViewStub.setLayoutResource( R.layout.item_mantissasize);
        lableViewStub.inflate();
    }

    @Override
    public UpdateItemRecyclerViewAdapter getRecylerViewAdapter(Context context) {
        return new MantissaSizeAdapter(context);
    }
    int Big,Small;

    private Func1<MantissaSizeVo,Boolean> filterFunc1=new Func1<MantissaSizeVo, Boolean>() {
        @Override
        public Boolean call(MantissaSizeVo MantissaSizeVo) {
            return MantissaSizeVo.getOpentimestamp() >= Hk6EnumHelp.Default2016;
        }
    };
    private Func1<List<MantissaSizeVo>,List<MantissaSizeVo>> mapFunc1=new Func1<List<MantissaSizeVo>, List<MantissaSizeVo>>() {
        @Override
        public List<MantissaSizeVo> call(List<MantissaSizeVo> MantissaSizeVos) {
            List<MantissaSizeVo> colors=new ArrayList<>();
            for (int i = 0; i < MantissaSizeVos.size(); i++) {
                if(MantissaSizeVos.get(i).getOpentimestamp()<=Hk6EnumHelp.Default2016){
                    colors.add(MantissaSizeVos.get(i));
                }
            }
            return colors;
        }
    };



    @Override
    public void onNext(List<MantissaSizeVo> chineseZodiacVos) {
        super.onNext(chineseZodiacVos);
        Observable.just(chineseZodiacVos).subscribeOn(Schedulers.from(JobExecutor_Factory.INSTANCE.get())).subscribe(new Observer<List<MantissaSizeVo>>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(List<MantissaSizeVo> MantissaSizeVos) {
                new MantissaSizeReport(MantissaSizeVos).BubbleSort(callback);
            }
        });

        Observable.from(chineseZodiacVos).filter(filterFunc1).subscribeOn(Schedulers.from(JobExecutor_Factory.INSTANCE.get())).subscribe(new Observer<MantissaSizeVo>() {
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
            public void onNext(MantissaSizeVo compositeVo) {
                if (compositeVo.Big == 0) {
                    Big++;
                } else if (compositeVo.Small == 0) {
                    Small++;
                }
            }
        });
    }

}
