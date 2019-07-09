package Util;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DB_Connection_JDBC_MySQL { // TODO изменить наподобии хибернейт_коннект

    public static Connection getConnection() {
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream("src/resources/DB_Connection.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        Connection connection = null;
        try {
            connection = DriverManager.getConnection(properties.getProperty("url"), properties.getProperty("user"), properties.getProperty("password"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
