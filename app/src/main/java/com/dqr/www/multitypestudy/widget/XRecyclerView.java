package com.dqr.www.multitypestudy.widget;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import me.drakeet.multitype.MultiTypeAdapter;

/**
 * 与MultiType使用时 先layoutManager setAdapter
 *  由于默认包含头部刷新布局和底部加载更多布局 导致
 *  RecyclerView..getChildLayoutPosition(view)
 *  parent.getAdapter().getItemCount() 等获取RecyclerView全局position时 会多出2个  即第一个和最后一个
 *
 */
public class XRecyclerView extends RecyclerView {
    private static final String TAG = "XRecyclerView";
    private ArrayList<View> mHeaderViews = new ArrayList<>();
    private WrapAdapter mWrapAdapter;
    private float mLastY = -1;
    private static final float DRAG_RATE = 1.8f;
    private LoadingListener mLoadingListener;
    private XListViewHeader mRefreshHeader;
    private boolean pullRefreshEnabled = true;
    private boolean loadingMoreEnabled = true;
    //下面的ItemViewType是保留值(ReservedItemViewType),如果用户的adapter与它们重复将会强制抛出异常。不过为了简化,我们检测到重复时对用户的提示是ItemViewType必须小于10000
    private static final int TYPE_REFRESH_HEADER = 10000;//设置一个很大的数字,尽可能避免和用户的adapter冲突
    private static final int TYPE_FOOTER = 10001;
    private static final int HEADER_INIT_INDEX = 10002;
    private List<Integer> sHeaderTypes = new ArrayList<>();//每个header必须有不同的type,不然滚动的时候顺序会变化

    private XListViewFooter mFootView;
    private final AdapterDataObserver mDataObserver = new DataObserver();

    public XRecyclerView(Context context) {
        this(context, null);
    }

