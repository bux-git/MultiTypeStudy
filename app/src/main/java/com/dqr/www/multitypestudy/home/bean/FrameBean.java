package com.dqr.www.multitypestudy.home.bean;

/**
 * Description：
 * Author：LiuYM
 * Date： 2017-08-14 16:58
 */

public class FrameBean {

    private int leftImgResId;
    private int leftTitleResId;
    private int rightTitle;
    private int rightImgReId;
    private int replaceResId;
    private Content mContent;

    public FrameBean(int leftImgResId, int leftTitleResId, int rightTitle, int rightImgReId, int replaceResId, Content content) {
        this.leftImgResId = leftImgResId;
        this.leftTitleResId = leftTitleResId;
        this.rightTitle = rightTitle;
        this.rightImgReId = rightImgReId;
        this.replaceResId = replaceResId;
        mContent = content;
    }

    public int getLeftImgResId() {
        return leftImgResId;
    }

    public void setLeftImgResId(int leftImgResId) {
        this.leftImgResId = leftImgResId;
    }

    public int getLeftTitleResId() {
        return leftTitleResId;
    }

    public void setLeftTitleResId(int leftTitleResId) {
        this.leftTitleResId = leftTitleResId;
    }

    public int getRightTitle() {
        return rightTitle;
    }

    public void setRightTitle(int rightTitle) {
        this.rightTitle = rightTitle;
    }

    public int getRightImgReId() {
        return rightImgReId;
    }

    public void setRightImgReId(int rightImgReId) {
        this.rightImgReId = rightImgReId;
    }

    public int getReplaceResId() {
        return replaceResId;
    }

    public void setReplaceResId(int replaceResId) {
        this.replaceResId = replaceResId;
    }

    public Content getContent() {
        return mContent;
    }

    public void setContent(Content content) {
        mContent = content;
    }
}
