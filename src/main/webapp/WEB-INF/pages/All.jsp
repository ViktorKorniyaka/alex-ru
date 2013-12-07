<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 12.08.13
  Time: 18:14
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


<meta charset="utf-8">
<title>Таблица</title>
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



<%--<table style=" border-style: solid; border-width:1px; width: 350px; border-collapse: collapse;">
    <thead>
    <tr style="background-color: gray;">
        <td style="width: 30px;">id</td>
        <td style="width: 80px;">name</td>
        <td style="width: 80px;">role</td>
        <td style="width: 80px;">telephone</td>
        <td style="width: 80px;">action</td>
        <td style="width: 80px;">action</td>
    </tr>
    </thead>
  //------------------------------------------------------------%>


  <%--  <c:forEach var="user" items="${usls}">
            <tr>
              <td>${user}</td>
               <td><c:out value="${user.clientName}" /></td>
                <td><c:out value="${user.clientTelephone}" /></td>
               <td></td>
               <td><c:out value="${user.role}" /></td>
               <td><a href="./kill-user.html?id=${theUser.id}">delete</a></td>
               <td><a href="./edit-user.html?id=${theUser.id}">edit</a></td>
            </tr>
        </c:forEach>--%>

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


    <br>
    <table>
        <tr>
            <td>.1..</td>
            <td>.2..</td>
            <td>.3..</td>
        </tr>
    </table>



    <c:forEach items="${ls}" var="ooo">
    <br> ${ooo} <br>
    </c:forEach>

    <br> UserId: ${userId}   <br>
    <br>  nameUser: ${nameUser}   <br>
    <br>  LogonLogin: ${loginLogin}     <br>

</body>
</html>