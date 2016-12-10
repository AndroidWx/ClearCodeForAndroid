package com.joye.hk6.vu;

import android.content.Context;
import android.widget.TextView;

import com.joye.basedata.executor.JobExecutor_Factory;
import com.joye.hk6.R;
import com.joye.hk6.adapter.ChineseZodiacAdapter;
import com.joye.hk6.adapter.UpdateItemRecyclerViewAdapter;
import com.joye.hk6.report.ChineseZodiacReport;
import com.joye.hk6.view.IPieChartCallback;
import com.joye.hk6.vu.base.CoordinatorLayoutToolBarImageViewRecyclerVu;
import com.joye.hk6domain.constants.Hk6EnumHelp;
import com.joye.hk6domain.vo.ChineseZodiacVo;

import java.util.List;

import rx.Observable;
import rx.Observer;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by Wx on 2016/9/25.
 * QQ:304622254;
 * remark:
 */

public class ChineseZodiacActivityVu extends CoordinatorLayoutToolBarImageViewRecyclerVu<ChineseZodiacVo> {
    private IPieChartCallback callback;

    public void setCallback(IPieChartCallback callback) {
        this.callback = callback;
    }

    @Override
    public void setToolbarTimeAndViewStubInflate() {
        backdrop.setImageResource(R.drawable.chinesezodiac);
        lableViewStub.setLayoutResource( R.layout.item_chinese_zodiac);
        lableViewStub.inflate();
    }

    @Override
    public UpdateItemRecyclerViewAdapter getRecylerViewAdapter(Context context) {
        return new ChineseZodiacAdapter(context);
    }
    int Mouse, Cow, Tiger, Rabbit, Dragon, Snake,Horse,Sheep,Monkey,Chook,Dog,Pig;

    @Override
    public void onNext(List<ChineseZodiacVo> chineseZodiacVos) {
        super.onNext(chineseZodiacVos);
        Observable.just(chineseZodiacVos).subscribeOn(Schedulers.from(JobExecutor_Factory.INSTANCE.get())).subscribe(new Observer<List<ChineseZodiacVo>>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(List<ChineseZodiacVo> colorVos) {
                ChineseZodiacReport report= new ChineseZodiacReport(colorVos);
                report.BubbleSort(callback);
                report.Demarcations(callback);
            }
        });

        Observable.from(chineseZodiacVos).filter(new Func1<ChineseZodiacVo, Boolean>() {
            @Override
            public Boolean call(ChineseZodiacVo compositeVo) {
                return compositeVo.getOpentimestamp() >= Hk6EnumHelp.Default2016;
            }
        }).subscribeOn(Schedulers.from(JobExecutor_Factory.INSTANCE.get())).subscribe(new Observer<ChineseZodiacVo>() {
            @Override
            public void onCompleted() {
                TextView.class.cast(view.findViewById(R.id.Mouse)).setText(view.getResources().getString(R.string.Mouse,Mouse));
                TextView.class.cast(view.findViewById(R.id.Cow)).setText(view.getResources().getString(R.string.Cow,Cow));
                TextView.class.cast(view.findViewById(R.id.Tiger)).setText(view.getResources().getString(R.string.Tiger,Tiger));
                TextView.class.cast(view.findViewById(R.id.Rabbit)).setText(view.getResources().getString(R.string.Rabbit,Rabbit));
                TextView.class.cast(view.findViewById(R.id.Dragon)).setText(view.getResources().getString(R.string.Dragon,Dragon));
                TextView.class.cast(view.findViewById(R.id.Snake)).setText(view.getResources().getString(R.string.Snake,Snake));
                TextView.class.cast(view.findViewById(R.id.Horse)).setText(view.getResources().getString(R.string.Horse,Horse));
                TextView.class.cast(view.findViewById(R.id.Sheep)).setText(view.getResources().getString(R.string.Sheep,Sheep));
                TextView.class.cast(view.findViewById(R.id.Monkey)).setText(view.getResources().getString(R.string.Monkey,Monkey));
                TextView.class.cast(view.findViewById(R.id.Chook)).setText(view.getResources().getString(R.string.Chook,Chook));
                TextView.class.cast(view.findViewById(R.id.Dog)).setText(view.getResources().getString(R.string.Dog,Dog));
                TextView.class.cast(view.findViewById(R.id.Pig)).setText(view.getResources().getString(R.string.Pig,Pig));
            }

            @Override
            public void onError(Throwable e) {
                e.printStackTrace();
            }
            @Override
            public void onNext(ChineseZodiacVo compositeVo) {
                if (compositeVo.Mouse == 0) {
                    Mouse++;
                } else if (compositeVo.Cow == 0) {
                    Cow++;
                } else if (compositeVo.Tiger == 0) {
                    Tiger++;
                } else if (compositeVo.Rabbit == 0) {
                    Rabbit++;
                } else if (compositeVo.Dragon == 0) {
                    Dragon++;
                } else if (compositeVo.Snake == 0) {
                    Snake++;
                } else if (compositeVo.Horse == 0) {
                    Horse++;
                } else if (compositeVo.Sheep == 0) {
                    Sheep++;
                } else if (compositeVo.Monkey == 0) {
                    Monkey++;
                } else if (compositeVo.Chook == 0) {
                    Chook++;
                } else if (compositeVo.Dog == 0) {
                    Dog++;
                } else if (compositeVo.Pig == 0) {
                    Pig++;
                }
            }
        });
    }
}
