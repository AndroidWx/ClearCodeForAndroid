package com.joye.hk6domain.constants;

/**
 * Created by W,x (JoyeWang)
 * on 2016/9/28.
 * 304622254@qq.com
 * Remeark: 警惕级别
 */

public enum  Vigilant implements IDcValue {
    Default{
        @Override
        public double getDcValue() {
            return 0.1;
        }
    }
    ,Base{
        @Override
        public double getDcValue() {
            return 0.90;
        }
    },

    Blue {
        @Override
        public double getDcValue() {
            return 0.95;
        }
    },
    Blue_1 {
        @Override
        public double getDcValue() {
            return 0.96;
        }
    }
,
    Yellow{
        @Override
        public double getDcValue() {
            return 0.97;
        }
    },
    Yellow_1{
        @Override
        public double getDcValue() {
            return 0.975;
        }
    }

    ,Orange{
        @Override
        public double getDcValue() {
            return 0.98;
        }
    },
    Orange_1 {
        @Override
        public double getDcValue() {
            return 0.985;
        }
    },
    Red {
        @Override
        public double getDcValue() {
            return 0.99;
        }
    },
    Red_1 {
        @Override
        public double getDcValue() {
            return 0.999;
        }
    }



}
