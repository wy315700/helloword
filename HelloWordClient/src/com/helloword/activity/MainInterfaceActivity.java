package com.helloword.activity;


import android.app.Activity;
import android.os.Bundle;

import com.helloword.R;

public class MainInterfaceActivity extends Activity {
    
    @Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_interface);
	}
	
	public void goMyScoreActivity() {
	    
	}
	
	public void goMyWordActivity() {
	    
	}
	
	public void goChooseModeActivity() {
//		Intent intent = new Intent(this, ChooseModeActivity.class);
//		startActivity(intent);
	}
	public void goMycardActivity(){
//		Intent intent = new Intent(this, MyCardActivity.class);
//		startActivity(intent);
	}
	
	
}
