package com.dqr.www.multitypestudy.normal;

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
 * Date： 2017-05-12 11:58
 */

public class RichItemViewBinder extends ItemViewBinder<RichItem,RichItemViewBinder.RichItemViewHolder> {

    @NonNull
    @Override
    protected RichItemViewHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        View view = inflater.inflate(R.layout.item_rich, parent, false);
        return new RichItemViewHolder(view);
    }

    @Override
    protected void onBindViewHolder(@NonNull RichItemViewHolder holder, @NonNull RichItem item) {
        holder.mImageView.setImageResource(item.imageResId);
        holder.mTextView.setText(item.text);
    }

    class RichItemViewHolder extends RecyclerView.ViewHolder{
        ImageView mImageView;
        TextView mTextView;


        public RichItemViewHolder(View itemView) {
            super(itemView);
            mImageView= (ImageView) itemView.findViewById(R.id.image);
            mTextView = (TextView) itemView.findViewById(R.id.text);
        }
    }
}
