package com.dqr.www.multitypestudy.constant;

import com.dqr.www.multitypestudy.common.BannerBean;
import com.dqr.www.multitypestudy.common.BannersBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Description：
 * Author：LiuYM
 * Date： 2017-08-14 11:21
 */

public class DataConstants {

    public static BannersBean getBannerData(){
        BannersBean beans = new BannersBean();
        List<BannerBean> beanList = new ArrayList<>();
        BannerBean bean1 = new BannerBean("www.baidu.com","标题","https://ws1.sinaimg.cn/large/610dc034ly1fiednrydq8j20u011itfz.jpg");
        beanList.add(bean1);
        BannerBean bean2 = new BannerBean("www.baidu.com","标题","https://ws1.sinaimg.cn/large/610dc034ly1fid5poqfznj20u011imzm.jpg");
        beanList.add(bean2);
        BannerBean bean3 = new BannerBean("www.baidu.com","标题","https://ws1.sinaimg.cn/large/610dc034ly1fibksd2mbmj20u011iacx.jpg");
        beanList.add(bean3);
        BannerBean bean4 = new BannerBean("www.baidu.com","标题","https://ws1.sinaimg.cn/large/610dc034gy1fi678xgq1ij20pa0vlgo4.jpg");
        beanList.add(bean4);
        BannerBean bean5 = new BannerBean("www.baidu.com","标题","https://ws1.sinaimg.cn/large/610dc034gy1fi502l3eqjj20u00hz41j.jpg");
        beanList.add(bean5);

        beans.setBeanList(beanList);
        return beans;
    }
}
