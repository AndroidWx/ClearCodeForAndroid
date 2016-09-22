package com.joye.hk6.ac;

import android.app.Activity;

/**
 * 支持 {@link IActivityResultDelegate}的标准
 * 
 * @author Wx
 *
 */
public interface IActivityResultDelegateAware {

	/**
	 * {@link #setActivityResultDelegate(IActivityResultDelegate)}所属的Activity
	 * 
	 * @return {@link #setActivityResultDelegate(IActivityResultDelegate)}
	 *         所属的Activity
	 */
	Activity getActivity();

	/**
	 * 设置 {@link IActivityResultDelegate}实例
	 * 
	 * @param delegate
	 *            委托者
	 */
	void setActivityResultDelegate(IActivityResultDelegate delegate);
}
