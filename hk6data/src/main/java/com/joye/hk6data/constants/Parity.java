package com.joye.hk6data.constants;

/**
 * Created by W,x (JoyeWang)
 * on 2016/9/21.
 * 304622254@qq.com
 * Remeark:奇偶
 */

public enum Parity implements IProbability{
    /**
     * 奇数
     */
    Odd {
        @Override
        public double getTheoryProbability() {
            return Probalility.Parity.Odd;
        }
    },
    /**
     * 偶数
     */
    Even {
        @Override
        public double getTheoryProbability() {
            return Probalility.Parity.Even;
        }
    }


}
