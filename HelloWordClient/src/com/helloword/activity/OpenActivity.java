package com.helloword.activity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import com.helloword.R;

public class OpenActivity extends BaseActivity {
    
    private final int OPEN_DURATION = 3000; //milliseconds
    private ImageView background;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_open);
		
		background = (ImageView) findViewById(R.id.open_bg);
		AnimatorListenerAdapter animEnd = new AnimatorListenerAdapter() {
		    @Override
		    public void onAnimationEnd(Animator animation) {
		        goMainInterfaceActivity();
		    }
		};
		fadeIn(background, OPEN_DURATION, animEnd);
		
	}
	
	public void goMainInterfaceActivity() {
		Intent intent = new Intent(this, MainInterfaceActivity.class);
		startActivity(intent);
		finish();
	}
	
	
	
	
	
	
    
	
	
}
