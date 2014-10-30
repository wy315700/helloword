package com.helloword.activity;

import java.util.ArrayList;
import java.util.List;

import com.helloword.R;
import com.helloword.database.MyScoreManager;
import com.helloword.service.GameService;
import com.helloword.service.NetworkService;
import com.helloword.util.UsersApplication;

import android.os.Bundle;
import android.app.TabActivity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.util.Log;
import android.view.View;
import android.widget.TabHost;
import android.widget.TabHost.OnTabChangeListener;
import android.widget.TabWidget;
import android.widget.TextView;
import android.widget.Toast;

@SuppressWarnings("deprecation")
public class PVPRankActivity extends TabActivity{
	private TabWidget tabWidget;
	private UsersApplication user;
	private ArrayList<Integer> myScore;
	private MyScoreManager dbManager;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_pvp_rank);
		user = (UsersApplication) getApplication();
//		user.setSessionID("6bbbb014-66ef-4b0e-a8f5-c2627e02198f");
//		PVPRank();
        downMyScoreRecord(user.getUserNickname());
				
		
		final TabHost tabHost = getTabHost();
		
		TabHost.TabSpec spec;
		Intent intent;		
		
		intent = new Intent().setClass(this, PVPRankTotalActivityUpdate.class);
		spec = tabHost
				.newTabSpec("total")
				.setIndicator("总榜排名")
				.setContent(intent);
		tabHost.addTab(spec);	
		
		intent = new Intent().setClass(this, PVPRankMeActivity.class);	
		spec = tabHost
				.newTabSpec("me")
				.setIndicator("我的排名")
				.setContent(intent);
		tabHost.addTab(spec);
		
		tabHost.setCurrentTab(1);
		View v;
		tabWidget = tabHost.getTabWidget();
		for (int i = 0; i < tabWidget.getChildCount(); i++){
			v = tabWidget.getChildAt(i);
			TextView textView = (TextView) v.findViewById(android.R.id.title);
			textView.setTextColor(Color.TRANSPARENT);
			if (i == 0)
				v.setBackgroundResource(R.drawable.tab_rank_total_pres);
			else if (i == 1)
				v.setBackgroundResource(R.drawable.tab_rank_me_unpres);
		}
		tabHost.setOnTabChangedListener(new OnTabChangeListener() {

			public void onTabChanged(String tabId) {
				for (int i = 0; i < tabHost.getTabWidget().getChildCount(); i++) {
					View v = tabHost.getTabWidget().getChildAt(i);
					if(i==0)
						v.setBackgroundResource(R.drawable.tab_rank_total_unpres);
					else if(i==1)
						v.setBackgroundResource(R.drawable.tab_rank_me_unpres);

					if (tabHost.getCurrentTab() == i) {
						if(i==0)
							v.setBackgroundResource(R.drawable.tab_rank_total_pres);
						else if(i==1)
							v.setBackgroundResource(R.drawable.tab_rank_me_pres);
					}
				}
			}
		});
	}
	
	public void downMyScoreRecord(String nickname){		
		MyScoreManager db = new MyScoreManager(getApplication());
		List<Integer> myscorelist = new ArrayList<Integer>();
		myscorelist = db.QuerySQL(nickname);
		user.setMyScoreAll(myscorelist);
	}
	
	
	public void PVPRank(){
		NetworkService networkService = new NetworkService(this);
        if (networkService.isConnected()) {
            new PVPRankTotalInBackground(PVPRankActivity.this).execute();
        } else {
            Toast.makeText(getApplicationContext(),R.string.connect_to_network,
                    Toast.LENGTH_SHORT)
                    .show();
        }				
	}
	
	private class PVPRankTotalInBackground extends AsyncTaskWithProgressDialog {
        public PVPRankTotalInBackground(Context progressDialogContext) {
			super(progressDialogContext);
		}

		@Override
        protected String doInBackground2(String... params) {
            GameService gameService = new GameService(getApplication());
         //   return gameService.getRank();
//            downMyScoreRecord(user.getUserNickname());
            Log.d("nickname",user.getUserNickname());
            String result = gameService.getRank();          
            Log.d("getRank: ", result);
            //Log.d("total:",user.getTotalScore());
            //Log.d("Rank:",user.getuserRank());
            return result;            
        }

        // onPostExecute displays the results of the AsyncTask.
        @Override
        protected void onPostExecute2(String result) {
            if (result.equals("success")) {
            	Toast.makeText(getApplicationContext(), "成功",
                        Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(getApplicationContext(), "失败",
                        Toast.LENGTH_SHORT).show();
            }
        }
    }
	
}
