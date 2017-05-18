package com.dqr.www.multitypestudy.blibli;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.dqr.www.multitypestudy.R;

import me.drakeet.multitype.ItemViewBinder;

/**
 * Description：
 * Author：LiuYM
 * Date： 2017-05-18 11:50
 */

public class PostItemViewBinder extends ItemViewBinder<PostItem, PostItemViewBinder.PostViewHolder> {


    @NonNull
    @Override
    protected PostViewHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        View view = inflater.inflate(R.layout.item_post, parent, false);
        return new PostViewHolder(view);
    }

    @Override
    protected void onBindViewHolder(@NonNull PostViewHolder holder, @NonNull PostItem item) {
        holder.ivPost.setImageResource(item.imgResId);
        holder.tvText.setText(item.text);
    }

    class PostViewHolder extends RecyclerView.ViewHolder {
        ImageView ivPost;
        TextView tvText;

        public PostViewHolder(View itemView) {
            super(itemView);
            ivPost = (ImageView) itemView.findViewById(R.id.iv_post);
            tvText = (TextView) itemView.findViewById(R.id.tv_text);
        }
    }
}
