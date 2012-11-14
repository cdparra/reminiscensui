/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package crowdMemories;

import java.sql.*;
import java.util.*;

public class Database {
    //Database  WEB

    private final String DB_USER = "reminiscens";
    private final String DB_NAME = "jdbc:mysql://test.lifeparticipation.org:3306/reminiscens";
    private final String DB_PASSWORD = "timeline@lp2012";
    private final String DB_DRIVER = "com.mysql.jdbc.Driver";
    Connection con = null;
    private Statement st = null;

    public Database() {
        this.getConnection();
    }

    private void getConnection() {
        try {
            Class.forName(DB_DRIVER).newInstance();
            con = DriverManager.getConnection(DB_NAME, DB_USER, DB_PASSWORD);
            st = (Statement) con.createStatement();
        } catch (Exception ex) {
            System.err.println(ex);
        }
    }

    private void endConnection() {
        if (con != null) {
            try {
                con.close();
            } catch (Exception e) {
                System.err.println(e);
            }
        }
    }

    public void addMedia(int media_id, String media_url, String media_type, String caption, String text, String source, String source_url, Timestamp last_update, boolean is_public, int location_id, int time_interval_id) throws SQLException {
        try {
            st.executeUpdate("INSERT INTO reminiscens.Media (media_id, media_url, media_type, caption, text, source, source_url, last_update, is_public, location_id, time_interval_id)"
                    + " VALUES ('" + media_id + "', '" + media_url + "', '" + media_type + "', '" + caption + "', '" + text + "', '" + source + "', '" + source_url + "', '" + last_update + "', '" + is_public + "', '" + location_id + "', '" + time_interval_id + "')");
        } catch (SQLException e) {
            System.err.print(e);
        }
    }

    public void addLocation(int location_id, String location_textual, int location_accuracy, String name, String description, String environment, String continent, String country, String city, String neighborhood, int location_type_id, float lat, float lon) {

        try {
            st.executeUpdate("INSERT INTO reminiscens.Location VALUES ('" + location_id + "', '" + location_textual + "', '" + location_accuracy + "', '" + name + "', '" + description + "', '" + environment + "', '" + continent + "', '" + country + "', '" + city + "', '" + neighborhood + "', '" + location_type_id + "', '" + lat + "', '" + lon + ")");
        } catch (SQLException e) {
            System.err.print(e);
        }
    }

    public void addTime_Interval(int time_interval_id, String duration_unit, String duration_amount, Timestamp startdate, Timestamp enddate, boolean is_fuzzy, int fuzzy_startdate, int fuzzy_enddate) {
        try {
            st.executeUpdate("INSERT INTO reminiscens.Time_Interval VALUES ('" + time_interval_id + "', '" + duration_unit + "', '" + duration_amount + "', '" + startdate + "', '" + enddate + "', '" + is_fuzzy + "', '" + fuzzy_startdate + "', '" + fuzzy_enddate + "')");

        } catch (SQLException e) {
            System.err.print(e);
        }
    }

    public void addFuzzyDate(int fuzzy_date_id, String textual_date, Timestamp exact_date, int decade, int year, String season, int month, int day, String day_name, String day_part, int hour, int minute, int second, int accuracy) {
        try {
            st.executeUpdate("INSERT INTO reminiscens.Time_Interval VALUES ('" + fuzzy_date_id + "', '" + textual_date + "', '" + exact_date + "', '" + decade + "', '" + year + "', '" + season + "', '" + month + "', '" + day + "', '" + day_name + "', '" + day_part + "', '" + hour + "', '" + minute + "', '" + second + "', '" + accuracy + "')");

        } catch (SQLException e) {
            System.err.print(e);
        }
    }

    public void addEvent(int event_id, String headline, String text, String type, String source, String source_url, Timestamp last_update, int location_id, int time_interval_id) {
    }
    Timestamp now = new Timestamp(System.currentTimeMillis());

    public Timestamp gettime() {
        return new Timestamp(System.currentTimeMillis());
    }
    
    
}
