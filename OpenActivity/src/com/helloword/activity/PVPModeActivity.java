package com.helloword.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.helloword.R;

public class PVPModeActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pvp_mode);
    }

    public void goPVPGame(View view) {
        Intent intent = new Intent(this, PVPGameActivity.class);
        startActivity(intent);
    }

}
