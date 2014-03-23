package com.helloword.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.helloword.R;

public class PVPModeActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pvp_mode);
    }

    /*public void goPVPGame(View view) {
        Intent intent = new Intent(this, PVPGameActivity.class);
        startActivity(intent);
    }*/
    public void goChooseBook(View view) {
    Intent intent = new Intent(this, PVPBook.class);
    startActivity(intent);
    }
    
    public void clickBoy(View view) {
    Button ic_boy=(Button)findViewById(R.id.pvp_mode_boy);
    ic_boy.setBackgroundResource(R.drawable.ic_boy_light);
    }
    
    public void clickGirl(View view) {
    Button ic_girl=(Button)findViewById(R.id.pvp_mode_girl);
    ic_girl.setBackgroundResource(R.drawable.ic_girl_light);
    }
}
