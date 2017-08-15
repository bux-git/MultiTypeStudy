package com.dqr.www.multitypestudy;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import me.drakeet.multitype.MultiTypeAdapter;

/**
 * Description：
 * Author：LiuYM
 * Date： 2017-08-14 11:53
 */

public abstract class MultiTypeActivity extends MenuBaseActivity {

    public RecyclerView mRecyclerView;
    public MultiTypeAdapter mAdapter;
    public List<Object> mItems;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorites_layout);

        mRecyclerView = (RecyclerView) findViewById(R.id.rl_container);
        mAdapter = new MultiTypeAdapter();
        mItems = new ArrayList<>();

        mRecyclerView.setAdapter(mAdapter);
        initView();
    }

    public abstract void initView();


}
