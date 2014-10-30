package com.helloword.database;

import java.util.List;
import java.util.ArrayList;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.helloword.database.helper.SQLiteMyScoreHelper;

public class MyScoreManager{
	
	private SQLiteMyScoreHelper helper;
	private static String Table_name = "Tablescore";
	
	public MyScoreManager(Context context){
		helper = new SQLiteMyScoreHelper(context);
	}
	
	public boolean AddScore(String username, int score){
		SQLiteDatabase db = helper.getWritableDatabase();
		String addSQLnew = "insert into " + Table_name + " (username, score) values(?,?)";
		db.beginTransaction();
		try{
			db.execSQL(addSQLnew, new Object[]{username ,score});
			db.setTransactionSuccessful();
		}
		finally{
			db.endTransaction();
			db.close();
		}
		return true;
	}
	
	//delete all score
	public boolean DeleteMyScore(String username){
		SQLiteDatabase db = helper.getWritableDatabase();
		String DeleteSQLnew = "delete from " + Table_name;
		db.beginTransaction();
		try{
			db.execSQL(DeleteSQLnew);
			db.setTransactionSuccessful();
		}
		finally{
			db.endTransaction();
			db.close();
		}
		return true;
		
	}
	
	public List<Integer> QuerySQL(String username){
        
		SQLiteDatabase db = helper.getWritableDatabase();
		List<Integer> scoreAll = new ArrayList<Integer>();
		Cursor cur = null;
		try{
			cur = db.query(Table_name, new String[]{"score"},
					"username=?",new String[]{username},null,null,"score desc");
			int score = 0;
			while(cur.moveToNext()){
				score = cur.getInt(0);
				scoreAll.add(score);
			//	Log.d("score",Integer.toString(score));
			}
		}
		catch(Exception e){
			
		}
		finally{
			cur.close();
			db.close();
		}
		
		return scoreAll;
	}
	
}