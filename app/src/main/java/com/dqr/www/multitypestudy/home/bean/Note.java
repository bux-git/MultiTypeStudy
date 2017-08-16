package com.dqr.www.multitypestudy.home.bean;

/**
 * Description：
 * Author：LiuYM
 * Date： 2017-08-16 10:44
 */

public class Note {

    private String title;
    private String bgImg;
    private int see;
    private int collection;
    private int comment;


    public Note(String title, String bgImg, int see, int collection, int comment) {
        this.title = title;
        this.bgImg = bgImg;
        this.see = see;
        this.collection = collection;
        this.comment = comment;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBgImg() {
        return bgImg;
    }

    public void setBgImg(String bgImg) {
        this.bgImg = bgImg;
    }

    public int getSee() {
        return see;
    }

    public void setSee(int see) {
        this.see = see;
    }

    public int getCollection() {
        return collection;
    }

    public void setCollection(int collection) {
        this.collection = collection;
    }

    public int getComment() {
        return comment;
    }

    public void setComment(int comment) {
        this.comment = comment;
    }
}
