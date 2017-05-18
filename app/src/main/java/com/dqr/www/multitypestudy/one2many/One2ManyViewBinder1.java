package com.dqr.www.multitypestudy.one2many;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dqr.www.multitypestudy.R;

import me.drakeet.multitype.ItemViewBinder;

/**
 * Description：
 * Author：LiuYM
 * Date： 2017-05-18 15:51
 */

public class One2ManyViewBinder1 extends ItemViewBinder<Data, One2ManyViewBinder1.One2ManyViewHolder1> {


    @NonNull
    @Override
    protected One2ManyViewHolder1 onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        View view = inflater.inflate(R.layout.item_one_2_many, parent, false);
        return new One2ManyViewHolder1(view);
    }

    @Override
    protected void onBindViewHolder(@NonNull One2ManyViewHolder1 holder, @NonNull Data item) {
        holder.tvData.setText(item.text);

    }

    class One2ManyViewHolder1 extends RecyclerView.ViewHolder {
        TextView tvData;

        public One2ManyViewHolder1(View itemView) {
            super(itemView);
            tvData = (TextView) itemView.findViewById(R.id.tv_data);
            tvData.setGravity(Gravity.LEFT);
             tvData.setTextColor(itemView.getContext().getResources().getColor(R.color.material_text_primary));
        }
    }
}
