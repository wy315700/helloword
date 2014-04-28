package com.helloword.activity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.helloword.R;
import com.helloword.service.GameService;
import com.helloword.service.NetworkService;

public class PVPModeActivity extends BaseActivity {
    private NetworkService networkService;

    private MyProgressDialog myProgressDialog;
	private boolean isReady=false;
    /**
     * 题库标识
     * @author bone-lee
     *
     */
    private enum QuestionLibType{
        CET4("1"), CET6("3"), GRE("5"),IELTS("7"),TOEFL("9");
        private String typeID;

        private QuestionLibType(String typeID) {
            this.typeID=typeID;
        }

        @Override
        public String toString() {
            return typeID;
        } 
    }
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pvp_mode);
        
        networkService = new NetworkService(this);
        myProgressDialog = new MyProgressDialog(PVPModeActivity.this);
    }

    public void goPickPlayer() {
        Intent intent = new Intent(this, PVPGameActivity.class);
        startActivity(intent);
    }
    
    public void goChangeInfo(View view) {
        Intent intent = new Intent(this, ChangeInfoActivity.class);
        startActivity(intent);
    }

    public void goCet4PK(View view) {
    	 BeginPK(QuestionLibType.CET4);
    }
    
    public void goCet6PK(View view) {
    	BeginPK(QuestionLibType.CET6);
    }

    public void goIeltsPK(View view) {
    	BeginPK(QuestionLibType.IELTS);
    }

    public void goToeflPK(View view) {
    	BeginPK(QuestionLibType.TOEFL);
    }

    public void goGrePK(View view) {
    	BeginPK(QuestionLibType.GRE);
    }
    
    public void goMorePK(View view) {
        Toast.makeText(getApplicationContext(), R.string.more_question_lib, Toast.LENGTH_SHORT)
                .show();
    }
    
    private void BeginPK(QuestionLibType questionLibType){
    	myProgressDialog.initDialog();
    	while(isReady){
    			if (networkService.isConnected()) {
    				new GetPKGamesInBackground().execute(questionLibType.toString());
    			} else {
    				Toast.makeText(getApplicationContext(),
            		R.string.connect_to_network, Toast.LENGTH_SHORT)
                    .show();
    			}
    	}
    }
    
    private class GetPKGamesInBackground extends
            AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... params) {
            GameService gameService = new GameService(getApplication());
            return gameService.getPKPuzzles(params[0]);
        }

        // onPostExecute displays the results of the AsyncTask.
        @Override
        protected void onPostExecute(String result) {
            if (result.equals("success")) {
                goPickPlayer();
            } else {
                Toast.makeText(getApplicationContext(), result,
                        Toast.LENGTH_SHORT).show();
            }
        }
    }

}
