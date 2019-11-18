package com.bawie.mycustomerview.widgt;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class FloatView3  extends ViewGroup {
    private Context context;
    //new的时候调用
    public FloatView3(Context context) {
        super(context);
        this.context=context;
    }
//在布局文件中（xml文件）中调用
    public FloatView3(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context=context;
    }
//一般需要专门调用
    public FloatView3(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context=context;
    }

    private static final String TAG = "FloatView3";
    //摆放 布局
    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        //获取子控件的总数
        int childCount = getChildCount();

        int space = 10;
        int left = 0;
        int right = 0;
        int top = 0;
        int bottom = 0;

        for (int i = 0; i < childCount; i++) {
            //获取某个子控件
            View childAt = getChildAt(i);
            //测量宽高
            childAt.measure(0,0);
            //获取测量的宽度,这个宽度是在测量阶段结束之后才可以获取到
            int measuredWidth = childAt.getMeasuredWidth();
            int measuredHeight = childAt.getMeasuredHeight();

            left=right+space;
            right=left+measuredWidth;

            //获取父控件的宽度
            int width =getWidth();
            if (right>width){
                left=space;
                top=bottom+space;
            }
            right=left+measuredWidth;
            bottom=top+measuredHeight;
            //摆放
            childAt.layout(left,top,right,bottom);
        }



    }


    public void addTag(String content){
        //初始化标签
        TextView textView = new TextView(context);
        textView.setTextColor(Color.RED);
        textView.setTextSize(14);
        textView.setPadding(12,12,12,12);
        textView.setGravity(Gravity.CENTER);
        textView.setText(content);
        textView.setBackgroundColor(Color.YELLOW);
        //把标签添加到布局中
        addView(textView);
    }
}
