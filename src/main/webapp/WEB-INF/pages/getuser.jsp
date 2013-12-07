<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 01.08.13
  Time: 18:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title></title>
</head>
<body>

UserName is: <h1>${userName}</h1>
Email is:    <h1>${email} </h1>
Login is:    <h1>${login}</h1>

<jsp:directive.include file="clients.jsp" />

<h1>------------ Список клиентов ------------ </h1>
<style>
    table {
        width: 50%; /* Ширина таблицы */
        border-collapse: collapse; /* Убираем двойные линии между ячейками */
    }
    td, th {
        padding: 3px; /* Поля вокруг содержимого таблицы */
        border: 1px solid #000; /* Параметры рамки */
    }
    th {
        background: #afd792; /* Цвет фона */
        color: #333;  /* Цвет текста */
    }
    tbody tr:hover {
        background: #f3bd48; /* Цвет фона при наведении */
        color: #fff; /* Цвет текста при наведении */
    }
</style>

<table style=" border-style: solid; border-width:1px; width: 350px; border-collapse: collapse;">
    <thead>

    </thead>

    <table>
        <tr style="background-color: gray;">
            <td style=>Name</td>
            <td style=>Name</td>
            <td style=>Telephone</td>
        </tr>

        <c:forEach items="${usId}" var="cl">
            <tr>
                <td> <a href="clients.jsp">${cl.clientName}</a>  </td>
                <td><c:out value= " ${cl.clientName}"/> </td>
                <td><c:out value= " ${cl.clientTelephone}"/>  </td>
            </tr>

        </c:forEach>
    </table>

<%--показать список клиентов--%>


<%--<form action="/get" method="post">

    <br>ID:<input type="text" name="id"/>

    <br><input type="submit" name="Go" />
    <p><input type="button" name="press" value=" push me "></p>

</form>--%>

</body>
</html>