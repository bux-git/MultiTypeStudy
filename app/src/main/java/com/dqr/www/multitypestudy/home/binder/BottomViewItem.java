package com.dqr.www.multitypestudy.home.binder;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dqr.www.multitypestudy.R;

import me.drakeet.multitype.ItemViewBinder;

/**
 * Description：
 * Author：LiuYM
 * Date： 2017-08-16 14:59
 */

public class BottomViewItem extends ItemViewBinder {
    @NonNull
    @Override
    protected RecyclerView.ViewHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        return new BottomViewViewHolder(inflater.inflate(R.layout.home_item_bottom_layout, parent, false));
    }

    @Override
    protected void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, @NonNull Object item) {

    }

    class  BottomViewViewHolder extends RecyclerView.ViewHolder{

        public BottomViewViewHolder(View itemView) {
            super(itemView);
        }
    }
}
