package db;

import db.entities.*;
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

        // CREATE PERSON 1
        Publisher pub1 = new Publisher(false);
        Person per1 = new Person("David","foo@bar.com",648701);
        ManagerHelper.createPerson(sessionFactory,per1,pub1);

        // CREATE PERSON 2
        Publisher pub2 = new Publisher(false);
        Person per2 = new Person("Adrian","herp@derp.com",642535);
        ManagerHelper.createPerson(sessionFactory, per2, pub2);
        
        // CREATE BAND
        Publisher pub3 = new Publisher(true);
        Band band1 = new Band("4real");
        ManagerHelper.createBand(sessionFactory, band1, pub3);
        
        // ADD PERSON 1 TO BAND 1
        ManagerHelper.addPersonToBand(sessionFactory, per1, band1);
        
        // CREATE PUBLICATION 1 FOR PERSON 1 (PUBLISHER 1)
        Publication publication1 = new Publication(System.currentTimeMillis(),"herp derp");
        ManagerHelper.addPublicationToPublisher(sessionFactory, pub1, publication1);

        // CREATE PUBLICATION 2 FOR BAND 1 (PUBLISHER 3)
        Publication publication2 = new Publication(System.currentTimeMillis(),"addSkillToPerson");
        ManagerHelper.addPublicationToPublisher(sessionFactory, pub3, publication2);

        // ADD PERSON 2 SKILL 1
        Skill skill1 = new Skill("guitar");
        ManagerHelper.addSkillToPerson(sessionFactory, per2, skill1);
        
        //ADD PERSON 1 TAG 1
        Tag tag1 = new Tag("zaragoza");
        ManagerHelper.addTagToPerson(sessionFactory, per1, tag1);

        //ADD BAND 1 TAG 1
        ManagerHelper.addTagToBand(sessionFactory, band1, tag1);
        
    }
}
