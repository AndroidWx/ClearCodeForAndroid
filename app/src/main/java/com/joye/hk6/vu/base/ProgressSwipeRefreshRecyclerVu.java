package com.joye.hk6.vu.base;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.CallSuper;
import android.view.View;

import com.google.gson.JsonSyntaxException;
import com.joye.hk6.R;
import com.joye.hk6.adapter.ChineseZodiacAdapter;
import com.joye.hk6.adapter.UpdateItemRecyclerViewAdapter;
import com.joye.hk6.mvp.ProgressVu;

import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.adapter.rxjava.HttpException;

/**
 * Created by W,x (JoyeWang)
 * on 2016/9/24.
 * 304622254@qq.com
 * Remeark:
 */

public abstract  class ProgressSwipeRefreshRecyclerVu<T> extends SwipeRefreshRecyclerViewVu implements ProgressVu<List<T>> {


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
    public String getErrorTextTitle(Throwable e){
        if(e instanceof JsonSyntaxException){
            return "JSON转换异常";
        }else if(e instanceof HttpException){
            return "http异常";
        }else if(e instanceof SocketTimeoutException){
            return "超时异常";
        }
        return getView().getResources().getString(R.string.default_progress_empty);
    }
    public String getErrorTextContent(Throwable e){
        if(e instanceof JsonSyntaxException){
            return "JSON转换异常";
        }else if(e instanceof HttpException){
            return "http异常";
        }else if(e instanceof SocketTimeoutException){
            return "超时异常";
        }
        return getView().getResources().getString(R.string.default_progress_empty);
    }
    public String getErrorButtonText(Throwable e){
        if(e instanceof JsonSyntaxException){
            return "JSON转换异常";
        }else if(e instanceof HttpException){
            return "http异常";
        }else if(e instanceof SocketTimeoutException){
            return "超时异常";
        }
        return getView().getResources().getString(R.string.default_progress_empty);
    }

    @Override
    public void showError(Throwable e) {
        iProgressListener.showError(getErrorDrawable(), getErrorTextTitle(e), getErrorTextContent(e), getErrorButtonText(e), new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iProgressListener.showLoading();
                listener.onClick(v);
            }
        });
    }

    @Override
    public void showContent() {
        iProgressListener.showContent();
    }
    @CallSuper
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
        return new ChineseZodiacAdapter(context);
    }

}
