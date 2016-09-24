package com.joye.hk6.vu;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewStub;

import com.joye.hk6.R;
import com.joye.hk6.adapter.ChineseZodiacProbilityAdapter;
import com.joye.hk6.adapter.UpdateItemRecyclerViewAdapter;
import com.joye.hk6.mvp.ProgressVu;
import com.joye.hk6domain.vo.ChineseZodiacVo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by W,x (JoyeWang)
 * on 2016/9/24.
 * 304622254@qq.com
 * Remeark:
 */

public class ChineseZodiacProbilityFragmentVu extends SwipeRefreshRecyclerViewVu implements ProgressVu<List<ChineseZodiacVo>> {


    private View.OnClickListener listener;

    public void setErrorRetryListener(View.OnClickListener listener) {
        this.listener = listener;
    }

    @Override
    public void showLoading() {
        iProgressListener.showLoading();
    }

    @Override
    public void showEmpty() {
        Drawable emptyDrawable=getView().getResources().getDrawable(R.drawable.default_progress_empty);
        String emptyTextTile=getView().getResources().getString(R.string.default_progress_empty);
        String emptyTextContent=getView().getResources().getString(R.string.default_progress_emptyContent);
        List<Integer> skipIds=new ArrayList<>();
        iProgressListener.showEmpty(emptyDrawable,emptyTextTile,emptyTextContent,skipIds);
    }

    @Override
    public void showError(Throwable e) {
        Drawable emptyDrawable=getView().getResources().getDrawable(R.drawable.default_progress_empty);
        String emptyTextTile=getView().getResources().getString(R.string.default_progress_empty);
        String emptyTextContent=getView().getResources().getString(R.string.default_progress_emptyContent);
        String errorButtonText=getView().getResources().getString(R.string.default_progress_emptyContent);
        iProgressListener.showError(emptyDrawable,emptyTextTile,emptyTextContent,errorButtonText,listener);
    }

    @Override
    public void showContent() {
        iProgressListener.showContent();
    }

    @Override
    public void onNext(List<ChineseZodiacVo> chineseZodiacVos) {
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
