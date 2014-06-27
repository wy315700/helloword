package com.helloword.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

//import com.helloword.activity.LoginActivity.LoginInBackground;
import com.helloword.service.NetworkService;
import com.helloword.service.UserService;
import com.helloword.util.*; 

import com.helloword.R;

public class ChangeInfoActivity extends Activity {
    private EditText userNameET;
    private EditText passwordET;
    private EditText nickNameET;
    private EditText collegeET;
    private EditText newpasswordET;
    private EditText confirmpasswordET;
    
    private String userName;
    private String password;
    private String nickName;
    private String college;
    private String newpassword;
    private String confirmpassword;
    private String userAvatarType;
    private String userAvatar;
    private UsersApplication myApplication;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
    	
    	 super.onCreate(savedInstanceState);
         setContentView(R.layout.activity_change_info);
    	
    	
        userNameET = (EditText) findViewById(R.id.pvp_modify_username);
        passwordET = (EditText) findViewById(R.id.pvp_modify_password);
        nickNameET = (EditText) findViewById(R.id.pvp_modify_nickname);
        //collegeET = (EditText) findViewById(R.id.pvp_modify_college);
        newpasswordET = (EditText) findViewById(R.id.pvp_modify_newpassword);
        confirmpasswordET = (EditText) findViewById(R.id.pvp_modify_confirmpass);
        
        myApplication = (UsersApplication)getApplication();
        userName = myApplication.getUserName();
        nickName = myApplication.getUserNickname();
        userAvatar = myApplication.getUserAvatar();
        userAvatarType = myApplication.getUserAvatarType();
        //password = myApplication.getUserName();
        //college = myApplication.get
        userNameET.setText(userName);
        nickNameET.setText(nickName);
       
    }
    
    public void goChangePhoto(View view) {
        Intent intent = new Intent(this, ChangePhotoActivity.class);
        startActivity(intent);
                
    }
    
    public void confirmModify(View view){
    	 userName = userNameET.getText().toString().trim();
         password = passwordET.getText().toString().trim();
         newpassword = newpasswordET .getText().toString().trim();
         confirmpassword = confirmpasswordET.getText().toString().trim();
         nickName = nickNameET.getText().toString().trim();
        boolean formatQuality = verifyFormat();
        if(formatQuality == false){
        	return;
        }
        NetworkService networkService = new NetworkService(this);
        if (networkService.isConnected()) {
            new ChangeInfoInBackground(ChangeInfoActivity.this).execute(userName, nickName,
            		password,newpassword,userAvatarType,userAvatar);
        } else {
            Toast.makeText(getApplicationContext(),R.string.connect_to_network,
                    Toast.LENGTH_SHORT)
                    .show();
        }
    }
    private class ChangeInfoInBackground extends AsyncTaskWithProgressDialog {
        public ChangeInfoInBackground(Context progressDialogContext) {
			super(progressDialogContext);
		}

		@Override
        protected String doInBackground2(String... params) {
            UserService userService = new UserService(getApplication());
            return userService.changeUserInfo(params[0], params[1],params[2], params[3],
            		params[4], params[5]);
        }

        // onPostExecute displays the results of the AsyncTask.
        @Override
        protected void onPostExecute2(String result) {
            if (result.equals("success")) {
            	Toast.makeText(getApplicationContext(), result,
                        Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(getApplicationContext(), result,
                        Toast.LENGTH_SHORT).show();
            }
        }
    }
    private boolean verifyFormat() {
        boolean formatQuality = false;

        userName = userNameET.getText().toString().trim();
        password = passwordET.getText().toString().trim();
        newpassword = newpasswordET .getText().toString().trim();
        confirmpassword = confirmpasswordET.getText().toString().trim();
        nickName = nickNameET.getText().toString().trim();
        
        // verify username format
        if (!userName.matches("^[a-zA-Z0-9_]+@([a-zA-Z0-9]+\\.)+(com|cn|net)$")) {
            Toast.makeText(getApplicationContext(), "用户名不正确",
                    Toast.LENGTH_SHORT).show();
            
            return formatQuality;
        }

        // verify password
        if (newpassword == "" || !newpassword.equals(confirmpassword)) {
            Toast.makeText(getApplicationContext(), "密码错误请重新输入",
                    Toast.LENGTH_SHORT).show();
           
            return formatQuality;
        }

        // verify nickname
        if (!nickName.matches("^[a-zA-Z0-9][a-zA-Z0-9_]+")) {
            Toast.makeText(getApplicationContext(), "昵称不正确", Toast.LENGTH_SHORT)
                    .show();
           
            return formatQuality;
        }

        formatQuality = true;
        return formatQuality;
        
    }  
}
