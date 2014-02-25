package com.helloword.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;

import com.helloword.R;

public class MainActivity extends Activity {
    
    Handler handler;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
//		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
//				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.activity_main);

		handler = new Handler();
		handler.postDelayed(new Runnable() {

			@Override
			public void run() {
				goLoginActivity();
			}
		}, 1500);
		
	}
	
	

	public void goLoginActivity() {
		Intent intent = new Intent(this, LoginActivity.class);
		startActivity(intent);
		finish();
	}
	
	
	
	
	// below are the test code for longpolling service, which i'm looking for a method to wrap
//	@Override
//    protected void onStart() {
//        super.onStart();
//        // Bind to LocalService
//        Intent intent = new Intent(this, LongPollingService.class);
//        bindService(intent, mConnection, Context.BIND_AUTO_CREATE);
//    }
//
//    @Override
//    protected void onStop() {
//        super.onStop();
//        // Unbind from the service
//        if (mBound) {
//            unbindService(mConnection);
//            mBound = false;
//        }
//    }
//
//    /** Called when a button is clicked (the button in the layout file attaches to
//      * this method with the android:onClick attribute) */
//    public void onButtonClick(View v) {
//        if (mBound) {
//            // Call a method from the LocalService.
//            // However, if this call were something that might hang, then this request should
//            // occur in a separate thread to avoid slowing down the activity performance.
////            int num = mService.getMessage();
////            Toast.makeText(this, "number: " + num, Toast.LENGTH_SHORT).show();
//        }
//    }
//
//    /** Defines callbacks for service binding, passed to bindService() */
//    private ServiceConnection mConnection = new ServiceConnection() {
//
//        @Override
//        public void onServiceConnected(ComponentName className,
//                IBinder service) {
//            // We've bound to LocalService, cast the IBinder and get LocalService instance
//            LocalBinder binder = (LocalBinder) service;
//            mService = binder.getService();
//            mBound = true;
//        }
//
//        @Override
//        public void onServiceDisconnected(ComponentName arg0) {
//            mBound = false;
//        }
//    };
	
    
	
	
}
