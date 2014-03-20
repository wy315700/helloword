package com.helloword.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.helloword.R;

public class OnLineActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_online);
    }
    
   
    
    public void goPVE(View view) {
        Toast.makeText(this, "UI not available yet", Toast.LENGTH_SHORT).show();
    }
    
    public void goPVP(View view) {
        Intent intent = new Intent(this, PVPModeActivity.class);
        startActivity(intent);
    }
    
    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this, MainInterfaceActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
        finish();
    }
    
}
