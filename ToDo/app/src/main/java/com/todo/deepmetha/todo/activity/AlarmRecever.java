package com.todo.deepmetha.todo.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.todo.deepmetha.todo.utils.AppTager;

/**
 * Created by deepmetha on 8/30/16.
 */
public class AlarmRecever extends BroadcastReceiver{
    @Override
    public void onReceive(Context context, Intent intent) {
        if(intent != null) {
            Bundle b = intent.getExtras();
            String TaskTitle = b.getString("TaskTitle");
            String TaskPrority = b.getString("TaskPrority");
            Intent myIntent = new Intent(context, NotificationService.class);
            myIntent.putExtra("Hello","Test");
            myIntent.putExtra("TaskTitle", TaskTitle);
            myIntent.putExtra("TaskPrority",TaskPrority);
            context.startService(myIntent);
        }

    }
}
