package com.joye.hk6.ac;

import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;

import com.joye.hk6.R;
import com.joye.hk6.report.PieChartImpl;
import com.joye.hk6.view.IPieChartCallback;
import com.joye.hk6.view.ReportActivity;
import com.joye.hk6.vu.base.CoordinatorLayoutToolBarImageViewRecyclerVu;
import com.joye.hk6data.utils.CollectionUtils;

import java.util.ArrayList;

/**
 * Created by Wx on 2016/9/26.
 * QQ:304622254;
 * remark:
 */

public abstract class Hk6ReportAppCompatActivity<V extends CoordinatorLayoutToolBarImageViewRecyclerVu>  extends BasePresenterAppCompatActivity<V>{
    ArrayList<PieChartImpl> datas=new ArrayList<>();
    ArrayList<PieChartImpl> demarcations=new ArrayList<PieChartImpl>();
    public abstract int getReportPic();
    public abstract String getReportActivityTitle();
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.menu_open_rv_menu) {
            if(CollectionUtils.isEmpty(datas)){
                return true;
            }
            Intent intent = new Intent(this, ReportActivity.class);
            intent.putParcelableArrayListExtra(ReportActivity.EXTRA_KEY_DATAS, datas);
            intent.putExtra(ReportActivity.EXTRA_KEY_PICRESID, getReportPic());
            intent.putExtra(ReportActivity.EXTRA_KEY_TITLE, getReportActivityTitle());
            startActivity(intent);
        }else if(item.getItemId() == R.id.menu_bug){
            if(CollectionUtils.isEmpty(demarcations)){
                return true;
            }
            Intent intent = new Intent(this, ReportActivity.class);
            intent.putParcelableArrayListExtra(ReportActivity.EXTRA_KEY_DATAS, demarcations);
            intent.putExtra(ReportActivity.EXTRA_KEY_PICRESID, getReportPic());
            intent.putExtra(ReportActivity.EXTRA_KEY_TITLE, getReportActivityTitle());
            startActivity(intent);
        }

        return true;
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_all_activity, menu);
        return true;
    }

    @Override
    protected void onVuInit() {
        super.onVuInit();
        vu.setCallback(new IPieChartCallback() {
            @Override
            public void callback(ArrayList<PieChartImpl> mdatas) {
                datas.addAll(mdatas);
            }

            @Override
            public void demarcationCallBack(ArrayList<PieChartImpl> datas) {
                demarcations.addAll(datas);
            }
        });
    }
}
