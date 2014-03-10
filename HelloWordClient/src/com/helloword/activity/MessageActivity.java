package com.helloword.activity;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;

import com.helloword.service.LongPollingService;
import com.helloword.service.LongPollingService.LocalBinder;

public abstract class MessageActivity extends BaseActivity {
    
// Below are the code for long-polling service, which is to be extended by related activities
// if there are some needs to modify the life cycle, please execute super's functions first
    
    LongPollingService longPolling;
    boolean mBound = false;
  
    @Override
    protected void onStart() {
      super.onStart();
      // Bind to LongPollingService
      Intent intent = new Intent(this, LongPollingService.class);
      bindService(intent, mConnection, Context.BIND_AUTO_CREATE);
  }
  
  @Override
  protected void onStop() {
      super.onStop();
      // Unbind from the service
      if (mBound) {
          unbindService(mConnection);
          mBound = false;
      }
  }
  
    
  /** Defines callbacks for service binding, passed to bindService() */
  private ServiceConnection mConnection = new ServiceConnection() {
  
      @Override
      public void onServiceConnected(ComponentName className,
              IBinder service) {
          LocalBinder binder = (LocalBinder) service;
          longPolling = binder.getService();
          mBound = true;
      }
  
      @Override
      public void onServiceDisconnected(ComponentName arg0) {
          mBound = false;
      }
  };

}
