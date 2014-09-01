package com.helloword.activity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.SimpleAdapter;

import com.helloword.R;

public class PVPModifyPhotoActivity extends Activity{
	 
	private ImageView imageView;
	public final static int RESULT_CODE=1;
	private int photo_choose_rid=1;
	private String  photo_id = "1";
	
	private int[] photo_resIds = {R.drawable.ic_photo1, R.drawable.ic_photo2,
			R.drawable.ic_photo3, R.drawable.ic_photo4,
			R.drawable.ic_photo5, R.drawable.ic_photo6,
			R.drawable.ic_photo7, R.drawable.ic_photo8,
			R.drawable.ic_photo9, R.drawable.ic_photo10};
	
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pvp_modify_photo);
        
        Intent intent=getIntent();  
        Bundle bundle=intent.getExtras();  
        String str=bundle.getString("userAvatarString");
        photo_id = str;

        
        GridView gridView = (GridView) findViewById(R.id.pvp_modify_photo_gridview);
        imageView = (ImageView) findViewById(R.id.pvp_modify_photo_image);
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		for (int i = 0; i < photo_resIds.length; i++) {
			Map<String, Object> cell = new HashMap<String, Object>();
			cell.put("imageview", photo_resIds[i]);
			list.add(cell);
		}
		SimpleAdapter simpleAdapter = new SimpleAdapter(PVPModifyPhotoActivity.this,
				(List<Map<String, Object>>)list, R.drawable.cell, new String[] { "imageview" },
				new int[] { R.id.ivCell });
		gridView.setAdapter(simpleAdapter);
		gridView.setOnItemClickListener(itemClick);
	}
	
	public OnItemClickListener itemClick = new OnItemClickListener() {

		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position,
				long id) {
			photo_choose_rid=photo_resIds[position];
			photo_id = Integer.toString(position+1);
			imageView.setImageResource(photo_resIds[position]);
		}
	};
	
	public void goPVPModify(View view){
	      
 	    Intent intent=new Intent(this, ChangeInfoActivity.class);  
        intent.putExtra("photo_id", Integer.toString(photo_choose_rid)); 
        intent.putExtra("photo_avatar", photo_id);
        setResult(RESULT_CODE, intent);  
        finish();
        
        
	//}		
}
	
}
