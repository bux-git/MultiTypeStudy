package com.dqr.www.multitypestudy.mine;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.dqr.www.multitypestudy.MenuBaseActivity;
import com.dqr.www.multitypestudy.R;
import com.dqr.www.multitypestudy.common.BannerBean;
import com.dqr.www.multitypestudy.common.BannersBean;
import com.dqr.www.multitypestudy.constant.DataConstants;
import com.dqr.www.multitypestudy.mine.bean.FunItemBean;
import com.dqr.www.multitypestudy.mine.bean.FunViewBinder;
import com.dqr.www.multitypestudy.mine.bean.HorizontalBean;
import com.dqr.www.multitypestudy.mine.bean.PersonalBean;
import com.dqr.www.multitypestudy.common.BannerViewBinder;
import com.dqr.www.multitypestudy.mine.binder.HorizontalViewBinder;
import com.dqr.www.multitypestudy.mine.binder.PersonalViewBinder;

import java.util.ArrayList;
import java.util.List;

import me.drakeet.multitype.MultiTypeAdapter;

/**
 * Description：
 * Author：LiuYM
 * Date： 2017-06-02 9:58
 */

public class MineActivity extends MenuBaseActivity implements  BannerViewBinder.OnHomeClickListener{
    private static final int COUNT_SPAN = 2;
    private RecyclerView mRecyclerView;

    private MultiTypeAdapter mAdapter;
    private List<Object> mItems;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView = (RecyclerView) findViewById(R.id.rl_content);

        mAdapter = new MultiTypeAdapter();
        mItems = new ArrayList<>();
        mAdapter.register(BannersBean.class, new BannerViewBinder(this,mRecyclerView));
        mAdapter.register(HorizontalBean.class, new HorizontalViewBinder());
        mAdapter.register(PersonalBean.class, new PersonalViewBinder());
        mAdapter.register(FunItemBean.class, new FunViewBinder());
        initData();
        GridLayoutManager layoutManager = new GridLayoutManager(this, COUNT_SPAN);
        GridLayoutManager.SpanSizeLookup spanSizeLookup = new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                if (mItems.get(position) instanceof FunItemBean) {
                    return ((FunItemBean) mItems.get(position)).countSpan;
                }
                return 2;
            }
        };

        ItemDecoration decoration = new ItemDecoration(getResources().getDimensionPixelSize(R.dimen.mine_normal_space), spanSizeLookup, mItems);
        layoutManager.setSpanSizeLookup(spanSizeLookup);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.addItemDecoration(decoration);
        mRecyclerView.setAdapter(mAdapter);


    }

    private void initData() {
        BannersBean banners = DataConstants.getBannerData();
        mItems.add(banners);

        HorizontalBean horizontalBean = new HorizontalBean(StaticDataSource.getMineNavigateList(this));
        mItems.add(horizontalBean);

        PersonalBean personalBean = new PersonalBean("http://test.dqr2015.cn:8888/uploadFiles/201705/10731/a6692f16504a45b5b49c7c1870071aac.JPG", "AA0000000", "地球人");
        mItems.add(personalBean);

        //激活中心
        FunItemBean funItemBean1 = new FunItemBean("http://test.dqr2015.cn:8888/uploadFiles/201705/10731/a6692f16504a45b5b49c7c1870071aac.JPG"
                , R.drawable.bg_mine_friend
                , R.string.mine_tv_friend_title
                , R.string.mine_tv_friend_detail
                , true
                , MineNavigateType.VIP
                , 1
                , 1);
        //地球人收益
        FunItemBean funItemBean2 = new FunItemBean(""
                , R.drawable.bg_mine_yield
                , R.string.mine_tv_yield
                , R.string.mine_tv_yield_detail
                , true
                , MineNavigateType.YIELD
                , 1
                , 2);

        //成长路程
        FunItemBean funItemBean3 = new FunItemBean(""
                , R.drawable.bg_mine_diary
                , R.string.mine_tv_diary_title
                , R.string.mine_tv_diary_detail
                , false
                , MineNavigateType.DIARY
                , 2
                , 3);

        //时光相册
        FunItemBean funItemBean4 = new FunItemBean(""
                , R.drawable.bg_mine_album
                , R.string.mine_tv_album_title
                , R.string.mine_tv_album_detail
                , true
                , MineNavigateType.ALBUM
                , 1
                , 4);

        //生活视频
        FunItemBean funItemBean5 = new FunItemBean(""
                , R.drawable.bg_mine_video
                , R.string.mine_tv_video_title
                , R.string.mine_tv_video_detail
                , true
                , MineNavigateType.VIDEO
                , 1
                , 5);


        //地球人名片
        FunItemBean funItemBean6 = new FunItemBean(""
                , R.drawable.bg_mine_card
                , R.string.mine_tv_card_title
                , R.string.mine_tv_card_detail
                , true
                , MineNavigateType.INTRO
                , 2
                , 6);

        //智能生活
        FunItemBean funItemBean7 = new FunItemBean(""
                , R.drawable.bg_mine_smart_life
                , R.string.mine_tv_smart_life_title
                , R.string.mine_tv_smart_life_detail
                , true
                , MineNavigateType.SMART_LIFE
                , 1
                , 7);

        //祝福视频
        FunItemBean funItemBean8 = new FunItemBean(""
                , R.drawable.my_blessing_video
                , R.string.mine_tv_new_year_video_title
                , R.string.mine_tv_new_year_video_detail
                , true
                , MineNavigateType.NEW_YEAR_VIDEO
                , 1
                , 8);

        mItems.add(funItemBean1);
        mItems.add(funItemBean2);
        mItems.add(funItemBean3);
        mItems.add(funItemBean4);
        mItems.add(funItemBean5);
        mItems.add(funItemBean6);
        mItems.add(funItemBean7);
        mItems.add(funItemBean8);

        mAdapter.setItems(mItems);
    }

    @Override
    public void onBannerClick(BannerBean bannersBean) {

    }
}
