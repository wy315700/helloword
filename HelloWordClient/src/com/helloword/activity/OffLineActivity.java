package com.helloword.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import com.helloword.R;

public class OffLineActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_offline);
       
    }

    public void getBack(View view) {
        onBackPressed();
    }

}
