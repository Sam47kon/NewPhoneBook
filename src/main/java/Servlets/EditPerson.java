package Servlets;

import Dao.Impl.Person_MySQL_DAO;
import Model.Person;
import Util.DB_Connection_JDBC_MySQL;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet("/editperson")
public class EditPerson extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String strId = request.getParameter("id");
        String name = request.getParameter("name");
        String strNumber = request.getParameter("number");
        long number = strNumber.equals("") ? 0 : Long.valueOf(strNumber);
        String address = request.getParameter("address");
        String date = request.getParameter("date");

        try (Connection connection = DB_Connection_JDBC_MySQL.getConnection()) {
            Person_MySQL_DAO entity = new Person_MySQL_DAO(connection);
            entity.update(new Person(Integer.parseInt(strId), name, number, address, date));
        } catch (SQLException e) {
            e.printStackTrace();
        }

        response.sendRedirect("index.jsp");
    }
}
