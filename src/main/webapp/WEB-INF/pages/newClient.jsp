<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 25.09.13
  Time: 19:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>

<br><h3>Регистрация клиента </h3><br>
<form action="/client/add" method="post">

    <br>Login:<input type="text" name="clientName"/>
    <br>ClientTelephone:<input type="text" name="clientTelephone"/>
    <br>Email:<input type="text" name="clientEmail"/>

    <br><input type="submit" name="Go" />
    <input type="button" name="bake" value=" Назад " button onclick='history.back()'> </p>

</form>

</body>
</html>