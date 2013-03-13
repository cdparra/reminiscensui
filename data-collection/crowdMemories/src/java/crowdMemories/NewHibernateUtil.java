/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package crowdMemories;

import java.sql.Timestamp;
import java.util.Iterator;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 * Hibernate Utility class with a convenient method to get Session Factory
 * object.
 *
 * @author francesco
 */
public class NewHibernateUtil {

    private static final SessionFactory sessionFactory;

    static {
        try {
            // Create the SessionFactory from standard (hibernate.cfg.xml) 
            // config file.
            sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            // Log the exception. 
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public Integer addMedia(Media media) {

        Session session = this.getSessionFactory().openSession();
        Transaction tx = null;
        Integer mediaID = null;

        try {
            tx = session.beginTransaction();

            Timestamp now = new Timestamp(System.currentTimeMillis());
            media.setLast_update(now);
            //inserisco nel database il media
            mediaID = (Integer) session.save(media);

            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }

        return mediaID;
    }

    public Album_Media addAlbum_Media(String album_id, String media_id) {

        Session session = this.getSessionFactory().openSession();
        Transaction tx = null;

        Album_Media AM = null;

        try {
            tx = session.beginTransaction();

            Album_Media am = new Album_Media(album_id, media_id);
            AM = (Album_Media) session.save(am);

            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return AM;
    }
}
