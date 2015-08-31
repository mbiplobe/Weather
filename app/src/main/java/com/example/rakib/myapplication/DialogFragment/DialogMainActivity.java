package com.example.rakib.myapplication.DialogFragment;

import android.app.FragmentManager;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.androidweather.mbiplobe.weatherproject.R;
import com.example.rakib.myapplication.DialogFragment.Location;
import com.example.rakib.myapplication.DialogFragment.MyDialogFragment;

import java.util.ArrayList;

public class DialogMainActivity extends ActionBarActivity {


    private Location location;
    private TextView name,city;

    ArrayAdapter<String> adapter;
//    private Test test;
//    public DialogMainActivity(Test test) {
//        this();
//        this.test=test;
//    }
//
//    public DialogMainActivity() {
//    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog_main);

        FragmentManager fragmentManager=getFragmentManager();
        MyDialogFragment myDialogFragment=new MyDialogFragment();
        myDialogFragment.show(fragmentManager,"Simple Fragment");


        name= (TextView) findViewById(R.id.name);
        city= (TextView) findViewById(R.id.email);



//        name.setText(test.getName());
//        email.setText(test.getEmail());
    }

    public void setObject(Location location){


        this.location=location;

//        TextView name1= (TextView) findViewById(R.id.name);
        name.setText(location.getCountryName());

//        TextView city= (TextView) findViewById(R.id.email);
        //TextView city= (TextView) findViewById(R.id.email);
        city.setText(location.getCountryCity());


    }


//    public void setCountryName(View view){
//        TextView name= (TextView) findViewById(R.id.name);
//        name.setText(test.getName().toString());
//    }

}
