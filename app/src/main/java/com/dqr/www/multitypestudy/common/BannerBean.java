package com.dqr.www.multitypestudy.common;

/**
 * Description：
 * Author：LiuYM
 * Date： 2017-06-02 10:01
 */

public class BannerBean {
    private String url;
    private String title;
    private String imgUrl;

    public BannerBean(String url, String title, String imgUrl) {
        this.url = url;
        this.title = title;
        this.imgUrl = imgUrl;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }
}
