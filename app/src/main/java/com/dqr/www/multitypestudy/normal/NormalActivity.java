package com.dqr.www.multitypestudy.normal;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;

import com.dqr.www.multitypestudy.MenuBaseActivity;
import com.dqr.www.multitypestudy.R;
import com.dqr.www.multitypestudy.widget.XRecyclerView;

import java.util.ArrayList;
import java.util.List;

import me.drakeet.multitype.MultiTypeAdapter;

/**
 * Description：
 * Author：LiuYM
 * Date： 2017-05-12 9:57
 */

public class NormalActivity extends MenuBaseActivity {

    private MultiTypeAdapter mAdapter;
    private List<Object> items;

    private int []imgResId={R.drawable.img_00,R.drawable.img_01,R.drawable.img_10,R.drawable.img_11};

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        XRecyclerView recyclerView= (XRecyclerView) findViewById(R.id.rl_content);

        items = new ArrayList<>();
        mAdapter = new MultiTypeAdapter();

        mAdapter.register(TextItem.class, new TextViewBinder());
        mAdapter.register(ImageItem.class, new ImageItemViewBinder());
        mAdapter.register(RichItem.class, new RichItemViewBinder());



        for(int i=0;i<20;i++){
            TextItem textItem = new TextItem("TextItem:"+i);
            items.add(textItem);

            int resId=imgResId[i%imgResId.length];

            ImageItem imageItem = new ImageItem(resId);
            items.add(imageItem);

            RichItem richItem = new RichItem("Image:"+i,resId);
            items.add(richItem);

        }
        mAdapter.setItems(items);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        recyclerView.setAdapter(mAdapter);


    }
}
