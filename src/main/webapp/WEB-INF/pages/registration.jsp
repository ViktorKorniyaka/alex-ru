<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<%--"/RegistrationServlet"--%>
<br><h3>Регистрация пользователя </h3><br>
<form action="/registration" method="post">

    <br>Login:<input type="text" name="login"/>
    <br>UserName:<input type="text" name="userName"/>
    <br>Password:<input type="password" name="password"/>
    <br>Email:<input type="text" name="email"/>

    <br><input type="submit" name="Go" />
    <p><input type="button" name="press" value=" push me "></p>

</form>

</body>
</html>