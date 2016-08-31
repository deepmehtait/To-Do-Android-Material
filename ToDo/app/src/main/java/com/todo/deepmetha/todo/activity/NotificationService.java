package com.todo.deepmetha.todo.activity;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

import com.todo.deepmetha.todo.R;
import com.todo.deepmetha.todo.utils.AppTager;

/**
 * Created by deepmetha on 8/30/16.
 */
public class NotificationService extends Service {

    private NotificationManager mManager;
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
    @Override
    public void onCreate() {
        super.onCreate();
    }
    @Override
    public void onStart(Intent intent, int startId) {
        super.onStart(intent, startId);
        // Getting Notification Service
        mManager = (NotificationManager) this.getApplicationContext()
                .getSystemService(
                        this.getApplicationContext().NOTIFICATION_SERVICE);
        Log.v(AppTager.getTag(),"onStart Notification service");
		/*
		 * When the user taps the notification we have to show the Home Screen
		 * of our App, this job can be done with the help of the following
		 * Intent.
		 */
        Intent intent1 = new Intent(this.getApplicationContext(), MainActivity.class);


        intent1.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP
                | Intent.FLAG_ACTIVITY_CLEAR_TOP);

        PendingIntent pendingNotificationIntent = PendingIntent.getActivity(
                this.getApplicationContext(), 0, intent1,
                PendingIntent.FLAG_UPDATE_CURRENT);


        Notification.Builder builder = new Notification.Builder(this.getApplicationContext());
        builder.setAutoCancel(false);
        builder.setTicker("Some Task");
        builder.setContentTitle("ToDo Task");
        builder.setContentText("You have a new message");
        builder.setSmallIcon(R.drawable.ic_notification);
        builder.setContentIntent(pendingNotificationIntent);
        builder.setOngoing(true);
        builder.setSubText("This is subtext...");   //API level 16
        builder.setNumber(100);
        builder.build();

        Notification myNotication = builder.getNotification();
        mManager.notify(0, myNotication);
    }

    @Override
    public void onDestroy() {
        // TODO Auto-generated method stub
        super.onDestroy();
    }
}
