<%@page import="Dao.Person_MySQL_DAO"%>
<%@page import="Model.Person"%>
<%@page import="Util.DB_Connection_JDBC_MySQL"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>

<%
int id = Integer.parseInt(request.getParameter("id"));
Connection connection = DB_Connection_JDBC_MySQL.getConnection();
Person_MySQL_DAO entity = new Person_MySQL_DAO(connection);
Person person = entity.readById(id);
%>

<div>
    <a href="index.jsp"> Вернутся в таблицу</a>
</div>
<div>
    <a href="/index"> Идти в таблицу через сервлет</a>
</div>
<div>
    <h1>Редактирование записи</h1>
</div>
<div>
    <form action="/editperson" method="post">
            <input type="hidden" name="id" value="<%=person.getId()%>">
        <div>
            <label for="myname">Name </label>
            <input type="text" id="myname" name="name" value="<%=person.getName()%>">
        </div>
        <div>
            <label for="mynumber">Number </label>
            <input type="tel" id="mynumber" name="number" value="<%=person.getNumber()%>">
        </div>
        <div>
            <label for="myaddress">Address </label>
            <input id="myaddress" name="address" value="<%=person.getAddress()%>">
        </div>
        <div>
            <label for="mydate">Date </label>
            <input type="date" id="mydate" name="date" value="<%=person.getDate()%>">
        </div>
        <div>
            <button type="submit">Submit</button>
        </div>
    </form>
</div>
</html>
