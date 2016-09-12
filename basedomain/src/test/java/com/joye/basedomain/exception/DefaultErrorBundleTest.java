package com.joye.basedomain.exception;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import sun.rmi.runtime.Log;

import static org.mockito.Mockito.verify;

/**
 * Created by W,x (JoyeWang)
 * on 2016/9/9.
 * 304622254@qq.com
 * Remeark:
 */

public class DefaultErrorBundleTest {
    private DefaultErrorBundle defaultErrorBundle;

    @Mock
    private Exception mockException;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        defaultErrorBundle = new DefaultErrorBundle(mockException);
    }
    @Test
    public void testGetErrorMessageInteraction() {
        System.out.print(defaultErrorBundle.getErrorMessage());

        verify(mockException).getMessage();
    }
}
