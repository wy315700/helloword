package com.helloword.activity;

import java.util.Timer;
import java.util.TimerTask;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.helloword.R;

public class PVPLoadActivity extends BaseActivity{
	ProgressBar waitforLoad;
	Handler mHandler = new Handler();
	final int TIME_LIMIT = 10000; 
	int mTimeProgress = 0;
	boolean ready=false;
	
	ImageView user;
	TextView username;
	TextView loadgame;
	TextView finduser;
	 protected void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.activity_pvp_load);
	        
	        
	        waitforLoad = (ProgressBar) findViewById(R.id.pvp_load_progress);
	        user=(ImageView)findViewById(R.id.pvp_game_load_user2);
	        username=(TextView)findViewById(R.id.pvp_game_load_user2name);
	        loadgame=(TextView)findViewById(R.id.pvp_game_load_loadgame);
	        finduser=(TextView)findViewById(R.id.pvp_game_load_finduser);
	        final Timer timer1 = new Timer();
	        timer1.schedule(new TimerTask(){

				@Override
				public void run() {
					// TODO Auto-generated method stub
					mTimeProgress+=2;
					waitforLoad .setProgress(mTimeProgress);
					if(!ready&&mTimeProgress >= 100){
						mHandler.post(show);
						mTimeProgress=0;
						ready=true;
					}
					if(ready&&mTimeProgress >= 100){
						this.cancel();
						goPVPGame();
					}
				}
	        	
	        }, TIME_LIMIT / 100, TIME_LIMIT / 100);
	    }
	 public void goPVPGame() {
	        Intent intent = new Intent(this, PVPGameActivity.class);
	        startActivity(intent);
	    }
	 
		Runnable show= new Runnable(){
			@Override
			public void run() {
				// TODO Auto-generated method stub
				finduser.setVisibility(View.INVISIBLE);
				user.setVisibility(View.VISIBLE);
				username.setVisibility(View.VISIBLE);
				loadgame.setVisibility(View.VISIBLE);
			}		
		};
}
