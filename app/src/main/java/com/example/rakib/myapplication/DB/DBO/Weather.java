package com.example.rakib.myapplication.DB.DBO;

/**
 * Created by mbiplobe on 8/6/2015.
 */
public class Weather {
    private String weatherState;
    private String weatherDescrition;
    private double temparature;
    private double pressure;
    private double humidity;
    private double temparatureMinimum;
    private double temparatureMaximum;
    private double windSpeed;


    private double windDeg;
    private String country;

    private String sunrise;
    private String sunset;
    private String countryCity;


    public String getCountryCity() {
        return countryCity;
    }

    public void setCountryCity(String countryCity) {
        this.countryCity = countryCity;
    }

    public String getSunset() {
        return sunset;
    }

    public void setSunset(String sunset) {
        this.sunset = sunset;
    }

    public String getSunrise() {
        return sunrise;
    }

    public void setSunrise(String sunrise) {
        this.sunrise = sunrise;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public double getWindDeg() {
        return windDeg;
    }

    public void setWindDeg(double windDeg) {
        this.windDeg = windDeg;
    }

    public double getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(double windSpeed) {
        this.windSpeed = windSpeed;
    }

    public double getTemparatureMaximum() {
        return temparatureMaximum;
    }

    public void setTemparatureMaximum(double temparatureMaximum) {
        this.temparatureMaximum = temparatureMaximum;
    }

    public double getTemparatureMinimum() {
        return temparatureMinimum;
    }

    public void setTemparatureMinimum(double temparatureMinimum) {
        this.temparatureMinimum = temparatureMinimum;
    }

    public double getHumidity() {
        return humidity;
    }

    public void setHumidity(double humidity) {
        this.humidity = humidity;
    }

    public double getPressure() {
        return pressure;
    }

    public void setPressure(double pressure) {
        this.pressure = pressure;
    }

    public double getTemparature() {
        return temparature;
    }

    public void setTemparature(double temparature) {
        this.temparature = temparature;
    }

    public String getWeatherDescrition() {
        return weatherDescrition;
    }

    public void setWeatherDescrition(String weatherDescrition) {
        this.weatherDescrition = weatherDescrition;
    }

    public String getWeatherState() {
        return weatherState;
    }

    public void setWeatherState(String weatherState) {
        this.weatherState = weatherState;
    }



}
