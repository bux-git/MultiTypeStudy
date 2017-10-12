package com.dqr.www.multitypestudy.smallfarmer.binder;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dqr.www.multitypestudy.R;
import com.dqr.www.multitypestudy.smallfarmer.bean.ItemTitleBean;

import me.drakeet.multitype.ItemViewBinder;

/**
 * Description：
 * Author：Bux on 2017/10/12 15:01
 * Email: 471025316@qq.com
 */

public class ItemTitleItemBinder extends ItemViewBinder<ItemTitleBean, ItemTitleItemBinder.ItemTitleHolder> {

    @NonNull
    @Override
    protected ItemTitleHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        return new ItemTitleHolder(inflater.inflate(R.layout.farmer_title_item_layout, parent, false));
    }

    @Override
    protected void onBindViewHolder(@NonNull ItemTitleHolder holder, @NonNull ItemTitleBean item) {
        holder.tvTitle.setText(item.getTitle());
    }

    class ItemTitleHolder extends RecyclerView.ViewHolder {

        TextView tvTitle;

        public ItemTitleHolder(View itemView) {
            super(itemView);
            tvTitle = (TextView) itemView.findViewById(R.id.tvTitle);
        }
    }
}
