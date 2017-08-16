/*
 * Copyright (c) 2015.
 * 湖南球谱科技有限公司版权所有
 * Hunan Qiupu Technology Co., Ltd. all rights reserved.
 */

package com.dqr.www.multitypestudy.home.binder;


import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.dqr.www.multitypestudy.R;
import com.dqr.www.multitypestudy.home.bean.EAlbum;

import java.util.List;

/**
 * Description：
 * Author：LiuYM
 * Date： 2017-08-09 8:22
 */

public class EAlbumViewBinder extends FrameViewBinder<EAlbum> {


    @Override
    public View onSubCreateView(LayoutInflater inflater, ViewGroup parent, int dataSize, int index) {
        //是否是双数
        boolean isDouble = dataSize % 2 == 0 ? true : false;
        int count = dataSize / 2 + dataSize % 2;//计算需要执行的次数 取整+取余
        if (index >= count) return null;
        View childView = LayoutInflater.from(mContext).inflate(R.layout.home_item_ealbum_layout, parent, false);

        if (index == count - 1 && !isDouble) {//单数 最后一排第二个不要
            childView.findViewById(R.id.llt_two).setVisibility(View.INVISIBLE);
        }
        return childView;
    }

    @Override
    public void onSubViewBind(View itemView, List<EAlbum> subList, int index) {

        int dataSize = subList.size();

        //第一项下标
        final int pos1 = index * 2;
        if (pos1 >= dataSize) return;
        final EAlbum eAlbum1 = subList.get(pos1);
        ImageView bgImg1 = (ImageView) itemView.findViewById(R.id.iv_bgImg1);
        TextView tvName1 = (TextView) itemView.findViewById(R.id.tv_name1);
        viewBind(bgImg1, tvName1, eAlbum1);
        //第二项下标
        final int pos2 = pos1 + 1;
        if (pos2 >= dataSize) return;
        final EAlbum eAlbum2 = subList.get(pos2);
        ImageView bgImg2 = (ImageView) itemView.findViewById(R.id.iv_bgImg2);
        TextView tvName2 = (TextView) itemView.findViewById(R.id.tv_name2);
        viewBind(bgImg2, tvName2, eAlbum2);

    }


    private void viewBind(ImageView bgImg1, TextView tvName1, final EAlbum eAlbum1) {
        Glide.with(mContext).load(eAlbum1.getImageUrl())
                .placeholder(R.drawable.ic_head_normal)
                .error(R.drawable.bg_photo_normal).into(bgImg1);
        tvName1.setText(eAlbum1.getName());


        bgImg1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(eAlbum1.getShareUrl())) return;
            }
        });
    }
}
