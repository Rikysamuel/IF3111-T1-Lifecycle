package com.example.rikysamuel.androidalarm;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class AlarmActivity extends ActionBarActivity {
    private final int REQUEST_CODE = 23432;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm);
    }


    public void startAlert(View view){
        EditText text = (EditText) findViewById(R.id.time);
        int a = Integer.parseInt(text.getText().toString());
        Intent i = new Intent(this, MyBroadcastReceiver.class);
        PendingIntent pint = PendingIntent.getBroadcast(this.getApplicationContext(),REQUEST_CODE, i, 0);
        AlarmManager almMgr = (AlarmManager) getSystemService(ALARM_SERVICE);
        almMgr.set(AlarmManager.RTC_WAKEUP, System.currentTimeMillis() + (a*1000), pint);
        Toast.makeText(this, "Alarm set in " + i + " seconds", Toast.LENGTH_LONG).show();
    }
}
