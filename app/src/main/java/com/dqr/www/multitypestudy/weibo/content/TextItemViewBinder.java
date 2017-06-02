package com.dqr.www.multitypestudy.weibo.content;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dqr.www.multitypestudy.R;
import com.dqr.www.multitypestudy.weibo.WeiBoContent;
import com.dqr.www.multitypestudy.weibo.WeiboViewBinder;


public class TextItemViewBinder extends WeiboViewBinder{


    @Override
    protected RecyclerView.ViewHolder onCreateSubViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        View view = inflater.inflate(R.layout.item_text, parent, false);
        return new TextItemViewHolder(view);
    }

    @Override
    protected void onSubBindViewHolder(RecyclerView.ViewHolder subViewHolder, WeiBoContent content) {
        TextItem textItem= (TextItem) content;
        TextItemViewHolder holder = (TextItemViewHolder) subViewHolder;
        holder.text.setText(textItem.text);
    }

    class TextItemViewHolder extends RecyclerView.ViewHolder{
        TextView text;
        public TextItemViewHolder(View itemView) {
            super(itemView);
            text = (TextView) itemView.findViewById(R.id.text);
        }
    }
}
