package com.joye.hk6data.constants;

/**
 * Created by W,x (JoyeWang)
 * on 2016/9/21.
 * 304622254@qq.com
 * Remeark: 红波蓝波绿波
 */

public enum Hk6Color implements IProbability{
    Red {
        @Override
        public double getTheoryProbability() {
            return Probalility.Color.Red;
        }
    },
    Blue {
        @Override
        public double getTheoryProbability() {
            return Probalility.Color.Blue;
        }
    },
    Green {
        @Override
        public double getTheoryProbability() {
            return Probalility.Color.Green;
        }
    }
}
