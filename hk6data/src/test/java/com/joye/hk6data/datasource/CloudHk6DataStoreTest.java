package com.joye.hk6data.datasource;

import com.joye.hk6data.ApplicationTestCase;
import com.joye.hk6data.cache.impl.Hk6Cache;
import com.joye.hk6data.net.Hk6RestApi;
import com.joye.hk6data.repository.datasource.CloudHk6DataStore;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.verify;

/**
 * Created by W,x (JoyeWang)
 * on 2016/9/20.
 * 304622254@qq.com
 * Remeark:
 */

public class CloudHk6DataStoreTest extends ApplicationTestCase {
    private static final String DATE = "2016-09-17";

    @Mock
    private Hk6RestApi hk6RestApi;
    @Mock
    private Hk6Cache hk6Cache;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        cloudHk6DataStore=new CloudHk6DataStore(hk6RestApi,hk6Cache);
    }
    private CloudHk6DataStore cloudHk6DataStore;
    @Test
    public void testGetHk6DataList() throws Exception {
//        cloudHk6DataStore.getHk6ListData(DATE);
        verify(cloudHk6DataStore).getHk6ListData(DATE);
    }
}
