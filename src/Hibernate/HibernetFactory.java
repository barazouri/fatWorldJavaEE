package Hibernate;

import Entities.User;
import java.util.Properties;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernetFactory {
    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() throws HibernateException {
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration();
                Properties settings = new Properties();
                settings.put("hibernate.connection.driver_class", "com.mysql.cj.jdbc.Driver");
                settings.put("hibernate.connection.url", "jdbc:mysql://SG-fatworld-1971-master.servers.mongodirector.com:3306/fat_world?characterEncoding=latin1");
//                settings.put("hibernate.connection.url", "jdbc:mysql://localhost:3306/fat_world?characterEncoding=latin1");       //this is for local host
//                settings.put("hibernate.connection.username", "bar");       // this is for local host
//                settings.put("hibernate.connection.password", "bar");       // this is for local host
                settings.put("hibernate.connection.username", "sgroot");    //this is for DB in cloud
                settings.put("hibernate.connection.password", "HNAgsl5yW4zyx#SG");      //this is for DB in cloud
                settings.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
                settings.put("hibernate.show_sql", "true");
                settings.put("hibernate.current_session_context_class", "thread");
                settings.put("hibernate.hbm2ddl.auto", "update");
                configuration.setProperties(settings);
                configuration.addAnnotatedClass(User.class);
                ServiceRegistry serviceRegistry = (new StandardServiceRegistryBuilder()).applySettings(configuration.getProperties()).build();
                sessionFactory = configuration.buildSessionFactory(serviceRegistry);
                System.out.println("Hibernate Java Config serviceRegistry created");
                return sessionFactory;
            } catch (HibernateException ex) {
                ex.printStackTrace();
                throw new HibernateException(ex.getMessage());
            }
        } else {
            return sessionFactory;
        }
    }

}
//mySql cloud site ->  https://console.scalegrid.io/MySQLClusters/1971/clusterDetails
//1234Qwer@@