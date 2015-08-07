package com.example.rakib.myapplication.VD.VG;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import org.json.JSONObject;

/**
 * Created by mbiplobe on 8/6/2015.
 */
public class InformtaionReceiver extends Activity {

    public InformtaionReceiver(JSONObject response) {


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TextView textView = null;
        textView.setText("Hellow");

        setContentView(textView);
    }
}
