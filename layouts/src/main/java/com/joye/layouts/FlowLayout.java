package com.joye.layouts;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;

/**
 * 流布局
 * <p>
 * 根据自身的大小，按照填充的方向（水平或垂直）尽量填满一行（列）后，剩余的换行（列）后继续填充。可以设置每行（列）的间隔，以及分割线。
 * </p>
 * <p>
 * 水平方向 ：支持 {@link Gravity#LEFT} {@link Gravity#RIGHT} {@link Gravity#TOP}
 * {@link Gravity#CENTER_VERTICAL} 靠左， 靠右，垂直居中
 * </p>
 * <p>
 * 关于换行（换列）：支持子视图的 {@link LayoutParams}中设置 {@link LayoutParams#newLine}强制换行；
 * 支持设置 maxCountInRow 参数，限制每行（每列）最多的子项。
 * </p>
 * 
 * @author W,x
 * 
 */
public class FlowLayout extends ViewGroup implements IOnChildAtNewLineListenerAware {
	public static final int HORIZONTAL = 0;
	public static final int VERTICAL = 1;
	private int horizontalSpacing = 0;
	private int verticalSpacing = 0;
	private int orientation = 0;
	private boolean debugDraw = false;
	private Paint dividerPaint;
	private int dividerColor = Color.TRANSPARENT;
	private int dividerSize = -1;

	private int mGravity = Gravity.TOP | Gravity.LEFT;

	private int maxCountInRow = -1;

	private IOnChildAtNewLineListener onNewLineListener;

	public FlowLayout(Context context) {
		super(context);
		init(context, null, 0);
	}

	public FlowLayout(Context context, AttributeSet attributeSet) {
		super(context, attributeSet);

		init(context, attributeSet, 0);
	}

