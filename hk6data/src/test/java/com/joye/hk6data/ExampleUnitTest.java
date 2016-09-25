package com.joye.hk6data;

import org.junit.Test;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {
        for (int i=1;i<50;i++){
            System.out.print( "public static final int N_+"+i+"="+i+";");
        }
    }
}