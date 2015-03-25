package db;

import db.entities.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 * Created by david on 25/03/2015.
 */
public class ManagerHelper {

    public static void addTagToBand(SessionFactory sessionFactory, Band band, Tag tag){
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        band.addTag(tag);
        session.saveOrUpdate(band);

        session.getTransaction().commit();
        session.close();
    }
    
    public static void addTagToPerson(SessionFactory sessionFactory, Person per, Tag tag){
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        per.addTag(tag);
        session.saveOrUpdate(per);

        session.getTransaction().commit();
        session.close();
    }
    
    public static void addSkillToPerson(SessionFactory sessionFactory, Person per, Skill skill){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        
        per.addSkill(skill);
        session.saveOrUpdate(per);

        session.getTransaction().commit();
        session.close();        
    }

    public static void addPublicationToPublisher(SessionFactory sessionFactory, Publisher publisher, Publication publication) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        publication.setPublisher(publisher);
        session.save(publication);

        session.getTransaction().commit();
        session.close();
    }
    
    public static void addPersonToBand(SessionFactory sessionFactory, Person per, Band band){
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        per.addBand(band);
        session.saveOrUpdate(per);

        session.getTransaction().commit();
        session.close();
    }
    
    public static void createBand(SessionFactory sessionFactory, Band band, Publisher pub){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        
        session.persist(pub);
        band.setId(pub.getId());
        band.setPublisher(pub);
        session.save(band);

        session.getTransaction().commit();
        session.close();
        
    }

    public static void createPerson(SessionFactory sessionFactory, Person per, Publisher pub){
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        session.persist(pub);
        per.setId(pub.getId());
        per.setPublisher(pub);
        session.save(per);

        session.getTransaction().commit();
        session.close();
    }
}
