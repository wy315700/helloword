package com.helloword.activity;

import android.content.Context;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.util.Log;

/**
 * 
 * 一个包含进度对话框的异步任务
 * 使用时，需要提供进度对话框的parent activity作为构造函数！
 * 仅仅重写doInBackground2和onPostExecute2即可！
 * @author bone-lee
 *
 */
public abstract class AsyncTaskWithProgressDialog  extends AsyncTask<String, Void, String>{
	public AsyncTaskWithProgressDialog(Context progressDialogContext){
		this.progressDialogContext=progressDialogContext;
	}
	
	/**
	 * 使用时候复写下面两个函数即可！
	 */
	abstract protected void onPostExecute2(String result);
	abstract protected String doInBackground2(String... params);		

	@Override
    final protected void onPreExecute() {    		
	    initAndDisplayProgressDialog();
    }
	
	@Override
    final protected String doInBackground(String... params) {
		if(!isCancelled()){//用户点击了back按键，退出task
			return doInBackground2(params);
    	}else{
    		return null;
    	}
	}
	
    @Override
    final protected void onPostExecute(String result) {
        hideProgressDialog();
        onPostExecute2(result);
    }
	
    @Override
    final protected void onCancelled() {
        super.onCancelled();
        Log.i("TASK", "user cancel the request of question lib.");
    }

	private void hideProgressDialog() {
		if(myProgressDialog.isShowing()) {
			 myProgressDialog.closeDialog();
		}
	}

	private void initAndDisplayProgressDialog() {
		//设置用户back按键回调，取消task
		DialogInterface.OnDismissListener cancelTaskCallback = new DialogInterface.OnDismissListener(){
			@Override
			public void onDismiss(DialogInterface arg0) {
				cancel(true);
			}
		};
		myProgressDialog = new MyProgressDialog(progressDialogContext,cancelTaskCallback);
		myProgressDialog.initDialog();
	}
	
	private Context progressDialogContext;
	
	//maybe the progress dialog should be a singleton.
	private MyProgressDialog myProgressDialog = null;
}