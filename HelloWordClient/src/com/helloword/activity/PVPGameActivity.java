package com.helloword.activity;

import java.util.Timer;
import java.util.TimerTask;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.helloword.R;

public class PVPGameActivity extends BaseActivity {
    
    TextView word;
    Button buttonA;
    Button buttonB;
    Button buttonC;
    Button buttonD;
    TextView puzzleNo;
    TextView userLeftName;
    TextView userRightName;
    ProgressBar timeProgress;
    ImageView message;
    TextView showResult;
    Button rightButton;
    int rightId;
    
    Handler mHandler = new Handler();
    int mTimeProgress = 0;
    
    final int TIME_LIMIT = 10000; // milliseconds

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pvp_game);
        
        word = (TextView) findViewById(R.id.pvp_game_word);
        buttonA = (Button) findViewById(R.id.pvp_game_btnA);
        buttonB = (Button) findViewById(R.id.pvp_game_btnB);
        buttonC = (Button) findViewById(R.id.pvp_game_btnC);
        buttonD = (Button) findViewById(R.id.pvp_game_btnD);
        puzzleNo = (TextView) findViewById(R.id.pvp_game_puzzleno);
        userLeftName = (TextView) findViewById(R.id.pvp_game_userleft_name);
        userRightName = (TextView) findViewById(R.id.pvp_game_userright_name);
        timeProgress = (ProgressBar) findViewById(R.id.pvp_game_time_progress);
        message = (ImageView) findViewById(R.id.pvp_game_message);
        showResult = (TextView) findViewById(R.id.pvp_game_result);
        
        // message animation
        message.setBackgroundResource(R.drawable.message_anime);
        AnimationDrawable messageAnime = (AnimationDrawable) message.getBackground();
        messageAnime.start();
        
        initPlayers();
        initPuzzles();
        countDownTime();
        
       
        buttonA.setOnClickListener(answerListener);
        buttonB.setOnClickListener(answerListener);
        buttonC.setOnClickListener(answerListener);
        buttonD.setOnClickListener(answerListener);
        
    }

    public void initPlayers() {
        userLeftName.setText("万花");
        userRightName.setText("藏剑");
    }
    
    public void initPuzzles() {
        
        // set puzzles
        // TODO replace with the real puzzles
        word.setText("Hello");
        // TODO justify font size with option length
        buttonA.setText("A. " + "你好");
        buttonB.setText("B. " + "你不好");
        buttonC.setText("C. " + "早上好");
        buttonD.setText("D. " + "晚安");
        puzzleNo.setText("1");
        
        //set right answer
        String rightAnswer = "a";
        switch (rightAnswer.compareTo("a")) {
            case 0:
                rightId = R.id.pvp_game_btnA;
                rightButton = (Button) findViewById(R.id.pvp_game_btnA);
                break;
            case 1:
                rightId = R.id.pvp_game_btnB;
                rightButton = (Button) findViewById(R.id.pvp_game_btnB);
                break;
            case 2:
                rightId = R.id.pvp_game_btnC;
                rightButton = (Button) findViewById(R.id.pvp_game_btnC);
                break;
            case 3:
                rightId = R.id.pvp_game_btnD;
                rightButton = (Button) findViewById(R.id.pvp_game_btnD);
                break;
        }
        
    }
    
    public void countDownTime() {
        final Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            public void run() {
                mTimeProgress++;
                mHandler.post(new Runnable() {
                    public void run() {
                        if (mTimeProgress >= 100) timer.cancel();
                        timeProgress.setProgress(mTimeProgress);
                    }
                });
            }
        }, TIME_LIMIT / 100, TIME_LIMIT / 100);
        
    }
    
    public void showGoodResult() {
        showResult.setText("Good!");
        showResult.setVisibility(View.VISIBLE);
    }
    
    public void showBadResult() {
        showResult.setText("Bad!");
        showResult.setVisibility(View.VISIBLE);
    }
    
    // Listen the answer pressed and respond accordingly
    View.OnClickListener answerListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId() - rightId) {
                case 0:
                    showGoodResult();
                    break;
                default:
                    showBadResult();
                    rightButton.setBackgroundResource(R.drawable.button_answer);
                    
            }
        }
    };
    
    // the crossfade animation of puzzles
    public void showPuzzles () {
        
    }
    
    public void fadePuzzles() {
        
    }

}
