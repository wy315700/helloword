package com.helloword.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.helloword.R;

public class OnLineActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_online);
    }
    
    public void getBack(View view) {
        onBackPressed();
    }
    
    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this, MainInterfaceActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
        finish();
    }
    
   
}
