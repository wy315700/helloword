package com.helloword.activity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.helloword.R;
import com.helloword.domain.QuestionLibType;
import com.helloword.service.GameService;
import com.helloword.service.NetworkService;
import com.helloword.util.UsersApplication;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class PVPRankTotalActivityUpdate1 extends Activity{
	
	private UsersApplication user;
	private int[] photo_resIds = {R.drawable.ic_photo1, R.drawable.ic_photo2,
			R.drawable.ic_photo3, R.drawable.ic_photo4,
			R.drawable.ic_photo5, R.drawable.ic_photo6,
			R.drawable.ic_photo7, R.drawable.ic_photo8,
			R.drawable.ic_photo9, R.drawable.ic_photo10};
	private String[] Level = {"first","second","third","four","five","six",
			"seven","eight","nine","ten"};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		 super.onCreate(savedInstanceState);
		 setContentView(R.layout.activity_pvp_rank_total_update);
		 user = (UsersApplication) getApplication();
		 
		 ListView gridView = (ListView) findViewById(R.id.pvp_rank_total_list);
	   
	       /* List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
			for (int i = 0; i < 10; i++) {
				Map<String, Object> cell = new HashMap<String, Object>();
				cell.put("imageview", photo_resIds[i]);
				String rankString = user.getuserRank() +
						". " +"得分：" + user.getTotalScore();
				cell.put("title",rankString);
				list.add(cell);
			}
			SimpleAdapter simpleAdapter = new SimpleAdapter(PVPRankTotalActivityUpdate.this,
					(List<Map<String, Object>>)list, R.drawable.rankcell, new String[] { "imageview","title" },
					new int[] { R.id.ItemCell, R.id.ItemTitle});
			gridView.setAdapter(simpleAdapter);*/
		 
		 List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
			for (int i = 0; i < 10; i++) {
				Map<String, Object> cell = new HashMap<String, Object>();
				cell.put("rankId", i+1);
				String rankString = "孙悟空";
				cell.put("rankName",rankString);
				cell.put("rankScore", 10000);
				list.add(cell);
			}
			SimpleAdapter simpleAdapter = new SimpleAdapter(PVPRankTotalActivityUpdate1.this,
					(List<Map<String, Object>>)list, R.drawable.rankcell1, new String[] { "rankId","rankName","rankScore" },
					new int[] { R.id.RankId, R.id.RankName, R.id.RankScore});
			gridView.setAdapter(simpleAdapter);
		}
}
