package com.helloword.activity;

import android.app.Activity;
import android.view.View;

public abstract class BaseActivity extends Activity {

    
    
    
    
    
    public void getBack(View view) {
        onBackPressed();
    }
    
}
