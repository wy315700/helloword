package com.helloword.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class MessageReceiver extends BroadcastReceiver {
    
    @Override  
    public void onReceive(Context context, Intent intent) {  
        int num = intent.getIntExtra("message_box", 0)  ;
        
        // to be replaced for real interaction with UI
        Toast.makeText(context, "message is: " + num, Toast.LENGTH_SHORT).show();  
    }
}
