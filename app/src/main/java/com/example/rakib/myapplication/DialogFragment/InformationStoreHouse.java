package com.example.rakib.myapplication.DialogFragment;

import android.content.Context;
import android.widget.ArrayAdapter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by mbiplobe on 8/29/2015.
 */
public class InformationStoreHouse {
    private Context context;
    private final DatabaseAccess databaseAccess;

    private ArrayAdapter<String>adapter;

    public InformationStoreHouse(Context context) {
        this.context=context;
        databaseAccess=new DatabaseAccess(context);
    }

    public ArrayAdapter<String> countryListAdapter()
    {

        databaseAccess.open();
        ArrayList<String> countryList=new ArrayList<String>(databaseAccess.getQuotes());
        databaseAccess.close();
        adapter=new ArrayAdapter<String>(context.getApplicationContext(),android.R.layout.simple_spinner_item,countryList);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        return adapter;
    }

    public ArrayAdapter<String> cityListAdapter(String countryName)
    {
        databaseAccess.open();
        String city=databaseAccess.getCity(countryName);
        databaseAccess.close();

        ArrayList<String> cityList=new ArrayList<String>(cityGenarator(city));

        adapter=new ArrayAdapter<String>(context.getApplicationContext(),android.R.layout.simple_spinner_item,cityList);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        return adapter;
    }

    public ArrayList<String> cityGenarator(String city) {
        ArrayList<String> cityList=new ArrayList<String>(Arrays.asList(city.split(",")));
        Collections.sort(cityList);
        return cityList;
    }
}
