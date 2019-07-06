<%@page import="Dao.Impl.Person_MySQL_DAO"%>
<%@page import="Model.Person"%>
<%@page import="Util.DB_Connection_JDBC_MySQL"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.util.Iterator"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>

<div><h1>Phone Book</h1></div>

<div>
    <table>
        <thead>
        <tr>
            <th>Id</th>
            <th>Name</th>
            <th>Number</th>
            <th>Address</th>
            <th>Date</th>
        </tr>
        </thead>
        <tbody>
        <%
        try {
        Connection connection = DB_Connection_JDBC_MySQL.getConnection();
        Person_MySQL_DAO entity = new Person_MySQL_DAO(connection);
        Iterator itr = entity.readAll().iterator();
            while (itr.hasNext()) {
        Person person = (Person) itr.next();
            %>
            <tr>
                <td><%=person.getId()%></td>
                <td><%=person.getName()%></td>
                <td><%=person.getNumber()==0?"":person.getNumber()%></td>
                <td><%=person.getAddress()%></td>
                <td><%=person.getDate()%></td>
                <td>
                    <button type="button">
                        <a href='EditPerson.jsp?id=<%=person.getId()%>'> Edit</a>
                    </button>
                    <button type="button">
                        <a href="/deleteperson?id=<%=person.getId()%>"> Delete</a>
                    </button>
                </td>
            </tr>
            <%
            }
            connection.close();
            } catch (SQLException e) {
            e.printStackTrace();
            }
            %>
        </tbody>
    </table>
</div>

<div><a href="AddPerson.jsp"><h3>Add Person</h3></a></div>

</html>