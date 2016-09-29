package com.joye.hk6.vu.base;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewStub;

import com.joye.hk6.R;
import com.joye.hk6.adapter.ChineseZodiacProbilityAdapter;
import com.joye.hk6.adapter.UpdateItemRecyclerViewAdapter;
import com.joye.hk6.mvp.ProgressVu;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by W,x (JoyeWang)
 * on 2016/9/24.
 * 304622254@qq.com
 * Remeark:
 */

public class BannberOnePageProgressSwipeRefreshRecyclerVu<T> extends BannerOpnePageSwipeRefreshRecyclerViewVu implements ProgressVu<List<T>> {


    private View.OnClickListener listener;

    public void setErrorRetryListener(View.OnClickListener listener) {
        this.listener = listener;
    }

    @Override
    public void showLoading() {
        iProgressListener.showLoading();
    }

    public Drawable getEmptyDrawable(){
        return  getView().getResources().getDrawable(R.drawable.default_progress_empty);
    }
    public String getEmptyTextTitle(){
        return getView().getResources().getString(R.string.default_progress_empty);
    }
    public String getEmptyTextContent(){
        return getView().getResources().getString(R.string.default_progress_empty);
    }
    public List<Integer> getSkipIds(){
        return new ArrayList<>();
    }
    @Override
    public void showEmpty() {
        iProgressListener.showEmpty(getEmptyDrawable(),getEmptyTextTitle(),getEmptyTextContent(),getSkipIds());
    }
    public Drawable getErrorDrawable(){
        return  getView().getResources().getDrawable(R.drawable.default_progress_empty);
    }
    public String getErrorTextTitle(){
        return getView().getResources().getString(R.string.default_progress_empty);
    }
    public String getErrorTextContent(){
        return getView().getResources().getString(R.string.default_progress_empty);
    }
    public String getErrorButtonText(){
        return getView().getResources().getString(R.string.default_progress_empty);
    }
    @Override
    public void showError(Throwable e) {
        iProgressListener.showError(getErrorDrawable(),getErrorTextTitle(),getErrorTextContent(),getErrorButtonText(),listener);
    }

    @Override
    public void showContent() {
        iProgressListener.showContent();
    }

    @Override
    public void onNext(List<T> chineseZodiacVos) {
        if(mAdapter.getDatas().isEmpty()&&chineseZodiacVos.isEmpty()){
            showEmpty();
            return;
        }
        mAdapter.updateItems(chineseZodiacVos,true);
        showContent();
    }

    @Override
    public UpdateItemRecyclerViewAdapter getRecylerViewAdapter(Context context) {
        return new ChineseZodiacProbilityAdapter(context);
    }

    @Override
    protected void onCreateContentView(ViewStub contentStub) {
        super.onCreateContentView(contentStub);

    }
}
