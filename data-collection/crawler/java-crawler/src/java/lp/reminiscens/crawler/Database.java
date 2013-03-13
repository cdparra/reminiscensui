/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lp.reminiscens.crawler;

import java.sql.*;
import java.util.List;
import lp.reminiscens.crawler.entities.City;
import lp.reminiscens.crawler.entities.Event;
import lp.reminiscens.crawler.entities.Media;
import lp.reminiscens.crawler.entities.Media_Metadata;
import lp.reminiscens.crawler.entities.Person;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;

public class Database {

    private final String DB_USER = "reminiscens";
    private final String DB_NAME = "jdbc:mysql://test.lifeparticipation.org:3306/reminiscens";
    private final String DB_PASSWORD = "timeline@lp2012";
    private final String DB_DRIVER = "com.mysql.jdbc.Driver";
    private static SessionFactory factory;
    public int newEvents = 0;
    public int newPeople = 0;
    public int newMedia = 0;
    public int newWorks = 0;

    public Database() {
        try {
            factory = new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Failed to create SessionFactory object." + ex);
            throw new ExceptionInInitializerError(ex);
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
                newEvents++;
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
                newMedia++;
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
                newPeople++;
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

    public Integer addWork(Media_Metadata mediaMD) {
        Session session = factory.openSession();
        Transaction tx = null;
        Integer workID = null;
        try {
            tx = session.beginTransaction();
            Query query = session.createQuery("SELECT person_id FROM Person WHERE source_url = :url");
            query.setParameter("url", mediaMD.getSource_url());
            if (!(query.list().isEmpty())) {
                mediaMD.setMedia_metadata_id((Integer) (query.list().get(0)));
                session.update(mediaMD);
            } else {
                session.saveOrUpdate(mediaMD);
                newWorks++;
            }
            workID = mediaMD.getMedia_metadata_id();
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return workID;
    }

    //USATA SOLO PER PRENDERE LE COORDINATE DELLE CITTà ITALIANE
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

    public List getEvents() {
        Session session = factory.openSession();
        Transaction tx = null;
        Query query = null;
        try {
            tx = session.beginTransaction();
            query = session.createQuery("FROM Event");
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }

        if (query == null) {
            return null;
        } else {
            return query.list();
        }
    }

    public List getMDs() {
        Session session = factory.openSession();
        Transaction tx = null;
        Query query = null;
        try {
            tx = session.beginTransaction();
            query = session.createQuery("FROM Media_Metadata");
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }

        if (query == null) {
            return null;
        } else {
            return query.list();
        }
    }

    public List getPeople() {
        Session session = factory.openSession();
        Transaction tx = null;
        Query query = null;
        try {
            tx = session.beginTransaction();
            query = session.createQuery("FROM Person");
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }

        if (query == null) {
            return null;
        } else {
            return query.list();
        }
    }

    public List getMedia() {
        Session session = factory.openSession();
        Transaction tx = null;
        Query query = null;
        try {
            tx = session.beginTransaction();
            query = session.createQuery("FROM Media");
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }

        if (query == null) {
            return null;
        } else {
            return query.list();
        }
    }
}