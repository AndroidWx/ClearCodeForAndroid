package com.joye.layouts;

import android.view.View;
import android.view.View.OnClickListener;

/**
 * 代理点击句柄
 * 
 * @author W,x
 * 
 */
public abstract class OnClickListenerDelegate implements OnClickListener {
	private OnClickListener delegate;

	public OnClickListenerDelegate(OnClickListener delegate) {
		super();
		this.delegate = delegate;
	}

	@Override
	public final void onClick(View view) {
		if(delegate != null){
			delegate.onClick(view);
		}
		onClickInternal(view);
	}

	/**
	 * 处理点击
	 * 
	 * @param view
	 */
	protected abstract void onClickInternal(View view);

}
