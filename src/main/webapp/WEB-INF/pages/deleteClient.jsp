<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 03.10.13
  Time: 10:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
Are you sure you want to delete ${clientName}
<form action="/client/${clientName}/delete" method="post">
        <br><input type="submit" name="delete"value=" delete ">
        <input type="submit" name="cancel" value=" cancel " button onclick='history.back()'>
</form>


</body>
</html>