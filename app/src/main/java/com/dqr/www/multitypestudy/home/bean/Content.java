package com.dqr.www.multitypestudy.home.bean;

import java.util.List;

/**
 * Description：
 * Author：LiuYM
 * Date： 2017-08-14 16:59
 */

public class Content<T> {
    private List<T> mList;

    public Content(List<T> list) {
        mList = list;
    }

    public List<T> getList() {
        return mList;
    }

    public void setList(List<T> list) {
        mList = list;
    }
}
