package com.joye.hk6data.constants;

/**
 * Created by W,x (JoyeWang)
 * on 2016/9/21.
 * 304622254@qq.com
 * Remeark:
 */

public enum PrimeCompositeNumber implements IProbability{
    /**
     * 非质数，非合数
     */
    One {
        @Override
        public double getTheoryProbability() {
            return Probalility.PrimeComposite.One;
        }
    },
    /**
     * 质数
     */
    Prime{
        @Override
        public double getTheoryProbability() {
            return Probalility.PrimeComposite.Prime;
        }
    },
    /**
     * 合数
     */
    Composite{
        @Override
        public double getTheoryProbability() {
            return Probalility.PrimeComposite.Composite;
        }
    };
}
