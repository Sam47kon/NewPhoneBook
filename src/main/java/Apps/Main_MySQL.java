package Apps;

import Dao.Impl.Person_MySQL_DAO;
import Model.Person;
import Util.DB_Connection_JDBC_MySQL;

import java.sql.Connection;
import java.sql.SQLException;

public class Main_MySQL {

    public static void main(String[] args) {
        //        getPersons();
    }

    private static void getPersons() {
        try {
            Connection connection = DB_Connection_JDBC_MySQL.getConnection();
            Person_MySQL_DAO entity = new Person_MySQL_DAO(connection);
            for (Person person : entity.readAll()) {
                System.out.println(person);
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
