package com.helloword.service;

import com.helloword.gsonObject.responseProtocol.LoginResponseProtocol;
import com.helloword.httpConnection.HttpLinker;
import com.helloword.protocolTransmission.DeserializeResponse;
import com.helloword.protocolTransmission.SerializeRequest;

/**
 * wrap the function of login, register and logout, etc
 *
 */
public class UserService {

	public boolean login(String userName,String password){
		SerializeRequest request = new SerializeRequest();
		String stringUpload = request.loginRequest(userName, password);
		String httpUrl = "http://halloword.sinaapp.com/user/login.json";
		HttpLinker httpLinker = new HttpLinker();
		String stringDownload = httpLinker.stringPost(httpUrl, stringUpload);
		
		DeserializeResponse response = new DeserializeResponse();
		LoginResponseProtocol loginResponse = response.loginResponse(stringDownload);
		if (loginResponse.getResult().equals("success")) return true;
		else return false;
	}
	
//	public boolean registerName(String userName){
//		SQLiteDatabase sqLiteDatabase = dbHelper.getReadableDatabase();
//		Cursor cursor = sqLiteDatabase.query("user",new String[]{"username"}, 
//				null,null,null,null,null);
//		cursor.moveToFirst();
//		for(int i=0;i<cursor.getCount();i++){
//			String name = cursor.getString(0);
//			if(name.equals(userName)){
//				cursor.close();
//				return false;
//			}
//		}
//		return true;
//	} 
	
//	public boolean register(User user){
//		SQLiteDatabase sqLiteDatabase = dbHelper.getReadableDatabase();
//		String sql = "insert into user(username,userpwd,useremail) values(?,?,?)";
//		Object[] obj = {user.getUserName(),user.getUserPwd(),user.getUserEmail()};
//		sqLiteDatabase.execSQL(sql, obj);
//		return true;
//	}
	
//	public boolean delete(int id){
//		SQLiteDatabase sqLiteDatabase = dbHelper.getReadableDatabase();
//		String sql = "delete from user where userid = ?";
//		Object[] obj = {id};
//		sqLiteDatabase.execSQL(sql, obj);
//		return true;
//	}
	
//	public boolean update(String[] values){
//		SQLiteDatabase sqLiteDatabase = dbHelper.getReadableDatabase();
//		String sql = "update user set userpwd = ?,useremail = ? where userid = ?";
//		Object[] obj = {values[0],values[1],values[2]};
//		sqLiteDatabase.execSQL(sql, obj);
//		return true;
//	}
	
//	public ArrayList<User> queryAll(){
//		ArrayList<User> list = new ArrayList<User>();
//		SQLiteDatabase sqLiteDatabase = dbHelper.getReadableDatabase();
//		Cursor cursor = sqLiteDatabase.query("user", 
//				new String[]{"userid","username","userpwd","useremail"},
//				null, null, null, null, "userid");
//		while(cursor.moveToNext()){
//			String id = cursor.getString(0);
//			String name = cursor.getString(1);
//			String pwd = cursor.getString(2);
//			String email = cursor.getString(3);
//			User user = new User(Integer.parseInt(id), name, pwd, email);
//			list.add(user);
//		}
//		cursor.close();
//		return list;
//	}
	
//	public User queryById(int id){
//		SQLiteDatabase sqLiteDatabase = dbHelper.getReadableDatabase();
//		String sql = "select * from user where userid = ?";
//		Cursor cursor = sqLiteDatabase.rawQuery(sql, new String[]{String.valueOf(id)});
//		User user = null;
//		while(cursor.moveToNext()){
//			String userid = cursor.getString(0);
//			String name = cursor.getString(1);
//			String pwd = cursor.getString(2);
//			String email = cursor.getString(3);
//			user = new User(Integer.parseInt(userid), name, pwd, email);
//		}
//		cursor.close();
//		return user;
//	}
	
}
