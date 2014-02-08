package com.example.manager.activity;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Vibrator;
import com.example.manager.R;
import com.example.manager.util.BuilderUtil;


public class UserListActivity extends Activity {


	// 振动器
	private Vibrator vibrator;


	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.list);
	}
	
	public void goLoginActivity() {
		Intent intent = new Intent();
		intent.setClass(this, LoginActivity.class);
		intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); 
		startActivity(intent);
	}

	@Override
	public void onBackPressed() {
		Builder builder = BuilderUtil.getBuilder(UserListActivity.this, "", "返回或退出");
		builder.setPositiveButton("切换用户", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				finish();
				goLoginActivity();
			}
		});
		builder.setNeutralButton("退出", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				finish();
			}
		});
		BuilderUtil.setNegativeButton(builder);
	}
	
	@Override
	protected void onStop() {
		super.onStop();
		// 关闭振动器
		if (vibrator != null) {
			vibrator.cancel();
		}
	}
}