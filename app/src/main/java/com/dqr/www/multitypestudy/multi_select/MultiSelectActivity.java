package com.dqr.www.multitypestudy.multi_select;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

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
 * Date： 2017-05-15 10:36
 */

public class MultiSelectActivity extends MenuBaseActivity {
    public static final int SPAN_COUNT=5;

    private MultiTypeAdapter mAdapter;
    private List<Object> items;

    private List<SquareItem> mSelects;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multi_select_layout);
        RecyclerView recyclerView= (RecyclerView) findViewById(R.id.rl_content);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,SPAN_COUNT);
        gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                return items.get(position) instanceof CategoryItem?SPAN_COUNT:1;
            }
        });
        recyclerView.setLayoutManager(gridLayoutManager);

        mSelects = new ArrayList<>();

        mAdapter = new MultiTypeAdapter();
        mAdapter.register(CategoryItem.class,new CategoryItemViewBinder());
        mAdapter.register(SquareItem.class, new SquareItemViewBinder(mSelects));
        recyclerView.setAdapter(mAdapter);

        loadData();


        Button fab = (Button) findViewById(R.id.fab);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String split="";
                StringBuffer stringBuffer = new StringBuffer("Selected:");
                for(int i=0;i<mSelects.size();i++){
                    stringBuffer
                            .append(split)
                            .append(mSelects.get(i).text);
                    split=", ";
                }
                Toast.makeText(MultiSelectActivity.this,stringBuffer.toString(),Toast.LENGTH_LONG).show();
            }
        });


    }

    private void loadData() {
        items = new ArrayList<>();

        CategoryItem categoryItem = new CategoryItem(R.mipmap.ic_launcher,R.drawable.ic_right,"特别篇","更多");
        items.add(categoryItem);
        for(int i=0;i<7;i++){
            SquareItem squareItem = new SquareItem(String.valueOf(i),false);
            items.add(squareItem);
        }

        CategoryItem categoryItem2 = new CategoryItem(R.mipmap.ic_launcher,R.drawable.ic_right,"正常篇","更多");
        items.add(categoryItem2);
        for(int i=0;i<520;i++){
            SquareItem squareItem = new SquareItem(String.valueOf(i),false);
            items.add(squareItem);
        }

        mAdapter.setItems(items);
        mAdapter.notifyDataSetChanged();
    }
}
