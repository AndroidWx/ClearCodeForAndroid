package com.joye.hk6domain.constants;

/**
 * Created by W,x (JoyeWang)
 * on 2016/9/21.
 * 304622254@qq.com
 * Remeark: ´óÊý×Ö Ð¡Êå×Ö
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
    };

    public Hk6Size getHk6Size(int n){
        return Hk6EnumHelp.getHk6Size(n);
    }
}
