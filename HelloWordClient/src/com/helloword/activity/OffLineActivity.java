package com.helloword.activity;

import java.util.List;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.helloword.R;
import com.helloword.domain.NewWord;
import com.helloword.domain.PuzzleDBInterface;

public class OffLineActivity extends BaseActivity {
	private TextView offlineLeftword;
	private PuzzleDBInterface puzzleDBInterface;
	
	private List<NewWord> wordsList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_offline);
        puzzleDBInterface=new PuzzleDBInterface(getApplicationContext());
        
        offlineLeftword=(TextView) findViewById(R.id.offline_leftword);
        wordsList=puzzleDBInterface.getAllWordsFromDB();
        offlineLeftword.setText(String.format(getResources().getString(R.string.remaining_words_cnt),wordsList.size()));
    }

    public void goPVCGame(View view) {
    	if(wordsList.size()>0){
    		Intent intent = new Intent(this, PVCGameActivity.class);
    		startActivity(intent);
    		finish();
    	}else{
    		Toast.makeText(getApplicationContext(), R.string.no_words_list_in_db, Toast.LENGTH_SHORT).show();
    	}
	}
}
