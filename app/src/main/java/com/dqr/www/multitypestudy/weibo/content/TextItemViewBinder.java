package com.dqr.www.multitypestudy.weibo.content;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dqr.www.multitypestudy.R;
import com.dqr.www.multitypestudy.weibo.WeiboTestBinder;

public class TextItemViewBinder extends WeiboTestBinder<TextItem,TextItemViewBinder.TextItemViewHolder> {
    private static final String TAG = "TextItemViewBinder";

    @Override
    protected TextItemViewHolder onCreateSubViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        View view = inflater.inflate(R.layout.item_text, parent, false);
        return new TextItemViewHolder(view);
    }

    @Override
    protected void onBindSubViewHolder(TextItemViewHolder viewHolder, TextItem content) {
        viewHolder.text.setText(content.text);
    }



    class TextItemViewHolder extends RecyclerView.ViewHolder{
        TextView text;
        public TextItemViewHolder(View itemView) {
            super(itemView);
            text = (TextView) itemView.findViewById(R.id.text);
            text.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.d(TAG, "onClick: ");
                }
            });
        }
    }
}
