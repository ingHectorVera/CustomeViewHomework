package com.example.hectorvera.customeviewhomework;

import android.content.Context;
import android.content.res.Configuration;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.TextView;

/**
 * Created by User on 10/8/2016.
 */

public class NewTextView extends TextView {

    private int newSize = 0;
    public NewTextView(Context context) {
        super(context);
    }

    public NewTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public NewTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        if(getContext().getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE){
            setMeasuredDimension(widthMeasureSpec, 150 + newSize);
            Log.d("Debug", newSize+"");
        }else {
            setMeasuredDimension(widthMeasureSpec, 150 + newSize);
            Log.d("Debug", newSize+"");
        }
    }

    public int getNewSize() {
        return newSize;
    }

    public void setNewSize(int newSize) {
        this.newSize = newSize;
    }
}
