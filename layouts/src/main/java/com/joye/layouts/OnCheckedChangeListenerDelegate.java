package com.joye.layouts;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;

/**
 * 代理选项改变侦听器。
 * 
 * @author W,x
 * 
 */
public abstract class OnCheckedChangeListenerDelegate implements OnCheckedChangeListener {

	private OnCheckedChangeListener delegate;

	/**
	 * 构造器
	 * 
	 * @param delegate
	 *            被代理的侦听器
	 */
	public OnCheckedChangeListenerDelegate(OnCheckedChangeListener delegate) {
		super();
		this.delegate = delegate;
	}

	@Override
	public final void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
		internalOnChange(buttonView, isChecked);
		if (delegate != null) {
			delegate.onCheckedChanged(buttonView, isChecked);
		}
	}

	protected abstract void internalOnChange(CompoundButton buttonView, boolean isChecked);

}
