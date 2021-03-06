package com.joye.hk6.vu;

import android.content.Context;
import android.widget.ImageButton;
import android.widget.TextView;

import com.joye.hk6.R;
import com.joye.hk6.adapter.SizeAdapter;
import com.joye.hk6.adapter.UpdateItemRecyclerViewAdapter;
import com.joye.hk6.vu.base.BannberOnePageProgressSwipeRefreshRecyclerVu;
import com.joye.hk6.vu.base.IBannerOnePageListener;
import com.joye.hk6domain.vo.SizeVo;
import com.joye.layouts.BorderRippleViewTextView;
import com.ms.square.android.expandabletextview.ExpandableTextView;

import butterknife.BindView;

/**
 * Created by Wx on 2016/9/25.
 * QQ:304622254;
 * remark:
 */

public class SizeFragmentVu extends BannberOnePageProgressSwipeRefreshRecyclerVu<SizeVo> {
    public IBannerOnePageListener.IBannerOnePageImpl BannerOnePageImpl = new IBannerOnePageListener.IBannerOnePageImpl() {
        @Override
        public void setTitleLable(String textStr) {
            ((TextView) view.findViewById(R.id.ctb_title_label)).setText(textStr);
        }

        @Override
        public void setOnRippleCompleteListener(BorderRippleViewTextView.OnRippleCompleteListener listener) {
            ((BorderRippleViewTextView) view.findViewById(R.id.ctb_btn_back)).setOnRippleCompleteListener(listener);
        }
    };
//    @BindView(R.id.vigilant)
//    public TextView vigilant;
    @BindView(R.id.expandable_text)
    public TextView expandableText;
    @BindView(R.id.expand_collapse)
    public  ImageButton expandCollapse;
    @BindView(R.id.expand_text_view)
    public  ExpandableTextView expandTextView;

    @Override
    public UpdateItemRecyclerViewAdapter getRecylerViewAdapter(Context context) {
        return new SizeAdapter(context);
    }

    @Override
    public int contentLayout() {
        return R.layout.fragment_size_common_list;
    }
}
