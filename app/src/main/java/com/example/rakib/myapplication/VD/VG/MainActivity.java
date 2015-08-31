package com.example.rakib.myapplication.VD.VG;


import android.app.FragmentManager;
import android.content.Context;
import android.graphics.Bitmap;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.androidweather.mbiplobe.weatherproject.R;
import com.example.rakib.myapplication.DB.DBO.Weather;
import com.example.rakib.myapplication.DialogFragment.Location;
import com.example.rakib.myapplication.DialogFragment.MyDialogFragment;
import com.example.rakib.myapplication.DialogFragment.ReceiveLocation;
import com.example.rakib.myapplication.VD.DataFatch.VollyConnection;
import com.example.rakib.myapplication.VD.VO.VollyWeather;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


import java.text.SimpleDateFormat;

import java.util.Date;

import java.util.TimeZone;


public class MainActivity extends ActionBarActivity {

    //TextView textView;
//    private  Weather nWeather=null;
    private  Weather weather=null;
    private TextView cityCountryTextView,weatherStateTextView,tempTextView,windSpeedTextView,pressureTextView,humidityTextView,sunriseTextView,sunsetTextView;

    public TextView minimumTextView,maximumTextView,cloudnessTextView;
    private TextView wind,cloud,pressure,humidity,sunrise,sunset,min,max;
    public ImageView cloudImage;
    private static  final String TAG="Check";
    private VollyConnection vollyConnection;
    private Location location;
    RequestQueue requestQueue;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.forcast_activity);

        wind= (TextView) findViewById(R.id.wind);
        cloud= (TextView) findViewById(R.id.cloud);
        pressure= (TextView) findViewById(R.id.pressure);
        humidity= (TextView) findViewById(R.id.humidity);
        sunrise= (TextView) findViewById(R.id.sunrise);
        sunset= (TextView) findViewById(R.id.sunset);
        min= (TextView) findViewById(R.id.min);
        max= (TextView) findViewById(R.id.max);
//        wind= (TextView) findViewById(R.id.wind);


        wind.setVisibility(View.INVISIBLE);
        cloud.setVisibility(View.INVISIBLE);
        pressure.setVisibility(View.INVISIBLE);
        humidity.setVisibility(View.INVISIBLE);
        sunrise.setVisibility(View.INVISIBLE);
        sunset.setVisibility(View.INVISIBLE);
        min.setVisibility(View.INVISIBLE);
        max.setVisibility(View.INVISIBLE);



        cityCountryTextView= (TextView) findViewById(R.id.cityCountryTextView);
        cityCountryTextView.setVisibility(View.INVISIBLE);

        weatherStateTextView= (TextView) findViewById(R.id.weatherStateTextView);
        weatherStateTextView.setVisibility(View.INVISIBLE);

        tempTextView= (TextView) findViewById(R.id.tempTextView);
        tempTextView.setVisibility(View.INVISIBLE);

        windSpeedTextView= (TextView) findViewById(R.id.windSpeedTextView);
        windSpeedTextView.setVisibility(View.INVISIBLE);

        pressureTextView= (TextView) findViewById(R.id.pressureTextView);
        pressureTextView.setVisibility(View.INVISIBLE);

        humidityTextView= (TextView) findViewById(R.id.humidityTextView);
        humidityTextView.setVisibility(View.INVISIBLE);

        sunriseTextView= (TextView) findViewById(R.id.sunriseTextView);
        sunriseTextView.setVisibility(View.INVISIBLE);

        sunsetTextView= (TextView) findViewById(R.id.sunsetTextView);
        sunsetTextView.setVisibility(View.INVISIBLE);

        minimumTextView= (TextView) findViewById(R.id.minimumTextView);
        minimumTextView.setVisibility(View.INVISIBLE);

        maximumTextView= (TextView) findViewById(R.id.maximumTextView);
        maximumTextView.setVisibility(View.INVISIBLE);

        cloudnessTextView= (TextView) findViewById(R.id.cloudnessTextView);
        cloudnessTextView.setVisibility(View.INVISIBLE);

        cloudImage= (ImageView) findViewById(R.id.cloudImage);
        cloudImage.setVisibility(View.INVISIBLE);




        //Test Start

        FragmentManager fragmentManager=getFragmentManager();
        MyDialogFragment myDialogFragment=new MyDialogFragment();
        myDialogFragment.show(fragmentManager, "Simple Fragment");

        //Test End



