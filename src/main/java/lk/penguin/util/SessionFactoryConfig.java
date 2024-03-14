package lk.penguin.util;

import lk.penguin.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SessionFactoryConfig {
    private static SessionFactoryConfig factoryConfig;
    private final SessionFactory sessionFactory;

    private SessionFactoryConfig(){
        sessionFactory=new Configuration()
                .mergeProperties(Utility.getProperties())
                .addAnnotatedClass(Admin.class)
                .addAnnotatedClass(User.class)
                .addAnnotatedClass(Books.class)
                .addAnnotatedClass(Branch.class)
                .addAnnotatedClass(Transaction.class)
                .addAnnotatedClass(TransactionDetail.class)
                .buildSessionFactory();
    }

    public static SessionFactoryConfig getInstance(){
        return factoryConfig==null
                ?factoryConfig=new SessionFactoryConfig()
                :factoryConfig;
    }

    public Session getSession(){
        return sessionFactory.openSession();
    }
}