package com.dqr.www.multitypestudy.mine.binder;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dqr.www.multitypestudy.R;
import com.dqr.www.multitypestudy.mine.bean.BannerBean;
import com.dqr.www.multitypestudy.widget.banner.Banner;
import com.dqr.www.multitypestudy.widget.banner.BannerConfig;
import com.dqr.www.multitypestudy.widget.banner.OnBannerClickListener;

import me.drakeet.multitype.ItemViewBinder;

/**
 * Description：
 * Author：LiuYM
 * Date： 2017-06-02 10:13
 */

public class BannerViewBinder extends ItemViewBinder<BannerBean,BannerViewBinder.BannerViewHolder> {

    @NonNull
    @Override
    protected BannerViewHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        View view = inflater.inflate(R.layout.mine_banner_layout, parent, false);
        return new BannerViewHolder(view);
    }

    @Override
    protected void onBindViewHolder(@NonNull BannerViewHolder holder, @NonNull BannerBean item) {
        holder.mBanner.setImages(item.images);
    }

    class BannerViewHolder extends RecyclerView.ViewHolder{

        Banner mBanner;
        public BannerViewHolder(View itemView) {
            super(itemView);
            mBanner = (Banner) itemView.findViewById(R.id.banner_container);
            mBanner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR);
            mBanner.setIndicatorGravity(BannerConfig.RIGHT);

            mBanner.setOnBannerClickListener(new OnBannerClickListener() {
                @Override
                public void OnBannerClick(int position) {

                }
            });
        }
    }
}
