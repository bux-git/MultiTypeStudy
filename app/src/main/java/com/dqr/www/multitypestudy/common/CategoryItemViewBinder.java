package com.dqr.www.multitypestudy.common;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dqr.www.multitypestudy.R;

import me.drakeet.multitype.ItemViewBinder;

/**
 * Description：
 * Author：LiuYM
 * Date： 2017-05-15 10:18
 */

public class CategoryItemViewBinder extends ItemViewBinder<CategoryItem,CategoryItemViewBinder.CategoryViewHolder> {

    @NonNull
    @Override
    protected CategoryViewHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        View view = inflater.inflate(R.layout.item_category, parent, false);
        return new CategoryViewHolder(view);
    }

    @Override
    protected void onBindViewHolder(@NonNull CategoryViewHolder holder, @NonNull CategoryItem item) {
        holder.title.setText(item.titleText);
    }

    class CategoryViewHolder extends RecyclerView.ViewHolder{

        TextView title;

        public CategoryViewHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.title);
        }
    }
}
