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

}
