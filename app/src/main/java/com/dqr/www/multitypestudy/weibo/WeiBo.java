package com.dqr.www.multitypestudy.weibo;

/**
 * Description：
 * Author：LiuYM
 * Date： 2017-06-02 19:09
 */

public class WeiBo {
    public User user;
    public WeiBoContent content;
    public String createTime;

    public WeiBo(User user, WeiBoContent content) {
        this.user = user;
        this.content = content;
        this.createTime = "Just Now";
    }
}
