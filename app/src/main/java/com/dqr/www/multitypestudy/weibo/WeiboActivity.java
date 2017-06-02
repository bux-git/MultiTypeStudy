package com.dqr.www.multitypestudy.weibo;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.dqr.www.multitypestudy.MenuBaseActivity;
import com.dqr.www.multitypestudy.R;
import com.dqr.www.multitypestudy.weibo.content.TextItem;
import com.dqr.www.multitypestudy.weibo.content.TextItemViewBinder;

import java.util.ArrayList;
import java.util.List;

import me.drakeet.multitype.Linker;
import me.drakeet.multitype.MultiTypeAdapter;

import static me.drakeet.multitype.MultiTypeAsserts.assertAllRegistered;

/**
 * Description：
 * Author：LiuYM
 * Date： 2017-06-02 19:56
 */

public class WeiboActivity extends MenuBaseActivity {

    private MultiTypeAdapter mAdapter;
    private List<Object> mItems;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rl_content);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        mItems = new ArrayList<>();
        mAdapter = new MultiTypeAdapter();
        mAdapter.register(WeiBo.class)
                .to(new TextItemViewBinder())
                .withLinker(new Linker<WeiBo>() {
                    @Override
                    public int index(@NonNull WeiBo weiBo) {
                        return 0;
                    }
                });

        User user = new User("Bux", R.drawable.user_avatar);
        for (int i = 0; i < 20; i++) {
            TextItem textItem = new TextItem("Simple text:" + i);
            WeiBo weiBo = new WeiBo(user, textItem);
            mItems.add(weiBo);
        }

        mAdapter.setItems(mItems);
        recyclerView.setAdapter(mAdapter);
        assertAllRegistered(mAdapter, mItems);
    }
}
