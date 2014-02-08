package com.example.manager.activity;

import com.example.manager.R;
import com.example.manager.service.UserService;
import com.example.manager.util.BuilderUtil;
import com.example.manager.util.DialogFactory;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class LoginActivity extends Activity implements OnClickListener {

	private Button loginBtn;
	private Button regBtn;

	
	private EditText userName;
	private EditText password;
	private CheckBox remember;

	private Dialog dialog;
	private SharedPreferences sp;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login);

		regBtn = (Button) findViewById(R.id.lg_reg_btn);
		loginBtn = (Button) findViewById(R.id.lg_btn);
		
		userName = (EditText) findViewById(R.id.lg_username);
		password = (EditText) findViewById(R.id.lg_password);
		remember = (CheckBox) findViewById(R.id.lg_remember_password);

		regBtn.setOnClickListener(this);
		loginBtn.setOnClickListener(this);
		
		initConfig();
	}
	
	// ��ʼ��SharedPreferences
	private void initConfig() {
		sp = getSharedPreferences("userinfo", MODE_PRIVATE);
		userName.setText(sp.getString("username", null));
		if(sp.getBoolean("remember", false)){
			password.setText(sp.getString("password", null));
		}
		//�ڶ�������ΪĬ��ֵ
		remember.setChecked(sp.getBoolean("remember", false));
	}
	

	public void goRegisterActivity() {
		Intent intent = new Intent();
		intent.setClass(this, RegisterActivity.class);
		startActivity(intent);
	}

	private void showRequestDialog() {
		if (dialog != null) {
			dialog.dismiss();
			dialog = null;
		}
		dialog = DialogFactory.creatRequestDialog(this, "���ڵ�½...");
		dialog.show();
	}
	
	//��¼��֤
	private void checkLogin(){
		showRequestDialog();
		UserService userService = new UserService(LoginActivity.this);
		if(userService.login(userName.getText().toString().trim(), 
				password.getText().toString().trim())){
			//��ס����
			if(remember.isChecked()){
				sp.edit().putString("username", userName.getText().toString().trim()).commit();
				sp.edit().putString("password", password.getText().toString().trim()).commit();
				sp.edit().putBoolean("remember",true).commit();
			}else{
				sp.edit().putString("username", "").commit();
				sp.edit().putString("password", "").commit();
				sp.edit().putBoolean("remember",false).commit();
			}
			Intent intent = new Intent();
			intent.setClass(LoginActivity.this, UserListActivity.class);
			intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); 
			startActivity(intent);
			finish();
			dialog.cancel();
		}else{
			dialog.cancel();
			new AlertDialog.Builder(LoginActivity.this)
			.setMessage("�û���������������������")
			.setPositiveButton("ȷ��", new DialogInterface.OnClickListener() {
				@Override
				public void onClick(DialogInterface dialog, int which) {
					password.setText("");
					dialog.cancel();
				}
			}).setCancelable(false).create().show();
		}
	}

	@Override
	public void onClick(View v) {
		switch(v.getId()){
		case R.id.lg_reg_btn:
			goRegisterActivity();
			break;
		case R.id.lg_btn:
			checkLogin();
			break;
		default:
			break;
		}
	}
	
	@Override
	public void onBackPressed() {
		Builder builder = BuilderUtil.getBuilder(LoginActivity.this, "", "ȷ���˳���");
		builder.setNeutralButton("ȷ��", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				finish();
			}
		});
		BuilderUtil.setNegativeButton(builder);
	}

}
