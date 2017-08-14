package com.dqr.www.multitypestudy.favorites.viewbinder;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.dqr.www.multitypestudy.R;
import com.dqr.www.multitypestudy.favorites.bean.Content;
import com.dqr.www.multitypestudy.favorites.bean.FavoritesBean;

import me.drakeet.multitype.ItemViewBinder;

/**
 * Description：
 * Author：LiuYM
 * Date： 2017-08-07 10:24
 */

public abstract class FavoritesFrameBinder<SubContent extends Content, SubViewHolder extends RecyclerView.ViewHolder> extends ItemViewBinder<FavoritesBean, FavoritesFrameBinder.FrameViewHolder    > {

    /**
     * 获取内容的ViewHolder
     * @param inflater
     * @param parent
     * @return
     */
    protected abstract SubViewHolder onCreateSubViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent);

    protected abstract void onSubBindViewHolder(SubViewHolder subViewHolder,SubContent subContent);

    @NonNull
    @Override
    protected FrameViewHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        View view = inflater.inflate(R.layout.item_favorites_frame_layout, parent, false);
        SubViewHolder subViewHolder = onCreateSubViewHolder(inflater, parent);
        return new FrameViewHolder(view,  subViewHolder);
    }

    @Override
    protected void onBindViewHolder(@NonNull FavoritesFrameBinder.FrameViewHolder holder, @NonNull FavoritesBean item) {
        holder.ivAvatar.setImageResource(item.getAvatarResId());
        holder.tvUserName.setText(item.getUserName());
        holder.tvDate.setText(item.getDate());
        holder.tvFromWhere.setText(item.getFromWhere());
        onSubBindViewHolder((SubViewHolder) holder.subViewHolder, (SubContent) item.getContent());
    }

    class FrameViewHolder extends RecyclerView.ViewHolder {
        ImageView ivAvatar;
        TextView tvUserName;
        TextView tvDate;
        FrameLayout fltContainer;
        TextView tvFromWhere;
        SubViewHolder subViewHolder;

        public FrameViewHolder(View itemView, SubViewHolder subViewHolder) {
            super(itemView);
            ivAvatar = find(R.id.iv_avatar);
            tvUserName = find(R.id.tv_userName);
            tvDate = find(R.id.tv_date);
            fltContainer = find(R.id.flt_container);
            tvFromWhere = find(R.id.tv_fromWhere);
            this.subViewHolder = subViewHolder;
            fltContainer.addView(subViewHolder.itemView, new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        }

        private <T extends View> T find(int resId) {
            return (T) itemView.findViewById(resId);
        }
    }
}
