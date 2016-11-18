package com.joye.hk6domain.interactor;

import com.joye.basedomain.executor.PostExecutionThread;
import com.joye.basedomain.executor.ThreadExecutor;
import com.joye.hk6domain.constants.ChineseZodiac;
import com.joye.hk6domain.constants.Hk6EnumHelp;
import com.joye.hk6domain.entity.Hk6UiData;
import com.joye.hk6domain.repository.Hk6Repository;
import com.joye.hk6domain.vo.ChineseZodiacVo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import rx.Observable;
import rx.functions.Func1;
import rx.functions.Func3;
import rx.functions.Func9;

/**
 * Created by W,x (JoyeWang)
 * on 2016/9/24.
 * 304622254@qq.com
 * Remeark:
 */

public class GetChineseZodiacUseCase extends GetHk6Data {


    public GetChineseZodiacUseCase(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread, Hk6Repository hk6Repository, String date) {
        super(threadExecutor, postExecutionThread, hk6Repository, date);
    }

    @Override
    protected Observable buildUseCaseObservable() {
        Observable observable2=Observable.zip(
                super.buildUseCaseObservable("1990-12-31"),
                super.buildUseCaseObservable("1991-12-31"),
                super.buildUseCaseObservable("1992-12-31"),
                super.buildUseCaseObservable("1993-12-31"),
                super.buildUseCaseObservable("1994-12-31"),
                super.buildUseCaseObservable("1995-12-31"),
                super.buildUseCaseObservable("1996-12-31"),
                super.buildUseCaseObservable("1997-12-31"),
                super.buildUseCaseObservable("1998-12-31"),
                new Func9<List<Hk6UiData>,
                        List<Hk6UiData>,
                        List<Hk6UiData>,
                        List<Hk6UiData>,
                        List<Hk6UiData>,
                        List<Hk6UiData>,
                        List<Hk6UiData>,
                        List<Hk6UiData>,
                        List<Hk6UiData>,
                        List<Hk6UiData>>() {


                    @Override
                    public List<Hk6UiData> call(List<Hk6UiData> o, List<Hk6UiData> o2, List<Hk6UiData> o3,List<Hk6UiData> o4,List<Hk6UiData> o5, List<Hk6UiData> o6,List<Hk6UiData> o7,List<Hk6UiData> o8,List<Hk6UiData>o9) {
                        List<Hk6UiData> datas=new ArrayList<Hk6UiData>();
                        datas.addAll(o9);
                        datas.addAll(o8);
                        datas.addAll(o7);
                        datas.addAll(o6);
                        datas.addAll(o5);
                        datas.addAll(o4);
                        datas.addAll(o3);
                        datas.addAll(o2);
                        datas.addAll(o);
                        return datas;
                    }
                });
        Observable observable1=Observable.zip(
                super.buildUseCaseObservable("1999-12-31"),
                super.buildUseCaseObservable("2000-12-31"),
                super.buildUseCaseObservable("2001-12-31"),
                super.buildUseCaseObservable("2002-12-31"),
                super.buildUseCaseObservable("2003-12-31"),
                super.buildUseCaseObservable("2004-12-31"),
                super.buildUseCaseObservable("2005-12-31"),
                super.buildUseCaseObservable("2006-12-31"),
                super.buildUseCaseObservable("2007-12-31"),
                new Func9<List<Hk6UiData>,
                        List<Hk6UiData>,
                        List<Hk6UiData>,
                        List<Hk6UiData>,
                        List<Hk6UiData>,
                        List<Hk6UiData>,
                        List<Hk6UiData>,
                        List<Hk6UiData>,
                        List<Hk6UiData>,
                        List<Hk6UiData>>() {


                    @Override
                    public List<Hk6UiData> call(List<Hk6UiData> o, List<Hk6UiData> o2, List<Hk6UiData> o3,List<Hk6UiData> o4,List<Hk6UiData> o5, List<Hk6UiData> o6,List<Hk6UiData> o7,List<Hk6UiData> o8,List<Hk6UiData>o9) {
                        List<Hk6UiData> datas=new ArrayList<Hk6UiData>();
                        datas.addAll(o9);
                        datas.addAll(o8);
                        datas.addAll(o7);
                        datas.addAll(o6);
                        datas.addAll(o5);
                        datas.addAll(o4);
                        datas.addAll(o3);
                        datas.addAll(o2);
                        datas.addAll(o);
                        return datas;
                    }
                });
        Observable observable0=Observable.zip(
                super.buildUseCaseObservable("2008-12-31"),
                super.buildUseCaseObservable("2009-12-31"),
                super.buildUseCaseObservable("2010-12-31"),
                super.buildUseCaseObservable("2011-12-31"),
                super.buildUseCaseObservable("2012-12-31"),
                super.buildUseCaseObservable("2013-12-31"),
                super.buildUseCaseObservable("2014-12-31"),
                super.buildUseCaseObservable("2015-12-31"),
                super.buildUseCaseObservable(),
                new Func9<List<Hk6UiData>,
                        List<Hk6UiData>,
                        List<Hk6UiData>,
                        List<Hk6UiData>,
                        List<Hk6UiData>,
                        List<Hk6UiData>,
                        List<Hk6UiData>,
                        List<Hk6UiData>,
                        List<Hk6UiData>,
                        List<Hk6UiData>>() {


                    @Override
                    public List<Hk6UiData> call(List<Hk6UiData> o, List<Hk6UiData> o2, List<Hk6UiData> o3,List<Hk6UiData> o4,List<Hk6UiData> o5, List<Hk6UiData> o6,List<Hk6UiData> o7,List<Hk6UiData> o8,List<Hk6UiData>o9) {
                        List<Hk6UiData> datas=new ArrayList<Hk6UiData>();
                        datas.addAll(o9);
                        datas.addAll(o8);
                        datas.addAll(o7);
                        datas.addAll(o6);
                        datas.addAll(o5);
                        datas.addAll(o4);
                        datas.addAll(o3);
                        datas.addAll(o2);
                        datas.addAll(o);
                        return datas;
                    }
                });
        Observable observable=Observable.zip(observable2,observable1,observable0,new Func3<List<Hk6UiData>,
                List<Hk6UiData>,
                List<Hk6UiData>,
                List<Hk6UiData>>(){


            @Override
            public List<Hk6UiData> call(List<Hk6UiData> o, List<Hk6UiData> o2, List<Hk6UiData> o3) {
                List<Hk6UiData> datas=new ArrayList<Hk6UiData>();
                datas.addAll(o3);
                datas.addAll(o2);
                datas.addAll(o);
                return datas;
            }
        });
        return observable.map(new Func1<List<Hk6UiData>, List<ChineseZodiacVo>>() {

            @Override
            public List<ChineseZodiacVo> call(List<Hk6UiData> hk6UiDatas) {
                List<ChineseZodiacVo> list = new ArrayList<ChineseZodiacVo>(hk6UiDatas.size());
                Collections.reverse(hk6UiDatas);
                int Mouse = 0, Cow = 0, Tiger = 0, Rabbit = 0, Dragon = 0, Snake = 0, Horse = 0, Sheep = 0, Monkey = 0, Chook = 0, Dog = 0, Pig = 0;
                ChineseZodiacVo vo;
                for (Hk6UiData itemVo : hk6UiDatas) {
                  vo= new ChineseZodiacVo(itemVo);
                    if (Hk6EnumHelp.getChineseZodiac(vo.getOpenCode(), vo.getOpentimestamp()).equals(ChineseZodiac.Mouse)) {
                        Mouse = 0;
                        Cow++;
                        Tiger++;
                        Rabbit++;
                        Dragon++;
                        Snake++;
                        Horse++;
                        Sheep++;
                        Monkey++;
                        Chook++;
                        Dog++;
                        Pig++;
                        initialValue(Mouse, Cow, Tiger, Rabbit, Dragon, Snake, Horse, Sheep, Monkey, Chook, Dog, Pig, vo);
                    }else  if (Hk6EnumHelp.getChineseZodiac(vo.getOpenCode(), vo.getOpentimestamp()).equals(ChineseZodiac.Cow)) {
                        Mouse++;
                        Cow=0;
                        Tiger++;
                        Rabbit++;
                        Dragon++;
                        Snake++;
                        Horse++;
                        Sheep++;
                        Monkey++;
                        Chook++;
                        Dog++;
                        Pig++;
                        initialValue(Mouse, Cow, Tiger, Rabbit, Dragon, Snake, Horse, Sheep, Monkey, Chook, Dog, Pig, vo);
                    }else if (Hk6EnumHelp.getChineseZodiac(vo.getOpenCode(), vo.getOpentimestamp()).equals(ChineseZodiac.Tiger)) {
                        Mouse++;
                        Cow++;
                        Tiger=0;
                        Rabbit++;
                        Dragon++;
                        Snake++;
                        Horse++;
                        Sheep++;
                        Monkey++;
                        Chook++;
                        Dog++;
                        Pig++;
                        initialValue(Mouse, Cow, Tiger, Rabbit, Dragon, Snake, Horse, Sheep, Monkey, Chook, Dog, Pig, vo);
                    }else if (Hk6EnumHelp.getChineseZodiac(vo.getOpenCode(), vo.getOpentimestamp()).equals(ChineseZodiac.Rabbit)) {
                        Mouse++;
                        Cow++;
                        Tiger++;
                        Rabbit=0;
                        Dragon++;
                        Snake++;
                        Horse++;
                        Sheep++;
                        Monkey++;
                        Chook++;
                        Dog++;
                        Pig++;
                        initialValue(Mouse, Cow, Tiger, Rabbit, Dragon, Snake, Horse, Sheep, Monkey, Chook, Dog, Pig, vo);
                    }else if (Hk6EnumHelp.getChineseZodiac(vo.getOpenCode(), vo.getOpentimestamp()).equals(ChineseZodiac.Dragon)) {
                        Mouse++;
                        Cow++;
                        Tiger++;
                        Rabbit++;
                        Dragon=0;
                        Snake++;
                        Horse++;
                        Sheep++;
                        Monkey++;
                        Chook++;
                        Dog++;
                        Pig++;
                        initialValue(Mouse, Cow, Tiger, Rabbit, Dragon, Snake, Horse, Sheep, Monkey, Chook, Dog, Pig, vo);
                    }else if (Hk6EnumHelp.getChineseZodiac(vo.getOpenCode(), vo.getOpentimestamp()).equals(ChineseZodiac.Snake)) {
                        Mouse++;
                        Cow++;
                        Tiger++;
                        Rabbit++;
                        Dragon++;
                        Snake=0;
                        Horse++;
                        Sheep++;
                        Monkey++;
                        Chook++;
                        Dog++;
                        Pig++;
                        initialValue(Mouse, Cow, Tiger, Rabbit, Dragon, Snake, Horse, Sheep, Monkey, Chook, Dog, Pig, vo);
                    }else if (Hk6EnumHelp.getChineseZodiac(vo.getOpenCode(), vo.getOpentimestamp()).equals(ChineseZodiac.Horse)) {
                        Mouse++;
                        Cow++;
                        Tiger++;
                        Rabbit++;
                        Dragon++;
                        Snake++;
                        Horse=0;
                        Sheep++;
                        Monkey++;
                        Chook++;
                        Dog++;
                        Pig++;
                        initialValue(Mouse, Cow, Tiger, Rabbit, Dragon, Snake, Horse, Sheep, Monkey, Chook, Dog, Pig, vo);
                    }else if (Hk6EnumHelp.getChineseZodiac(vo.getOpenCode(), vo.getOpentimestamp()).equals(ChineseZodiac.Sheep)) {
                        Mouse++;
                        Cow++;
                        Tiger++;
                        Rabbit++;
                        Dragon++;
                        Snake++;
                        Horse++;
                        Sheep=0;
                        Monkey++;
                        Chook++;
                        Dog++;
                        Pig++;
                        initialValue(Mouse, Cow, Tiger, Rabbit, Dragon, Snake, Horse, Sheep, Monkey, Chook, Dog, Pig, vo);
                    }else if (Hk6EnumHelp.getChineseZodiac(vo.getOpenCode(), vo.getOpentimestamp()).equals(ChineseZodiac.Monkey)) {
                        Mouse++;
                        Cow++;
                        Tiger++;
                        Rabbit++;
                        Dragon++;
                        Snake++;
                        Horse++;
                        Sheep++;
                        Monkey=0;
                        Chook++;
                        Dog++;
                        Pig++;
                        initialValue(Mouse, Cow, Tiger, Rabbit, Dragon, Snake, Horse, Sheep, Monkey, Chook, Dog, Pig, vo);
                    }else if (Hk6EnumHelp.getChineseZodiac(vo.getOpenCode(), vo.getOpentimestamp()).equals(ChineseZodiac.Chook)) {
                        Mouse++;
                        Cow++;
                        Tiger++;
                        Rabbit++;
                        Dragon++;
                        Snake++;
                        Horse++;
                        Sheep++;
                        Monkey++;
                        Chook=0;
                        Dog++;
                        Pig++;
                        initialValue(Mouse, Cow, Tiger, Rabbit, Dragon, Snake, Horse, Sheep, Monkey, Chook, Dog, Pig, vo);
                    }else if (Hk6EnumHelp.getChineseZodiac(vo.getOpenCode(), vo.getOpentimestamp()).equals(ChineseZodiac.Dog)) {
                        Mouse++;
                        Cow++;
                        Tiger++;
                        Rabbit++;
                        Dragon++;
                        Snake++;
                        Horse++;
                        Sheep++;
                        Monkey++;
                        Chook++;
                        Dog=0;
                        Pig++;
                        initialValue(Mouse, Cow, Tiger, Rabbit, Dragon, Snake, Horse, Sheep, Monkey, Chook, Dog, Pig, vo);
                    }else if (Hk6EnumHelp.getChineseZodiac(vo.getOpenCode(), vo.getOpentimestamp()).equals(ChineseZodiac.Pig)) {
                        Mouse++;
                        Cow++;
                        Tiger++;
                        Rabbit++;
                        Dragon++;
                        Snake++;
                        Horse++;
                        Sheep++;
                        Monkey++;
                        Chook++;
                        Dog++;
                        Pig=0;
                        initialValue(Mouse, Cow, Tiger, Rabbit, Dragon, Snake, Horse, Sheep, Monkey, Chook, Dog, Pig, vo);
                    }
                    list.add(vo);
                }
                Collections.reverse(list);
                return list;
            }
        });
    }

    private void initialValue(int mouse, int cow, int tiger, int rabbit, int dragon, int snake, int horse, int sheep, int monkey, int chook, int dog, int pig, ChineseZodiacVo vo) {
        vo.Mouse = mouse;
        vo.Cow = cow;
        vo.Tiger = tiger;
        vo.Rabbit = rabbit;
        vo.Dragon = dragon;
        vo.Snake = snake;
        vo.Horse = horse;
        vo.Sheep = sheep;
        vo.Monkey = monkey;
        vo.Chook = chook;
        vo.Dog = dog;
        vo.Pig = pig;
    }
}
