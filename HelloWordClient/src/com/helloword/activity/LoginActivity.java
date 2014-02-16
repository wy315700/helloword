package com.helloword.activity;


import java.io.UnsupportedEncodingException;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.helloword.R;
import com.helloword.service.UserService;


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
	    String userName = userNameET.getText().toString().trim();
	    String password = passwordET.getText().toString().trim();
	    UserService userService = new UserService(this);
	    
	    if (userService.isConnected()) {
	        new LoginInBackground().execute(userName, password);
//	        Toast.makeText(getApplicationContext(), "num is " + loginResult,
//                  Toast.LENGTH_SHORT).show();
//	        
//	        }
	    }
	    else {
	        Toast.makeText(getApplicationContext(), "Please connect to the internet",
	                Toast.LENGTH_SHORT).show();
        }
	    
	}
	
	public void registerHandler(View view) {
	    Intent intent = new Intent(this, RegisterActivity.class);
	    startActivity(intent);
		Log.e(DEBUGTAG, "to register...");
	}
	
	private class LoginInBackground extends AsyncTask<String, Void, String> {
	    @Override
	    protected String doInBackground(String... params) {
	        UserService userService = new UserService();
            
            return userService.login(params[0], params[1]);
            
        }
        // onPostExecute displays the results of the AsyncTask.
        @Override
        protected void onPostExecute(String result) {
//          if (result.equals("success")) {
////              Intent intent = new Intent(this, UserListActivity.class);
////              startActivity(intent);
//          }
//          else {
              Toast.makeText(getApplicationContext(), result,
                      Toast.LENGTH_SHORT).show();
        }
	}
	

}
