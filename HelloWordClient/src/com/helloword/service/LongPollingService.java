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
            
            UserService userService = new UserService();
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
