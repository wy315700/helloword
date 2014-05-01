package com.helloword.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.helloword.R;
import com.helloword.domain.QuestionLibType;
import com.helloword.service.GameService;
import com.helloword.service.NetworkService;

public class PVPModeActivity extends BaseActivity {
    public static final String USER_CHOOSED_QUESTION_LIB_TYPE = "USER_CHOOSED_QUESTION_LIB_TYPE";
	private NetworkService networkService;
	private QuestionLibType choosedQuestionLibType;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pvp_mode);
        
        networkService = new NetworkService(this);
    }

    public void goPickPlayer() {
        Intent intent = new Intent(this, PVPGameActivity.class);
        intent.putExtra(USER_CHOOSED_QUESTION_LIB_TYPE, choosedQuestionLibType.getTypeID());
        startActivity(intent);
    }
    
    public void goChangeInfo(View view) {
        Intent intent = new Intent(this, ChangeInfoActivity.class);
        startActivity(intent);
    }

    public void goCet4PK(View view) {
    	choosedQuestionLibType=QuestionLibType.CET4;
    	BeginPK(QuestionLibType.CET4);
    }
    
    public void goCet6PK(View view) {
    	choosedQuestionLibType=QuestionLibType.CET6;
    	BeginPK(QuestionLibType.CET6);
    }

    public void goIeltsPK(View view) {
    	choosedQuestionLibType=QuestionLibType.IELTS;
    	BeginPK(QuestionLibType.IELTS);
    }

    public void goToeflPK(View view) {
    	choosedQuestionLibType=QuestionLibType.TOEFL;
    	BeginPK(QuestionLibType.TOEFL);
    }

    public void goGrePK(View view) {
    	choosedQuestionLibType=QuestionLibType.GRE;
    	BeginPK(QuestionLibType.GRE);
    }
    
    public void goMorePK(View view) {
        Toast.makeText(getApplicationContext(), R.string.more_question_lib, Toast.LENGTH_SHORT)
                .show();
    }
    
	private void BeginPK(QuestionLibType questionLibType) {
		if (networkService.isConnected()) {
			new GetPKGamesInBackground(PVPModeActivity.this).execute(questionLibType.toString());
		} else {
			Toast.makeText(getApplicationContext(),
					R.string.connect_to_network, Toast.LENGTH_SHORT).show();
		}
	}
   
    private class GetPKGamesInBackground extends AsyncTaskWithProgressDialog{
    	
    	public GetPKGamesInBackground(Context progressDialogContext) {
			super(progressDialogContext);
		}

        @Override
        protected String doInBackground2(String... params) {
        	GameService gameService = new GameService(getApplication());
            return gameService.getPKPuzzles(params[0]);
        }

        // onPostExecute displays the results of the AsyncTask.
        @Override
        protected void onPostExecute2(String result) {
            if (result.equals("success")) {
                goPickPlayer();
            } else {
                Toast.makeText(getApplicationContext(), result,
                        Toast.LENGTH_SHORT).show();
            }
        }
    }

}
