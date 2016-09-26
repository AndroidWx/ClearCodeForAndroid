package com.joye.hk6domain.vo;


import com.joye.hk6domain.entity.Hk6UiData;

/**
 * Created by W,x (JoyeWang)
 * on 2016/9/23.
 * 304622254@qq.com
 * Remeark: 生肖走势图的vo
 */

public class SizeVo extends Hk6UiData implements ReportRightI {

    public SizeVo(Hk6UiData sup){
        setOpentime(sup.getOpentime());
        setOpentimestamp(sup.getOpentimestamp());
        setEvictors(sup.getEvictors());
        setExpect(sup.getExpect());
        setOpenCode(sup.getOpenCode());
    }

    public int Big,Small;


}
