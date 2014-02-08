package com.example.manager.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;

import com.example.manager.R;

public class MainActivity extends Activity {

	private Handler handler;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// ÎÞtitle
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		// È«ÆÁ
//		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
//				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.activity_main);

		handler = new Handler();
		handler.postDelayed(new Runnable() {

			@Override
			public void run() {
				goLoginActivity();
			}
		}, 1200);
	}

	public void goLoginActivity() {
		Intent intent = new Intent();
		intent.setClass(this, LoginActivity.class);
		startActivity(intent);
		finish();
	}
}
