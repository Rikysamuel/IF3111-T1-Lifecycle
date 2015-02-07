package com.example.rikysamuel.intentexplicit;

/**
 * Created by Rikysamuel on 2/7/2015.
 */
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class ResultActivity extends Activity {

    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_result);

        Bundle extras = getIntent().getExtras();

        //get the data
        String val1 = extras.getString("val1");
        TextView t = (TextView) findViewById(R.id.displayintentextra);
        t.setText(val1);
    }

    @Override
    public void finish(){
        // TODO 1 create new Intent
        Intent i = new Intent();

        // TODO 2 read the data of the EditText field
        EditText et = (EditText) findViewById(R.id.returnValue);

        // TODO 3 put the text from EditText
        String val2 = et.getText().toString();
        i.putExtra("val2",val2);

        // TODO 4 use setResult(RESULT_OK, intent);
        setResult(RESULT_OK,i);

        super.finish();
    }
}