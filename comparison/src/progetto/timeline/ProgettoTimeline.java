/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package progetto.timeline;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

/**
 *
 * @author Junkie
 */
public class ProgettoTimeline {
    static final double DistanceConstant = 0.00018;
    static final double TimeConstant = 0.02465753424;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        boolean end = false;
        String command;
        
        do
        {
            System.out.print("Console> ");
            command = input.next();
            command = command.toLowerCase();
            switch(command)
            {
                case "comparison": Comparison(); break;
                case "time": Time(); break;
                case "distance": Distance(); break;
                case "quit": end = true; break;
                default: System.out.println("Console: Unknown command '" + command + "'"); break;
            }
        }while(!end);
        System.out.println("Console: Run successful...");
    }
    
    static double CalculateDistance(Coordinate c1, Coordinate c2)
    {
        double CircleOfLatitudeLenght;
        double d1 = (c1.Latitude() - c2.Latitude())*111111;
        if(c1.Longitude()>c2.Longitude())
        {
            CircleOfLatitudeLenght = 40075 * Math.cos(c1.Longitude())/360;
        }
        else
        {
            CircleOfLatitudeLenght = 40075 * Math.cos(c2.Longitude())/360;
        }
        double d2 = (c1.Longitude() - c2.Longitude()) * CircleOfLatitudeLenght;
        int distance = (int)Math.sqrt(d1 * d1 + d2 * d2);
        double distanceScore = 1/(DistanceConstant * distance + 1);
        return distanceScore;
    }
    
    static double CalculateTimeDistance(Date d1, Date d2)
    {
        if(d1.compareTo(d2) == -1)
        {
            Date tmp;
            tmp = d1;
            d1 = d2;
            d2 = tmp;
        }
        long difference = (d1.getTime() - d2.getTime())/(24 * 60 * 60 * 1000);
        double timeScore = 1/(TimeConstant * difference + 1);
        return timeScore;
    }
    
    static double EventDistance(Event e1, Event e2)
    {
        double d = CalculateDistance(e1.Location(), e2.Location());
        double td = CalculateTimeDistance(e1.Time(), e2.Time());
        double res =  d * td;
        return res;
    }
    
    static void Time()
    {
        Scanner input = new Scanner(System.in);
        Connection con = null;
        Statement st = null;
        ResultSet rs = null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            //Otteniamo una connessione con username e password
            con = DriverManager.getConnection ("jdbc:mysql://test.lifeparticipation.org:3306/reminiscens", "reminiscens", "timeline@lp2012");
            System.out.println("Connection successful");
            
            st = (Statement) con.createStatement();
            rs = st.executeQuery("SELECT * from Time_Interval");
            
            rs.next();
            
            Date startdate = rs.getDate("startdate");
            Date enddate = new Date(startdate.getYear()+1, startdate.getMonth(), startdate.getDate());
            System.out.print("Distance between " + startdate + " and " + enddate + " = ");
            System.out.println(CalculateTimeDistance(startdate, enddate));
        }
        catch(Exception ex){
            System.out.println("Console: " + ex.getMessage());
        }
        finally{
            try{
                if (rs != null) {
                    rs.close();
                }
                if (st != null) {
                    st.close();
                }
                if (con != null) {
                    con.close();
                }
            }
            catch(Exception f){}
        }
    }
    
    static void Distance()
    {
        Scanner input = new Scanner(System.in);
        Connection con = null;
        Statement st = null;
        ResultSet rs = null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection ("jdbc:mysql://test.lifeparticipation.org:3306/reminiscens", "reminiscens", "timeline@lp2012");
            System.out.println("Connection successful");
            
            System.out.print("Insert first city name: ");
            String city1 = input.next();
            System.out.print("Insert second city name: ");
            String city2 = input.next();
            
            st = (Statement) con.createStatement();
            rs = st.executeQuery("SELECT * from City where city_name = '" + city1 + "' OR city_name = '" + city2 + "'");

            if(city1.equals(city2))
            {
                double res = CalculateDistance(new Coordinate(0,0), new Coordinate(0,0));
                System.out.println("Distance between " + city1 + " and " + city2 + " = " + res);
            }
            if(rs.next())
            {
                double lat = rs.getDouble("lat");
                double lon = rs.getDouble("lon");
                Coordinate c1 = new Coordinate(lat, lon);
                if(rs.next())
                {
                    lat = rs.getDouble("lat");
                    lon = rs.getDouble("lon");
                    Coordinate c2 = new Coordinate(lat, lon);
                    double res = CalculateDistance(c1,c2);
                    System.out.println("Distance between " + city1 + " and " + city2 + " = " + res);
                }
                else
                {
                    System.out.println("Console: can't find the city in the DB");
                }
            }
            else
            {
                System.out.println("Console: can't find the city in the DB");
            }
        }
        catch(Exception ex){
            System.out.println("Console: " + ex.getMessage());
        }
        finally{
            try{
                if (rs != null) {
                    rs.close();
                }
                if (st != null) {
                    st.close();
                }
                if (con != null) {
                    con.close();
                }
            }
            catch(Exception f){}
        }
    }
    
    static void Comparison()
    {
        Scanner input = new Scanner(System.in);
        Connection con = null;
        Statement st = null;
        ResultSet rs = null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            //Otteniamo una connessione con username e password
            con = DriverManager.getConnection ("jdbc:mysql://test.lifeparticipation.org:3306/reminiscens", "reminiscens", "timeline@lp2012");
            System.out.println("Connection successful");
            st = (Statement) con.createStatement();
            
            System.out.print("Insert first ID: ");
            int person1 = Integer.parseInt(input.next());
            rs = st.executeQuery("SELECT * from Life_Event, Location, Time_Interval, Participant, Person, City where Life_Event.life_event_id = Participant.life_event_id AND Person.person_id = Participant.person_id AND Life_Event.location_id = Location.location_id AND Life_Event.time_interval_id = Time_Interval.time_interval_id AND Location.city = City.city_name AND Person.person_id = '" + person1 + "'");
            ArrayList<Event> tm1 = new ArrayList<> ();
            
            while(rs.next())
            {
                Event e = new Event(rs.getInt("life_event_id"), rs.getString("city"), new Coordinate(rs.getDouble("City.lat"), rs.getDouble("City.lon")), rs.getDate("startdate"));
                if(tm1.add(e)) {
                    System.out.println(rs.getInt("person_id") + " " + rs.getString("firstname") + " " + rs.getString("lastname") + " " + rs.getInt("life_event_id") + " " + rs.getString("city") + " " + rs.getDate("startdate"));
                }
            }
            if(tm1.isEmpty())
            {
                System.out.println("Error: ID didn't found or no event with that ID");
                return;
            }
            
            System.out.print("Insert second ID: ");
            int person2 = Integer.parseInt(input.next());
            rs = st.executeQuery("SELECT * from Life_Event, Location, Time_Interval, Participant, Person, City where Life_Event.life_event_id = Participant.life_event_id AND Person.person_id = Participant.person_id AND Life_Event.location_id = Location.location_id AND Life_Event.time_interval_id = Time_Interval.time_interval_id AND Location.city = City.city_name AND Person.person_id = '" + person2 + "'");
            ArrayList<Event> tm2 = new ArrayList<> ();
            
            while(rs.next())
            {
                Event e = new Event(rs.getInt("life_event_id"), rs.getString("city"), new Coordinate(rs.getDouble("City.lat"), rs.getDouble("City.lon")), rs.getDate("startdate"));
                if(tm2.add(e)) {
                    System.out.println(rs.getInt("person_id") + " " + rs.getString("firstname") + " " + rs.getString("lastname") + " " + rs.getInt("life_event_id") + " " + rs.getString("city") + " " + rs.getDate("startdate"));
                }
            }
            if(tm2.isEmpty())
            {
                System.out.println("Error: ID didn't found or no event with that ID");
                return;
            }

            //ArrayList<Double> dv = new ArrayList<>();
            Iterator it1 = tm1.iterator();
            while(it1.hasNext()){
                Event e1 = (Event) it1.next();
                Iterator it2 = tm2.iterator();
                while(it2.hasNext()){
                    Event e2 = (Event) it2.next();
                    System.out.println("Couple " + e1.ID() + ";" + e2.ID() + " = " + EventDistance(e1, e2));
                    //dv.add(new Double(EventDistance(e1, e2)));
                } 
            }
            
            /*
            //Arrays.sort(dv);
            System.out.println("Stampa array delle distanze");
            Iterator itdv = dv.iterator();
            while(itdv.hasNext()){
                System.out.println((Double) itdv.next());
            }*/
            
            /*rs = st.executeQuery("SELECT * from Life_Event, Location, Time_Interval where Life_Event.location_id = Location.location_id AND Life_Event.time_interval_id = Time_Interval.time_interval_id");
            
            Event[] e = new Event[2];
            int i = 0;
            while(rs.next() && i < 2)
            {    
                System.out.print(rs.getInt("life_event_id") + " " + rs.getString("city") + " " + rs.getDate("startdate"));
                if(rs.getDate("startdate") == null || rs.getDate("enddate") == null || rs.getString("city") == null) {
                    continue;
                }
                e[i] = new Event(rs.getString("city"), rs.getDate("startdate"));
                if(e[i].Location() != null && rs.getDate("startdate").compareTo(rs.getDate("enddate")) == 0)
                {
                    i++;
                    System.out.println(" OK");
                }
                else {
                    System.out.println(" NO");
                }
            }
            System.out.println("Distance between the events = " + EventDistance(e[0], e[1]));
            */
        }
        catch(Exception ex){
            System.out.println("Console: " + ex.getMessage());
        }
        finally{
            try{
                if (rs != null) {
                    rs.close();
                }
                if (st != null) {
                    st.close();
                }
                if (con != null) {
                    con.close();
                }
            }
            catch(Exception f){}
        }
    }
}

