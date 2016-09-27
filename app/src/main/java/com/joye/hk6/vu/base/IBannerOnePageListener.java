package com.joye.hk6.vu.base;

import android.graphics.drawable.Drawable;
import android.support.annotation.ColorRes;
import android.text.SpannableString;
import android.view.View.OnClickListener;

import com.joye.layouts.BorderRippleViewImageButton;
import com.joye.layouts.BorderRippleViewTextView;


/**
 * bannerOnePage listener
 *
 * @author Wx Contact Qq:304622254
 */
public interface IBannerOnePageListener {
    /**
     * 设置返回按钮点击事件
     *
     * @author Wx
     * @date2015年6月8日
     */
    void setBackBtnClickListener(OnClickListener backClickListener,
                                 int textResId);

    /**
     * 设置文字
     *
     * @author Wx
     * @date2015年6月8日
     */
    void setTitleLable(int text, String textstr);

    /**
     * 功能按键
     *
     * @author Wx
     * @date2015年6月8日
     */
    void setFuncBtnClickListener(OnClickListener funcClickListener,
                                 int textResId);

    abstract class IBannerOnePageImpl implements
            IBannerOnePageListener {
        public void setFuncTextDrawablePadding(int padding) {

        }

        public void setOnRippleCompleteListener(BorderRippleViewTextView.OnRippleCompleteListener listener) {

        }

        public void setOnRippleCompleteListener2(BorderRippleViewTextView.OnRippleCompleteListener listener) {

        }

        public void setOnRippleCompleteListener(BorderRippleViewImageButton.OnRippleCompleteListener listener) {

        }

        public void setFuncImageButtonSrc(int src) {

        }

        public void setTitle(boolean bool) {

        }

        public void setTitleLable(SpannableString charSequence) {
        }

        public void setFuncTextDrawable(Drawable left, Drawable right, Drawable top, Drawable bottom) {
        }

        public void setFuncBtnSrc(int res) {

        }

        public void setFuncBtnColor(@ColorRes int color) {

        }

        @Override
        public void setBackBtnClickListener(OnClickListener backClickListener,
                                            int textResId) {

        }

        public void setBackBtnClickListener(OnClickListener backClickListener,
                                            String textRes) {

        }

        public void setBackBtnClickListener(OnClickListener backClickListener) {

        }

        @Override
        public void setTitleLable(int text, String textstr) {

        }

        @Override
        public void setFuncBtnClickListener(OnClickListener funcClickListener,
                                            int textResId) {

        }

        public void setFuncBtnClickListener(OnClickListener funcClickListener,
                                            String textResId) {

        }

        public void setFuncBtnClickListener(OnClickListener funcClickListener) {

        }

        public void setFuncBt2nClickListener(OnClickListener funcClickListener) {

        }

        public void setTitleLable(String textStr) {

        }

        public void setTitleLable(int text) {

        }

        public void setBackBtnLable(
                String textRes) {

        }
        public void setFuncBtnLable(
                String textRes) {

        }
    }
}
