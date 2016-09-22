package com.joye.hk6.ac;

import android.app.Activity;
import android.content.Intent;

/**
 * 注入外部处理 {@link Activity#onActivityResult}结果的句柄
 * 
 * @author Wx
 *
 */
public interface IActivityResultDelegate {

	/**
	 * 处理返回的支付结果
	 * 
	 * @param requestCode
	 * @param resultCode
	 * @param data
	 * @return <code>true</code>是关心的结果并且已经处理,<code>false</code>
	 *         结果不是本委托者关心的内容，本委托者没做任何处理
	 */
	boolean onActivityResult(int requestCode, int resultCode, Intent data);
}
