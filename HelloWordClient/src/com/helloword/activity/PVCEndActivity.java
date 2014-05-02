package com.helloword.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import com.helloword.R;

public class PVCEndActivity extends BaseActivity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_pvc_end);
		int removedWordCnt = getIntent().getExtras().getInt(
				PVCGameActivity.REMOVED_WORD_CNT);
		TextView wordCntTextView = (TextView) findViewById(R.id.pvc_end_s);
		wordCntTextView.setText(String.format(
				getResources().getString(R.string.pvcend_sentence),
				removedWordCnt));
		Button nextRunBtn = (Button) findViewById(R.id.pvc_end_continue);
		nextRunBtn.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				Intent intent = new Intent(PVCEndActivity.this, PVCGameActivity.class);
				startActivity(intent);
				PVCEndActivity.this.finish();
			}
		});
	}
}
