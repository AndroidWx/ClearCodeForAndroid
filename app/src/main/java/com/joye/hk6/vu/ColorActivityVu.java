package com.joye.hk6.vu;

import android.content.Context;
import android.widget.TextView;

import com.joye.basedata.executor.JobExecutor_Factory;
import com.joye.hk6.R;
import com.joye.hk6.adapter.ColorAdapter;
import com.joye.hk6.adapter.UpdateItemRecyclerViewAdapter;
import com.joye.hk6.report.ColorReport;
import com.joye.hk6.report.PieChartImpl;
import com.joye.hk6.view.IPieChartCallback;
import com.joye.hk6.vu.base.CoordinatorLayoutToolBarImageViewRecyclerVu;
import com.joye.hk6domain.constants.Hk6EnumHelp;
import com.joye.hk6domain.vo.ColorVo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

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

    private IPieChartCallback callback;

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

    public PieChartImpl genPieChartImpl(Map<Integer,Integer> map,String contentText){
        PieChartImpl item=new PieChartImpl();
        item.setContentText(contentText);
        ArrayList<Float> redFloatList=new ArrayList<Float>();
        ArrayList<String> lableList=new ArrayList<String>();
//        Iterator<Integer> iterator = map.keySet().iterator();
//        while (iterator.hasNext()){
//            Integer key=iterator.next();
//            lableList.add("阈"+key+"共"+map.get(key));
//        }
        Iterator<Map.Entry<Integer, Integer>> intera = map.entrySet().iterator();
        while (intera.hasNext()){
            Map.Entry entry = (Map.Entry) intera.next();
            Integer val = (Integer) entry.getValue();
            if(val>0) {
                lableList.add("阈" + entry.getKey() + "共" + map.get(entry.getKey()));
                redFloatList.add(val.floatValue() * 100.0f);
            }
        }
        item.setPieEntryFlotArrayList(redFloatList);
        item.setPieEntryLabelArrayList(lableList);
        return item;
    }

    @Override
    public void onNext(List<ColorVo> chineseZodiacVos) {
        super.onNext(chineseZodiacVos);
        Observable.just(chineseZodiacVos).map(mapFunc1).subscribeOn(Schedulers.from(JobExecutor_Factory.INSTANCE.get())).subscribe(new Observer<List<ColorVo>>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(List<ColorVo> colorVos) {
                new ColorReport(colorVos).BubbleSort(new ColorReport.IColorReport() {
                    @Override
                    public void onReportMapData(Map<Integer, Integer> blueMap, Map<Integer, Integer> redMap, Map<Integer, Integer> greeMap) {
                        if(callback!=null){
                            ArrayList<PieChartImpl> datas=new ArrayList<PieChartImpl>();
                            datas.add(genPieChartImpl(blueMap,"蓝波"));
                            datas.add(genPieChartImpl(redMap,"红波"));
                            datas.add(genPieChartImpl(greeMap,"绿波"));
                            callback.callback(datas);
                        }

                    }
                });
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

    public void setCallback(IPieChartCallback callback) {
        this.callback = callback;
    }
}
