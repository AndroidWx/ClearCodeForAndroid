package com.joye.hk6.vu;

import android.content.Context;
import android.widget.TextView;

import com.joye.basedata.executor.JobExecutor_Factory;
import com.joye.hk6.R;
import com.joye.hk6.adapter.CompositeSizeAdapter;
import com.joye.hk6.adapter.UpdateItemRecyclerViewAdapter;
import com.joye.hk6.report.CompositeSizeReport;
import com.joye.hk6.vu.base.CoordinatorLayoutToolBarImageViewRecyclerVu;
import com.joye.hk6domain.constants.Hk6EnumHelp;
import com.joye.hk6domain.vo.CompositeSizeVo;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;
import rx.Observer;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by xiang on 16/9/29.
 */

public class CompositeSizeActivityVu extends CoordinatorLayoutToolBarImageViewRecyclerVu<CompositeSizeVo> {
    @Override
    public void setToolbarTimeAndViewStubInflate() {
        toolbar.setTitle("合数大小走势预警");
        backdrop.setImageResource(R.drawable.compositesize);
        lableViewStub.setLayoutResource( R.layout.item_compositesize);
        lableViewStub.inflate();
    }

    @Override
    public UpdateItemRecyclerViewAdapter getRecylerViewAdapter(Context context) {
        return new CompositeSizeAdapter(context);
    }
    int Big,Small;

    private Func1<CompositeSizeVo,Boolean> filterFunc1=new Func1<CompositeSizeVo, Boolean>() {
        @Override
        public Boolean call(CompositeSizeVo CompositeSizeVo) {
            return CompositeSizeVo.getOpentimestamp() >= Hk6EnumHelp.Default2016;
        }
    };
    private Func1<List<CompositeSizeVo>,List<CompositeSizeVo>> mapFunc1=new Func1<List<CompositeSizeVo>, List<CompositeSizeVo>>() {
        @Override
        public List<CompositeSizeVo> call(List<CompositeSizeVo> CompositeSizeVos) {
            List<CompositeSizeVo> colors=new ArrayList<>();
            for (int i = 0; i < CompositeSizeVos.size(); i++) {
                if(CompositeSizeVos.get(i).getOpentimestamp()<=Hk6EnumHelp.Default2016){
                    colors.add(CompositeSizeVos.get(i));
                }
            }
            return colors;
        }
    };



    @Override
    public void onNext(List<CompositeSizeVo> chineseZodiacVos) {
        super.onNext(chineseZodiacVos);
        Observable.just(chineseZodiacVos).subscribeOn(Schedulers.from(JobExecutor_Factory.INSTANCE.get())).subscribe(new Observer<List<CompositeSizeVo>>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(List<CompositeSizeVo> CompositeSizeVos) {
                CompositeSizeReport report=new CompositeSizeReport(CompositeSizeVos);
                report.BubbleSort(callback);
                report.Demarcations(callback);
            }
        });

        Observable.from(chineseZodiacVos).filter(filterFunc1).subscribeOn(Schedulers.from(JobExecutor_Factory.INSTANCE.get())).subscribe(new Observer<CompositeSizeVo>() {
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
            public void onNext(CompositeSizeVo compositeVo) {
                if (compositeVo.Big == 0) {
                    Big++;
                } else if (compositeVo.Small == 0) {
                    Small++;
                }
            }
        });
    }

}
