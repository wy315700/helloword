package com.helloword.activity;

import com.helloword.R;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


public class PVPBook extends BaseActivity{
	//TextView finduser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pvp_book);
        
        //finduser=(TextView)findViewById(R.id.pvp_game_load_finduser);
    }
    public void goPVPLoad(View view) {
    	Intent intent = new Intent(this, PVPLoadActivity.class);
        startActivity(intent);
    }
    
    /*public void goPVPLoad_cet4(View view) {
    	finduser.setText("四级对战！正在为你匹配对手…");
    	Intent intent = new Intent(this, PVPLoadActivity.class);
        startActivity(intent);
    }
    public void goPVPLoad_toefl(View view) {
    	finduser.setText("托福对战！正在为你匹配对手…");
    	Intent intent = new Intent(this, PVPLoadActivity.class);
        startActivity(intent);
    }
    public void goPVPLoad_cet6(View view) {
    	finduser.setText("六级对战！正在为你匹配对手…");
    	Intent intent = new Intent(this, PVPLoadActivity.class);
        startActivity(intent);
    }
    public void goPVPLoad_gre(View view) {
    	finduser.setText("gre对战！正在为你匹配对手…");
    	Intent intent = new Intent(this, PVPLoadActivity.class);
        startActivity(intent);
    }
    public void goPVPLoad_ielts(View view) {
    	finduser.setText("雅思对战！正在为你匹配对手…");
    	Intent intent = new Intent(this, PVPLoadActivity.class);
        startActivity(intent);
    }
    public void goPVPLoad_more(View view) {
    	finduser.setText("更多对战！正在为你匹配对手…");
    	Intent intent = new Intent(this, PVPLoadActivity.class);
        startActivity(intent);
    }*/
}
