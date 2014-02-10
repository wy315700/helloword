package com.helloword.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.helloword.R;
import com.helloword.protocolTransmission.SerializeRequest;



public class RegisterActivity extends Activity {

private static final String DEBUG = "register activity";
//	private Button registerBtn;
//	private Button returnBtn;
//	private Dialog dialog = null;
//	
	private EditText userNameET;
	private EditText passwordET;
	private EditText passwordConfirmET;
	private EditText userNicknameET;
	
	private String userName;
	private String password;
	private String passwordConfirm;
	private String userNickname;
	
//	//�ж��û����Ƿ�ͨ����֤
//	private boolean userNamePass = false;
//	//�ж������Ƿ�ͨ����֤
//	private boolean passwordPass = false;
//	//�ж������Ƿ�ͨ����֤
//	private boolean emailPass = false;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_register);
		
		userNameET = (EditText) findViewById(R.id.register_username);
		passwordET = (EditText) findViewById(R.id.register_password);
		passwordConfirmET = (EditText) findViewById(R.id.register_password_confirm);
		userNicknameET = (EditText) findViewById(R.id.register_user_nickname);
	}
	
	public void registerHandler(View view) {
	    boolean format = verifyFormat();
	    if (format) {
	        SerializeRequest request = new SerializeRequest();
	        String jsonData = request.registerRequest(userName, userNickname, password);
	        Toast.makeText(getApplicationContext(), jsonData,
                    Toast.LENGTH_SHORT).show();
	        Log.e(DEBUG, jsonData);
	        Intent intent = new Intent(this, UserListActivity.class);
	        startActivity(intent);
	    }
	}
	
	public void goback(View view) {
	    Intent intent = new Intent(this, LoginActivity.class);
	    startActivity(intent);
	}
	
	private boolean verifyFormat() {
	    boolean formatQuality = false;
	    
	    userName = userNameET.getText().toString().trim();
        password = passwordET.getText().toString().trim();
        passwordConfirm = passwordConfirmET.getText().toString().trim();
	    userNickname = userNicknameET.getText().toString().trim();
	    
	    // verify username format
	    if (!userName.matches("^[a-zA-Z0-9_]+@([a-zA-Z0-9]+\\.)+(com|cn|net)$")) {
	        Toast.makeText(getApplicationContext(), "用户名不正确",
	                Toast.LENGTH_SHORT).show();
	        Log.e(DEBUG, "用户名不正确");
	        return formatQuality;
	    }
	        
	    // verify password
	    if (password == "" || !password.equals(passwordConfirm)) {
	        Toast.makeText(getApplicationContext(), "密码错误请重新输入",
                    Toast.LENGTH_SHORT).show();
	        Log.e(DEBUG, "密码错误请重新输入");
	        return formatQuality;
	    }
	    
	    // verify nickname
	    if (!userNickname.matches("^[a-zA-Z0-9][a-zA-Z0-9_]+")) {
	        Toast.makeText(getApplicationContext(), "昵称不正确",
                    Toast.LENGTH_SHORT).show();
	        Log.e(DEBUG, "昵称不正确");
            return formatQuality;
	    }
	    	    
	    formatQuality = true;
	    return formatQuality;
	}

}
