package com.dqr.www.multitypestudy.common;

import android.content.Context;
import android.content.res.TypedArray;

import com.dqr.www.multitypestudy.R;
import com.dqr.www.multitypestudy.mine.MineNavigateType;
import com.dqr.www.multitypestudy.mine.bean.MineNavBean;

import java.util.ArrayList;
import java.util.List;


public class StaticDataSource {


    public static final String[] IMAGES = {"https://ws1.sinaimg.cn/large/610dc034ly1fhb0t7ob2mj20u011itd9.jpg"
            , "https://ws1.sinaimg.cn/large/610dc034ly1fhfmsbxvllj20u00u0q80.jpg"
            , "http://7xi8d6.com1.z0.glb.clouddn.com/2017-05-05-18251898_1013302395468665_8734429858911748096_n.jpg"
            , "https://ws1.sinaimg.cn/large/610dc034ly1fgepc1lpvfj20u011i0wv.jpg"
            , "https://ws1.sinaimg.cn/large/610dc034ly1fgi3vd6irmj20u011i439.jpg"
            , "http://7xi8d6.com1.z0.glb.clouddn.com/2017-04-19-17881407_1845958195665029_1132383288824954880_n.jpg"};


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


    public static BannersBean getBannerData() {
        BannersBean beans = new BannersBean();
        List<BannerBean> beanList = new ArrayList<>();
        BannerBean bean1 = new BannerBean("www.baidu.com", "标题", "https://ws1.sinaimg.cn/large/610dc034ly1fiednrydq8j20u011itfz.jpg");
        beanList.add(bean1);
        BannerBean bean2 = new BannerBean("www.baidu.com", "标题", "https://ws1.sinaimg.cn/large/610dc034ly1fid5poqfznj20u011imzm.jpg");
        beanList.add(bean2);
        BannerBean bean3 = new BannerBean("www.baidu.com", "标题", "https://ws1.sinaimg.cn/large/610dc034ly1fibksd2mbmj20u011iacx.jpg");
        beanList.add(bean3);
        BannerBean bean4 = new BannerBean("www.baidu.com", "标题", "https://ws1.sinaimg.cn/large/610dc034gy1fi678xgq1ij20pa0vlgo4.jpg");
        beanList.add(bean4);
        BannerBean bean5 = new BannerBean("www.baidu.com", "标题", "https://ws1.sinaimg.cn/large/610dc034gy1fi502l3eqjj20u00hz41j.jpg");
        beanList.add(bean5);

        beans.setBeanList(beanList);
        return beans;
    }


    /**
     * 首页导航按钮列表
     *
     * @param context
     * @return
     */
    public static HorizontalBean getHomeNavigateList(Context context) {
        //----------------------------------获取数据源
        String[] nameArray = context.getResources().getStringArray(R.array.navigate_names);//文字集合
        TypedArray resArray = context.getResources().obtainTypedArray(R.array.navigate_imgs);

        int len = resArray.length();
        int[] imgResArray = new int[len];  //图片集合
        for (int i = 0; i < len; i++) {
            imgResArray[i] = resArray.getResourceId(i, 0);
        }
        resArray.recycle();
        //------------------------------------
        int i = 0;
        List<MineNavBean> mNaviList = new ArrayList<>();
        mNaviList.add(new MineNavBean(MineNavigateType.HOME_OFFICIAL, imgResArray[i], nameArray[i++]));
        mNaviList.add(new MineNavBean(MineNavigateType.HOME_NEWS, imgResArray[i], nameArray[i++]));
        mNaviList.add(new MineNavBean(MineNavigateType.HOME_VIDEO, imgResArray[i], nameArray[i++]));
        mNaviList.add(new MineNavBean(MineNavigateType.HOME_CHANNEL, imgResArray[i], nameArray[i++]));
        mNaviList.add(new MineNavBean(MineNavigateType.HOME_LITERATURE, imgResArray[i], nameArray[i++]));
//        mNaviList.add(new HomeNavBean(NavigateType.MARRIAGE, nameArray[i], imgResArray[i++]));
        mNaviList.add(new MineNavBean(MineNavigateType.HOME_RANKING, imgResArray[i], nameArray[i++]));
        mNaviList.add(new MineNavBean(MineNavigateType.HOME_MORE, imgResArray[i], nameArray[i++]));

        HorizontalBean horizontalBean = new HorizontalBean(mNaviList);
        return horizontalBean;
    }
}
