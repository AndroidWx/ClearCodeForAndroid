package com.joye.layouts;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Build;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;

/**
 * 表格布局
 * 
 * 类似Table ，但没有 Adapter模式。添加的子项列表视图按列对齐排列。
 * 
 * 可指定列数
 * 
 * @author W,x
 * 
 */
public class GridLayout extends ViewGroup implements IOnChildAtNewLineListenerAware {

	private int horizontalSpacing = 0;
	private int verticalSpacing = 0;
	private Paint dividerPaint;
	private int dividerColor = Color.TRANSPARENT;
	private int dividerSize = -1;
	private int gravity = Gravity.TOP | Gravity.LEFT;

	private int rowCount = 3;
	private IOnChildAtNewLineListener onNewLineListener;

	public GridLayout(Context context) {
		super(context);
	}

	public GridLayout(Context context, AttributeSet attrs) {
		super(context, attrs);
		init(context, attrs, 0);
	}

	public GridLayout(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		init(context, attrs, defStyle);
	}

	/**
	 * 解析布局参数
	 * 
	 * @param context
	 * @param attrs
	 * @param defStyle
	 */
	private void init(Context context, AttributeSet attrs, int defStyle) {
		TypedArray attributes = context.obtainStyledAttributes(attrs, R.styleable.FlowLayout,
				defStyle, 0);
		int n = attributes.getIndexCount();
		try {
			for (int i = 0; i < n; i++) {
				int attr = attributes.getIndex(i);
				if (attr == R.styleable.FlowLayout_horizontalSpacing) {
					horizontalSpacing = attributes.getDimensionPixelSize(
							R.styleable.FlowLayout_horizontalSpacing, 0);
				} else if (attr == R.styleable.FlowLayout_verticalSpacing) {
					verticalSpacing = attributes.getDimensionPixelSize(
							R.styleable.FlowLayout_verticalSpacing, 0);
				} else if (attr == R.styleable.FlowLayout_divider_color) {
					dividerColor = attributes.getColor(R.styleable.FlowLayout_divider_color,
							Color.TRANSPARENT);
				} else if (attr == R.styleable.FlowLayout_divider_size) {
					dividerSize = attributes.getDimensionPixelSize(
							R.styleable.FlowLayout_divider_size, -1);
				} else if (attr == R.styleable.FlowLayout_android_gravity) {
					setGravity(attributes.getInt(attr, gravity));
				}
			}
		} finally {
			attributes.recycle();
		}
		attributes = context.obtainStyledAttributes(attrs, R.styleable.GridLayout, defStyle, 0);
		n = attributes.getIndexCount();
		try {
			for (int i = 0; i < n; i++) {
				int attr = attributes.getIndex(i);
				if (attr == R.styleable.GridLayout_rowCount) {
					setRowCount(attributes.getInt(attr, rowCount));
				}
			}
		} finally {
			attributes.recycle();
		}
		updateDividerPaint();
	}

	public void setDividerSize(int dividerSize) {
		if (this.dividerSize == dividerSize)
			return;
		this.dividerSize = dividerSize;
		updateDividerPaint();
	}

	private void updateDividerPaint() {
		if (dividerSize > 0) {
			if (dividerPaint == null) {
				dividerPaint = new Paint();
				dividerPaint.setAntiAlias(true);
			}
			dividerPaint.setColor(dividerColor);
			dividerPaint.setStrokeWidth(dividerSize);
		} else {
			dividerPaint = null;
		}
		invalidate();
	}

	public void setDividerColor(int dividerColor) {
		if (this.dividerColor == dividerColor)
			return;
		this.dividerColor = dividerColor;
		updateDividerPaint();
	}

	/**
	 * 摆放方式
	 * 
	 * @param gravity
	 */
	public void setGravity(int gravity) {
		if (this.gravity != gravity) {
			if ((gravity & Gravity.HORIZONTAL_GRAVITY_MASK) == 0) {
				gravity |= Gravity.LEFT;
			}

			if ((gravity & Gravity.VERTICAL_GRAVITY_MASK) == 0) {
				gravity |= Gravity.TOP;
			}

			this.gravity = gravity;
			requestLayout();
		}
	}

	/**
	 * 列数
	 * 
	 * @param rowCount
	 */
	public void setRowCount(int rowCount) {
		if (rowCount == this.rowCount)
			return;
		this.rowCount = rowCount;
		requestLayout();
	}

	public void setOnNewLineListener(IOnChildAtNewLineListener onNewLineListener) {
		this.onNewLineListener = onNewLineListener;
	}

	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		int paddingRight = getPaddingRight();
		int paddingLeft = getPaddingLeft();
		int paddingTop = getPaddingTop();
		int paddingBottom = getPaddingBottom();
		int sizeWidth = MeasureSpec.getSize(widthMeasureSpec) - paddingLeft - paddingRight;
		int sizeHeight = MeasureSpec.getSize(heightMeasureSpec) - paddingTop - paddingBottom;

		int widthMode = MeasureSpec.getMode(widthMeasureSpec);
		int widthSize = MeasureSpec.getSize(widthMeasureSpec);
		int heightMode = MeasureSpec.getMode(heightMeasureSpec);
		int heightSize = MeasureSpec.getSize(heightMeasureSpec);

		int width = -1;
		int height = -1;

		int desiredWidth = 0;
		int desiredHeight = 0;
		if (Build.VERSION.SDK_INT > 15) {
			desiredWidth = getMinimumWidth();
			desiredHeight = getMinimumHeight();
		}

		final int count = getChildCount();

