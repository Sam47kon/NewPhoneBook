package Util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DB_Connector_Hibernate_MySQL_v2 {
    private static final SessionFactory sessionFactory = buildSessionFactory();

    private DB_Connector_Hibernate_MySQL_v2() {
    }

    private static SessionFactory buildSessionFactory() {
        try {
            return new Configuration().configure("/config/hibernate.cfg.xml").buildSessionFactory(); // TODO спросить у Гриши
        } catch (Throwable e) {
            System.err.println("Ошибка инициализации SessionFactory" + e);
            throw new ExceptionInInitializerError(e);
        }

    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
