package com.joye.hk6domain.vo;


import com.joye.hk6domain.constants.NumberProperty;
import com.joye.hk6domain.entity.Hk6UiData;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by W,x (JoyeWang)
 * on 2016/9/23.
 * 304622254@qq.com
 * Remeark: 默认走势图的vo
 */

public class DefaultNumberVo extends Hk6UiData implements ReportRightI {
    public Map<String, Integer>map;

    public void setMap(Map<String, Integer> map) {
        this.map = map;
    }

    public Map<String, Integer> getMap() {
        return map;
    }

    public DefaultNumberVo(Hk6UiData sup){
        setOpentime(sup.getOpentime());
        setOpentimestamp(sup.getOpentimestamp());
        setEvictors(sup.getEvictors());
        setExpect(sup.getExpect());
        setOpenCode(sup.getOpenCode());
        map=new HashMap<>();
        for (NumberProperty numberProperty:NumberProperty.values()){
            map.put(numberProperty.toString(),0);
        }
    }



}
