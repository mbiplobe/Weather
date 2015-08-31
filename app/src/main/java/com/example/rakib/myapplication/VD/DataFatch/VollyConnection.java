package com.example.rakib.myapplication.VD.DataFatch;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
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
import com.example.rakib.myapplication.VD.VG.MainActivity;
import com.example.rakib.myapplication.VD.VO.VollyWeather;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/**
 * Created by mbiplobe on 8/30/2015.
 */
public class VollyConnection {
    private Context context;
    private Location location;
    final MainActivity mainActivity;
    private Weather weather=null;

    JSONObject nResponse=null;
//    MyDialogFragment myDialogFragment=new MyDialogFragment();


//    public void setWeather(Weather weather) {
//        this.weather = weather;
//    }

//    public void setWeather(Weather weather) {
//        this.weather = weather;
//    }



//    public Weather getWeather() {
//        return weather;
//    }

    public VollyConnection(Context context) {
        this.context=context;
//        setWeather(new Weather());

//        this.weather=weather;
//        this.location=location;
        mainActivity=new MainActivity();
    }

//    public void setObject(Location location){
//        this.location=location;
//    }

    public void apiDataFatch(){
        RequestQueue requestQueue= Volley.newRequestQueue(context);
//        String url = "http://api.openweathermap.org/data/2.5/weather?q='"+myDialogFragment.getLocation().getCountryCity()+"','"+myDialogFragment.getLocation().getCountryCity()+"'&APPID=c15646613c5b5b7a89f764b00b96c709";
        String url = "http://api.openweathermap.org/data/2.5/weather?q=dhaka & APPID=c15646613c5b5b7a89f764b00b96c709";

        JsonObjectRequest jsObjRequest = new JsonObjectRequest
                (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {

//                        InformtaionReceiver informtaionReceiver=new InformtaionReceiver(response);

                        nResponse=response;
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

                        Toast.makeText(context.getApplicationContext(), "Please Check your Internet Connection", Toast.LENGTH_SHORT).show();
//                        Log.d("Error", TAG);

                    }
                });
        requestQueue.add(jsObjRequest);


    }

    public  Weather  dataReceiver()  {

        //  Weather weather=new Weather();
        try {

            //  JSONObject jasonObject=response.getJSONObject("sys");
            JSONArray weatherArray = nResponse.getJSONArray(VollyWeather.WEATHER_ARR);
            JSONObject jsonWeatherObject=weatherArray.getJSONObject(0);


           weather.setWeatherIcon(jsonWeatherObject.getString(VollyWeather.WEATHER_ICON));
            Log.d("Number", weather.getWeatherIcon());
            // cityCountryTextView.setText(jsonWeatherObject.toString());
//            weatherStateTextView.setText(jsonWeatherObject.getString(VollyWeather.WEATHER_MAIN));


//            weather.setWeatherState(jsonWeatherObject.getString(VollyWeather.WEATHER_MAIN));
            weather.setWeatherDescrition(jsonWeatherObject.getString(VollyWeather.WEATHER_MAIN_DESCRIPTION));
//            weatherStateTextView.setText(weather.getWeatherState());





            JSONObject weatherBasicInfo=nResponse.getJSONObject(VollyWeather.BASIC_WEATHER_UPDATE_MAIN_OBJ);
            weather.setTemparature(FerhToCel(weatherBasicInfo.getDouble(VollyWeather.BASIC_WEATHER_UPDATE_MAIN_TEMPARATURE)));

            weather.setPressure(weatherBasicInfo.getDouble(VollyWeather.BASIC_WEATHER_UPDATE_MAIN_PRESSURE));

            weather.setTemparatureMinimum(FerhToCel(weatherBasicInfo.getDouble(VollyWeather.BASIC_WEATHER_UPDATE_MAIN_TEMP_MIN)));

            weather.setHumidity(weatherBasicInfo.getDouble(VollyWeather.BASIC_WEATHER_UPDATE_MAIN_HUMIDITY));
            weather.setTemparatureMaximum(FerhToCel(weatherBasicInfo.getDouble(VollyWeather.BASIC_WEATHER_UPDATE_MAIN_TEMP_MAX)));
//
//
            JSONObject windObject=nResponse.getJSONObject(VollyWeather.WIND_OBJ);
            weather.setWindSpeed(windObject.getDouble(VollyWeather.WIND_SPEED));
//            weather.setWindDeg(windObject.getDouble(VollyWeather.WIND_DEG));

            JSONObject cloudObject=nResponse.getJSONObject(VollyWeather.CLOUDS_OBJ);
            weather.setCloudness(cloudObject.getInt(VollyWeather.CLOUDS_ALL));
//
//
            JSONObject  systemObject=nResponse.getJSONObject(VollyWeather.SYS_OBJ);
            weather.setCountry(systemObject.getString(VollyWeather.SYS_COUNTRY));

            // String date=


            weather.setSunrise(dataTimeConversion(Long.parseLong(systemObject.getString(VollyWeather.SYS_SUNRISE))));
            weather.setSunset(dataTimeConversion(Long.parseLong(systemObject.getString(VollyWeather.SYS_SUNSET))));
//
            weather.setCountryCity(nResponse.getString(VollyWeather.CITY_ID_NAME));
//            Toast.makeText(getBaseContext(),"response.getString(VollyWeather.CITY_ID_NAME",Toast.LENGTH_SHORT).show();
//            Log.d(response.getString(VollyWeather.CITY_ID_NAME),TAG);


//            setWeather(weather);

            //textView.setText(Double.toString(weather.getWindDeg()));







        } catch (JSONException e) {
            Log.e(e.getMessage(),"Error");
        }
        return  weather;

    }