    public XRecyclerView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public XRecyclerView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    private void init() {
        if (pullRefreshEnabled) {
            mRefreshHeader = new XListViewHeader(getContext());
        }

        mFootView = new XListViewFooter(getContext());

        mFootView.setLayoutParams(new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        mFootView.setVisibility(GONE);
    }

    public void addHeaderView(View view) {
        sHeaderTypes.add(HEADER_INIT_INDEX + mHeaderViews.size());
        mHeaderViews.add(view);
    }

    //根据header的ViewType判断是哪个header
    private View getHeaderViewByType(int itemType) {
        if (!isHeaderType(itemType)) {
            return null;
        }
        return mHeaderViews.get(itemType - HEADER_INIT_INDEX);
    }

    //判断一个type是否为HeaderType
    private boolean isHeaderType(int itemViewType) {
        return mHeaderViews.size() > 0 && sHeaderTypes.contains(itemViewType);
    }

    //判断是否是XRecyclerView保留的itemViewType
    private boolean isReservedItemViewType(int itemViewType) {
        if (itemViewType == TYPE_REFRESH_HEADER || itemViewType == TYPE_FOOTER || sHeaderTypes.contains(itemViewType)) {
            return true;
        } else {
            return false;
        }
    }


    public void setPullRefreshEnable(boolean enable) {
        pullRefreshEnabled = enable;
        mRefreshHeader.setPullRefreshEnable(enable);
    }


    public void setPullLoadEnable(boolean enable) {

        mFootView.setPullLoadEnable(enable);

    }


    public void stopRefresh() {
        mRefreshHeader.refreshComplete();
    }

    public void stopLoadMore() {

        mFootView.refreshComplete();

    }

    public void setLoadingMoreEnabled(boolean enabled) {
        loadingMoreEnabled = enabled;

    }

    private void startOnRefresh() {

        if (mLoadingListener != null && mRefreshHeader.getState() != XListViewHeader.STATE_REFRESHING) {
            mRefreshHeader.setState(XListViewHeader.STATE_REFRESHING);
            mLoadingListener.onRefresh();
        }
    }

    private void startLoadMore() {

        if (mLoadingListener != null && mFootView.getState() != XListViewFooter.STATE_LOADING) {
            mFootView.setState(XListViewFooter.STATE_LOADING);
            mFootView.setVisibility(View.VISIBLE);
            mLoadingListener.onLoadMore();
        }
    }

    public void setNoMore(boolean hasmore) {

        if (mFootView != null && hasmore) {
            mFootView.setState(XListViewFooter.STATE__NO_MORE);
            mFootView.setVisibility(View.VISIBLE);
        }

        if (mFootView != null && !hasmore) {
            mFootView.setState(XListViewFooter.STATE_NORMAL);
            mFootView.setVisibility(View.GONE);
        }

    }

    public Adapter getRealAdapter() {
        return adapter;
    }

    private Adapter adapter;

    @Override
    public void setAdapter(Adapter adapter) {

        if(this.adapter!=null){
            this.adapter.unregisterAdapterDataObserver(mDataObserver);
        }

        this.adapter = adapter;
        mWrapAdapter = new WrapAdapter(adapter);
        super.setAdapter(mWrapAdapter);

        adapter.registerAdapterDataObserver(mDataObserver);
        mDataObserver.onChanged();
    }

    @Override
    public void onScrollStateChanged(int state) {
        super.onScrollStateChanged(state);
        if (state == RecyclerView.SCROLL_STATE_IDLE && mLoadingListener != null && mFootView.getState() != XListViewFooter.STATE_LOADING && loadingMoreEnabled) {
            LayoutManager layoutManager = getLayoutManager();
            int lastVisibleItemPosition;
            if (layoutManager instanceof GridLayoutManager) {
                lastVisibleItemPosition = ((GridLayoutManager) layoutManager).findLastVisibleItemPosition();
            } else if (layoutManager instanceof StaggeredGridLayoutManager) {
                int[] into = new int[((StaggeredGridLayoutManager) layoutManager).getSpanCount()];
                ((StaggeredGridLayoutManager) layoutManager).findLastVisibleItemPositions(into);
                lastVisibleItemPosition = findMax(into);
            } else {
                lastVisibleItemPosition = ((LinearLayoutManager) layoutManager).findLastVisibleItemPosition();
            }
            if (layoutManager.getChildCount() > 0
                    && lastVisibleItemPosition >= layoutManager.getItemCount() - 1
                    && layoutManager.getItemCount() > layoutManager.getChildCount()
                    && mFootView.getState() != XListViewFooter.STATE__NO_MORE
                    && mFootView.getState() != XListViewFooter.STATE_LOADING
                    && mRefreshHeader.getState() != mRefreshHeader.STATE_REFRESHING) {

                if (mFootView instanceof XListViewFooter) {
                    startLoadMore();
                }
            }
        }
    }


    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        LayoutManager manager = getLayoutManager();
        int position = -1;
        int top=-1;
        if (mLastY == -1) {
            mLastY = ev.getRawY();
        }
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                mLastY = ev.getRawY();
                break;
            case MotionEvent.ACTION_MOVE:
                final float deltaY = ev.getRawY() - mLastY;
                mLastY = ev.getRawY();
                // int aa[] = ((GridLayoutManager)getLayoutManager()).findFirstVisibleItemPositions(null);

                if (manager instanceof GridLayoutManager) {
                    position = ((GridLayoutManager) manager).findFirstVisibleItemPosition();
                } else if (manager instanceof LinearLayoutManager) {
                    position = ((LinearLayoutManager) manager).findFirstVisibleItemPosition();

                }
                View view = manager.getChildAt(0);
                if(view!=null){
                    top = view.getTop();
                }

                if ((position == 1 && top == 0) || position == 0) {
                    if (mRefreshHeader.getVisibleHeight() > 0) {
                        scrollToPosition(0);
                    }
                    mRefreshHeader.onMove(deltaY / DRAG_RATE);
                }

                break;
            default:
                mLastY = -1;
                if (mRefreshHeader.releaseAction()) {
                    if (mLoadingListener != null) {
                        startOnRefresh();
                    }
                }

                break;
        }
        return super.onTouchEvent(ev);
    }

    private int findMax(int[] lastPositions) {
        int max = lastPositions[0];
        for (int value : lastPositions) {
            if (value > max) {
                max = value;
            }
        }
        return max;
    }


    private class DataObserver extends AdapterDataObserver {
        @Override
        public void onChanged() {
            Adapter<?> adapter = getAdapter();
            if (adapter != null) {
                int emptyCount = 0;
                if (pullRefreshEnabled) {
                    emptyCount++;
                }
                if (loadingMoreEnabled) {
                    emptyCount++;
                }
                if (adapter.getItemCount() == emptyCount) {
                    XRecyclerView.this.setVisibility(View.GONE);
                } else {
                    XRecyclerView.this.setVisibility(View.VISIBLE);
                }
            }
            if (mWrapAdapter != null) {
                mWrapAdapter.notifyDataSetChanged();
            }
        }

        @Override
        public void onItemRangeInserted(int positionStart, int itemCount) {
            mWrapAdapter.notifyItemRangeInserted(positionStart, itemCount);
        }

        @Override
        public void onItemRangeChanged(int positionStart, int itemCount) {
            mWrapAdapter.notifyItemRangeChanged(positionStart, itemCount);
        }

        @Override
        public void onItemRangeRemoved(int positionStart, int itemCount) {
            mWrapAdapter.notifyItemRangeRemoved(positionStart, itemCount);
        }

        @Override
        public void onItemRangeMoved(int fromPosition, int toPosition, int itemCount) {
            mWrapAdapter.notifyItemMoved(fromPosition, toPosition);
        }
    }

    ;

    public class WrapAdapter extends Adapter<ViewHolder> {

        private Adapter adapter;

        public WrapAdapter(Adapter adapter) {
            this.adapter = adapter;
        }

        public boolean isHeader(int position) {
            return position >= 1 && position < mHeaderViews.size() + 1;
        }

        public boolean isFooter(int position) {
            if (loadingMoreEnabled) {

                return position == getItemCount() - 1;
            } else {

                return false;
            }
        }

        public boolean isRefreshHeader(int position) {
            return position == 0;
        }

        public int getHeadersCount() {
            return mHeaderViews.size();
        }

        private class SimpleViewHolder extends ViewHolder {
            public SimpleViewHolder(View itemView) {
                super(itemView);
            }
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            if (viewType == TYPE_REFRESH_HEADER) {
                return new SimpleViewHolder(mRefreshHeader);
            } else if (isHeaderType(viewType)) {
                return new SimpleViewHolder(getHeaderViewByType(viewType));
            } else if (viewType == TYPE_FOOTER) {
                return new SimpleViewHolder(mFootView);
            }
            return adapter.onCreateViewHolder(parent, viewType);
        }

        @Override
        public void onBindViewHolder(final ViewHolder holder, int position) {
            if (isHeader(position) || isRefreshHeader(position)) {
                return;
            }
            int adjPosition = position - (getHeadersCount() + 1);
            int adapterCount;
            if (adapter != null) {
                adapterCount = adapter.getItemCount();
                if (adjPosition < adapterCount) {
                    if(adapter instanceof MultiTypeAdapter){
                        adapter.onBindViewHolder(holder, adjPosition,null);
                    }else{
                        adapter.onBindViewHolder(holder, adjPosition);
                    }

                    return;
                }
            }
        }

        @Override
        public int getItemCount() {
            if (loadingMoreEnabled) {
                if (adapter != null) {
                    return getHeadersCount() + adapter.getItemCount() + 2;
                } else {
                    return getHeadersCount() + 2;
                }
            } else {
                if (adapter != null) {
                    return getHeadersCount() + adapter.getItemCount() + 1;
                } else {
                    return getHeadersCount() + 1;
                }
            }
        }

        @Override
        public int getItemViewType(int position) {
            int adjPosition = position - (getHeadersCount() + 1);

            if (isRefreshHeader(position)) {
                return TYPE_REFRESH_HEADER;
            }

            if (isHeader(position)) {
                position = position - 1;
                return sHeaderTypes.get(position);
            }

            if (isFooter(position)) {
                return TYPE_FOOTER;
            }

            int adapterCount;
            if (adapter != null) {
                adapterCount = adapter.getItemCount();
                if (adjPosition < adapterCount) {
                    return adapter.getItemViewType(adjPosition);
                }
            }
            return 0;
        }

        @Override
        public long getItemId(int position) {
            if (adapter != null && position >= getHeadersCount() + 1) {
                int adjPosition = position - (getHeadersCount() + 1);
                if (adjPosition < adapter.getItemCount()) {
                    return adapter.getItemId(adjPosition);
                }
            }
            return -1;
        }

        @Override
        public void onAttachedToRecyclerView(final RecyclerView recyclerView) {
            Log.d(TAG, "onAttachedToRecyclerView: ");
            super.onAttachedToRecyclerView(recyclerView);
            LayoutManager manager = recyclerView.getLayoutManager();
            if (manager instanceof GridLayoutManager) {

                final GridLayoutManager gridManager = ((GridLayoutManager) manager);
                final GridLayoutManager.SpanSizeLookup oldSpanSizeLookup= gridManager.getSpanSizeLookup();

                gridManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
                    @Override
                    public int getSpanSize(int position) {

                        if (isHeader(position) || isFooter(position) || isRefreshHeader(position)) {
                            return gridManager.getSpanCount();
                        } else {
                            if (oldSpanSizeLookup != null) {
                                int adjPosition = -1;
                                if (adapter != null && position >= getHeadersCount() + 1) {
                                    adjPosition = position - (getHeadersCount() + 1);
                                    if (adjPosition >= adapter.getItemCount()) {
                                        return -1;
                                    }
                                }
                                return oldSpanSizeLookup.getSpanSize(adjPosition);
                            } else {
                                return 1;
                            }
                        }
                    }
                });
            }
            adapter.onAttachedToRecyclerView(recyclerView);
        }


        @Override
        public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
            adapter.onDetachedFromRecyclerView(recyclerView);
        }

        @Override
        public void onViewAttachedToWindow(ViewHolder holder) {
            super.onViewAttachedToWindow(holder);
            ViewGroup.LayoutParams lp = holder.itemView.getLayoutParams();
            if (lp != null
                    && lp instanceof StaggeredGridLayoutManager.LayoutParams
                    && (isHeader(holder.getLayoutPosition()) || isRefreshHeader(holder.getLayoutPosition()) || isFooter(holder.getLayoutPosition()))) {
                StaggeredGridLayoutManager.LayoutParams p = (StaggeredGridLayoutManager.LayoutParams) lp;
                p.setFullSpan(true);
            }
            if(!isHeader(holder.getLayoutPosition()) && !isRefreshHeader(holder.getLayoutPosition()) && !isFooter(holder.getLayoutPosition())) {
                adapter.onViewAttachedToWindow(holder);
            }
        }

        @Override
        public void onViewDetachedFromWindow(ViewHolder holder) {
            if(!isHeader(holder.getLayoutPosition()) && !isRefreshHeader(holder.getLayoutPosition()) && !isFooter(holder.getLayoutPosition())) {
                adapter.onViewDetachedFromWindow(holder);
            }
        }

        @Override
        public void onViewRecycled(ViewHolder holder) {

            if(!isHeader(holder.getLayoutPosition()) && !isRefreshHeader(holder.getLayoutPosition()) && !isFooter(holder.getLayoutPosition())) {
                adapter.onViewRecycled(holder);
            }
        }

        @Override
        public boolean onFailedToRecycleView(ViewHolder holder) {
            if(!isHeader(holder.getLayoutPosition()) && !isRefreshHeader(holder.getLayoutPosition()) && !isFooter(holder.getLayoutPosition())) {
                return adapter.onFailedToRecycleView(holder);
            }
            return super.onFailedToRecycleView(holder);
        }

        @Override
        public void unregisterAdapterDataObserver(AdapterDataObserver observer) {
            adapter.unregisterAdapterDataObserver(observer);
        }

        @Override
        public void registerAdapterDataObserver(AdapterDataObserver observer) {
            adapter.registerAdapterDataObserver(observer);
        }

    }

    public void setLoadingListener(LoadingListener listener) {
        mLoadingListener = listener;
    }

    public interface LoadingListener {

        void onRefresh();

        void onLoadMore();
    }

    private SpanSizeLookup spanSizeLookup;

    public void setSpanSizeLookup(SpanSizeLookup spanSizeLookup) {
        this.spanSizeLookup = spanSizeLookup;
    }

    public interface SpanSizeLookup {
        int getSpanSize(int position);
    }

    public void setRefreshing() {
        if (pullRefreshEnabled && mLoadingListener != null) {
            scrollToPosition(0);
            final ValueAnimator valueAnimator = ValueAnimator.ofInt(0, mRefreshHeader.mMeasuredHeight);
            valueAnimator.setDuration(600);
            valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {

                @Override
                public void onAnimationUpdate(ValueAnimator animation) {
                    int value = (int) animation.getAnimatedValue();
                    mRefreshHeader.setHeight(value);

                }

            });

            valueAnimator.addListener(new Animator.AnimatorListener() {


                @Override
                public void onAnimationStart(Animator animator) {

                }

                @Override
                public void onAnimationEnd(Animator animator) {
                    startOnRefresh();
                }

                @Override
                public void onAnimationCancel(Animator animator) {

                }

                @Override
                public void onAnimationRepeat(Animator animator) {

                }

            });
            valueAnimator.start();
        }
    }

}