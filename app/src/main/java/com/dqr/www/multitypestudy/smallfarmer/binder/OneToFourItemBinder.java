package com.dqr.www.multitypestudy.smallfarmer.binder;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dqr.www.multitypestudy.R;
import com.dqr.www.multitypestudy.smallfarmer.bean.OneToFourBean;

import me.drakeet.multitype.ItemViewBinder;

/**
 * Description：
 * Author：Bux on 2017/10/12 14:29
 * Email: 471025316@qq.com
 */

public class OneToFourItemBinder extends ItemViewBinder<OneToFourBean, OneToFourItemBinder.OneToFourHolder> {


    @NonNull
    @Override
    protected OneToFourHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        return new OneToFourHolder(inflater.inflate(R.layout.farmer_one_to_four_layout, parent, false));
    }

    @Override
    protected void onBindViewHolder(@NonNull OneToFourHolder holder, @NonNull OneToFourBean item) {

    }

    class OneToFourHolder extends ViewHolder {

        public OneToFourHolder(View itemView) {
            super(itemView);
        }
    }
}
