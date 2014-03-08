package com.helloword.activity;


import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.helloword.R;

public class MainInterfaceActivity extends Activity {
    
    private long firstBackTime;
    
    @Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_interface);
		
		firstBackTime = 0;
	}
    
 // when back-key pressed twice, quit the app
    @Override
    public void onBackPressed() {
        if ((System.currentTimeMillis() - firstBackTime) > 1500) {
            Toast.makeText(this, R.string.toast_quit_app, Toast.LENGTH_SHORT).show();
            firstBackTime = System.currentTimeMillis();

        } else {
            // TODO add cache clean code   
            ActivityManager activityManager = (ActivityManager) this.getSystemService(Context.ACTIVITY_SERVICE);
            activityManager.killBackgroundProcesses(getPackageName());
            finish();
        }
    }
	
	public void goOnline(View view) {
	    boolean autoLogin = false; // ready for the auto log function, value depended on the checker
	    
	    if (!autoLogin) {
	        Intent intent = new Intent(this, LoginActivity.class);
	        startActivity(intent);
	    }
	    // TODO add else and local user file reading
	    
	}
	
	public void goOffline(View view) {
	    Intent intent = new Intent(this, OffLineActivity.class);
        startActivity(intent);
	}
}
