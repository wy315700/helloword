package com.helloword.activity;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Vibrator;

import com.helloword.R;
import com.helloword.util.BuilderUtil;


public class UserListActivity extends Activity {


	// ����
	private Vibrator vibrator;


	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_userlist);
	}
	
	public void goLoginActivity() {
		Intent intent = new Intent();
		intent.setClass(this, LoginActivity.class);
		intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); 
		startActivity(intent);
	}

	@Override
	public void onBackPressed() {
		Builder builder = BuilderUtil.getBuilder(UserListActivity.this, "", "���ػ��˳�");
		builder.setPositiveButton("�л��û�", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				finish();
				goLoginActivity();
			}
		});
		builder.setNeutralButton("�˳�", new DialogInterface.OnClickListener() {
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
		// �ر�����
		if (vibrator != null) {
			vibrator.cancel();
		}
	}
}