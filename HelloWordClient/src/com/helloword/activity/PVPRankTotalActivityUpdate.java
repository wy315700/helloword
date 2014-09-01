package com.helloword.activity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.helloword.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.AdapterView.OnItemClickListener;

public class PVPRankTotalActivityUpdate extends Activity{

	
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
		 
		 ListView gridView = (ListView) findViewById(R.id.pvp_rank_total_list);
	   
	        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
			for (int i = 0; i < photo_resIds.length; i++) {
				Map<String, Object> cell = new HashMap<String, Object>();
				cell.put("imageview", photo_resIds[i]);
				cell.put("title",Level[i]);
				list.add(cell);
			}
			SimpleAdapter simpleAdapter = new SimpleAdapter(PVPRankTotalActivityUpdate.this,
					(List<Map<String, Object>>)list, R.drawable.rankcell, new String[] { "imageview","title" },
					new int[] { R.id.ItemCell, R.id.ItemTitle});
			gridView.setAdapter(simpleAdapter);
	//		gridView.setOnItemClickListener(itemClick);
		}
		
/*		public OnItemClickListener itemClick = new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position,
					long id) {
	//			photo_choose_rid=photo_resIds[position];
	//			photo_id = Integer.toString(position+1);
	//			imageView.setImageResource(photo_resIds[position]);
			}
		};*/
}
