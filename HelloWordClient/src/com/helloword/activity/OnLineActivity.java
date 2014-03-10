package com.helloword.activity;

import android.content.Intent;
import android.os.Bundle;

import com.helloword.R;

public class OnLineActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_online);
    }
    
   
    
    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this, MainInterfaceActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
        finish();
    }
    
   
}
