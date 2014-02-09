package com.example.manager.activity;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.manager.R;
import com.example.manager.service.UserService;
import com.example.manager.util.DialogFactory;
import com.example.manager.vo.User;

public class RegisterActivity extends Activity {

	private Button registerBtn;
	private Button returnBtn;
	private Dialog dialog = null;
	
	private EditText userName;
	private EditText password;
	private EditText passwordCon;
	private EditText email;
	
	//判断用户名是否通过验证
	private boolean userNamePass = false;
	//判断密码是否通过验证
	private boolean passwordPass = false;
	//判断邮箱是否通过验证
	private boolean emailPass = false;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.register);

		registerBtn = (Button) findViewById(R.id.reg_btn);
		returnBtn=(Button) findViewById(R.id.Button01);
		userName = (EditText) findViewById(R.id.username);
		password = (EditText) findViewById(R.id.password);
		passwordCon = (EditText) findViewById(R.id.passwordcon);
		email = (EditText) findViewById(R.id.email);
		
		final UserService userService = new UserService(RegisterActivity.this);
		
		userName.setOnFocusChangeListener(new View.OnFocusChangeListener() {
			@Override
			public void onFocusChange(View v, boolean hasFocus) {
				if(!userName.hasFocus()){
					if(checkEmail(userName.getText().toString().trim())){
						if(userService.registerName(userName.getText().toString().trim())){
							userNamePass = true;
						}else{
							Toast.makeText(RegisterActivity.this, "该用户名已存在，请注册其他用户名", 
									Toast.LENGTH_LONG).show();
						}
					}
				}
			}
		});
		
		password.setOnFocusChangeListener(new View.OnFocusChangeListener() {
			@Override
			public void onFocusChange(View v, boolean hasFocus) {
				if(!password.hasFocus()){
					if(checkPassword(password.getText().toString().trim())){
						passwordPass = true;
					}
				}
			}
		});
		
		passwordCon.setOnFocusChangeListener(new View.OnFocusChangeListener() {
			@Override
			public void onFocusChange(View v, boolean hasFocus) {
				if(!passwordCon.hasFocus()){
					if(!checkPasswordEqual(password.getText().toString().trim(),
							passwordCon.getText().toString().trim())){
						passwordPass = false;
						password.setText("");
						passwordCon.setText("");
					}else{
						passwordPass = true;
					}
				}
			}
		});
			
		registerBtn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				if(checkUserName(email.getText().toString().trim())){
					emailPass = true;
				}
				if(checkEmpty()&&userNamePass&&passwordPass&&emailPass){
					showRequestDialog();
					String userNameStr = userName.getText().toString().trim();
					String passwordStr = password.getText().toString().trim();
					String emailStr = email.getText().toString().trim();
					
					
					User user = new User();
					user.setUserName(userNameStr);
					user.setUserPwd(passwordStr);
					user.setUserEmail(emailStr);
					
					if(userService.register(user)){
						dialog.cancel();
						//new AlertDialog.Builder(RegisterActivity.this)
						//.setMessage("恭喜你注册成功！点击确定跳转到登陆界面")
						//.setPositiveButton("确定", new DialogInterface.OnClickListener() {
							//@Override
							//public void onClick(DialogInterface dialog, int which) {
								Intent intent = new Intent();
								intent.setClass(RegisterActivity.this, UserListActivity.class);
								startActivity(intent);
								finish();
								//dialog.cancel();
							//}
						//}).setCancelable(false).create().show();
					}
				}
			}
		});
		returnBtn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent();
				intent.setClass(RegisterActivity.this, LoginActivity.class);
				startActivity(intent);
				finish();
			}
		});
	}

	private void showRequestDialog() {
		if (dialog != null) {
			dialog.dismiss();// 解雇此对话框
			dialog = null;
		}
		dialog = DialogFactory.creatRequestDialog(this, "正在注册中...");
		dialog.show();
	}
	
	
	/************************************验证部分*************************************/
	//验证用户名格式
	private boolean checkUserName(String username){
		if(username.matches("(\\w){6,18}")){
			return true;
		}else{
			Toast.makeText(RegisterActivity.this, "昵称为6-18个字符，可使用数字、字母、下划线", 
					Toast.LENGTH_LONG).show();
		}
		return false;
	}
	//验证密码格式
	private boolean checkPassword(String password){
		if(password.matches("(\\w){6,15}")){
			return true;
		}else{
			Toast.makeText(RegisterActivity.this, "密码为6-15个字符，区分大小写,可使用数字、字母、下划线", 
					Toast.LENGTH_LONG).show();
		}
		return false;
	}
	//验证邮箱格式
	private boolean checkEmail(String email){
		if(email.matches("^[a-zA-Z0-9_]+@([a-zA-Z0-9]+\\.)+(com|cn|net)$")){
			return true;
		}else{
			Toast.makeText(RegisterActivity.this, "电子邮箱格式不正确，请输入正确的邮箱", 
					Toast.LENGTH_LONG).show();
		}
		return false;
	}
	//验证两次密码输入是否相同
	private boolean checkPasswordEqual(String password,String passwordCon){
		if(password.equals(passwordCon)){
			return true;
		}else{
			Toast.makeText(RegisterActivity.this, "两次输入的密码不一致，请重新输入", 
					Toast.LENGTH_LONG).show();
		}
		return false;
	}
	//判断是否有空输入
	private boolean checkEmpty(){
		if(userName.getText().toString().equals("")){
			Toast.makeText(RegisterActivity.this, "用户名为空，请输入用户名", 
					Toast.LENGTH_LONG).show();
			return false;
		}
		if(password.getText().toString().equals("")){
			Toast.makeText(RegisterActivity.this, "密码为空，请输入密码", 
					Toast.LENGTH_LONG).show();
			return false;
		}
		if(passwordCon.getText().toString().equals("")){
			Toast.makeText(RegisterActivity.this, "确认密码为空，请输入确认密码", 
					Toast.LENGTH_LONG).show();
			return false;
		}
		if(email.getText().toString().equals("")){
			Toast.makeText(RegisterActivity.this, "邮箱为空，请输入邮箱", 
					Toast.LENGTH_LONG).show();
			return false;
		}
		return true;
	}

}

