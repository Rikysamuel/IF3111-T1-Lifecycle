package com.example.rikysamuel.intentbrowseractivity;

import android.os.StrictMode;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.webkit.WebView;
import android.widget.TextView;


public class BrowserActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        StrictMode.ThreadPolicy pol = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(pol);

        setContentView(R.layout.activity_browser);
        Intent i = new Intent(Intent.ACTION_VIEW,Uri.parse("http://192.168.35.1/xampp/"));
        startActivity(i);
        TextView tw = (TextView) findViewById(R.id.textView);

        String act = i.getAction();
        if (!act.equals(i.ACTION_VIEW)){
            throw new RuntimeException("Should not happen");
        }

        Uri data = i.getData();
        URL url;
        try{
            url = new URL(data.getScheme(), data.getHost(), data.getPath());
            BufferedReader rd = new BufferedReader(new InputStreamReader(url.openStream()));
            String line = "";
            while ((line = rd.readLine()) != null){
                tw.append(line);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
//        WebView tw = (WebView) findViewById(R.id.textView);
//        tw.loadUrl("http://www.google.com");
    }
}
