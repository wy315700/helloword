package com.helloword.activity;

import android.animation.AnimatorListenerAdapter;
import android.app.Activity;
import android.view.View;

public abstract class BaseActivity extends Activity {

    //========UI interaction effect=============
    public void fadeIn(View animView, int durationTime, AnimatorListenerAdapter animListener) {
        animView.setVisibility(View.GONE);
        animView.setAlpha(0f);
        animView.setVisibility(View.VISIBLE);
        animView.animate()
            .alpha(1f)
            .setDuration(durationTime)
            .setListener(animListener);
    }
    
    public void fadeOut(View animView, int durationTime, AnimatorListenerAdapter animListener) {
        animView.animate()
            .alpha(0f)
            .setDuration(durationTime)
            .setListener(animListener);
        animView.setVisibility(View.GONE);
    }
    
    
    
    //===========Common button function==============
    public void getBack(View view) {
        onBackPressed();
    }
    
}
