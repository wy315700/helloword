package com.helloword.activity;

import java.util.Iterator;
import java.util.Timer;
import java.util.TimerTask;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.helloword.R;
import com.helloword.database.NewWordManager;
import com.helloword.database.beans.NewWord;
import com.helloword.domain.QuestionLibType;
import com.helloword.domain.PuzzleToDB;
import com.helloword.gsonObject.PKPuzzles;
import com.helloword.gsonObject.Puzzles;
import com.helloword.util.UsersApplication;

public class PVPGameActivity extends BaseActivity {
    final int TIME_LIMIT = 10000; // milliseconds

    private UsersApplication user;
    private Iterator<PKPuzzles> iterator;

    private TextView word;
    private TextView userLeftName;
    private TextView userRightName;
    private TextView fractionLeft;
    private TextView fractionRight;
    private TextView puzzleNo;
    private TextView resultPop;

    private Button buttonA;
    private Button buttonB;
    private Button buttonC;
    private Button buttonD;
    private Button rightButton;

    private ProgressBar timeProgress;
    private ProgressBar scoreLeftProgress;
    private ProgressBar scoreRightProgress;

    private ImageView message;
    private RelativeLayout puzzleArea;

    private int rightId;
    private int scoreLeft;
    private int scoreRight;
    private int puzzleNum;
    private int intTimeProgress;

    Handler handler;
    Animator animStack;

