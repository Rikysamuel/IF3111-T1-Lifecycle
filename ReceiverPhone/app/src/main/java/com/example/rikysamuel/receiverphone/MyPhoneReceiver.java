package com.example.rikysamuel.receiverphone;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.util.Log;

/**
 * Created by Rikysamuel on 2/7/2015.
 */
public class MyPhoneReceiver extends BroadcastReceiver{
    @Override
    public void onReceive(Context context, Intent i){
        Bundle extras = i.getExtras();
        if (extras != null){
            String state = extras.getString(TelephonyManager.EXTRA_STATE);
            Log.w("MY_DEBUG_TAG", state);
            if (state.equals(TelephonyManager.EXTRA_STATE_RINGING)){
                String phnum = extras.getString(TelephonyManager.EXTRA_INCOMING_NUMBER);
                Log.w("MY_DEBUG_TAG",phnum);
            }
        }
    }
}
