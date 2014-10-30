package com.helloword.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.onekeyshare.OnekeyShare;

import com.helloword.R;
import com.helloword.service.GameService;
import com.helloword.service.NetworkService;
import com.helloword.util.UsersApplication;

public class PVPEndActivity extends BaseActivity {

    private TextView win;
    private RelativeLayout buttonsArea;
    private UsersApplication users;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pvp_end);
		users = (UsersApplication) getApplication();

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
    
	public void goPVPRank(View view) {      
        Intent intent = new Intent(this, PVPRankActivity.class);
		startActivity(intent);
	}

	
	public void shareRecord(View view){
		ShareSDK.initSDK(this);
		OnekeyShare oks = new OnekeyShare();
		oks.setNotification(R.drawable.ic_photo1, "demo");
		String nickname = users.getUserNickname();
		String shareContextString = "恭喜" + nickname +
				"击败世界90%的参赛者，你敢来挑战？等你来！";
		oks.setTitle("jianhu");
		oks.setText(shareContextString);
		oks.setSilent(false);
		oks.show(this);		
	}	
}
