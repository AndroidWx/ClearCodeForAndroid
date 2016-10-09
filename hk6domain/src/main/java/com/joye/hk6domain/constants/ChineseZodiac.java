package com.joye.hk6domain.constants;

import static com.joye.hk6domain.constants.Number.N_1;
import static com.joye.hk6domain.constants.Number.N_10;
import static com.joye.hk6domain.constants.Number.N_11;
import static com.joye.hk6domain.constants.Number.N_12;
import static com.joye.hk6domain.constants.Number.N_13;
import static com.joye.hk6domain.constants.Number.N_14;
import static com.joye.hk6domain.constants.Number.N_15;
import static com.joye.hk6domain.constants.Number.N_16;
import static com.joye.hk6domain.constants.Number.N_17;
import static com.joye.hk6domain.constants.Number.N_18;
import static com.joye.hk6domain.constants.Number.N_19;
import static com.joye.hk6domain.constants.Number.N_2;
import static com.joye.hk6domain.constants.Number.N_20;
import static com.joye.hk6domain.constants.Number.N_21;
import static com.joye.hk6domain.constants.Number.N_22;
import static com.joye.hk6domain.constants.Number.N_23;
import static com.joye.hk6domain.constants.Number.N_24;
import static com.joye.hk6domain.constants.Number.N_25;
import static com.joye.hk6domain.constants.Number.N_26;
import static com.joye.hk6domain.constants.Number.N_27;
import static com.joye.hk6domain.constants.Number.N_28;
import static com.joye.hk6domain.constants.Number.N_29;
import static com.joye.hk6domain.constants.Number.N_3;
import static com.joye.hk6domain.constants.Number.N_30;
import static com.joye.hk6domain.constants.Number.N_31;
import static com.joye.hk6domain.constants.Number.N_32;
import static com.joye.hk6domain.constants.Number.N_33;
import static com.joye.hk6domain.constants.Number.N_34;
import static com.joye.hk6domain.constants.Number.N_35;
import static com.joye.hk6domain.constants.Number.N_36;
import static com.joye.hk6domain.constants.Number.N_37;
import static com.joye.hk6domain.constants.Number.N_38;
import static com.joye.hk6domain.constants.Number.N_39;
import static com.joye.hk6domain.constants.Number.N_4;
import static com.joye.hk6domain.constants.Number.N_40;
import static com.joye.hk6domain.constants.Number.N_41;
import static com.joye.hk6domain.constants.Number.N_42;
import static com.joye.hk6domain.constants.Number.N_43;
import static com.joye.hk6domain.constants.Number.N_44;
import static com.joye.hk6domain.constants.Number.N_45;
import static com.joye.hk6domain.constants.Number.N_46;
import static com.joye.hk6domain.constants.Number.N_47;
import static com.joye.hk6domain.constants.Number.N_48;
import static com.joye.hk6domain.constants.Number.N_49;
import static com.joye.hk6domain.constants.Number.N_5;
import static com.joye.hk6domain.constants.Number.N_6;
import static com.joye.hk6domain.constants.Number.N_7;
import static com.joye.hk6domain.constants.Number.N_8;
import static com.joye.hk6domain.constants.Number.N_9;

/**
 * Created by W,x (JoyeWang)
 * on 2016/9/21.
 * 304622254@qq.com
 * Remeark:��Ф
 */

public enum ChineseZodiac implements IProbability, INumbersTime, INumbers {

