package com.helloword.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.helloword.R;

public class OffLineActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_offline);
       
    }
    
    public void goPVCGame(View view) {
		Intent intent = new Intent(this, PVCGameActivity.class);
		startActivity(intent);
		finish();
	}
    
}