		// Measure Width
		if (widthMode == MeasureSpec.EXACTLY) {
			// Must be this size
			width = widthSize - paddingLeft - paddingRight;
		} else if (widthMode == MeasureSpec.AT_MOST) {
			// Can't be bigger than...
			width = Math.min(desiredWidth, widthSize) - paddingLeft - paddingRight;
		} else {
			int colWidth = 0;
			int maxColWidth = 0;
			int index = 0;
			int row = 0;
			while (index < count) {
				final View child = getChildAt(index++);
				if (child.getVisibility() == GONE)
					continue;
				LayoutParams lp = LayoutParams.class.cast(child.getLayoutParams());
				child.measure(
						getChildMeasureSpec(widthMeasureSpec, paddingLeft + paddingRight, lp.width),
						getChildMeasureSpec(heightMeasureSpec, paddingTop + paddingBottom,
								lp.height));
				colWidth += child.getMeasuredWidth();
				row++;
				if (row >= rowCount) {
					maxColWidth = Math.max(colWidth, maxColWidth);
					row = 0;
				}
			}
			width = Math.max(maxColWidth, desiredWidth);
			widthSize += paddingLeft + paddingRight;
		}

		// Measure Height
		if (heightMode == MeasureSpec.EXACTLY) {
			// Must be this size
			height = heightSize;
		} else if (heightMode == MeasureSpec.AT_MOST) {
			// Can't be bigger than...
			height = Math.min(desiredHeight, heightSize);
		}

		int index = 0;
		int row = 0;
		final int rowWidth = width / rowCount;
		int colHeight = 0;
		int colMaxHeight = 0;
		final int childWidthSpec = MeasureSpec.makeMeasureSpec(rowWidth, MeasureSpec.AT_MOST);
		while (index < count) {
			final View child = getChildAt(index++);
			if (child.getVisibility() == GONE)
				continue;
			LayoutParams lp = LayoutParams.class.cast(child.getLayoutParams());
			child.measure(getChildMeasureSpec(childWidthSpec, 0, lp.width),
					getChildMeasureSpec(heightMeasureSpec, 0, lp.height));
			lp.x = paddingLeft + row * rowWidth;
			if (row == 0) {
				colHeight += verticalSpacing;
				lp.newLine = true;
				if (onNewLineListener != null) {
					onNewLineListener.onNewLine(child);
				}
			} else {
				lp.newLine = false;
			}
			lp.y = colHeight;
			colMaxHeight = Math.max(colMaxHeight, child.getMeasuredHeight());
			row++;
			if (row >= rowCount) {
				colHeight += colMaxHeight + verticalSpacing;
				row = 0;
			}
		}
		this.setMeasuredDimension(
				resolveSize(width, widthMeasureSpec),
				resolveSize(
						heightMode == MeasureSpec.UNSPECIFIED ? Math.max(desiredHeight, colHeight)
								: height, heightMeasureSpec));
	}

	@Override
	protected void onLayout(boolean changed, int l, int t, int r, int b) {
		final int count = getChildCount();
		for (int i = 0; i < count; i++) {
			View child = getChildAt(i);
			if (child.getVisibility() == GONE)
				continue;
			LayoutParams lp = (LayoutParams) child.getLayoutParams();
			child.layout(lp.x, lp.y, lp.x + child.getMeasuredWidth(),
					lp.y + child.getMeasuredHeight());
		}
	}

	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		if (dividerPaint != null) {
			canvas.save();
			int count = getChildCount();
			for (int index = 0; index < count; index++) {
				final View child = getChildAt(index);
				if (child.getVisibility() == View.GONE)
					continue;
				LayoutParams lp = LayoutParams.class.cast(child.getLayoutParams());
				if (lp.newLine) {
					canvas.drawLine(0, lp.y - verticalSpacing, getMeasuredWidth(), lp.y
							- verticalSpacing, dividerPaint);
				}
			}
		}

	}

	@Override
	protected LayoutParams generateDefaultLayoutParams() {
		return new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
	}

	@Override
	public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
		return new LayoutParams(getContext(), attributeSet);
	}

	@Override
	protected LayoutParams generateLayoutParams(ViewGroup.LayoutParams p) {
		return new LayoutParams(p);
	}

	public static class LayoutParams extends ViewGroup.LayoutParams {

		private static int NO_SPACING = -1;
		private int x;
		private int y;
		private int horizontalSpacing = NO_SPACING;
		private int verticalSpacing = NO_SPACING;
		private boolean newLine = false;

		public LayoutParams(Context context, AttributeSet attributeSet) {
			super(context, attributeSet);
			this.readStyleParameters(context, attributeSet);
		}

		public LayoutParams(int width, int height) {
			super(width, height);
		}

		public LayoutParams(ViewGroup.LayoutParams layoutParams) {
			super(layoutParams);
		}

		public boolean horizontalSpacingSpecified() {
			return horizontalSpacing != NO_SPACING;
		}

		public boolean verticalSpacingSpecified() {
			return verticalSpacing != NO_SPACING;
		}

		public void setPosition(int x, int y) {
			this.x = x;
			this.y = y;
		}

		private void readStyleParameters(Context context, AttributeSet attributeSet) {
			TypedArray a = context.obtainStyledAttributes(attributeSet,
					R.styleable.FlowLayout_LayoutParams);
			try {
				horizontalSpacing = a.getDimensionPixelSize(
						R.styleable.FlowLayout_LayoutParams_layout_horizontalSpacing, NO_SPACING);
				verticalSpacing = a.getDimensionPixelSize(
						R.styleable.FlowLayout_LayoutParams_layout_verticalSpacing, NO_SPACING);
			} finally {
				a.recycle();
			}
		}
	}
}
