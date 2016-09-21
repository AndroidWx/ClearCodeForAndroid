package com.joye.hk6data.constants;

/**
 * Created by W,x (JoyeWang)
 * on 2016/9/21.
 * 304622254@qq.com
 * Remeark:生肖
 */

public enum ChineseZodiac implements IProbability {
    /**
     * 老鼠
     */
    Mouse {
        @Override
        public double getTheoryProbability() {
            return Probalility.ChineseZodiac.Default;
        }
    },
    /**
     * 牛
     */
    Cow {
        @Override
        public double getTheoryProbability() {
            return Probalility.ChineseZodiac.Default;
        }
    },
    /**
     * 虎
     */
    Tiger {
        @Override
        public double getTheoryProbability() {
            return Probalility.ChineseZodiac.Default;
        }
    },
    /**
     * 兔
     */
    Rabbit {
        @Override
        public double getTheoryProbability() {
            return Probalility.ChineseZodiac.Default;
        }
    },
    /**
     * 龙
     */
    Dragon {
        @Override
        public double getTheoryProbability() {
            return Probalility.ChineseZodiac.Default;
        }
    },
    /**
     * 蛇
     */
    Snake {
        @Override
        public double getTheoryProbability() {
            return Probalility.ChineseZodiac.Default;
        }
    },
    /**
     * 马
     */
    Horse {
        @Override
        public double getTheoryProbability() {
            return Probalility.ChineseZodiac.Default;
        }
    },
    /**
     * 羊
     */
    Sheep {
        @Override
        public double getTheoryProbability() {
            return Probalility.ChineseZodiac.Default;
        }
    },
    /**
     * 猴
     */
    Monkey {
        @Override
        public double getTheoryProbability() {
            return Probalility.ChineseZodiac.OnlyOne;
        }
    },
    /**
     * 鸡
     */
    Chook {
        @Override
        public double getTheoryProbability() {
            return Probalility.ChineseZodiac.Default;
        }
    },
    /**
     * 狗
     */
    Dog {
        @Override
        public double getTheoryProbability() {
            return Probalility.ChineseZodiac.Default;
        }
    },
    /**
     * 猪
     */
    Pig {
        @Override
        public double getTheoryProbability() {
            return Probalility.ChineseZodiac.Default;
        }
    }

}
