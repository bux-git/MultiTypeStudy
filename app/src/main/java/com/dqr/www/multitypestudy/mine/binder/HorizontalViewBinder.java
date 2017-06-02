package com.dqr.www.multitypestudy.mine.binder;

import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dqr.www.multitypestudy.R;
import com.dqr.www.multitypestudy.mine.bean.HorizontalBean;
import com.dqr.www.multitypestudy.mine.bean.MineNavBean;

import java.util.List;

import me.drakeet.multitype.ItemViewBinder;

/**
 * Description：
 * Author：LiuYM
 * Date： 2017-06-02 11:37
 */

public class HorizontalViewBinder extends ItemViewBinder<HorizontalBean, HorizontalViewBinder.HorizontalViewHolder> {

    @NonNull
    @Override
    protected HorizontalViewHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        View view = inflater.inflate(R.layout.mine_horizontal_layout, parent, false);
        return new HorizontalViewHolder(view);
    }

    @Override
    protected void onBindViewHolder(@NonNull HorizontalViewHolder holder, @NonNull HorizontalBean item) {
        holder.setData(item.mNavBeanList);
    }

    class HorizontalViewHolder extends RecyclerView.ViewHolder {
        RecyclerView mRecyclerView;
        HorizontalItemAdapter mItemAdapter;

        public HorizontalViewHolder(View itemView) {
            super(itemView);
            mRecyclerView = (RecyclerView) itemView.findViewById(R.id.rl_navigation);
            mRecyclerView.setLayoutManager(new LinearLayoutManager(itemView.getContext(), LinearLayoutManager.HORIZONTAL, false));
            mItemAdapter = new HorizontalItemAdapter();
            mRecyclerView.setAdapter(mItemAdapter);
        }

        public void setData(List<MineNavBean> navs) {
            mItemAdapter.setNavBeanList(navs);
        }
    }
}
