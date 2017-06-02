package com.dqr.www.multitypestudy.weibo.content;


import com.dqr.www.multitypestudy.weibo.WeiBoContent;

/**
 * Description：
 * Author：LiuYM
 * Date： 2017-06-02 19:44
 */

public class TextItem extends WeiBoContent {

    public String text;

    public TextItem(String text) {
        super("text_image");
        this.text=text;
    }
}
