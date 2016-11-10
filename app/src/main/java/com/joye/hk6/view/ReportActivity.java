package com.joye.hk6.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.joye.hk6.util.ReportHelper;

/**
 * Created by xiang on 16/11/5.
 * remark:属性报表查看activity
 *
 */

public class ReportActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent=getIntent();
        if(intent.hasExtra(ReportHelper.EXTRA_KEY_TYPE)){
            intent.getParcelableExtra(ReportHelper.EXTRA_KEY_TYPE);
        }
    }
}
