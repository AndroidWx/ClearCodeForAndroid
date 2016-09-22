package com.joye.hk6.ac;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.os.StrictMode;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import com.apkfuns.logutils.LogUtils;
import com.joye.hk6.BuildConfig;
import com.joye.hk6.R;
import com.joye.hk6.StatusBarHelp;
import com.joye.hk6.common.ac.MethodInvoke;
import com.joye.hk6.common.ac.WindowAnimation;

import javax.inject.Inject;

/**
 * Created by W,x (JoyeWang)
 * on 2016/9/22.
 * 304622254@qq.com
 * Remeark:
 */

public class EmptyActivity extends BaseFragmentActivity implements
        IActivityResultDelegateAware {
    @Inject
    StatusBarHelp statusBarHelp;

    private IActivityResultDelegate activityResultDelegate;


    public static final String EXTRA_CLASSNAME = "cls";

    /**
     * 本activity所加载的主Fragment
     */
    private Fragment mainFragment;

    public static Intent newIntent(Context context, Class mClass){
        Intent intent=new Intent(context,EmptyActivity.class);
        intent.putExtra(EXTRA_CLASSNAME,mClass.getName());
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(BuildConfig.DEBUG){
            StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().build());
            StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder().detectAll().build());
        }
        Intent intent = getIntent();
        setContentView(R.layout.f_emptycontent);
        super.onCreate(savedInstanceState);

        if (intent != null && intent.hasExtra(EXTRA_CLASSNAME)) {

            FragmentTransaction tran = getSupportFragmentManager()
                    .beginTransaction();
            String cls = intent.getStringExtra(EXTRA_CLASSNAME);
            try {
                mainFragment = Fragment.class.cast(Class.forName(cls)
                        .newInstance());
                tran.replace(R.id.emptyContent, mainFragment);
            } catch (Exception e) {
                LogUtils.e( "instant fragment failed " + cls);
            }
            tran.commit();
        }
        statusBarHelp.setStatusBarTintEnable(true,getResources().getDrawable(R.drawable.statusbar_bg));
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
    }

    private WindowAnimation mAnimation = new WindowAnimation();
    @Override
    public void finish() {
        super.finish();
        super.overridePendingTransition(mAnimation.closeEnter, mAnimation.closeExit);
        if((0x2 & MethodInvoke.getAnnotationValue(super.getClass())) == 0) {
            return ;
        }
        if ((0x4 & MethodInvoke.getAnnotationValue(super.getClass())) != 0) {
            MethodInvoke.startTransitionNotChange(this);
            return ;
        }
        MethodInvoke.startTransitionPopout(this);
    }
    private void onStartActivityAction(Intent intent) {
        if(intent == null) {
            super.overridePendingTransition(R.anim.slide_right_in, R.anim.slide_left_out);
            return ;
        }
        String className = null;
        ComponentName component = intent.getComponent();
        if(component != null) {
            className = component.getClassName();
            if (!(className.startsWith(component.getPackageName()))) {
                className = component.getPackageName() + component.getClassName();
            }
        } else {
            return ;
        }
        if((0x2 & MethodInvoke.getTransitionValue(className)) != 0) {
            super.overridePendingTransition(mAnimation.openEnter, mAnimation.openExit);
            return ;
        }

        if((0x4 & MethodInvoke.getTransitionValue(className)) != 0) {
            MethodInvoke.startTransitionNotChange(this);
            return ;
        }
        MethodInvoke.startTransitionPopin(this);
    }
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    @Override
    public void startActivities(Intent[] intents) {
        super.startActivities(intents);
        onStartActivityAction(null);
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public void startActivities(Intent[] intents, Bundle bundle) {
        super.startActivities(intents, bundle);
        onStartActivityAction(null);
    }

    @Override
    public void startActivity(Intent intent) {
        super.startActivity(intent);
        onStartActivityAction(intent);
    }

    @Override
    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    public void startActivity(Intent intent, Bundle bundle) {
        super.startActivity(intent, bundle);
        onStartActivityAction(intent);
    }

    @Override
    public void startActivityForResult(Intent intent, int requestCode) {
        super.startActivityForResult(intent, requestCode);
        onStartActivityAction(intent);
    }

    @Override
    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    public void startActivityForResult(Intent intent, int requestCode, Bundle options) {
        super.startActivityForResult(intent, requestCode, options);
        onStartActivityAction(intent);
    }

    @Override
    protected void onResumeFragments() {
        super.onResumeFragments();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (mainFragment != null
                && mainFragment instanceof IFragmentOnKeyDownHandler) {
            return IFragmentOnKeyDownHandler.class.cast(mainFragment)
                    .onKeyDown(keyCode, event);
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (activityResultDelegate != null) {
            if (activityResultDelegate.onActivityResult(requestCode,
                    resultCode, data)) {
                return;
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    /**
     * 需要截取按键事件的处理器
     *
     * @author wx
     *
     */
    public interface IFragmentOnKeyDownHandler {

        /**
         * Fragment 处理按钮下按的事件
         *
         * @param keyCode
         *            键值
         * @param event
         *            事件
         * @return <code>true</code>Fragment已经处理
         */
        boolean onKeyDown(int keyCode, KeyEvent event);
    }


//    /**
//     * hide inputMethod
//     */
//    @Override
//    public void hideSoftKeyboard() {
//        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
//        if(inputMethodManager != null ) {
//            View localView = getCurrentFocus();
//            if(localView != null && localView.getWindowToken() != null ) {
//                IBinder windowToken = localView.getWindowToken();
//                inputMethodManager.hideSoftInputFromWindow(windowToken, 0);
//            }
//        }
//    }

    @Override
    public Activity getActivity() {
        return this;
    }

    @Override
    public void setActivityResultDelegate(IActivityResultDelegate delegate) {
        this.activityResultDelegate = delegate;
    }

    /**
     * 需要截取按键事件的处理器
     *
     * @author wx
     *
     */
    public interface IFragmentOnCreateOptionsMenu {

        /**
         * Fragment onCreateOptionsMenu
         *
         * @return <code>true</code>Fragment已经处理
         */
        boolean onCreateOptionsMenu(Menu menu) ;
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        if (mainFragment != null
                && mainFragment instanceof IFragmentOnCreateOptionsMenu) {
            return IFragmentOnCreateOptionsMenu.class.cast(mainFragment)
                    .onCreateOptionsMenu(menu);
        }
        return super.onCreateOptionsMenu(menu);
    }
}
