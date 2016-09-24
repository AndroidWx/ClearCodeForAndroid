package com.joye.layouts;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;

import java.util.ArrayList;
import java.util.List;

/**
 * 单选按钮组
 * 
 * @author W,x
 * 
 */
public class RadioButtonGroup {

	private List<CompoundButton> buttons;

	private IOnCheckedChangeListener changeListener;

	private CompoundButton selectedItem;

	public RadioButtonGroup() {
		buttons = new ArrayList<CompoundButton>();
	}

	/**
	 * 添加一个单选按钮
	 * 
	 * @param rb
	 * @param listener
	 *            如果调用者还需要 rb 的
	 *            android.widget.CompoundButton.OnCheckedChangeListener的句柄
	 */
	public void add(CompoundButton rb, OnCheckedChangeListener... listener) {
		buttons.add(rb);
		rb.setOnCheckedChangeListener(new OnCheckedChangeListenerDelegate(listener == null || listener.length < 1 ? null : listener[0]) {

			@Override
			public void internalOnChange(CompoundButton buttonView, boolean isChecked) {
				if (isChecked) {
					toggleButtons(buttonView);
					selectedItem = buttonView;
					if (changeListener != null) {
						changeListener.onCheckedChanged(RadioButtonGroup.this, buttonView.getId());
					}
				}
			}
		});
	}
	
	/**
	 * 清空被管理的按钮
	 */
	public void clear(){
		buttons.clear();
	}

	/**
	 * 被选中的按钮
	 * 
	 * @return
	 */
	public CompoundButton getSelectedItem() {
		return selectedItem;
	}

	/**
	 * 侦听按钮组选中改变的事件
	 * 
	 * @param changeListener
	 */
	public void setOnChangeListener(IOnCheckedChangeListener changeListener) {
		this.changeListener = changeListener;
	}

	private void toggleButtons(CompoundButton rb) {
		for (CompoundButton rbtn : buttons) {
			if (rbtn != rb && rbtn.isChecked()) {
				rbtn.setChecked(false);
			}
		}
	}

	/**
	 * 选中的按钮发生变化
	 * 
	 * @author W,x
	 * 
	 */
	public interface IOnCheckedChangeListener {
		/**
		 * 选中的按钮发生变化
		 * 
		 * @param group
		 *            单选按钮组
		 * @param checkedId
		 *            被选中的按钮的id
		 */
		void onCheckedChanged(RadioButtonGroup group, int checkedId);
	}

}
