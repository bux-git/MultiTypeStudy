package com.dqr.www.multitypestudy.weibo.content;

import com.dqr.www.multitypestudy.weibo.WeiboContent;

/**
 * Description：
 * Author：LiuYM
 * Date： 2017-05-18 20:07
 */

public class SimpleText extends WeiboContent {

    public String msg;


    public SimpleText(int contentType, String msg) {
        super(contentType);
        this.msg = msg;
    }
}
