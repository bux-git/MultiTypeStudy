package com.dqr.www.multitypestudy.common;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dqr.www.multitypestudy.R;
import com.dqr.www.multitypestudy.widget.banner.Banner;
import com.dqr.www.multitypestudy.widget.banner.BannerConfig;
import com.dqr.www.multitypestudy.widget.banner.OnBannerClickListener;

import me.drakeet.multitype.ItemViewBinder;

/**
 * Description：
 * Author：LiuYM
 * Date： 2017-06-02 10:13
 */

public class BannerViewBinder extends ItemViewBinder<BannersBean,BannerViewBinder.BannerViewHolder> {


    private static final String TAG = "BannerViewBinder";

    private OnHomeClickListener mListener;
    private BannersBean item;
    private BannerViewHolder mHolder;


    public BannerViewBinder(OnHomeClickListener listener, RecyclerView recyclerView) {
        mListener = listener;
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                if(newState!=RecyclerView.SCROLL_STATE_IDLE){
                    mHolder.mBanner.isAutoPlay(false);
                    // Log.d(TAG, "onScrollStateChanged: false");
                }else{
                    mHolder.mBanner.isAutoPlay(true);
                    //Log.d(TAG, "onScrollStateChanged: true");
                }
            }
        });
    }

    @NonNull
    @Override
    protected BannerViewHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        View view = inflater.inflate(R.layout.mine_banner_layout, parent, false);
        return new BannerViewHolder(view);
    }

    @Override
    protected void onBindViewHolder(@NonNull BannerViewHolder holder, @NonNull BannersBean item) {
        mHolder=holder;
        this.item = item;
        int size = item.getBeanList().size();
        if (item.getBeanList() != null && size > 0) {
            String[] images = new String[size];
            String[] titles = new String[size];

            for (int i = 0; i < size; i++) {
                BannerBean bean = item.getBeanList().get(i);
                images[i] = bean.getImgUrl();
                titles[i] = bean.getTitle();

            }
            //记得设置标题列表哦
            holder.mBanner.setBannerTitle(titles);
            holder.mBanner.setImages(images);//可以选择设置图片网址，或者资源文件，默认用Glide加载
        }
    }



    class BannerViewHolder extends RecyclerView.ViewHolder {
        Banner mBanner;

        public BannerViewHolder(final View itemView) {
            super(itemView);
            mBanner = (Banner) itemView.findViewById(R.id.banner_container);
            //显示标题内圆形指示器和标题
            mBanner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE_INSIDE);

            mBanner.setOnBannerClickListener(new OnBannerClickListener() {//设置点击事件
                @Override
                public void OnBannerClick(int position) {
                    if (item.getBeanList() != null && item.getBeanList().size() > 0) {
                        mListener.onBannerClick(item.getBeanList().get(position-1));
                    }
                }
            });

        }


    }

    public interface OnHomeClickListener {
        /**
         * banner点击事件
         * @param bannersBean
         */
        void onBannerClick(BannerBean bannersBean);
    }
}
