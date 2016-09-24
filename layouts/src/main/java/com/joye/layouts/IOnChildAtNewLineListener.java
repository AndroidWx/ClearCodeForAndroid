package com.joye.layouts;

import android.view.View;

/**
 * 当子视图是新换行的对象时发出的事件
 * 
 * @author W,x
 * 
 */
public interface IOnChildAtNewLineListener {

	/**
	 * 起新行
	 * 
	 * @param child
	 *            新行的第一个视图对象
	 */
	void onNewLine(View child);
}
