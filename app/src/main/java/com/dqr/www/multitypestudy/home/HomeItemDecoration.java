package com.dqr.www.multitypestudy.home;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Description：
 * Author：LiuYM
 * Date： 2017-08-15 15:39
 */

public class HomeItemDecoration extends RecyclerView.ItemDecoration {
    private int spcae;
    private Paint mPaint;

    /**
     *
     * @param space px
     * @param color color颜色值
     */
    public HomeItemDecoration(int space,int color){
        this.spcae=space;
        mPaint = new Paint();
        mPaint.setColor(color);
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
        int count= parent.getAdapter().getItemCount();
        int position = parent.getChildLayoutPosition(view);

        //第1.2项和最后一项不需要分隔
        if(position>1&&position<count-1){
            outRect.top=spcae;
        }
    }

    @Override
    public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
        int childCount=parent.getChildCount();//子View的个数
        int itemCount=parent.getAdapter().getItemCount();//item总数目
        for(int i=0;i<childCount;i++){
            View view = parent.getChildAt(i);
           int position= parent.getChildLayoutPosition(view);
            if(position>1&&position< itemCount-1){
                int top=view.getTop();
                c.drawRect(0,top-spcae,view.getRight(),top,mPaint);
            }
        }
    }
}
