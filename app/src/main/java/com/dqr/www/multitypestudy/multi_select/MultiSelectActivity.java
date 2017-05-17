package com.dqr.www.multitypestudy.multi_select;

import android.animation.ValueAnimator;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver;
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
    private static final String TAG = "MultiSelectActivity";
    public static final int SPAN_COUNT = 5;

    private MultiTypeAdapter mAdapter;
    private List<Object> items;

    private List<SquareItem> mSelects;
    int top, bottom, driveHeight, distanceY,height;
    ValueAnimator animatorMode;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multi_select_layout);
        driveHeight = getResources().getDisplayMetrics().heightPixels;

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rl_content);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, SPAN_COUNT);
        gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                return items.get(position) instanceof CategoryItem ? SPAN_COUNT : 1;
            }
        });
        recyclerView.setLayoutManager(gridLayoutManager);

        mSelects = new ArrayList<>();

        mAdapter = new MultiTypeAdapter();
        mAdapter.register(CategoryItem.class, new CategoryItemViewBinder());
        mAdapter.register(SquareItem.class, new SquareItemViewBinder(mSelects));
        recyclerView.setAdapter(mAdapter);

        loadData();


        final Button fab = (Button) findViewById(R.id.fab);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String split = "";
                StringBuffer stringBuffer = new StringBuffer("Selected:");
                for (int i = 0; i < mSelects.size(); i++) {
                    stringBuffer
                            .append(split)
                            .append(mSelects.get(i).text);
                    split = ", ";
                }
                Toast.makeText(MultiSelectActivity.this, stringBuffer.toString(), Toast.LENGTH_LONG).show();
            }
        });


        fab.getViewTreeObserver().addOnGlobalLayoutListener(
                new ViewTreeObserver.OnGlobalLayoutListener() {
                    @Override
                    public void onGlobalLayout() {
                        top = fab.getTop();
                        bottom = fab.getBottom();
                        height=fab.getHeight();
                        distanceY = driveHeight - top;
                        Log.d(TAG, "onGlobalLayout: top" + top + " bottom:" + bottom+"  height:"+fab.getHeight());
                        fab.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                    }
                });

        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                if (dy > 0) {//上滑
                    modeOutInAnimator(fab, true);
                } else {//下滑
                    modeOutInAnimator(fab, false);
                }
            }
        });


    }


    private boolean isStatus;
    /**
     * 模版动画效果
     *
     * @param view
     * @param isDown 是否向下移动
     */
    private void modeOutInAnimator(final View view,boolean isDown) {
        if (animatorMode == null) {
            if (distanceY <= 0) return;
            animatorMode = ValueAnimator.ofInt(0, distanceY);
            animatorMode.setDuration(500);
        }

        if (!animatorMode.isRunning() && !animatorMode.isStarted()) {
            Log.d(TAG, "modeOutInAnimator: " + top + "  bottom:" + bottom+"  distanceY:"+distanceY);

            if(isStatus&&isDown)return;//已经处于屏幕下方
            if(!isStatus&&!isDown)return;//已经处于屏幕上方


            animatorMode.removeAllUpdateListeners();
            if (isDown) {
                isStatus=true;
                Log.d(TAG, "modeOutInAnimator: isDown:"+isDown);
                animatorMode.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    @Override
                    public void onAnimationUpdate(ValueAnimator animation) {
                        int curValue = (int) animation.getAnimatedValue();
                        float changeValue=1-(curValue/(float)distanceY);

                       view.layout(view.getLeft(), top + curValue, view.getRight(), curValue + bottom);
                        view.setAlpha(changeValue);
                        view.setScaleX(changeValue);
                        view.setScaleY(changeValue);
                        //Log.d(TAG, "onAnimationUpdate: "+changeValue);
                    }
                });
            } else {
                isStatus=false;
                Log.d(TAG, "modeOutInAnimator: isDown:"+isDown);
                animatorMode.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    @Override
                    public void onAnimationUpdate(ValueAnimator animation) {
                        int curValue = (int) animation.getAnimatedValue();
                        float changeValue=(curValue/(float)distanceY);

                        view.layout(view.getLeft(), driveHeight - curValue, view.getRight(),bottom+distanceY-curValue);
                        view.setAlpha(changeValue);
                        view.setScaleX(changeValue);
                        view.setScaleY(changeValue);

                    }
                });

            }

            animatorMode.start();
        }
    }

    private void loadData() {
        items = new ArrayList<>();

        CategoryItem categoryItem = new CategoryItem(R.mipmap.ic_launcher, R.drawable.ic_right, "特别篇", "更多");
        items.add(categoryItem);
        for (int i = 0; i < 7; i++) {
            SquareItem squareItem = new SquareItem(String.valueOf(i), false);
            items.add(squareItem);
        }

        CategoryItem categoryItem2 = new CategoryItem(R.mipmap.ic_launcher, R.drawable.ic_right, "正常篇", "更多");
        items.add(categoryItem2);
        for (int i = 0; i < 520; i++) {
            SquareItem squareItem = new SquareItem(String.valueOf(i), false);
            items.add(squareItem);
        }

        mAdapter.setItems(items);
        mAdapter.notifyDataSetChanged();
    }
}
