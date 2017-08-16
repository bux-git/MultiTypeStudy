package com.dqr.www.multitypestudy.home;

import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;

import com.dqr.www.multitypestudy.MultiTypeActivity;
import com.dqr.www.multitypestudy.R;
import com.dqr.www.multitypestudy.common.BannerBean;
import com.dqr.www.multitypestudy.common.BannerViewBinder;
import com.dqr.www.multitypestudy.common.BannersBean;
import com.dqr.www.multitypestudy.common.HorizontalBean;
import com.dqr.www.multitypestudy.common.HorizontalViewBinder;
import com.dqr.www.multitypestudy.common.StaticDataSource;
import com.dqr.www.multitypestudy.home.bean.Content;
import com.dqr.www.multitypestudy.home.bean.FrameBean;
import com.dqr.www.multitypestudy.home.bean.NewBean;
import com.dqr.www.multitypestudy.home.bean.Note;
import com.dqr.www.multitypestudy.home.binder.NewViewBinder;
import com.dqr.www.multitypestudy.home.binder.NoteViewBinder;

import java.util.ArrayList;
import java.util.List;

import me.drakeet.multitype.Linker;

/**
 * Description：
 * Author：LiuYM
 * Date： 2017-08-07 16:41
 */

public class HomeActivity extends MultiTypeActivity implements BannerViewBinder.OnHomeClickListener {

    @Override
    public void initView() {
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.addItemDecoration(new HomeItemDecoration(getResources().getDimensionPixelOffset(R.dimen.normal_space), getResources().getColor(R.color.color_f5)));
        mAdapter.register(BannersBean.class, new BannerViewBinder(this, mRecyclerView));
        mAdapter.register(HorizontalBean.class, new HorizontalViewBinder());
        mAdapter.register(FrameBean.class)
                .to(new NewViewBinder()
                ,new NoteViewBinder())
                .withLinker(new Linker<FrameBean>() {
                    @Override
                    public int index(@NonNull FrameBean frameBean) {
                        switch (frameBean.getType()) {
                            case NEWS:
                                return 0;
                            case NOTE:
                                return 1;
                        }
                        return 0;
                    }
                });
        initData();
    }

    private void initData() {
        //Banner
        mItems.add(StaticDataSource.getBannerData());
        //横向排列
        mItems.add(StaticDataSource.getHomeNavigateList(this));

        //新闻
        List<NewBean> newList = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            NewBean newBean = new NewBean(R.drawable.ic_triangle, "地球人新闻" + i, "");
            newList.add(newBean);
        }
        Content content = new Content(newList);

        FrameBean newFrameBean = new FrameBean(R.drawable.ic_home_news
                , R.string.home_news
                , R.string.more_news
                , R.drawable.ic_right_arrows
                , R.string.news_replace
                , FrameBean.DataType.NEWS
                , content);
        mItems.add(newFrameBean);

        //足迹
        List<Note> notes = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            Note note = new Note("名片" + i
                    , StaticDataSource.IMAGES[i]
                    , 666
                    , 666
                    , 666);
            notes.add(note);
        }
        Content noteContent = new Content(notes);
        FrameBean noteFrame = new FrameBean(R.drawable.ic_growing_process
                , R.string.growing_title
                , R.string.more_news
                , R.drawable.ic_right_arrows
                , R.string.replace
                , FrameBean.DataType.NOTE
                , noteContent);

        mItems.add(noteFrame);

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
