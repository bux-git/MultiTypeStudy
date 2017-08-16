package com.dqr.www.multitypestudy.home;

import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.devlin_n.videoplayer.player.IjkVideoView;
import com.devlin_n.videoplayer.player.VideoViewManager;
import com.dqr.www.multitypestudy.MultiTypeActivity;
import com.dqr.www.multitypestudy.R;
import com.dqr.www.multitypestudy.common.BannerBean;
import com.dqr.www.multitypestudy.common.BannerViewBinder;
import com.dqr.www.multitypestudy.common.BannersBean;
import com.dqr.www.multitypestudy.common.HorizontalBean;
import com.dqr.www.multitypestudy.common.HorizontalViewBinder;
import com.dqr.www.multitypestudy.common.StaticDataSource;
import com.dqr.www.multitypestudy.home.bean.Bottom;
import com.dqr.www.multitypestudy.home.bean.Content;
import com.dqr.www.multitypestudy.home.bean.EAlbum;
import com.dqr.www.multitypestudy.home.bean.ECard;
import com.dqr.www.multitypestudy.home.bean.FrameBean;
import com.dqr.www.multitypestudy.home.bean.LiveBean;
import com.dqr.www.multitypestudy.home.bean.NewBean;
import com.dqr.www.multitypestudy.home.bean.Note;
import com.dqr.www.multitypestudy.home.binder.BottomViewItem;
import com.dqr.www.multitypestudy.home.binder.EAlbumViewBinder;
import com.dqr.www.multitypestudy.home.binder.ECardViewItemBinder;
import com.dqr.www.multitypestudy.home.binder.LiveViewBinder;
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

        mRecyclerView.addOnChildAttachStateChangeListener(new RecyclerView.OnChildAttachStateChangeListener() {
            @Override
            public void onChildViewAttachedToWindow(View view) {
            }

            @Override
            public void onChildViewDetachedFromWindow(View view) {
                IjkVideoView ijkVideoView = (IjkVideoView) view.findViewById(R.id.ijkVideoView);
                if (ijkVideoView != null && !ijkVideoView.isFullScreen()) {
                    ijkVideoView.pause();
                }
            }
        });


        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.addItemDecoration(new HomeItemDecoration(getResources().getDimensionPixelOffset(R.dimen.normal_space), getResources().getColor(R.color.color_f5)));
        mAdapter.register(BannersBean.class, new BannerViewBinder(this, mRecyclerView));
        mAdapter.register(HorizontalBean.class, new HorizontalViewBinder());
        mAdapter.register(Bottom.class, new BottomViewItem());
        mAdapter.register(FrameBean.class)
                .to(new NewViewBinder()
                        , new NoteViewBinder()
                        , new LiveViewBinder()
                        , new ECardViewItemBinder()
                        , new EAlbumViewBinder())
                .withLinker(new Linker<FrameBean>() {
                    @Override
                    public int index(@NonNull FrameBean frameBean) {
                        switch (frameBean.getType()) {
                            case NEWS:
                                return 0;
                            case NOTE:
                                return 1;
                            case LIVE:
                                return 2;
                            case ECARD:
                                return 3;
                            case EALBUM:
                                return 4;
                        }
                        return 0;
                    }
                });
        initData();
    }

    @Override
    protected void onResume() {
        super.onResume();
        IjkVideoView currentVideoPlayer = VideoViewManager.instance().getCurrentVideoPlayer();
        if (currentVideoPlayer != null) {
            currentVideoPlayer.resume();
            currentVideoPlayer.stopFloatWindow();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        IjkVideoView currentVideoPlayer = VideoViewManager.instance().getCurrentVideoPlayer();
        if (currentVideoPlayer != null) {
            currentVideoPlayer.release();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        IjkVideoView currentVideoPlayer = VideoViewManager.instance().getCurrentVideoPlayer();
        if (currentVideoPlayer != null) {
            currentVideoPlayer.release();
        }
    }


    @Override
    public void onBackPressed() {
        if (!VideoViewManager.instance().onBackPressed()) {
            super.onBackPressed();
        }
    }


    private void initData() {
        //Banner
        mItems.add(StaticDataSource.getBannerData());
        //横向排列
        mItems.add(StaticDataSource.getHomeNavigateList(this));

        //新闻
        List<NewBean> newList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
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

        //直播
        List<LiveBean> lives = new ArrayList<>();
        for (int i = 0; i < 1; i++) {
            LiveBean liveBean = new LiveBean(R.drawable.bg_mine_album
                    , "湖南卫视"
                    , StaticDataSource.LIVE_PATH);
            lives.add(liveBean);
        }
        Content liveContent = new Content(lives);
        FrameBean liveFrame = new FrameBean(R.drawable.ic_live
                , R.string.home_live
                , -1
                , R.drawable.ic_right_arrows
                , -1
                , FrameBean.DataType.LIVE
                , liveContent);

        mItems.add(liveFrame);

        //名片
        List<ECard> eCards = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            ECard eCard = new ECard();
            eCard.setCardId("AA000000");
            eCard.setIcName("地球人名片");
            eCard.setNice("地球人" + i);
            eCard.setIcImg(StaticDataSource.IMAGES[i * 2 + 1]);
            eCards.add(eCard);
        }
        Content eCardContent = new Content(eCards);
        FrameBean eCardFrame = new FrameBean(R.drawable.ic_business_card
                , R.string.home_ecard
                , -1
                , R.drawable.ic_right_arrows
                , R.string.more
                , FrameBean.DataType.ECARD
                , eCardContent);

        mItems.add(eCardFrame);

        //相册
        List<EAlbum> albumList = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            EAlbum eAlbum = new EAlbum();
            eAlbum.setName("地球人相册");
            albumList.add(eAlbum);
        }
        Content albumContent = new Content(albumList);
        FrameBean eAlbumFrameBean = new FrameBean(R.drawable.ic_photohome
                , R.string.home_ealbum
                , -1
                , -1
                , R.string.replace
                , FrameBean.DataType.EALBUM
                , albumContent);
        mItems.add(eAlbumFrameBean);


        //底部间隔
        mItems.add(new Bottom());

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
