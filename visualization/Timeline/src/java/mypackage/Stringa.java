/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author J
 */
package mypackage;

import java.sql.*;

public class Stringa {

//    public static void main(String argv[]) {
//        creazioneStringa("Fantozzi", "Kessler");
//    }

    public Stringa() {
    }

    private String creazioneItems(String nome, String colore) {
        String s = ""; //stringa che conterrà i vari items relativi a un dataset
        
        //bottone Read More che apre l' overlay
        String ReadMore = "<br/><br/><button id='apri' class='btn btn-primary' onmousedown='ApriOverlay()'>Read More...</button>";

        Connection db = null;
        Statement st = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            db = DriverManager.getConnection("jdbc:mysql://test.lifeparticipation.org/reminiscens", "reminiscens", "timeline@lp2012");
            st = db.createStatement();
            
            //recupero i dati necessari a creare gli item relativi a una persona
            String query = "SELECT startdate,enddate,lat,lon,headline,text,memento_url "
                    + "FROM reminiscens.Life_Event,reminiscens.Participant, reminiscens.Location, reminiscens.Time_Interval, reminiscens.Memento,reminiscens.Person "
                    + "WHERE Life_Event.life_event_id = Participant.life_event_id AND Location.location_id = Life_Event.location_id AND "
                    + "Time_Interval.time_interval_id = Life_Event.time_interval_id AND Life_Event.life_event_id = Memento.life_event_id AND "
                    + "Participant.person_id = Person.person_id AND "
                    + "lastname = '" + nome + "' "
                    + "ORDER BY startdate;";
            ResultSet rs = st.executeQuery(query);
            String coordinate = ""; //serve per salvare le coordinate che verranno utilizzate per creare la linea temporale

            int i = 1;
            //imposto le varie opzioni di ciascun item
            while (rs.next()) {
                s += "{";
                s += "start:" + "\"" + rs.getString("startdate") + "\"" + ",";
                s += "point:{" + "lat:" + "\"" + rs.getString("lat") + "\"" + ",lon:" + "\"" + rs.getString("lon") + "\"" + "},";
                s += "title:" + "\"" + rs.getString("headline") + "\"" + ",";
                s += "options:{";
                s += "theme: new TimeMapTheme({";
                s += "icon: \"images/markerIcons/largeTD" + colore + "Icons_1/marker" + i + ".png\","
                        + "iconSize: [20, 34],"
                        + "iconAnchor: [10, 35],"
                        + "eventIconImage: \"" + colore + "-circle.png\","
                        + "color: \"" + colore + "\"";
                s += "}),";
                String tmp = rs.getString("text");
                tmp = tmp.replaceAll("\"", "\\\\\"");
                String img = "</br></br><img src='" + rs.getString("memento_url") + "' style='height:100px;'/>";
                s += "infoHtml:" + "\"" + tmp + img + ReadMore + "\"";
                s += "}";
                s += "},";
                i++;

                coordinate += "{lat: " + rs.getString("lat") + ",lon:" + rs.getString("lon") + "},";
            }
            //creo linea temporale
            s += "{";
            //prelevo la data più vecchia 
            rs.first();
            s += "start: \"" + rs.getString("startdate") + "\",";
            //recupero la data più recente            
            query = "SELECT enddate "
                    + "FROM reminiscens.Life_Event,reminiscens.Participant, reminiscens.Time_Interval,reminiscens.Person "
                    + "WHERE Life_Event.life_event_id = Participant.life_event_id AND "
                    + "Time_Interval.time_interval_id = Life_Event.time_interval_id AND "
                    + "Person.person_id = Participant.person_id AND "
                    + "lastname = '" + nome + "' "
                    + "ORDER BY enddate DESC;";
            rs = st.executeQuery(query);
            rs.next();
            s += "end: \"" + rs.getString("enddate") + "\",";
            //inserisco valori della linea temporale
            s += "polyline: [" + coordinate + "],";
            s += "title: \"Vita " + nome + "\",";
            s += "options:{";
            s += "description: \"Vita " + nome + "\","
                    + "theme: \""+ colore +"\","
                    + "lineWeight: 5";
            s += "}";
            s += "}";
            rs.close();
            st.close();   // Chiudo lo Statement
            db.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        //ritorno gli itema appena creati
        return s;
    }

    private String creazioneDataset(String nome, String colore) {
        String s = ""; //stringa che conterrà i dataset
        //imposto il nome del primo dataset e le opzioni generali
        s += "{id:" + "\"" + nome + "\","
                + "title: \"Prova\","
                + "type: \"basic\",";
        s += "options: {items: [";
        s += creazioneItems(nome, colore); //creo la stringa per i vari items
        s += "]}},";
        //ritorno il dataset creato
        return s;
    }

    public String creazioneStringa(String persona1, String persona2) {
        String s;//stringa contenente tutto il json per la creazione della mappa dinamica
        //setto i parametri principali
        s = "{mapId: \"map\","
                + "timelineId: \"timeline\","
                + "options: {eventIconPath: \"images/\"},"
                + "bandIntervals: \"mon\",";
        s += "datasets:[";
        s += creazioneDataset(persona1, "red"); //creo il primo dataset
        s += creazioneDataset(persona2, "blue"); //creo il secondo dataset
        s += "]";
        s += "}"; //chiusura esterna

        //System.out.println(s);
        //ritorno tutto il json creato
        return s;
    }
}
