package com.helloword.database.helper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class SQLiteHelper extends SQLiteOpenHelper {
	
	private static final String DATABASE_NAME = "halloword.db"; //数据库名
	private static final int DATABASE_VERSION = 2;
	
	private static final String TABLE_NEW_WORD = "new_word";//生词表
	
	private static final String CREATE_TABLE_NEW_WORD = "CREATE TABLE " + TABLE_NEW_WORD + 
					"(" +
					 "pro_id INTEGER AUTO_INCREMENT,"+
					 "pro_description varchar(50) DEFAULT NULL,"+
					 "pro_ans_a varchar(10) DEFAULT NULL,"+
					 "pro_ans_b varchar(10) DEFAULT NULL,"+
					 "pro_ans_c varchar(10) DEFAULT NULL,"+
					 "pro_ans_d varchar(10) DEFAULT NULL,"+
					 "pro_point tinyint(4) DEFAULT '5',"+
					 "pro_time tinyint(4) DEFAULT '5',"+
					 "pro_type tinyint(4) DEFAULT '0',"+
					 "PRIMARY KEY (`pro_id`)"+
					") ";
	
	
	public SQLiteHelper(Context context, String name, CursorFactory factory,
			int version) {
		super(context, name, factory, version);
		// TODO Auto-generated constructor stub
	}

	/**
	 * 用于创建数据库,没有则创建,有则返回(不会进行升级操作)
	 */
	public SQLiteHelper(Context context) {
		this(context, DATABASE_NAME, null, DATABASE_VERSION);
	}
	
	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		db.execSQL(CREATE_TABLE_NEW_WORD);
	}
	
	/**
	 * 升级数据库使用.需要指定的新的版本号
	 */
	public SQLiteHelper(Context context,int version) {
		this(context, DATABASE_NAME, null, version);
	}

	/**
	 * 升级数据库
	 */
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
	
	}
}
