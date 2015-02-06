package com.example.rikysamuel.lifecycle1;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.os.Bundle;


/**
 * Created by Rikysamuel on 2/5/2015.
 */
public class TracerActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        notify("Create App");
    }

    @Override
    protected void onPause() {
        super.onPause();
        notify("Pause App");
    }

    @Override
    protected void onResume() {
        super.onResume();
        notify("Resume App");
    }

    @Override
    protected void onStop() {
        super.onStop();
        notify("Stop App");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        notify("Destroy App");
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        notify("Restore State");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        notify("Save State");
    }

    private void notify(String methodName) {
        String name = this.getClass().getName();
        String[] strings = name.split("\\.");
        Notification noti = new Notification.Builder(this)
                .setContentTitle(methodName + " " + strings[strings.length - 1]).setAutoCancel(true)
                .setSmallIcon(R.drawable.ic_launcher)
                .setContentText(name).build();
        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        notificationManager.notify((int) System.currentTimeMillis(), noti);
    }

}
