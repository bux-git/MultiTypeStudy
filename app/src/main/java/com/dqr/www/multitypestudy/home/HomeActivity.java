package com.dqr.www.multitypestudy.home;

import android.support.v7.widget.LinearLayoutManager;

import com.dqr.www.multitypestudy.MultiTypeActivity;
import com.dqr.www.multitypestudy.common.BannerBean;
import com.dqr.www.multitypestudy.common.BannerViewBinder;
import com.dqr.www.multitypestudy.common.BannersBean;
import com.dqr.www.multitypestudy.common.HorizontalBean;
import com.dqr.www.multitypestudy.common.HorizontalViewBinder;
import com.dqr.www.multitypestudy.common.StaticDataSource;

/**
 * Description：
 * Author：LiuYM
 * Date： 2017-08-07 16:41
 */

public class HomeActivity extends MultiTypeActivity implements BannerViewBinder.OnHomeClickListener {

    @Override
    public void initView() {
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mAdapter.register(BannersBean.class, new BannerViewBinder(this, mRecyclerView));
        mAdapter.register(HorizontalBean.class, new HorizontalViewBinder());

        initData();
    }

    private void initData() {
        //Banner
        mItems.add(StaticDataSource.getBannerData());
        //横向排列
        mItems.add(StaticDataSource.getHomeNavigateList(this));

        mAdapter.setItems(mItems);
        mAdapter.notifyDataSetChanged();
    }

    /**
     * Banner点击事件
     *
     * @param bannersBean
     */
    @Override
    public void onBannerClick(BannerBean bannersBean) {

    }
}
