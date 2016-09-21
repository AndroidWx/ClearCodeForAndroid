package com.joye.hk6data.datasource;

import android.content.Context;

import com.joye.hk6data.ApplicationTestCase;
import com.joye.hk6data.BuildConfig;
import com.joye.hk6data.MyRunner;
import com.joye.hk6data.cache.impl.Hk6Cache;
import com.joye.hk6data.entity.Hk6Entity;
import com.joye.hk6data.net.BaseApiConstants;
import com.joye.hk6data.net.Hk6RestApi;
import com.joye.hk6data.net.Hk6RestApiImpl;
import com.joye.hk6data.repository.datasource.CloudHk6DataStore;
import com.joye.hk6data.repository.datasource.Hk6DataStore;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;
import org.robolectric.util.Logger;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;
import rx.functions.Action1;
import rx.functions.Func1;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

/**
 * Created by W,x (JoyeWang)
 * on 2016/9/20.
 * 304622254@qq.com
 * Remeark:
 */
@RunWith(MyRunner.class)
@Config(constants = BuildConfig.class)
public class CloudHk6DataStoreTest extends ApplicationTestCase {
    private static final String DATE = "2016-09-17";

    @Mock
    private Hk6RestApi hk6RestApi;
    @Mock
    private Hk6Cache hk6Cache;
    @Mock
    private Context context;
    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Mock
    private CloudHk6DataStore dataStore;
    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        hk6RestApi=new Hk6RestApiImpl(context);
    }
    @Test
    public void testGetHk6DataList() throws Exception {
//        cloudHk6DataStore.getHk6ListData(DATE);
//        List<Hk6Entity> hk6EntityList=new ArrayListyList<>();
//        cloudHk6DataStore.getHk6ListData(DATE).doOnNext(hk6EntityList1 -> {
//            Logger.info("size",hk6EntityList1.size());
//        });
//
//        given(cloudHk6DataStore.getHk6ListData(DATE)).willReturn(Observable.just(hk6EntityList));
        dataStore.getHk6ListData(DATE);
//        verify(hk6RestApi).getHk6ListData("demo","hk6",DATE, BaseApiConstants.FORMAT_JSON);
        verify(dataStore).getHk6ListData(DATE);
    }
}
