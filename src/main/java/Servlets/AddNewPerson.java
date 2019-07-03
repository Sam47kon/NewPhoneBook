package Servlets;

import Dao.Person_MySQL_DAO;
import Model.Person;
import Util.DB_Connection_JDBC_MySQL;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/addnewperson")
public class AddNewPerson extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String a = request.getParameter("name");
        String b = request.getParameter("number");
        String c = request.getParameter("address");
        String d = request.getParameter("date");

        if (!a.equals("") && !b.equals("") && !c.equals("") && !d.equals("")) {
            Person_MySQL_DAO person_mySQL_dao = new Person_MySQL_DAO(DB_Connection_JDBC_MySQL.getConnection());
            person_mySQL_dao.create(new Person(a, Integer.valueOf(b), c, d));
            response.sendRedirect("index.jsp");
        }else {
            response.sendRedirect("AddPerson.jsp");
        }
    }

}


