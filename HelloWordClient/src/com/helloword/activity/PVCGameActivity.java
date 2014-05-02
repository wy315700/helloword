package com.helloword.activity;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import com.helloword.R;
import com.helloword.domain.PuzzleDBInterface;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.helloword.domain.NewWord;
import com.helloword.util.RandomUtil;

public class PVCGameActivity extends BaseActivity {

	public static final String REMOVED_WORD_CNT = "REMOVED_WORD_CNT";
	private int puzzlesCntPerRound = 20;
	private static final int ANIMATION_TIME = 1500;
	private TextView word;
	private TextView userName;
	private TextView puzzleNumTextView;
	private TextView resultPop;

	private Button buttonA;
	private Button buttonB;
	private Button buttonC;
	private Button buttonD;
	private Button rightButton;

	private Button nextWord;
	private Button lastWord;

	private int rightId;
	private int puzzleNum;

	private Typeface typeFace;
	Handler handler = new Handler();

	private PuzzleDBInterface puzzleDBInterface;
	private List<NewWord> wordsList;
	private ProgressBar progressBar;
	private HashSet<NewWord> wordRemoveSet=new HashSet<NewWord>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_pvc_game);
		puzzleDBInterface = new PuzzleDBInterface(getApplicationContext());
		wordsList = puzzleDBInterface.getAllWordsFromDB();
		if(wordsList.size()==0){
    		Toast.makeText(getApplicationContext(), R.string.no_words_list_in_db, Toast.LENGTH_SHORT).show();
			Intent intent = new Intent(this, OffLineActivity.class);
	        startActivity(intent);
	        finish();
	        return;
		}
		
		//进度设置
		progressBar=(ProgressBar) findViewById(R.id.pvc_game_progressbar);
		
		word = (TextView) findViewById(R.id.pvc_game_word);
		userName = (TextView) findViewById(R.id.pvc_game_user_name);
		puzzleNumTextView = (TextView) findViewById(R.id.pvc_game_answer_progress);
		resultPop = (TextView) findViewById(R.id.pvc_game_result);

		buttonA = (Button) findViewById(R.id.pvc_game_btnA);
		buttonB = (Button) findViewById(R.id.pvc_game_btnB);
		buttonC = (Button) findViewById(R.id.pvc_game_btnC);
		buttonD = (Button) findViewById(R.id.pvc_game_btnD);
		nextWord = (Button) findViewById(R.id.pvc_game_nextword);
		lastWord = (Button) findViewById(R.id.pvc_game_lastword);

		//puzzleArea = (RelativeLayout) findViewById(R.id.pvc_game_puzzle_area);

		typeFace = Typeface.createFromAsset(getAssets(), "fonts/maobi.ttf");
		userName.setTypeface(typeFace);
		puzzleNumTextView.setTypeface(typeFace);

		buttonA.setOnClickListener(answerListener);
		buttonB.setOnClickListener(answerListener);
		buttonC.setOnClickListener(answerListener);
		buttonD.setOnClickListener(answerListener);

		nextWord.setOnClickListener(nextListener);
		lastWord.setOnClickListener(lastListener);

		// ========fake users for test========
		// FIXME
		userName.setText("江小鱼");//TODO add user information to DB

		final int MAX_PUZZLE_PER_ROUND = 20;
		puzzlesCntPerRound = wordsList.size() < MAX_PUZZLE_PER_ROUND ? (wordsList
				.size()) : (MAX_PUZZLE_PER_ROUND);	
		puzzleNum = 1;
		preparePuzzles();
		resetOptionButton();
		updateProgress();
	}

	View.OnClickListener answerListener = new View.OnClickListener() {
		@Override
		public void onClick(View view) {
			switch (view.getId() - rightId) {
			case 0:
				displayResult("Good!");
				addWordToRemoveSet();
				break;
			default:
				displayResult("Bad!");
			}
		}
	};

	View.OnClickListener nextListener = new View.OnClickListener() {

		@Override
		public void onClick(View v) {
			if (puzzleNum < puzzlesCntPerRound) {
				resultPop.setText("");
				puzzleNum++;
				preparePuzzles();
				resetOptionButton();
				updateProgress();
			} else {
				handler.post(new Runnable() {
					@Override
					public void run() {
						goPVCEnd();
					}
				});
			}
		}
	};

	View.OnClickListener lastListener = new View.OnClickListener() {

		@Override
		public void onClick(View v) {
			if (puzzleNum > 1) {
				resultPop.setText("");
				puzzleNum--;
				preparePuzzles();
				resetOptionButton();
				updateProgress();
			} else {
				Toast.makeText(getApplicationContext(), R.string.nothing_tips,
						Toast.LENGTH_SHORT).show();
			}
		}
	};

	private void resetOptionButton() {
		buttonA.setBackgroundResource(R.drawable.blue_button);
		buttonB.setBackgroundResource(R.drawable.blue_button);
		buttonC.setBackgroundResource(R.drawable.blue_button);
		buttonD.setBackgroundResource(R.drawable.blue_button);
	}

	protected void addWordToRemoveSet() {
		NewWord word=wordsList.get(puzzleNum-1);
		if(!wordRemoveSet.contains(word)){
			Log.i("ADD_TO_REMOVE_SET",word.getPro_description());
			Log.i("HASH_KEY",""+word.hashCode());
			wordRemoveSet.add(word);		
		}
	}

	protected int removeWordFromDB() {
		for(Iterator<NewWord> it=wordRemoveSet.iterator();it.hasNext();){
			NewWord word=it.next();
			Log.i("REMOVE_FROM_DB",word.getPro_description());
			puzzleDBInterface.removeWordById(word.getPro_id());
		}
		return wordRemoveSet.size();
	}

	public void preparePuzzles() {
		//每次的题目乱序输出，这样用户体验更好
		if(puzzleNum>=1 && puzzleNum<=wordsList.size()){
			NewWord puzzle = wordsList.get(puzzleNum-1);
			word.setText(puzzle.getPro_description());
			String[] option={puzzle.getPro_ans_a(),puzzle.getPro_ans_b(),puzzle.getPro_ans_c(),puzzle.getPro_ans_d()};
			int[] shuffle=RandomUtil.shuffle4();
			for(int i=0;i<4;++i){
				if(shuffle[i]==0){
					switch (i) {
					case 0:
						rightButton = buttonA;
						break;
					case 1:
						rightButton = buttonB;
						break;
					case 2:
						rightButton = buttonC;
						break;
					case 3:
						rightButton = buttonD;
						break;
					default:
						break;
					}
				}
			}
			rightId=rightButton.getId();
			buttonA.setText("A. " + option[shuffle[0]]);
			buttonB.setText("B. " + option[shuffle[1]]);
			buttonC.setText("C. " + option[shuffle[2]]);
			buttonD.setText("D. " + option[shuffle[3]]);
		}
	}

	public void displayResult(String goodOrBad) {
		resultPop.setText(goodOrBad);
		rightButton.setBackgroundResource(R.drawable.button_answer);
		AnimationListener animEnd = new AnimationListener() {
			@Override
			public void onAnimationEnd(Animation animation) {
				resultPop.setText("");
			}

			@Override
			public void onAnimationRepeat(Animation animation) {
			}

			@Override
			public void onAnimationStart(Animation animation) {
			}
		};
		fadeIn(resultPop, ANIMATION_TIME, animEnd);
	}

	public void updateProgress() {
		if (puzzleNum >= 1){
			puzzleNumTextView.setText(puzzleNum + " / " + puzzlesCntPerRound);
			progressBar.setMax(puzzlesCntPerRound-1);
			progressBar.setProgress(puzzleNum-1);
		}
	}

	public void goPVCEnd() {
		int removedWordCnt=removeWordFromDB();
		Intent intent = new Intent(this, PVCEndActivity.class);
		intent.putExtra(REMOVED_WORD_CNT, removedWordCnt);
		startActivity(intent);
		finish();
	}
}
