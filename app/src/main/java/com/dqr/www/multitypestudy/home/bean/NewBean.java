package com.dqr.www.multitypestudy.home.bean;

/**
 * Description：
 * Author：LiuYM
 * Date： 2017-08-14 17:14
 */

public class NewBean {
    private int leftImgResId;
    private String newDesc;
    private String url;

    public NewBean(int leftImgResId, String newDesc, String url) {
        this.leftImgResId = leftImgResId;
        this.newDesc = newDesc;
        this.url = url;
    }

    public int getLeftImgResId() {
        return leftImgResId;
    }

    public void setLeftImgResId(int leftImgResId) {
        this.leftImgResId = leftImgResId;
    }

    public String getNewDesc() {
        return newDesc;
    }

    public void setNewDesc(String newDesc) {
        this.newDesc = newDesc;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
