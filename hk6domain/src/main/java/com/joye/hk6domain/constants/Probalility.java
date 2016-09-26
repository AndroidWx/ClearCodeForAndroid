package com.joye.hk6domain.constants;

/**
 * Created by W,x (JoyeWang)
 * on 2016/9/21.
 * 304622254@qq.com
 * Remeark:概率常量类
 */

public class Probalility {

    public static class  Region{
        public static final double Default=0.14285714285714;
    }

    //生肖的理论概率
    public static class ChineseZodiac{
        /**
         * 平码的理论概率
         */
        public static final double Default=0.0816326530612245;
        /**
         * 特码的理论概率
         */
        public static final double OnlyOne=0.1020408163265306;
    }
    //波色的理论概率
    public static class Color{
        //16个数的理论概率
        private static final double Default=0.326530612244898;
        //17个数的理论概率
        private static final double Else=0.3469387755102041;
        public static final double Red =Else ;
        public static final double Blue =Default ;
        public static final double Green =Default ;
    }
    //大小的理论概率
    public static class Size{
        /**
         * Big
         */
        public static final double Big = 0.5102040816326531;
        /**
         * Small
         */
        public static final double Small = 0.4897959183673469;
    }
    //奇偶的理论概率
    public static class Parity{
        /**
         * 奇数
         */
        public static final double Odd = 0.5102040816326531;
        /**
         * 偶数
         */
        public static final double Even = 0.4897959183673469;
    }
    //质数合数出现的理论概率
    public static class PrimeComposite{
        /**
         * 质数
         */
        public static final double Prime =0.3061224489795918 ;

        /**
         * 合数
         */
        public static final double Composite = 0.673469387755102;
        /**
         * 出现1个的概率
         */
        public static final double One=0.0204081632653061;
    }

}
