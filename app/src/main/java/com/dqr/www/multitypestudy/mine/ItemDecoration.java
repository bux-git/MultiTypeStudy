package com.dqr.www.multitypestudy.mine;

import android.graphics.Rect;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.dqr.www.multitypestudy.mine.bean.FunItemBean;

import java.util.List;

/**
 * Description：
 * Author：LiuYM
 * Date： 2017-06-02 16:30
 */

public class ItemDecoration extends RecyclerView.ItemDecoration {

    private int space;
    private GridLayoutManager.SpanSizeLookup spanSizeLookup;
    private List<Object> mList;


    public ItemDecoration(int space, GridLayoutManager.SpanSizeLookup spanSizeLookup, List<Object> list) {
        this.space = space;
        this.spanSizeLookup = spanSizeLookup;
        this.mList = list;
    }


    @Override
    public void getItemOffsets(
            Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        int position = parent.getChildLayoutPosition(view);
        if (mList.get(position) instanceof FunItemBean) {
            FunItemBean itemBean = (FunItemBean) mList.get(position);
            if (itemBean.countSpan == 2) {
                outRect.left = space;
                outRect.right = space;
            } else {
                outRect.left = space;
                if ("2,5,8,11,14".contains(itemBean.index+"")) {
                    outRect.right = space;
                }
            }
        }

    }
}