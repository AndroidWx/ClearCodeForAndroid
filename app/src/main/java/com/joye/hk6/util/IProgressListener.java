package com.joye.hk6.util;

import android.graphics.drawable.Drawable;
import android.view.View;

import com.joye.hk6.R;
import com.vlonjatg.progressactivity.ProgressActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Wx on 2015/9/17.
 * progreeActivity 委托者
 */
public class IProgressListener {
    private ProgressActivity mProgressActivity;

    public IProgressListener(ProgressActivity progressActivity) {
        this.mProgressActivity = progressActivity;
    }

    public void showLoading() {
        if (mProgressActivity.isLoading()) {
            return;
        }
        mProgressActivity.showLoading();
    }

    public void showContent() {
        if (mProgressActivity.isContent()) {
            return;
        }
        mProgressActivity.showContent();
    }

    public void showEmpty(Drawable emptyImageDrawable, String emptyTextTitle, String emptyTextContent, List<Integer> skipIds) {
        if (null == skipIds) skipIds = new ArrayList<>();
        if (!mProgressActivity.isEmpty())
            mProgressActivity.showEmpty(emptyImageDrawable, emptyTextTitle, emptyTextContent, skipIds);
    }

    public void showEmpty(Drawable emptyImageDrawable, String emptyTextTitle, String emptyTextContent, List<Integer> skipIds, boolean udpdateFlag) {
        if (null == skipIds) skipIds = new ArrayList<>();
        if (udpdateFlag)
            mProgressActivity.showEmpty(emptyImageDrawable, emptyTextTitle, emptyTextContent, skipIds);
    }

    public void showError(Drawable emptyImageDrawable, String emptyTextTitle, String emptyTextContent, String errorButtonText, View.OnClickListener onClickListener) {
        if (!mProgressActivity.isError()){
            mProgressActivity.showError(mProgressActivity.getContext().getResources().getDrawable(R.drawable.error_network), emptyTextTitle, emptyTextContent, errorButtonText, onClickListener);
        }
    }

    public ProgressActivity getProgressActivity() {
        return mProgressActivity;
    }
}
