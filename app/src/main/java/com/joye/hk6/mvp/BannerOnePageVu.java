package com.joye.hk6.mvp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;

import com.joye.hk6.R;


/**
 * banneronepage mvp
 * 
 * @author Wx Contact Qq:304622254
 */
public abstract class BannerOnePageVu extends IBannerOnePageVu{
	protected View view;

	@Override
	public final void init(LayoutInflater inflater, ViewGroup container) {
		view = inflater.inflate(R.layout.f_pageone_fragments, container, false);

	}

	@Override
	public final View getView() {
		return view;
	}
	@Override
	public void onActivityCreate(Bundle savedInstanceState) {
		View view = getView();
		ViewStub bannerStub = ViewStub.class.cast(view
				.findViewById(R.id.fpo_titlebar));
		onCreateBannerView(bannerStub);
		ViewStub contentStub = ViewStub.class.cast(view
				.findViewById(R.id.fpo_content));
		onCreateContentView(contentStub);
	}
	
	

}
