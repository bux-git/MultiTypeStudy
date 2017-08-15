package com.dqr.www.multitypestudy.common;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.dqr.www.multitypestudy.R;
import com.dqr.www.multitypestudy.mine.MineNavigateType;
import com.dqr.www.multitypestudy.mine.bean.MineNavBean;

import java.util.List;

/**
 * Description：
 * Author：LiuYM
 * Date： 2017-06-02 11:46
 */

public class HorizontalItemAdapter extends RecyclerView.Adapter<HorizontalItemAdapter.ItemViewHolder> {
    private List<MineNavBean> mNavBeanList;
    private Context mContext;


    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        mContext = parent.getContext();
        View view = LayoutInflater.from(mContext).inflate(R.layout.mine_navigate_item, parent, false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ItemViewHolder holder, int position) {
        final MineNavBean mineNavBean = mNavBeanList.get(position);
        Glide.with(mContext).load(mineNavBean.getIconId())
                .into(holder.navIcon);
        holder.navName.setText(mineNavBean.getIconName());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (mineNavBean.getType()) {
                    case MineNavigateType.VIP://激活中心
                        break;
                    case MineNavigateType.YIELD://地球人收益

                        break;
                    case MineNavigateType.DIARY://成长路程

                        break;
                    case MineNavigateType.NEW_YEAR_VIDEO:

                        break;
                    case MineNavigateType.ALBUM://时光相册

                        break;
                    case MineNavigateType.VIDEO://生活视频

                        break;
                    case MineNavigateType.INTRO://地球人名片

                        break;
                    case MineNavigateType.SMART_LIFE://智能生活

                        break;
                }
            }
        });


    }

    @Override
    public int getItemCount() {
        return mNavBeanList.size();
    }



    public void setNavBeanList(List<MineNavBean> navBeanList) {
        mNavBeanList = navBeanList;
        notifyDataSetChanged();
    }


    class ItemViewHolder extends RecyclerView.ViewHolder {

        ImageView navIcon;
        TextView navName;

        public ItemViewHolder(View itemView) {
            super(itemView);
            navIcon = (ImageView) itemView.findViewById(R.id.iv_nav_icon);
            navName = (TextView) itemView.findViewById(R.id.tv_nav_name);

        }
    }

}
