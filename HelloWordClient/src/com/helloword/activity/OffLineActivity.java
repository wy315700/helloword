package com.helloword.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.helloword.R;

public class OffLineActivity extends BaseActivity {

	private MyProgressDialog myProgressDialog;
	private boolean isReady=false;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_offline);
       
        myProgressDialog = new MyProgressDialog(OffLineActivity.this);
    }

    public void goPVCGame(View view) {
    	myProgressDialog.initDialog();
    	while(isReady){
    		if (myProgressDialog.isShowing()) {
    			myProgressDialog.closeDialog();
    		}
    		Intent intent = new Intent(this, PVCGameActivity.class);
    		startActivity(intent);
    		finish();
    	}
	}

}
