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

    public static class ColorTwos{
        /**
         * 红双
         */
        public static final double RedEven=0.1836734693877551;
        /**
         * 红单
         */
        public static final double RedOdd = 0.163265306122449;
        /**
         * 蓝单
         */
        public static final double BlueOdd = 0.163265306122449;
        /**
         * 蓝双
         */
        public static final double BlueEven = 0.163265306122449;
        /**
         * 蓝双
         */
        public static final double GreenEven = 0.1428571428571429;

        /**
         * 蓝单
         */
        public static final double GreenOdd = 0.1836734693877551;
    }

    /**
     * 头数
     */
    public static class HeadAge{
        public static final double H_0=0.18367346938776;
        public static final double Default=0.20408163265306;
    }

    /**
     * 合数
     */
    public static class Composite{
        public static final double C_1=0.04081632653061;
        public static final double C_2=0.06122448979592;
        public static final double C_3=0.08163265306122;
        public static final double C_4=0.10204081632653;
        public static final double C_5=C_4;
        public static final double C_6=C_4;
        public static final double C_7=C_4;
        public static final double C_8=C_4;
        public static final double C_9=C_4;
        public static final double C_10=C_3;
        public static final double C_11=C_2;
        public static final double C_12=C_1;
        public static final double C_13=0.02040816326531;
    }

    public static class HeadTows{
        //0头双
        public static final double HeadEven0=0.08163265306122;
        //默认
        public static final double Default=0.10204081632653;
    }

    /**
     * 合尾数
     */
    public static class CompositeMantissa{
        //0尾
        public static final double Mantissa0=0.08163265306122;
        //默认
        public static final double Default=0.10204081632653;
    }

    /**
     * 门数
     */
    public static class GateCount{
        public static final double GateCount_1=0.18367346938776;
        public static final double GateCount_2=GateCount_1;
        public static final double GateCount_3=GateCount_1;
        public static final double GateCount_4=0.20408163265306;
        public static final double GateCount_5=0.24489795918367;
    }

    public static class Mantissa{
        //0尾
        public static final double Mantissa0=0.08163265306122;
        //默认
        public static final double Default=0.10204081632653;
    }


    //合数大小的理论概率
    public static class CompositeSize{
        /**
         * Big
         */
        public static final double Big = 0.5102040816326531;
        /**
         * Small
         */
        public static final double Small = 0.4897959183673469;
    }

    //尾数数大小的理论概率
    public static class MantissaSize{
        /**
         * Big
         */
        public static final double Big = 0.5102040816326531;
        /**
         * Small
         */
        public static final double Small = 0.4897959183673469;
    }

    public static class SizeTwos{
        //小单
        public static final double SmallOdd=0.24489795918367;
        //小双
        public static final double SmallEven=SmallOdd;
        //大单
        public static final double BigOdd=0.26530612244898;
        //大双
        public static final double BigEven=SmallOdd;
    }

    public static class Modular3{
        public static final double M0=0.326530612244898;
        public static final double M1=0.3469387755102041;
        public static final double M2=0.326530612244898;
    }

    public static class Modular4{
        public static final double M0=0.2448979591836735;
        public static final double M1=0.2653061224489796;
        public static final double M2=0.2448979591836735;
        public static final double M3=0.2448979591836735;
    }

    public static class Modular5{
        public static final double M0=0.1836734693877551;
        public static final double M1=0.2040816326530612;
        public static final double M2=0.2040816326530612;
        public static final double M3=0.2040816326530612;
        public static final double M4=0.2040816326530612;
    }

    public static class Modular6{
        public static final double M0=0.163265306122449;
        public static final double M1=0.1836734693877551;
        public static final double M2=0.163265306122449;
        public static final double M3=0.163265306122449;
        public static final double M4=0.163265306122449;
        public static final double M5=0.163265306122449;
    }

    public static class Modular7{
        public static final double M0=0.1428571428571429;
        public static final double M1=0.1428571428571429;
        public static final double M2=0.1428571428571429;
        public static final double M3=0.1428571428571429;
        public static final double M4=0.1428571428571429;
        public static final double M5=0.1428571428571429;
        public static final double M6=0.1428571428571429;
    }

    public static class DefaultNumber{
        public static final double Defult=0.0204081632653061;
    }
}
