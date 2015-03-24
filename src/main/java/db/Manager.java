package db;

import db.entities.Band;
import db.entities.Person;
import db.entities.Publisher;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

/**
 * Created by david on 24/03/2015.
 */
public class Manager {

    public static void main(String[] args) {

        SessionFactory sessionFactory;

        Configuration configuration = new Configuration();
        configuration.configure();
        ServiceRegistry serviceRegistry = new ServiceRegistryBuilder()
                .applySettings(configuration.getProperties())
                .buildServiceRegistry();
        sessionFactory = configuration.buildSessionFactory(serviceRegistry);

        Session session = sessionFactory.openSession();
        session.beginTransaction();

        Publisher pub1 = new Publisher(false);
        Person per1 = new Person("David","foo@bar.com",648701);
        session.persist(pub1);
        per1.setId(pub1.getId());
        per1.setPublisher(pub1);
        session.save(per1);
        
        session.getTransaction().commit();
        session.close();

        session = sessionFactory.openSession();
        session.beginTransaction();

        Publisher pub2 = new Publisher(false);
        Person per2 = new Person("Adrian","herp@derp.com",642535);
        session.persist(pub2);
        per2.setId(pub2.getId());
        per2.setPublisher(pub2);
        session.save(per2);

        session.getTransaction().commit();
        session.close();

        session = sessionFactory.openSession();
        session.beginTransaction();

        Publisher pub3 = new Publisher(true);
        Band g = new Band("4real");
        session.persist(pub3);
        g.setId(pub3.getId());
        g.setPublisher(pub3);
        session.save(g);
        
        session.getTransaction().commit();
        session.close();
        
    }
}
