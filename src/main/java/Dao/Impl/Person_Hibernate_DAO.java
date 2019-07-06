package Dao.Impl;

import Dao.DAO_CRUD;
import Model.Person_Hibernate;
import Util.DB_Connector_Hibernate_MySQL;
import org.hibernate.Session;

import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

public class Person_Hibernate_DAO implements DAO_CRUD<Person_Hibernate, Integer> {

    @Override
    public void create(Person_Hibernate person) {
        Session session = null;
        try {
            session = DB_Connector_Hibernate_MySQL.getSessionFactory().openSession(); // открываем сессию
            session.beginTransaction(); // открываем транзацкию
            session.save(person);   // сохраняем в сессию объект TODO (здесь наверно sql запрос метода create)
            session.getTransaction().commit(); // заканчиваем действие
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if ((session != null) && session.isOpen()) {    // если сессия открыта
                session.close();   // закрываем
            }
        }
    }

    @Override
    public void delete(Person_Hibernate person) {
        Session session = null;
        try {
            session = DB_Connector_Hibernate_MySQL.getSessionFactory().openSession(); // открываем сессию
            session.beginTransaction(); // открываем транзацкию
            session.delete(person);   // сохраняем в сессию объект TODO (здесь наверно sql запрос метода delete)
            session.getTransaction().commit(); // заканчиваем действие
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if ((session != null) && session.isOpen()) {    // если сессия открыта
                session.close();   // закрываем
            }
        }
    }

    @Override
    public Person_Hibernate readById(Integer id) {
        Person_Hibernate personResult = null;

        Session session = null;
        try {
            session = DB_Connector_Hibernate_MySQL.getSessionFactory().openSession(); // открываем сессию

//            personResult = session.load(Person_Hibernate.class, id);  // аналогичный метод get, но если у load закрыть сессию до return, то будет LazyInitializationException
            personResult = session.get(Person_Hibernate.class, id); // вытаскиваем с сессии объект TODO (здесь наверно sql запрос)

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if ((session != null) && session.isOpen()) {    // если сессия открыта
                session.close();   // закрываем
            }
        }

        return personResult;
    }

    @Override
    public List<Person_Hibernate> readAll() {
        List<Person_Hibernate> personsResult = null;

        Session session = null;
        try {
            session = DB_Connector_Hibernate_MySQL.getSessionFactory().openSession(); // открываем сессию

//            personsResult = session.createCriteria(Person_Hibernate.class).list();    // устаревший вариант

            CriteriaQuery<Person_Hibernate> criteriaQuery = session.getCriteriaBuilder().createQuery(Person_Hibernate.class);
            criteriaQuery.from(Person_Hibernate.class);
            personsResult = session.createQuery(criteriaQuery).getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if ((session != null) && session.isOpen()) {    // если сессия открыта
                session.close();   // закрываем
            }
        }

        return personsResult;
    }

    @Override
    public void update(Person_Hibernate person) {
        Session session = null;
        try {
            session = DB_Connector_Hibernate_MySQL.getSessionFactory().openSession(); // открываем сессию
            session.beginTransaction(); // открываем транзацкию
            session.update(person);   // сохраняем в сессию объект TODO (здесь наверно sql запрос метода update)
            session.getTransaction().commit(); // заканчиваем действие
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if ((session != null) && session.isOpen()) {    // если сессия открыта
                session.close();   // закрываем
            }
        }
    }
}