//        vollyConnection=new VollyConnection(this);
//        vollyConnection.apiDataFatch();
////        nWeather=vollyConnection.dataReceiver();
//        ReceiveLocation receiveLocation=new ReceiveLocation();
//        Location currentLocation=receiveLocation.getLocation();


        requestQueue= Volley.newRequestQueue(this);

        // textView= (TextView) findViewById(R.id.textView);
//        RequestQueue requestQueue= Volley.newRequestQueue(this);
//        String url = "http://api.openweathermap.org/data/2.5/weather?q='"+currentLocation.getCountryCity()+"','"+currentLocation.getCountryName()+"'&APPID=c15646613c5b5b7a89f764b00b96c709";
//
//        JsonObjectRequest jsObjRequest = new JsonObjectRequest
//                (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
//
//                    @Override
//                    public void onResponse(JSONObject response) {
//
////                        InformtaionReceiver informtaionReceiver=new InformtaionReceiver(response);
//
//                         dataReceiver(response);
////                        try {
////                            JSONObject jasonObject=response.getJSONObject("sys");
////                            textView.setText(jasonObject.toString());
////                        } catch (JSONException e) {
////                            e.printStackTrace();
////                        }
////                        textView.setText(response.toString());
//
//
//                    }
//                }, new Response.ErrorListener() {
//
//                    @Override
//                    public void onErrorResponse(VolleyError error) {
//                        // TODO Auto-generated method stub
//
//                        Toast.makeText(getApplicationContext(),"Please Check your Internet Connection",Toast.LENGTH_SHORT).show();
////                        Log.d("Error", TAG);
//
//                    }
//                });
//        requestQueue.add(jsObjRequest);
////
//        //setObject();
//
//        setValueAtUI();
//        setObject();

    }

//    public void setObject(Location currentLocation,Context context{
//    public void setObject(){
    public void setObject(Location currentLocation){


//        cityCountryTextView= (TextView) findViewById(R.id.cityCountryTextView);
//        weatherStateTextView= (TextView) findViewById(R.id.weatherStateTextView);
//        tempTextView= (TextView) findViewById(R.id.tempTextView);
//        windSpeedTextView= (TextView) findViewById(R.id.windSpeedTextView);
//        pressureTextView= (TextView) findViewById(R.id.pressureTextView);
//        humidityTextView= (TextView) findViewById(R.id.humidityTextView);
//        sunriseTextView= (TextView) findViewById(R.id.sunriseTextView);
//        sunsetTextView= (TextView) findViewById(R.id.sunsetTextView);
//        minimumTextView= (TextView) findViewById(R.id.minimumTextView);
//        maximumTextView= (TextView) findViewById(R.id.maximumTextView);
//        cloudnessTextView= (TextView) findViewById(R.id.cloudnessTextView);
//        cloudImage= (ImageView) findViewById(R.id.cloudImage);

        weather=new Weather();


        String url = "http://api.openweathermap.org/data/2.5/weather?q='"+currentLocation.getCountryCity()+"','"+currentLocation.getCountryName()+"'&APPID=c15646613c5b5b7a89f764b00b96c709";
//        String url = "http://api.openweathermap.org/data/2.5/weather?q=rajshahi,bangladesh&APPID=c15646613c5b5b7a89f764b00b96c709";

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

                        Toast.makeText(getApplicationContext(),"Please Check your Internet Connection",Toast.LENGTH_SHORT).show();
//                        Log.d("Error", TAG);

                    }
                });
        requestQueue.add(jsObjRequest);
//
        //setObject();

