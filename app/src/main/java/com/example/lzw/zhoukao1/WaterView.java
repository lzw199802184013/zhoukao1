package com.example.lzw.zhoukao1;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class WaterView extends View {
    private int  mPaint2;
    private  int mPaint;
    private Paint mPaintTop;
    private Paint mPaintBottom;
    private Path mPathTop;
    private Path mPathBottom;
    private float a;

    public WaterView(Context context) {
        super(context);
        init(context);
    }

    public WaterView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.WaterView);
        mPaint=typedArray.getColor(R.styleable.WaterView_mPaintTop,1000);
        mPaint2=typedArray.getColor(R.styleable.WaterView_mPaintBottom,1000);
        typedArray.recycle();//释放
        init(context);
    }

    public WaterView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {

        mPaintTop = new Paint();
        mPaintTop.setColor(mPaint);
        mPaintTop.setAntiAlias(true);
        mPaintBottom = new Paint();
        mPaintBottom.setColor(mPaint2);
        mPaintBottom.setAntiAlias(true);
        mPaintBottom.setAlpha(60);
        mPathTop = new Path();
        mPathBottom = new Path();

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mPathTop.reset();
       mPathBottom.reset();
        //起始位置
        mPathTop.moveTo(getLeft(), getBottom());
        mPathBottom.moveTo(getLeft(), getBottom());

        double mY = Math.PI * 2 / getWidth();
        a -= 0.1f;
        //移动位置
        for (float x = 0; x <= getWidth(); x += 20) {
            float y=(float) (10 * Math.cos(mY * x + a) + 10);
            mPathTop.lineTo(x, y);
            mPathBottom.lineTo(x, (float) (10 * Math.sin(mY * x + a)));
            listener.animation(y);
        }
        //终止位置
        mPathTop.moveTo(getRight(), getBottom());
        mPathBottom.moveTo(getRight(), getBottom());
        canvas.drawPath(mPathTop, mPaintTop);
        canvas.drawPath(mPathBottom, mPaintBottom);
        postInvalidateDelayed(20);//刷新
    }
    //传递接口
    private  AnimationListener listener;
    public  void  result(AnimationListener listener){
        this.listener = listener;

    }
    public  interface  AnimationListener{
        void  animation(float y);

    };
}
