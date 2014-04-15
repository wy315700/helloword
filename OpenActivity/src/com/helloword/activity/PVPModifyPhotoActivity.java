package com.helloword.activity;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.SimpleAdapter;
import android.widget.AdapterView.OnItemClickListener;

import com.helloword.R;

public class PVPModifyPhotoActivity extends BaseActivity{
	
	private ImageView imageView;
	int photo_choose_rid=-1;
	private int[] photo_resIds = new int[] { R.drawable.photo_girl1, R.drawable.photo_girl2,
			R.drawable.photo_girl3, R.drawable.photo_girl4, R.drawable.photo_girl5, R.drawable.photo_girl6,
			R.drawable.photo_girl7, R.drawable.photo_boy1, R.drawable.photo_boy2, R.drawable.photo_boy3,R.drawable.photo_boy4,
			R.drawable.photo_boy5,R.drawable.photo_boy6,R.drawable.photo_boy7};
	
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pvp_modify_photo);
        
        GridView gridView = (GridView) findViewById(R.id.pvp_modify_photo_gridview);
        imageView = (ImageView) findViewById(R.id.pvp_modify_photo_image);
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		for (int i = 0; i < photo_resIds.length; i++) {
			Map<String, Object> cell = new HashMap<String, Object>();
			cell.put("imageview", photo_resIds[i]);
			list.add(cell);
		}
		SimpleAdapter simpleAdapter = new SimpleAdapter(PVPModifyPhotoActivity.this,
				list, R.drawable.cell, new String[] { "imageview" },
				new int[] { R.id.ivCell });
		gridView.setAdapter(simpleAdapter);
		gridView.setOnItemClickListener(itemClick);
	}
	
	private OnItemClickListener itemClick = new OnItemClickListener() {

		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position,
				long id) {
			// TODO Auto-generated method stub
			photo_choose_rid=photo_resIds[position];
			imageView.setImageResource(photo_resIds[position]);
		}
	};
	
	public void goPVPModify(View view){
		Intent intent = new Intent(this, PVPModifyActivity.class);
		intent.putExtra("photo_choose",photo_choose_rid);
		setResult(1001, intent);
        finish();
	}
}
