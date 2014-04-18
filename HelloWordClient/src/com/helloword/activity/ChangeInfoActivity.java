package com.helloword.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.helloword.R;

public class ChangeInfoActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_info);
    }
    
    public void goChangePhoto(View view) {
        Intent intent = new Intent(this, ChangePhotoActivity.class);
        startActivity(intent);
                
    }

    
}
