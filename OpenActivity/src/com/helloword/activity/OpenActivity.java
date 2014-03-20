package com.helloword.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.helloword.R;

public class OpenActivity extends BaseActivity {
    
    Handler handler;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
//		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
//				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.activity_open);

		handler = new Handler();
		handler.postDelayed(new Runnable() {

			@Override
			public void run() {
				goMainInterfaceActivity();
			}
		}, 1500);
		
	}
	
	

	public void goMainInterfaceActivity() {
		Intent intent = new Intent(this, MainInterfaceActivity.class);
		startActivity(intent);
		finish();
	}
	
	
	
	
	
	
    
	
	
}
