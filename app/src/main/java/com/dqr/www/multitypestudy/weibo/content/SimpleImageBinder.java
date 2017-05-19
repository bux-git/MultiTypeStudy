package com.dqr.www.multitypestudy.weibo.content;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.dqr.www.multitypestudy.R;
import com.dqr.www.multitypestudy.weibo.WeiboFrameBinder;

/**
 * Description：
 * Author：LiuYM
 * Date： 2017-05-19 11:26
 */

public class SimpleImageBinder extends WeiboFrameBinder<SimpleImge,SimpleImageBinder.ImageViewHolder> {


    @Override
    protected RecyclerView.ViewHolder onCreateContentViewHolder(LayoutInflater inflater, ViewGroup parent) {
        View view = inflater.inflate(R.layout.item_image, parent, false);
        return new ImageViewHolder(view);
    }

    @Override
    protected void onBindContentViewHolder(ImageViewHolder holder, SimpleImge content) {
        holder.image.setImageResource(content.imgResId);
    }

    class ImageViewHolder extends RecyclerView.ViewHolder{
        ImageView image;
        public ImageViewHolder(View itemView) {
            super(itemView);
            image = (ImageView) itemView.findViewById(R.id.image);
        }
    }
}
