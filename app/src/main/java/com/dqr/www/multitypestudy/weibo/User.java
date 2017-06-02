package com.dqr.www.multitypestudy.weibo;

/**
 * Description：
 * Author：LiuYM
 * Date： 2017-06-02 9:27
 */

public class User {

    private String nick;
    private int avatar;

    public User(String nick, int avatar) {
        this.nick = nick;
        this.avatar = avatar;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public int getAvatar() {
        return avatar;
    }

    public void setAvatar(int avatar) {
        this.avatar = avatar;
    }
}
