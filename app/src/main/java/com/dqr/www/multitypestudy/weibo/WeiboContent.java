package com.dqr.www.multitypestudy.weibo;

/**
 * Description：
 * Author：LiuYM
 * Date： 2017-05-18 17:19
 */

public abstract class WeiboContent {

    public  int contentType;

    public WeiboContent(int contentType) {
        this.contentType = contentType;
    }
}