//    private void setValueAtUI()
//    {
//        mainActivity.weatherStateTextView.setText(weather.getWeatherDescrition());
//        mainActivity.cityCountryTextView.setText(weather.getCountryCity() + "," + weather.getCountry());
//
//
//
//
//
//
//
//        setImage();
//
//        String Temparatute=String.format("%.2f", weather.getTemparature());
//        tempTextView.setText(Temparatute+"\u00b0"+"C");
//
//
//        cloudnessTextView.setText(CloudDescription(weather.getCloudness()));
//
//        windSpeedTextView.setText(Double.toString(weather.getWindSpeed())+" m/s");
//        pressureTextView.setText(Double.toString(weather.getPressure())+" hpa");
//        humidityTextView.setText(Double.toString(weather.getHumidity())+" %");
//        sunriseTextView.setText(weather.getSunrise());
//        sunsetTextView.setText(weather.getSunset());
//        String minTemparatute=String.format("%.2f",weather.getTemparatureMinimum());
//        minimumTextView.setText(minTemparatute + "\u00b0" + "C");
//        String maxTemparatute=String.format("%.2f",weather.getTemparatureMaximum());
//        //String maxTemp=String.format("%.2f", weather.getTemparatureMaximum());
//        maximumTextView.setText(maxTemparatute.toString() + "\u00b0" + "C");
//
//    }
//

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

//    private String CloudDescription(int cloudness){
////
//////        int oktas=cloudness/10;
////
//        String cloud = null;
////
//        if(cloudness>=0&&cloudness<10){
//            cloud="Clear";
//        }
//        else if(cloudness>=10&&cloudness<30){cloud="Mostly Clear";}
//
//        else if(cloudness>=30&&cloudness<69){cloud="Scattered";}
//
//        else if(cloudness>=70&&cloudness<89){cloud="Broken";}
//
//        else if(cloudness>=90&&cloudness<100){cloud="Overcast";}
//
////
//        return cloud;
//    }

//    public Uri setURI(String icon){
//
//        //String imageLocation="http://openweathermap.org/img/w/"+icon+".png";
//        String imageLocation="http://openweathermap.org/img/w/50d.png";
//
//        Uri locationUri=Uri.parse(imageLocation);
//
//        Log.e("Location",locationUri.toString());
//        return locationUri;
//    }

    public void setImage()
    {
        RequestQueue queue = Volley.newRequestQueue(context.getApplicationContext());
        Log.d("Name","biplobe");




        String url="http://openweathermap.org/img/w/"+weather.getWeatherIcon()+".png";
        ImageRequest request = new ImageRequest(url,
                new Response.Listener<Bitmap>() {
                    @Override
                    public void onResponse(Bitmap bitmap) {
                        mainActivity.cloudImage.setImageBitmap(bitmap);
                        Log.e("Yes","I got");
                    }
                }, 0, 0, null,
                new Response.ErrorListener() {
                    public void onErrorResponse(VolleyError error) {
                        mainActivity.cloudImage.setImageResource(R.drawable.sun1);
                        Log.e("mib","I Fail");
                    }
                });
        queue.add(request);

//        cloudImage.setImageResource(R.drawable.sun1);
    }

}
