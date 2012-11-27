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
import java.util.ArrayList;

public class Stringa {

//    public static void main(String argv[]) {
//        creazioneStringa("Fantozzi", "Kessler");
//    }
    private ArrayList<String[]> datiId1; //titolo e descrizione
    private ArrayList<String[]> datiId2;
    private static int Dim = 2;
    private static int NParam = 3;
    boolean primo;

    public Stringa() {
        datiId1 = new ArrayList<String[]>();
        datiId2 = new ArrayList<String[]>();
        primo = true;
    }

    private String creazioneItems(String nome, String colore) {
        String s = ""; //stringa che conterrà i vari items relativi a un dataset

        //bottone Read More che apre l' overlay
        int VisualizzaConfronto,id;
        if(primo){
            id = 1;
            VisualizzaConfronto = 2;            
        }
        else{
            id = 2;
            VisualizzaConfronto = 1;
        }
        String ReadMore = "<br/><br/><button id='apri' class='btn btn-primary' onmousedown='ApriOverlay(" + id + "," + VisualizzaConfronto + ")'>Read More...</button>";

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
                String[] dati = new String[Dim];
                dati[0] = rs.getString("headline").replace("\"", "");
                dati[1] = rs.getString("text").replace("\"", "");
                
                
                
                if (primo) {
                    datiId1.add(dati);
                } else {
                    datiId2.add(dati);
                }

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
                s += "infoHtml:" + "\"" + "<h3>" + rs.getString("headline") + "</h3>" + tmp + img + ReadMore + "\"";
                s += "}";
                s += "},";
                i++;

                coordinate += "{lat: " + rs.getString("lat") + ",lon:" + rs.getString("lon") + "},";
            }
            s += "]}},";
            //creo linea temporale
            s += "{id:" + "\"Linea temporale " + nome + "\","
                    + "title: \"Prova\","
                    + "type: \"basic\",";
            s += "options: {items: [";
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
                    + "theme: \"" + colore + "\","
                    + "lineWeight: 5";
            s += "}";
            s += "}";
            s += "]}},";
            rs.close();
            st.close();   // Chiudo lo Statement
            db.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        //ritorno gli itema appena creati
        primo = false;
        return s;
    }

    private String creazioneDataset(String nome, String colore) {
        String s = ""; //stringa che conterrà i dataset
        //imposto il nome del primo dataset e le opzioni generali
        s += "{id:" + "\"" + nome + "\","
                + "title: \"" + nome + "\","
                + "type: \"basic\",";
        s += "options: {items: [";
        s += creazioneItems(nome, colore); //creo la stringa per i vari items

        //ritorno il dataset creato
        return s;
    }

    private String ContenutoConfronto(String lista, ArrayList<String[]> dati) {

        lista += "<ul class=\"nav nav-tabs\">";
        String id = dati.get(0)[0].replace(" ","");
        lista += "<li class=\"active\"><a href=\"#" + id + "\" data-toggle=\"tab\">" + dati.get(0)[0] + "</a></li>";
        for (int i = 1; i < dati.size(); i++) {
            id = dati.get(i)[0].replace(" ","");
            lista += "<li><a href=\"#" + id + "\" data-toggle=\"tab\">" + dati.get(i)[0] + "</a></li>";
        }
        lista += "</ul>";

        lista += "<div class=\"tab-content\">";
        id = dati.get(0)[0].replace(" ", "");
        lista += "<div class=\"tab-pane active\" id=\"" +id + "\">";
        lista += "<p>" + dati.get(0)[1] + "</p>";
        lista += "</div>";
        for (int i = 1; i < dati.size(); i++) {
            id = dati.get(i)[0].replace(" ", "");
            lista += "<div class=\"tab-pane\" id=\"" + id + "\">";
            lista += "<p>" + dati.get(i)[1] + "</p>";
            lista += "</div>";
        }
        lista += "</div>";
        return lista;
    }

    private String InizializzaLista(String lista) {
        //lista += "<div class=\"tabbable tabs-left\">";
        if (primo) {
            lista += ContenutoConfronto(lista, datiId1);
        } else {
            lista += ContenutoConfronto(lista, datiId2);
        }
        //lista += "</div>";
        return lista;
    }

    public String[] creazioneStringa(String persona1, String persona2) {
        String[] param = new String[NParam];//stringa contenente tutto il json per la creazione della mappa dinamica
        //setto i parametri principali
        param[0] = "{mapId: \"map\","
                + "timelineId: \"timeline\","
                + "options: {eventIconPath: \"images/\"},"
                + "bandIntervals: \"mon\",";
        param[0] += "datasets:[";

        //String lista1 = "";
        //String lista2 = "";
        param[0] += creazioneDataset(persona1, "red"); //creo il primo dataset
        param[0] += creazioneDataset(persona2, "blue"); //creo il secondo dataset
        param[0] += "]";
        param[0] += "}"; //chiusura esterna

        primo = true;
        param[1] = "";
        param[1] += InizializzaLista(param[1]);
        primo = false;
        param[2] = "";
        param[2] += InizializzaLista(param[2]);

        //System.out.println(s);
        //ritorno tutto il json creato
        return param;
    }
}
