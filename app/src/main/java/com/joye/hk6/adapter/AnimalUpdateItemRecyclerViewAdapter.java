package com.joye.hk6.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;

import com.joye.hk6.R;
import com.joye.hk6.common.JoyeEnvironment;

import java.util.List;

/**
 * Created by W,x (JoyeWang)
 * on 2016/9/27.
 * 304622254@qq.com
 * Remeark:
 */

public abstract class AnimalUpdateItemRecyclerViewAdapter<T> extends UpdateItemRecyclerViewAdapter<T> {

    private int lastAnimatedPosition = -1;
    protected boolean animateItems = false;
    private int animated_items_count = 12;

    protected AnimalUpdateItemRecyclerViewAdapter(Context ctx) {
        super(ctx);
    }

    protected int getAnimRes(){
        return R.anim.item_bottom_in;
    }

    private void setAnimation(View viewToAnimate, int position) {
        if (position > lastAnimatedPosition) {
            Animation animation = AnimationUtils.loadAnimation(viewToAnimate.getContext(), getAnimRes());
            viewToAnimate.startAnimation(animation);
            lastAnimatedPosition = position;
        }
    }
    protected void runEnterAnimation(View view, int position) {
        if (!animateItems || position >= animated_items_count - 1) {
            setAnimation(view, position);
            return;
        }
        if (position > lastAnimatedPosition) {
            lastAnimatedPosition = position;
            view.setTranslationY(JoyeEnvironment.Instance.getScreenHeight());
            view.animate()
                    .translationY(0)
                    .setInterpolator(new DecelerateInterpolator(3.f))
                    .setDuration(700)
                    .start();
        }
    }
    @Override
    public void onViewDetachedFromWindow(RecyclerView.ViewHolder holder) {
        super.onViewDetachedFromWindow(holder);
        holder.itemView.clearAnimation();
    }
    public void setItemCount(int itemCount) {
        this.animated_items_count = itemCount;
    }
    @Override
    public void updateItems(List<T> pDatas, boolean animated) {
        datas.clear();
        datas.addAll(pDatas);
        animateItems = animated;
        notifyDataSetChanged();
    }
}
