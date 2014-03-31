package com.helloword.activity;

import android.animation.ObjectAnimator;
import android.annotation.TargetApi;
import android.app.Activity;
import android.os.Build;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation.AnimationListener;
import android.widget.ProgressBar;

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
    
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public void progressAnim(ProgressBar progressBar, int start, int end, int durationTime) {
        ObjectAnimator anim = ObjectAnimator.ofInt(progressBar,
                "progress", start, end);
        anim.setDuration(durationTime);
        anim.start();
    }

    // ===========Common button function==============
    public void getBack(View view) {
        onBackPressed();
    }

}
