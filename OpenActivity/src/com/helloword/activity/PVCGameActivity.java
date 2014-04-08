package com.helloword.activity;

import com.helloword.R;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PVCGameActivity extends BaseActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pvc_game);
    }
    
    public void changeStarState(View view){
    	Button star=(Button)findViewById(R.id.pvc_game_star);
    	star.setBackgroundResource(R.drawable.btn_star_pres);
    }
}