	private int userChoosedQuestionLibType = QuestionLibType.CET4.getTypeID();
    private PKPuzzles currentPuzzle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pvp_game);

        user = (UsersApplication) getApplication();

        word = (TextView) findViewById(R.id.pvp_game_word);
        userLeftName = (TextView) findViewById(R.id.pvp_game_userleft_name);
        userRightName = (TextView) findViewById(R.id.pvp_game_userright_name);
        puzzleNo = (TextView) findViewById(R.id.pvp_game_puzzleno);
        resultPop = (TextView) findViewById(R.id.pvp_game_result);
        fractionLeft = (TextView) findViewById(R.id.pvp_game_userleft_fraction);
        fractionRight = (TextView) findViewById(R.id.pvp_game_userright_fraction);

        buttonA = (Button) findViewById(R.id.pvp_game_btnA);
        buttonB = (Button) findViewById(R.id.pvp_game_btnB);
        buttonC = (Button) findViewById(R.id.pvp_game_btnC);
        buttonD = (Button) findViewById(R.id.pvp_game_btnD);

        timeProgress = (ProgressBar) findViewById(R.id.pvp_game_time_progress);
        scoreLeftProgress = (ProgressBar) findViewById(R.id.pvp_game_userleft_score);
        scoreRightProgress = (ProgressBar) findViewById(R.id.pvp_game_userright_score);

        message = (ImageView) findViewById(R.id.pvp_game_message);
        puzzleArea = (RelativeLayout) findViewById(R.id.pvp_game_puzzle_area);

        puzzleNum = 1;
        scoreLeft = 0;
        scoreRight = 0;

        // ========fake puzzles for test========
        // List<PKPuzzles> fakePuzzles = new ArrayList<PKPuzzles>();
        // for (int i = 0; i < 20; i++) {
        // PKPuzzles pkPuzzle = new PKPuzzles();
        // pkPuzzle.setDescription("Morning");
        // pkPuzzle.setAns1("早上");
        // pkPuzzle.setAns2("晚上");
        // pkPuzzle.setAns3("中午");
        // pkPuzzle.setAns4("凌晨");
        // pkPuzzle.setAns("a");
        // pkPuzzle.setPoint("2");
        // pkPuzzle.setTime("10");
        // pkPuzzle.setEnemyAns("a");
        // pkPuzzle.setEnemyTime("6");
        // fakePuzzles.add(pkPuzzle);
        // }
        // user.setPKPuzzles(fakePuzzles);
        // =======================================

        // initiate players display
        userLeftName.setText(user.getUserNickname());
        // FIXME replaced with real enemy name
        userRightName.setText("藏剑");
        scoreLeft = 10;
        scoreRight = 10;
        displayFraction(fractionLeft, scoreLeft);
        displayFraction(fractionRight, scoreRight);

        iterator = user.getPKPuzzles().iterator();

        buttonA.setOnClickListener(answerListener);
        buttonB.setOnClickListener(answerListener);
        buttonC.setOnClickListener(answerListener);
        buttonD.setOnClickListener(answerListener);

        //由于需要将用户答错的题存储在数据库，而数据库中需要记录题库类型，所以需要记录用户选择的题库类别
        userChoosedQuestionLibType = getIntent().getExtras().getInt(PVPModeActivity.USER_CHOOSED_QUESTION_LIB_TYPE);
        
        setPuzzles();
    }

    public void setPuzzles() {
        if (puzzleNum > 1) {

            fadeOut(puzzleArea, 500, null);

        }
        if (scoreLeft > 0 && scoreRight > 0 && iterator.hasNext()) {
            PKPuzzles game = new PKPuzzles();
            game = iterator.next();
            currentPuzzle=game;//需要将答错的题目记录到数据库
            if (puzzleNum > 1)
                rightButton.setBackgroundResource(R.drawable.blue_button);
            // set right answer
            String rightAnswer = game.getAns();
            if (rightAnswer.equalsIgnoreCase(game.getAns1())) {
                rightId = R.id.pvp_game_btnA;
                rightButton = (Button) findViewById(R.id.pvp_game_btnA);
            } else if (rightAnswer.equalsIgnoreCase(game.getAns2())) {
                rightId = R.id.pvp_game_btnB;
                rightButton = (Button) findViewById(R.id.pvp_game_btnB);
            } else if (rightAnswer.equalsIgnoreCase(game.getAns3())) {
                rightId = R.id.pvp_game_btnC;
                rightButton = (Button) findViewById(R.id.pvp_game_btnC);
            } else {
                rightId = R.id.pvp_game_btnD;
                rightButton = (Button) findViewById(R.id.pvp_game_btnD);
            }

            word.setText(game.getDescription());
            buttonA.setText("A. " + game.getAns1());
            buttonB.setText("B. " + game.getAns2());
            buttonC.setText("C. " + game.getAns3());
            buttonD.setText("D. " + game.getAns4());

            AnimationListenerAdapter animEnd = new AnimationListenerAdapter() {
                @Override
                public void onAnimationEnd(Animation animation) {
                    fadeOut(resultPop, 500, null);
                }
            };
            if (puzzleNum == 1)
                animEnd = null;
            fadeIn(puzzleArea, 300, animEnd);
            puzzleNo.setText("" + puzzleNum);
            puzzleNum++;
            countDownTime();
        } else {
            // FIXME
            goPVPEnd();
        }
    }

	public void displayFraction(TextView scoreText, int score) {
        if (score >= 0)
            scoreText.setText(score + " / 50");
    }

    public void displayGoodResult() {
        resultPop.setText("Good!");
        AnimationListenerAdapter animEnd = new AnimationListenerAdapter() {
            @Override
            public void onAnimationEnd(Animation animation) {
                setPuzzles();
            }
        };
        fadeIn(resultPop, 500, animEnd);
        scoreLeft += 4;
        displayFraction(fractionLeft, scoreLeft);
        displayScoreProgress(scoreLeftProgress, scoreLeft - 4, scoreLeft, 500);
    }

    public void displayBadResult() {
        resultPop.setText("Bad!");
        rightButton.setBackgroundResource(R.drawable.button_answer);
        AnimationListenerAdapter animEnd = new AnimationListenerAdapter() {
            @Override
            public void onAnimationEnd(Animation animation) {
                setPuzzles();
            }
        };
        fadeIn(resultPop, 500, animEnd);
        scoreLeft -= 2;
        displayFraction(fractionLeft, scoreLeft);
        displayScoreProgress(scoreLeftProgress, scoreLeft + 2, scoreLeft, 500);
    }

    public void displayScoreProgress(ProgressBar progressBar, int start,
            int end, int duration) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
            progressAnim(progressBar, start, end, duration);
        } else {
            progressBar.setProgress(end);
        }
    }

    // Listen the answer pressed and respond accordingly
    View.OnClickListener answerListener = new View.OnClickListener() {

		@Override
        public void onClick(View view) {
            switch (view.getId() - rightId) {
            case 0:
                clearAnim(timeProgress);
                displayGoodResult();
                break;
            default:
                clearAnim(timeProgress);
                displayBadResult();
                //将答错的题目记录到数据库
                new PuzzleToDB(getApplicationContext(),currentPuzzle,userChoosedQuestionLibType).execute();
            }
        }
    };

    @SuppressLint("NewApi")
    public void countDownTime() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
            progressAnim(timeProgress, 0, 100, TIME_LIMIT, 1);
        } else {
            intTimeProgress = 0;
            timeProgress.setProgress(intTimeProgress);

            final Timer timer = new Timer();
            timer.schedule(new TimerTask() {
                public void run() {
                    intTimeProgress++;
                    handler.post(new Runnable() {
                        public void run() {
                            if (intTimeProgress >= 100) {
                                timer.cancel();
                                displayBadResult();
                            }
                            timeProgress.setProgress(intTimeProgress);
                        }
                    });
                }
            }, TIME_LIMIT / 100, TIME_LIMIT / 100);
        }

    }

    public void goPVPEnd() {
        Intent intent = new Intent(this, PVPEndActivity.class);
        startActivity(intent);
        finish();
    }

    // FIXME find a way to solve the param transmission problem
    public void progressAnim(ProgressBar progressBar, int start, int end,
            int durationTime) {
        progressAnim(progressBar, start, end, durationTime, 0);
    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public void progressAnim(ProgressBar progressBar, int start, int end,
            int durationTime, int flag) {
        ObjectAnimator anim = ObjectAnimator.ofInt(progressBar, "progress",
                start, end);

        anim.setDuration(durationTime);
        if (flag == 1) {
            if (puzzleNum > 2 && animStack.isRunning()) {
                animStack.removeAllListeners();
                animStack.cancel();
            }
            animStack = (Animator) anim;
            AnimatorListenerAdapter animEnd = new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    displayBadResult();
                }
            };
            anim.addListener(animEnd);
        }
        anim.start();
        
    }
}
