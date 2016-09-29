package com.joye.hk6domain.constants;

import javax.inject.Singleton;

/**
 * Created by W,x (JoyeWang)
 * on 2016/9/21.
 * 304622254@qq.com
 * Remeark:
 */
@Singleton
public class Hk6EnumHelp {
    /**
     * �첨��
     */
    public static final int RedColorNumber[]=   {1,2,7,8,12,13,18,19,23,24,29,30,34,35,40,45,46};
    /**
     * ����
     */
    public static final int BlueColorNumber[]=  {3,4,9,10,14,15,20,25,26,31,36,37,41,42,47,48};
    /**
     * �̲�
     */
    public static final int GreenColorNumber[]= {5,6,11,16,17,21,22,27,28,32,33,38,39,43,44,49};

    public static PrimeCompositeNumber getPrimeCompositeNumber(int n){
        if (n <= 3) {
            return n > 1?PrimeCompositeNumber.Prime:PrimeCompositeNumber.One;
        }
        for(int i=2;i<=Math.sqrt(n);i++){
            if(n%i == 0)
                return PrimeCompositeNumber.Composite;
        }
        return PrimeCompositeNumber.Prime;
    }

    public Parity getParity(int n){
        if(n>=1&&n<=49) {
            return (n & 1) == 0 ? Parity.Odd : Parity.Even;
        }else{
            throw new IllegalArgumentException("��������������");
        }
    }

    public static Region getRegion(int n){
           return Region.values()[Double.valueOf(n/7.001).intValue()];
//        return Region.Seven;
    };

    public static ColorTwos getColorTwos(int n){
        for(ColorTwos colorTwos:ColorTwos.values()){
         for(int item:colorTwos.getNumbers()){
             if(item==n){
                 return colorTwos;
             }
         }
        }
        return ColorTwos.BlueEven;
    }


    public static Hk6Size getHk6Size(int n){
        if(n>=1&&n<=24){
            return Hk6Size.Small;
        }else if(n>=25 &&n<=49){
            return Hk6Size.Big;
        }else{
            throw new IllegalArgumentException("��������������");
        }
    }

    public Hk6Color getHk6Color(int n){
        for(int i=0;i<16;i++){
            if(n==RedColorNumber[i]){
                return Hk6Color.Red;
            }else if(n==BlueColorNumber[i]){
                return Hk6Color.Blue;
            }else if(n==GreenColorNumber[i]){
                return Hk6Color.Green;
            }else {
                return RedColorNumber.length == 17 ?
                        Hk6Color.Red :
                        BlueColorNumber.length == 17 ?
                                Hk6Color.Blue : Hk6Color.Green;
            }
        }
        return Hk6Color.Green;
    }


}
