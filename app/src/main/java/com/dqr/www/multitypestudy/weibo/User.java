package com.dqr.www.multitypestudy.weibo;

import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;

/**
 * Description：
 * Author：LiuYM
 * Date： 2017-06-02 9:27
 */

public class User {


    @NonNull
    public String name;
    @DrawableRes
    public int avatar;


    public User(@NonNull String name, int avatar) {
        this.name = name;
        this.avatar = avatar;
    }
}
