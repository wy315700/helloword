package com.helloword.activity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.helloword.R;

public class PVPEndActivity extends BaseActivity {

    private TextView win;
    private RelativeLayout buttonsArea;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pvp_end);

        win = (TextView) findViewById(R.id.pvp_end_tx_win);
        buttonsArea = (RelativeLayout) findViewById(R.id.pvp_end_buttons_area);
        buttonsArea.setVisibility(View.GONE);
        // Animation set
        win.setVisibility(View.GONE);
        AlphaAnimation alphaAnim = new AlphaAnimation(0f, 1f);
        alphaAnim.setDuration(1000);
        ScaleAnimation scaleAnim = new ScaleAnimation(0.5f, 1.5f, 0.5f, 1.5f);
        scaleAnim.setDuration(1000);
        TranslateAnimation translateAnim = new TranslateAnimation(0f, -400f, 0f,
                -400f);
        translateAnim.setDuration(2000);
        AnimationSet animSet = new AnimationSet(true);
        animSet.addAnimation(alphaAnim);
        animSet.addAnimation(scaleAnim);
        animSet.addAnimation(translateAnim);
        animSet.setFillAfter(true);
        AnimationListenerAdapter animEnd = new AnimationListenerAdapter() {
            @Override
            public void onAnimationEnd(Animation animation) {
                fadeIn(buttonsArea, 500, null);
            }
        };
        animSet.setAnimationListener(animEnd);
        win.setAnimation(animSet);
        win.setVisibility(View.VISIBLE);
        animSet.startNow();
    }

}