//        setValueAtUI();



    }






    public  void  dataReceiver(JSONObject response)  {


        cityCountryTextView.setVisibility(View.VISIBLE);
        weatherStateTextView.setVisibility(View.VISIBLE);
        tempTextView.setVisibility(View.VISIBLE);
        windSpeedTextView.setVisibility(View.VISIBLE);
        pressureTextView.setVisibility(View.VISIBLE);
        humidityTextView.setVisibility(View.VISIBLE);
        sunriseTextView.setVisibility(View.VISIBLE);
        sunsetTextView.setVisibility(View.VISIBLE);
        minimumTextView.setVisibility(View.VISIBLE);
        maximumTextView.setVisibility(View.VISIBLE);
        cloudnessTextView.setVisibility(View.VISIBLE);
        cloudImage.setVisibility(View.VISIBLE);


        wind.setVisibility(View.VISIBLE);
        cloud.setVisibility(View.VISIBLE);
        pressure.setVisibility(View.VISIBLE);
        humidity.setVisibility(View.VISIBLE);
        sunrise.setVisibility(View.VISIBLE);
        sunset.setVisibility(View.VISIBLE);
        min.setVisibility(View.VISIBLE);
        max.setVisibility(View.VISIBLE);


      //  Weather weather=new Weather();
        try {

          //  JSONObject jasonObject=response.getJSONObject("sys");
            JSONArray weatherArray = response.getJSONArray(VollyWeather.WEATHER_ARR);
            JSONObject jsonWeatherObject=weatherArray.getJSONObject(0);


            weather.setWeatherIcon(jsonWeatherObject.getString(VollyWeather.WEATHER_ICON));
            Log.d("Number",weather.getWeatherIcon());
           // cityCountryTextView.setText(jsonWeatherObject.toString());
//            weatherStateTextView.setText(jsonWeatherObject.getString(VollyWeather.WEATHER_MAIN));


//            weather.setWeatherState(jsonWeatherObject.getString(VollyWeather.WEATHER_MAIN));
            weather.setWeatherDescrition(jsonWeatherObject.getString(VollyWeather.WEATHER_MAIN_DESCRIPTION));
//            weatherStateTextView.setText(weather.getWeatherState());





            JSONObject weatherBasicInfo=response.getJSONObject(VollyWeather.BASIC_WEATHER_UPDATE_MAIN_OBJ);
            weather.setTemparature(FerhToCel(weatherBasicInfo.getDouble(VollyWeather.BASIC_WEATHER_UPDATE_MAIN_TEMPARATURE)));

            weather.setPressure(weatherBasicInfo.getDouble(VollyWeather.BASIC_WEATHER_UPDATE_MAIN_PRESSURE));

            weather.setTemparatureMinimum(FerhToCel(weatherBasicInfo.getDouble(VollyWeather.BASIC_WEATHER_UPDATE_MAIN_TEMP_MIN)));

            weather.setHumidity(weatherBasicInfo.getDouble(VollyWeather.BASIC_WEATHER_UPDATE_MAIN_HUMIDITY));
            weather.setTemparatureMaximum(FerhToCel(weatherBasicInfo.getDouble(VollyWeather.BASIC_WEATHER_UPDATE_MAIN_TEMP_MAX)));
//
//
            JSONObject windObject=response.getJSONObject(VollyWeather.WIND_OBJ);
            weather.setWindSpeed(windObject.getDouble(VollyWeather.WIND_SPEED));
//            weather.setWindDeg(windObject.getDouble(VollyWeather.WIND_DEG));

            JSONObject cloudObject=response.getJSONObject(VollyWeather.CLOUDS_OBJ);
            weather.setCloudness(cloudObject.getInt(VollyWeather.CLOUDS_ALL));
//
//
            JSONObject  systemObject=response.getJSONObject(VollyWeather.SYS_OBJ);
            weather.setCountry(systemObject.getString(VollyWeather.SYS_COUNTRY));

           // String date=


            weather.setSunrise(dataTimeConversion(Long.parseLong(systemObject.getString(VollyWeather.SYS_SUNRISE))));
            weather.setSunset(dataTimeConversion(Long.parseLong(systemObject.getString(VollyWeather.SYS_SUNSET))));
//
            weather.setCountryCity(response.getString(VollyWeather.CITY_ID_NAME));
//            Toast.makeText(getBaseContext(),"response.getString(VollyWeather.CITY_ID_NAME",Toast.LENGTH_SHORT).show();
//            Log.d(response.getString(VollyWeather.CITY_ID_NAME),TAG);

                    setValueAtUI();

            //textView.setText(Double.toString(weather.getWindDeg()));





        } catch (JSONException e) {
            Log.e(e.getMessage(),"Error");
        }

    }

    private void setValueAtUI()
    {

        weatherStateTextView.setText(weather.getWeatherDescrition());
        cityCountryTextView.setText(weather.getCountryCity() + "," + weather.getCountry());







        setImage();

        String Temparatute=String.format("%.2f", weather.getTemparature());
        tempTextView.setText(Temparatute+"\u00b0"+"C");


        cloudnessTextView.setText(CloudDescription(weather.getCloudness()));

        windSpeedTextView.setText(Double.toString(weather.getWindSpeed())+" m/s");
        pressureTextView.setText(Double.toString(weather.getPressure())+" hpa");
        humidityTextView.setText(Double.toString(weather.getHumidity())+" %");
        sunriseTextView.setText(weather.getSunrise());
        sunsetTextView.setText(weather.getSunset());
        String minTemparatute=String.format("%.2f",weather.getTemparatureMinimum());
        minimumTextView.setText(minTemparatute + "\u00b0" + "C");
        String maxTemparatute=String.format("%.2f",weather.getTemparatureMaximum());
        //String maxTemp=String.format("%.2f", weather.getTemparatureMaximum());
        maximumTextView.setText(maxTemparatute.toString() + "\u00b0" + "C");

    }


    private String dataTimeConversion(long time)
    {


        Date date = new Date(time*1000L); // *1000 is to convert seconds to milliseconds
        SimpleDateFormat sdf = new SimpleDateFormat("HH:MM:SS"); // the format of your date
        sdf.setTimeZone(TimeZone.getTimeZone("GMT+6")); // give a timezone reference for formating (see comment at the bottom
        String formattedDate = sdf.format(date);
        return formattedDate;
    }


    private double FerhToCel(double fahrenh)
    {
        double celsiu =fahrenh-273.15 ;
        return Math.abs(celsiu);

    }

    private String CloudDescription(int cloudness){
//
////        int oktas=cloudness/10;
//
        String cloud = null;
//
        if(cloudness>=0&&cloudness<10){
            cloud="Clear";
        }
        else if(cloudness>=10&&cloudness<30){cloud="Mostly Clear";}

        else if(cloudness>=30&&cloudness<69){cloud="Scattered";}

        else if(cloudness>=70&&cloudness<89){cloud="Broken";}

        else if(cloudness>=90&&cloudness<100){cloud="Overcast";}

//
        return cloud;
    }
//
////    public Uri setURI(String icon){
////
////        //String imageLocation="http://openweathermap.org/img/w/"+icon+".png";
////        String imageLocation="http://openweathermap.org/img/w/50d.png";
////
////        Uri locationUri=Uri.parse(imageLocation);
////
////        Log.e("Location",locationUri.toString());
////        return locationUri;
////    }
//
    private void setImage()
    {
        RequestQueue queue = Volley.newRequestQueue(this);
        Log.d("Name","biplobe");



        String url="http://openweathermap.org/img/w/"+weather.getWeatherIcon()+".png";
        ImageRequest request = new ImageRequest(url,
                new Response.Listener<Bitmap>() {
                    @Override
                    public void onResponse(Bitmap bitmap) {
                        cloudImage.setImageBitmap(bitmap);
                        Log.e("Yes","I got");
                    }
                }, 0, 0, null,
                new Response.ErrorListener() {
                    public void onErrorResponse(VolleyError error) {
                        cloudImage.setImageResource(R.drawable.sun1);
                        Log.e("mib","I Fail");
                    }
                });
        queue.add(request);

//        cloudImage.setImageResource(R.drawable.sun1);
    }

}
