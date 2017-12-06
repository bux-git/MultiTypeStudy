/**
 * @file XListViewHeader.java
 * @create Apr 18, 2012 5:22:27 PM
 * @author Maxwin
 * @description XListView's header
 */
package com.dqr.www.multitypestudy.widget;

import android.animation.ValueAnimator;
import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.dqr.www.multitypestudy.R;


public class XListViewHeader extends LinearLayout {
	private LinearLayout mContainer;
	private ImageView mArrowImageView;
	private ProgressBar mProgressBar;
	private TextView mHintTextView;
	private int mState = STATE_NORMAL;
	public int mMeasuredHeight;
	private Animation mRotateUpAnim;
	private Animation mRotateDownAnim;
	private RelativeLayout mHeaderViewContent;
	private final int ROTATE_ANIM_DURATION = 180;
	private boolean mEnablePullRefresh = true;
	public final static int STATE_NORMAL = 0;
	public final static int STATE_READY = 1;
	public final static int STATE_REFRESHING = 2;
	public final static int STATE_DONE=3;
	public XListViewHeader(Context context) {
		super(context);
		initView(context);
	}

	public XListViewHeader(Context context, AttributeSet attrs) {
		super(context, attrs);
		initView(context);
	}

	private void initView(Context context) {
		LayoutParams lp = new LayoutParams(LayoutParams.MATCH_PARENT, 0);
		mContainer = (LinearLayout) LayoutInflater.from(context).inflate(
				R.layout.xlistview_header, null);
		addView(mContainer, lp);
		setGravity(Gravity.BOTTOM);

		mArrowImageView = (ImageView)findViewById(R.id.xlistview_header_arrow);
		mHintTextView = (TextView)findViewById(R.id.xlistview_header_hint_textview);
		mProgressBar = (ProgressBar)findViewById(R.id.xlistview_header_progressbar);
		mHeaderViewContent = (RelativeLayout)findViewById(R.id.xlistview_header_content);
		mRotateUpAnim = new RotateAnimation(0.0f, -180.0f,
				Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF,
				0.5f);
		mRotateUpAnim.setDuration(ROTATE_ANIM_DURATION);
		mRotateUpAnim.setFillAfter(true);
		mRotateDownAnim = new RotateAnimation(-180.0f, 0.0f,
				Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF,
				0.5f);
		mRotateDownAnim.setDuration(ROTATE_ANIM_DURATION);
		mRotateDownAnim.setFillAfter(true);
		measure(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
		if (mMeasuredHeight==0){
			mMeasuredHeight = getMeasuredHeight();
		}

	}

	public void setPullRefreshEnable(boolean enable) {
		mEnablePullRefresh=enable;
		if (!enable) { // disable, hide the content
			mHeaderViewContent.setVisibility(View.INVISIBLE);
		} else {
			mHeaderViewContent.setVisibility(View.VISIBLE);
		}
	}

	public void setState(int state) {
		if (state == mState) return ;
		
		if (state == STATE_REFRESHING) {	// 显示进度
			mArrowImageView.clearAnimation();
			mArrowImageView.setVisibility(View.INVISIBLE);
			mProgressBar.setVisibility(View.VISIBLE);
		} else if(state == STATE_DONE) {
			mArrowImageView.setVisibility(View.INVISIBLE);
			mProgressBar.setVisibility(View.INVISIBLE);
		} else {	// 显示箭头图片
			mArrowImageView.setVisibility(View.VISIBLE);
			mProgressBar.setVisibility(View.INVISIBLE);
		}
		
		switch(state){
		case STATE_NORMAL:
			if (mState == STATE_READY) {
				mArrowImageView.startAnimation(mRotateDownAnim);
			}
			if (mState == STATE_REFRESHING) {
				mArrowImageView.clearAnimation();
			}
			mHintTextView.setText(R.string.xlistview_header_hint_normal);
			break;
		case STATE_READY:
			if (mState != STATE_READY) {
				mArrowImageView.clearAnimation();
				mArrowImageView.startAnimation(mRotateUpAnim);
				mHintTextView.setText(R.string.xlistview_header_hint_ready);
			}
			break;
		case STATE_REFRESHING:
			mHintTextView.setText(R.string.xlistview_header_hint_loading);
			break;
			case    STATE_DONE:
				mHintTextView.setText(R.string.xlistview_header_hint_done);
				break;
		}
		
		mState = state;
	}
	
	public int getState() {
		return mState;
	}

	public void setVisibleHeight(int height) {
		if (height < 0)
			height = 0;
		LayoutParams lp = (LayoutParams) mContainer
				.getLayoutParams();
		lp.height = height;
		mContainer.setLayoutParams(lp);
	}

	public int getVisibleHeight() {
		return mContainer.getLayoutParams().height;
	}

	public void onMove(float delta) {
		if(getVisibleHeight() > 0 || delta > 0) {
			setVisibleHeight((int) delta + getVisibleHeight());
			if (mState != STATE_REFRESHING&&mEnablePullRefresh) { // 未处于刷新状态，更新箭头
				if (getVisibleHeight() >= mMeasuredHeight) {
					setState(STATE_READY);
				}else {
					setState(STATE_NORMAL);
				}
			}
		}
	}
	public void setHeight(int delta) {
		if(getVisibleHeight() > 0 || delta > 0) {
			setVisibleHeight(delta );
			if (mState != STATE_REFRESHING&&mEnablePullRefresh) { // 未处于刷新状态，更新箭头
				if (getVisibleHeight() >= mMeasuredHeight) {
					setState(STATE_READY);
				}else {
					setState(STATE_NORMAL);
				}
			}
		}
	}
	public void refreshComplete(){
		setState(STATE_DONE);
		new Handler().postDelayed(new Runnable() {
			public void run() {
				reset();
			}
		}, 300);
	}

	public boolean releaseAction() {

		if(!mEnablePullRefresh){
			smoothScrollTo(0);
			return false;
		}
		boolean isOnRefresh = false;
		int height = getVisibleHeight();
		if (height == 0) // not visible.
			isOnRefresh = false;

		if(getVisibleHeight() > mMeasuredHeight){
			setState(STATE_READY);
			isOnRefresh = true;
		}
		// refreshing and header isn't shown fully. do nothing.
		if (mState == STATE_REFRESHING && height <=  mMeasuredHeight) {
			//return;
		}

		int destHeight = 0; // default: scroll back to dismiss header.
		// is refreshing, just scroll back to show all the header.
		if (mState == STATE_READY) {
			destHeight = mMeasuredHeight;

		}
		smoothScrollTo(destHeight);

		return isOnRefresh;
	}

	public void reset() {
		smoothScrollTo(0);
		new Handler().postDelayed(new Runnable() {
			public void run() {
				setState(STATE_NORMAL);
			}
		}, 500);
	}

	private void smoothScrollTo(int destHeight) {
		ValueAnimator animator = ValueAnimator.ofInt(getVisibleHeight(), destHeight);
		animator.setDuration(300).start();
		animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
			@Override
			public void onAnimationUpdate(ValueAnimator animation)
			{
				setVisibleHeight((int) animation.getAnimatedValue());
			}
		});
		animator.start();
	}

}
