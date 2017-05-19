package com.dqr.www.multitypestudy.weibo;

/**
 * Description：
 * Author：LiuYM
 * Date： 2017-05-18 17:22
 */

public class Weibo {
    public User user;
    public WeiboContent mWeiboContent;
    public String createTime;

    public Weibo(User user, WeiboContent weiboContent) {
        this.user = user;
        mWeiboContent = weiboContent;
        this.createTime = "Just now";

    }
}
