package com.joye.hk6.vu;

import android.content.Context;
import android.widget.TextView;

import com.joye.basedata.executor.JobExecutor_Factory;
import com.joye.hk6.R;
import com.joye.hk6.adapter.HeadTwosAdapter;
import com.joye.hk6.adapter.UpdateItemRecyclerViewAdapter;
import com.joye.hk6.vu.base.CoordinatorLayoutToolBarImageViewRecyclerVu;
import com.joye.hk6domain.constants.Hk6EnumHelp;
import com.joye.hk6domain.vo.HeadTwosVo;
import com.joye.hk6domain.vo.HeadTwosVo;

import java.util.List;

import rx.Observable;
import rx.Observer;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by xiang on 16/9/29.
 */

public class HeadTwosActivityVu extends CoordinatorLayoutToolBarImageViewRecyclerVu<HeadTwosVo> {
    @Override
    public void setToolbarTimeAndViewStubInflate() {
        toolbar.setTitle("头数单与双走势预警");
        backdrop.setImageResource(R.drawable.headtwos);
        lableViewStub.setLayoutResource( R.layout.item_headtows);
        lableViewStub.inflate();
    }

    @Override
    public UpdateItemRecyclerViewAdapter getRecylerViewAdapter(Context context) {
        return new HeadTwosAdapter(context);
    }



    public int HeadEven0, HeadEven1, HeadEven2, HeadEven3, HeadEven4;
    public int HeadOdd0, HeadOdd1, HeadOdd2, HeadOdd3, HeadOdd4;
    @Override
    public void onNext(List<HeadTwosVo> HeadTwosVos) {
        super.onNext(HeadTwosVos);
        Observable.from(HeadTwosVos).filter(new Func1<HeadTwosVo, Boolean>() {
            @Override
            public Boolean call(HeadTwosVo compositeVo) {
                return compositeVo.getOpentimestamp() >= Hk6EnumHelp.Default2016;
            }
        }).subscribeOn(Schedulers.from(JobExecutor_Factory.INSTANCE.get())).subscribe(new Observer<HeadTwosVo>() {
            @Override
            public void onCompleted() {
                TextView.class.cast(view.findViewById(R.id.report_left_headEven0)).setText(view.getResources().getString(R.string.headEven0,HeadEven0));
                TextView.class.cast(view.findViewById(R.id.report_left_headEven1)).setText(view.getResources().getString(R.string.headEven1,HeadEven1));
                TextView.class.cast(view.findViewById(R.id.report_left_headEven2)).setText(view.getResources().getString(R.string.headEven2,HeadEven2));
                TextView.class.cast(view.findViewById(R.id.report_left_headEven3)).setText(view.getResources().getString(R.string.headEven3,HeadEven3));
                TextView.class.cast(view.findViewById(R.id.report_left_headEven4)).setText(view.getResources().getString(R.string.headEven4,HeadEven4));

                TextView.class.cast(view.findViewById(R.id.report_left_headOdd0)).setText(view.getResources().getString(R.string.headOdd0,HeadOdd0));
                TextView.class.cast(view.findViewById(R.id.report_left_headOdd1)).setText(view.getResources().getString(R.string.headOdd1,HeadOdd1));
                TextView.class.cast(view.findViewById(R.id.report_left_headOdd2)).setText(view.getResources().getString(R.string.headOdd2,HeadOdd2));
                TextView.class.cast(view.findViewById(R.id.report_left_headOdd3)).setText(view.getResources().getString(R.string.headOdd3,HeadOdd3));
                TextView.class.cast(view.findViewById(R.id.report_left_headOdd4)).setText(view.getResources().getString(R.string.headOdd4,HeadOdd4));

            }

            @Override
            public void onError(Throwable e) {
                e.printStackTrace();
            }

            @Override
            public void onNext(HeadTwosVo compositeVo) {
                if (compositeVo.HeadEven0 == 0) {
                    HeadEven0++;
                } else if (compositeVo.HeadEven1== 0) {
                    HeadEven1++;
                } else if (compositeVo.HeadEven2 == 0) {
                    HeadEven2++;
                } else if (compositeVo.HeadEven3 == 0) {
                    HeadEven3++;
                } else if (compositeVo.HeadEven4 == 0) {
                    HeadEven4++;
                }else if (compositeVo.HeadOdd0 == 0) {
                    HeadOdd0++;
                } else if (compositeVo.HeadOdd1== 0) {
                    HeadOdd1++;
                } else if (compositeVo.HeadOdd2 == 0) {
                    HeadOdd2++;
                } else if (compositeVo.HeadOdd3 == 0) {
                    HeadOdd3++;
                } else if (compositeVo.HeadOdd4 == 0) {
                    HeadOdd4++;
                }
            }
        });
    }
}
