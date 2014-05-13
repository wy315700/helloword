package com.helloword.activity;

import com.helloword.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.TextView;

public class PVPRankMeActivity extends Activity{
	private HorizontalListView hListView;
	private HorizontalListViewAdapter hListViewAdapter;
	private TextView rankme_text;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		 super.onCreate(savedInstanceState);
		 setContentView(R.layout.activity_pvp_rank_me);
		 
		 rankme_text=(TextView)findViewById(R.id.pvp_rank_me_text);
		 hListView = (HorizontalListView)findViewById(R.id.pvp_rank_me_horizon_listview);
			String[] titles = {"凌波微步", "水上漂", "闭关", "花木兰", "慕蓉", "哥白尼"};
			final int[] ids = {R.drawable.ic_photo1, R.drawable.ic_photo2,
					R.drawable.ic_photo3, R.drawable.ic_photo4,
					R.drawable.ic_photo5, R.drawable.ic_photo6};
			final String[] ids_text={"怀师        第1名       总分：23432",
					                 "南怀瑾军校       第2名      总分：23423",
					                 "闭关       第3名      总分：234234",
					                 "花木兰       第4名        总分：234234",
					                 "慕容        第5名        总分：234234",
					                 "哥白尼        第6名       总分：576534"};
			hListViewAdapter = new HorizontalListViewAdapter(getApplicationContext(),titles,ids);
			hListView.setAdapter(hListViewAdapter);
			hListView.setOnItemClickListener(new OnItemClickListener() {
				@Override
				public void onItemClick(AdapterView<?> parent, View view,
						int position, long id) {
					rankme_text.setText(ids_text[position]);
					hListViewAdapter.setSelectIndex(position);
					hListViewAdapter.notifyDataSetChanged();				
				}
			});
	}
}
