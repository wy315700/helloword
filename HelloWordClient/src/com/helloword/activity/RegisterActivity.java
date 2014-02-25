package com.helloword.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.helloword.R;
import com.helloword.service.NetworkService;
import com.helloword.service.UserService;



/**
 * @author Liletta
 * register activity
 * all the strings displayed are waiting to be put into string XML for universal management
 *
 */
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
	    NetworkService networkService = new NetworkService(this);
	    boolean format = verifyFormat();
	    if (format)
	        if(networkService.isConnected()) {
	            new RegisterInBackground().execute(userName, password, userNickname);
	        }
	        else {
	            Toast.makeText(getApplicationContext(), "please connect to internet",
	                    Toast.LENGTH_SHORT).show();
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
	
	private class RegisterInBackground extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... params) {
            UserService userService = new UserService();
            return userService.register(params[0], params[1], params[2]);
            
        }
        // onPostExecute displays the results of the AsyncTask.
        @Override
        protected void onPostExecute(String result) {
            if (result.equals("success")) {
                Intent intent = new Intent(getApplicationContext(), MainInterfaceActivity.class);
                startActivity(intent);
            }
            else {
                Toast.makeText(getApplicationContext(), result,
                      Toast.LENGTH_SHORT).show();
            }
        }
    }

}
