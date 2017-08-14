package com.dqr.www.multitypestudy.favorites;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Description：
 * Author：LiuYM
 * Date： 2017-08-07 14:45
 */

public class ItemDecoration extends RecyclerView.ItemDecoration {
    private static final String TAG = "ItemDecoration";
    private int space;
    private Paint mPaint;
    public ItemDecoration(Context context, int space,int color) {
       // Log.d(TAG, "ItemDecoration: "+context.getResources().getDisplayMetrics());
        this.space= (int) (context.getResources().getDisplayMetrics().density*space);
        mPaint = new Paint();
        mPaint.setColor(color);
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        super.getItemOffsets(outRect,view,parent,state);
        if(parent.getChildLayoutPosition(view)!=0) {
            outRect.top = space;
        }
    }

    @Override
    public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
        int childCount=parent.getChildCount();
        for(int i=0;i<childCount;i++){
            View view = parent.getChildAt(i);
            int top=view.getBottom();
            int bottom=view.getBottom()+space;
            c.drawRect(0,top,view.getWidth(),bottom,mPaint);
        }
    }
}
