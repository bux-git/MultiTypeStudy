package com.dqr.www.multitypestudy.weibo.content;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dqr.www.multitypestudy.weibo.WeiBoContent;
import com.dqr.www.multitypestudy.weibo.WeiboFrameBinder;

/**
 * Description：
 * Author：LiuYM
 * Date： 2017-08-05 15:54
 */

public class ImageItemViewBinder extends WeiboFrameBinder<TextItem,ImageItemViewBinder.ViewHolder> {

    @Override
    protected RecyclerView.ViewHolder onCreateSubViewHolder(LayoutInflater inflater, ViewGroup parent) {
        return null;
    }

    @Override
    protected void onSubBindViewHolder(RecyclerView.ViewHolder subViewHolder, WeiBoContent content) {

    }

    class ViewHolder extends RecyclerView.ViewHolder{

        public ViewHolder(View itemView) {
            super(itemView);
        }
    }
}
