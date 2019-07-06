package Apps;

import Dao.Impl.Person_Hibernate_DAO;
import Model.Person_Hibernate;
import Util.Factory_Hibernate;

import java.util.List;

public class Main_Hibernate {

    private static Person_Hibernate person = new Person_Hibernate("name1", 81112224455L, "address1", "1995-10-10"); // id 3

    public static void main(String[] args) {

        Factory_Hibernate factory = Factory_Hibernate.getInstance();
        Person_Hibernate_DAO personDao = factory.getPersonDao();

        System.out.println("Чтение таблицы person...");
        System.out.println("Должен быть Sam: " + personDao.readById(1));
        System.out.println("Должен быть Alina: " + personDao.readById(2) + "\n");


        System.out.println("Создание person name1...");
        personDao.create(person);
        System.out.println("Должен быть name1: " + personDao.readById(3) + "\n");


        System.out.println("Изменение person name1 на NEWname1...");
        personDao.update(new Person_Hibernate(3, "NEW name1", 81112224455L, "NEW address1", "1995-10-10"));
        System.out.println("Должен быть NEWname1: " + personDao.readById(3) + "\n");

        System.out.println("Изменение person обратно...");
        personDao.update(person);
        System.out.println("Должен быть name1: " + personDao.readById(3) + "\n");


        System.out.println("Удаление person name1..." + "\n");
        personDao.delete(person);


        System.out.println("Вывод всех person's, должно быть только 2");
        List<Person_Hibernate> list = personDao.readAll();
        list.forEach(System.out::println);
    }
}
