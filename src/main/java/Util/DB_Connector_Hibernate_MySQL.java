package Util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DB_Connector_Hibernate_MySQL {
    private static SessionFactory sessionFactory;

    static {
        try {
            sessionFactory = new Configuration().configure().buildSessionFactory();
        } catch (Throwable e) {
            System.err.println("Ошибка инициализации SessionFactory" + e);
            throw new ExceptionInInitializerError(e);
        }
    }

    private DB_Connector_Hibernate_MySQL() {
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
