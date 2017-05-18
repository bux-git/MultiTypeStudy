package com.dqr.www.multitypestudy.weibo.content;

import android.support.annotation.DrawableRes;

import com.dqr.www.multitypestudy.weibo.WeiboContent;

/**
 * Description：
 * Author：LiuYM
 * Date： 2017-05-18 20:04
 */

public class SimpleImge extends WeiboContent {

    @DrawableRes
    public int imgResId;


    public SimpleImge(int contentType, @DrawableRes int imgResId) {
        super(contentType);
        this.imgResId = imgResId;
    }
}
