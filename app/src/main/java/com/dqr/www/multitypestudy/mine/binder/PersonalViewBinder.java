package com.dqr.www.multitypestudy.mine.binder;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.dqr.www.multitypestudy.R;
import com.dqr.www.multitypestudy.mine.bean.PersonalBean;

import jp.wasabeef.glide.transformations.CropCircleTransformation;
import me.drakeet.multitype.ItemViewBinder;

/**
 * Description：
 * Author：LiuYM
 * Date： 2017-06-02 14:49
 */

public class PersonalViewBinder extends ItemViewBinder<PersonalBean, PersonalViewBinder.PersonalViewHolder> {

    @NonNull
    @Override
    protected PersonalViewHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        View view = inflater.inflate(R.layout.mine_personal_item_layout, parent, false);
        return new PersonalViewHolder(view);
    }

    @Override
    protected void onBindViewHolder(@NonNull PersonalViewHolder holder, @NonNull PersonalBean item) {
        Glide.with(holder.itemView.getContext())
                .load(item.avatar)
                .placeholder(R.drawable.user_avatar)
                .bitmapTransform(new CropCircleTransformation(holder.itemView.getContext()))
                .into(holder.mIvUserIcon);
        holder.mUserNice.setText(item.nice);
        holder.mUserCode.setText(item.cardId);
    }

    class PersonalViewHolder extends RecyclerView.ViewHolder {
        RelativeLayout mRlPersonalInfo;
        ImageView mIvUserIcon;
        TextView mUserCode;
        TextView mUserNice;
        ImageView mUserScanCode;

        public PersonalViewHolder(View itemView) {
            super(itemView);
            mRlPersonalInfo = (RelativeLayout) itemView.findViewById(R.id.rl_personal_info);
            mIvUserIcon = (ImageView) itemView.findViewById(R.id.iv_mine_user_ico);
            mUserCode = (TextView) itemView.findViewById(R.id.tv_earth_code);
            mUserNice = (TextView) itemView.findViewById(R.id.tv_nice);
            mUserScanCode = (ImageView) itemView.findViewById(R.id.iv_scan_code);

            mRlPersonalInfo.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });
            mUserScanCode.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });
        }
    }
}
