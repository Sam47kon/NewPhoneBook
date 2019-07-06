package Servlets;

import Dao.Impl.Person_MySQL_DAO;
import Util.DB_Connection_JDBC_MySQL;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet("/deleteperson")
public class DeletePerson extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        String parameter = req.getParameter("id");
        int id = Integer.parseInt(parameter);
        try (Connection connection = DB_Connection_JDBC_MySQL.getConnection()) {
            Person_MySQL_DAO person_mySQL_dao = new Person_MySQL_DAO(connection);
            person_mySQL_dao.deletePerson(id);
            resp.sendRedirect("index.jsp");
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }
}