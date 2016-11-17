package com.skyzone.netdemomvp.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.ImageView;

import com.skyzone.netdemomvp.R;

/**
 * Created by Skyzone on 8/22/2016.
 */
public class DynamicHeightImageView extends ImageView {

    private int corner_top_left;
    private int corner_top_right;
    private int corner_bottom_left;
    private int corner_bottom_right;

    private int width;
    private int height;

    private float mHeightRatio;

    public DynamicHeightImageView(Context context) {
        super(context, null);
    }

    public DynamicHeightImageView(Context context, AttributeSet attrs) {
        super(context, attrs, 0);
    }

    public DynamicHeightImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        //get values
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.DynamicHeightImageView, defStyleAttr, 0);
        corner_top_left = typedArray.getDimensionPixelSize(R.styleable.DynamicHeightImageView_corner_top_left, 0);
        corner_top_right = typedArray.getDimensionPixelSize(R.styleable.DynamicHeightImageView_corner_top_right, 0);
        corner_bottom_left = typedArray.getDimensionPixelSize(R.styleable.DynamicHeightImageView_corner_bottom_left, 0);
        corner_bottom_right = typedArray.getDimensionPixelSize(R.styleable.DynamicHeightImageView_corner_bottom_right, 0);
        typedArray.recycle();
    }

    @Override
    protected void onDraw(Canvas canvas) {
//        int saveCount = canvas.getSaveCount();
//        canvas.save();
        super.onDraw(canvas);

//        final Paint mPaint = new Paint();
//        mPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
//        canvas.drawRoundRect(new RectF(0f, 0f, (float) width, (float) height), 30, 30, mPaint);
//        canvas.restoreToCount(saveCount);
    }

    //Here we will set the aspect ratio
    public void setSize(int width, int height) {
        mHeightRatio = (float) height / width;
        requestLayout();
    }

    public double getHeightRatio() {
        return mHeightRatio;
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (mHeightRatio > 0.0) {
            // set the image views size
            width = MeasureSpec.getSize(widthMeasureSpec);
            height = (int) (width * mHeightRatio);
            setMeasuredDimension(width, height);
        } else {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        }
    }
}
