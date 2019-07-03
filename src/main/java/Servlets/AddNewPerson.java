package Servlets;

import Dao.Person_MySQL_DAO;
import Model.Person;
import Util.DB_Connection_JDBC_MySQL;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet("/addnewperson")
public class AddNewPerson extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String name = request.getParameter("name");
        String number = request.getParameter("number");
        String address = request.getParameter("address");
        String date = request.getParameter("date");

        if (!name.equals("") && !number.equals("") && !address.equals("") && !date.equals("")) {
            try (Connection connection = DB_Connection_JDBC_MySQL.getConnection()) {
                Person_MySQL_DAO entity = new Person_MySQL_DAO(connection);
                entity.create(new Person(name, Integer.valueOf(number), address, date));
                response.sendRedirect("index.jsp");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }else {
            response.sendRedirect("AddPerson.jsp");
        }
    }

}


