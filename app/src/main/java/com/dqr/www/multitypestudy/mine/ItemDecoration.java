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
        //默认有刷新头部和加载更多底部view 即有2项View不是mList中的View
            //第一个和最后一个不属于外部list中的
            if(position==0||position>mList.size()){
                return;
            }
           position= --position;//減去头部View

        if (mList.get(position) instanceof FunItemBean) {
            FunItemBean itemBean = (FunItemBean) mList.get(position);

                if(itemBean.leftSpace) {
                    outRect.left = space;
                }
                if(itemBean.rightSpace){
                    outRect.right = space;
                }
        }

    }
}