    /**
     * ����
     */
    Mouse {
        @Override
        public double getTheoryProbability() {
            return Probalility.ChineseZodiac.Default;
        }

        @Override
        public int[] getNumbers(long time) {
            if (time >= Time_2016) {
                return getNumbers();
            } else if (time >= Time_2015) {
                return new int[]{N_8,N_20,N_32,N_44};
            } else if (time >= Time_2014) {
                return new int[]{N_7,N_19,N_31,N_43};
            }else{
                return new int[]{N_6,N_18,N_30,N_42};
            }
//            return getNumbers();
        }

        @Override
        public int[] getNumbers() {
            return new int[]{N_9, N_21, N_33, N_45};
        }
    },
    /**
     * ţ
     */
    Cow {
        @Override
        public double getTheoryProbability() {
            return Probalility.ChineseZodiac.Default;
        }

        @Override
        public int[] getNumbers(long time) {
            if(time >=Time_2016){
                return getNumbers();
            }else if(time>=Time_2015){
                return new int[]{N_7,N_19,N_31,N_43};
            }else if(time>=Time_2014){
                return new int[]{N_6,N_18,N_30,N_42};
            }else {
                return new int[]{N_5,N_17,N_29,N_41};
            }

        }

        @Override
        public int[] getNumbers() {
            return new int[]{N_8,N_20,N_32,N_44};
        }
    },
    /**
     * ��
     */
    Tiger {
        @Override
        public double getTheoryProbability() {
            return Probalility.ChineseZodiac.Default;
        }

        @Override
        public int[] getNumbers(long time) {
            if(time >=Time_2016){
                return getNumbers();
            }else if(time>=Time_2015){
                return new int[]{N_6,N_18,N_30,N_42};
            }else if(time>=Time_2014){
                return new int[]{N_5,N_17,N_29,N_41};
            }else {
                return new int[]{N_4,N_16,N_28,N_40};
            }
        }

        @Override
        public int[] getNumbers() {
            return new int[]{N_7, N_19, N_31, N_43};
        }
    },
    /**
     * ��
     */
    Rabbit {
        @Override
        public double getTheoryProbability() {
            return Probalility.ChineseZodiac.Default;
        }

        @Override
        public int[] getNumbers(long time) {
            if(time >=Time_2016){
                return getNumbers();
            }else if(time>=Time_2015){
                return new int[]{N_5,N_17,N_29,N_41};
            }else if(time>=Time_2014){
                return new int[]{N_4,N_16,N_28,N_40};
            }else{
                return new int[]{N_3,N_15,N_27,N_39};
            }

        }

        @Override
        public int[] getNumbers() {
            return new int[]{N_6, N_18, N_30, N_42};
        }
    },
    /**
     * ��
     */
    Dragon {
        @Override
        public double getTheoryProbability() {
            return Probalility.ChineseZodiac.Default;
        }

        @Override
        public int[] getNumbers(long time) {
            if(time >=Time_2016){
                return getNumbers();
            }else if(time>=Time_2015){
                return new int[]{N_4,N_16,N_28,N_40};
            }else if(time>=Time_2014){
                return new int[]{N_3,N_15,N_27,N_39};
            }else{
                return new int[]{N_2,N_14,N_26,N_38};
            }

        }

        @Override
        public int[] getNumbers() {
            return new int[]{N_5, N_17, N_29, N_41};
        }
    },
    /**
     * ��
     */
    Snake {
        @Override
        public double getTheoryProbability() {
            return Probalility.ChineseZodiac.Default;
        }

        @Override
        public int[] getNumbers(long time) {
            if(time >=Time_2016){
                return getNumbers();
            }else if(time>=Time_2015){
                return new int[]{N_3,N_15,N_27,N_39};
            }else if(time>=Time_2014){
                return new int[]{N_2,N_14,N_26,N_38};
            }else{
                return new int[]{N_1,N_13,N_25,N_37,N_49};
            }
        }

        @Override
        public int[] getNumbers() {
            return new int[]{N_4, N_16, N_28, N_40};
        }
    },
    /**
     * ��
     */
    Horse {
        @Override
        public double getTheoryProbability() {
            return Probalility.ChineseZodiac.Default;
        }

        @Override
        public int[] getNumbers(long time) {
            if(time >=Time_2016){
                return getNumbers();
            }else if(time>=Time_2015){
                return new int[]{N_2,N_14,N_26,N_38};
            }else if(time>=Time_2014){
                return new int[]{N_1,N_13,N_25,N_37,N_49};
            }else{
                return new int[]{N_12,N_24,N_36,N_48};
            }

        }

        @Override
        public int[] getNumbers() {
            return new int[]{N_3, N_15, N_27, N_39};
        }
    },
    /**
     * ��
     */
    Sheep {
        @Override
        public double getTheoryProbability() {
            return Probalility.ChineseZodiac.Default;
        }

        @Override
        public int[] getNumbers(long time) {
            if(time >=Time_2016){
                return getNumbers();
            }else if(time>=Time_2015){
                return new int[]{N_1,N_13,N_25,N_37,N_49};
            }else if(time>=Time_2014){
                return new int[]{N_12,N_24,N_36,N_48};
            }else{
                return new int[]{N_11,N_23,N_35,N_47};
            }

        }

        @Override
        public int[] getNumbers() {
            return new int[]{N_2, N_14, N_26, N_38};
        }
    },
    /**
     * ��
     */
    Monkey {
        @Override
        public double getTheoryProbability() {
            return Probalility.ChineseZodiac.OnlyOne;
        }

        @Override
        public int[] getNumbers(long time) {
            if(time >=Time_2016){
                return getNumbers();
            }else if(time>=Time_2015){
                return new int[]{N_12,N_24,N_36,N_48};
            }else if(time>=Time_2014){
                return new int[]{N_11,N_23,N_35,N_47};
            }else{
                return new int[]{N_10,N_22,N_34,N_46};
            }
        }

        @Override
        public int[] getNumbers() {
            return new int[]{N_1, N_13, N_25, N_37, N_49};
        }
    },
    /**
     * ��
     */
    Chook {
        @Override
        public double getTheoryProbability() {
            return Probalility.ChineseZodiac.Default;
        }

        @Override
        public int[] getNumbers(long time) {
            if(time >=Time_2016){
                return getNumbers();
            }else if(time>=Time_2015){
                return new int[]{N_11,N_23,N_35,N_47};
            }else if(time>=Time_2014){
                return new int[]{N_10,N_22,N_34,N_46};
            }else{
                return new int[]{N_9,N_21,N_33,N_45};
            }

        }

        @Override
        public int[] getNumbers() {
            return new int[]{N_12, N_24, N_36, N_48};
        }
    },
    /**
     * ��
     */
    Dog {
        @Override
        public double getTheoryProbability() {
            return Probalility.ChineseZodiac.Default;
        }

        @Override
        public int[] getNumbers(long time) {
            if(time >=Time_2016){
                return getNumbers();
            }else if(time>=Time_2015){
                return new int[]{N_10,N_22,N_34,N_46};
            }else if(time>=Time_2014){
                return new int[]{N_9,N_21,N_33,N_45};
            }else{
                return new int[]{N_8,N_20,N_32,N_44};
            }

        }

        @Override
        public int[] getNumbers() {
            return new int[]{N_11, N_23, N_35, N_47};
        }
    },
    /**
     * ��
     */
    Pig {
        @Override
        public double getTheoryProbability() {
            return Probalility.ChineseZodiac.Default;
        }

        @Override
        public int[] getNumbers(long time) {
            if(time >=Time_2016){
                return getNumbers();
            }else if(time>=Time_2015){
                return new int[]{N_9,N_21,N_33,N_45};
            }else if(time>=Time_2014){
                return new int[]{N_8,N_20,N_32,N_44};
            }else {
                return new int []{N_7,N_19,N_31,N_43};
            }
        }

        @Override
        public int[] getNumbers() {
            return new int[]{N_10, N_22, N_34, N_46};
        }
    };
    /**
     *
     */
    public static final long Time_2016 = 1455197697;
    public static final long Time_2015 = 1425762709;
    public static final long Time_2014 = 1391520610;
}
