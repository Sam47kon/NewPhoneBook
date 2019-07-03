package Apps;

import Dao.Person_MySQL_DAO;
import Model.Person;
import Util.DB_Connection_JDBC_MySQL;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        try {
            Connection connection = DB_Connection_JDBC_MySQL.getConnection();
            Person_MySQL_DAO entity = new Person_MySQL_DAO(connection);
            Iterator<Person> itr = entity.readAll().iterator();
            while (itr.hasNext()) {
                Person person = itr.next();
                System.out.println(person);
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
