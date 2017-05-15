package com.dqr.www.multitypestudy.common;

import android.support.annotation.DrawableRes;

/**
 * Description：
 * Author：LiuYM
 * Date： 2017-05-15 10:08
 */

public class CategoryItem {

    @DrawableRes
    public int leftResId;
    @DrawableRes
    public int rightResId;
    public String titleText;
    public String rightText;

    public CategoryItem(int leftResId, int rightResId, String titleText, String rightText) {
        this.leftResId = leftResId;
        this.rightResId = rightResId;
        this.titleText = titleText;
        this.rightText = rightText;
    }
}
