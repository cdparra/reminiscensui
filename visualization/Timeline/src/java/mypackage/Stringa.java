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
    private ArrayList<String[]> datiId1; //titolo, descrizione e img
    private ArrayList<String[]> datiId2; //titolo, descrizione e img
    private static int Dim = 3; //numero parametri per il vettore utilizzateo per la creazione dei dati per il confronto
    private static int NParam = 3; //numero parametri ritornati

    public Stringa() {
        datiId1 = new ArrayList<String[]>();
        datiId2 = new ArrayList<String[]>();
    }

    private String creazioneItems(String nome, String colore, ArrayList<String[]> dati, int id, int VisualizzaConfronto) {
        String s = ""; //stringa che conterrà i vari items relativi a un dataset

        //bottone Read More che apre l' overlay
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
                String[] datiTmp = new String[Dim];
                datiTmp[0] = rs.getString("headline").replace("\"", ""); //recupero titolo
                datiTmp[1] = rs.getString("text").replace("\"", ""); //recupero descrizione
                datiTmp[2] = rs.getString("memento_url").replace("\"", ""); //recupero immagine

                //devo capire in quale ArrayList devo inserire le info
                dati.add(datiTmp);

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
                    + "title:" + "\"Linea temporale " + nome + "\","
                    + "type: \"basic\",";
            s += "options: {items: [";
            if (i != 1) {
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
            }
            rs.close();
            st.close();   // Chiudo lo Statement
            db.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        //dopo aver eseguito il metodo la prima volta lo setto primo su false in modo da salavre i dati per il confronto nel secondo ArrayList
        //ritorno gli itema appena creati
        return s;
    }

    private String creazioneDataset(String nome, String colore, ArrayList<String[]> dati, int id, int VisualizzaConfronto) {
        String s = ""; //stringa che conterrà i dataset
        //imposto il nome del primo dataset e le opzioni generali
        s += "{id:" + "\"" + nome + "\","
                + "title: \"" + nome + "\","
                + "type: \"basic\",";
        s += "options: {items: [";
        s += creazioneItems(nome, colore, dati, id, VisualizzaConfronto); //creo la stringa per i vari items
        s += "]}},";

        //ritorno il dataset creato
        return s;
    }

    //creo il contenuto del confronto
    private String ContenutoConfronto(String lista, ArrayList<String[]> dati) {

        //controllo che ci siano dati
        if (dati.size() > 0) {
            //inserisco titoli
            lista += "<ul class=\"nav nav-tabs\">";

            String id = dati.get(0)[0].replace(" ", "");
            lista += "<li class=\"active\"><a href=\"#" + id + "\" data-toggle=\"tab\">" + dati.get(0)[0] + "</a></li>";
            for (int i = 1; i < dati.size(); i++) {
                id = dati.get(i)[0].replace(" ", "");
                lista += "<li><a href=\"#" + id + "\" data-toggle=\"tab\">" + dati.get(i)[0] + "</a></li>";
            }
            lista += "</ul>";

            //inserico contenuto schede
            lista += "<div class=\"tab-content\">";
            id = dati.get(0)[0].replace(" ", "");
            lista += "<div class=\"tab-pane active\" id=\"" + id + "\">";
            lista += "<p>" + dati.get(0)[1] + "</p>";
            lista += "<img src='" + dati.get(0)[2] + "'/>";
            lista += "</div>";
            for (int i = 1; i < dati.size(); i++) {
                id = dati.get(i)[0].replace(" ", "");
                lista += "<div class=\"tab-pane\" id=\"" + id + "\">";
                lista += "<p>" + dati.get(i)[1] + "</p>";
                lista += "<img src='" + dati.get(i)[2] + "'/>";
                lista += "</div>";
            }
            lista += "</div>";
        }
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
        param[0] += creazioneDataset(persona1, "red", datiId1, 1, 2); //creo il primo dataset
        param[0] += creazioneDataset(persona2, "blue", datiId2, 2, 1); //creo il secondo dataset
        param[0] += "]";
        param[0] += "}"; //chiusura esterna

        param[1] = "";
        param[1] += ContenutoConfronto(param[1], datiId1); //creo il primo confronto (con i dati della seconda persona)
        param[2] = "";
        param[2] += ContenutoConfronto(param[2], datiId2);//creo il secondo confronto (con i dati della prima persona)

        //System.out.println(s);
        return param;
    }
}
