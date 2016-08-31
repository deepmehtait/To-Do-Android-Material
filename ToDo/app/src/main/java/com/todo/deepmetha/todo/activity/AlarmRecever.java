package com.todo.deepmetha.todo.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.todo.deepmetha.todo.utils.AppTager;

/**
 * Created by deepmetha on 8/30/16.
 */
public class AlarmRecever extends BroadcastReceiver{
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.v(AppTager.getTag()," in Broadcast Receiver");
        Intent myIntent = new Intent(context, NotificationService.class);
        context.startService(myIntent);
    }
}
