package com.example.rakib.myapplication.DialogFragment;

import android.app.DialogFragment;
import android.os.Bundle;

import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;

import com.androidweather.mbiplobe.weatherproject.R;
import com.example.rakib.myapplication.VD.DataFatch.VollyConnection;
import com.example.rakib.myapplication.VD.VG.MainActivity;


public class MyDialogFragment extends DialogFragment {

    @Nullable
    private View view;

    private Spinner mibSpinner,cityCountryEditText;

    public Location getLocation() {
        return location;
    }

    private Location location=new Location();;
    private InformationStoreHouse informationStoreHouse;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view= inflater.inflate(R.layout.fragment_sample_dialog, container, false);
        getDialog().setTitle("Set Your Location");

        final Spinner mibSpinner= (Spinner) view.findViewById(R.id.mibSpinner);
        final Spinner citySpinner= (Spinner) view.findViewById(R.id.citySpinner);

        Button submitButton= (Button) view.findViewById(R.id.submitButton);

        informationStoreHouse=new InformationStoreHouse(getActivity().getApplicationContext());

        mibSpinner.setAdapter(informationStoreHouse.countryListAdapter());

        mibSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {


                location.setCountryName(parent.getSelectedItem().toString());
                citySpinner.setAdapter(informationStoreHouse.cityListAdapter(location.getCountryName()));


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }

        });
        citySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                location.setCountryCity(parent.getSelectedItem().toString());
                Log.d("City", location.getCountryCity());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                MainActivity mainActivity=new MainActivity();
//                mainActivity.setObject(location);
//                ReceiveLocation receiveLocation=new ReceiveLocation();
//                receiveLocation.setLocation(location);
//                DialogMainActivity dialogMainActivity= (DialogMainActivity) getActivity();
//                dialogMainActivity.setObject(location);
                MainActivity mainActivity= (MainActivity) getActivity();
                mainActivity.setObject(location);

                dismiss();
            }
        });
        return view;
    }

}