class Coordinate
{
    private double _latitude, _longitude;
    public Coordinate(double latitude, double longitude) {
        _latitude = latitude;
        _longitude = longitude;
    }
    
    public double Latitude(){
        return _latitude;
    }
    public double Longitude(){
        return _longitude;
    }
}

class Event
{
    private int _id;
    private String _city;
    private Coordinate _location;
    private Date _time;
    
    public Event(int id, String city, Coordinate location, Date time)
    {
        _id = id;
        _city = city;
        _time = time;
        _location = location;
    }
    
    static double EventDistance(Event e1, Event e2)
    {
        //double d = CalculateDistance(e1.Location(), e2.Location());
        //double td = CalculateTimeDistance(e1.Time(), e2.Time());
        //double res =  d * td;
        return 0.1;
    }
    
    public int ID(){
        return _id;
    }
    
    public Coordinate Location(){
        return _location;
    }
    
    public Date Time(){
        return _time;
    }
    
    public String City(){
        return _city;
    }
}

class Timeline
{
    private String _name;
    private int _id;
    private ArrayList<Event> _timeline;
    
    public Timeline(int id, String nome)
    {
        _id = id;
        _name = nome;
    }
    
    public void NewEvent(Event e)
    {
        _timeline.add(e);
    }
    
    
    
    public int ID(){
        return _id;
    }
    
    public String Nome(){
        return _name;
    }
}