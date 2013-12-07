<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 04.08.13
  Time: 16:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<html>
<head>
    <title></title>
    <style>
        a {
            text-decoration: none; /* Отменяем подчеркивание у ссылки */
        }
    </style>
</head>
<body>

<form action="/enter" method="post">

    <br>Login:<input type="text" name="login"/>
    <br>Password:<input type="password" name="password"/>

    <br><input type="submit" name="Go" />

</form>


<br> <a href="registration.jsp">Регистрация</a>  <br>


</body>
</html>