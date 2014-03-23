package com.helloword.activity;

import java.util.Timer;
import java.util.TimerTask;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.helloword.R;

public class PVPGameActivity extends BaseActivity implements AnimationListener{
    
    TextView word;
    Button buttonA;
    Button buttonB;
    Button buttonC;
    Button buttonD;
    TextView puzzleNo;
    TextView userLeftName;
    TextView userRightName;
    ProgressBar timeProgress;
    ProgressBar userrightScore;
    ProgressBar userleftScore;
    ImageView message;
    ImageView icpuzzleNo;
    ImageView bomb;
    ImageView blast;
    ImageView egg;
    ImageView flower;
    TextView showResult;
    Button rightButton;
    TextView overWait;
    TextView overScore;
    TextView overRank;
    Button shareButton;
    Button exchangeButton;
    Button seerankButton;
    Button gcontinueButton;
    int rightId;
    
    Handler mHandler = new Handler();
    QuestionThread questionThread;
    int mTimeProgress = 0;
    int progressbarState = 0;
    int temprightScore=10;
    int templeftScore=10;
    int tempquestionNo=1;
    int tempshowResult=1;
    boolean tempisBomb=false;
    boolean tempisEgg=false;
    boolean tempisRound=true;
    
	private AnimationDrawable animationBomb;
	private AnimationDrawable animationBlast;
	private AnimationDrawable animationEgg;
	private AnimationDrawable animationFlower;
	private Animation plus2Animation;
	private Animation plus5Animation;
	private Animation winAnimation;
	private Animation overRankAnimation;
    
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
        userrightScore = (ProgressBar) findViewById(R.id.pvp_game_userright_score);
        userleftScore = (ProgressBar) findViewById(R.id.pvp_game_userleft_score);
        message = (ImageView) findViewById(R.id.pvp_game_message);
        showResult = (TextView) findViewById(R.id.pvp_game_result);
        icpuzzleNo = (ImageView) findViewById(R.id.pvp_game_icpuzzleno);
        bomb = (ImageView) findViewById(R.id.pvp_game_bomb);
        blast = (ImageView) findViewById(R.id.pvp_game_blast);
        egg = (ImageView) findViewById(R.id.pvp_game_egg);
        flower = (ImageView) findViewById(R.id.pvp_game_flower);
        plus2Animation =AnimationUtils.loadAnimation(this, R.anim.finalplus);
        plus5Animation =AnimationUtils.loadAnimation(this, R.anim.finalplus);
        winAnimation =AnimationUtils.loadAnimation(this, R.anim.finalplus);
        overRankAnimation =AnimationUtils.loadAnimation(this, R.anim.finalrank);
        plus2Animation.setAnimationListener(this);
        plus5Animation.setAnimationListener(this);
        winAnimation.setAnimationListener(this);
        overRankAnimation.setAnimationListener(this);
        overWait = (TextView) findViewById(R.id.pvp_game_overwait);
        overScore = (TextView) findViewById(R.id.pvp_game_overscore);
        overRank = (TextView) findViewById(R.id.pvp_game_overrank);
        
