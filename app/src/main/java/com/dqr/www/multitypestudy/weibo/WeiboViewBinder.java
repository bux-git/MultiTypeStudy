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
 * Date： 2017-06-02 20:39
 */

public abstract class WeiboViewBinder
        extends ItemViewBinder<WeiBo, WeiboViewBinder.WeiBoFrameViewHolder> {

    protected abstract RecyclerView.ViewHolder onCreateSubViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent);

    protected abstract void onSubBindViewHolder(RecyclerView.ViewHolder subViewHolder, WeiBoContent content);


    @NonNull
    @Override
    protected WeiBoFrameViewHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        View view = inflater.inflate(R.layout.item_weibo_frame, parent, false);
        RecyclerView.ViewHolder subViewHolder = onCreateSubViewHolder(inflater, parent);
        return new WeiBoFrameViewHolder(view,subViewHolder);
    }

    @Override
    protected void onBindViewHolder(@NonNull WeiBoFrameViewHolder holder, @NonNull WeiBo item) {
        holder.avatar.setImageResource(item.user.getAvatar());
        holder.username.setText(item.user.getNick());
        holder.create_time.setText(item.createTime);
        onSubBindViewHolder(holder.mSubViewHolder, item.content);

    }


    class WeiBoFrameViewHolder extends RecyclerView.ViewHolder {
        ImageView avatar;
        TextView username;
        FrameLayout container;
        TextView create_time;
        RecyclerView.ViewHolder mSubViewHolder;

        public WeiBoFrameViewHolder(View itemView,RecyclerView.ViewHolder subViewHolder) {
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
