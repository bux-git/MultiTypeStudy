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
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.dqr.www.multitypestudy.R;
import com.dqr.www.multitypestudy.home.bean.ECard;

import java.util.List;

/**
 * Description：
 * Author：LiuYM
 * Date： 2017-08-08 19:47
 */

public class ECardViewItemBinder extends FrameViewBinder<ECard> {


    @Override
    public View onSubCreateView(LayoutInflater inflater, ViewGroup parent, int dataSize, int index) {

        View childView = LayoutInflater.from(mContext).inflate(R.layout.home_item_ecard_layout, parent, false);
        if (index != dataSize - 1) {
            childView.findViewById(R.id.v_driver).setVisibility(View.VISIBLE);
        }
        return childView;
    }

    @Override
    public void onSubViewBind(View itemView, List<ECard> subList, int index) {
        final ECard eCard = subList.get(index);
        ECard.InfoBean infoBean = eCard.getInfo();
        ECard.ComInfo comInfo = eCard.getComInfo();

        ImageView ivBgImg = (ImageView) itemView.findViewById(R.id.iv_bgImg);
        TextView tvTitle = (TextView) itemView.findViewById(R.id.tv_card_title);
        RelativeLayout rltContainer = (RelativeLayout) itemView.findViewById(R.id.rlt_container);

        TextView tvCardName = (TextView) itemView.findViewById(R.id.tv_card_name);
        TextView tvCardNice = (TextView) itemView.findViewById(R.id.tv_card_nice);
        TextView tvCardCode = (TextView) itemView.findViewById(R.id.tv_card_code);
        TextView tvCardOrigin = (TextView) itemView.findViewById(R.id.tv_card_origin);
        TextView tvWorkPlace = (TextView) itemView.findViewById(R.id.tv_card_work);


        Glide.with(mContext).load(eCard.getIcImg())
                .placeholder(R.drawable.ic_ecard_list_normal_head)
                .error(R.drawable.ic_ecard_list_normal_head)
                .into(ivBgImg);
        tvTitle.setText(eCard.getIcName());

        if (!TextUtils.isEmpty(eCard.getNice())) {
            tvCardNice.setVisibility(View.VISIBLE);
            tvCardNice.setText("昵称：" + eCard.getNice());
        }

        if (!TextUtils.isEmpty(eCard.getCardId())) {
            tvCardCode.setVisibility(View.VISIBLE);
            tvCardCode.setText("代码：" + eCard.getCardId().toUpperCase());
        }

        String surname = "";
        String origo = "";
        String workPlace = "";
        if (infoBean != null) {
            surname = infoBean.getSurname();
            origo = infoBean.getOrigo();
            workPlace = infoBean.getWorkplace();
        }
        if (comInfo != null) {
            surname = comInfo.getSurname();
            origo = "";
            workPlace = comInfo.getCompanyAddress();
        }

        if (!TextUtils.isEmpty(surname)) {
            tvCardName.setVisibility(View.VISIBLE);
            tvCardName.setText("姓名：" + surname);
        }


        if (!TextUtils.isEmpty(origo)) {
            tvCardOrigin.setVisibility(View.VISIBLE);
            tvCardOrigin.setText("籍贯：" + origo);
        }

        if (!TextUtils.isEmpty(workPlace)) {
            tvCardName.setVisibility(View.VISIBLE);
            tvWorkPlace.setText("工作地：" + workPlace);
        }


        rltContainer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (eCard.getId() == 0) return;
            }
        });
    }
}
