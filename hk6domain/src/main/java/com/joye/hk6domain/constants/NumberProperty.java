package com.joye.hk6domain.constants;


import java.util.Arrays;

import static com.joye.hk6domain.constants.ChineseZodiac.Cow;
import static com.joye.hk6domain.constants.ChineseZodiac.Dog;
import static com.joye.hk6domain.constants.ChineseZodiac.Dragon;
import static com.joye.hk6domain.constants.ChineseZodiac.Horse;
import static com.joye.hk6domain.constants.ChineseZodiac.Monkey;
import static com.joye.hk6domain.constants.ChineseZodiac.Mouse;
import static com.joye.hk6domain.constants.ChineseZodiac.Pig;
import static com.joye.hk6domain.constants.ChineseZodiac.Rabbit;
import static com.joye.hk6domain.constants.ChineseZodiac.Sheep;
import static com.joye.hk6domain.constants.ChineseZodiac.Snake;
import static com.joye.hk6domain.constants.ChineseZodiac.Tiger;
import static com.joye.hk6domain.constants.Hk6Color.Blue;
import static com.joye.hk6domain.constants.Hk6Color.Green;
import static com.joye.hk6domain.constants.Hk6Color.Red;
import static com.joye.hk6domain.constants.Number.N_1;
import static com.joye.hk6domain.constants.Number.N_10;
import static com.joye.hk6domain.constants.Number.N_11;
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
 * Created by Wx on 2016/9/25.
 * QQ:304622254;
 * remark:
 */

