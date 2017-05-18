package com.dqr.www.multitypestudy.one2many;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.dqr.www.multitypestudy.MenuBaseActivity;
import com.dqr.www.multitypestudy.R;

import java.util.ArrayList;
import java.util.List;

import me.drakeet.multitype.ClassLinker;
import me.drakeet.multitype.ItemViewBinder;
import me.drakeet.multitype.MultiTypeAdapter;

/**
 * Description：
 * Author：LiuYM
 * Date： 2017-05-18 16:16
 */

public class OneToManyActivity extends MenuBaseActivity {

    public static final int DATA_TYPE_1 = 0;
    public static final int DATA_TYPE_2 = 1;

    MultiTypeAdapter mAdapter;
    List<Object> items;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAdapter = new MultiTypeAdapter();
        mAdapter.register(Data.class).to(
                new One2ManyViewBinder1()
                , new One2ManyViewBinder2())
                .withClassLinker(new ClassLinker<Data>() {
                    @NonNull
                    @Override
                    public Class<? extends ItemViewBinder<Data, ?>> index(@NonNull Data data) {
                        if (data.type == DATA_TYPE_1) {
                            return One2ManyViewBinder1.class;
                        } else if (data.type == DATA_TYPE_2) {
                            return One2ManyViewBinder2.class;
                        }
                        return null;
                    }
                });

        int item=0;
        items = new ArrayList<>();
        for(int i=0;i<200;i++){
            int type=i%2;//取余

            if(type==0){
                item=i/2+1;//取整
            }else{
                item=(i+1)/2;
            }
            Data data = new Data("Item:"+item,type);
            items.add(data);
        }
        mAdapter.setItems(items);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rl_content);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(mAdapter);
    }
}
