package com.example.manager.util;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;

public class BuilderUtil {
	private static AlertDialog.Builder builder;
	
	//构建提示信息对话框
	public static void buildInfo(Activity activity,String title,String message){
		builder = new AlertDialog.Builder(activity);
		builder.setTitle(title);
		builder.setMessage(message);
		builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				dialog.cancel();
			}
		});
		builder.setCancelable(false);
		builder.create();
		builder.show();
	}
	
	//获取builder
	public static AlertDialog.Builder getBuilder(Activity activity,String title,String message){
		builder = new AlertDialog.Builder(activity);
		builder.setTitle(title);
		builder.setMessage(message);
		return builder;
	}
	
	//设置取消按钮
	public static void setNegativeButton(AlertDialog.Builder builder){
		builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				dialog.cancel();
			}
		});
		builder.setCancelable(false);
		builder.create();
		builder.show();
	}
}
