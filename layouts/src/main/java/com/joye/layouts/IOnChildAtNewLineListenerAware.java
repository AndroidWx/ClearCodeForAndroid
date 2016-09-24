package com.joye.layouts;

/**
 * 支持提供新行事件的组件规范
 * 
 * @author W,x
 * 
 */
public interface IOnChildAtNewLineListenerAware {

	/**
	 * 监听当子视图成为新行的事件
	 * 
	 * @param onNewLineListener
	 */
	public void setOnNewLineListener(IOnChildAtNewLineListener onNewLineListener);
}
