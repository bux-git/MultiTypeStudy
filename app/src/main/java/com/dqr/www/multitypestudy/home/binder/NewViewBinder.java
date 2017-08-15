package com.dqr.www.multitypestudy.home.binder;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dqr.www.multitypestudy.home.bean.NewBean;

import java.util.List;

/**
 * Description：
 * Author：LiuYM
 * Date： 2017-08-15 10:50
 */

public class NewViewBinder extends FrameViewBinder<NewBean> {

    @Override
    public View onSubCreateView(LayoutInflater inflater, ViewGroup parent, int dataSize) {
        return null;
    }

    @Override
    public void onSubViewBind(View itemView, List<NewBean> subList, int index) {

    }
}
