package com.helloword.activity;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.helloword.R;
import com.helloword.service.NetworkService;
import com.helloword.service.UserService;

public class MainInterfaceActivity extends BaseActivity {
    
    private long firstBackTime;
    
    @Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_interface);
		
		firstBackTime = 0;
	}
    
 // when press back-key twice, quit the app
    @Override
    public void onBackPressed() {
        if ((System.currentTimeMillis() - firstBackTime) > 1500) {
            Toast.makeText(this, R.string.toast_quit_app, Toast.LENGTH_SHORT).show();
            firstBackTime = System.currentTimeMillis();

        } else {
            System.exit(0);
        }
    }
	
	public void goOnline(View view) {
	    UserService userService = new UserService(getApplication());
	    
	    if (userService.isAutoLoginOn()) {
	        String[] userLoginInfo = userService.getUserInfo();
	        NetworkService networkService = new NetworkService(this);
            if (networkService.isConnected()) {
                new LoginInBackground(MainInterfaceActivity.this).execute(userLoginInfo);
            } else {
                Toast.makeText(getApplicationContext(),
                		R.string.connect_to_network, Toast.LENGTH_SHORT)
                        .show();
            }
	    } else {
	        Intent intent = new Intent(this, LoginActivity.class);

            startActivity(intent);
	    }
	    
	}
	
	public void goOffline(View view) {
	    Intent intent = new Intent(this, OffLineActivity.class);
        startActivity(intent);
	}
	
	private class LoginInBackground extends AsyncTaskWithProgressDialog {
        public LoginInBackground(Context progressDialogContext) {
			super(progressDialogContext);
		}

		@Override
        protected String doInBackground2(String... params) {
            UserService userService = new UserService(getApplication());
            return userService.login(params[0], params[1]);
        }

        // onPostExecute displays the results of the AsyncTask.
        @Override
        protected void onPostExecute2(String result) {
            if (result.equals("success")) {
                Intent intent = new Intent(getApplicationContext(),
                        PVPModeActivity.class);
                startActivity(intent);
            } else {
                Intent intent = new Intent(getApplicationContext(),
                        LoginActivity.class);
                startActivity(intent);
            }
        }
    }
}
