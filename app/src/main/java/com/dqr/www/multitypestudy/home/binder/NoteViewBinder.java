package com.dqr.www.multitypestudy.home.binder;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.dqr.www.multitypestudy.R;
import com.dqr.www.multitypestudy.home.bean.Note;

import java.util.List;

import static com.dqr.www.multitypestudy.R.id.tv_nickname;

/**
 * Description：
 * Author：LiuYM
 * Date： 2017-08-16 11:02
 */

public class NoteViewBinder extends FrameViewBinder<Note>{



    @Override
    public View onSubCreateView(LayoutInflater inflater, ViewGroup parent, int dataSize,int index) {
        return inflater.inflate(R.layout.home_item_note_layout,parent,false);
    }

    @Override
    public void onSubViewBind(View itemView, List<Note> subList, int index) {
        ImageView ivBgImg = (ImageView) itemView.findViewById(R.id.img_bj);
        TextView tvTitle = (TextView) itemView.findViewById(R.id.tv_title);
        ImageView ivAvatar = (ImageView) itemView.findViewById(R.id.iv_avatar);
        TextView tvNickname = (TextView) itemView.findViewById(tv_nickname);
        TextView tvEye = (TextView) itemView.findViewById(R.id.tv_eye);
        TextView tvPraise = (TextView) itemView.findViewById(R.id.tv_praise);
        TextView tvComment = (TextView) itemView.findViewById(R.id.tv_comment);

        final Note note = subList.get(index);

        Glide.with(mContext)
                .load(note.getBgImg())
                .error(R.drawable.note_loading).into(ivBgImg);


        tvTitle.setText(note.getTitle());
        tvEye.setText(note.getSee()+"");
        tvPraise.setText(note.getCollection()+"");
        tvComment.setText(note.getComment()+"");


        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
