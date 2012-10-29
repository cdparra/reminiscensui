/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.reminiscens.fromdbpedia;

import java.sql.Date;
import java.util.Calendar;
import java.util.Locale;

/**
 *
 * @author Nicola.Parrello
 */
public class Fuzzy_Date {

    private int fuzzy_date_id;
    private String exact_date;
    private int accuracy;
    private Time_Interval interval;
    private String decade;
    private String year;
    private String month;
    private String day;
    private String day_name;
    private String hour;
    private String minute;
    private String second;
    private String day_part;
    private String locale;

    public Fuzzy_Date() {
        accuracy = 8;
    }

    public void splitDate(String date) {
        year = date.substring(0, 4);
        decade = date.substring(0, 3);
        decade += "0";
        month = date.substring(5, 7);
        day = date.substring(8, 10);
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day)));
        day_name = cal.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.LONG, Locale.ENGLISH);
        if (date.length() > 10) {
            hour = date.substring(11, 13);
            minute = date.substring(14, 16);
            second = date.substring(17, 19);
            locale = "en";
            int intHour = Integer.parseInt(hour);
            if (intHour >= 05 && intHour < 12) {
                day_part = "morning";
            } else if (intHour >= 12 && intHour < 19) {
                day_part = "afternoon";
            } else if (intHour >= 19 && intHour < 24) {
                day_part = "evening";
            } else if (intHour >= 24 && intHour < 05) {
                day_part = "night";
            }
        }
        /*
          System.out.println(date); System.out.println(year);
          System.out.println(decade); System.out.println(month);
          System.out.println(day);
          System.out.println(cal.getDisplayName(Calendar.DAY_OF_WEEK,
          Calendar.LONG, Locale.ENGLISH)); System.out.println(hour);
          System.out.println(minute); System.out.println(second);
         */
        //System.out.println(day_part);
    }

    public static void main(String[] args) {
        Fuzzy_Date k = new Fuzzy_Date();
        k.splitDate("2012-10-26 09:55:02");
    }

    public Time_Interval getInterval() {
        return interval;
    }

    public void setInterval(Time_Interval interval) {
        this.interval = interval;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getDay_name() {
        return day_name;
    }

    public void setDay_name(String day_name) {
        this.day_name = day_name;
    }

    public String getDay_part() {
        return day_part;
    }

    public void setDay_part(String day_part) {
        this.day_part = day_part;
    }

    public String getDecade() {
        return decade;
    }

    public void setDecade(String decade) {
        this.decade = decade;
    }

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }

    public String getMinute() {
        return minute;
    }

    public void setMinute(String minute) {
        this.minute = minute;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getSecond() {
        return second;
    }

    public void setSecond(String second) {
        this.second = second;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public int getAccuracy() {
        return accuracy;
    }

    public String getLocale() {
        return locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }

    public void setAccuracy(int accuracy) {
        this.accuracy = accuracy;
    }

    public String getExact_date() {
        return exact_date;
    }

    public void setExact_date(String exact_date) {
        this.exact_date = exact_date;
    }

    public int getFuzzy_date_id() {
        return fuzzy_date_id;
    }

    public void setFuzzy_date_id(int fuzzy_date_id) {
        this.fuzzy_date_id = fuzzy_date_id;
    }
}
