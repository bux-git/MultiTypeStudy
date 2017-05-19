package com.dqr.www.multitypestudy.weibo;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.dqr.www.multitypestudy.R;

import me.drakeet.multitype.ItemViewBinder;

/**
 * Description：
 * Author：LiuYM
 * Date： 2017-05-18 20:19
 */

public abstract class WeiboFrameBinder<Content extends WeiboContent, SubViewHolder extends RecyclerView.ViewHolder>
        extends ItemViewBinder<Weibo, WeiboFrameBinder.FrameHolder> {

    protected abstract RecyclerView.ViewHolder onCreateContentViewHolder(LayoutInflater inflater, ViewGroup parent);

    protected abstract void onBindContentViewHolder(SubViewHolder holder, Content content);

    @NonNull
    @Override
    protected FrameHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        View view = inflater.inflate(R.layout.item_weibo_frame, parent, false);
        RecyclerView.ViewHolder subViewHolder = onCreateContentViewHolder(inflater, parent);
        return new FrameHolder(view,subViewHolder);
    }

    @Override
    protected void onBindViewHolder(@NonNull FrameHolder holder, @NonNull Weibo item) {
        holder.avatar.setImageResource(item.user.avatar);
        holder.userName.setText(item.user.name);
        holder.createTime.setText(item.createTime);
        WeiboContent weiboContent=item.mWeiboContent;
        onBindContentViewHolder((SubViewHolder)holder.subViewHolder,(Content)weiboContent);

    }

    public static class FrameHolder extends RecyclerView.ViewHolder {
        ImageView avatar;
        TextView userName;
        FrameLayout container;
        TextView createTime;
        RecyclerView.ViewHolder subViewHolder;

        public FrameHolder(View itemView,RecyclerView.ViewHolder subViewHolder) {
            super(itemView);
            avatar = findViewById(R.id.avatar);
            userName = findViewById(R.id.username);
            container = findViewById(R.id.container);
            createTime = findViewById(R.id.create_time);
            container.addView(subViewHolder.itemView);
            this.subViewHolder=subViewHolder;
        }

        private <T extends View> T findViewById(int resId) {
            return (T) itemView.findViewById(resId);
        }
    }

}
