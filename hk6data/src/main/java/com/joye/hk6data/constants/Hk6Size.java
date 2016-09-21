package com.joye.hk6data.constants;

/**
 * Created by W,x (JoyeWang)
 * on 2016/9/21.
 * 304622254@qq.com
 * Remeark: 大数字 小叔字
 */

public enum Hk6Size implements IProbability {
    Big {
        @Override
        public double getTheoryProbability() {
            return Probalility.Size.Big;
        }
    },
    Small {
        @Override
        public double getTheoryProbability() {
            return Probalility.Size.Small;
        }
    }
}
