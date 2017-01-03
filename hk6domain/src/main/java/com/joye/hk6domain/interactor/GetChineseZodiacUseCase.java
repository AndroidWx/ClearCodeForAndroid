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
    int Mouse = 0, Cow = 0, Tiger = 0, Rabbit = 0, Dragon = 0, Snake = 0, Horse = 0, Sheep = 0, Monkey = 0, Chook = 0, Dog = 0, Pig = 0;
    public void addNumber(){
        Mouse ++;
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
    }
    @Override
    protected Observable buildUseCaseObservable() {
        return getHistory().map(new Func1<List<Hk6UiData>, List<ChineseZodiacVo>>() {

            @Override
            public List<ChineseZodiacVo> call(List<Hk6UiData> hk6UiDatas) {
                List<ChineseZodiacVo> list = new ArrayList<ChineseZodiacVo>(hk6UiDatas.size());
                Collections.reverse(hk6UiDatas);
                ChineseZodiacVo vo;
                for (Hk6UiData itemVo : hk6UiDatas) {
                  vo= new ChineseZodiacVo(itemVo);
                    if (Hk6EnumHelp.getChineseZodiac(vo.getOpenCode(),Integer.valueOf(vo.getOpentime().substring(0,4))).equals(ChineseZodiac.Mouse)) {
                        addNumber();
                        Mouse = 0;
                        initialValue(Mouse, Cow, Tiger, Rabbit, Dragon, Snake, Horse, Sheep, Monkey, Chook, Dog, Pig, vo);
                    }else  if (Hk6EnumHelp.getChineseZodiac(vo.getOpenCode(), Integer.valueOf(vo.getOpentime().substring(0,4))).equals(ChineseZodiac.Cow)) {
                        addNumber();
                        Cow=0;
                        initialValue(Mouse, Cow, Tiger, Rabbit, Dragon, Snake, Horse, Sheep, Monkey, Chook, Dog, Pig, vo);
                    }else if (Hk6EnumHelp.getChineseZodiac(vo.getOpenCode(), Integer.valueOf(vo.getOpentime().substring(0,4))).equals(ChineseZodiac.Tiger)) {
                        addNumber();
                        Tiger=0;
                        initialValue(Mouse, Cow, Tiger, Rabbit, Dragon, Snake, Horse, Sheep, Monkey, Chook, Dog, Pig, vo);
                    }else if (Hk6EnumHelp.getChineseZodiac(vo.getOpenCode(), Integer.valueOf(vo.getOpentime().substring(0,4))).equals(ChineseZodiac.Rabbit)) {
                        addNumber();
                        Rabbit=0;
                        initialValue(Mouse, Cow, Tiger, Rabbit, Dragon, Snake, Horse, Sheep, Monkey, Chook, Dog, Pig, vo);
                    }else if (Hk6EnumHelp.getChineseZodiac(vo.getOpenCode(), Integer.valueOf(vo.getOpentime().substring(0,4))).equals(ChineseZodiac.Dragon)) {
                        addNumber();
                        Dragon=0;
                        initialValue(Mouse, Cow, Tiger, Rabbit, Dragon, Snake, Horse, Sheep, Monkey, Chook, Dog, Pig, vo);
                    }else if (Hk6EnumHelp.getChineseZodiac(vo.getOpenCode(), Integer.valueOf(vo.getOpentime().substring(0,4))).equals(ChineseZodiac.Snake)) {
                        addNumber();
                        Snake=0;
                        initialValue(Mouse, Cow, Tiger, Rabbit, Dragon, Snake, Horse, Sheep, Monkey, Chook, Dog, Pig, vo);
                    }else if (Hk6EnumHelp.getChineseZodiac(vo.getOpenCode(), Integer.valueOf(vo.getOpentime().substring(0,4))).equals(ChineseZodiac.Horse)) {
                        addNumber();
                        Horse=0;
                        initialValue(Mouse, Cow, Tiger, Rabbit, Dragon, Snake, Horse, Sheep, Monkey, Chook, Dog, Pig, vo);
                    }else if (Hk6EnumHelp.getChineseZodiac(vo.getOpenCode(), Integer.valueOf(vo.getOpentime().substring(0,4))).equals(ChineseZodiac.Sheep)) {
                        addNumber();
                        Sheep=0;
                        initialValue(Mouse, Cow, Tiger, Rabbit, Dragon, Snake, Horse, Sheep, Monkey, Chook, Dog, Pig, vo);
                    }else if (Hk6EnumHelp.getChineseZodiac(vo.getOpenCode(), Integer.valueOf(vo.getOpentime().substring(0,4))).equals(ChineseZodiac.Monkey)) {
                        addNumber();
                        Monkey=0;
                        initialValue(Mouse, Cow, Tiger, Rabbit, Dragon, Snake, Horse, Sheep, Monkey, Chook, Dog, Pig, vo);
                    }else if (Hk6EnumHelp.getChineseZodiac(vo.getOpenCode(), Integer.valueOf(vo.getOpentime().substring(0,4))).equals(ChineseZodiac.Chook)) {
                        addNumber();
                        Chook=0;
                        initialValue(Mouse, Cow, Tiger, Rabbit, Dragon, Snake, Horse, Sheep, Monkey, Chook, Dog, Pig, vo);
                    }else if (Hk6EnumHelp.getChineseZodiac(vo.getOpenCode(), Integer.valueOf(vo.getOpentime().substring(0,4))).equals(ChineseZodiac.Dog)) {
                        addNumber();
                        Dog=0;
                        initialValue(Mouse, Cow, Tiger, Rabbit, Dragon, Snake, Horse, Sheep, Monkey, Chook, Dog, Pig, vo);
                    }else if (Hk6EnumHelp.getChineseZodiac(vo.getOpenCode(), Integer.valueOf(vo.getOpentime().substring(0,4))).equals(ChineseZodiac.Pig)) {
                        addNumber();
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
