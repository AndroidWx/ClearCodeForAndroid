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

    public static  Composite getComposite(int n){
        for (Composite composite:Composite.values()){
            for (int item:composite.getNumbers()){
                if(item==n){
                    return composite;
                }
            }
        }
        return Composite.C1;
    }

    public static Mantissa getMantissa(int n){
        for (Mantissa composite:Mantissa.values()){
            for (int item:composite.getNumbers()){
                if(item==n){
                    return composite;
                }
            }
        }
        return Mantissa.Mantissa0;
    }

    public static MantissaSize getMantissaSize(int n){
        for (MantissaSize composite:MantissaSize.values()){
            for (int item:composite.getNumbers()){
                if(item==n){
                    return composite;
                }
            }
        }
        return MantissaSize.MantissaBig;
    }

    public static SizeTwos getSizeTwos(int n){
        for (SizeTwos composite:SizeTwos.values()){
            for (int item:composite.getNumbers()){
                if(item==n){
                    return composite;
                }
            }
        }
        return SizeTwos.BigEven;
    }
    public static Modular7 getModular7(int n){
        for (Modular7 mModular7:Modular7.values()){
            for (int item:mModular7.getNumbers()){
                if(item==n){
                    return mModular7;
                }
            }
        }
        return Modular7.M0;
    }
    public static Modular6 getModular6(int n){
        for (Modular6 mModular6:Modular6.values()){
            for (int item:mModular6.getNumbers()){
                if(item==n){
                    return mModular6;
                }
            }
        }
        return Modular6.M0;
    }
    public static Modular5 getModular5(int n){
        for (Modular5 mModular5:Modular5.values()){
            for (int item:mModular5.getNumbers()){
                if(item==n){
                    return mModular5;
                }
            }
        }
        return Modular5.M0;
    }
    public static Modular4 getModular4(int n){
        for (Modular4 mModular4:Modular4.values()){
            for (int item:mModular4.getNumbers()){
                if(item==n){
                    return mModular4;
                }
            }
        }
        return Modular4.M0;
    }
    public static Modular3 getModular3(int n){
        for (Modular3 mModular3:Modular3.values()){
            for (int item:mModular3.getNumbers()){
                if(item==n){
                    return mModular3;
                }
            }
        }
        return Modular3.M0;
    }

    public static HeadTwos getHeadTwos(int n){
        for (HeadTwos compositeMantissa:HeadTwos.values()){
            for (int item:compositeMantissa.getNumbers()){
                if(item==n){
                    return compositeMantissa;
                }
            }
        }
        return HeadTwos.HeadEven0;
    }

    public static CompositeMantissa getCompositeMantissa(int n){
        for (CompositeMantissa compositeMantissa:CompositeMantissa.values()){
            for (int item:compositeMantissa.getNumbers()){
                if(item==n){
                    return compositeMantissa;
                }
            }
        }
        return CompositeMantissa.CM0;
    }

    public static CompositeSize getCompositeSize(int n){
        for (CompositeSize composite:CompositeSize.values()){
            for (int item:composite.getNumbers()){
                if(item==n){
                    return composite;
                }
            }
        }
        return CompositeSize.Big;
    }


    public static HeadAge getHeadAge(int n){
        int value=n/10;
        if(value==0){
            return HeadAge.Headage0;
        }else if(value==1){
            return HeadAge.Headage1;
        }else if(value==2){
            return HeadAge.Headage2;
        }else if(value==3){
            return HeadAge.Headage3;
        }else {
            return HeadAge.Headage4;
        }

    }

    public static GateCount getGateCount(int n){
        for (GateCount composite:GateCount.values()){
            for (int item:composite.getNumbers()){
                if(item==n){
                    return composite;
                }
            }
        }
        return GateCount.GateCount1;
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
