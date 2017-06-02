package com.dqr.www.multitypestudy.mine.bean;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.dqr.www.multitypestudy.R;

import me.drakeet.multitype.ItemViewBinder;

import static com.dqr.www.multitypestudy.R.id.btn_edit;

/**
 * Description：
 * Author：LiuYM
 * Date： 2017-06-02 15:30
 */

public class FunViewBinder extends ItemViewBinder<FunItemBean, FunViewBinder.FunViewHolder> {


    @NonNull
    @Override
    protected FunViewHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        View view = inflater.inflate(R.layout.mine_fun_item_layout, parent, false);
        return new FunViewHolder(view);
    }

    @Override
    protected void onBindViewHolder(@NonNull FunViewHolder holder, @NonNull FunItemBean item) {
        Glide.with(holder.itemView.getContext())
                .load(item.bgImg)
                .placeholder(item.defaultResId)
                .into(holder.ivBg);
        holder.tvDetail.setText(item.detail);
        holder.tvTitle.setText(item.title);
        if (item.isEdit) {
            holder.btnEdit.setVisibility(View.VISIBLE);
            holder.btnEdit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });
        } else {
            holder.btnEdit.setVisibility(View.GONE);
        }

        holder.rlContainer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    class FunViewHolder extends RecyclerView.ViewHolder {

        RelativeLayout rlContainer;
        ImageView ivBg;
        Button btnEdit;
        TextView tvTitle;
        TextView tvDetail;

        public FunViewHolder(View itemView) {
            super(itemView);
            rlContainer = (RelativeLayout) itemView.findViewById(R.id.rl_container);
            ivBg = (ImageView) itemView.findViewById(R.id.iv_bg);
            btnEdit = (Button) itemView.findViewById(btn_edit);
            tvTitle = (TextView) itemView.findViewById(R.id.tv_title);
            tvDetail = (TextView) itemView.findViewById(R.id.tv_detail);
        }
    }
}
