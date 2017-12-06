package com.dqr.www.multitypestudy.blibli;

import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.PagerSnapHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SnapHelper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dqr.www.multitypestudy.R;

import me.drakeet.multitype.ItemViewBinder;

/**
 * Description：
 * Author：LiuYM
 * Date： 2017-05-18 14:57
 */

public class PostListViewBinder extends ItemViewBinder<PostList,PostListViewBinder.PostListViewHolder> {

    @NonNull
    @Override
    protected PostListViewHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        View view = inflater.inflate(R.layout.item_post_list, parent, false);
        return new PostListViewHolder(view);
    }

    @Override
    protected void onBindViewHolder(@NonNull PostListViewHolder holder, @NonNull PostList item) {
        holder.setPosts(item);
    }

    class PostListViewHolder extends RecyclerView.ViewHolder{
        RecyclerView mRecyclerView;
        PostListAdapter mPostListAdapter;
        public PostListViewHolder(View itemView) {
            super(itemView);
            mRecyclerView = (RecyclerView) itemView.findViewById(R.id.rl_post_list);
            mRecyclerView.setLayoutManager(new LinearLayoutManager(itemView.getContext(),LinearLayoutManager.HORIZONTAL,false));
            SnapHelper snapHelper = new PagerSnapHelper();
            snapHelper.attachToRecyclerView(mRecyclerView);
            mPostListAdapter = new PostListAdapter();
            mRecyclerView.setAdapter(mPostListAdapter);

        }

        public void setPosts(PostList posts){
            mPostListAdapter.setPostItems(posts.mPostItems);
            mPostListAdapter.notifyDataSetChanged();
        }
    }
}
