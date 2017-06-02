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
 * Date： 2017-06-02 22:51
 */

public abstract class WeiboTestBinder<Content extends WeiBoContent,SubViewHolder extends RecyclerView.ViewHolder>
        extends ItemViewBinder<WeiBo,WeiboTestBinder.WeiBoViewHolder> {

    protected abstract SubViewHolder onCreateSubViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent);
    protected abstract void onBindSubViewHolder(SubViewHolder viewHolder,Content content);

    @NonNull
    @Override
    protected WeiboTestBinder.WeiBoViewHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        View view = inflater.inflate(R.layout.item_weibo_frame, parent, false);
        SubViewHolder subViewHolder = onCreateSubViewHolder(inflater, parent);
        return new WeiBoViewHolder(view,subViewHolder);
    }

    @Override
    protected void onBindViewHolder(@NonNull WeiboTestBinder.WeiBoViewHolder holder, @NonNull WeiBo item) {
        holder.avatar.setImageResource(item.user.avatar);
        holder.username.setText(item.user.name);
        holder.create_time.setText(item.createTime);
        onBindSubViewHolder((SubViewHolder) holder.mSubViewHolder, (Content)item.content);
    }

    class WeiBoViewHolder extends RecyclerView.ViewHolder {
        ImageView avatar;
        TextView username;
        FrameLayout container;
        TextView create_time;
        SubViewHolder mSubViewHolder;

        public WeiBoViewHolder(View itemView, SubViewHolder subViewHolder) {
            super(itemView);
            avatar = findViewById(R.id.avatar);
            username = findViewById(R.id.username);
            container = findViewById(R.id.container);
            create_time = findViewById(R.id.create_time);
            mSubViewHolder=subViewHolder;
            container.addView(subViewHolder.itemView);
        }

        private <T extends View> T findViewById(int resId) {
            return (T) itemView.findViewById(resId);
        }
    }
}
