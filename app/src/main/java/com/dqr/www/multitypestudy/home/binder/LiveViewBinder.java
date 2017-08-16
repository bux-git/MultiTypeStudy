/*
 * Copyright (c) 2015.
 * 湖南球谱科技有限公司版权所有
 * Hunan Qiupu Technology Co., Ltd. all rights reserved.
 */

package com.dqr.www.multitypestudy.home.binder;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.devlin_n.videoplayer.player.IjkVideoView;
import com.dqr.www.multitypestudy.R;
import com.dqr.www.multitypestudy.home.bean.LiveBean;
import com.dqr.www.multitypestudy.widget.ijkvideo.VideoController;

import java.util.List;


/**
 * Description：
 * Author：LiuYM
 * Date： 2017-08-08 17:59
 */

public class LiveViewBinder extends FrameViewBinder<LiveBean> {




    @Override
    public View onSubCreateView(LayoutInflater inflater, ViewGroup parent, int dataSize, int index) {
        return inflater.inflate(R.layout.home_item_live_layout, parent, false);
    }

    @Override
    public void onSubViewBind(View itemView, List<LiveBean> subList, int index) {
        LiveBean liveBean = subList.get(index);

        IjkVideoView ijkVideoView = (IjkVideoView) itemView.findViewById(R.id.ijkVideoView);
        VideoController controller = new VideoController(mContext);
        controller.setLive(true);

        Glide.with(mContext)
                .load(liveBean.getBgResId())
                .crossFade()
                .placeholder(android.R.color.darker_gray)
                .into(controller.getThumb());
        ijkVideoView
                //.useSurfaceView()
                .setUrl(liveBean.getVideoPath())
                .setTitle(liveBean.getTitle())
                .addToPlayerManager()
                .setVideoController(controller);
    }
}
