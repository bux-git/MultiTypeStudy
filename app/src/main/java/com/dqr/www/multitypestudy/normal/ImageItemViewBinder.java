package com.dqr.www.multitypestudy.normal;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.dqr.www.multitypestudy.R;

import me.drakeet.multitype.ItemViewBinder;

/**
 * Description：
 * Author：LiuYM
 * Date： 2017-05-12 11:46
 */

public class ImageItemViewBinder extends ItemViewBinder<ImageItem,ImageItemViewBinder.ImageItemViewHolder> {

    @NonNull
    @Override
    protected ImageItemViewHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        View view = inflater.inflate(R.layout.item_image, parent, false);
        return new ImageItemViewHolder(view);
    }

    @Override
    protected void onBindViewHolder(@NonNull ImageItemViewHolder holder, @NonNull ImageItem item) {
        holder.mImageView.setImageResource(item.resId);
    }

    class ImageItemViewHolder extends RecyclerView.ViewHolder{

        ImageView mImageView;

        public ImageItemViewHolder(View itemView) {
            super(itemView);
            mImageView= (ImageView) itemView.findViewById(R.id.image);

        }
    }
}
