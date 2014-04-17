package com.helloword.activity;

import android.app.Activity;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

public abstract class BaseActivity extends Activity {

    // ========UI interaction effect=============
    public void fadeIn(View animView, int durationTime,
            AnimationListener animListener) {
        animView.setVisibility(View.GONE);
        AlphaAnimation alphaAnim = new AlphaAnimation(0f, 1f);
        alphaAnim.setDuration(durationTime);
        alphaAnim.setAnimationListener(animListener);
        animView.setAnimation(alphaAnim);
        animView.setVisibility(View.VISIBLE);
        alphaAnim.startNow();
    }

    public void fadeOut(View animView, int durationTime,
            AnimationListener animListener) {
        AlphaAnimation alphaAnim = new AlphaAnimation(1f, 0f);
        alphaAnim.setDuration(durationTime);
        alphaAnim.setAnimationListener(animListener);
        animView.setAnimation(alphaAnim);
        animView.setVisibility(View.VISIBLE);
        alphaAnim.startNow();
        animView.setVisibility(View.GONE);
    }

    public void clearAnim(View animView) {
        animView.clearAnimation();
    }

    
    // ===========Common button function==============
    public void getBack(View view) {
        onBackPressed();
    }
    
    protected class AnimationListenerAdapter implements AnimationListener {
        @Override
        public void onAnimationEnd(Animation animation) {
        }
        @Override
        public void onAnimationRepeat(Animation animation) {
        }
        @Override
        public void onAnimationStart(Animation animation) {
        }
    }

}
