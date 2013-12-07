<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 22.09.13
  Time: 14:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<h1>Message name: ${name}</h1>
<h1>Message  lol: ${lol}</h1>
<h1>Message lol2: ${lol2}</h1>
<h1>Message lol3: ${lol3}</h1>
<h1>Client:  ${client}</h1>

<form action="/welcome/form" method="post">
    <br>Lol:<input type="text" name="testForm"/>
  <%--  <br>Lol2:<input type="text" name="lol2"/>
    <br>Lol3:<input type="text" name="lol3"/>--%>
    <br><input type="submit" name="Go" />

</form>

</body>
</html>