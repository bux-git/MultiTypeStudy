package com.dqr.www.multitypestudy.mine.bean;

import com.dqr.www.multitypestudy.mine.MineNavigateType;

/**
 * Description：
 * Author：LiuYM
 * Date： 2017-06-02 15:26
 */

public class FunItemBean {
    public String bgImg;
    public int defaultResId;
    public int title;
    public int detail;
    public boolean isEdit;
    public byte navType;
    public int countSpan;
    public int index;

    public FunItemBean(String bgImg, int defaultResId, int title, int detail, boolean isEdit, @MineNavigateType.Tab byte type, int countSpan,int index) {
        this.bgImg = bgImg;
        this.defaultResId = defaultResId;
        this.title = title;
        this.detail = detail;
        this.isEdit = isEdit;
        this.navType = type;
        this.countSpan = countSpan;
        this.index=index;
    }
}
