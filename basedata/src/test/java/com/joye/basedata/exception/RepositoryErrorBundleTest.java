package com.joye.basedata.exception;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.verify;

/**
 * Created by W,x (JoyeWang)
 * on 2016/9/19.
 * 304622254@qq.com
 * Remeark:
 */

public class RepositoryErrorBundleTest {
    private RepositoryErrorBundle repositoryErrorBundle;

    @Mock
    private Exception mockException;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        repositoryErrorBundle = new RepositoryErrorBundle(mockException);
    }

    @Test
    public void testGetErrorMessageInteraction() throws Exception {
        repositoryErrorBundle.getErrorMessage();
        verify(mockException).getMessage();
    }
}
