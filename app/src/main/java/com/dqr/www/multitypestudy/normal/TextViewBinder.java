package com.dqr.www.multitypestudy.normal;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dqr.www.multitypestudy.R;

import me.drakeet.multitype.ItemViewBinder;

/**
 * Description：
 * Author：LiuYM
 * Date： 2017-05-12 11:03
 */

public class TextViewBinder extends ItemViewBinder<TextItem,TextViewBinder.TextViewHolder> {

    @NonNull
    @Override
    protected TextViewHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        View view = inflater.inflate(R.layout.item_text, parent, false);
        return new TextViewHolder(view);
    }

    @Override
    protected void onBindViewHolder(@NonNull TextViewHolder holder, @NonNull TextItem item) {
        holder.mTextView.setText(item.text);
    }

    class  TextViewHolder extends RecyclerView.ViewHolder{

        TextView mTextView;

       public TextViewHolder(View itemView) {
           super(itemView);
           mTextView = (TextView) itemView.findViewById(R.id.text);
       }
   }
}