	public FlowLayout(Context context, AttributeSet attributeSet, int defStyle) {
		super(context, attributeSet, defStyle);
		init(context, attributeSet, defStyle);
	}

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
				} else if (attr == R.styleable.FlowLayout_floworientation) {
					orientation = attributes.getInteger(R.styleable.FlowLayout_floworientation,
							HORIZONTAL);
				} else if (attr == R.styleable.FlowLayout_debugDraw) {
					debugDraw = attributes.getBoolean(R.styleable.FlowLayout_debugDraw, false);
				} else if (attr == R.styleable.FlowLayout_divider_color) {
					dividerColor = attributes.getColor(R.styleable.FlowLayout_divider_color,
							Color.TRANSPARENT);
				} else if (attr == R.styleable.FlowLayout_divider_size) {
					dividerSize = attributes.getDimensionPixelSize(
							R.styleable.FlowLayout_divider_size, -1);
				} else if (attr == R.styleable.FlowLayout_android_gravity) {
					setGravity(attributes.getInt(attr, mGravity));
				} else if (attr == R.styleable.FlowLayout_maxCountInRow) {
					setMaxCountInRow(attributes.getInt(attr, -1));
				}
			}
		} finally {
			attributes.recycle();
		}
		if (dividerSize > -1) {
			dividerPaint = this.createPaint(dividerColor);
			dividerPaint.setStrokeWidth(dividerSize);
		}
	}

	/**
	 * 一行或一列中最大个数
	 * 
	 * @param maxcount
	 */
	public void setMaxCountInRow(int maxcount) {
		if (maxCountInRow == maxcount)
			return;
		maxCountInRow = maxcount;
		requestLayout();
	}

	/**
	 * 一行或一列中最大个数
	 * 
	 * @return 一行或一列中最大个数
	 */
	public int getMaxCountInRow() {
		return maxCountInRow;
	}

	/**
	 * 摆放方式
	 * 
	 * @param gravity
	 */
	public void setGravity(int gravity) {
		if (mGravity != gravity) {
			if ((gravity & Gravity.HORIZONTAL_GRAVITY_MASK) == 0) {
				gravity |= Gravity.LEFT;
			}

			if ((gravity & Gravity.VERTICAL_GRAVITY_MASK) == 0) {
				gravity |= Gravity.TOP;
			}

			mGravity = gravity;
			requestLayout();
		}
	}

	/**
	 * 监听当子视图成为新行的事件
	 * 
	 * @param onNewLineListener
	 */
	public void setOnNewLineListener(IOnChildAtNewLineListener onNewLineListener) {
		this.onNewLineListener = onNewLineListener;
	}

	/**
	 * 摆放方式
	 * 
	 * @return
	 * 
	 * @see Gravity
	 */
	public int getGravity() {
		return mGravity;
	}

	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		if (orientation == HORIZONTAL) {
			onMeasureHorizontal(widthMeasureSpec, heightMeasureSpec);
		} else {
			onMeasureVertical(widthMeasureSpec, heightMeasureSpec);
		}
	}

	/**
	 * 从上到下摆放
	 * 
	 * @param widthMeasureSpec
	 * @param heightMeasureSpec
	 */
	private void onMeasureVertical(int widthMeasureSpec, int heightMeasureSpec) {
		int paddingRight = getPaddingRight();
		int paddingLeft = getPaddingLeft();
		int paddingTop = getPaddingTop();
		int paddingBottom = getPaddingBottom();
		int size = MeasureSpec.getSize(heightMeasureSpec) - paddingTop - paddingBottom;

		int mode = MeasureSpec.getMode(heightMeasureSpec);

		int lineThicknessWithSpacing = 0;
		int lineLengthWithSpacing = 0;
		int lineLength;

		int prevLinePosition = 0;

		int controlMaxLength = 0;
		int controlMaxThickness = 0;

		final int count = getChildCount();
		int rowcount = 0;
		for (int i = 0; i < count; i++) {
			final View child = getChildAt(i);
			if (child.getVisibility() == GONE) {
				continue;
			}

			LayoutParams lp = (LayoutParams) child.getLayoutParams();
			child.measure(
					getChildMeasureSpec(widthMeasureSpec, paddingLeft + paddingRight, lp.width),
					getChildMeasureSpec(heightMeasureSpec, paddingTop + paddingBottom, lp.height));

			int childWidth = child.getMeasuredWidth();
			int childHeight = child.getMeasuredHeight();

			int childLength;
			int childThickness;
			int spacingLength;
			int spacingThickness;

			childLength = childHeight;
			childThickness = childWidth;
			spacingLength = this.getVerticalSpacing(lp);
			spacingThickness = this.getHorizontalSpacing(lp);

			lineLength = lineLengthWithSpacing + childLength;
			lineLengthWithSpacing = lineLength + spacingLength;

			boolean newLine = lp.newLine
					|| (mode != MeasureSpec.UNSPECIFIED && lineLength > size || (maxCountInRow > 0 ? rowcount >= maxCountInRow
							: false));
			if (newLine) {
				prevLinePosition = prevLinePosition + lineThicknessWithSpacing;
				lineLength = childLength;
				lineThicknessWithSpacing = childThickness + spacingThickness;
				lineLengthWithSpacing = lineLength + spacingLength;
				lp.newLineDraw = true;
				rowcount = 0;
				if (onNewLineListener != null) {
					onNewLineListener.onNewLine(child);
				}
			}

			lineThicknessWithSpacing = Math.max(lineThicknessWithSpacing, childThickness
					+ spacingThickness);
			childThickness = Math.max(childThickness, childThickness);

			int posX;
			int posY;
			posX = paddingLeft + prevLinePosition;
			posY = paddingTop + lineLength - childHeight;
			lp.setPosition(posX, posY);

			controlMaxLength = Math.max(controlMaxLength, lineLength);
			controlMaxThickness = prevLinePosition + childThickness;
			if (maxCountInRow > 0) {
				rowcount++;
			}
		}

		/* need to take paddings into account */
		controlMaxLength += paddingBottom + paddingTop;
		controlMaxThickness += paddingLeft + paddingRight;

		this.setMeasuredDimension(resolveSize(controlMaxThickness, widthMeasureSpec),
				resolveSize(controlMaxLength, heightMeasureSpec));
	}

	/**
	 * 从右边开始摆放
	 * 
	 * @param widthMeasureSpec
	 * @param heightMeasureSpec
	 */
	private void onMeasureHorizontal(int widthMeasureSpec, int heightMeasureSpec) {
		int paddingRight = getPaddingRight();
		int paddingLeft = getPaddingLeft();
		int paddingTop = getPaddingTop();
		int paddingBottom = getPaddingBottom();
		int size = MeasureSpec.getSize(widthMeasureSpec) - paddingRight - paddingLeft;
		int height = MeasureSpec.getSize(heightMeasureSpec) - paddingTop - paddingBottom;

		int mode = MeasureSpec.getMode(widthMeasureSpec);

		int lineThicknessWithSpacing = 0;
		int lineLengthWithSpacing = 0;
		int lineLength;

		int prevLinePosition = 0;

		int controlMaxLength = 0;
		int controlMaxThickness = 0;

		final int count = getChildCount();
		int rowcount = 0;
		for (int i = 0; i < count; i++) {
			final View child = getChildAt(i);
			if (child.getVisibility() == GONE) {
				continue;
			}

			LayoutParams lp = (LayoutParams) child.getLayoutParams();

			child.measure(
					getChildMeasureSpec(widthMeasureSpec, paddingLeft + paddingRight, lp.width),
					getChildMeasureSpec(heightMeasureSpec, paddingTop + paddingBottom, lp.height));

			int childWidth = child.getMeasuredWidth();
			int childHeight = child.getMeasuredHeight();

			int childLength = childWidth;
			int childThickness = childHeight;
			int spacingLength = this.getHorizontalSpacing(lp);
			int spacingThickness = this.getVerticalSpacing(lp);

			lineLength = lineLengthWithSpacing + childLength;
			lineLengthWithSpacing = lineLength + spacingLength;

			boolean newLine = lp.newLine || (mode != MeasureSpec.UNSPECIFIED && lineLength > size)
					|| (maxCountInRow > 0 ? rowcount >= maxCountInRow : false);
			if (newLine) {
				prevLinePosition = prevLinePosition + lineThicknessWithSpacing;
				lineLength = childLength;
				lineThicknessWithSpacing = childThickness + spacingThickness;
				lineLengthWithSpacing = lineLength + spacingLength;
				lp.newLineDraw = true;
				rowcount = 0;
				if (onNewLineListener != null) {
					onNewLineListener.onNewLine(child);
				}
			}

			lineThicknessWithSpacing = Math.max(lineThicknessWithSpacing, childThickness
					+ spacingThickness);
			childThickness = Math.max(childThickness, childThickness);

			int posX = paddingLeft + lineLength - childLength;
			int posY = paddingTop + prevLinePosition;

			lp.setPosition(posX, posY);

			controlMaxLength = Math.max(controlMaxLength, lineLength);
			controlMaxThickness = prevLinePosition + childThickness;
			if (maxCountInRow > 0) {
				rowcount++;
			}
		}

		/* need to take paddings into account */
		controlMaxLength += paddingLeft + paddingRight;
		controlMaxThickness += paddingBottom + paddingTop;

		this.setMeasuredDimension(resolveSize(controlMaxLength, widthMeasureSpec),
				resolveSize(controlMaxThickness, heightMeasureSpec));
		int majorHorizontalGravity = mGravity & Gravity.HORIZONTAL_GRAVITY_MASK;
		if (majorHorizontalGravity == Gravity.RIGHT) {

			int rightSpace = 0;
			for (int i = getChildCount() - 1; i >= 0; i--) {
				final View child = getChildAt(i);
				if (child.getVisibility() == GONE) {
					continue;
				}
				LayoutParams lp = (LayoutParams) child.getLayoutParams();
				// the last item in a line, compute right space
				if (rightSpace <= 0) {
					rightSpace = size - (paddingRight + lp.x + child.getMeasuredWidth());
				}
				lp.x = lp.x - paddingLeft + rightSpace;
				if (lp.newLineDraw) {
					rightSpace = 0;
				}
			}
		}
		int majorVeritcalGravity = mGravity & Gravity.VERTICAL_GRAVITY_MASK;
		if (majorVeritcalGravity == Gravity.CENTER_VERTICAL) {
			int childCount = getChildCount();
			if (childCount > 0) {
				View lastChild = getChildAt(childCount - 1);
				LayoutParams last = (LayoutParams) lastChild.getLayoutParams();
				int bottomSpace = (height - (last.y - paddingTop) - lastChild.getMeasuredHeight()) / 2;
				for (int i = getChildCount() - 1; i >= 0; i--) {
					final View child = getChildAt(i);
					if (child.getVisibility() == GONE) {
						continue;
					}
					LayoutParams lp = (LayoutParams) child.getLayoutParams();
					// the last item in a line, compute right space
					lp.y += bottomSpace;
				}
			}
		}
	}

	private int getVerticalSpacing(LayoutParams lp) {
		int vSpacing;
		if (lp.verticalSpacingSpecified()) {
			vSpacing = lp.verticalSpacing;
		} else {
			vSpacing = this.verticalSpacing;
		}
		return vSpacing;
	}

	private int getHorizontalSpacing(LayoutParams lp) {
		int hSpacing;
		if (lp.horizontalSpacingSpecified()) {
			hSpacing = lp.horizontalSpacing;
		} else {
			hSpacing = this.horizontalSpacing;
		}
		return hSpacing;
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
	protected boolean drawChild(Canvas canvas, View child, long drawingTime) {
		boolean more = super.drawChild(canvas, child, drawingTime);
		this.drawDebugInfo(canvas, child);
		if (dividerPaint != null) {
			LayoutParams lp = LayoutParams.class.cast(child.getLayoutParams());
			if (lp.newLineDraw) {
				canvas.drawLine(0, lp.y - verticalSpacing / 2, getMeasuredWidth(), lp.y
						- verticalSpacing / 2, dividerPaint);
			}
		}
		return more;
	}

	@Override
	protected boolean checkLayoutParams(ViewGroup.LayoutParams p) {
		return p instanceof LayoutParams;
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

	private void drawDebugInfo(Canvas canvas, View child) {
		if (!debugDraw) {
			return;
		}

		Paint childPaint = this.createPaint(0xffffff00);
		Paint layoutPaint = this.createPaint(0xff00ff00);
		Paint newLinePaint = this.createPaint(0xffff0000);

		LayoutParams lp = (LayoutParams) child.getLayoutParams();

		if (lp.horizontalSpacing > 0) {
			float x = child.getRight();
			float y = child.getTop() + child.getHeight() / 2.0f;
			canvas.drawLine(x, y, x + lp.horizontalSpacing, y, childPaint);
			canvas.drawLine(x + lp.horizontalSpacing - 4.0f, y - 4.0f, x + lp.horizontalSpacing, y,
					childPaint);
			canvas.drawLine(x + lp.horizontalSpacing - 4.0f, y + 4.0f, x + lp.horizontalSpacing, y,
					childPaint);
		} else if (this.horizontalSpacing > 0) {
			float x = child.getRight();
			float y = child.getTop() + child.getHeight() / 2.0f;
			canvas.drawLine(x, y, x + this.horizontalSpacing, y, layoutPaint);
			canvas.drawLine(x + this.horizontalSpacing - 4.0f, y - 4.0f,
					x + this.horizontalSpacing, y, layoutPaint);
			canvas.drawLine(x + this.horizontalSpacing - 4.0f, y + 4.0f,
					x + this.horizontalSpacing, y, layoutPaint);
		}

		if (lp.verticalSpacing > 0) {
			float x = child.getLeft() + child.getWidth() / 2.0f;
			float y = child.getBottom();
			canvas.drawLine(x, y, x, y + lp.verticalSpacing, childPaint);
			canvas.drawLine(x - 4.0f, y + lp.verticalSpacing - 4.0f, x, y + lp.verticalSpacing,
					childPaint);
			canvas.drawLine(x + 4.0f, y + lp.verticalSpacing - 4.0f, x, y + lp.verticalSpacing,
					childPaint);
		} else if (this.verticalSpacing > 0) {
			float x = child.getLeft() + child.getWidth() / 2.0f;
			float y = child.getBottom();
			canvas.drawLine(x, y, x, y + this.verticalSpacing, layoutPaint);
			canvas.drawLine(x - 4.0f, y + this.verticalSpacing - 4.0f, x, y + this.verticalSpacing,
					layoutPaint);
			canvas.drawLine(x + 4.0f, y + this.verticalSpacing - 4.0f, x, y + this.verticalSpacing,
					layoutPaint);
		}

		if (lp.newLine) {
			if (orientation == HORIZONTAL) {
				float x = child.getLeft();
				float y = child.getTop() + child.getHeight() / 2.0f;
				canvas.drawLine(x, y - 6.0f, x, y + 6.0f, newLinePaint);
			} else {
				float x = child.getLeft() + child.getWidth() / 2.0f;
				float y = child.getTop();
				canvas.drawLine(x - 6.0f, y, x + 6.0f, y, newLinePaint);
			}
		}
	}

	private Paint createPaint(int color) {
		Paint paint = new Paint();
		paint.setAntiAlias(true);
		paint.setColor(color);
		paint.setStrokeWidth(2.0f);
		return paint;
	}

	public static class LayoutParams extends ViewGroup.LayoutParams {
		private static int NO_SPACING = -1;
		private int x;
		private int y;
		private int horizontalSpacing = NO_SPACING;
		private int verticalSpacing = NO_SPACING;

		/**
		 * 配置参数，强制换行
		 */
		private boolean newLine = false;

		/**
		 * 作图参数，换行
		 */
		private boolean newLineDraw = false;

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
				newLine = a.getBoolean(R.styleable.FlowLayout_LayoutParams_layout_newLine, false);
			} finally {
				a.recycle();
			}
		}
	}

}