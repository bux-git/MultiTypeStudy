package com.dqr.www.multitypestudy.favorites.bean;

/**
 * Description：
 * Author：LiuYM
 * Date： 2017-08-07 10:23
 */

public class TextIBean extends Content {
    private String text;

    public TextIBean(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
