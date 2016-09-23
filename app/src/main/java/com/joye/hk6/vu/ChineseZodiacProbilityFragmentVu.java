package com.joye.hk6.vu;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.Toast;

import com.apkfuns.logutils.LogUtils;
import com.joye.hk6.R;
import com.joye.hk6.mvp.ProgressVu;
import com.joye.hk6.mvp.Vu;
import com.joye.hk6domain.entity.Hk6UiData;

import java.util.List;

/**
 * Created by W,x (JoyeWang)
 * on 2016/9/22.
 * 304622254@qq.com
 * Remeark:生肖概率的视图
 */
public class ChineseZodiacProbilityFragmentVu implements ProgressVu<List<Hk6UiData>>{
    private View view;
    @Override
    public void init(LayoutInflater layoutInflater, ViewGroup container) {
        view=layoutInflater.inflate(R.layout.activity_scrolling,container);
    }

    @Override
    public View getView() {
        return view;
    }
    @Override
    public void showLoading() {
        LogUtils.d("showLoading");
    }

    @Override
    public void showEmpty() {
        LogUtils.d("showEmpty");
    }

    @Override
    public void showError(Throwable e) {
        LogUtils.d(e);
    }

    @Override
    public void showContent() {
        LogUtils.d("showContent");
    }

    @Override
    public void onNext(List<Hk6UiData> hk6UiDatas) {
        LogUtils.i(hk6UiDatas);
    }
}
