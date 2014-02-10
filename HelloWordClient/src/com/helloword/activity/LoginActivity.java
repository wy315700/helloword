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


public class LoginActivity extends Activity {

	// private Button loginBtn;
	// private Button regBtn;

	
	 private EditText userNameET;
	 private EditText passwordET;
	// private CheckBox remember;

	// private Dialog dialog;
	// private SharedPreferences sp;

	private static final String DEBUGTAG = "LoginActivity";

    @Override
	protected void onCreate(Bundle savedInstanceState) {
		 super.onCreate(savedInstanceState);
		 setContentView(R.layout.activity_login);

		// registerBtn = (Button) findViewById(R.id.lg_register_btn);
		// loginBtn = (Button) findViewById(R.id.lg_login_btn);
		
		 userNameET = (EditText) findViewById(R.id.lg_username);
		 passwordET = (EditText) findViewById(R.id.lg_password);
		// rememberPassword = (CheckBox) findViewById(R.id.lg_remember_password);

		// regBtn.setOnClickListener(this);
		// loginBtn.setOnClickListener(this);
		
		// initConfig();
	}
	
	public void loginHandler(View view) {
	    SerializeRequest request = new SerializeRequest();
	    String userName = userNameET.getText().toString().trim();
	    String password = passwordET.getText().toString().trim();
	    String jsonData = request.loginRequest(userName, password);
	    Toast.makeText(getApplicationContext(), jsonData,
	            Toast.LENGTH_SHORT).show();
		Log.e(DEBUGTAG, "to login..." + jsonData);
	}

	public void registerHandler(View view) {
	    Intent intent = new Intent(this, RegisterActivity.class);
	    startActivity(intent);
		Log.e(DEBUGTAG, "to register...");
	}
	

}
