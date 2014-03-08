package com.helloword.service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

public class LongPollingService extends Service {
    
    private final IBinder mBinder = new LocalBinder();

    public class LocalBinder extends Binder {
        public LongPollingService getService() {
            return LongPollingService.this;
        }
    }

    @Override
    public IBinder onBind(Intent intent) {
        getMessage();
        return mBinder;
    }

    /** method for clients */
    public void getMessage() {
       
        new Thread(new Runnable() { 
            
            UserService userService = new UserService(getApplication());
            Intent intent = new Intent("com.helloword.service.LONGPOLLING");
            
            @Override  
            public void run() {  
                while(true){  
                    String messageRequest = userService.getMessage();  
                    intent.putExtra("message_box", messageRequest);  
                    sendBroadcast(intent);  
                    try {  
                        Thread.sleep(2000);  
                    } catch (InterruptedException e) {  
                        e.printStackTrace();  
                    }  
                }  
            }  
        }).start();
    }
}

//below are the test code for longpolling service, which is to be placed in relative activities
//@Override
//protected void onStart() {
//    super.onStart();
//    // Bind to LocalService
//    Intent intent = new Intent(this, LongPollingService.class);
//    bindService(intent, mConnection, Context.BIND_AUTO_CREATE);
//}
//
//@Override
//protected void onStop() {
//    super.onStop();
//    // Unbind from the service
//    if (mBound) {
//        unbindService(mConnection);
//        mBound = false;
//    }
//}
//
///** Called when a button is clicked (the button in the layout file attaches to
//  * this method with the android:onClick attribute) */
//public void onButtonClick(View v) {
//    if (mBound) {
//        // Call a method from the LocalService.
//        // However, if this call were something that might hang, then this request should
//        // occur in a separate thread to avoid slowing down the activity performance.
////        int num = mService.getMessage();
////        Toast.makeText(this, "number: " + num, Toast.LENGTH_SHORT).show();
//    }
//}
//
///** Defines callbacks for service binding, passed to bindService() */
//private ServiceConnection mConnection = new ServiceConnection() {
//
//    @Override
//    public void onServiceConnected(ComponentName className,
//            IBinder service) {
//        // We've bound to LocalService, cast the IBinder and get LocalService instance
//        LocalBinder binder = (LocalBinder) service;
//        mService = binder.getService();
//        mBound = true;
//    }
//
//    @Override
//    public void onServiceDisconnected(ComponentName arg0) {
//        mBound = false;
//    }
//};