public enum NumberProperty implements INumberProperty{
    N1 {
        @Override
        public int getValue() {
            return N_1;
        }

        @Override
        public ChineseZodiac getChineseZodiac() {
            for (ChineseZodiac zodiac:ChineseZodiac.values()){
                if(Arrays.asList(zodiac.getNumbers()).contains(getValue())){
                    return zodiac;
                }
            }
            return Monkey;
        }

        @Override
        public Hk6Color getHk6Color() {
            for (Hk6Color color:Hk6Color.values()){
                if(Arrays.asList(color.getNumbers()).contains(getValue())){
                    return color;
                }
            }
            return Red;
        }

        @Override
        public Parity getParity() {
            for (Parity parity:Parity.values()){
                if(Arrays.asList(parity.getNumbers()).contains(getValue())){
                    return parity;
                }
            }
            return Parity.Even;
        }

        @Override
        public PrimeCompositeNumber getPrimeCompositeNumber() {
            return PrimeCompositeNumber.One;
        }

        @Override
        public Region getRegion() {
            for (Region region:Region.values()){
                if(Arrays.asList(region.getNumbers()).contains(getValue())){
                    return region;
                }
            }
            return Region.One;
        }
    },N2 {
        @Override
        public int getValue() {
            return N_2;
        }

        @Override
        public ChineseZodiac getChineseZodiac() {
            for (ChineseZodiac zodiac:ChineseZodiac.values()){
                if(Arrays.asList(zodiac.getNumbers()).contains(getValue())){
                    return zodiac;
                }
            }
            return Sheep;
        }

        @Override
        public Hk6Color getHk6Color() {
            for (Hk6Color color:Hk6Color.values()){
                if(Arrays.asList(color.getNumbers()).contains(getValue())){
                    return color;
                }
            }
            return Red;
        }

        @Override
        public Parity getParity() {
            for (Parity parity:Parity.values()){
                if(Arrays.asList(parity.getNumbers()).contains(getValue())){
                    return parity;
                }
            }
            return Parity.Odd;
        }

        @Override
        public PrimeCompositeNumber getPrimeCompositeNumber() {
            for (PrimeCompositeNumber parity:PrimeCompositeNumber.values()){
                if(Arrays.asList(parity.getNumbers()).contains(getValue())){
                    return parity;
                }
            }
            return PrimeCompositeNumber.Prime;
        }

        @Override
        public Region getRegion() {
            for (Region region:Region.values()){
                if(Arrays.asList(region.getNumbers()).contains(getValue())){
                    return region;
                }
            }
            return Region.One;
        }
    },N3 {
        @Override
        public int getValue() {
            return N_3;
        }

        @Override
        public ChineseZodiac getChineseZodiac() {
            for (ChineseZodiac zodiac:ChineseZodiac.values()){
                if(Arrays.asList(zodiac.getNumbers()).contains(getValue())){
                    return zodiac;
                }
            }
            return Horse;
        }

        @Override
        public Hk6Color getHk6Color() {
            for (Hk6Color color:Hk6Color.values()){
                if(Arrays.asList(color.getNumbers()).contains(getValue())){
                    return color;
                }
            }
            return Blue;
        }

        @Override
        public Parity getParity() {
            for (Parity parity:Parity.values()){
                if(Arrays.asList(parity.getNumbers()).contains(getValue())){
                    return parity;
                }
            }
            return Parity.Even;
        }

        @Override
        public PrimeCompositeNumber getPrimeCompositeNumber() {
            for (PrimeCompositeNumber parity:PrimeCompositeNumber.values()){
                if(Arrays.asList(parity.getNumbers()).contains(getValue())){
                    return parity;
                }
            }
            return PrimeCompositeNumber.Prime;
        }

        @Override
        public Region getRegion() {
            for (Region region:Region.values()){
                if(Arrays.asList(region.getNumbers()).contains(getValue())){
                    return region;
                }
            }
            return Region.One;
        }
    },N4 {
        @Override
        public int getValue() {
            return N_4;
        }

        @Override
        public ChineseZodiac getChineseZodiac() {
            for (ChineseZodiac zodiac:ChineseZodiac.values()){
                if(Arrays.asList(zodiac.getNumbers()).contains(getValue())){
                    return zodiac;
                }
            }
            return Snake;
        }

        @Override
        public Hk6Color getHk6Color() {
            for (Hk6Color color:Hk6Color.values()){
                if(Arrays.asList(color.getNumbers()).contains(getValue())){
                    return color;
                }
            }
            return Blue;
        }

        @Override
        public Parity getParity() {
            for (Parity parity:Parity.values()){
                if(Arrays.asList(parity.getNumbers()).contains(getValue())){
                    return parity;
                }
            }
            return Parity.Even;
        }

        @Override
        public PrimeCompositeNumber getPrimeCompositeNumber() {
            for (PrimeCompositeNumber parity:PrimeCompositeNumber.values()){
                if(Arrays.asList(parity.getNumbers()).contains(getValue())){
                    return parity;
                }
            }
            return PrimeCompositeNumber.Composite;
        }

        @Override
        public Region getRegion() {
            for (Region region:Region.values()){
                if(Arrays.asList(region.getNumbers()).contains(getValue())){
                    return region;
                }
            }
            return Region.One;
        }
    },N5 {
        @Override
        public int getValue() {
            return N_5;
        }

        @Override
        public ChineseZodiac getChineseZodiac() {
            for (ChineseZodiac zodiac:ChineseZodiac.values()){
                if(Arrays.asList(zodiac.getNumbers()).contains(getValue())){
                    return zodiac;
                }
            }
            return Dragon;
        }

        @Override
        public Hk6Color getHk6Color() {
            for (Hk6Color color:Hk6Color.values()){
                if(Arrays.asList(color.getNumbers()).contains(getValue())){
                    return color;
                }
            }
            return Green;
        }

        @Override
        public Parity getParity() {
            for (Parity parity:Parity.values()){
                if(Arrays.asList(parity.getNumbers()).contains(getValue())){
                    return parity;
                }
            }
            return Parity.Odd;
        }

        @Override
        public PrimeCompositeNumber getPrimeCompositeNumber() {
            for (PrimeCompositeNumber parity:PrimeCompositeNumber.values()){
                if(Arrays.asList(parity.getNumbers()).contains(getValue())){
                    return parity;
                }
            }
            return PrimeCompositeNumber.Prime;
        }

        @Override
        public Region getRegion() {
            for (Region region:Region.values()){
                if(Arrays.asList(region.getNumbers()).contains(getValue())){
                    return region;
                }
            }
            return Region.One;
        }
    },N6 {
        @Override
        public int getValue() {
            return N_6;
        }

        @Override
        public ChineseZodiac getChineseZodiac() {
            for (ChineseZodiac zodiac:ChineseZodiac.values()){
                if(Arrays.asList(zodiac.getNumbers()).contains(getValue())){
                    return zodiac;
                }
            }
            return Rabbit;
        }

        @Override
        public Hk6Color getHk6Color() {
            for (Hk6Color color:Hk6Color.values()){
                if(Arrays.asList(color.getNumbers()).contains(getValue())){
                    return color;
                }
            }
            return Green;
        }

        @Override
        public Parity getParity() {
            for (Parity parity:Parity.values()){
                if(Arrays.asList(parity.getNumbers()).contains(getValue())){
                    return parity;
                }
            }
            return Parity.Odd;
        }

        @Override
        public PrimeCompositeNumber getPrimeCompositeNumber() {
            for (PrimeCompositeNumber parity:PrimeCompositeNumber.values()){
                if(Arrays.asList(parity.getNumbers()).contains(getValue())){
                    return parity;
                }
            }
            return PrimeCompositeNumber.Composite;
        }

        @Override
        public Region getRegion() {
            for (Region region:Region.values()){
                if(Arrays.asList(region.getNumbers()).contains(getValue())){
                    return region;
                }
            }
            return Region.One;
        }
    },N7 {
        @Override
        public int getValue() {
            return N_7;
        }

        @Override
        public ChineseZodiac getChineseZodiac() {
            for (ChineseZodiac zodiac:ChineseZodiac.values()){
                if(Arrays.asList(zodiac.getNumbers()).contains(getValue())){
                    return zodiac;
                }
            }
            return Tiger;
        }

        @Override
        public Hk6Color getHk6Color() {
            for (Hk6Color color:Hk6Color.values()){
                if(Arrays.asList(color.getNumbers()).contains(getValue())){
                    return color;
                }
            }
            return Red;
        }

        @Override
        public Parity getParity() {
            for (Parity parity:Parity.values()){
                if(Arrays.asList(parity.getNumbers()).contains(getValue())){
                    return parity;
                }
            }
            return Parity.Odd;
        }

        @Override
        public PrimeCompositeNumber getPrimeCompositeNumber() {
            for (PrimeCompositeNumber parity:PrimeCompositeNumber.values()){
                if(Arrays.asList(parity.getNumbers()).contains(getValue())){
                    return parity;
                }
            }
            return PrimeCompositeNumber.Prime;
        }

        @Override
        public Region getRegion() {
            for (Region region:Region.values()){
                if(Arrays.asList(region.getNumbers()).contains(getValue())){
                    return region;
                }
            }
            return Region.One;
        }
    },N8 {
        @Override
        public int getValue() {
            return N_8;
        }

        @Override
        public ChineseZodiac getChineseZodiac() {
            for (ChineseZodiac zodiac:ChineseZodiac.values()){
                if(Arrays.asList(zodiac.getNumbers()).contains(getValue())){
                    return zodiac;
                }
            }
            return Cow;
        }

        @Override
        public Hk6Color getHk6Color() {
            for (Hk6Color color:Hk6Color.values()){
                if(Arrays.asList(color.getNumbers()).contains(getValue())){
                    return color;
                }
            }
            return Red;
        }

        @Override
        public Parity getParity() {
            return (getValue() & 1) == 0 ? Parity.Odd : Parity.Even;
        }

        @Override
        public PrimeCompositeNumber getPrimeCompositeNumber() {
            return Hk6EnumHelp.getPrimeCompositeNumber(getValue());
        }

        @Override
        public Region getRegion() {
            for (Region region:Region.values()){
                if(Arrays.asList(region.getNumbers()).contains(getValue())){
                    return region;
                }
            }
            return Region.Two;
        }
    },N9{
        @Override
        public int getValue() {
            return N_9;
        }

        @Override
        public ChineseZodiac getChineseZodiac() {
            for (ChineseZodiac zodiac:ChineseZodiac.values()){
                if(Arrays.asList(zodiac.getNumbers()).contains(getValue())){
                    return zodiac;
                }
            }
            return Mouse;
        }

        @Override
        public Hk6Color getHk6Color() {
            for (Hk6Color color:Hk6Color.values()){
                if(Arrays.asList(color.getNumbers()).contains(getValue())){
                    return color;
                }
            }
            return Blue;
        }

        @Override
        public Parity getParity() {
            return (getValue() & 1) == 0 ? Parity.Odd : Parity.Even;
        }

        @Override
        public PrimeCompositeNumber getPrimeCompositeNumber() {
            return Hk6EnumHelp.getPrimeCompositeNumber(getValue());
        }

        @Override
        public Region getRegion() {
            for (Region region:Region.values()){
                if(Arrays.asList(region.getNumbers()).contains(getValue())){
                    return region;
                }
            }
            return Region.Two;
        }
    },N10 {
        @Override
        public int getValue() {
            return N_10;
        }

        @Override
        public ChineseZodiac getChineseZodiac() {
            for (ChineseZodiac zodiac:ChineseZodiac.values()){
                if(Arrays.asList(zodiac.getNumbers()).contains(getValue())){
                    return zodiac;
                }
            }
            return Pig;
        }

        @Override
        public Hk6Color getHk6Color() {
            for (Hk6Color color:Hk6Color.values()){
                if(Arrays.asList(color.getNumbers()).contains(getValue())){
                    return color;
                }
            }
            return Blue;
        }

        @Override
        public Parity getParity() {
            return (getValue() & 1) == 0 ? Parity.Odd : Parity.Even;
        }

        @Override
        public PrimeCompositeNumber getPrimeCompositeNumber() {
            return Hk6EnumHelp.getPrimeCompositeNumber(getValue());
        }

        @Override
        public Region getRegion() {
            for (Region region:Region.values()){
                if(Arrays.asList(region.getNumbers()).contains(getValue())){
                    return region;
                }
            }
            return Region.Two;
        }
    },N11 {
        @Override
        public int getValue() {
            return N_11;
        }

        @Override
        public ChineseZodiac getChineseZodiac() {
            for (ChineseZodiac zodiac:ChineseZodiac.values()){
                if(Arrays.asList(zodiac.getNumbers()).contains(getValue())){
                    return zodiac;
                }
            }
            return Dog;
        }

        @Override
        public Hk6Color getHk6Color() {
            for (Hk6Color color:Hk6Color.values()){
                if(Arrays.asList(color.getNumbers()).contains(getValue())){
                    return color;
                }
            }
            return Green;
        }

        @Override
        public Parity getParity() {
            return (getValue() & 1) == 0 ? Parity.Odd : Parity.Even;
        }

        @Override
        public PrimeCompositeNumber getPrimeCompositeNumber() {
            return Hk6EnumHelp.getPrimeCompositeNumber(getValue());
        }

        @Override
        public Region getRegion() {
            for (Region region:Region.values()){
                if(Arrays.asList(region.getNumbers()).contains(getValue())){
                    return region;
                }
            }
            return Region.Two;
        }
    },N12 {
        @Override
        public int getValue() {
            return N_11;
        }

        @Override
        public ChineseZodiac getChineseZodiac() {
            for (ChineseZodiac zodiac:ChineseZodiac.values()){
                if(Arrays.asList(zodiac.getNumbers()).contains(getValue())){
                    return zodiac;
                }
            }
            return Dog;
        }

        @Override
        public Region getRegion() {
            for (Region region:Region.values()){
                if(Arrays.asList(region.getNumbers()).contains(getValue())){
                    return region;
                }
            }
            return Region.Two;
        }
    },N13 {
        @Override
        public int getValue() {
            return N_13;
        }
    },N14 {
        @Override
        public int getValue() {
            return N_14;
        }
    },N15 {
        @Override
        public int getValue() {
            return N_15;
        }
    },N16 {
        @Override
        public int getValue() {
            return N_16;
        }
    },N17 {
        @Override
        public int getValue() {
            return N_17;
        }
    },N18 {
        @Override
        public int getValue() {
            return N_18;
        }
    },N19 {
        @Override
        public int getValue() {
            return N_19;
        }
    },N20 {
        @Override
        public int getValue() {
            return N_20;
        }
    },N21 {
        @Override
        public int getValue() {
            return N_21;
        }
    },N22 {
        @Override
        public int getValue() {
            return N_22;
        }
    },N23 {
        @Override
        public int getValue() {
            return N_23;
        }
    },N24 {
        @Override
        public int getValue() {
            return N_24;
        }
    },N25 {
        @Override
        public int getValue() {
            return N_25;
        }
    },N26 {
        @Override
        public int getValue() {
            return N_26;
        }
    },N27{
        @Override
        public int getValue() {
            return N_27;
        }
    },N28{
        @Override
        public int getValue() {
            return N_28;
        }
    },N29{
        @Override
        public int getValue() {
            return N_29;
        }
    },N30{
        @Override
        public int getValue() {
            return N_30;
        }
    },N31{
        @Override
        public int getValue() {
            return N_31;
        }
    },N32{
        @Override
        public int getValue() {
            return N_32;
        }
    },N33{
        @Override
        public int getValue() {
            return N_33;
        }
    },N34{
        @Override
        public int getValue() {
            return N_34;
        }
    },N35{
        @Override
        public int getValue() {
            return N_35;
        }
    },N36{
        @Override
        public int getValue() {
            return N_36;
        }
    },N37{
        @Override
        public int getValue() {
            return N_37;
        }
    },N38{
        @Override
        public int getValue() {
            return N_38;
        }
    },N39{
        @Override
        public int getValue() {
            return N_39;
        }
    },N40{
        @Override
        public int getValue() {
            return N_40;
        }
    },N41{
        @Override
        public int getValue() {
            return N_41;
        }
    },N42{
        @Override
        public int getValue() {
            return N_42;
        }
    },N43{
        @Override
        public int getValue() {
            return N_43;
        }
    },N44{
        @Override
        public int getValue() {
            return N_44;
        }
    },N45{
        @Override
        public int getValue() {
            return N_45;
        }
    },N46{
        @Override
        public int getValue() {
            return N_46;
        }
    },N47{
        @Override
        public int getValue() {
            return N_47;
        }
    },N48{
        @Override
        public int getValue() {
            return N_48;
        }
    },N49{
        @Override
        public int getValue() {
            return N_49;
        }
    };


    @Override
    public PrimeCompositeNumber getPrimeCompositeNumber() {
        return Hk6EnumHelp.getPrimeCompositeNumber(getValue());
    }
    @Override
    public Parity getParity() {
        return (getValue() & 1) == 0 ? Parity.Odd : Parity.Even;
    }
    @Override
    public Hk6Color getHk6Color() {
        for (Hk6Color color:Hk6Color.values()){
            if(Arrays.asList(color.getNumbers()).contains(getValue())){
                return color;
            }
        }
        return Green;
    }
    @Override
    public ChineseZodiac getChineseZodiac() {
        for (ChineseZodiac zodiac:ChineseZodiac.values()){
            if(Arrays.asList(zodiac.getNumbers()).contains(getValue())){
                return zodiac;
            }
        }
        return Dog;
    }
    @Override
    public Region getRegion() {
        for (Region region:Region.values()){
            if(Arrays.asList(region.getNumbers()).contains(getValue())){
                return region;
            }
        }
        return Region.Two;
    }

    @Override
    public Hk6Size getSize() {
        return Hk6EnumHelp.getHk6Size(getValue());
    }


}
