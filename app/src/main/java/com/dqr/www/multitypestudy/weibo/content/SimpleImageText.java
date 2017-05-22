package com.dqr.www.multitypestudy.weibo.content;

/**
 * Description：
 * Author：LiuYM
 * Date： 2017-05-22 8:36
 */

public class SimpleImageText extends ContentType {
    public int imgResId;
    public String text;

    public SimpleImageText(int imgResId, String text) {
        this.imgResId = imgResId;
        this.text = text;
    }
}
