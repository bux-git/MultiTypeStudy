package com.dqr.www.multitypestudy.blibli;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.dqr.www.multitypestudy.R;

import java.util.List;

/**
 * Description：
 * Author：LiuYM
 * Date： 2017-05-18 15:09
 */

public class PostListAdapter extends RecyclerView.Adapter<PostListAdapter.PostListViewHolder> {

    private List<PostItem> mPostItems;

    public void setPostItems(List<PostItem> postItems) {
        mPostItems = postItems;
    }

    @Override
    public PostListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.post_list_item, parent, false);
        return new PostListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(PostListViewHolder holder, int position) {
        PostItem postItem = mPostItems.get(position);
        holder.mImageView.setImageResource(postItem.imgResId);
        holder.mTextView.setText(postItem.text);
    }

    @Override
    public int getItemCount() {
        return mPostItems == null ? 0 : mPostItems.size();
    }

    class PostListViewHolder extends RecyclerView.ViewHolder {
        ImageView mImageView;
        TextView mTextView;

        public PostListViewHolder(View itemView) {
            super(itemView);
            mImageView = (ImageView) itemView.findViewById(R.id.iv_post);
            mTextView = (TextView) itemView.findViewById(R.id.tv_text);
        }
    }
}
