package com.helloword.database;

import java.util.ArrayList;
import java.util.List;

import com.helloword.database.beans.NewWord;
import com.helloword.database.helper.SQLiteHelper;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class NewWordManager {
	private SQLiteHelper helper;
	private static final String TABLE_NEW_WORD = "new_word";//生词表
	

	public NewWordManager(Context context) {
		helper = new SQLiteHelper(context);
	}
	
	/**
	 * 为升级数据库而用
	 */
	public NewWordManager(Context ctx,int version){
		helper = new SQLiteHelper(ctx,version); 
	}
	
	public boolean addNewWordToList(NewWord word){
		
		SQLiteDatabase db = helper.getWritableDatabase();
		
		String insertQuery = "INSERT INTO " + TABLE_NEW_WORD + " (word_id, word_content , word_meaning , word_type ) VALUES (?,?,?,?)";
		
		db.beginTransaction();
		try {

			db.execSQL(insertQuery, new Object[]{
					word.word_id, word.word_content,word.word_meaning,word.word_type
					}
				);
			db.setTransactionSuccessful();
		}
		finally{
			db.endTransaction();
			db.close();
		}
		return true;
	}
	
	public boolean delNewWordFromList(int word_id){
		
		SQLiteDatabase db = helper.getWritableDatabase();
		
		String deleteQuery = "DELETE FROM " + TABLE_NEW_WORD + " WHERE word_id = ?";
		
		db.beginTransaction();
		try {

			db.execSQL(deleteQuery, new Object[]{
					word_id
					}
				);
			db.setTransactionSuccessful();
		}
		finally{
			db.endTransaction();
			db.close();
		}
		return true;
	}
	
	public boolean delAllNewWordFromList(){
		
		SQLiteDatabase db = helper.getWritableDatabase();
		
		String deleteQuery = "DELETE FROM " + TABLE_NEW_WORD;
		
		db.beginTransaction();
		try {

			db.execSQL(deleteQuery);
			db.setTransactionSuccessful();
		}
		finally{
			db.endTransaction();
			db.close();
		}
		return true;
	}

	public List<NewWord> ListNewWordFromList(int start, int end){
	
		SQLiteDatabase db = helper.getWritableDatabase();
	
		String selectQuery = "SELECT * FROM " + TABLE_NEW_WORD + " LIMIT " + start + "," + end;
	
		List<NewWord> wordList = new ArrayList<NewWord>();
		try {
			Cursor c = db.rawQuery(selectQuery,null);
		
			while(c.moveToNext()){
			
				NewWord word = new NewWord();
				word.setWord_id(c.getInt(c.getColumnIndex("word_id")));
				word.setWord_content(c.getString(c.getColumnIndex("word_content")));
				word.setWord_meaning(c.getString(c.getColumnIndex("word_meaning")));
				word.setWord_type(c.getInt(c.getColumnIndex("word_type")));
			
				wordList.add(word);
			}
		}
		finally{
			db.close();
		}
		return wordList;
	}
	
	public NewWord GetNewWordFromListById(int word_id){
		
		SQLiteDatabase db = helper.getWritableDatabase();
	
		String selectQuery = "SELECT * FROM " + TABLE_NEW_WORD + " WHERE word_id = ? ";
	
		NewWord word = null;
		try {
			Cursor c = db.rawQuery(selectQuery,new String[]{
					Integer.toString(word_id)
					});
		
			if(c.moveToFirst()){
			
				word = new NewWord();
				word.setWord_id(c.getInt(c.getColumnIndex("word_id")));
				word.setWord_content(c.getString(c.getColumnIndex("word_content")));
				word.setWord_meaning(c.getString(c.getColumnIndex("word_meaning")));
				word.setWord_type(c.getInt(c.getColumnIndex("word_type")));
			
			}
		}
		finally{
			db.close();
		}
		return word;
	}

}
