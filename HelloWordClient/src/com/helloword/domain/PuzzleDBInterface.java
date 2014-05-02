package com.helloword.domain;

import java.util.List;
import android.content.Context;
import com.helloword.database.NewWordManager;
import com.helloword.gsonObject.PKPuzzles;

/****
 * 数据库操作的间接层
 * @author bone-lee
 *
 */
public class PuzzleDBInterface {
	private NewWordManager wordMan;
	
	public PuzzleDBInterface(Context context){
    	this.wordMan = new NewWordManager(context);
	}
	
	public void savePuzzleToDB(PKPuzzles puzzles,int questionLibType){
		saveToDB(extractWord(puzzles, questionLibType));
	}
	
    private void saveToDB(NewWord word){
    	//man.recreateNewWordTable();
    	wordMan.addNewWordToList(word);
    }
    
    public List<NewWord> getAllWordsFromDB(){
    	final int MAX_DB_ROW_CNT=999999;
    	List<NewWord> words = wordMan.ListNewWordFromList(0,MAX_DB_ROW_CNT);    	
    	//Debug
    	/*
    	Log.i("**************************", "%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
    	Iterator<NewWord> iter = words.iterator();
    	while(iter.hasNext()){
    		Log.i("DATA CHECK",iter.next().toString());
    	}
    	Log.i("**************************", "%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
    	*/
    	return words;
    }
    
    private NewWord extractWord(final PKPuzzles puzzles,int questionLibType){
    	 String rightAnswer = puzzles.getAns();
         int point=Integer.parseInt(puzzles.getPoint());
         int time=Integer.parseInt(puzzles.getTime());
         if (rightAnswer.equalsIgnoreCase(puzzles.getAns1())) {
        	 return new NewWord(puzzles.getDescription(), 
             		puzzles.getAns1(),        		
             		puzzles.getAns2(),
             		puzzles.getAns3(),
             		puzzles.getAns4(),
             		point,
             		time,
             		questionLibType);
         } else if (rightAnswer.equalsIgnoreCase(puzzles.getAns2())) {
        	 return new NewWord(puzzles.getDescription(), 
              		puzzles.getAns2(),
              		puzzles.getAns1(),        		
              		puzzles.getAns3(),
              		puzzles.getAns4(),
             		point,
             		time,
             		questionLibType);
         } else if (rightAnswer.equalsIgnoreCase(puzzles.getAns3())) {
        	 return new NewWord(puzzles.getDescription(), 
              		puzzles.getAns3(),
              		puzzles.getAns1(),        		
              		puzzles.getAns2(),
              		puzzles.getAns4(),
              		point,
              		time,
              		questionLibType);
         } else {
        	 return new NewWord(puzzles.getDescription(), 
              		puzzles.getAns4(),
              		puzzles.getAns1(),        		
              		puzzles.getAns2(),
              		puzzles.getAns3(),
              		point,
              		time,
              		questionLibType);
         }
    }

	public void removeWordById(int pro_id) {
		wordMan.delNewWordFromList(pro_id);
	}
}
