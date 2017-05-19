package com.dqr.www.multitypestudy.weibo.content;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dqr.www.multitypestudy.R;
import com.dqr.www.multitypestudy.weibo.WeiboFrameBinder;

/**
 * Description：
 * Author：LiuYM
 * Date： 2017-05-18 21:04
 */

public class SimpleTextBinder extends WeiboFrameBinder<SimpleText,SimpleTextBinder.TextViewHolder> {

    @Override
    protected RecyclerView.ViewHolder onCreateContentViewHolder(LayoutInflater inflater, ViewGroup parent) {
        View view = inflater.inflate(R.layout.item_text, parent, false);
        return new TextViewHolder(view);
    }

    @Override
    protected void onBindContentViewHolder(TextViewHolder holder, SimpleText content) {
        holder.text.setText(content.msg);
    }




    class TextViewHolder extends RecyclerView.ViewHolder{
        TextView text;
        public TextViewHolder(View itemView) {
            super(itemView);
            text = (TextView) itemView.findViewById(R.id.text);
        }
    }
}
