package com.helloword.util;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public  class DBHelper extends SQLiteOpenHelper{

	private final static int version = 1;
	private final static String dbName = "userinfo.db";
	
	public DBHelper(Context context) {
		super(context, dbName, null, version);
	}
	@Override
	public void onCreate(SQLiteDatabase db) {
		String sql = "create table user(userid integer primary key autoincrement,username varchar(30) not null,userpwd varchar(30) not null,useremail varchar(50))";
		db.execSQL(sql);
	}
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		
	}
	
}
