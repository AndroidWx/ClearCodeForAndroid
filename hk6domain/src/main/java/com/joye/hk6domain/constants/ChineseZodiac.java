package com.joye.hk6domain.constants;

/**
 * Created by W,x (JoyeWang)
 * on 2016/9/21.
 * 304622254@qq.com
 * Remeark:��Ф
 */

public enum ChineseZodiac implements   INumbersTime {


    /**
     * ����
     */
    Mouse {
        @Override
        public int[] getNumbers(int time) {
            return getNumbers(time,this);
        }


    },
    /**
     * ţ
     */
    Cow {
        @Override
        public int[] getNumbers(int time) {
            return getNumbers(time,this);
        }
    },
    /**
     * ��
     */
    Tiger {
        @Override
        public int[] getNumbers(int time) {
            return getNumbers(time,this);
        }
    },
    /**
     * ��
     */
    Rabbit {

        @Override
        public int[] getNumbers(int time) {
            return getNumbers(time,this);
        }

    },
    /**
     * ��
     */
    Dragon {
        @Override
        public int[] getNumbers(int time) {
            return getNumbers(time,this);
        }

    },
    /**
     * ��
     */
    Snake {
        @Override
        public int[] getNumbers(int time) {
            return getNumbers(time,this);
        }

    },
    /**
     * ��
     */
    Horse {
        @Override
        public int[] getNumbers(int time) {
            return getNumbers(time,this);
        }

    },
    /**
     * ��
     */
    Sheep {
        @Override
        public int[] getNumbers(int time) {
            return getNumbers(time,this);
        }

    },
    /**
     * ��
     */
    Monkey {
        @Override
        public int[] getNumbers(int time) {
            return getNumbers(time,this);
        }

    },
    /**
     * ��
     */
    Chook {
        @Override
        public int[] getNumbers(int time) {
            return getNumbers(time,this);
        }

    },
    /**
     * ��
     */
    Dog {
        @Override
        public int[] getNumbers(int time) {
            return getNumbers(time,this);
        }

    },
    /**
     * ��
     */
    Pig {
        @Override
        public int[] getNumbers(int time) {
            return getNumbers(time,this);
        }

    };
    /**
     *
     */
    public static final long Time_2017 = 1483450478;
    public static final long Time_2016 = 1455197697;
    public static final long Time_2015 = 1425762709;
    public static final long Time_2014 = 1391520610;
    public ChineseZodiac getYear(Integer year){
        Integer start=1900;
        ChineseZodiac [] years=new ChineseZodiac[]{
                Mouse,Cow,Tiger,Rabbit,
                Dragon,Snake,Horse,Sheep,
                Monkey,Chook,Dog,Pig
        };
        return years[(year-start)%years.length];
    }
    public int[] getInts(int c) {
        int[] newDatas=new int[4];
        for (int i=0;i<4;i++){
            newDatas[i]=consts[i]+c;
        }
        return newDatas;
    }

    public int[] getNumbers(int time,ChineseZodiac mChineseZodiac){
        ChineseZodiac chineseZodiac=getYear(time);
        if(chineseZodiac==mChineseZodiac){
            return consts;
        }else{
            int c=chineseZodiac.ordinal()-mChineseZodiac.ordinal();
            return getInts(c);
        }
    }
    static int [] consts=new int[]{1,13,25,37,49};

}
