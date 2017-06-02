package com.dqr.www.multitypestudy.mine;

import android.content.Context;

import com.dqr.www.multitypestudy.R;
import com.dqr.www.multitypestudy.mine.bean.MineNavBean;

import java.util.ArrayList;
import java.util.List;


public class StaticDataSource {



    /**
     * 我的页面导航按钮列表
     *
     * @param context
     * @return
     */
    public static List<MineNavBean> getMineNavigateList(Context context) {
        List<MineNavBean> navList = new ArrayList<>();
        navList.add(new MineNavBean(MineNavigateType.VIP, R.drawable.ic_mine_vip, context.getString(R.string.mine_tv_friend_title)));
        navList.add(new MineNavBean(MineNavigateType.YIELD, R.drawable.ic_mine_yield, context.getString(R.string.mine_tv_yield)));
        navList.add(new MineNavBean(MineNavigateType.DIARY, R.drawable.ic_mine_diary, context.getString(R.string.mine_tv_diary_title)));
        navList.add(new MineNavBean(MineNavigateType.ALBUM, R.drawable.ic_mine_album, context.getString(R.string.mine_tv_album_title)));

        navList.add(new MineNavBean(MineNavigateType.VIDEO, R.drawable.ic_mine_video, context.getString(R.string.mine_tv_video_title)));
        navList.add(new MineNavBean(MineNavigateType.INTRO, R.drawable.ic_mine_intro, context.getString(R.string.mine_tv_card_title)));
        //navList.add(new MineNavBean(MineNavigateType.PERSONAL, R.drawable.ic_mine_personal, "个人中心"));
        navList.add(new MineNavBean(MineNavigateType.SMART_LIFE, R.drawable.ic_mine_smart_life, context.getString(R.string.mine_tv_smart_life_title)));
        navList.add(new MineNavBean(MineNavigateType.NEW_YEAR_VIDEO, R.drawable.my_icon_blessing, context.getString(R.string.mine_tv_new_year_video_title)));
        return navList;
    }

}
