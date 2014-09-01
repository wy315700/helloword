package com.helloword.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
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
    private ImageView userAvatarET;
    
    private String userName;
    private String password;
    private String nickName;
    private String college;
    private String newpassword;
    private String confirmpassword;
    private String userAvatarType;
    private String userAvatar;
    private int  REQUEST_CODE=1;
    private UsersApplication myApplication;
    private int[] drawAvatar = {R.drawable.ic_photo1, R.drawable.ic_photo2,
			R.drawable.ic_photo3, R.drawable.ic_photo4,
			R.drawable.ic_photo5, R.drawable.ic_photo6,
			R.drawable.ic_photo7, R.drawable.ic_photo8,
			R.drawable.ic_photo9, R.drawable.ic_photo10};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
    	
    	 super.onCreate(savedInstanceState);
         setContentView(R.layout.activity_change_info);
    	
    	
        userNameET = (EditText) findViewById(R.id.pvp_modify_username);
        passwordET = (EditText) findViewById(R.id.pvp_modify_password);
        nickNameET = (EditText) findViewById(R.id.pvp_modify_nickname);
        userAvatarET = (ImageView) findViewById(R.id.pvp_modify_photo);
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
//        Toast.makeText(ChangeInfoActivity.this, userAvatar, Toast.LENGTH_LONG).show();
        userAvatarET.setImageResource(ChoosePhoto(userAvatar));
    }
    
    
  /*  public void goChangePhoto(View view) {
        Intent intent = new Intent(this, ChangePhotoActivity.class);
        startActivity(intent);             
    }*/
    
    
    public int ChoosePhoto(String avatar){
    	
    	int resultdraw = R.drawable.ic_photo1;
    	int intavatar = Integer.parseInt(avatar);
    	
    	if(intavatar>=1&&intavatar<=10){
    		resultdraw = drawAvatar[intavatar-1];
    	}
    	    	   	
        return resultdraw;
    }

    public void goChangePhoto(View view){
    	Intent intent = new Intent();
    	intent.setClass(ChangeInfoActivity.this, PVPModifyPhotoActivity.class);
    	intent.putExtra("userAvatarString", userAvatar);
    	startActivityForResult(intent, REQUEST_CODE);
    	
    }
    
    public void onActivityResult(int requestCode, int resultCode, Intent data){
    	if (requestCode==REQUEST_CODE)  
        {  
            if (resultCode==PVPModifyPhotoActivity.RESULT_CODE)  
            {  
                Bundle bundle=data.getExtras();  
                userAvatar=bundle.getString("photo_avatar");  
                System.out.println(userAvatar);
                userAvatarET.setImageResource(ChoosePhoto(userAvatar));
//                Toast.makeText(ChangeInfoActivity.this, userAvatar, Toast.LENGTH_LONG).show(); 
                
            }  
        }  
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
