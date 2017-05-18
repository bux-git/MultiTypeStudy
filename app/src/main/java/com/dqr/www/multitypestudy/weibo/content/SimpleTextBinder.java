package com.dqr.www.multitypestudy.weibo.content;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dqr.www.multitypestudy.R;
import com.dqr.www.multitypestudy.weibo.ContentHolder;
import com.dqr.www.multitypestudy.weibo.WeiboFrameBinder;

/**
 * Description：
 * Author：LiuYM
 * Date： 2017-05-18 21:04
 */

public class SimpleTextBinder extends WeiboFrameBinder<SimpleText,SimpleTextBinder.ViewHolder> {

    @Override
    protected ContentHolder onCreateContentViewHolder(LayoutInflater inflater, ViewGroup parent) {
        View view = inflater.inflate(R.layout.item_text, parent, false);
        return new ViewHolder(view);
    }

    @Override
    protected void onBindContentViewHolder(ViewHolder holder, SimpleText content) {
        holder.text.setText(content.msg);
    }

    class ViewHolder extends ContentHolder{
        TextView text;
        public ViewHolder(View itemView) {
            super(itemView);
            text = (TextView) itemView.findViewById(R.id.text);
        }
    }
}
