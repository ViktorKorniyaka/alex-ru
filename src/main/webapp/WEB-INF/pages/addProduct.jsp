<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 02.10.13
  Time: 13:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page session="true"%>
<html>
<head>
    <title></title>
</head>
<body>
------------Добавить Product для ${clientName}-------------
<%--<form action="/client/${clientName}/products/add" method="post">--%>
<form action="/client/${clientName}/products/add" method="post">         <%--// а если тут дать страничку куда надо перейте--%>

    <br>ProductName:<input type="text" name="productName"/>
    <br>ProductPrice:<input type="text" name="productPrice"/>
    <br>ProductCount:<input type="text" name="productCount"/>
    <br>DateBuy:<input type="datetime" name="dateBuy"/>
    <br>DateEnd:<input type="datetime" name="dateEnd"/>

    <time datetime="<ГГГГ-ММ-ДД>">текст</time>
    <time datetime="<ДД-ММ-ГГГГ>">текст</time>

    <br><input type="submit" name="Go" />
    <p><input type="button" name="press" value=" push me " ></p>

</form>
</body>
</html>