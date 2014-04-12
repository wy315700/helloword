package com.helloword.activity;


import java.util.ArrayList;
import java.util.List;

import com.helloword.R;
import com.helloword.gsonObject.PKPuzzles;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class PVCGameActivity extends BaseActivity{
	
	private TextView word;
	private TextView userName;
	private TextView answerNum; 
	private TextView resultPop;
	
    private Button buttonA;
    private Button buttonB;
    private Button buttonC;
    private Button buttonD;
    private Button rightButton;
    private Button nextWord;
    private Button lastWord;
    
    private ProgressBar scoreProgress;
    private ImageView message;
    private RelativeLayout puzzleArea;
    
    private int rightId;
    private int score;
    private int puzzleNum;
    
    private Typeface typeFace;
    Handler handler=new Handler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pvc_game);
        
        word=(TextView)findViewById(R.id.pvc_game_word);
        userName=(TextView)findViewById(R.id.pvc_game_user_name);
        answerNum=(TextView)findViewById(R.id.pvc_game_answer_progress);
        resultPop = (TextView) findViewById(R.id.pvc_game_result);
        
        buttonA=(Button)findViewById(R.id.pvc_game_btnA);
        buttonB=(Button)findViewById(R.id.pvc_game_btnB);
        buttonC=(Button)findViewById(R.id.pvc_game_btnC);
        buttonD=(Button)findViewById(R.id.pvc_game_btnD);
        nextWord=(Button)findViewById(R.id.pvc_game_nextword);
        lastWord=(Button)findViewById(R.id.pvc_game_lastword);
        
        puzzleArea=(RelativeLayout) findViewById(R.id.pvc_game_puzzle_area);
        puzzleNum=1;
        
        typeFace= Typeface.createFromAsset(getAssets(),"fonts/maobi.ttf");
        userName.setTypeface(typeFace);
        answerNum.setTypeface(typeFace);
        
        buttonA.setOnClickListener(answerListener);
        buttonB.setOnClickListener(answerListener);
        buttonC.setOnClickListener(answerListener);
        buttonD.setOnClickListener(answerListener);
        
        nextWord.setOnClickListener(nextListener);
        lastWord.setOnClickListener(lastListener);
        
     // ========fake users for test========
        userName.setText("江小鱼");
        displayFraction(answerNum, puzzleNum);
        setPuzzles();
    }
    
    View.OnClickListener answerListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId() - rightId) {
            case 0:
                displayGoodResult();
                break;
            default:
                displayBadResult();
            }
        }
    };
    
    View.OnClickListener nextListener=new View.OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			if(puzzleNum<3){
				rightButton.setBackgroundResource(R.drawable.blue_button);
				resultPop.setText("");
				setPuzzles();
				puzzleNum++;
				displayFraction(answerNum, puzzleNum);
			}
			else{
				handler.post(new Runnable(){

					@Override
					public void run() {
						// TODO Auto-generated method stub
						goPVCEnd();
					}
					
				});
			}
		}
	};
	
	View.OnClickListener lastListener=new View.OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			setPuzzles();
		}
	};
    public void setPuzzles() {
        // ========fake puzzles for test========
    	rightId = R.id.pvc_game_btnA;
    	rightButton = (Button) findViewById(R.id.pvc_game_btnA);
    	
    	word.setText("Morning");
        buttonA.setText("A. " + "早上");
        buttonB.setText("B. " + "晚上");
        buttonC.setText("C. " + "中午");
        buttonD.setText("D. " + "凌晨");
    }
    public void displayGoodResult() {
    	resultPop.setText("Good!");
    	AnimationListener animEnd = new AnimationListener() {
            @Override
            public void onAnimationEnd(Animation animation) {
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            }

            @Override
            public void onAnimationStart(Animation animation) {
            }
        };
        fadeIn(resultPop, 500, animEnd);
    }
    
    public void displayBadResult() {
    	resultPop.setText("Bad!");
        rightButton.setBackgroundResource(R.drawable.button_answer);
    	AnimationListener animEnd = new AnimationListener() {
            @Override
            public void onAnimationEnd(Animation animation) {
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            }

            @Override
            public void onAnimationStart(Animation animation) {
            }
        };
        fadeIn(resultPop, 500, animEnd);
    }
    
    public void displayFraction(TextView scoreText, int score) {
        if (score >= 0)
            scoreText.setText(score + " / 20");
    }
    
    public void goPVCEnd() {
        Intent intent = new Intent(this, PVCEndActivity.class);
        startActivity(intent);
        finish();
    }
}
