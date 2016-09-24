package com.joye.hk6.mvp;


import android.support.annotation.CallSuper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;

public abstract class BaseVuImp implements Vu {
	protected View view;

	@Override
	public final void init(LayoutInflater inflater, ViewGroup container) {
		view = inflater.inflate(getResouceId(), null);
		ButterKnife.bind(this,view);
		initView();
	}

	protected abstract void initView();
	public abstract int getResouceId();
	@CallSuper
	@Override
	public View getView() {
		return view;
	}

}
