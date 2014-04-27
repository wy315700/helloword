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
		
		String insertQuery = "INSERT INTO " + TABLE_NEW_WORD + " (pro_description , pro_ans_a , pro_ans_b , pro_ans_c , pro_ans_d , pro_point , pro_time , pro_type) VALUES (?,?,?,?,?,?,?,?)";
		
		db.beginTransaction();
		try {

			db.execSQL(insertQuery, new Object[]{
					word.pro_description,word.pro_ans_a,word.pro_ans_b,word.pro_ans_c,word.pro_ans_d,word.pro_point,word.pro_time,word.pro_type
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
	
	public boolean delNewWordFromList(int pro_id){
		
		SQLiteDatabase db = helper.getWritableDatabase();
		
		String deleteQuery = "DELETE FROM " + TABLE_NEW_WORD + " WHERE pro_id = ?";
		
		db.beginTransaction();
		try {

			db.execSQL(deleteQuery, new Object[]{
					pro_id
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
				
				word.setPro_id(c.getInt(c.getColumnIndex("pro_id")));
				word.setPro_description(c.getString(c.getColumnIndex("pro_description")));
				word.setPro_ans_a(c.getString(c.getColumnIndex("pro_ans_a")));
				word.setPro_ans_b(c.getString(c.getColumnIndex("pro_ans_b")));
				word.setPro_ans_c(c.getString(c.getColumnIndex("pro_ans_c")));
				word.setPro_ans_d(c.getString(c.getColumnIndex("pro_ans_d")));
				word.setPro_point(c.getInt(c.getColumnIndex("pro_point")));
				word.setPro_time(c.getInt(c.getColumnIndex("pro_time")));
				word.setPro_type(c.getInt(c.getColumnIndex("pro_type")));
				
				
				wordList.add(word);
			}
		}
		finally{
			db.close();
		}
		return wordList;
	}
	
	public NewWord GetNewWordFromListById(int pro_id){
		
		SQLiteDatabase db = helper.getWritableDatabase();
	
		String selectQuery = "SELECT * FROM " + TABLE_NEW_WORD + " WHERE pro_id = ? ";
	
		NewWord word = null;
		try {
			Cursor c = db.rawQuery(selectQuery,new String[]{
					Integer.toString(pro_id)
					});
		
			if(c.moveToFirst()){
			
				word = new NewWord();
				
				word.setPro_id(c.getInt(c.getColumnIndex("pro_id")));
				word.setPro_description(c.getString(c.getColumnIndex("pro_description")));
				word.setPro_ans_a(c.getString(c.getColumnIndex("pro_ans_a")));
				word.setPro_ans_b(c.getString(c.getColumnIndex("pro_ans_b")));
				word.setPro_ans_c(c.getString(c.getColumnIndex("pro_ans_c")));
				word.setPro_ans_d(c.getString(c.getColumnIndex("pro_ans_d")));
				word.setPro_point(c.getInt(c.getColumnIndex("pro_point")));
				word.setPro_time(c.getInt(c.getColumnIndex("pro_time")));
				word.setPro_type(c.getInt(c.getColumnIndex("pro_type")));
			
			}
		}
		finally{
			db.close();
		}
		return word;
	}

}
