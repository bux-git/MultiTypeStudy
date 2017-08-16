package com.dqr.www.multitypestudy.home.binder;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.dqr.www.multitypestudy.R;
import com.dqr.www.multitypestudy.home.bean.FrameBean;

import java.util.List;

import me.drakeet.multitype.ItemViewBinder;

/**
 * Description：
 * Author：LiuYM
 * Date： 2017-08-14 17:18
 */

public abstract class FrameViewBinder<T> extends ItemViewBinder<FrameBean, FrameViewBinder.FrameViewHolder> {

    private LayoutInflater mInflater;
    public Context mContext;
    /**
     * 创建子项布局
     *
     * @param inflater
     * @param parent
     * @param dataSize
     * @return
     */
    public abstract View onSubCreateView(LayoutInflater inflater, ViewGroup parent, int dataSize,int index);

    /**
     * 绑定数据
     *
     * @param itemView 单项View
     * @param subList  数据集合
     * @param index    当前数据下标
     */
    public abstract void onSubViewBind(View itemView, List<T> subList, int index);

    @NonNull
    @Override
    protected FrameViewHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        View view = inflater.inflate(R.layout.home_item_frame_layout, parent, false);
        mInflater = inflater;
        mContext=parent.getContext();
        return new FrameViewHolder(view);
    }

    @Override
    protected void onBindViewHolder(@NonNull FrameViewBinder.FrameViewHolder holder, @NonNull FrameBean item) {
        holder.setData(item);
        if(item.getContent().getList()==null)return;
        LinearLayout container = holder.lltContainer;
        int containerChildSize = container.getChildCount();
        int dataSize = item.getContent().getList().size();
        if (containerChildSize == 0 || containerChildSize != dataSize) {//容器有子项 且 数量与数据相同 则直接重新赋值  否则清除容器所有子View 重新添加
            container.removeAllViews();
            for(int i=0;i<dataSize;i++) {
                View childView = onSubCreateView(mInflater, container, dataSize,i);
                if(childView!=null) {
                    container.addView(childView);
                }
            }
        }
        //绑定数据
        for (int i = 0; i < dataSize; i++) {
            onSubViewBind(container.getChildAt(i), item.getContent().getList(), i);
        }
    }

    class FrameViewHolder extends RecyclerView.ViewHolder {
        ImageView ivLeft;
        TextView tvLeftTitle;

        LinearLayout lltMore;
        TextView tvMore;
        ImageView ivArrow;

        LinearLayout lltContainer;
        TextView tvReplace;

        public FrameViewHolder(View itemView) {
            super(itemView);
            ivLeft = find(R.id.iv_left);
            tvLeftTitle = find(R.id.tv_title);

            lltMore = find(R.id.llt_more);
            tvMore = find(R.id.tv_more);
            ivArrow = find(R.id.iv_arrows);

            lltContainer = find(R.id.llt_container);

            tvReplace = find(R.id.tv_replace);

        }

        private <T extends View> T find(int resId) {
            return (T) itemView.findViewById(resId);
        }

        public void setData(FrameBean item) {
            ivLeft.setImageResource(item.getLeftImgResId());
            tvLeftTitle.setText(item.getLeftTitleResId());


            if(item.getReplaceResId()<0){
                tvReplace.setVisibility(View.GONE);
            }else{
                tvReplace.setVisibility(View.VISIBLE);
                tvReplace.setText(item.getReplaceResId());
            }

            if(item.getRightTitle()<0){
                lltMore.setVisibility(View.GONE);
            }else{
                lltMore.setVisibility(View.VISIBLE);
                ivArrow.setImageResource(item.getRightImgReId());
                tvMore.setText(item.getRightTitle());
            }


        }
    }
}
