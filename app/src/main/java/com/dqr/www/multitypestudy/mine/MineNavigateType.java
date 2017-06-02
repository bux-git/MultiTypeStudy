package com.dqr.www.multitypestudy.mine;

import android.support.annotation.IntDef;

/**
 * Description："我的" 导航栏注解类
 * Author：lxl
 * Date： 2016/12/6 15:22
 */
public class MineNavigateType {
    private byte tab;
    public static final byte DIARY=0;//成长路程
    public static final byte NEW_YEAR_VIDEO=1;//拜年视频
    public static final byte ALBUM=2;//时光相册
    public static final byte VIDEO=3;//生活视频
    public static final byte INTRO=4;//互联网名片
    public static final byte PERSONAL=5;//个人中心
    public static final byte VIP=6;//会员中心
    public static final byte SMART_LIFE=7;//智能生活
    public static final byte YIELD=8;//地球人收益


    @IntDef({DIARY,NEW_YEAR_VIDEO, ALBUM, VIDEO,INTRO,PERSONAL,VIP,SMART_LIFE,YIELD})
    public @interface Tab{}

    public byte getTab() {
        return tab;
    }

    public void setTab(byte tab) {
        this.tab = tab;
    }
}
