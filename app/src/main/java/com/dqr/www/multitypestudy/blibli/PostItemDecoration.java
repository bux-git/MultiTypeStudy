package com.dqr.www.multitypestudy.blibli;

import android.graphics.Rect;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

public class PostItemDecoration extends RecyclerView.ItemDecoration {

    private int space;
    private GridLayoutManager.SpanSizeLookup spanSizeLookup;


    public PostItemDecoration(int space, GridLayoutManager.SpanSizeLookup spanSizeLookup) {
        this.space = space;
        this.spanSizeLookup = spanSizeLookup;
    }


    @Override
    public void getItemOffsets(
            Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        int position = parent.getChildLayoutPosition(view);
        //第一个和最后一个不用计算 不属于外部List集合
        if(position==0||position>parent.getAdapter().getItemCount()-2) {
            return;

        }
        //由于recyclerView position比List集合要大一  故减去1
        if (spanSizeLookup.getSpanSize(--position) == 1) {
            outRect.left = space;
            if (position % 2 == 0) {
                outRect.right = space;
            }
        }
    }
}