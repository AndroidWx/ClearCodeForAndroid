package com.joye.hk6.frg;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;

import com.joye.hk6.R;
import com.joye.hk6.adapter.UpdateItemRecyclerViewAdapter;
import com.joye.hk6.mvp.BaseBannerOnePageFragment;
import com.joye.hk6.view.ChineseZodiacActivity;
import com.joye.hk6.view.ColorActivity;
import com.joye.hk6.view.ReportActivity;
import com.joye.hk6.vu.ConstantsFragmentVu;

import java.util.ArrayList;
import java.util.List;

import static com.joye.hk6.adapter.ConstantsAdapter.ConstantsItem;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * to handle interaction events.
 * Use the {@link VariationFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class VariationFragment extends BaseBannerOnePageFragment<ConstantsFragmentVu> {


    public VariationFragment() {

    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment ConstantsFragment.
     */
    public static VariationFragment newInstance() {
        VariationFragment fragment = new VariationFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    protected Class<ConstantsFragmentVu> getVuClass() {
        return ConstantsFragmentVu.class;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        List<ConstantsItem> list = new ArrayList<>();
        ConstantsItem item = new ConstantsItem(R.string.chieseZodiac, ChineseZodiacActivity.class);
        list.add(item);
        item = new ConstantsItem(R.string.color, ColorActivity.class);
        list.add(item);
        item = new ConstantsItem(R.string.number, ReportActivity.class);
        list.add(item);

        vu.commonRecyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));
        vu.mAdapter.updateItems(list, true);
        vu.mAdapter.setmRecyclerViewItemListener(new UpdateItemRecyclerViewAdapter.RecyclerViewItemListener<ConstantsItem>() {

            @Override
            public void onRecyclerViewItemClick(ConstantsItem constantsItem) {
                Intent intent=new Intent(getContext(), constantsItem.className);
                startActivity(intent);
            }
        });
    }


}
