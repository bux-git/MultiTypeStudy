package com.dqr.www.multitypestudy.smallfarmer.binder;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dqr.www.multitypestudy.R;
import com.dqr.www.multitypestudy.smallfarmer.bean.SingleItem2Bean;

import me.drakeet.multitype.ItemViewBinder;

/**
 * Description：
 * Author：Bux on 2017/10/12 14:00
 * Email: 471025316@qq.com
 */

public class SingleItem2Binder extends ItemViewBinder<SingleItem2Bean,SingleItem2Binder.SingleItemHolder> {

    @NonNull
    @Override
    protected SingleItemHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        return new SingleItemHolder(inflater.inflate(R.layout.farmer_item_single_2_layout,parent,false));
    }

    @Override
    protected void onBindViewHolder(@NonNull SingleItemHolder holder, @NonNull SingleItem2Bean item) {

    }

    class SingleItemHolder extends RecyclerView.ViewHolder{

        public SingleItemHolder(View itemView) {
            super(itemView);
        }
    }
}
