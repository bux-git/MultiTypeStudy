package com.dqr.www.multitypestudy.mine;

import android.support.annotation.IntDef;

/**
 * Description："我的" 导航栏注解类
 * Author：lxl
 * Date： 2016/12/6 15:22
 */
public class MineNavigateType {
    private byte tab;
    public static final int DIARY=0;//成长路程
    public static final int NEW_YEAR_VIDEO=1;//拜年视频
    public static final int ALBUM=2;//时光相册
    public static final int VIDEO=3;//生活视频
    public static final int INTRO=4;//互联网名片
    public static final int PERSONAL=5;//个人中心
    public static final int VIP=6;//会员中心
    public static final int SMART_LIFE=7;//智能生活
    public static final int YIELD=8;//地球人收益

    public static final byte HOME_OFFICIAL=30;//新闻
    public static final byte HOME_NEWS=31;//新闻
    public static final byte HOME_VIDEO=32;//视频专区
    public static final byte HOME_CHANNEL=33;//地球人频道
    public static final byte HOME_LITERATURE=34;//地球人文学
    public static final byte HOME_RANKING=35;//排行榜
    public static final byte HOME_RECORD=36;//视频录制
    public static final byte HOME_MORE=37;//更多
    public static final byte HOME_MARRIAGE=38;//婚恋交友


    @IntDef({DIARY,NEW_YEAR_VIDEO, ALBUM, VIDEO,INTRO,PERSONAL,VIP,SMART_LIFE,YIELD
    ,HOME_OFFICIAL,HOME_NEWS,HOME_VIDEO,HOME_CHANNEL,HOME_LITERATURE,HOME_RANKING,HOME_RECORD,HOME_MORE,HOME_MARRIAGE})
    public @interface Tab{}

}
