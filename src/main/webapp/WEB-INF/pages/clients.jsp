<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 08.08.13
  Time: 17:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="true"%>
<html>
<head>
    <title></title>
</head>
<body>
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
            <td style=>Change</td>
            <td style=>Delete</td>
        </tr>

        <c:forEach items="${usId}" var="cl">
            <tr>
               <%-- <a href= "${message}" title="MyClient112">MyClient111</a>
                <td> <a href="/client/{clientName}">${cl.clientName}</a>  </td>--%>
                <td> <a href="/client/${cl.clientName}" title="ClientName">${cl.clientName}</a>  </td>
                <td><c:out value= " ${cl.clientName}"/> </td>
                <td><c:out value= " ${cl.clientTelephone}"/>  </td>
                <td> <a href="/client/${cl.clientName}/change" title="ClientName">change</a>  </td>
                <td> <a href="/client/${cl.clientName}/delete" title="ClientName">delete</a>  </td>
            </tr>

        </c:forEach>
    </table>
    <%--<br>--%><td> <a href="/client/add">AddClient</a>  </td>
    <a href="/user"><input type="button" value="Назад"></a>
</body>
</html>