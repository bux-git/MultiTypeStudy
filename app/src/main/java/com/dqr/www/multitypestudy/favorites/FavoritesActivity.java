package com.dqr.www.multitypestudy.favorites;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.dqr.www.multitypestudy.MenuBaseActivity;
import com.dqr.www.multitypestudy.R;
import com.dqr.www.multitypestudy.favorites.bean.FavoritesBean;
import com.dqr.www.multitypestudy.favorites.bean.TextIBean;
import com.dqr.www.multitypestudy.favorites.viewbinder.TextItemBinder;

import java.util.ArrayList;
import java.util.List;

import me.drakeet.multitype.Linker;
import me.drakeet.multitype.MultiTypeAdapter;

/**
 * Description：
 * Author：LiuYM
 * Date： 2017-08-07 9:44
 */

public class FavoritesActivity extends MenuBaseActivity {

    RecyclerView mRlRecyclerView;
    private MultiTypeAdapter mAdapter;
    private List<Object> mItemsList;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorites_layout);
        mRlRecyclerView = (RecyclerView) findViewById(R.id.rl_container);
        mAdapter = new MultiTypeAdapter();
        mAdapter.register(FavoritesBean.class)
        .to(new TextItemBinder())
        .withLinker(new Linker<FavoritesBean>() {
            @Override
            public int index(@NonNull FavoritesBean favoritesBean) {
                if(favoritesBean.getContent() instanceof TextIBean) {
                    return 0;
                }
                return 0;
            }
        });

        mRlRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRlRecyclerView.setAdapter(mAdapter);
        mRlRecyclerView.addItemDecoration(new ItemDecoration(this,5,Color.parseColor("#f3f3f3")));

        mItemsList = new ArrayList<>();

        for(int i=0;i<10;i++){
            FavoritesBean bean = new FavoritesBean(R.drawable.img_00,"不修","2017-02-06","足迹",new TextIBean("CO是Windows的图标文件格式，图标文件可以存储单个图案图标文件可以存储单个图案图标文件可以存储单个图案图标文件可以存储单个图案图标文件可以存储单个图案、多尺寸、多色板的图标文件。一个图标实际上是多张不同格式的图片的集合体，并且还包含了一定的透明区域"));
            mItemsList.add(bean);
        }
        mAdapter.setItems(mItemsList);
        mAdapter.notifyDataSetChanged();

    }
}
