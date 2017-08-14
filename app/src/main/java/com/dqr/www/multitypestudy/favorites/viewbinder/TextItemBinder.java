package com.dqr.www.multitypestudy.favorites.viewbinder;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dqr.www.multitypestudy.R;
import com.dqr.www.multitypestudy.favorites.bean.TextIBean;

/**
 * Description：
 * Author：LiuYM
 * Date： 2017-08-07 11:39
 */

public class TextItemBinder extends FavoritesFrameBinder<TextIBean,TextItemBinder.TextItemHolder> {

    @Override
    protected TextItemHolder onCreateSubViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        View view = inflater.inflate(R.layout.item_favorites_layout, parent, false);
        return new TextItemHolder(view);
    }

    @Override
    protected void onSubBindViewHolder(TextItemHolder textItemHolder, TextIBean textIBean) {
        textItemHolder.tvContent.setText(textIBean.getText());
    }

    class TextItemHolder extends RecyclerView.ViewHolder{
        TextView tvContent;
        public TextItemHolder(View itemView) {
            super(itemView);
            tvContent = (TextView) itemView.findViewById(R.id.tv_content);
        }
    }
}
