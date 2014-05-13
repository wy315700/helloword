package com.helloword.activity;

import com.helloword.R;

import android.os.Bundle;
import android.app.TabActivity;
import android.content.Intent;
import android.graphics.Color;
import android.view.View;
import android.widget.TabHost;
import android.widget.TabHost.OnTabChangeListener;
import android.widget.TabWidget;
import android.widget.TextView;

@SuppressWarnings("deprecation")
public class PVPRankActivity extends TabActivity{
	private TabWidget tabWidget;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_pvp_rank);
		
		final TabHost tabHost = getTabHost();
		
		TabHost.TabSpec spec;
		Intent intent;
		
		intent = new Intent().setClass(this, PVPRankTotalActivity.class);
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
		
		tabHost.setCurrentTab(0);
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
}
