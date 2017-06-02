package com.dqr.www.multitypestudy.weibo;

import android.support.annotation.NonNull;

/**
 * Description：
 * Author：LiuYM
 * Date： 2017-06-02 19:09
 */

public class WeiBo {

    @NonNull
    public User user;
    @NonNull public WeiBoContent content;
    @NonNull public String createTime;
    /* ... id, counts, etc. */


    public WeiBo(@NonNull User user, @NonNull WeiBoContent content) {
        this.user = user;
        this.content = content;
        this.createTime = "Just now";
    }


    @Override public String toString() {
        return "content: " + content.getClass().getSimpleName();
    }
}
