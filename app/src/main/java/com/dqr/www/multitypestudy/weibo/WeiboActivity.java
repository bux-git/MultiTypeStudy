package com.dqr.www.multitypestudy.weibo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.dqr.www.multitypestudy.MenuBaseActivity;
import com.dqr.www.multitypestudy.R;
import com.dqr.www.multitypestudy.weibo.content.SimpleText;
import com.dqr.www.multitypestudy.weibo.content.SimpleTextBinder;

import java.util.ArrayList;
import java.util.List;

import me.drakeet.multitype.MultiTypeAdapter;

/**
 * Description：
 * Author：LiuYM
 * Date： 2017-05-18 21:12
 */

public class WeiboActivity extends MenuBaseActivity {

    List<Object> items;
    MultiTypeAdapter mAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rl_content);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        mAdapter = new MultiTypeAdapter();
        mAdapter.register(Weibo.class, new SimpleTextBinder());

        items = new ArrayList<>();

        User user = new User("Bux",R.drawable.img_00);
        for(int i=0;i<20;i++){
            SimpleText simpleText = new SimpleText(1,"Just a simple text msg:"+i);
            Weibo weibo = new Weibo(user,simpleText);
            items.add(weibo);
        }

        mAdapter.setItems(items);
        recyclerView.setAdapter(mAdapter);


    }
}
