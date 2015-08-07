package com.example.rakib.myapplication.VD.VG;

import android.app.DownloadManager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.androidweather.mbiplobe.weatherproject.R;
import com.example.rakib.myapplication.DB.DBO.Weather;
import com.example.rakib.myapplication.VD.VO.VollyWeather;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class MainActivity extends ActionBarActivity {

    //TextView textView;
    private  Weather weather=null;
    private TextView cityCountryTextView;

    private static  final String TAG="Check";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.forcast_activity);
        weather=new Weather();

       // textView= (TextView) findViewById(R.id.textView);
        RequestQueue requestQueue= Volley.newRequestQueue(this);
        String url = "http://api.openweathermap.org/data/2.5/weather?q=dhaka,bangladesh";

        JsonObjectRequest jsObjRequest = new JsonObjectRequest
                (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {

//                        InformtaionReceiver informtaionReceiver=new InformtaionReceiver(response);

                         dataReceiver(response);
//                        try {
//                            JSONObject jasonObject=response.getJSONObject("sys");
//                            textView.setText(jasonObject.toString());
//                        } catch (JSONException e) {
//                            e.printStackTrace();
//                        }
//                        textView.setText(response.toString());


                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // TODO Auto-generated method stub

                        Toast.makeText(getApplicationContext(),"Error",Toast.LENGTH_SHORT).show();
                        Log.d("Error", TAG);

                    }
                });
        requestQueue.add(jsObjRequest);


    }

    public  void  dataReceiver(JSONObject response)  {

      //  Weather weather=new Weather();
        try {

          //  JSONObject jasonObject=response.getJSONObject("sys");
            JSONArray weatherArray = response.getJSONArray(VollyWeather.WEATHER_ARR);
            JSONObject jsonWeatherObject=weatherArray.getJSONObject(0);


            weather.setWeatherState(jsonWeatherObject.getString(VollyWeather.WEATHER_MAIN_CLUODS));
            weather.setWeatherDescrition(jsonWeatherObject.getString(VollyWeather.WEATHER_MAIN_DESCRIPTION));





            JSONObject weatherBasicInfo=response.getJSONObject(VollyWeather.BASIC_WEATHER_UPDATE_MAIN_OBJ);
            weather.setTemparature(weatherBasicInfo.getDouble(VollyWeather.BASIC_WEATHER_UPDATE_MAIN_TEMPARATURE));
            weather.setPressure(weatherBasicInfo.getDouble(VollyWeather.BASIC_WEATHER_UPDATE_MAIN_PRESSURE));
            weather.setTemparatureMinimum(weatherBasicInfo.getDouble(VollyWeather.BASIC_WEATHER_UPDATE_MAIN_TEMP_MIN));
            weather.setTemparatureMaximum(weatherBasicInfo.getDouble(VollyWeather.BASIC_WEATHER_UPDATE_MAIN_TEMP_MAX));


            JSONObject windObject=response.getJSONObject(VollyWeather.WIND_OBJ);
            weather.setWindSpeed(windObject.getDouble(VollyWeather.WIND_SPEED));
            weather.setWindDeg(windObject.getDouble(VollyWeather.WIND_DEG));


            JSONObject  systemObject=response.getJSONObject(VollyWeather.SYS_OBJ);
            weather.setCountry(systemObject.getString(VollyWeather.SYS_COUNTRY));
            weather.setSunrise(systemObject.getDouble(VollyWeather.SYS_SUNRISE));
            weather.setSunset(systemObject.getDouble(VollyWeather.SYS_SUNSET));

            weather.setCountryCity(response.getString(VollyWeather.CITY_ID_NAME));
            Toast.makeText(getBaseContext(),"response.getString(VollyWeather.CITY_ID_NAME",Toast.LENGTH_SHORT).show();
            Log.d(response.getString(VollyWeather.CITY_ID_NAME),TAG);

                    setValueAtUI();

            //textView.setText(Double.toString(weather.getWindDeg()));





        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    private void setValueAtUI()
    {
        cityCountryTextView= (TextView) findViewById(R.id.cityCountryTextView);
        cityCountryTextView.setText(weather.getCountryCity()+","+weather.getCountry());
    }

}
