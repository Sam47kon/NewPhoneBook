package Util;

import Dao.Impl.Person_Hibernate_DAO;

public class Factory_Hibernate {
    private static Factory_Hibernate instance = new Factory_Hibernate();
    private Person_Hibernate_DAO personDao;


    private Factory_Hibernate() {
    }

    public static Factory_Hibernate getInstance() {
        return Factory_Hibernate.instance;
    }

    public Person_Hibernate_DAO getPersonDao() {
        return personDao == null ? new Person_Hibernate_DAO() : personDao;
    }

}
