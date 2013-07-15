package com.example.skindemo;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.LinearLayout;

public class CustomLinearLayout extends LinearLayout {

	public CustomLinearLayout(Context context) {
		super(context);
	}

	public CustomLinearLayout(Context context, AttributeSet attrs) {
		super(context, attrs);
		
		TypedArray a = context.obtainStyledAttributes(attrs,
				R.styleable.CustomLinearLayout, R.attr.linearLayoutStyle, 0);
		boolean isrounded = a.getBoolean(
				R.styleable.CustomLinearLayout_roundedCorner, false);
		int resid = a.getResourceId(
				R.styleable.CustomLinearLayout_android_background, 0);
		if (isrounded && resid != 0) {
			resid = a.getResourceId(
					R.styleable.CustomLinearLayout_roundedBackgroud, 0);
			this.setBackgroundResource(resid);
		}
		a.recycle();
	}
}
