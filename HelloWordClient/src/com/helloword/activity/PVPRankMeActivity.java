package com.helloword.activity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.helloword.R;
import com.helloword.database.MyScoreManager;
import com.helloword.gsonObject.RankTotal;
import com.helloword.util.UsersApplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.TextView;

public class PVPRankMeActivity extends Activity{
	private String rankStringName;
	private UsersApplication user;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		 super.onCreate(savedInstanceState);
		 setContentView(R.layout.activity_pvp_rank_me_update);
		 user = (UsersApplication) getApplication();
         
		 final int[] ids = {R.drawable.ic_photo1, R.drawable.ic_photo2,
					R.drawable.ic_photo3, R.drawable.ic_photo4,
					R.drawable.ic_photo5, R.drawable.ic_photo6,
					R.drawable.ic_photo7,R.drawable.ic_photo8,
					R.drawable.ic_photo9,R.drawable.ic_photo10,
					R.drawable.ic_photo11,R.drawable.ic_photo12};
						
		 List<Integer> score = new ArrayList<Integer>();
		 score = user.getMyScoreAll();
	/*	 for(int i=0;i<score.size();i++){
			 Log.d("score.add",Integer.toString(score.get(i)));
		 }
	*/		
		 ListView gridView = (ListView) findViewById(R.id.pvp_rank_me_list);
			   
	     List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
/*		 for (int i = 0; i < score.size(); i++) {
				rankString = Integer.toString(i+1) + ". 得分：";
				Map<String, Object> cell = new HashMap<String, Object>();
				cell.put("imageview", ids[Integer.parseInt(user.getUserAvatar())]); 
				cell.put("title",rankString+Integer.toString(score.get(i))+"分");
				list.add(cell);
		 }
				 
			
		 SimpleAdapter simpleAdapter = new SimpleAdapter(PVPRankMeActivity.this,
					(List<Map<String, Object>>)list, R.drawable.rankmecell, 
					new String[] { "imageview","title" },
					new int[] { R.id.ItemCellme, R.id.ItemTitleme});
		 gridView.setAdapter(simpleAdapter);  */
		 
//		 rankStringName = user.getRankTotal().iterator().next().getuserNickname();
// 		 Log.d("Name",rankStringName);
		 
		 Map<String, Object> cellph = new HashMap<String, Object>();
			 cellph.put("rankId", "排名");				
			 cellph.put("rankName","昵称");
			 cellph.put("rankScore","得分");
			 list.add(cellph);		
		 
		 for(int i=0;i<score.size();i++){
			 Map<String, Object> cell = new HashMap<String, Object>();
			 cell.put("rankId", i+1);				
			 cell.put("rankName",user.getUserNickname());
			 cell.put("rankScore",Integer.toString(score.get(i)));
			 list.add(cell);		
		 }
		 
		 
		 SimpleAdapter simpleAdapter = new SimpleAdapter(PVPRankMeActivity.this,
					(List<Map<String, Object>>)list, R.drawable.rankcell1, new String[] { "rankId","rankName","rankScore" },
					new int[] { R.id.RankId, R.id.RankName, R.id.RankScore});
			gridView.setAdapter(simpleAdapter);	
		 
	}
	
}
