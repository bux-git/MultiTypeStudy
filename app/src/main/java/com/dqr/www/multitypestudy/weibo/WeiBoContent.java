package com.dqr.www.multitypestudy.weibo;

import android.support.annotation.NonNull;

/**
 * Description：
 * Author：LiuYM
 * Date： 2017-06-02 19:09
 */

public  class WeiBoContent {
    @NonNull
    public final String contentType;


    protected WeiBoContent(@NonNull String contentType) {
        this.contentType = contentType;
    }
}
