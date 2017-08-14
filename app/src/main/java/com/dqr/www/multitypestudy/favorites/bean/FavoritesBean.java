package com.dqr.www.multitypestudy.favorites.bean;

/**
 * Description：
 * Author：LiuYM
 * Date： 2017-08-07 10:18
 */

public class FavoritesBean {
    private int avatarResId;//头像
    private String userName;//用户名称
    private String date;//时间
    private String fromWhere;//来源
    private Content content;

    public FavoritesBean(int avatarResId, String userName, String date, String fromWhere, Content content) {
        this.avatarResId = avatarResId;
        this.userName = userName;
        this.date = date;
        this.fromWhere = fromWhere;
        this.content = content;
    }

    public int getAvatarResId() {
        return avatarResId;
    }

    public void setAvatarResId(int avatarResId) {
        this.avatarResId = avatarResId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getFromWhere() {
        return fromWhere;
    }

    public void setFromWhere(String fromWhere) {
        this.fromWhere = fromWhere;
    }

    public Content getContent() {
        return content;
    }

    public void setContent(Content content) {
        this.content = content;
    }
}
