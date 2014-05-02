package com.helloword.activity;

import java.util.Iterator;
import java.util.List;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.helloword.R;
import com.helloword.database.NewWordManager;
import com.helloword.database.beans.NewWord;

public class OffLineActivity extends BaseActivity {

	//private MyProgressDialog myProgressDialog;
	//private boolean isReady=false;
	private TextView offlineLeftword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_offline);
        offlineLeftword=(TextView) findViewById(R.id.offline_leftword);
        List<NewWord> wordsList=getAllWordsInDB(getApplicationContext());
        offlineLeftword.setText(String.format(getResources().getString(R.string.remaining_words_cnt),wordsList.size()));
    }

    public void goPVCGame(View view) {
    	//myProgressDialog.initDialog();
    	//while(isReady){
    		//if (myProgressDialog.isShowing()) {
    		//	myProgressDialog.closeDialog();
    		//}
    		Intent intent = new Intent(this, PVCGameActivity.class);
    		startActivity(intent);
    		finish();
    		//listWords(getApplicationContext());
    	//}
	}
    
    private List<NewWord> getAllWordsInDB(Context context){
    	NewWordManager man = new NewWordManager(context);
    	List<NewWord> words = man.ListNewWordFromList(0,100);    	
    	//Debug
    	Log.i("**************************", "%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
    	Iterator<NewWord> iter = words.iterator();
    	while(iter.hasNext()){
    		Log.i("DATA CHECK",iter.next().toString());
    	}
    	Log.i("**************************", "%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
    	return words;
    }
}
