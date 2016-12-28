package com.joye.hk6.vu.base;

import android.graphics.drawable.Drawable;
import android.support.annotation.CallSuper;
import android.view.View;

import com.google.gson.JsonSyntaxException;
import com.joye.hk6.R;
import com.joye.hk6.adapter.ReportLeftAdapter;
import com.joye.hk6.adapter.ReportRightAdapter;
import com.joye.hk6.mvp.BaseVuImp;
import com.joye.hk6.mvp.ProgressVu;
import com.joye.hk6.util.IProgressListener;
import com.joye.hk6.widget.ReportMeasureHeightListView;
import com.joye.hk6.widget.ReportMeasureWidthListView;
import com.joye.hk6.widget.ReportSyncHorizontalScrollView;
import com.vlonjatg.progressactivity.ProgressActivity;

import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import retrofit2.adapter.rxjava.HttpException;

/**
 * Created by W,x (JoyeWang)
 * on 2016/10/12.
 * 304622254@qq.com
 * Remeark:
 */

public abstract  class ReportBaseVu <T>extends BaseVuImp implements ProgressVu<List<T>> {
    private View.OnClickListener listener;

    public void setErrorRetryListener(View.OnClickListener listener) {
        this.listener = listener;
    }

    @Override
    public void showLoading() {
        progressListener.showLoading();
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
        progressListener.showEmpty(getEmptyDrawable(),getEmptyTextTitle(),getEmptyTextContent(),getSkipIds());
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

        progressListener.showError(getErrorDrawable(),getErrorTextTitle(e),getErrorTextContent(e),getErrorButtonText(e),listener);
    }

    @Override
    public void showContent() {
        progressListener.showContent();
    }

    @BindView(R.id.rightTitleHorscrollView)
    public ReportSyncHorizontalScrollView rightTitleHorscrollView;

    @BindView(R.id.contentListViewLeft)
    public ReportMeasureWidthListView contentListViewLeft;

    @BindView(R.id.rightContentHorscrollView)
    public ReportSyncHorizontalScrollView rightContentHorscrollView;

    @BindView(R.id.contentListViewRight)
    public ReportMeasureHeightListView contentListViewRight;

    public ReportLeftAdapter reportLeftAdapter;

    public ReportRightAdapter reportRightAdapter;


//    @BindView(R.id.ReportSyncHorizontalScrollViewVisibility)
//    public ReportSyncHorizontalScrollView ReportSyncHorizontalScrollViewVisibility;

    @BindView(R.id.progressActivity)
    public ProgressActivity progressActivity;

    private IProgressListener progressListener;

    public IProgressListener getProgressListener() {
        if(progressListener==null){
            progressListener=new IProgressListener(progressActivity);
        }
        return progressListener;
    }
    @CallSuper
    @Override
    protected void initView() {
        progressListener = new IProgressListener(progressActivity);
        rightTitleHorscrollView.setmSyncView(rightContentHorscrollView);
        rightContentHorscrollView.setmSyncView(rightTitleHorscrollView);
        reportLeftAdapter = new ReportLeftAdapter(view.getContext(), 0, new ArrayList<T>());
        contentListViewLeft.setAdapter(reportLeftAdapter);
        reportRightAdapter = new ReportRightAdapter(view.getContext(), 0, new ArrayList<T>());
        contentListViewRight.setAdapter(reportRightAdapter);
    }


}
