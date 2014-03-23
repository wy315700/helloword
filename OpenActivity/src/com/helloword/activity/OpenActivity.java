package com.helloword.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView;

import com.helloword.R;

public class OpenActivity extends BaseActivity implements AnimationListener{
    
    Handler handler;
    ImageView open_cushion_shade;
    private Animation shade;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
//		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
//				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.activity_open);

		
		open_cushion_shade = (ImageView) findViewById(R.id.open_cushion_shade);
		shade=AnimationUtils.loadAnimation(this, R.anim.open_shade);
		shade.setAnimationListener(this);
		open_cushion_shade.startAnimation(shade);
	}
	
	

	public void goMainInterfaceActivity() {
		Intent intent = new Intent(this, MainInterfaceActivity.class);
		startActivity(intent);
		finish();
	}



	@Override
	public void onAnimationEnd(Animation animation) {
		// TODO Auto-generated method stub
		open_cushion_shade.setVisibility(View.VISIBLE);
		handler = new Handler();
		handler.postDelayed(new Runnable() {

			@Override
			public void run() {
				goMainInterfaceActivity();
			}
		}, 1500);
	}



	@Override
	public void onAnimationRepeat(Animation animation) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void onAnimationStart(Animation animation) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
	
	
    
	
	
}
