
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package crowdMemories;
//package np.reminiscens.crawler;

import java.sql.*;
//import np.reminiscens.crawler.entities.City;
//import np.reminiscens.crawler.entities.Event;
//import np.reminiscens.crawler.entities.Media;
//import np.reminiscens.crawler.entities.Person;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;

public class Databasep {
    //Database  WEB

    private final String DB_USER = "reminiscens";
    private final String DB_NAME = "jdbc:mysql://test.lifeparticipation.org:3306/reminiscens";
    private final String DB_PASSWORD = "timeline@lp2012";
    private final String DB_DRIVER = "com.mysql.jdbc.Driver";
    Connection con = null;
    private Statement st = null;
    private String data;
    private static SessionFactory factory;

    /*
     public Databasep() {

     try {
     factory = new Configuration().configure().buildSessionFactory();
     } catch (Throwable ex) {
     System.err.println("Failed to create sessionFactory object." + ex);
     throw new ExceptionInInitializerError(ex);
     }

     connetti();
     }

     public boolean connessioneChiusa() throws SQLException {
     return this.con.isClosed();
     }

     public void connetti() {
     try {
     Class.forName(DB_DRIVER);
     con = DriverManager.getConnection(DB_NAME, DB_USER, DB_PASSWORD);
     st = con.createStatement();
     } catch (Exception ex) {
     System.err.println(ex);
     }
     }
     
     public Integer addEvent(Event event) {
     Session session = factory.openSession();
     Transaction tx = null;
     Integer eventID = null;
     try {
     tx = session.beginTransaction();
     Timestamp now = new Timestamp(System.currentTimeMillis());
     event.setLast_update(now);
     Query query = session.createQuery("SELECT event_id FROM Event WHERE source_url = :url");
     query.setParameter("url", event.getSource_url());
     if (!(query.list().isEmpty())) {
     event.setEvent_id((Integer) (query.list().get(0)));
     session.update(event);
     } else {
     session.saveOrUpdate(event);
     }
     eventID = event.getEvent_id();
     tx.commit();
     } catch (HibernateException e) {
     if (tx != null) {
     tx.rollback();
     }
     e.printStackTrace();
     } finally {
     session.close();
     }
     return eventID;
     }

     public Integer addMedia(Media photo) {
     Session session = factory.openSession();
     Transaction tx = null;
     Integer photoID = null;
     try {
     tx = session.beginTransaction();
     Timestamp now = new Timestamp(System.currentTimeMillis());
     photo.setLast_update(now);
     Query query = session.createQuery("SELECT media_id FROM Media WHERE media_url = :url");
     query.setParameter("url", photo.getMedia_url());
     if (!(query.list().isEmpty())) {
     photo.setMedia_id((Integer) (query.list().get(0)));
     session.update(photo);
     } else {
     session.saveOrUpdate(photo);
     }
     photoID = photo.getMedia_id();
     tx.commit();
     } catch (HibernateException e) {
     if (tx != null) {
     tx.rollback();
     }
     e.printStackTrace();
     } finally {
     session.close();
     }

     return photoID;
     }

     public Integer addCity(City city) {
     Session session = factory.openSession();
     Transaction tx = null;
     Integer cityID = null;
     try {
     tx = session.beginTransaction();
     Query query = session.createQuery("SELECT event_id FROM City WHERE city_name = :name");
     query.setParameter("name", city.getCity_name());
     if (!(query.list().isEmpty())) {
     city.setCity_id((Integer) (query.list().get(0)));
     session.update(city);
     } else {
     session.saveOrUpdate(city);
     }
     cityID = city.getCity_id();
     tx.commit();
     } catch (HibernateException e) {
     if (tx != null) {
     tx.rollback();
     }
     e.printStackTrace();
     } finally {
     session.close();
     }
     return cityID;
     }

     public Integer addPerson(Person person) {
     Session session = factory.openSession();
     Transaction tx = null;
     Integer personID = null;
     try {
     tx = session.beginTransaction();
     Timestamp now = new Timestamp(System.currentTimeMillis());
     person.setLast_update(now);
     Query query = session.createQuery("SELECT person_id FROM Person WHERE source_url = :url");
     query.setParameter("url", person.getSource_url());
     if (!(query.list().isEmpty())) {
     person.setPerson_id((Integer) (query.list().get(0)));
     session.update(person);
     } else {
     session.saveOrUpdate(person);
     }
     personID = person.getPerson_id();
     tx.commit();
     } catch (HibernateException e) {
     if (tx != null) {
     tx.rollback();
     }
     e.printStackTrace();
     } finally {
     session.close();
     }
     return personID;
     }
     */
}
