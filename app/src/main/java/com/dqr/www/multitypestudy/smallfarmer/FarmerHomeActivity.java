package com.dqr.www.multitypestudy.smallfarmer;

import android.graphics.Rect;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;

import com.dqr.www.multitypestudy.R;
import com.dqr.www.multitypestudy.common.BannerBean;
import com.dqr.www.multitypestudy.common.BannerViewBinder;
import com.dqr.www.multitypestudy.common.BannersBean;
import com.dqr.www.multitypestudy.common.StaticDataSource;
import com.dqr.www.multitypestudy.smallfarmer.bean.BottomTagBean;
import com.dqr.www.multitypestudy.smallfarmer.bean.ItemTitleBean;
import com.dqr.www.multitypestudy.smallfarmer.bean.OneToFourBean;
import com.dqr.www.multitypestudy.smallfarmer.bean.SingleItem2Bean;
import com.dqr.www.multitypestudy.smallfarmer.bean.SingleItem3Bean;
import com.dqr.www.multitypestudy.smallfarmer.bean.SingleItemBean;
import com.dqr.www.multitypestudy.smallfarmer.binder.BottomTagItemBinder;
import com.dqr.www.multitypestudy.smallfarmer.binder.ItemTitleItemBinder;
import com.dqr.www.multitypestudy.smallfarmer.binder.OneToFourItemBinder;
import com.dqr.www.multitypestudy.smallfarmer.binder.SingleItem2Binder;
import com.dqr.www.multitypestudy.smallfarmer.binder.SingleItem3Binder;
import com.dqr.www.multitypestudy.smallfarmer.binder.SingleItemBinder;
import com.dqr.www.multitypestudy.util.MathUtils;

import java.util.ArrayList;
import java.util.List;

import me.drakeet.multitype.MultiTypeAdapter;

/**
 * Description：
 * Author：Bux on 2017/10/12 13:02
 * Email: 471025316@qq.com
 */

public class FarmerHomeActivity extends AppCompatActivity implements BannerViewBinder.OnHomeClickListener {

    private static final int COUNT_SPAN = 4;

    private LinearLayout mLltTitle;

    private RecyclerView mRecyclerView;
    private MultiTypeAdapter mAdapter;
    private List<Object> mItems;
    GridLayoutManager layoutManager;

    // ----------title透明渐变----------------------------------------------------
    private int mTotalDy;//滑动距离
    private double mScale;//高度和透明度的比例
    private int mBannerHeight;//轮播图的高度

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_farmerhome_layout);

        mLltTitle = (LinearLayout) findViewById(R.id.lltTitle);

        mRecyclerView = (RecyclerView) findViewById(R.id.rl_content);
        mAdapter = new MultiTypeAdapter();
        mItems = new ArrayList<>();

        mRecyclerView.setAdapter(mAdapter);
        initView();
        initData();
    }


    private void initView() {

        mBannerHeight = (int) (getResources().getDimension(R.dimen.banners_height) / 2);
        mScale = MathUtils.div(255, mBannerHeight);

        //Toolbar 透明度跟随scroll变化
        mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                setToolBarAlpha(dy);
            }
        });

        //设置显示列
        layoutManager = new GridLayoutManager(this, COUNT_SPAN);
        GridLayoutManager.SpanSizeLookup spanSizeLookup = new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                if (mItems.get(position) instanceof SingleItemBean) {
                    return 2;
                } else if (mItems.get(position) instanceof BottomTagBean) {
                    return 1;
                }
                return 4;
            }
        };

        layoutManager.setSpanSizeLookup(spanSizeLookup);
        mRecyclerView.setLayoutManager(layoutManager);
        mAdapter.register(BannersBean.class, new BannerViewBinder(this, mRecyclerView));//轮播图
        mAdapter.register(SingleItemBean.class, new SingleItemBinder());//单个选项
        mAdapter.register(OneToFourBean.class, new OneToFourItemBinder());//一拖四布局
        mAdapter.register(ItemTitleBean.class, new ItemTitleItemBinder());//子标题项
        mAdapter.register(SingleItem2Bean.class, new SingleItem2Binder());//类型2
        mAdapter.register(SingleItem3Bean.class, new SingleItem3Binder());//类型3
        mAdapter.register(BottomTagBean.class, new BottomTagItemBinder());//底部Tag

    }


    private void initData() {
        //Banner
        mItems.add(StaticDataSource.getBannerData());

        //单个选项
        for (int i = 0; i < 4; i++) {
            mItems.add(new SingleItemBean());
        }

        //一拖四
        mItems.add(new OneToFourBean());

        //子标题项 专场推荐
        ItemTitleBean title1 = new ItemTitleBean();
        title1.setTitle("专场推荐");
        mItems.add(title1);

        for (int i = 0; i < 3; i++) {
            mItems.add(new SingleItem2Bean());
        }


        //子标题项 每日必看
        ItemTitleBean title2 = new ItemTitleBean();
        title2.setTitle("每日必看");
        mItems.add(title2);

        for (int i = 0; i < 10; i++) {
            mItems.add(new SingleItem3Bean());
        }

        //底部TAG
        for (int i = 0; i < 8; i++) {
            mItems.add(new BottomTagBean("商品推荐" + i));
        }

        mAdapter.setItems(mItems);
        mAdapter.notifyDataSetChanged();
    }


    @Override
    public void onBannerClick(BannerBean bannersBean) {

    }

    /**
     * 设置ToolBarAlpha
     */
    private void setToolBarAlpha(int dy) {
        int alpha;

        int position = layoutManager.findFirstVisibleItemPosition();
        if (position == 0) {//第一项
            View view = layoutManager.findViewByPosition(position);
            Rect rect = new Rect();
            view.getLocalVisibleRect(rect);//相对于View左上角为原点的显示区域左上角坐标
            if (rect.top <= mBannerHeight + 200) {
                mTotalDy += dy;
            }
        } else {
            mTotalDy = mBannerHeight;
        }
        if (mTotalDy < mBannerHeight) {
            if (mTotalDy < 0) {
                mTotalDy = 0;
            }
            alpha = (int) MathUtils.mul(mScale, Math.abs(mTotalDy));
        } else {
            alpha = 255;
        }
        mLltTitle.getBackground().mutate().setAlpha(alpha);
    }

}
