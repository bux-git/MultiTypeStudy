package com.dqr.www.multitypestudy.home.binder;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dqr.www.multitypestudy.R;
import com.dqr.www.multitypestudy.home.bean.NewBean;

import java.util.List;

/**
 * Description：
 * Author：LiuYM
 * Date： 2017-08-15 10:50
 */

public class NewViewBinder extends FrameViewBinder<NewBean> {

    @Override
    public View onSubCreateView(LayoutInflater inflater, ViewGroup parent, int dataSize,int index) {
        View view = inflater.inflate(R.layout.home_item_news_layout, parent, false);
        return view;
    }

    @Override
    public void onSubViewBind(View itemView, List<NewBean> subList, int index) {
        NewBean newBean = subList.get(index);
        TextView tvNew= (TextView) itemView;
        tvNew.setText(newBean.getNewDesc());
        Drawable drawable= itemView.getContext().getResources().getDrawable(R.drawable.ic_triangle);
        drawable.setBounds(0,0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
        tvNew.setCompoundDrawables(drawable,null,null,null);
    }
}