        shareButton = (Button) findViewById(R.id.pvp_game_share);
        exchangeButton = (Button) findViewById(R.id.pvp_game_exchange);
        seerankButton = (Button) findViewById(R.id.pvp_game_seerank);
        gcontinueButton = (Button) findViewById(R.id.pvp_game_continue);
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
        shareButton.setOnClickListener(new OnClickListener() {  
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
			}  
        });
        exchangeButton.setOnClickListener(new OnClickListener() {  
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
			}  
        });
        seerankButton.setOnClickListener(new OnClickListener() {  
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
			}  
        });
        gcontinueButton.setOnClickListener(new OnClickListener() {  
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
			}  
        });
        
        questionThread = new QuestionThread();
        questionThread.start();
        
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
        showResult.setVisibility(View.INVISIBLE);//每次答题时都不显示对或错
        puzzleNo.setText("1");
        icpuzzleNo.startAnimation(getRotateAnimation(-360, 0, 1000));
        
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
                mTimeProgress+=2;//5秒倒计时
                mHandler.post(new Runnable() {
                    public void run() {
                    	if(progressbarState==0){
                    		if(mTimeProgress==20){
                    			puzzleNo.setText("2");
                    			icpuzzleNo.startAnimation(getRotateAnimation(-360, 0, 500));
                    		}
                    		else if(mTimeProgress==40){
                    			puzzleNo.setText("3");
                    			icpuzzleNo.startAnimation(getRotateAnimation(-360, 0, 500));
                    		}
                    		else if(mTimeProgress==60){
                    			puzzleNo.setText("4");
                    			icpuzzleNo.startAnimation(getRotateAnimation(-360, 0, 500));
                    		}
                    		else if(mTimeProgress==80){
                    			puzzleNo.setText("5");
                    			icpuzzleNo.startAnimation(getRotateAnimation(-360, 0, 500));
                    		}
                    		else if (mTimeProgress >= 100) {
                    			showBadResult();
                                rightButton.setBackgroundResource(R.drawable.button_answer);
                                //炸弹题没答要爆炸
                        		if(tempisBomb){
                        			animationBomb = (AnimationDrawable) bomb.getDrawable();
                        			animationBomb.stop();
                        			bomb.setVisibility(View.INVISIBLE);
                    	        	animationBlast = (AnimationDrawable) blast.getDrawable();
                    				blast.setVisibility(View.VISIBLE);
                    				animationBlast.stop();
                    				animationBlast.start();
                    				tempisBomb=false;
                        		}
                        		//彩蛋题没答没有奖励
                        		if(tempisEgg){
                        			animationEgg = (AnimationDrawable) egg.getDrawable();
                        			animationEgg.stop();
                        			egg.setVisibility(View.INVISIBLE);
                        			tempisEgg=false;
                        		}
                    			progressbarState=1;
                    		}
                    	}
                        if(progressbarState==1){
                        	timer.cancel();
                        	timeProgress.setVisibility(View.INVISIBLE);//点击或计时结束后进度条消失
                        	puzzleNo.setVisibility(View.INVISIBLE);//计时数字消失
                        	icpuzzleNo.setVisibility(View.INVISIBLE);
                        }
                        else
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
        	if(progressbarState==0&&tempisRound){
        		switch (view.getId() - rightId) {
                	case 0:{
                		progressbarState=1;
                		templeftScore+=4;
                		userleftScore.setProgress(templeftScore>100?100:templeftScore);
                		showGoodResult();
                		//炸弹题答对了危机解除
                		if(tempisBomb){
                			animationBomb = (AnimationDrawable) bomb.getDrawable();
                			animationBomb.stop();
                			bomb.setVisibility(View.INVISIBLE);
                			tempisBomb=false;
                		}
                		//彩蛋题答对了金花四溅
                		if(tempisEgg){
                			animationEgg = (AnimationDrawable) egg.getDrawable();
                			animationEgg.stop();
                			egg.setVisibility(View.INVISIBLE);
            	        	animationFlower = (AnimationDrawable) flower.getDrawable();
            				flower.setVisibility(View.VISIBLE);
            				animationFlower.stop();
            				animationFlower.start();
            				tempisEgg=false;
                		}
                		break;
                	}
                	default:{
                		progressbarState=1;
                		templeftScore-=4;
                		userleftScore.setProgress(templeftScore<0?0:templeftScore);
                		showBadResult();
                		rightButton.setBackgroundResource(R.drawable.button_answer);
                		//是炸弹题需要爆炸
                		if(tempisBomb){
                			animationBomb = (AnimationDrawable) bomb.getDrawable();
                			animationBomb.stop();
                			bomb.setVisibility(View.INVISIBLE);
            	        	animationBlast = (AnimationDrawable) blast.getDrawable();
            				blast.setVisibility(View.VISIBLE);
            				animationBlast.stop();
            				animationBlast.start();
            				tempisBomb=false;
                		}
                		//彩蛋题答错了没有奖励
                		if(tempisEgg){
                			animationEgg = (AnimationDrawable) egg.getDrawable();
                			animationEgg.stop();
                			egg.setVisibility(View.INVISIBLE);
                			tempisEgg=false;
                		}
                	}                
        		}
        		//答完一轮后
        	}
        }
    };
    
    //旋转动画
	public static Animation getRotateAnimation(float fromDegrees,  
            float toDegrees, int durationMillis) {  
        RotateAnimation rotate = new RotateAnimation(fromDegrees, toDegrees,  
                Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF,  
                0.5f);  
        rotate.setDuration(durationMillis);  
        rotate.setFillAfter(true);  
        return rotate;  
    }
	
	//线程用于刷新题目
	private class QuestionThread extends Thread{
		public void run(){
			while(true){
				if(progressbarState==1){
					try{
						Thread.sleep(2000);
					}catch(InterruptedException e){  
						// TODO Auto-generated catch block  
					e.printStackTrace();  
					} //显示答案暂停2秒
	        		if(tempquestionNo==6){
	        			mHandler.post(showRoundResult);
	        			progressbarState=0;
	        			tempisRound=false;
	        		}
	        		else{
	        			progressbarState=0;
	        			mTimeProgress=0;
	        			mHandler.post(questionUi);
	        			mHandler.post(runnableBackground);
	        		}
				}
			}
		}
	}
	
	//刷新UI中button,时间
	Runnable runnableBackground = new Runnable(){  
		@Override  
		public void run(){  
	        buttonA.setBackgroundResource(R.drawable.button_unpressed);
	        buttonB.setBackgroundResource(R.drawable.button_unpressed);
	        buttonC.setBackgroundResource(R.drawable.button_unpressed);
	        buttonD.setBackgroundResource(R.drawable.button_unpressed);
	        puzzleNo.setText("1");
	        timeProgress.setVisibility(View.VISIBLE);//点击或计时结束后进度条消失
        	puzzleNo.setVisibility(View.VISIBLE);//计时数字消失
        	icpuzzleNo.setVisibility(View.VISIBLE);
	        countDownTime();
			}
	};  
		
	//刷新题目
	Runnable questionUi=new Runnable(){
		@Override
		public void run() {
			// TODO Auto-generated method stub
			tempquestionNo++;
			word.setText("Morning");
	        // TODO justify font size with option length
	        buttonA.setText("A. " + "早");
	        buttonB.setText("B. " + "晚");
	        buttonC.setText("C. " + "早上好");
	        buttonD.setText("D. " + "晚上好");
	        showResult.setVisibility(View.INVISIBLE);//每次答题时都不显示对或错
	        puzzleNo.setText("1");
	        icpuzzleNo.startAnimation(getRotateAnimation(-360, 0, 1000));
	        
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
	        //如果是炸弹题需要显示炸弹
	        if(tempquestionNo%2==0&&tempquestionNo%3!=0){
	        	tempisBomb=true;
	        	animationBomb = (AnimationDrawable) bomb.getDrawable();
				bomb.setVisibility(View.VISIBLE);
				animationBomb.start();
	        }
	        //如果是彩蛋题要显示彩蛋
	        if(tempquestionNo%3==0&&tempquestionNo%2!=0){
	        	tempisEgg=true;
	        	animationEgg = (AnimationDrawable) egg.getDrawable();
	        	egg.setVisibility(View.VISIBLE);
				animationEgg.start();
	        }
		}
		
	};
	
	Runnable showRoundResult= new Runnable(){
		@Override
		public void run() {
			// TODO Auto-generated method stub
			//先使得北京的一些内容不可见
			buttonA.setVisibility(View.INVISIBLE);
			buttonB.setVisibility(View.INVISIBLE);
			buttonC.setVisibility(View.INVISIBLE);
			buttonD.setVisibility(View.INVISIBLE);
			puzzleNo.setVisibility(View.INVISIBLE);
			showResult.setVisibility(View.INVISIBLE);
			word.setVisibility(View.INVISIBLE);
			icpuzzleNo.setVisibility(View.INVISIBLE);
			
			String text="恭喜，您已经完成本轮答题"+'\n'+'\n'+"用时152秒，获得时间积分加成+2";
			overWait.setText(text);
			overWait.setVisibility(View.VISIBLE);
	    	ImageView plus2 = (ImageView) findViewById(R.id.pvp_game_plus2);
	    	plus2.startAnimation(plus2Animation);
	    	tempshowResult=2;
		}		
	};
	@Override
	public void onAnimationEnd(Animation arg0) {
		// TODO Auto-generated method stub
		while(tempshowResult==1);
		if(tempshowResult==2){
			overWait.setVisibility(View.INVISIBLE);
			String text="江小鱼共获得29分，花儿共获得26分"+'\n'+'\n'+"江小鱼获胜！获得胜利积分加成+5";
			overScore.setText(text);
			overScore.setVisibility(View.VISIBLE);
			ImageView plus5 = (ImageView) findViewById(R.id.pvp_game_plus5);
			plus5.startAnimation(plus5Animation);
			tempshowResult=3;//可以显示胜
		}
		else if(tempshowResult==3){
			ImageView win = (ImageView) findViewById(R.id.pvp_game_win);
			win.startAnimation(winAnimation);
			tempshowResult=4;
		}
		else if(tempshowResult==4){
			overScore.setVisibility(View.INVISIBLE);
			String text="世界排名+23,当前世界排名第12位!";
			overRank.setText(text);
			overRank.setVisibility(View.VISIBLE);
			
		    shareButton.setVisibility(View.VISIBLE);
		    exchangeButton.setVisibility(View.VISIBLE);
		    seerankButton.setVisibility(View.VISIBLE);
		    gcontinueButton.setVisibility(View.VISIBLE);
		    shareButton.startAnimation(overRankAnimation);
		    exchangeButton.startAnimation(overRankAnimation);
		    seerankButton.startAnimation(overRankAnimation);
		    gcontinueButton.startAnimation(overRankAnimation);
			tempshowResult=1;
		}
	}

	@Override
	public void onAnimationRepeat(Animation arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onAnimationStart(Animation arg0) {
		// TODO Auto-generated method stub
		
	}

}
