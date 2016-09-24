package com.joye.hk6.mvp;

import android.os.Bundle;
import android.view.ViewStub;

public abstract class  IBannerOnePageVu implements Vu{
	
	protected abstract void onCreateContentView(ViewStub contentStub);

	protected abstract void onCreateBannerView(ViewStub bannerStub);
	
    protected abstract void onActivityCreate(Bundle savedInstanceState);
}
