package com.dqr.www.multitypestudy.blibli;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.dqr.www.multitypestudy.MenuBaseActivity;
import com.dqr.www.multitypestudy.R;
import com.dqr.www.multitypestudy.common.CategoryItem;
import com.dqr.www.multitypestudy.common.CategoryItemViewBinder;

import java.util.ArrayList;
import java.util.List;

import me.drakeet.multitype.MultiTypeAdapter;

/**
 * Description：
 * Author：LiuYM
 * Date： 2017-05-18 14:09
 */

public class BlibliActivity extends MenuBaseActivity {

    private static final int SPAN_COUNT = 2;

    MultiTypeAdapter mAdapter;
    List<Object> items;

    private static class JsonData {
        private final String text = "Blibli标题文字，Android 复杂的列表视图新写法 MultiType";
        CategoryItem mCategoryItem = new CategoryItem(R.mipmap.ic_launcher_round, R.drawable.ic_right, "Blibli", "更多");
        PostItem[] mPostItems = {new PostItem(R.drawable.img_00, text + "img_00")
                , new PostItem(R.drawable.img_01, text + "img_01")
                , new PostItem(R.drawable.img_10, text + "img_10")
                , new PostItem(R.drawable.img_11, text + "img_11")
        };
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rl_content);

        mAdapter = new MultiTypeAdapter();
        items = new ArrayList<>();
        mAdapter.register(CategoryItem.class, new CategoryItemViewBinder());
        mAdapter.register(PostItem.class, new PostItemViewBinder());

        GridLayoutManager layoutManager = new GridLayoutManager(this, SPAN_COUNT);
        layoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                if(items.get(position) instanceof PostItem){
                    return 1;
                }else{
                    return 2;
                }

            }
        });
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(mAdapter);

        JsonData jsonData = new JsonData();
        for(int i=0;i<20;i++){
            items.add(jsonData.mCategoryItem);
            items.add(jsonData.mPostItems[0]);
            items.add(jsonData.mPostItems[2]);
            items.add(jsonData.mPostItems[3]);
            items.add(jsonData.mPostItems[1]);
            items.add(jsonData.mPostItems[0]);
            items.add(jsonData.mPostItems[2]);
        }
        mAdapter.setItems(items);
        mAdapter.notifyDataSetChanged();
    }
}
