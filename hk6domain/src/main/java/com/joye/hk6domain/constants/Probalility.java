package com.joye.hk6domain.constants;

/**
 * Created by W,x (JoyeWang)
 * on 2016/9/21.
 * 304622254@qq.com
 * Remeark:���ʳ�����
 */

public class Probalility {

    public static class  Region{
        public static final double Default=0.14285714285714;
    }

    //��Ф�����۸���
    public static class ChineseZodiac{
        /**
         * ƽ������۸���
         */
        public static final double Default=0.0816326530612245;
        /**
         * ��������۸���
         */
        public static final double OnlyOne=0.1020408163265306;
    }
    //��ɫ�����۸���
    public static class Color{
        //16���������۸���
        private static final double Default=0.326530612244898;
        //17���������۸���
        private static final double Else=0.3469387755102041;
        public static final double Red =Else ;
        public static final double Blue =Default ;
        public static final double Green =Default ;
    }
    //��С�����۸���
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
    //��ż�����۸���
    public static class Parity{
        /**
         * ����
         */
        public static final double Odd = 0.5102040816326531;
        /**
         * ż��
         */
        public static final double Even = 0.4897959183673469;
    }
    //�����������ֵ����۸���
    public static class PrimeComposite{
        /**
         * ����
         */
        public static final double Prime =0.3061224489795918 ;

        /**
         * ����
         */
        public static final double Composite = 0.673469387755102;
        /**
         * ����1���ĸ���
         */
        public static final double One=0.0204081632653061;
    }

    public static class ColorTwos{
        /**
         * ��˫
         */
        public static final double RedEven=0.1836734693877551;
        /**
         * �쵥
         */
        public static final double RedOdd = 0.163265306122449;
        /**
         * ����
         */
        public static final double BlueOdd = 0.163265306122449;
        /**
         * ��˫
         */
        public static final double BlueEven = 0.163265306122449;
        /**
         * ��˫
         */
        public static final double GreenEven = 0.1428571428571429;

        /**
         * ����
         */
        public static final double GreenOdd = 0.1836734693877551;
    }

    public static class HeadAge{
        public static final double H_0=0.18367346938776;
        public static final double Default=0.20408163265306;
    }

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

    public static class GateCount{
        public static final double GateCount_1=0.18367346938776;
        public static final double GateCount_2=GateCount_1;
        public static final double GateCount_3=GateCount_1;
        public static final double GateCount_4=0.20408163265306;
        public static final double GateCount_5=0.24489795918367;

    }


}
