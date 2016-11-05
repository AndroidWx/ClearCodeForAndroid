package com.joye.hk6.report;

import android.support.annotation.NonNull;

import com.joye.hk6domain.vo.ColorVo;

import java.util.List;

/**
 * Created by W,x (JoyeWang)
 * on 2016/11/5.
 * 304622254@qq.com
 * Remeark:波色报表统计
 */

public class ColorReport {
    /**
     * 总数据
     */
    private final List<ColorVo> colorVos;
    public ColorReport(List<ColorVo> chineseZodiacVos) {
        this.colorVos = chineseZodiacVos;
    }
    private void BubbleSortBlue(@NonNull  ColorVo[] vos){
        ColorVo temp = vos[0];
        for (int i = vos.length - 1; i > 0; --i)
        {
            for (int j = 0; j < i; ++j)
            {
                if (vos[j + 1].Blue < vos[j].Blue)
                {
                    temp = vos[j];
                    vos[j] = vos[j + 1];
                    vos[j + 1] = temp;
                }
            }
        }


    }






    //1.冒泡得到最大阈值
    //2.获取最大阈值的开奖次数
    //////////3.递归（阈值-1）的开奖次数

    //统计最大阈值出现的次数 阈值-1出现的次数
}
