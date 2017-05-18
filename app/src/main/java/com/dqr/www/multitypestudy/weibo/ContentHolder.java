package com.dqr.www.multitypestudy.weibo;

import android.view.View;

/**
 * Description：
 * Author：LiuYM
 * Date： 2017-05-18 20:44
 */

public class ContentHolder {

    WeiboFrameBinder.FrameHolder mFrameHolder;
    public final View itemView;

    public ContentHolder(View itemView) {
        this.itemView = itemView;
    }

    public WeiboFrameBinder.FrameHolder getParent(){
        return mFrameHolder;
    }

}
