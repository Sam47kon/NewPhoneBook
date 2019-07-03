<!DOCTYPE html>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html xmlns="http://www.w3.org/1999/html">

<div>
    <div>
        <a href="index.jsp"> Вернутся в таблицу</a>
    </div>
<div>
<a href="/index"> Идти в таблицу через сервлет</a>
</div>
    <form action="/addnewperson" method="post">
        <div>
            <label for="myname">Name </label>
            <input type="text" id="myname" name="name" placeholder="Enter name...">
        </div>
        <div>
            <label for="mynumber">Number </label>
            <input type="tel" id="mynumber" name="number" placeholder="Enter number...">
        </div>
        <div>
            <label for="myaddress">Address </label>
            <input id="myaddress" name="address" placeholder="Enter address...">
        </div>
        <div>
            <label for="mydate">Date </label>
            <input type="date" id="mydate" name="date" placeholder="Enter date...">
        </div>
        <button type="submit" name="submit" value="submit">Submit</a></button>
    </form>
</div>
</html>
