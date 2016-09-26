package com.joye.hk6domain.constants;

/**
 * Created by Wx on 2016/9/25.
 * QQ:304622254;
 * remark:
 */

public interface INumberProperty {

    int getValue();

    /**
     * number归属生肖
     * @return
     */
    ChineseZodiac getChineseZodiac();

    /**
     *
     * @return 归属波色
     */
    Hk6Color getHk6Color();

    /**
     * 归属奇偶
     * @return
     */
    Parity getParity();

    /**
     * 归属质数合数
     * @return
     */
    PrimeCompositeNumber getPrimeCompositeNumber();

    /**
     * 归属区间
     * @return
     */
    Region getRegion();

    Hk6Size getSize();
}
