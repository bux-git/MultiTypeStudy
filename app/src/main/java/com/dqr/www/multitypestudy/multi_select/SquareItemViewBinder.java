package com.dqr.www.multitypestudy.multi_select;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dqr.www.multitypestudy.R;

import java.util.List;

import me.drakeet.multitype.ItemViewBinder;

/**
 * Description：
 * Author：LiuYM
 * Date： 2017-05-15 11:01
 */

public class SquareItemViewBinder extends ItemViewBinder<SquareItem,SquareItemViewBinder.SquareViewHolder> {
    private List<SquareItem> mSquareItems;

    public SquareItemViewBinder(List<SquareItem> squareItems) {
        mSquareItems = squareItems;
    }

    @NonNull
    @Override
    protected SquareViewHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        View view = inflater.inflate(R.layout.item_square, parent, false);
        return new SquareViewHolder(view);
    }

    @Override
    protected void onBindViewHolder(@NonNull SquareViewHolder holder, @NonNull SquareItem item) {
        holder.mSquareItem=item;
        holder.square.setText(item.text);
        holder.square.setSelected(item.isSelected);
    }

    class SquareViewHolder extends RecyclerView.ViewHolder{
        TextView square;
        SquareItem mSquareItem;
        public SquareViewHolder(View itemView) {
            super(itemView);
            square = (TextView) itemView.findViewById(R.id.square);
            square.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    square.setSelected(mSquareItem.isSelected=!mSquareItem.isSelected);
                    if(mSquareItem.isSelected){
                        mSquareItems.add(mSquareItem);
                    }else{
                        mSquareItems.remove(mSquareItem);
                    }
                }
            });
        }
    }
}
