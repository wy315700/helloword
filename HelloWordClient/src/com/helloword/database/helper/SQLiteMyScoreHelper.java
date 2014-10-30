package com.helloword.database.helper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;


public class SQLiteMyScoreHelper extends SQLiteOpenHelper{
	
	private static String Table_name = "Tablescore";
	private static String Database_name = "score.db";
	private static int version = 1;
	
	public SQLiteMyScoreHelper(Context context, String name, CursorFactory factory, 
			
			int version){		
		super(context, name, factory, version);
	}
	
	public SQLiteMyScoreHelper(Context context){
		super(context, Database_name, null, version);
	}
	
	
	
	public void onCreate(SQLiteDatabase db){
		String sql = "create table if not exists " + Table_name +
				"(" +
				"_id INTEGER PRIMARY KEY," + 
				"username varchar(30) default null," +
				"score int(5) default 0" +
				");";
		Log.d("table",sql);
		db.execSQL(sql);		
	}
	
	public void onUpgrade(SQLiteDatabase db, int oldversion, int newversion){
				
	}
}